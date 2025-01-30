package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.engines.OldIESEngine;
import org.spongycastle.crypto.generators.DHKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.parsers.DHIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class IESCipher extends CipherSpi {
    private IESEngine engine;
    private AsymmetricKeyParameter key;
    private SecureRandom random;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int state = -1;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineSpec = null;
    private boolean dhaesMode = false;
    private AsymmetricKeyParameter otherKeyParameter = null;

    /* loaded from: classes3.dex */
    public static class IES extends IESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: classes3.dex */
    public static class IESwithAES extends IESCipher {
        public IESwithAES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new AESEngine())));
        }
    }

    /* loaded from: classes3.dex */
    public static class IESwithDESede extends IESCipher {
        public IESwithDESede() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new DESedeEngine())));
        }
    }

    /* loaded from: classes3.dex */
    public static class OldIES extends IESCipher {
        public OldIES() {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: classes3.dex */
    public static class OldIESwithAES extends OldIESwithCipher {
        public OldIESwithAES() {
            super(new AESEngine());
        }
    }

    /* loaded from: classes3.dex */
    public static class OldIESwithCipher extends IESCipher {
        public OldIESwithCipher(BlockCipher blockCipher) {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(blockCipher)));
        }
    }

    /* loaded from: classes3.dex */
    public static class OldIESwithDESede extends OldIESwithCipher {
        public OldIESwithDESede() {
            super(new DESedeEngine());
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.engine = iESEngine;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (i3 != 0) {
            this.buffer.write(bArr, i2, i3);
        }
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        IESWithCipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        DHParameters parameters = ((DHKeyParameters) this.key).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                int i4 = this.state;
                if (i4 != 1 && i4 != 3) {
                    this.engine.init(false, this.key, asymmetricKeyParameter, iESWithCipherParameters);
                    return this.engine.processBlock(byteArray, 0, byteArray.length);
                }
                this.engine.init(true, asymmetricKeyParameter, this.key, iESWithCipherParameters);
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e2) {
                throw new BadPaddingException(e2.getMessage());
            }
        }
        int i5 = this.state;
        if (i5 == 1 || i5 == 3) {
            DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
            dHKeyPairGenerator.init(new DHKeyGenerationParameters(this.random, parameters));
            try {
                this.engine.init(this.key, iESWithCipherParameters, new EphemeralKeyPairGenerator(dHKeyPairGenerator, new KeyEncoder() { // from class: org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher.1
                    @Override // org.spongycastle.crypto.KeyEncoder
                    public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter2) {
                        int bitLength = (((DHKeyParameters) asymmetricKeyParameter2).getParameters().getP().bitLength() + 7) / 8;
                        byte[] bArr2 = new byte[bitLength];
                        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters) asymmetricKeyParameter2).getY());
                        if (asUnsignedByteArray.length <= bitLength) {
                            System.arraycopy(asUnsignedByteArray, 0, bArr2, bitLength - asUnsignedByteArray.length, asUnsignedByteArray.length);
                            return bArr2;
                        }
                        throw new IllegalArgumentException("Senders's public key longer than expected.");
                    }
                }));
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e3) {
                throw new BadPaddingException(e3.getMessage());
            }
        } else if (i5 != 2 && i5 != 4) {
            throw new IllegalStateException("IESCipher not initialised");
        } else {
            try {
                IESEngine iESEngine = this.engine;
                AsymmetricKeyParameter asymmetricKeyParameter2 = this.key;
                iESEngine.init(asymmetricKeyParameter2, iESWithCipherParameters, new DHIESPublicKeyParser(((DHKeyParameters) asymmetricKeyParameter2).getParameters()));
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (InvalidCipherTextException e4) {
                throw new BadPaddingException(e4.getMessage());
            }
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        if (this.engine.getCipher() != null) {
            return this.engine.getCipher().getBlockSize();
        }
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        int size;
        if (this.key != null) {
            int macSize = this.engine.getMac().getMacSize();
            int bitLength = this.otherKeyParameter == null ? (((((DHKeyParameters) this.key).getParameters().getP().bitLength() + 7) * 2) / 8) + 1 : 0;
            if (this.engine.getCipher() != null) {
                int i3 = this.state;
                if (i3 == 1 || i3 == 3) {
                    i2 = this.engine.getCipher().getOutputSize(i2);
                } else if (i3 != 2 && i3 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                } else {
                    i2 = this.engine.getCipher().getOutputSize((i2 - macSize) - bitLength);
                }
            }
            int i4 = this.state;
            if (i4 == 1 || i4 == 3) {
                size = this.buffer.size() + macSize + bitLength;
            } else if (i4 != 2 && i4 != 4) {
                throw new IllegalStateException("IESCipher not initialised");
            } else {
                size = (this.buffer.size() - macSize) - bitLength;
            }
            return size + i2;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
                this.engineParam = createAlgorithmParameters;
                createAlgorithmParameters.init(this.engineSpec);
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.engineParam;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e2.toString());
            }
        } else {
            parameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i2, key, parameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NONE")) {
            this.dhaesMode = false;
        } else if (upperCase.equals("DHAES")) {
            this.dhaesMode = true;
        } else {
            throw new IllegalArgumentException("can't support mode " + str);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        this.buffer.write(bArr, i2, i3);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        this.buffer.write(bArr, i2, i3);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        if (algorithmParameterSpec == null) {
            this.engineSpec = IESUtil.guessParameterSpec(this.engine.getCipher());
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.engineSpec = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        if (i2 == 1 || i2 == 3) {
            if (key instanceof DHPublicKey) {
                this.key = DHUtil.generatePublicKeyParameter((PublicKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey = (IESKey) key;
                this.key = DHUtil.generatePublicKeyParameter(iESKey.getPublic());
                this.otherKeyParameter = DHUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            } else {
                throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
            }
        } else if (i2 != 2 && i2 != 4) {
            throw new InvalidKeyException("must be passed EC key");
        } else {
            if (key instanceof DHPrivateKey) {
                this.key = DHUtil.generatePrivateKeyParameter((PrivateKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key;
                this.otherKeyParameter = DHUtil.generatePublicKeyParameter(iESKey2.getPublic());
                this.key = DHUtil.generatePrivateKeyParameter(iESKey2.getPrivate());
            } else {
                throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
            }
        }
        this.random = secureRandom;
        this.state = i2;
        this.buffer.reset();
    }

    public IESCipher(OldIESEngine oldIESEngine) {
        this.engine = oldIESEngine;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i2, i3);
        System.arraycopy(engineDoFinal, 0, bArr2, i4, engineDoFinal.length);
        return engineDoFinal.length;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new IllegalArgumentException("can't handle supplied parameter spec");
        }
    }
}
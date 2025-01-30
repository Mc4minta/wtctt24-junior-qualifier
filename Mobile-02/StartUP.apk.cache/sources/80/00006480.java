package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.engines.OldIESEngine;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;

/* loaded from: classes3.dex */
public class CipherSpi extends javax.crypto.CipherSpi {
    private IESEngine cipher;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int state = -1;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineParams = null;
    private Class[] availableSpecs = {IESParameterSpec.class};

    /* loaded from: classes3.dex */
    public static class IES extends CipherSpi {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: classes3.dex */
    public static class OldIES extends CipherSpi {
        public OldIES() {
            super(new OldIESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public CipherSpi(IESEngine iESEngine) {
        this.cipher = iESEngine;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (i3 != 0) {
            this.buffer.write(bArr, i2, i3);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            return this.cipher.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e2) {
            throw new BadPaddingException(e2.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) {
        if (key instanceof IESKey) {
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPrivate() instanceof DHPrivateKey) {
                return ((DHPrivateKey) iESKey.getPrivate()).getX().bitLength();
            }
            if (iESKey.getPrivate() instanceof ECPrivateKey) {
                return ((ECPrivateKey) iESKey.getPrivate()).getD().bitLength();
            }
            throw new IllegalArgumentException("not an IE key!");
        }
        throw new IllegalArgumentException("must be passed IE key");
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetOutputSize(int i2) {
        int i3 = this.state;
        if (i3 == 1 || i3 == 3) {
            return this.buffer.size() + i2 + 20;
        }
        if (i3 != 2 && i3 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        return (this.buffer.size() + i2) - 20;
    }

    @Override // javax.crypto.CipherSpi
    protected AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineParams != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
                this.engineParam = createAlgorithmParameters;
                createAlgorithmParameters.init(this.engineParams);
            } catch (Exception e2) {
                throw new RuntimeException(e2.toString());
            }
        }
        return this.engineParam;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter generatePublicKeyParameter;
        AsymmetricKeyParameter generatePrivateKeyParameter;
        if (key instanceof IESKey) {
            if (algorithmParameterSpec == null && (i2 == 1 || i2 == 3)) {
                byte[] bArr = new byte[16];
                byte[] bArr2 = new byte[16];
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                secureRandom.nextBytes(bArr);
                secureRandom.nextBytes(bArr2);
                algorithmParameterSpec = new IESParameterSpec(bArr, bArr2, 128);
            } else if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPublic() instanceof DHPublicKey) {
                generatePublicKeyParameter = DHUtil.generatePublicKeyParameter(iESKey.getPublic());
                generatePrivateKeyParameter = DHUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            } else {
                generatePublicKeyParameter = ECUtil.generatePublicKeyParameter(iESKey.getPublic());
                generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            }
            IESParameterSpec iESParameterSpec = (IESParameterSpec) algorithmParameterSpec;
            this.engineParams = iESParameterSpec;
            IESParameters iESParameters = new IESParameters(iESParameterSpec.getDerivationV(), this.engineParams.getEncodingV(), this.engineParams.getMacKeySize());
            this.state = i2;
            this.buffer.reset();
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            System.out.println("eeek!");
                            return;
                        }
                    }
                }
                this.cipher.init(false, generatePrivateKeyParameter, generatePublicKeyParameter, iESParameters);
                return;
            }
            this.cipher.init(true, generatePrivateKeyParameter, generatePublicKeyParameter, iESParameters);
            return;
        }
        throw new InvalidKeyException("must be passed IES key");
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetMode(String str) {
        throw new IllegalArgumentException("can't support mode " + str);
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException(str + " unavailable with RSA.");
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        this.buffer.write(bArr, i2, i3);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        this.buffer.write(bArr, i2, i3);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalBlockSizeException, BadPaddingException {
        if (i3 != 0) {
            this.buffer.write(bArr, i2, i3);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            byte[] processBlock = this.cipher.processBlock(byteArray, 0, byteArray.length);
            System.arraycopy(processBlock, 0, bArr2, i4, processBlock.length);
            return processBlock.length;
        } catch (InvalidCipherTextException e2) {
            throw new BadPaddingException(e2.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i3 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i3 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i3]);
                    break;
                } catch (Exception unused) {
                    i3++;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.engineParam = algorithmParameters;
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (i2 == 1 || i2 == 3) {
            try {
                engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
                return;
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }
        throw new IllegalArgumentException("can't handle null parameter spec in IES");
    }
}
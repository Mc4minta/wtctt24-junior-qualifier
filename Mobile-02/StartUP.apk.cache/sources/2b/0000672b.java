package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;

/* loaded from: classes3.dex */
public class BaseStreamCipher extends BaseWrapCipher implements PBE {
    private Class[] availableSpecs;
    private StreamCipher cipher;
    private int digest;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseStreamCipher(StreamCipher streamCipher, int i2) {
        this(streamCipher, i2, -1, -1);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i2, int i3) {
        if (i3 != 0) {
            byte[] engineUpdate = engineUpdate(bArr, i2, i3);
            this.cipher.reset();
            return engineUpdate;
        }
        this.cipher.reset();
        return new byte[0];
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        return 0;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineGetOutputSize(int i2) {
        return i2;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected AlgorithmParameters engineGetParameters() {
        AlgorithmParameters algorithmParameters = this.engineParams;
        if (algorithmParameters != null || this.pbeSpec == null) {
            return algorithmParameters;
        }
        try {
            AlgorithmParameters createParametersInstance = createParametersInstance(this.pbeAlgorithm);
            createParametersInstance.init(this.pbeSpec);
            return createParametersInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        CipherParameters keyParameter;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (key instanceof SecretKey) {
            if (key instanceof PKCS12Key) {
                PKCS12Key pKCS12Key = (PKCS12Key) key;
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.pbeSpec = pBEParameterSpec;
                if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                    PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                    this.pbeSpec = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
                }
                parametersWithIV = PBE.Util.makePBEParameters(pKCS12Key.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
            } else {
                if (key instanceof BCPBEKey) {
                    BCPBEKey bCPBEKey = (BCPBEKey) key;
                    if (bCPBEKey.getOID() != null) {
                        this.pbeAlgorithm = bCPBEKey.getOID().getId();
                    } else {
                        this.pbeAlgorithm = bCPBEKey.getAlgorithm();
                    }
                    if (bCPBEKey.getParam() != null) {
                        keyParameter = bCPBEKey.getParam();
                        this.pbeSpec = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                    } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        CipherParameters makePBEParameters = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.cipher.getAlgorithmName());
                        this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                        keyParameter = makePBEParameters;
                    } else {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    if (bCPBEKey.getIvSize() != 0) {
                        this.ivParam = (ParametersWithIV) keyParameter;
                    }
                } else if (algorithmParameterSpec == null) {
                    if (this.digest <= 0) {
                        keyParameter = new KeyParameter(key.getEncoded());
                    } else {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                    ParametersWithIV parametersWithIV2 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                    this.ivParam = parametersWithIV2;
                    parametersWithIV = parametersWithIV2;
                } else {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                parametersWithIV = keyParameter;
            }
            if (this.ivLength != 0 && !(parametersWithIV instanceof ParametersWithIV)) {
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                if (i2 != 1 && i2 != 3) {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
                byte[] bArr = new byte[this.ivLength];
                secureRandom.nextBytes(bArr);
                ParametersWithIV parametersWithIV3 = new ParametersWithIV(parametersWithIV, bArr);
                this.ivParam = parametersWithIV3;
                parametersWithIV = parametersWithIV3;
            }
            try {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                throw new InvalidParameterException("unknown opmode " + i2 + " passed");
                            }
                        }
                    }
                    this.cipher.init(false, parametersWithIV);
                    return;
                }
                this.cipher.init(true, parametersWithIV);
                return;
            } catch (Exception e2) {
                throw new InvalidKeyException(e2.getMessage());
            }
        }
        throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineSetMode(String str) {
        if (str.equalsIgnoreCase("ECB")) {
            return;
        }
        throw new IllegalArgumentException("can't support mode " + str);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineSetPadding(String str) throws NoSuchPaddingException {
        if (str.equalsIgnoreCase("NoPadding")) {
            return;
        }
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        this.cipher.processBytes(bArr, i2, i3, bArr2, 0);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseStreamCipher(StreamCipher streamCipher, int i2, int i3, int i4) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.cipher = streamCipher;
        this.ivLength = i2;
        this.keySizeInBits = i3;
        this.digest = i4;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (i4 + i3 <= bArr2.length) {
            try {
                this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
                return i3;
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.getMessage());
            }
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (i4 + i3 <= bArr2.length) {
            if (i3 != 0) {
                this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
            }
            this.cipher.reset();
            return i3;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
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
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }
}
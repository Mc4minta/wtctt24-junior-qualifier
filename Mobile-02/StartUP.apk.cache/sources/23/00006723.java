package org.spongycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.RC2Parameters;
import org.spongycastle.crypto.params.RC5Parameters;
import org.spongycastle.jcajce.PBKDF1Key;
import org.spongycastle.jcajce.PBKDF1KeyWithParameters;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.RepeatedSecretKeySpec;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs;
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int digest;
    private BlockCipherProvider engineProvider;
    private boolean fixedIv;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String modeName;
    private boolean padded;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;
    private int scheme;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;
        private AEADBlockCipher cipher;

        static {
            Class lookup = BaseBlockCipher.lookup("javax.crypto.AEADBadTagException");
            if (lookup != null) {
                aeadBadTagConstructor = findExceptionConstructor(lookup);
            } else {
                aeadBadTagConstructor = null;
            }
        }

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(String.class);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] bArr, int i2) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i2);
            } catch (InvalidCipherTextException e2) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    BadPaddingException badPaddingException = null;
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(e2.getMessage());
                    } catch (Exception unused) {
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e2.getMessage());
            }
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i2) {
            return this.cipher.getOutputSize(i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i2) {
            return this.cipher.getUpdateOutputSize(i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
            return this.cipher.processByte(b2, bArr, i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
            return this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i2, int i3) {
            this.cipher.processAADBytes(bArr, i2, i3);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i2) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int i2);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i2);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException;

        int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException;

        void updateAAD(byte[] bArr, int i2, int i3);

        boolean wrapOnNoPadding();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(BlockCipher blockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CipherParameters adjustParameters(AlgorithmParameterSpec algorithmParameterSpec, CipherParameters cipherParameters) {
        ParametersWithSBox parametersWithSBox;
        if (cipherParameters instanceof ParametersWithIV) {
            CipherParameters parameters = ((ParametersWithIV) cipherParameters).getParameters();
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                ParametersWithIV parametersWithIV = new ParametersWithIV(parameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.ivParam = parametersWithIV;
                return parametersWithIV;
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                ParametersWithSBox parametersWithSBox2 = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec.getSbox());
                if (gOST28147ParameterSpec.getIV() == null || this.ivLength == 0) {
                    return parametersWithSBox2;
                }
                ParametersWithIV parametersWithIV2 = new ParametersWithIV(parameters, gOST28147ParameterSpec.getIV());
                this.ivParam = parametersWithIV2;
                return parametersWithIV2;
            } else {
                return cipherParameters;
            }
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            ParametersWithIV parametersWithIV3 = new ParametersWithIV(cipherParameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
            this.ivParam = parametersWithIV3;
            parametersWithSBox = parametersWithIV3;
        } else if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
            return cipherParameters;
        } else {
            GOST28147ParameterSpec gOST28147ParameterSpec2 = (GOST28147ParameterSpec) algorithmParameterSpec;
            ParametersWithSBox parametersWithSBox3 = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec2.getSbox());
            parametersWithSBox = parametersWithSBox3;
            if (gOST28147ParameterSpec2.getIV() != null) {
                parametersWithSBox = parametersWithSBox3;
                if (this.ivLength != 0) {
                    return new ParametersWithIV(parametersWithSBox3, gOST28147ParameterSpec2.getIV());
                }
            }
        }
        return parametersWithSBox;
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str) || "OCB".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class lookup(String str) {
        try {
            return BaseBlockCipher.class.getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i3);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int processBytes = i3 != 0 ? this.cipher.processBytes(bArr, i2, i3, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == engineGetOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
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
        return this.cipher.getOutputSize(i2);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    AlgorithmParameters createParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    this.engineParams = createParametersInstance;
                    createParametersInstance.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters createParametersInstance2 = createParametersInstance(algorithmName);
                    this.engineParams = createParametersInstance2;
                    createParametersInstance2.init(this.ivParam.getIV());
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            } else if (this.aeadParams != null) {
                try {
                    AlgorithmParameters createParametersInstance3 = createParametersInstance("GCM");
                    this.engineParams = createParametersInstance3;
                    createParametersInstance3.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v61, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v11, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v18, types: [org.spongycastle.crypto.params.RC5Parameters, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v21, types: [org.spongycastle.crypto.params.RC2Parameters, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25, types: [org.spongycastle.crypto.params.ParametersWithSBox, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v28, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v33, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v58 */
    /* JADX WARN: Type inference failed for: r5v59 */
    /* JADX WARN: Type inference failed for: r5v60 */
    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineInit(int i2, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters makePBEParameters;
        KeyParameter keyParameter;
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        CipherParameters cipherParameters;
        ?? r5 = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        this.aeadParams = null;
        if (key instanceof SecretKey) {
            if (algorithmParameterSpec == null && this.baseEngine.getAlgorithmName().startsWith("RC5-64")) {
                throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
            }
            int i3 = this.scheme;
            if (i3 != 2 && !(key instanceof PKCS12Key)) {
                if (key instanceof PBKDF1Key) {
                    PBKDF1Key pBKDF1Key = (PBKDF1Key) key;
                    if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                    }
                    if ((pBKDF1Key instanceof PBKDF1KeyWithParameters) && this.pbeSpec == null) {
                        PBKDF1KeyWithParameters pBKDF1KeyWithParameters = (PBKDF1KeyWithParameters) pBKDF1Key;
                        this.pbeSpec = new PBEParameterSpec(pBKDF1KeyWithParameters.getSalt(), pBKDF1KeyWithParameters.getIterationCount());
                    }
                    CipherParameters makePBEParameters2 = PBE.Util.makePBEParameters(pBKDF1Key.getEncoded(), 0, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
                    boolean z = makePBEParameters2 instanceof ParametersWithIV;
                    r5 = makePBEParameters2;
                    if (z) {
                        this.ivParam = (ParametersWithIV) makePBEParameters2;
                        r5 = makePBEParameters2;
                    }
                } else if (key instanceof BCPBEKey) {
                    BCPBEKey bCPBEKey = (BCPBEKey) key;
                    if (bCPBEKey.getOID() != null) {
                        this.pbeAlgorithm = bCPBEKey.getOID().getId();
                    } else {
                        this.pbeAlgorithm = bCPBEKey.getAlgorithm();
                    }
                    if (bCPBEKey.getParam() != null) {
                        cipherParameters = adjustParameters(algorithmParameterSpec, bCPBEKey.getParam());
                    } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                        cipherParameters = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.cipher.getUnderlyingCipher().getAlgorithmName());
                    } else {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    boolean z2 = cipherParameters instanceof ParametersWithIV;
                    r5 = cipherParameters;
                    if (z2) {
                        this.ivParam = (ParametersWithIV) cipherParameters;
                        r5 = cipherParameters;
                    }
                } else if (key instanceof PBEKey) {
                    PBEKey pBEKey = (PBEKey) key;
                    PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                    this.pbeSpec = pBEParameterSpec;
                    if ((pBEKey instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                        this.pbeSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                    }
                    CipherParameters makePBEParameters3 = PBE.Util.makePBEParameters(pBEKey.getEncoded(), this.scheme, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
                    boolean z3 = makePBEParameters3 instanceof ParametersWithIV;
                    r5 = makePBEParameters3;
                    if (z3) {
                        this.ivParam = (ParametersWithIV) makePBEParameters3;
                        r5 = makePBEParameters3;
                    }
                } else if (!(key instanceof RepeatedSecretKeySpec)) {
                    if (i3 != 0 && i3 != 4 && i3 != 1 && i3 != 5) {
                        r5 = new KeyParameter(key.getEncoded());
                    } else {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                }
            } else {
                try {
                    SecretKey secretKey = (SecretKey) key;
                    if (algorithmParameterSpec instanceof PBEParameterSpec) {
                        this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                    }
                    boolean z4 = secretKey instanceof PBEKey;
                    if (z4 && this.pbeSpec == null) {
                        PBEKey pBEKey2 = (PBEKey) secretKey;
                        this.pbeSpec = new PBEParameterSpec(pBEKey2.getSalt(), pBEKey2.getIterationCount());
                    }
                    if (this.pbeSpec == null && !z4) {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                    if (key instanceof BCPBEKey) {
                        BCPBEKey bCPBEKey2 = (BCPBEKey) key;
                        if (bCPBEKey2.getParam() != null) {
                            makePBEParameters = bCPBEKey2.getParam();
                        } else {
                            makePBEParameters = PBE.Util.makePBEParameters(secretKey.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
                        }
                    } else {
                        makePBEParameters = PBE.Util.makePBEParameters(secretKey.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
                    }
                    boolean z5 = makePBEParameters instanceof ParametersWithIV;
                    r5 = makePBEParameters;
                    if (z5) {
                        this.ivParam = (ParametersWithIV) makePBEParameters;
                        r5 = makePBEParameters;
                    }
                } catch (Exception unused) {
                    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
                }
            }
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                if (this.ivLength != 0) {
                    IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
                    if (ivParameterSpec.getIV().length != this.ivLength && !(this.cipher instanceof AEADGenericBlockCipher) && this.fixedIv) {
                        throw new InvalidAlgorithmParameterException("IV must be " + this.ivLength + " bytes long.");
                    }
                    if (r5 instanceof ParametersWithIV) {
                        parametersWithIV2 = new ParametersWithIV(((ParametersWithIV) r5).getParameters(), ivParameterSpec.getIV());
                    } else {
                        parametersWithIV2 = new ParametersWithIV(r5, ivParameterSpec.getIV());
                    }
                    r5 = parametersWithIV2;
                    this.ivParam = r5;
                } else {
                    String str = this.modeName;
                    if (str != null && str.equals("ECB")) {
                        throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
                    }
                }
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                r5 = new ParametersWithSBox(new KeyParameter(key.getEncoded()), gOST28147ParameterSpec.getSbox());
                if (gOST28147ParameterSpec.getIV() != null && this.ivLength != 0) {
                    if (r5 instanceof ParametersWithIV) {
                        parametersWithIV = new ParametersWithIV(((ParametersWithIV) r5).getParameters(), gOST28147ParameterSpec.getIV());
                    } else {
                        parametersWithIV = new ParametersWithIV(r5, gOST28147ParameterSpec.getIV());
                    }
                    this.ivParam = parametersWithIV;
                    r5 = parametersWithIV;
                }
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                r5 = new RC2Parameters(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                if (rC2ParameterSpec.getIV() != null && this.ivLength != 0) {
                    if (r5 instanceof ParametersWithIV) {
                        parametersWithIV = new ParametersWithIV(((ParametersWithIV) r5).getParameters(), rC2ParameterSpec.getIV());
                    } else {
                        parametersWithIV = new ParametersWithIV(r5, rC2ParameterSpec.getIV());
                    }
                    this.ivParam = parametersWithIV;
                    r5 = parametersWithIV;
                }
            } else if (algorithmParameterSpec instanceof RC5ParameterSpec) {
                RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec;
                r5 = new RC5Parameters(key.getEncoded(), rC5ParameterSpec.getRounds());
                if (this.baseEngine.getAlgorithmName().startsWith("RC5")) {
                    if (this.baseEngine.getAlgorithmName().equals("RC5-32")) {
                        if (rC5ParameterSpec.getWordSize() != 32) {
                            throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 32 not " + rC5ParameterSpec.getWordSize() + ".");
                        }
                    } else if (this.baseEngine.getAlgorithmName().equals("RC5-64") && rC5ParameterSpec.getWordSize() != 64) {
                        throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 64 not " + rC5ParameterSpec.getWordSize() + ".");
                    }
                    if (rC5ParameterSpec.getIV() != null && this.ivLength != 0) {
                        if (r5 instanceof ParametersWithIV) {
                            parametersWithIV = new ParametersWithIV(((ParametersWithIV) r5).getParameters(), rC5ParameterSpec.getIV());
                        } else {
                            parametersWithIV = new ParametersWithIV(r5, rC5ParameterSpec.getIV());
                        }
                        this.ivParam = parametersWithIV;
                        r5 = parametersWithIV;
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
                }
            } else {
                Class cls = gcmSpecClass;
                if (cls != null && cls.isInstance(algorithmParameterSpec)) {
                    if (!isAEADModeName(this.modeName) && !(this.cipher instanceof AEADGenericBlockCipher)) {
                        throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
                    }
                    try {
                        Method declaredMethod = cls.getDeclaredMethod("getTLen", new Class[0]);
                        Method declaredMethod2 = cls.getDeclaredMethod("getIV", new Class[0]);
                        if (r5 instanceof ParametersWithIV) {
                            keyParameter = (KeyParameter) ((ParametersWithIV) r5).getParameters();
                        } else {
                            keyParameter = (KeyParameter) r5;
                        }
                        AEADParameters aEADParameters = new AEADParameters(keyParameter, ((Integer) declaredMethod.invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) declaredMethod2.invoke(algorithmParameterSpec, new Object[0]));
                        this.aeadParams = aEADParameters;
                        r5 = aEADParameters;
                    } catch (Exception unused2) {
                        throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
                    }
                } else if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
            }
            ParametersWithRandom parametersWithRandom = r5;
            if (this.ivLength != 0) {
                boolean z6 = r5 instanceof ParametersWithIV;
                parametersWithRandom = r5;
                if (!z6) {
                    boolean z7 = r5 instanceof AEADParameters;
                    parametersWithRandom = r5;
                    if (!z7) {
                        SecureRandom secureRandom2 = secureRandom == null ? new SecureRandom() : secureRandom;
                        if (i2 != 1 && i2 != 3) {
                            parametersWithRandom = r5;
                            if (this.cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") < 0) {
                                throw new InvalidAlgorithmParameterException("no IV set when one expected");
                            }
                        } else {
                            byte[] bArr = new byte[this.ivLength];
                            secureRandom2.nextBytes(bArr);
                            ?? parametersWithIV3 = new ParametersWithIV(r5, bArr);
                            this.ivParam = parametersWithIV3;
                            parametersWithRandom = parametersWithIV3;
                        }
                    }
                }
            }
            if (secureRandom != null && this.padded) {
                parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
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
                    this.cipher.init(false, parametersWithRandom);
                    return;
                }
                this.cipher.init(true, parametersWithRandom);
                return;
            } catch (Exception e2) {
                throw new InvalidKeyException(e2.getMessage()) { // from class: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.1
                    @Override // java.lang.Throwable
                    public Throwable getCause() {
                        return e2;
                    }
                };
            }
        }
        throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        this.modeName = upperCase;
        if (upperCase.equals("ECB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new CBCBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher(new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else if (this.modeName.startsWith("CFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher2 = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher(new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
        } else if (this.modeName.startsWith("PGP")) {
            boolean equalsIgnoreCase = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, equalsIgnoreCase));
        } else if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("SIC")) {
            int blockSize = this.baseEngine.getBlockSize();
            this.ivLength = blockSize;
            if (blockSize >= 16) {
                this.fixedIv = false;
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.modeName.startsWith("CTR")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.fixedIv = false;
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GOFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GCFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CTS")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CCM")) {
            this.ivLength = 13;
            this.cipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OCB")) {
            if (this.engineProvider != null) {
                this.ivLength = 15;
                this.cipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.get()));
                return;
            }
            throw new NoSuchAlgorithmException("can't support mode " + str);
        } else if (this.modeName.startsWith("EAX")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("GCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        } else {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (this.cipher.wrapOnNoPadding()) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS")) {
            this.cipher = new BufferedGenericBlockCipher(new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (!isAEADModeName(this.modeName)) {
                if (!upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
                    if (upperCase.equals("ZEROBYTEPADDING")) {
                        this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
                        return;
                    } else if (!upperCase.equals("ISO10126PADDING") && !upperCase.equals("ISO10126-2PADDING")) {
                        if (!upperCase.equals("X9.23PADDING") && !upperCase.equals("X923PADDING")) {
                            if (!upperCase.equals("ISO7816-4PADDING") && !upperCase.equals("ISO9797-1PADDING")) {
                                if (upperCase.equals("TBCPADDING")) {
                                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
                                    return;
                                }
                                throw new NoSuchPaddingException("Padding " + str + " unknown.");
                            }
                            this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
                            return;
                        }
                        this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
                        return;
                    } else {
                        this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
                        return;
                    }
                }
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
                return;
            }
            throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i3);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i2, i3, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes != updateOutputSize) {
                byte[] bArr3 = new byte[processBytes];
                System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
                return bArr3;
            }
            return bArr2;
        }
        this.cipher.processBytes(bArr, i2, i3, null, 0);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineUpdateAAD(byte[] bArr, int i2, int i3) {
        this.cipher.updateAAD(bArr, i2, i3);
    }

    /* loaded from: classes3.dex */
    private static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] bArr, int i2) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i2);
            } catch (InvalidCipherTextException e2) {
                throw new BadPaddingException(e2.getMessage());
            }
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i2) {
            return this.cipher.getOutputSize(i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i2) {
            return this.cipher.getUpdateOutputSize(i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
            return this.cipher.processByte(b2, bArr, i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
            return this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i2, int i3) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineUpdateAAD(ByteBuffer byteBuffer) {
        engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int processBytes;
        if (engineGetOutputSize(i3) + i4 <= bArr2.length) {
            if (i3 != 0) {
                try {
                    processBytes = this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
                } catch (OutputLengthException e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                } catch (DataLengthException e3) {
                    throw new IllegalBlockSizeException(e3.getMessage());
                }
            } else {
                processBytes = 0;
            }
            return processBytes + this.cipher.doFinal(bArr2, i4 + processBytes);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (this.cipher.getUpdateOutputSize(i3) + i4 <= bArr2.length) {
            try {
                return this.cipher.processBytes(bArr, i2, i3, bArr2, i4);
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.toString());
            }
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(BlockCipher blockCipher, int i2, int i3, int i4, int i5) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.scheme = i2;
        this.digest = i3;
        this.keySizeInBits = i4;
        this.ivLength = i5;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        BlockCipher underlyingCipher = aEADBlockCipher.getUnderlyingCipher();
        this.baseEngine = underlyingCipher;
        this.ivLength = underlyingCipher.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i2) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.fixedIv = z;
        this.ivLength = i2;
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(BlockCipher blockCipher, int i2) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i2 / 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i2) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = i2 / 8;
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
                if (clsArr[i3] != null) {
                    try {
                        algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i3]);
                        break;
                    } catch (Exception unused) {
                        i3++;
                    }
                }
                i3++;
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
package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: classes3.dex */
public interface PBE {
    public static final int GOST3411 = 6;
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S1_UTF8 = 4;
    public static final int PKCS5S2 = 1;
    public static final int PKCS5S2_UTF8 = 5;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA256 = 4;
    public static final int TIGER = 3;

    /* loaded from: classes3.dex */
    public static class Util {
        private static byte[] convertPassword(int i2, PBEKeySpec pBEKeySpec) {
            if (i2 == 2) {
                return PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            }
            if (i2 != 5 && i2 != 4) {
                return PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            }
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(pBEKeySpec.getPassword());
        }

        private static PBEParametersGenerator makePBEGenerator(int i2, int i3) {
            if (i2 == 0 || i2 == 4) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 5) {
                            return new PKCS5S1ParametersGenerator(new MD2Digest());
                        }
                        throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
                    }
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                return new PKCS5S1ParametersGenerator(new MD5Digest());
            } else if (i2 == 1 || i2 == 5) {
                switch (i3) {
                    case 0:
                        return new PKCS5S2ParametersGenerator(new MD5Digest());
                    case 1:
                        return new PKCS5S2ParametersGenerator(new SHA1Digest());
                    case 2:
                        return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS5S2ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS5S2ParametersGenerator(new SHA256Digest());
                    case 5:
                        return new PKCS5S2ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS5S2ParametersGenerator(new GOST3411Digest());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
                }
            } else if (i2 == 2) {
                switch (i3) {
                    case 0:
                        return new PKCS12ParametersGenerator(new MD5Digest());
                    case 1:
                        return new PKCS12ParametersGenerator(new SHA1Digest());
                    case 2:
                        return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS12ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS12ParametersGenerator(new SHA256Digest());
                    case 5:
                        return new PKCS12ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS12ParametersGenerator(new GOST3411Digest());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            } else {
                return new OpenSSLPBEParametersGenerator();
            }
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof PBEParameterSpec)) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                PBEParametersGenerator makePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
                byte[] encoded = bCPBEKey.getEncoded();
                makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(bCPBEKey.getKeySize());
                for (int i2 = 0; i2 != encoded.length; i2++) {
                    encoded[i2] = 0;
                }
                return generateDerivedMacParameters;
            }
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(byte[] bArr, int i2, int i3, int i4, int i5, AlgorithmParameterSpec algorithmParameterSpec, String str) throws InvalidAlgorithmParameterException {
            CipherParameters generateDerivedParameters;
            if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof PBEParameterSpec)) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                PBEParametersGenerator makePBEGenerator = makePBEGenerator(i2, i3);
                makePBEGenerator.init(bArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                if (i5 != 0) {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i4, i5);
                } else {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i4);
                }
                if (str.startsWith("DES")) {
                    if (generateDerivedParameters instanceof ParametersWithIV) {
                        DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) generateDerivedParameters).getParameters()).getKey());
                    } else {
                        DESParameters.setOddParity(((KeyParameter) generateDerivedParameters).getKey());
                    }
                }
                for (int i6 = 0; i6 != bArr.length; i6++) {
                    bArr[i6] = 0;
                }
                return generateDerivedParameters;
            }
            throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i2, int i3, int i4) {
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i2, i3);
            byte[] convertPassword = convertPassword(i2, pBEKeySpec);
            makePBEGenerator.init(convertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(i4);
            for (int i5 = 0; i5 != convertPassword.length; i5++) {
                convertPassword[i5] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEMacParameters(SecretKey secretKey, int i2, int i3, int i4, PBEParameterSpec pBEParameterSpec) {
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i2, i3);
            byte[] encoded = secretKey.getEncoded();
            makePBEGenerator.init(secretKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(i4);
            for (int i5 = 0; i5 != encoded.length; i5++) {
                encoded[i5] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            CipherParameters generateDerivedParameters;
            if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof PBEParameterSpec)) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                PBEParametersGenerator makePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
                byte[] encoded = bCPBEKey.getEncoded();
                if (bCPBEKey.shouldTryWrongPKCS12()) {
                    encoded = new byte[2];
                }
                makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                if (bCPBEKey.getIvSize() != 0) {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize(), bCPBEKey.getIvSize());
                } else {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize());
                }
                if (str.startsWith("DES")) {
                    if (generateDerivedParameters instanceof ParametersWithIV) {
                        DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) generateDerivedParameters).getParameters()).getKey());
                    } else {
                        DESParameters.setOddParity(((KeyParameter) generateDerivedParameters).getKey());
                    }
                }
                for (int i2 = 0; i2 != encoded.length; i2++) {
                    encoded[i2] = 0;
                }
                return generateDerivedParameters;
            }
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i2, int i3, int i4, int i5) {
            CipherParameters generateDerivedParameters;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i2, i3);
            byte[] convertPassword = convertPassword(i2, pBEKeySpec);
            makePBEGenerator.init(convertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            if (i5 != 0) {
                generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i4, i5);
            } else {
                generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i4);
            }
            for (int i6 = 0; i6 != convertPassword.length; i6++) {
                convertPassword[i6] = 0;
            }
            return generateDerivedParameters;
        }
    }
}
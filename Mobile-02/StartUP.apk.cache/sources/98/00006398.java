package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import okhttp3.internal.ws.WebSocketProtocol;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.io.Streams;

/* loaded from: classes3.dex */
public class TlsUtils {
    public static final byte[] EMPTY_BYTES = new byte[0];
    public static final short[] EMPTY_SHORTS = new short[0];
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Integer EXT_signature_algorithms = Integers.valueOf(13);
    static final byte[] SSL_CLIENT = {67, 76, 78, 84};
    static final byte[] SSL_SERVER = {83, 82, 86, 82};
    static final byte[][] SSL3_CONST = genSSL3Const();

    public static byte[] PRF(TlsContext tlsContext, byte[] bArr, String str, byte[] bArr2, int i2) {
        if (!tlsContext.getServerVersion().isSSL()) {
            byte[] byteArray = Strings.toByteArray(str);
            byte[] concat = concat(byteArray, bArr2);
            int prfAlgorithm = tlsContext.getSecurityParameters().getPrfAlgorithm();
            if (prfAlgorithm == 0) {
                return PRF_legacy(bArr, byteArray, concat, i2);
            }
            byte[] bArr3 = new byte[i2];
            hmac_hash(createPRFHash(prfAlgorithm), bArr, concat, bArr3);
            return bArr3;
        }
        throw new IllegalStateException("No PRF available for SSLv3 session");
    }

    public static byte[] PRF_legacy(byte[] bArr, String str, byte[] bArr2, int i2) {
        byte[] byteArray = Strings.toByteArray(str);
        return PRF_legacy(bArr, byteArray, concat(byteArray, bArr2), i2);
    }

    public static void addSignatureAlgorithmsExtension(Hashtable hashtable, Vector vector) throws IOException {
        hashtable.put(EXT_signature_algorithms, createSignatureAlgorithmsExtension(vector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] calculateKeyBlock(TlsContext tlsContext, int i2) {
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        byte[] masterSecret = securityParameters.getMasterSecret();
        byte[] concat = concat(securityParameters.getServerRandom(), securityParameters.getClientRandom());
        if (isSSL(tlsContext)) {
            return calculateKeyBlock_SSL(masterSecret, concat, i2);
        }
        return PRF(tlsContext, masterSecret, ExporterLabel.key_expansion, concat, i2);
    }

    static byte[] calculateKeyBlock_SSL(byte[] bArr, byte[] bArr2, int i2) {
        Digest createHash = createHash((short) 1);
        Digest createHash2 = createHash((short) 2);
        int digestSize = createHash.getDigestSize();
        int digestSize2 = createHash2.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        byte[] bArr4 = new byte[i2 + digestSize];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            byte[] bArr5 = SSL3_CONST[i4];
            createHash2.update(bArr5, 0, bArr5.length);
            createHash2.update(bArr, 0, bArr.length);
            createHash2.update(bArr2, 0, bArr2.length);
            createHash2.doFinal(bArr3, 0);
            createHash.update(bArr, 0, bArr.length);
            createHash.update(bArr3, 0, digestSize2);
            createHash.doFinal(bArr4, i3);
            i3 += digestSize;
            i4++;
        }
        return Arrays.copyOfRange(bArr4, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] calculateMasterSecret(TlsContext tlsContext, byte[] bArr) {
        byte[] concat;
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        if (securityParameters.extendedMasterSecret) {
            concat = securityParameters.getSessionHash();
        } else {
            concat = concat(securityParameters.getClientRandom(), securityParameters.getServerRandom());
        }
        if (isSSL(tlsContext)) {
            return calculateMasterSecret_SSL(bArr, concat);
        }
        return PRF(tlsContext, bArr, securityParameters.extendedMasterSecret ? ExporterLabel.extended_master_secret : ExporterLabel.master_secret, concat, 48);
    }

    static byte[] calculateMasterSecret_SSL(byte[] bArr, byte[] bArr2) {
        Digest createHash = createHash((short) 1);
        Digest createHash2 = createHash((short) 2);
        int digestSize = createHash.getDigestSize();
        int digestSize2 = createHash2.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        byte[] bArr4 = new byte[digestSize * 3];
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            byte[] bArr5 = SSL3_CONST[i3];
            createHash2.update(bArr5, 0, bArr5.length);
            createHash2.update(bArr, 0, bArr.length);
            createHash2.update(bArr2, 0, bArr2.length);
            createHash2.doFinal(bArr3, 0);
            createHash.update(bArr, 0, bArr.length);
            createHash.update(bArr3, 0, digestSize2);
            createHash.doFinal(bArr4, i2);
            i2 += digestSize;
        }
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] calculateVerifyData(TlsContext tlsContext, String str, byte[] bArr) {
        if (isSSL(tlsContext)) {
            return bArr;
        }
        SecurityParameters securityParameters = tlsContext.getSecurityParameters();
        return PRF(tlsContext, securityParameters.getMasterSecret(), str, bArr, securityParameters.getVerifyDataLength());
    }

    public static void checkUint16(int i2) throws IOException {
        if (!isValidUint16(i2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint24(int i2) throws IOException {
        if (!isValidUint24(i2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint32(long j2) throws IOException {
        if (!isValidUint32(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint48(long j2) throws IOException {
        if (!isValidUint48(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint64(long j2) throws IOException {
        if (!isValidUint64(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint8(short s) throws IOException {
        if (!isValidUint8(s)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static Digest cloneHash(short s, Digest digest) {
        switch (s) {
            case 1:
                return new MD5Digest((MD5Digest) digest);
            case 2:
                return new SHA1Digest((SHA1Digest) digest);
            case 3:
                return new SHA224Digest((SHA224Digest) digest);
            case 4:
                return new SHA256Digest((SHA256Digest) digest);
            case 5:
                return new SHA384Digest((SHA384Digest) digest);
            case 6:
                return new SHA512Digest((SHA512Digest) digest);
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static Digest clonePRFHash(int i2, Digest digest) {
        if (i2 != 0) {
            return cloneHash(getHashAlgorithmForPRFAlgorithm(i2), digest);
        }
        return new CombinedHash((CombinedHash) digest);
    }

    static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static Digest createHash(short s) {
        switch (s) {
            case 1:
                return new MD5Digest();
            case 2:
                return new SHA1Digest();
            case 3:
                return new SHA224Digest();
            case 4:
                return new SHA256Digest();
            case 5:
                return new SHA384Digest();
            case 6:
                return new SHA512Digest();
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static Digest createPRFHash(int i2) {
        if (i2 != 0) {
            return createHash(getHashAlgorithmForPRFAlgorithm(i2));
        }
        return new CombinedHash();
    }

    public static byte[] createSignatureAlgorithmsExtension(Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encodeSupportedSignatureAlgorithms(vector, false, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static TlsSigner createTlsSigner(short s) {
        if (s != 1) {
            if (s != 2) {
                if (s == 64) {
                    return new TlsECDSASigner();
                }
                throw new IllegalArgumentException("'clientCertificateType' is not a type with signing capability");
            }
            return new TlsDSSSigner();
        }
        return new TlsRSASigner();
    }

    public static byte[] encodeOpaque8(byte[] bArr) throws IOException {
        checkUint8(bArr.length);
        return Arrays.prepend(bArr, (byte) bArr.length);
    }

    public static void encodeSupportedSignatureAlgorithms(Vector vector, boolean z, OutputStream outputStream) throws IOException {
        if (vector != null && vector.size() >= 1 && vector.size() < 32768) {
            int size = vector.size() * 2;
            checkUint16(size);
            writeUint16(size, outputStream);
            for (int i2 = 0; i2 < vector.size(); i2++) {
                SignatureAndHashAlgorithm signatureAndHashAlgorithm = (SignatureAndHashAlgorithm) vector.elementAt(i2);
                if (!z && signatureAndHashAlgorithm.getSignature() == 0) {
                    throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
                }
                signatureAndHashAlgorithm.encode(outputStream);
            }
            return;
        }
        throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
    }

    public static byte[] encodeUint16ArrayWithUint16Length(int[] iArr) throws IOException {
        byte[] bArr = new byte[(iArr.length * 2) + 2];
        writeUint16ArrayWithUint16Length(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] encodeUint8ArrayWithUint8Length(short[] sArr) throws IOException {
        byte[] bArr = new byte[sArr.length + 1];
        writeUint8ArrayWithUint8Length(sArr, bArr, 0);
        return bArr;
    }

    private static byte[][] genSSL3Const() {
        byte[][] bArr = new byte[10];
        int i2 = 0;
        while (i2 < 10) {
            int i3 = i2 + 1;
            byte[] bArr2 = new byte[i3];
            Arrays.fill(bArr2, (byte) (i2 + 65));
            bArr[i2] = bArr2;
            i2 = i3;
        }
        return bArr;
    }

    public static int getCipherType(int i2) throws IOException {
        int encryptionAlgorithm = getEncryptionAlgorithm(i2);
        switch (encryptionAlgorithm) {
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            case 13:
            case 14:
                return 1;
            case 10:
            case 11:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return 2;
            default:
                switch (encryptionAlgorithm) {
                    case 100:
                    case 101:
                        return 0;
                    case 102:
                        return 2;
                    default:
                        throw new TlsFatalAlert((short) 80);
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getClientCertificateType(Certificate certificate, Certificate certificate2) throws IOException {
        if (certificate.isEmpty()) {
            return (short) -1;
        }
        org.spongycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
        try {
            AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
            if (!createKey.isPrivate()) {
                if (createKey instanceof RSAKeyParameters) {
                    validateKeyUsage(certificateAt, 128);
                    return (short) 1;
                } else if (createKey instanceof DSAPublicKeyParameters) {
                    validateKeyUsage(certificateAt, 128);
                    return (short) 2;
                } else if (createKey instanceof ECPublicKeyParameters) {
                    validateKeyUsage(certificateAt, 128);
                    return (short) 64;
                } else {
                    throw new TlsFatalAlert((short) 43);
                }
            }
            throw new TlsFatalAlert((short) 80);
        } catch (Exception e2) {
            throw new TlsFatalAlert((short) 43, e2);
        }
    }

    public static Vector getDefaultDSSSignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 2));
    }

    public static Vector getDefaultECDSASignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 3));
    }

    public static Vector getDefaultRSASignatureAlgorithms() {
        return vectorOfOne(new SignatureAndHashAlgorithm((short) 2, (short) 1));
    }

    public static Vector getDefaultSupportedSignatureAlgorithms() {
        short[] sArr = {2, 3, 4, 5, 6};
        short[] sArr2 = {1, 2, 3};
        Vector vector = new Vector();
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                vector.addElement(new SignatureAndHashAlgorithm(sArr[i3], sArr2[i2]));
            }
        }
        return vector;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0058 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getEncryptionAlgorithm(int r6) throws java.io.IOException {
        /*
            r0 = 1
            r1 = 0
            if (r6 == r0) goto L67
            r0 = 2
            if (r6 == r0) goto L67
            r2 = 4
            if (r6 == r2) goto L66
            r2 = 5
            if (r6 == r2) goto L66
            r2 = 12
            r3 = 8
            r4 = 13
            r5 = 9
            switch(r6) {
                case 10: goto L64;
                case 13: goto L64;
                case 16: goto L64;
                case 19: goto L64;
                case 22: goto L64;
                case 24: goto L66;
                case 168: goto L61;
                case 169: goto L5e;
                case 170: goto L61;
                case 171: goto L5e;
                case 172: goto L61;
                case 173: goto L5e;
                case 174: goto L5d;
                case 175: goto L5c;
                case 176: goto L5b;
                case 177: goto L5b;
                case 178: goto L5d;
                case 179: goto L5c;
                case 180: goto L5b;
                case 181: goto L5b;
                case 182: goto L5d;
                case 183: goto L5c;
                case 184: goto L5b;
                case 185: goto L5b;
                case 186: goto L5a;
                case 187: goto L5a;
                case 188: goto L5a;
                case 189: goto L5a;
                case 190: goto L5a;
                case 192: goto L59;
                case 193: goto L59;
                case 194: goto L59;
                case 195: goto L59;
                case 196: goto L59;
                case 49153: goto L67;
                case 49154: goto L66;
                case 49155: goto L64;
                case 49156: goto L58;
                case 49157: goto L57;
                case 49158: goto L67;
                case 49159: goto L66;
                case 49160: goto L64;
                case 49161: goto L58;
                case 49162: goto L57;
                case 49163: goto L67;
                case 49164: goto L66;
                case 49165: goto L64;
                case 49166: goto L58;
                case 49167: goto L57;
                case 49168: goto L67;
                case 49169: goto L66;
                case 49170: goto L64;
                case 49171: goto L58;
                case 49172: goto L57;
                case 49174: goto L66;
                case 49178: goto L64;
                case 49179: goto L64;
                case 49180: goto L64;
                case 49181: goto L58;
                case 49182: goto L58;
                case 49183: goto L58;
                case 49184: goto L57;
                case 49185: goto L57;
                case 49186: goto L57;
                case 49187: goto L5d;
                case 49188: goto L5c;
                case 49189: goto L5d;
                case 49190: goto L5c;
                case 49191: goto L5d;
                case 49192: goto L5c;
                case 49193: goto L5d;
                case 49194: goto L5c;
                case 49195: goto L61;
                case 49196: goto L5e;
                case 49197: goto L61;
                case 49198: goto L5e;
                case 49199: goto L61;
                case 49200: goto L5e;
                case 49201: goto L61;
                case 49202: goto L5e;
                case 49203: goto L66;
                case 49204: goto L64;
                case 49205: goto L58;
                case 49206: goto L57;
                case 49207: goto L5d;
                case 49208: goto L5c;
                case 49209: goto L67;
                case 49210: goto L5b;
                case 49211: goto L5b;
                case 49266: goto L5a;
                case 49267: goto L56;
                case 49268: goto L5a;
                case 49269: goto L56;
                case 49270: goto L5a;
                case 49271: goto L56;
                case 49272: goto L5a;
                case 49273: goto L56;
                case 49274: goto L53;
                case 49275: goto L50;
                case 49276: goto L53;
                case 49277: goto L50;
                case 49278: goto L53;
                case 49279: goto L50;
                case 49280: goto L53;
                case 49281: goto L50;
                case 49282: goto L53;
                case 49283: goto L50;
                case 49286: goto L53;
                case 49287: goto L50;
                case 49288: goto L53;
                case 49289: goto L50;
                case 49290: goto L53;
                case 49291: goto L50;
                case 49292: goto L53;
                case 49293: goto L50;
                case 49294: goto L53;
                case 49295: goto L50;
                case 49296: goto L53;
                case 49297: goto L50;
                case 49298: goto L53;
                case 49299: goto L50;
                case 49300: goto L5a;
                case 49301: goto L56;
                case 49302: goto L5a;
                case 49303: goto L56;
                case 49304: goto L5a;
                case 49305: goto L56;
                case 49306: goto L5a;
                case 49307: goto L56;
                case 49308: goto L4d;
                case 49309: goto L4a;
                case 49310: goto L4d;
                case 49311: goto L4a;
                case 49312: goto L47;
                case 49313: goto L44;
                case 49314: goto L47;
                case 49315: goto L44;
                case 49316: goto L4d;
                case 49317: goto L4a;
                case 49318: goto L4d;
                case 49319: goto L4a;
                case 49320: goto L47;
                case 49321: goto L44;
                case 49322: goto L47;
                case 49323: goto L44;
                case 49324: goto L4d;
                case 49325: goto L4a;
                case 49326: goto L47;
                case 49327: goto L44;
                case 52243: goto L41;
                case 52244: goto L41;
                case 52245: goto L41;
                case 58384: goto L3e;
                case 58385: goto L3b;
                case 58386: goto L3e;
                case 58387: goto L3b;
                case 58388: goto L3e;
                case 58389: goto L3b;
                case 58390: goto L3e;
                case 58391: goto L3b;
                case 58392: goto L3e;
                case 58393: goto L3b;
                case 58394: goto L3e;
                case 58395: goto L3b;
                case 58396: goto L3e;
                case 58397: goto L3b;
                case 58398: goto L3e;
                case 58399: goto L3b;
                default: goto L18;
            }
        L18:
            switch(r6) {
                case 44: goto L67;
                case 45: goto L67;
                case 46: goto L67;
                case 47: goto L58;
                case 48: goto L58;
                case 49: goto L58;
                case 50: goto L58;
                case 51: goto L58;
                default: goto L1b;
            }
        L1b:
            switch(r6) {
                case 53: goto L57;
                case 54: goto L57;
                case 55: goto L57;
                case 56: goto L57;
                case 57: goto L57;
                default: goto L1e;
            }
        L1e:
            switch(r6) {
                case 59: goto L5b;
                case 60: goto L5d;
                case 61: goto L3a;
                case 62: goto L5d;
                case 63: goto L5d;
                case 64: goto L5d;
                case 65: goto L39;
                case 66: goto L39;
                case 67: goto L39;
                case 68: goto L39;
                case 69: goto L39;
                default: goto L21;
            }
        L21:
            switch(r6) {
                case 103: goto L5d;
                case 104: goto L3a;
                case 105: goto L3a;
                case 106: goto L3a;
                case 107: goto L3a;
                default: goto L24;
            }
        L24:
            switch(r6) {
                case 132: goto L38;
                case 133: goto L38;
                case 134: goto L38;
                case 135: goto L38;
                case 136: goto L38;
                default: goto L27;
            }
        L27:
            switch(r6) {
                case 138: goto L66;
                case 139: goto L64;
                case 140: goto L58;
                case 141: goto L57;
                case 142: goto L66;
                case 143: goto L64;
                case 144: goto L58;
                case 145: goto L57;
                case 146: goto L66;
                case 147: goto L64;
                case 148: goto L58;
                case 149: goto L57;
                case 150: goto L35;
                case 151: goto L35;
                case 152: goto L35;
                case 153: goto L35;
                case 154: goto L35;
                default: goto L2a;
            }
        L2a:
            switch(r6) {
                case 156: goto L61;
                case 157: goto L5e;
                case 158: goto L61;
                case 159: goto L5e;
                case 160: goto L61;
                case 161: goto L5e;
                case 162: goto L61;
                case 163: goto L5e;
                case 164: goto L61;
                case 165: goto L5e;
                default: goto L2d;
            }
        L2d:
            org.spongycastle.crypto.tls.TlsFatalAlert r6 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r0 = 80
            r6.<init>(r0)
            throw r6
        L35:
            r6 = 14
            return r6
        L38:
            return r4
        L39:
            return r2
        L3a:
            return r5
        L3b:
            r6 = 101(0x65, float:1.42E-43)
            return r6
        L3e:
            r6 = 100
            return r6
        L41:
            r6 = 102(0x66, float:1.43E-43)
            return r6
        L44:
            r6 = 18
            return r6
        L47:
            r6 = 16
            return r6
        L4a:
            r6 = 17
            return r6
        L4d:
            r6 = 15
            return r6
        L50:
            r6 = 20
            return r6
        L53:
            r6 = 19
            return r6
        L56:
            return r4
        L57:
            return r5
        L58:
            return r3
        L59:
            return r4
        L5a:
            return r2
        L5b:
            return r1
        L5c:
            return r5
        L5d:
            return r3
        L5e:
            r6 = 11
            return r6
        L61:
            r6 = 10
            return r6
        L64:
            r6 = 7
            return r6
        L66:
            return r0
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.getEncryptionAlgorithm(int):int");
    }

    public static byte[] getExtensionData(Hashtable hashtable, Integer num) {
        if (hashtable == null) {
            return null;
        }
        return (byte[]) hashtable.get(num);
    }

    public static short getHashAlgorithmForPRFAlgorithm(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return (short) 5;
                }
                throw new IllegalArgumentException("unknown PRFAlgorithm");
            }
            return (short) 4;
        }
        throw new IllegalArgumentException("legacy PRF not a valid algorithm");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getKeyExchangeAlgorithm(int r2) throws java.io.IOException {
        /*
            r0 = 1
            if (r2 == r0) goto L55
            r1 = 2
            if (r2 == r1) goto L55
            r1 = 4
            if (r2 == r1) goto L55
            r1 = 5
            if (r2 == r1) goto L55
            switch(r2) {
                case 10: goto L55;
                case 13: goto L53;
                case 16: goto L50;
                case 19: goto L4e;
                case 22: goto L4d;
                case 168: goto L4a;
                case 169: goto L4a;
                case 170: goto L47;
                case 171: goto L47;
                case 172: goto L44;
                case 173: goto L44;
                case 174: goto L4a;
                case 175: goto L4a;
                case 176: goto L4a;
                case 177: goto L4a;
                case 178: goto L47;
                case 179: goto L47;
                case 180: goto L47;
                case 181: goto L47;
                case 182: goto L44;
                case 183: goto L44;
                case 184: goto L44;
                case 185: goto L44;
                case 186: goto L55;
                case 187: goto L53;
                case 188: goto L50;
                case 189: goto L4e;
                case 190: goto L4d;
                case 192: goto L55;
                case 193: goto L53;
                case 194: goto L50;
                case 195: goto L4e;
                case 196: goto L4d;
                case 49153: goto L41;
                case 49154: goto L41;
                case 49155: goto L41;
                case 49156: goto L41;
                case 49157: goto L41;
                case 49158: goto L3e;
                case 49159: goto L3e;
                case 49160: goto L3e;
                case 49161: goto L3e;
                case 49162: goto L3e;
                case 49163: goto L3b;
                case 49164: goto L3b;
                case 49165: goto L3b;
                case 49166: goto L3b;
                case 49167: goto L3b;
                case 49168: goto L38;
                case 49169: goto L38;
                case 49170: goto L38;
                case 49171: goto L38;
                case 49172: goto L38;
                case 49178: goto L35;
                case 49179: goto L32;
                case 49180: goto L2f;
                case 49181: goto L35;
                case 49182: goto L32;
                case 49183: goto L2f;
                case 49184: goto L35;
                case 49185: goto L32;
                case 49186: goto L2f;
                case 49187: goto L3e;
                case 49188: goto L3e;
                case 49189: goto L41;
                case 49190: goto L41;
                case 49191: goto L38;
                case 49192: goto L38;
                case 49193: goto L3b;
                case 49194: goto L3b;
                case 49195: goto L3e;
                case 49196: goto L3e;
                case 49197: goto L41;
                case 49198: goto L41;
                case 49199: goto L38;
                case 49200: goto L38;
                case 49201: goto L3b;
                case 49202: goto L3b;
                case 49203: goto L2c;
                case 49204: goto L2c;
                case 49205: goto L2c;
                case 49206: goto L2c;
                case 49207: goto L2c;
                case 49208: goto L2c;
                case 49209: goto L2c;
                case 49210: goto L2c;
                case 49211: goto L2c;
                case 49266: goto L3e;
                case 49267: goto L3e;
                case 49268: goto L41;
                case 49269: goto L41;
                case 49270: goto L38;
                case 49271: goto L38;
                case 49272: goto L3b;
                case 49273: goto L3b;
                case 49274: goto L55;
                case 49275: goto L55;
                case 49276: goto L4d;
                case 49277: goto L4d;
                case 49278: goto L50;
                case 49279: goto L50;
                case 49280: goto L4e;
                case 49281: goto L4e;
                case 49282: goto L53;
                case 49283: goto L53;
                case 49286: goto L3e;
                case 49287: goto L3e;
                case 49288: goto L41;
                case 49289: goto L41;
                case 49290: goto L38;
                case 49291: goto L38;
                case 49292: goto L3b;
                case 49293: goto L3b;
                case 49294: goto L4a;
                case 49295: goto L4a;
                case 49296: goto L47;
                case 49297: goto L47;
                case 49298: goto L44;
                case 49299: goto L44;
                case 49300: goto L4a;
                case 49301: goto L4a;
                case 49302: goto L47;
                case 49303: goto L47;
                case 49304: goto L44;
                case 49305: goto L44;
                case 49306: goto L2c;
                case 49307: goto L2c;
                case 49308: goto L55;
                case 49309: goto L55;
                case 49310: goto L4d;
                case 49311: goto L4d;
                case 49312: goto L55;
                case 49313: goto L55;
                case 49314: goto L4d;
                case 49315: goto L4d;
                case 49316: goto L4a;
                case 49317: goto L4a;
                case 49318: goto L47;
                case 49319: goto L47;
                case 49320: goto L4a;
                case 49321: goto L4a;
                case 49322: goto L47;
                case 49323: goto L47;
                case 49324: goto L3e;
                case 49325: goto L3e;
                case 49326: goto L3e;
                case 49327: goto L3e;
                case 52243: goto L38;
                case 52244: goto L3e;
                case 52245: goto L4d;
                case 58384: goto L55;
                case 58385: goto L55;
                case 58386: goto L38;
                case 58387: goto L38;
                case 58388: goto L3e;
                case 58389: goto L3e;
                case 58390: goto L4a;
                case 58391: goto L4a;
                case 58392: goto L2c;
                case 58393: goto L2c;
                case 58394: goto L44;
                case 58395: goto L44;
                case 58396: goto L47;
                case 58397: goto L47;
                case 58398: goto L4d;
                case 58399: goto L4d;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 44: goto L4a;
                case 45: goto L47;
                case 46: goto L44;
                case 47: goto L55;
                case 48: goto L53;
                case 49: goto L50;
                case 50: goto L4e;
                case 51: goto L4d;
                default: goto L12;
            }
        L12:
            switch(r2) {
                case 53: goto L55;
                case 54: goto L53;
                case 55: goto L50;
                case 56: goto L4e;
                case 57: goto L4d;
                default: goto L15;
            }
        L15:
            switch(r2) {
                case 59: goto L55;
                case 60: goto L55;
                case 61: goto L55;
                case 62: goto L53;
                case 63: goto L50;
                case 64: goto L4e;
                case 65: goto L55;
                case 66: goto L53;
                case 67: goto L50;
                case 68: goto L4e;
                case 69: goto L4d;
                default: goto L18;
            }
        L18:
            switch(r2) {
                case 103: goto L4d;
                case 104: goto L53;
                case 105: goto L50;
                case 106: goto L4e;
                case 107: goto L4d;
                default: goto L1b;
            }
        L1b:
            switch(r2) {
                case 132: goto L55;
                case 133: goto L53;
                case 134: goto L50;
                case 135: goto L4e;
                case 136: goto L4d;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 138: goto L4a;
                case 139: goto L4a;
                case 140: goto L4a;
                case 141: goto L4a;
                case 142: goto L47;
                case 143: goto L47;
                case 144: goto L47;
                case 145: goto L47;
                case 146: goto L44;
                case 147: goto L44;
                case 148: goto L44;
                case 149: goto L44;
                case 150: goto L55;
                case 151: goto L53;
                case 152: goto L50;
                case 153: goto L4e;
                case 154: goto L4d;
                default: goto L21;
            }
        L21:
            switch(r2) {
                case 156: goto L55;
                case 157: goto L55;
                case 158: goto L4d;
                case 159: goto L4d;
                case 160: goto L50;
                case 161: goto L50;
                case 162: goto L4e;
                case 163: goto L4e;
                case 164: goto L53;
                case 165: goto L53;
                default: goto L24;
            }
        L24:
            org.spongycastle.crypto.tls.TlsFatalAlert r2 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r0 = 80
            r2.<init>(r0)
            throw r2
        L2c:
            r2 = 24
            return r2
        L2f:
            r2 = 22
            return r2
        L32:
            r2 = 23
            return r2
        L35:
            r2 = 21
            return r2
        L38:
            r2 = 19
            return r2
        L3b:
            r2 = 18
            return r2
        L3e:
            r2 = 17
            return r2
        L41:
            r2 = 16
            return r2
        L44:
            r2 = 15
            return r2
        L47:
            r2 = 14
            return r2
        L4a:
            r2 = 13
            return r2
        L4d:
            return r1
        L4e:
            r2 = 3
            return r2
        L50:
            r2 = 9
            return r2
        L53:
            r2 = 7
            return r2
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.getKeyExchangeAlgorithm(int):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getMACAlgorithm(int i2) throws IOException {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        switch (i2) {
                            case 10:
                            case 13:
                            case 16:
                            case 19:
                            case 22:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA /* 49153 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA /* 49154 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA /* 49155 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA /* 49156 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA /* 49157 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA /* 49158 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA /* 49159 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA /* 49160 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA /* 49161 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA /* 49162 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA /* 49163 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA /* 49164 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA /* 49165 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA /* 49166 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA /* 49167 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA /* 49168 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA /* 49169 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA /* 49170 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA /* 49171 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA /* 49172 */:
                            case CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA /* 49178 */:
                            case CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA /* 49179 */:
                            case CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA /* 49180 */:
                            case CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA /* 49181 */:
                            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA /* 49182 */:
                            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA /* 49183 */:
                            case CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA /* 49184 */:
                            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA /* 49185 */:
                            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA /* 49186 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_RC4_128_SHA /* 49203 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA /* 49204 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA /* 49205 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA /* 49206 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA /* 49209 */:
                            case CipherSuite.TLS_RSA_WITH_ESTREAM_SALSA20_SHA1 /* 58384 */:
                            case CipherSuite.TLS_RSA_WITH_SALSA20_SHA1 /* 58385 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_ESTREAM_SALSA20_SHA1 /* 58386 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_SALSA20_SHA1 /* 58387 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_ESTREAM_SALSA20_SHA1 /* 58388 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_SALSA20_SHA1 /* 58389 */:
                            case CipherSuite.TLS_PSK_WITH_ESTREAM_SALSA20_SHA1 /* 58390 */:
                            case CipherSuite.TLS_PSK_WITH_SALSA20_SHA1 /* 58391 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_ESTREAM_SALSA20_SHA1 /* 58392 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_SALSA20_SHA1 /* 58393 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_ESTREAM_SALSA20_SHA1 /* 58394 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_SALSA20_SHA1 /* 58395 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_ESTREAM_SALSA20_SHA1 /* 58396 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_SALSA20_SHA1 /* 58397 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_ESTREAM_SALSA20_SHA1 /* 58398 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_SALSA20_SHA1 /* 58399 */:
                                break;
                            case CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256 /* 168 */:
                            case CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384 /* 169 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 /* 170 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384 /* 171 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 /* 172 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384 /* 173 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 /* 49195 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 /* 49196 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 /* 49197 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 /* 49198 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 /* 49199 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 /* 49200 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 /* 49201 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 /* 49202 */:
                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49274 */:
                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49275 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49276 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49277 */:
                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49278 */:
                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49279 */:
                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_GCM_SHA256 /* 49280 */:
                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_GCM_SHA384 /* 49281 */:
                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_GCM_SHA256 /* 49282 */:
                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_GCM_SHA384 /* 49283 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49286 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49287 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49288 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49289 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49290 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49291 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49292 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49293 */:
                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49294 */:
                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49295 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49296 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49297 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49298 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49299 */:
                            case CipherSuite.TLS_RSA_WITH_AES_128_CCM /* 49308 */:
                            case CipherSuite.TLS_RSA_WITH_AES_256_CCM /* 49309 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_128_CCM /* 49310 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_CCM /* 49311 */:
                            case CipherSuite.TLS_RSA_WITH_AES_128_CCM_8 /* 49312 */:
                            case CipherSuite.TLS_RSA_WITH_AES_256_CCM_8 /* 49313 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_128_CCM_8 /* 49314 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_CCM_8 /* 49315 */:
                            case CipherSuite.TLS_PSK_WITH_AES_128_CCM /* 49316 */:
                            case CipherSuite.TLS_PSK_WITH_AES_256_CCM /* 49317 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CCM /* 49318 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CCM /* 49319 */:
                            case CipherSuite.TLS_PSK_WITH_AES_128_CCM_8 /* 49320 */:
                            case CipherSuite.TLS_PSK_WITH_AES_256_CCM_8 /* 49321 */:
                            case CipherSuite.TLS_PSK_DHE_WITH_AES_128_CCM_8 /* 49322 */:
                            case CipherSuite.TLS_PSK_DHE_WITH_AES_256_CCM_8 /* 49323 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CCM /* 49324 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CCM /* 49325 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8 /* 49326 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8 /* 49327 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 /* 52243 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 /* 52244 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 /* 52245 */:
                                return 0;
                            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256 /* 174 */:
                            case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /* 176 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256 /* 178 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 /* 180 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256 /* 182 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA256 /* 184 */:
                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 186 */:
                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256 /* 187 */:
                            case 188:
                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256 /* 189 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 190 */:
                            case 192:
                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 193 */:
                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 194 */:
                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 195 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 196 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 /* 49187 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 /* 49189 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 /* 49191 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 /* 49193 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256 /* 49207 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA256 /* 49210 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49266 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49268 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49270 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49272 */:
                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_128_CBC_SHA256 /* 49300 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_128_CBC_SHA256 /* 49302 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_128_CBC_SHA256 /* 49304 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_CAMELLIA_128_CBC_SHA256 /* 49306 */:
                                return 3;
                            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384 /* 175 */:
                            case CipherSuite.TLS_PSK_WITH_NULL_SHA384 /* 177 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 /* 179 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384 /* 181 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384 /* 183 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384 /* 185 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 /* 49188 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 /* 49190 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 /* 49192 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 /* 49194 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384 /* 49208 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_NULL_SHA384 /* 49211 */:
                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49267 */:
                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49269 */:
                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49271 */:
                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49273 */:
                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_256_CBC_SHA384 /* 49301 */:
                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_256_CBC_SHA384 /* 49303 */:
                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_256_CBC_SHA384 /* 49305 */:
                            case CipherSuite.TLS_ECDHE_PSK_WITH_CAMELLIA_256_CBC_SHA384 /* 49307 */:
                                return 4;
                            default:
                                switch (i2) {
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                        break;
                                    default:
                                        switch (i2) {
                                            case 53:
                                            case 54:
                                            case 55:
                                            case 56:
                                            case 57:
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 59:
                                                    case 60:
                                                    case 61:
                                                    case 62:
                                                    case 63:
                                                    case 64:
                                                        return 3;
                                                    case 65:
                                                    case 66:
                                                    case 67:
                                                    case 68:
                                                    case 69:
                                                        break;
                                                    default:
                                                        switch (i2) {
                                                            case 103:
                                                            case 104:
                                                            case 105:
                                                            case 106:
                                                            case 107:
                                                                return 3;
                                                            default:
                                                                switch (i2) {
                                                                    case CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA /* 132 */:
                                                                    case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA /* 133 */:
                                                                    case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA /* 134 */:
                                                                    case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA /* 135 */:
                                                                    case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA /* 136 */:
                                                                        break;
                                                                    default:
                                                                        switch (i2) {
                                                                            case CipherSuite.TLS_PSK_WITH_RC4_128_SHA /* 138 */:
                                                                            case CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA /* 139 */:
                                                                            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA /* 140 */:
                                                                            case CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA /* 141 */:
                                                                            case CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA /* 142 */:
                                                                            case CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA /* 143 */:
                                                                            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /* 144 */:
                                                                            case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA /* 145 */:
                                                                            case CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA /* 146 */:
                                                                            case CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA /* 147 */:
                                                                            case CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA /* 148 */:
                                                                            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA /* 149 */:
                                                                            case CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA /* 150 */:
                                                                            case CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA /* 151 */:
                                                                            case CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA /* 152 */:
                                                                            case CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA /* 153 */:
                                                                            case CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA /* 154 */:
                                                                                break;
                                                                            default:
                                                                                switch (i2) {
                                                                                    case CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 /* 156 */:
                                                                                    case CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 /* 157 */:
                                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 /* 158 */:
                                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /* 159 */:
                                                                                    case CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256 /* 160 */:
                                                                                    case CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384 /* 161 */:
                                                                                    case CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 /* 162 */:
                                                                                    case CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 /* 163 */:
                                                                                    case CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256 /* 164 */:
                                                                                    case CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384 /* 165 */:
                                                                                        return 0;
                                                                                    default:
                                                                                        throw new TlsFatalAlert((short) 80);
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                }
            }
            return 2;
        }
        return 1;
    }

    public static ProtocolVersion getMinimumVersion(int i2) {
        switch (i2) {
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                break;
            default:
                switch (i2) {
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                        break;
                    default:
                        switch (i2) {
                            case CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 /* 156 */:
                            case CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 /* 157 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 /* 158 */:
                            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /* 159 */:
                            case CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256 /* 160 */:
                            case CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384 /* 161 */:
                            case CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 /* 162 */:
                            case CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 /* 163 */:
                            case CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256 /* 164 */:
                            case CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384 /* 165 */:
                                break;
                            default:
                                switch (i2) {
                                    case CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256 /* 168 */:
                                    case CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384 /* 169 */:
                                    case CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 /* 170 */:
                                    case CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384 /* 171 */:
                                    case CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 /* 172 */:
                                    case CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384 /* 173 */:
                                        break;
                                    default:
                                        switch (i2) {
                                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 186 */:
                                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256 /* 187 */:
                                            case 188:
                                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256 /* 189 */:
                                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 190 */:
                                            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256 /* 191 */:
                                            case 192:
                                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 193 */:
                                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 194 */:
                                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 195 */:
                                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 196 */:
                                            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256 /* 197 */:
                                                break;
                                            default:
                                                switch (i2) {
                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 /* 49187 */:
                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 /* 49188 */:
                                                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 /* 49189 */:
                                                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 /* 49190 */:
                                                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 /* 49191 */:
                                                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 /* 49192 */:
                                                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 /* 49193 */:
                                                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 /* 49194 */:
                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 /* 49195 */:
                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 /* 49196 */:
                                                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 /* 49197 */:
                                                    case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 /* 49198 */:
                                                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 /* 49199 */:
                                                    case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 /* 49200 */:
                                                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 /* 49201 */:
                                                    case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 /* 49202 */:
                                                        break;
                                                    default:
                                                        switch (i2) {
                                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49266 */:
                                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49267 */:
                                                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49268 */:
                                                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49269 */:
                                                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49270 */:
                                                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49271 */:
                                                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_128_CBC_SHA256 /* 49272 */:
                                                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_256_CBC_SHA384 /* 49273 */:
                                                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49274 */:
                                                            case CipherSuite.TLS_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49275 */:
                                                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49276 */:
                                                            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49277 */:
                                                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49278 */:
                                                            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49279 */:
                                                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_GCM_SHA256 /* 49280 */:
                                                            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_GCM_SHA384 /* 49281 */:
                                                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_GCM_SHA256 /* 49282 */:
                                                            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_GCM_SHA384 /* 49283 */:
                                                            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_GCM_SHA256 /* 49284 */:
                                                            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_GCM_SHA384 /* 49285 */:
                                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49286 */:
                                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49287 */:
                                                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49288 */:
                                                            case CipherSuite.TLS_ECDH_ECDSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49289 */:
                                                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49290 */:
                                                            case CipherSuite.TLS_ECDHE_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49291 */:
                                                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_128_GCM_SHA256 /* 49292 */:
                                                            case CipherSuite.TLS_ECDH_RSA_WITH_CAMELLIA_256_GCM_SHA384 /* 49293 */:
                                                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49294 */:
                                                            case CipherSuite.TLS_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49295 */:
                                                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49296 */:
                                                            case CipherSuite.TLS_DHE_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49297 */:
                                                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_128_GCM_SHA256 /* 49298 */:
                                                            case CipherSuite.TLS_RSA_PSK_WITH_CAMELLIA_256_GCM_SHA384 /* 49299 */:
                                                                break;
                                                            default:
                                                                switch (i2) {
                                                                    case CipherSuite.TLS_RSA_WITH_AES_128_CCM /* 49308 */:
                                                                    case CipherSuite.TLS_RSA_WITH_AES_256_CCM /* 49309 */:
                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_128_CCM /* 49310 */:
                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_256_CCM /* 49311 */:
                                                                    case CipherSuite.TLS_RSA_WITH_AES_128_CCM_8 /* 49312 */:
                                                                    case CipherSuite.TLS_RSA_WITH_AES_256_CCM_8 /* 49313 */:
                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_128_CCM_8 /* 49314 */:
                                                                    case CipherSuite.TLS_DHE_RSA_WITH_AES_256_CCM_8 /* 49315 */:
                                                                    case CipherSuite.TLS_PSK_WITH_AES_128_CCM /* 49316 */:
                                                                    case CipherSuite.TLS_PSK_WITH_AES_256_CCM /* 49317 */:
                                                                    case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CCM /* 49318 */:
                                                                    case CipherSuite.TLS_DHE_PSK_WITH_AES_256_CCM /* 49319 */:
                                                                    case CipherSuite.TLS_PSK_WITH_AES_128_CCM_8 /* 49320 */:
                                                                    case CipherSuite.TLS_PSK_WITH_AES_256_CCM_8 /* 49321 */:
                                                                    case CipherSuite.TLS_PSK_DHE_WITH_AES_128_CCM_8 /* 49322 */:
                                                                    case CipherSuite.TLS_PSK_DHE_WITH_AES_256_CCM_8 /* 49323 */:
                                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CCM /* 49324 */:
                                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CCM /* 49325 */:
                                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8 /* 49326 */:
                                                                    case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8 /* 49327 */:
                                                                        break;
                                                                    default:
                                                                        switch (i2) {
                                                                            case CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 /* 52243 */:
                                                                            case CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 /* 52244 */:
                                                                            case CipherSuite.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 /* 52245 */:
                                                                                break;
                                                                            default:
                                                                                return ProtocolVersion.SSLv3;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return ProtocolVersion.TLSv12;
    }

    public static ASN1ObjectIdentifier getOIDForHashAlgorithm(short s) {
        switch (s) {
            case 1:
                return PKCSObjectIdentifiers.md5;
            case 2:
                return X509ObjectIdentifiers.id_SHA1;
            case 3:
                return NISTObjectIdentifiers.id_sha224;
            case 4:
                return NISTObjectIdentifiers.id_sha256;
            case 5:
                return NISTObjectIdentifiers.id_sha384;
            case 6:
                return NISTObjectIdentifiers.id_sha512;
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    public static Vector getSignatureAlgorithmsExtension(Hashtable hashtable) throws IOException {
        byte[] extensionData = getExtensionData(hashtable, EXT_signature_algorithms);
        if (extensionData == null) {
            return null;
        }
        return readSignatureAlgorithmsExtension(extensionData);
    }

    public static SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(TlsContext tlsContext, TlsSignerCredentials tlsSignerCredentials) throws IOException {
        if (isTLSv12(tlsContext)) {
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = tlsSignerCredentials.getSignatureAndHashAlgorithm();
            if (signatureAndHashAlgorithm != null) {
                return signatureAndHashAlgorithm;
            }
            throw new TlsFatalAlert((short) 80);
        }
        return null;
    }

    public static boolean hasExpectedEmptyExtensionData(Hashtable hashtable, Integer num, short s) throws IOException {
        byte[] extensionData = getExtensionData(hashtable, num);
        if (extensionData == null) {
            return false;
        }
        if (extensionData.length == 0) {
            return true;
        }
        throw new TlsFatalAlert(s);
    }

    public static boolean hasSigningCapability(short s) {
        return s == 1 || s == 2 || s == 64;
    }

    static void hmac_hash(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMac hMac = new HMac(digest);
        hMac.init(new KeyParameter(bArr));
        int digestSize = digest.getDigestSize();
        int length = ((bArr3.length + digestSize) - 1) / digestSize;
        int macSize = hMac.getMacSize();
        byte[] bArr4 = new byte[macSize];
        byte[] bArr5 = new byte[hMac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i2 = 0;
        while (i2 < length) {
            hMac.update(bArr6, 0, bArr6.length);
            hMac.doFinal(bArr4, 0);
            hMac.update(bArr4, 0, macSize);
            hMac.update(bArr2, 0, bArr2.length);
            hMac.doFinal(bArr5, 0);
            int i3 = digestSize * i2;
            System.arraycopy(bArr5, 0, bArr3, i3, Math.min(digestSize, bArr3.length - i3));
            i2++;
            bArr6 = bArr4;
        }
    }

    public static TlsSession importSession(byte[] bArr, SessionParameters sessionParameters) {
        return new TlsSessionImpl(bArr, sessionParameters);
    }

    public static boolean isAEADCipherSuite(int i2) throws IOException {
        return 2 == getCipherType(i2);
    }

    public static boolean isBlockCipherSuite(int i2) throws IOException {
        return 1 == getCipherType(i2);
    }

    public static boolean isSSL(TlsContext tlsContext) {
        return tlsContext.getServerVersion().isSSL();
    }

    public static boolean isSignatureAlgorithmsExtensionAllowed(ProtocolVersion protocolVersion) {
        return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(protocolVersion.getEquivalentTLSVersion());
    }

    public static boolean isStreamCipherSuite(int i2) throws IOException {
        return getCipherType(i2) == 0;
    }

    public static boolean isTLSv11(ProtocolVersion protocolVersion) {
        return ProtocolVersion.TLSv11.isEqualOrEarlierVersionOf(protocolVersion.getEquivalentTLSVersion());
    }

    public static boolean isTLSv12(ProtocolVersion protocolVersion) {
        return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(protocolVersion.getEquivalentTLSVersion());
    }

    public static boolean isValidCipherSuiteForVersion(int i2, ProtocolVersion protocolVersion) {
        return getMinimumVersion(i2).isEqualOrEarlierVersionOf(protocolVersion.getEquivalentTLSVersion());
    }

    public static boolean isValidUint16(int i2) {
        return (65535 & i2) == i2;
    }

    public static boolean isValidUint16(long j2) {
        return (WebSocketProtocol.PAYLOAD_SHORT_MAX & j2) == j2;
    }

    public static boolean isValidUint24(int i2) {
        return (16777215 & i2) == i2;
    }

    public static boolean isValidUint24(long j2) {
        return (16777215 & j2) == j2;
    }

    public static boolean isValidUint32(long j2) {
        return (4294967295L & j2) == j2;
    }

    public static boolean isValidUint48(long j2) {
        return (281474976710655L & j2) == j2;
    }

    public static boolean isValidUint64(long j2) {
        return true;
    }

    public static boolean isValidUint8(int i2) {
        return (i2 & 255) == i2;
    }

    public static boolean isValidUint8(long j2) {
        return (255 & j2) == j2;
    }

    public static boolean isValidUint8(short s) {
        return (s & 255) == s;
    }

    public static Vector parseSupportedSignatureAlgorithms(boolean z, InputStream inputStream) throws IOException {
        int readUint16 = readUint16(inputStream);
        if (readUint16 >= 2 && (readUint16 & 1) == 0) {
            int i2 = readUint16 / 2;
            Vector vector = new Vector(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                SignatureAndHashAlgorithm parse = SignatureAndHashAlgorithm.parse(inputStream);
                if (!z && parse.getSignature() == 0) {
                    throw new TlsFatalAlert((short) 47);
                }
                vector.addElement(parse);
            }
            return vector;
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static ASN1Primitive readASN1Object(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        ASN1Primitive readObject = aSN1InputStream.readObject();
        if (readObject != null) {
            if (aSN1InputStream.readObject() == null) {
                return readObject;
            }
            throw new TlsFatalAlert((short) 50);
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static byte[] readAllOrNothing(int i2, InputStream inputStream) throws IOException {
        if (i2 < 1) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        int readFully = Streams.readFully(inputStream, bArr);
        if (readFully == 0) {
            return null;
        }
        if (readFully == i2) {
            return bArr;
        }
        throw new EOFException();
    }

    public static ASN1Primitive readDERObject(byte[] bArr) throws IOException {
        ASN1Primitive readASN1Object = readASN1Object(bArr);
        if (Arrays.areEqual(readASN1Object.getEncoded(ASN1Encoding.DER), bArr)) {
            return readASN1Object;
        }
        throw new TlsFatalAlert((short) 50);
    }

    public static byte[] readFully(int i2, InputStream inputStream) throws IOException {
        if (i2 < 1) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i2];
        if (i2 == Streams.readFully(inputStream, bArr)) {
            return bArr;
        }
        throw new EOFException();
    }

    public static byte[] readOpaque16(InputStream inputStream) throws IOException {
        return readFully(readUint16(inputStream), inputStream);
    }

    public static byte[] readOpaque24(InputStream inputStream) throws IOException {
        return readFully(readUint24(inputStream), inputStream);
    }

    public static byte[] readOpaque8(InputStream inputStream) throws IOException {
        return readFully(readUint8(inputStream), inputStream);
    }

    public static Vector readSignatureAlgorithmsExtension(byte[] bArr) throws IOException {
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Vector parseSupportedSignatureAlgorithms = parseSupportedSignatureAlgorithms(false, byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            return parseSupportedSignatureAlgorithms;
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    public static int readUint16(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    public static int[] readUint16Array(int i2, InputStream inputStream) throws IOException {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = readUint16(inputStream);
        }
        return iArr;
    }

    public static int readUint24(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if (read3 >= 0) {
            return read3 | (read << 16) | (read2 << 8);
        }
        throw new EOFException();
    }

    public static long readUint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if (read4 >= 0) {
            return (read4 | (read << 2) | (read2 << 16) | (read3 << 8)) & 4294967295L;
        }
        throw new EOFException();
    }

    public static long readUint48(InputStream inputStream) throws IOException {
        return ((readUint24(inputStream) & 4294967295L) << 24) | (4294967295L & readUint24(inputStream));
    }

    public static short readUint8(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read >= 0) {
            return (short) read;
        }
        throw new EOFException();
    }

    public static short[] readUint8Array(int i2, InputStream inputStream) throws IOException {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = readUint8(inputStream);
        }
        return sArr;
    }

    public static ProtocolVersion readVersion(byte[] bArr, int i2) throws IOException {
        return ProtocolVersion.get(bArr[i2] & 255, bArr[i2 + 1] & 255);
    }

    public static int readVersionRaw(byte[] bArr, int i2) throws IOException {
        return bArr[i2 + 1] | (bArr[i2] << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void trackHashAlgorithms(TlsHandshakeHash tlsHandshakeHash, Vector vector) {
        if (vector != null) {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                tlsHandshakeHash.trackHashAlgorithm(((SignatureAndHashAlgorithm) vector.elementAt(i2)).getHash());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validateKeyUsage(org.spongycastle.asn1.x509.Certificate certificate, int i2) throws IOException {
        KeyUsage fromExtensions;
        Extensions extensions = certificate.getTBSCertificate().getExtensions();
        if (extensions != null && (fromExtensions = KeyUsage.fromExtensions(extensions)) != null && (fromExtensions.getBytes()[0] & 255 & i2) != i2) {
            throw new TlsFatalAlert((short) 46);
        }
    }

    private static Vector vectorOfOne(Object obj) {
        Vector vector = new Vector(1);
        vector.addElement(obj);
        return vector;
    }

    public static void verifySupportedSignatureAlgorithm(Vector vector, SignatureAndHashAlgorithm signatureAndHashAlgorithm) throws IOException {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        if (signatureAndHashAlgorithm != null) {
            if (signatureAndHashAlgorithm.getSignature() != 0) {
                for (int i2 = 0; i2 < vector.size(); i2++) {
                    SignatureAndHashAlgorithm signatureAndHashAlgorithm2 = (SignatureAndHashAlgorithm) vector.elementAt(i2);
                    if (signatureAndHashAlgorithm2.getHash() == signatureAndHashAlgorithm.getHash() && signatureAndHashAlgorithm2.getSignature() == signatureAndHashAlgorithm.getSignature()) {
                        return;
                    }
                }
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new IllegalArgumentException("'signatureAlgorithm' cannot be null");
    }

    public static void writeGMTUnixTime(byte[] bArr, int i2) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i2] = (byte) (currentTimeMillis >>> 24);
        bArr[i2 + 1] = (byte) (currentTimeMillis >>> 16);
        bArr[i2 + 2] = (byte) (currentTimeMillis >>> 8);
        bArr[i2 + 3] = (byte) currentTimeMillis;
    }

    public static void writeOpaque16(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint16(bArr.length);
        writeUint16(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque24(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint24(bArr.length);
        writeUint24(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque8(byte[] bArr, OutputStream outputStream) throws IOException {
        checkUint8(bArr.length);
        writeUint8(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeUint16(int i2, OutputStream outputStream) throws IOException {
        outputStream.write(i2 >>> 8);
        outputStream.write(i2);
    }

    public static void writeUint16Array(int[] iArr, OutputStream outputStream) throws IOException {
        for (int i2 : iArr) {
            writeUint16(i2, outputStream);
        }
    }

    public static void writeUint16ArrayWithUint16Length(int[] iArr, OutputStream outputStream) throws IOException {
        int length = iArr.length * 2;
        checkUint16(length);
        writeUint16(length, outputStream);
        writeUint16Array(iArr, outputStream);
    }

    public static void writeUint24(int i2, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i2 >>> 16));
        outputStream.write((byte) (i2 >>> 8));
        outputStream.write((byte) i2);
    }

    public static void writeUint32(long j2, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) j2);
    }

    public static void writeUint48(long j2, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) j2);
    }

    public static void writeUint64(long j2, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j2 >>> 56));
        outputStream.write((byte) (j2 >>> 48));
        outputStream.write((byte) (j2 >>> 40));
        outputStream.write((byte) (j2 >>> 32));
        outputStream.write((byte) (j2 >>> 24));
        outputStream.write((byte) (j2 >>> 16));
        outputStream.write((byte) (j2 >>> 8));
        outputStream.write((byte) j2);
    }

    public static void writeUint8(short s, OutputStream outputStream) throws IOException {
        outputStream.write(s);
    }

    public static void writeUint8Array(short[] sArr, OutputStream outputStream) throws IOException {
        for (short s : sArr) {
            writeUint8(s, outputStream);
        }
    }

    public static void writeUint8ArrayWithUint8Length(short[] sArr, OutputStream outputStream) throws IOException {
        checkUint8(sArr.length);
        writeUint8(sArr.length, outputStream);
        writeUint8Array(sArr, outputStream);
    }

    public static void writeVersion(ProtocolVersion protocolVersion, OutputStream outputStream) throws IOException {
        outputStream.write(protocolVersion.getMajorVersion());
        outputStream.write(protocolVersion.getMinorVersion());
    }

    public static boolean isTLSv11(TlsContext tlsContext) {
        return isTLSv11(tlsContext.getServerVersion());
    }

    public static boolean isTLSv12(TlsContext tlsContext) {
        return isTLSv12(tlsContext.getServerVersion());
    }

    public static ProtocolVersion readVersion(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return ProtocolVersion.get(read, read2);
        }
        throw new EOFException();
    }

    public static int readVersionRaw(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    public static void writeUint8(int i2, OutputStream outputStream) throws IOException {
        outputStream.write(i2);
    }

    public static void checkUint16(long j2) throws IOException {
        if (!isValidUint16(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint24(long j2) throws IOException {
        if (!isValidUint24(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void checkUint8(int i2) throws IOException {
        if (!isValidUint8(i2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static long readUint48(byte[] bArr, int i2) {
        int readUint24 = readUint24(bArr, i2);
        return (readUint24(bArr, i2 + 3) & 4294967295L) | ((readUint24 & 4294967295L) << 24);
    }

    public static short readUint8(byte[] bArr, int i2) {
        return bArr[i2];
    }

    public static void writeUint16(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 8);
        bArr[i3 + 1] = (byte) i2;
    }

    public static void writeUint16Array(int[] iArr, byte[] bArr, int i2) throws IOException {
        for (int i3 : iArr) {
            writeUint16(i3, bArr, i2);
            i2 += 2;
        }
    }

    public static void writeUint8(short s, byte[] bArr, int i2) {
        bArr[i2] = (byte) s;
    }

    public static void writeUint8Array(short[] sArr, byte[] bArr, int i2) throws IOException {
        for (short s : sArr) {
            writeUint8(s, bArr, i2);
            i2++;
        }
    }

    public static void writeVersion(ProtocolVersion protocolVersion, byte[] bArr, int i2) {
        bArr[i2] = (byte) protocolVersion.getMajorVersion();
        bArr[i2 + 1] = (byte) protocolVersion.getMinorVersion();
    }

    static byte[] PRF_legacy(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        int length = (bArr.length + 1) / 2;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 0, bArr4, 0, length);
        System.arraycopy(bArr, bArr.length - length, bArr5, 0, length);
        byte[] bArr6 = new byte[i2];
        byte[] bArr7 = new byte[i2];
        hmac_hash(createHash((short) 1), bArr4, bArr3, bArr6);
        hmac_hash(createHash((short) 2), bArr5, bArr3, bArr7);
        for (int i3 = 0; i3 < i2; i3++) {
            bArr6[i3] = (byte) (bArr6[i3] ^ bArr7[i3]);
        }
        return bArr6;
    }

    public static int readUint16(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    public static void writeUint24(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) i2;
    }

    public static void writeUint8(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
    }

    public static void writeUint8ArrayWithUint8Length(short[] sArr, byte[] bArr, int i2) throws IOException {
        checkUint8(sArr.length);
        writeUint8(sArr.length, bArr, i2);
        writeUint8Array(sArr, bArr, i2 + 1);
    }

    public static void checkUint8(long j2) throws IOException {
        if (!isValidUint8(j2)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    public static void readFully(byte[] bArr, InputStream inputStream) throws IOException {
        int length = bArr.length;
        if (length > 0 && length != Streams.readFully(inputStream, bArr)) {
            throw new EOFException();
        }
    }

    public static int readUint24(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & 255) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public static void writeUint16ArrayWithUint16Length(int[] iArr, byte[] bArr, int i2) throws IOException {
        int length = iArr.length * 2;
        checkUint16(length);
        writeUint16(length, bArr, i2);
        writeUint16Array(iArr, bArr, i2 + 2);
    }

    public static void writeUint32(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j2 >>> 24);
        bArr[i2 + 1] = (byte) (j2 >>> 16);
        bArr[i2 + 2] = (byte) (j2 >>> 8);
        bArr[i2 + 3] = (byte) j2;
    }

    public static long readUint32(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        return ((bArr[i4 + 1] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8)) & 4294967295L;
    }

    public static void writeUint48(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j2 >>> 40);
        bArr[i2 + 1] = (byte) (j2 >>> 32);
        bArr[i2 + 2] = (byte) (j2 >>> 24);
        bArr[i2 + 3] = (byte) (j2 >>> 16);
        bArr[i2 + 4] = (byte) (j2 >>> 8);
        bArr[i2 + 5] = (byte) j2;
    }

    public static Digest createHash(SignatureAndHashAlgorithm signatureAndHashAlgorithm) {
        if (signatureAndHashAlgorithm == null) {
            return new CombinedHash();
        }
        return createHash(signatureAndHashAlgorithm.getHash());
    }

    public static void writeUint64(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j2 >>> 56);
        bArr[i2 + 1] = (byte) (j2 >>> 48);
        bArr[i2 + 2] = (byte) (j2 >>> 40);
        bArr[i2 + 3] = (byte) (j2 >>> 32);
        bArr[i2 + 4] = (byte) (j2 >>> 24);
        bArr[i2 + 5] = (byte) (j2 >>> 16);
        bArr[i2 + 6] = (byte) (j2 >>> 8);
        bArr[i2 + 7] = (byte) j2;
    }
}
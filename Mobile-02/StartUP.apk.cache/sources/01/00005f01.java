package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class ASN1ObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    private static final Map pool = new HashMap();
    private byte[] body;
    private final String identifier;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class OidHandle {
        private final byte[] enc;
        private int key;

        OidHandle(byte[] bArr) {
            this.key = Arrays.hashCode(bArr);
            this.enc = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return Arrays.areEqual(this.enc, ((OidHandle) obj).enc);
            }
            return false;
        }

        public int hashCode() {
            return this.key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1ObjectIdentifier(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j2 = 0;
        BigInteger bigInteger = null;
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            if (j2 <= LONG_LIMIT) {
                long j3 = j2 + (i3 & 127);
                if ((i3 & 128) == 0) {
                    if (z) {
                        if (j3 < 40) {
                            stringBuffer.append('0');
                        } else if (j3 < 80) {
                            stringBuffer.append('1');
                            j3 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j3 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j3);
                    j2 = 0;
                } else {
                    j2 = j3 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j2) : bigInteger).or(BigInteger.valueOf(i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j2 = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.body = Arrays.clone(bArr);
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        int parseInt = Integer.parseInt(oIDTokenizer.nextToken()) * 40;
        String nextToken = oIDTokenizer.nextToken();
        if (nextToken.length() <= 18) {
            writeField(byteArrayOutputStream, parseInt + Long.parseLong(nextToken));
        } else {
            writeField(byteArrayOutputStream, new BigInteger(nextToken).add(BigInteger.valueOf(parseInt)));
        }
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken2 = oIDTokenizer.nextToken();
            if (nextToken2.length() <= 18) {
                writeField(byteArrayOutputStream, Long.parseLong(nextToken2));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(nextToken2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        OidHandle oidHandle = new OidHandle(bArr);
        Map map = pool;
        synchronized (map) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) map.get(oidHandle);
            return aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier : new ASN1ObjectIdentifier(bArr);
        }
    }

    private synchronized byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1ObjectIdentifier)) {
            if (obj instanceof ASN1Encodable) {
                ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
                if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                    return (ASN1ObjectIdentifier) aSN1Encodable.toASN1Primitive();
                }
            }
            if (obj instanceof byte[]) {
                try {
                    return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray((byte[]) obj);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e2.getMessage());
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (ASN1ObjectIdentifier) obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r3 != '.') goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isValidBranchID(java.lang.String r5, int r6) {
        /*
            int r0 = r5.length()
            r1 = 0
        L5:
            r2 = r1
        L6:
            int r0 = r0 + (-1)
            if (r0 < r6) goto L1f
            char r3 = r5.charAt(r0)
            r4 = 48
            if (r4 > r3) goto L18
            r4 = 57
            if (r3 > r4) goto L18
            r2 = 1
            goto L6
        L18:
            r4 = 46
            if (r3 != r4) goto L1e
            if (r2 != 0) goto L5
        L1e:
            return r1
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1ObjectIdentifier.isValidBranchID(java.lang.String, int):boolean");
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return isValidBranchID(str, 2);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long j2) {
        byte[] bArr = new byte[9];
        int i2 = 8;
        bArr[8] = (byte) (((int) j2) & 127);
        while (j2 >= 128) {
            j2 >>= 7;
            i2--;
            bArr[i2] = (byte) ((((int) j2) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i2, 9 - i2);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
        }
        return false;
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] body = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body.length);
        aSN1OutputStream.write(body);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        Map map = pool;
        synchronized (map) {
            OidHandle oidHandle = new OidHandle(getBody());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) map.get(oidHandle);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            map.put(oidHandle, this);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id = getId();
        String id2 = aSN1ObjectIdentifier.getId();
        return id.length() > id2.length() && id.charAt(id2.length()) == '.' && id.startsWith(id2);
    }

    public String toString() {
        return getId();
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i2 = bitLength - 1;
        for (int i3 = i2; i3 >= 0; i3--) {
            bArr[i3] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i2] = (byte) (bArr[i2] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof ASN1ObjectIdentifier)) {
            return fromOctetString(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
        }
        return getInstance(object);
    }

    public ASN1ObjectIdentifier(String str) {
        if (str != null) {
            if (isValidIdentifier(str)) {
                this.identifier = str;
                return;
            }
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
        throw new IllegalArgumentException("'identifier' cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (isValidBranchID(str, 0)) {
            this.identifier = aSN1ObjectIdentifier.getId() + "." + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }
}
package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    protected final boolean isConstructed;
    protected final byte[] octets;
    protected final int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1ApplicationSpecific(boolean z, int i2, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i2;
        this.octets = bArr;
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1ApplicationSpecific)) {
            if (obj instanceof byte[]) {
                try {
                    return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to construct object from byte[]: " + e2.getMessage());
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        return (ASN1ApplicationSpecific) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getLengthOfHeader(byte[] bArr) {
        int i2 = bArr[1] & 255;
        if (i2 != 128 && i2 > 127) {
            int i3 = i2 & 127;
            if (i3 <= 4) {
                return i3 + 2;
            }
            throw new IllegalStateException("DER length more than 4 bytes: " + i3);
        }
        return 2;
    }

    private byte[] replaceTagNumber(int i2, byte[] bArr) throws IOException {
        int i3;
        if ((bArr[0] & 31) == 31) {
            i3 = 2;
            int i4 = bArr[1] & 255;
            if ((i4 & 127) == 0) {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
            while (i4 >= 0 && (i4 & 128) != 0) {
                i4 = bArr[i3] & 255;
                i3++;
            }
        } else {
            i3 = 1;
        }
        int length = (bArr.length - i3) + 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i3, bArr2, 1, length - 1);
        bArr2[0] = (byte) i2;
        return bArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1ApplicationSpecific) {
            ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
            return this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && Arrays.areEqual(this.octets, aSN1ApplicationSpecific.octets);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return this.octets;
    }

    public ASN1Primitive getObject() throws IOException {
        return new ASN1InputStream(getContents()).readObject();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        boolean z = this.isConstructed;
        return ((z ? 1 : 0) ^ this.tag) ^ Arrays.hashCode(this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return this.isConstructed;
    }

    public ASN1Primitive getObject(int i2) throws IOException {
        if (i2 < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i2, encoded);
            if ((encoded[0] & 32) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | 32);
            }
            return new ASN1InputStream(replaceTagNumber).readObject();
        }
        throw new IOException("unsupported tag number");
    }
}
package org.spongycastle.asn1;

import java.io.IOException;

/* loaded from: classes3.dex */
public class DERBitString extends ASN1BitString {
    protected DERBitString(byte b2, int i2) {
        this(toByteArray(b2), i2);
    }

    static DERBitString fromOctetString(byte[] bArr) {
        if (bArr.length >= 1) {
            byte b2 = bArr[0];
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            if (length != 0) {
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            }
            return new DERBitString(bArr2, b2);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static DERBitString getInstance(Object obj) {
        if (obj != null && !(obj instanceof DERBitString)) {
            if (obj instanceof DLBitString) {
                DLBitString dLBitString = (DLBitString) obj;
                return new DERBitString(dLBitString.data, dLBitString.padBits);
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (DERBitString) obj;
    }

    private static byte[] toByteArray(byte b2) {
        return new byte[]{b2};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1BitString, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] derForm = ASN1BitString.derForm(this.data, this.padBits);
        int length = derForm.length + 1;
        byte[] bArr = new byte[length];
        bArr[0] = (byte) getPadBits();
        System.arraycopy(derForm, 0, bArr, 1, length - 1);
        aSN1OutputStream.writeEncoded(3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public DERBitString(byte[] bArr, int i2) {
        super(bArr, i2);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(int i2) {
        super(ASN1BitString.getBytes(i2), ASN1BitString.getPadBits(i2));
    }

    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERBitString)) {
            return fromOctetString(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }
}
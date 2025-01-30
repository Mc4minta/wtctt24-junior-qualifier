package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DERApplicationSpecific(boolean z, int i2, byte[] bArr) {
        super(z, i2, bArr);
    }

    private static byte[] getEncodedVector(ASN1EncodableVector aSN1EncodableVector) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 != aSN1EncodableVector.size(); i2++) {
            try {
                byteArrayOutputStream.write(((ASN1Object) aSN1EncodableVector.get(i2)).getEncoded(ASN1Encoding.DER));
            } catch (IOException e2) {
                throw new ASN1ParsingException("malformed object: " + e2, e2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] getEncoding(boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        if (z) {
            return encoded;
        }
        int lengthOfHeader = ASN1ApplicationSpecific.getLengthOfHeader(encoded);
        int length = encoded.length - lengthOfHeader;
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, lengthOfHeader, bArr, 0, length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1ApplicationSpecific, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    public DERApplicationSpecific(int i2, byte[] bArr) {
        this(false, i2, bArr);
    }

    public DERApplicationSpecific(int i2, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i2, aSN1Encodable);
    }

    public DERApplicationSpecific(boolean z, int i2, ASN1Encodable aSN1Encodable) throws IOException {
        super(z || aSN1Encodable.toASN1Primitive().isConstructed(), i2, getEncoding(z, aSN1Encodable));
    }

    public DERApplicationSpecific(int i2, ASN1EncodableVector aSN1EncodableVector) {
        super(true, i2, getEncodedVector(aSN1EncodableVector));
    }
}
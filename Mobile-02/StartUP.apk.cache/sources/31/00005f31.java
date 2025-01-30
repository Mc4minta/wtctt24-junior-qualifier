package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class DERGeneralString extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERGeneralString(byte[] bArr) {
        this.string = bArr;
    }

    public static DERGeneralString getInstance(Object obj) {
        if (obj != null && !(obj instanceof DERGeneralString)) {
            if (obj instanceof byte[]) {
                try {
                    return (DERGeneralString) ASN1Primitive.fromByteArray((byte[]) obj);
                } catch (Exception e2) {
                    throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (DERGeneralString) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERGeneralString) {
            return Arrays.areEqual(this.string, ((DERGeneralString) aSN1Primitive).string);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(27, this.string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }

    public DERGeneralString(String str) {
        this.string = Strings.toByteArray(str);
    }

    public static DERGeneralString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERGeneralString)) {
            return new DERGeneralString(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }
}
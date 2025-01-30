package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class ASN1Boolean extends ASN1Primitive {
    private final byte[] value;
    private static final byte[] TRUE_VALUE = {-1};
    private static final byte[] FALSE_VALUE = {0};
    public static final ASN1Boolean FALSE = new ASN1Boolean(false);
    public static final ASN1Boolean TRUE = new ASN1Boolean(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1Boolean(byte[] bArr) {
        if (bArr.length == 1) {
            if (bArr[0] == 0) {
                this.value = FALSE_VALUE;
                return;
            } else if ((bArr[0] & 255) == 255) {
                this.value = TRUE_VALUE;
                return;
            } else {
                this.value = Arrays.clone(bArr);
                return;
            }
        }
        throw new IllegalArgumentException("byte value should have 1 byte in it");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length == 1) {
            if (bArr[0] == 0) {
                return FALSE;
            }
            if ((bArr[0] & 255) == 255) {
                return TRUE;
            }
            return new ASN1Boolean(bArr);
        }
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1Boolean)) {
            if (obj instanceof byte[]) {
                try {
                    return (ASN1Boolean) ASN1Primitive.fromByteArray((byte[]) obj);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e2.getMessage());
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (ASN1Boolean) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    protected boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && this.value[0] == ((ASN1Boolean) aSN1Primitive).value[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(1, this.value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 3;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.value[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value[0] != 0;
    }

    public String toString() {
        return this.value[0] != 0 ? "TRUE" : "FALSE";
    }

    public static ASN1Boolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    public ASN1Boolean(boolean z) {
        this.value = z ? TRUE_VALUE : FALSE_VALUE;
    }

    public static ASN1Boolean getInstance(int i2) {
        return i2 != 0 ? TRUE : FALSE;
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof ASN1Boolean)) {
            return fromOctetString(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }
}
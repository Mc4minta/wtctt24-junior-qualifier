package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;

/* loaded from: classes3.dex */
public class DHPublicKey extends ASN1Object {
    private ASN1Integer y;

    private DHPublicKey(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            this.y = aSN1Integer;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public static DHPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Integer.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getY() {
        return this.y.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.y;
    }

    public static DHPublicKey getInstance(Object obj) {
        if (obj != null && !(obj instanceof DHPublicKey)) {
            if (obj instanceof ASN1Integer) {
                return new DHPublicKey((ASN1Integer) obj);
            }
            throw new IllegalArgumentException("Invalid DHPublicKey: " + obj.getClass().getName());
        }
        return (DHPublicKey) obj;
    }

    public DHPublicKey(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.y = new ASN1Integer(bigInteger);
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }
}
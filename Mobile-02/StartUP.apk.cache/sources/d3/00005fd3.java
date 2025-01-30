package org.spongycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

/* loaded from: classes3.dex */
public class ECGOST3410ParamSetParameters extends ASN1Object {
    ASN1Integer a;

    /* renamed from: b  reason: collision with root package name */
    ASN1Integer f17764b;
    ASN1Integer p;
    ASN1Integer q;
    ASN1Integer x;
    ASN1Integer y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i2, BigInteger bigInteger5) {
        this.a = new ASN1Integer(bigInteger);
        this.f17764b = new ASN1Integer(bigInteger2);
        this.p = new ASN1Integer(bigInteger3);
        this.q = new ASN1Integer(bigInteger4);
        this.x = new ASN1Integer(i2);
        this.y = new ASN1Integer(bigInteger5);
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.q.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.f17764b);
        aSN1EncodableVector.add(this.p);
        aSN1EncodableVector.add(this.q);
        aSN1EncodableVector.add(this.x);
        aSN1EncodableVector.add(this.y);
        return new DERSequence(aSN1EncodableVector);
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj != null && !(obj instanceof ECGOST3410ParamSetParameters)) {
            if (obj instanceof ASN1Sequence) {
                return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
            }
            throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
        }
        return (ECGOST3410ParamSetParameters) obj;
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = (ASN1Integer) objects.nextElement();
        this.f17764b = (ASN1Integer) objects.nextElement();
        this.p = (ASN1Integer) objects.nextElement();
        this.q = (ASN1Integer) objects.nextElement();
        this.x = (ASN1Integer) objects.nextElement();
        this.y = (ASN1Integer) objects.nextElement();
    }
}
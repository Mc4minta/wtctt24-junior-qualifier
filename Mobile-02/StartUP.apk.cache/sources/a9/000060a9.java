package org.spongycastle.asn1.ua;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

/* loaded from: classes3.dex */
public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j  reason: collision with root package name */
    private int f17769j;

    /* renamed from: k  reason: collision with root package name */
    private int f17770k;

    /* renamed from: l  reason: collision with root package name */
    private int f17771l;
    private int m;

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getPositiveValue().intValue();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f17770k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getPositiveValue().intValue();
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f17770k = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(0)).getPositiveValue().intValue();
            this.f17769j = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(1)).getPositiveValue().intValue();
            this.f17771l = ASN1Integer.getInstance(aSN1Sequence2.getObjectAt(2)).getPositiveValue().intValue();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getK1() {
        return this.f17770k;
    }

    public int getK2() {
        return this.f17769j;
    }

    public int getK3() {
        return this.f17771l;
    }

    public int getM() {
        return this.m;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(this.m));
        if (this.f17769j == 0) {
            aSN1EncodableVector.add(new ASN1Integer(this.f17770k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1Integer(this.f17770k));
            aSN1EncodableVector2.add(new ASN1Integer(this.f17769j));
            aSN1EncodableVector2.add(new ASN1Integer(this.f17771l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145BinaryField(int i2, int i3, int i4, int i5) {
        this.m = i2;
        this.f17770k = i3;
        this.f17769j = i4;
        this.f17771l = i5;
    }

    public DSTU4145BinaryField(int i2, int i3) {
        this(i2, i3, 0, 0);
    }
}
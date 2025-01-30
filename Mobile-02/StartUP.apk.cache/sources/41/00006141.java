package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECFieldElement;

/* loaded from: classes3.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f  reason: collision with root package name */
    protected ECFieldElement f17784f;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f17784f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f17784f;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f17784f.toBigInteger(), converter.getByteLength(this.f17784f)));
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(int i2, int i3, int i4, int i5, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i2, i3, i4, i5, new BigInteger(1, aSN1OctetString.getOctets())));
    }
}
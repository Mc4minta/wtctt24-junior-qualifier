package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: classes3.dex */
public class RecipientIdentifier extends ASN1Object implements ASN1Choice {
    private ASN1Encodable id;

    public RecipientIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.id = issuerAndSerialNumber;
    }

    public static RecipientIdentifier getInstance(Object obj) {
        if (obj != null && !(obj instanceof RecipientIdentifier)) {
            if (obj instanceof IssuerAndSerialNumber) {
                return new RecipientIdentifier((IssuerAndSerialNumber) obj);
            }
            if (obj instanceof ASN1OctetString) {
                return new RecipientIdentifier((ASN1OctetString) obj);
            }
            if (obj instanceof ASN1Primitive) {
                return new RecipientIdentifier((ASN1Primitive) obj);
            }
            throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + obj.getClass().getName());
        }
        return (RecipientIdentifier) obj;
    }

    public ASN1Encodable getId() {
        ASN1Encodable aSN1Encodable = this.id;
        if (aSN1Encodable instanceof ASN1TaggedObject) {
            return ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Encodable, false);
        }
        return IssuerAndSerialNumber.getInstance(aSN1Encodable);
    }

    public boolean isTagged() {
        return this.id instanceof ASN1TaggedObject;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.id.toASN1Primitive();
    }

    public RecipientIdentifier(ASN1OctetString aSN1OctetString) {
        this.id = new DERTaggedObject(false, 0, aSN1OctetString);
    }

    public RecipientIdentifier(ASN1Primitive aSN1Primitive) {
        this.id = aSN1Primitive;
    }
}
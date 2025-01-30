package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes3.dex */
public class ASN1EncodableVector {
    private final Vector v = new Vector();

    public void add(ASN1Encodable aSN1Encodable) {
        this.v.addElement(aSN1Encodable);
    }

    public void addAll(ASN1EncodableVector aSN1EncodableVector) {
        Enumeration elements = aSN1EncodableVector.v.elements();
        while (elements.hasMoreElements()) {
            this.v.addElement(elements.nextElement());
        }
    }

    public ASN1Encodable get(int i2) {
        return (ASN1Encodable) this.v.elementAt(i2);
    }

    public int size() {
        return this.v.size();
    }
}
package org.spongycastle.asn1.cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSet;

/* loaded from: classes3.dex */
public class AttributeTable {
    private Hashtable attributes;

    public AttributeTable(Hashtable hashtable) {
        this.attributes = new Hashtable();
        this.attributes = copyTable(hashtable);
    }

    private void addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, Attribute attribute) {
        Vector vector;
        Object obj = this.attributes.get(aSN1ObjectIdentifier);
        if (obj == null) {
            this.attributes.put(aSN1ObjectIdentifier, attribute);
            return;
        }
        if (obj instanceof Attribute) {
            vector = new Vector();
            vector.addElement(obj);
            vector.addElement(attribute);
        } else {
            vector = (Vector) obj;
            vector.addElement(attribute);
        }
        this.attributes.put(aSN1ObjectIdentifier, vector);
    }

    private Hashtable copyTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    public AttributeTable add(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        AttributeTable attributeTable = new AttributeTable(this.attributes);
        attributeTable.addAttribute(aSN1ObjectIdentifier, new Attribute(aSN1ObjectIdentifier, new DERSet(aSN1Encodable)));
        return attributeTable;
    }

    public Attribute get(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Object obj = this.attributes.get(aSN1ObjectIdentifier);
        if (obj instanceof Vector) {
            return (Attribute) ((Vector) obj).elementAt(0);
        }
        return (Attribute) obj;
    }

    public ASN1EncodableVector getAll(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Object obj = this.attributes.get(aSN1ObjectIdentifier);
        if (obj instanceof Vector) {
            Enumeration elements = ((Vector) obj).elements();
            while (elements.hasMoreElements()) {
                aSN1EncodableVector.add((Attribute) elements.nextElement());
            }
        } else if (obj != null) {
            aSN1EncodableVector.add((Attribute) obj);
        }
        return aSN1EncodableVector;
    }

    public AttributeTable remove(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AttributeTable attributeTable = new AttributeTable(this.attributes);
        attributeTable.attributes.remove(aSN1ObjectIdentifier);
        return attributeTable;
    }

    public int size() {
        Enumeration elements = this.attributes.elements();
        int i2 = 0;
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            i2 = nextElement instanceof Vector ? i2 + ((Vector) nextElement).size() : i2 + 1;
        }
        return i2;
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.attributes.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Vector) {
                Enumeration elements2 = ((Vector) nextElement).elements();
                while (elements2.hasMoreElements()) {
                    aSN1EncodableVector.add(Attribute.getInstance(elements2.nextElement()));
                }
            } else {
                aSN1EncodableVector.add(Attribute.getInstance(nextElement));
            }
        }
        return aSN1EncodableVector;
    }

    public Attributes toASN1Structure() {
        return new Attributes(toASN1EncodableVector());
    }

    public Hashtable toHashtable() {
        return copyTable(this.attributes);
    }

    public AttributeTable(ASN1EncodableVector aSN1EncodableVector) {
        this.attributes = new Hashtable();
        for (int i2 = 0; i2 != aSN1EncodableVector.size(); i2++) {
            Attribute attribute = Attribute.getInstance(aSN1EncodableVector.get(i2));
            addAttribute(attribute.getAttrType(), attribute);
        }
    }

    public AttributeTable(ASN1Set aSN1Set) {
        this.attributes = new Hashtable();
        for (int i2 = 0; i2 != aSN1Set.size(); i2++) {
            Attribute attribute = Attribute.getInstance(aSN1Set.getObjectAt(i2));
            addAttribute(attribute.getAttrType(), attribute);
        }
    }

    public AttributeTable(Attribute attribute) {
        this.attributes = new Hashtable();
        addAttribute(attribute.getAttrType(), attribute);
    }

    public AttributeTable(Attributes attributes) {
        this(ASN1Set.getInstance(attributes.toASN1Primitive()));
    }
}
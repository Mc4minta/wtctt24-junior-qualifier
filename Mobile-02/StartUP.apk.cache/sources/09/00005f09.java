package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

/* loaded from: classes3.dex */
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    protected Vector seq;

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence() {
        this.seq = new Vector();
    }

    public static ASN1Sequence getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1Sequence)) {
            if (obj instanceof ASN1SequenceParser) {
                return getInstance(((ASN1SequenceParser) obj).toASN1Primitive());
            }
            if (obj instanceof byte[]) {
                try {
                    return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
                } catch (IOException e2) {
                    throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e2.getMessage());
                }
            }
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Sequence) {
                    return (ASN1Sequence) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        return (ASN1Sequence) obj;
    }

    private ASN1Encodable getNext(Enumeration enumeration) {
        return (ASN1Encodable) enumeration.nextElement();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1Sequence) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
            if (size() != aSN1Sequence.size()) {
                return false;
            }
            Enumeration objects = getObjects();
            Enumeration objects2 = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1Encodable next = getNext(objects);
                ASN1Encodable next2 = getNext(objects2);
                ASN1Primitive aSN1Primitive2 = next.toASN1Primitive();
                ASN1Primitive aSN1Primitive3 = next2.toASN1Primitive();
                if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.equals(aSN1Primitive3)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream) throws IOException;

    public ASN1Encodable getObjectAt(int i2) {
        return (ASN1Encodable) this.seq.elementAt(i2);
    }

    public Enumeration getObjects() {
        return this.seq.elements();
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ getNext(objects).hashCode();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    @Override // org.spongycastle.util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SequenceParser parser() {
        return new ASN1SequenceParser() { // from class: org.spongycastle.asn1.ASN1Sequence.1
            private int index;
            private final int max;

            {
                this.max = ASN1Sequence.this.size();
            }

            @Override // org.spongycastle.asn1.InMemoryRepresentable
            public ASN1Primitive getLoadedObject() {
                return this;
            }

            @Override // org.spongycastle.asn1.ASN1SequenceParser
            public ASN1Encodable readObject() throws IOException {
                int i2 = this.index;
                if (i2 == this.max) {
                    return null;
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.this;
                this.index = i2 + 1;
                ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i2);
                if (objectAt instanceof ASN1Sequence) {
                    return ((ASN1Sequence) objectAt).parser();
                }
                return objectAt instanceof ASN1Set ? ((ASN1Set) objectAt).parser() : objectAt;
            }

            @Override // org.spongycastle.asn1.ASN1Encodable
            public ASN1Primitive toASN1Primitive() {
                return this;
            }
        };
    }

    public int size() {
        return this.seq.size();
    }

    public ASN1Encodable[] toArray() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i2 = 0; i2 != size(); i2++) {
            aSN1EncodableArr[i2] = getObjectAt(i2);
        }
        return aSN1EncodableArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        DERSequence dERSequence = new DERSequence();
        dERSequence.seq = this.seq;
        return dERSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        DLSequence dLSequence = new DLSequence();
        dLSequence.seq = this.seq;
        return dLSequence;
    }

    public String toString() {
        return this.seq.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1Encodable aSN1Encodable) {
        Vector vector = new Vector();
        this.seq = vector;
        vector.addElement(aSN1Encodable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        this.seq = new Vector();
        for (int i2 = 0; i2 != aSN1EncodableVector.size(); i2++) {
            this.seq.addElement(aSN1EncodableVector.get(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        this.seq = new Vector();
        for (int i2 = 0; i2 != aSN1EncodableArr.length; i2++) {
            this.seq.addElement(aSN1EncodableArr[i2]);
        }
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.isExplicit()) {
                return getInstance(aSN1TaggedObject.getObject().toASN1Primitive());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.isExplicit()) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSequence(aSN1TaggedObject.getObject());
            }
            return new DLSequence(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
            return (ASN1Sequence) aSN1TaggedObject.getObject();
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
        }
    }
}
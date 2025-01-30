package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes3.dex */
public class BEROctetString extends ASN1OctetString {
    private static final int MAX_LENGTH = 1000;
    private ASN1OctetString[] octs;

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BEROctetString fromSequence(ASN1Sequence aSN1Sequence) {
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i2 = 0;
        while (objects.hasMoreElements()) {
            aSN1OctetStringArr[i2] = (ASN1OctetString) objects.nextElement();
            i2++;
        }
        return new BEROctetString(aSN1OctetStringArr);
    }

    private Vector generateOcts() {
        Vector vector = new Vector();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.string;
            if (i2 >= bArr.length) {
                return vector;
            }
            int i3 = i2 + 1000;
            int length = (i3 > bArr.length ? bArr.length : i3) - i2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i2, bArr2, 0, length);
            vector.addElement(new DEROctetString(bArr2));
            i2 = i3;
        }
    }

    private static byte[] toBytes(ASN1OctetString[] aSN1OctetStringArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 != aSN1OctetStringArr.length; i2++) {
            try {
                byteArrayOutputStream.write(((DEROctetString) aSN1OctetStringArr[i2]).getOctets());
            } catch (IOException e2) {
                throw new IllegalArgumentException("exception converting octets " + e2.toString());
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(aSN1OctetStringArr[i2].getClass().getName() + " found in input should only contain DEROctetString");
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.spongycastle.asn1.ASN1OctetString, org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(36);
        aSN1OutputStream.write(128);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        Enumeration objects = getObjects();
        int i2 = 0;
        while (objects.hasMoreElements()) {
            i2 += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().encodedLength();
        }
        return i2 + 2 + 2;
    }

    public Enumeration getObjects() {
        if (this.octs == null) {
            return generateOcts().elements();
        }
        return new Enumeration() { // from class: org.spongycastle.asn1.BEROctetString.1
            int counter = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.counter < BEROctetString.this.octs.length;
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                ASN1OctetString[] aSN1OctetStringArr = BEROctetString.this.octs;
                int i2 = this.counter;
                this.counter = i2 + 1;
                return aSN1OctetStringArr[i2];
            }
        };
    }

    @Override // org.spongycastle.asn1.ASN1OctetString
    public byte[] getOctets() {
        return this.string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        super(toBytes(aSN1OctetStringArr));
        this.octs = aSN1OctetStringArr;
    }
}
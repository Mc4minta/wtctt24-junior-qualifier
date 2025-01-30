package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    public GeneralNames(GeneralName generalName) {
        this.names = new GeneralName[]{generalName};
    }

    public static GeneralNames fromExtensions(Extensions extensions, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return getInstance(extensions.getExtensionParsedValue(aSN1ObjectIdentifier));
    }

    public static GeneralNames getInstance(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        if (obj != null) {
            return new GeneralNames(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName[] getNames() {
        GeneralName[] generalNameArr = this.names;
        GeneralName[] generalNameArr2 = new GeneralName[generalNameArr.length];
        System.arraycopy(generalNameArr, 0, generalNameArr2, 0, generalNameArr.length);
        return generalNameArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.names);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("GeneralNames:");
        stringBuffer.append(lineSeparator);
        for (int i2 = 0; i2 != this.names.length; i2++) {
            stringBuffer.append("    ");
            stringBuffer.append(this.names[i2]);
            stringBuffer.append(lineSeparator);
        }
        return stringBuffer.toString();
    }

    public GeneralNames(GeneralName[] generalNameArr) {
        this.names = generalNameArr;
    }

    public static GeneralNames getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private GeneralNames(ASN1Sequence aSN1Sequence) {
        this.names = new GeneralName[aSN1Sequence.size()];
        for (int i2 = 0; i2 != aSN1Sequence.size(); i2++) {
            this.names[i2] = GeneralName.getInstance(aSN1Sequence.getObjectAt(i2));
        }
    }
}
package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVisibleString;

/* loaded from: classes3.dex */
public class DisplayText extends ASN1Object implements ASN1Choice {
    public static final int CONTENT_TYPE_BMPSTRING = 1;
    public static final int CONTENT_TYPE_IA5STRING = 0;
    public static final int CONTENT_TYPE_UTF8STRING = 2;
    public static final int CONTENT_TYPE_VISIBLESTRING = 3;
    public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
    int contentType;
    ASN1String contents;

    public DisplayText(int i2, String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = i2;
        if (i2 == 0) {
            this.contents = new DERIA5String(str);
        } else if (i2 == 1) {
            this.contents = new DERBMPString(str);
        } else if (i2 == 2) {
            this.contents = new DERUTF8String(str);
        } else if (i2 != 3) {
            this.contents = new DERUTF8String(str);
        } else {
            this.contents = new DERVisibleString(str);
        }
    }

    public static DisplayText getInstance(Object obj) {
        if (obj instanceof ASN1String) {
            return new DisplayText((ASN1String) obj);
        }
        if (obj != null && !(obj instanceof DisplayText)) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (DisplayText) obj;
    }

    public String getString() {
        return this.contents.getString();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return (ASN1Primitive) this.contents;
    }

    public static DisplayText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DisplayText(String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = 2;
        this.contents = new DERUTF8String(str);
    }

    private DisplayText(ASN1String aSN1String) {
        this.contents = aSN1String;
    }
}
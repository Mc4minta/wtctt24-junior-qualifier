package org.spongycastle.asn1;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class ASN1GeneralizedTime extends ASN1Primitive {
    private byte[] time;

    public ASN1GeneralizedTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    private String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i2 = rawOffset / 3600000;
        int i3 = (rawOffset - (((i2 * 60) * 60) * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i2 += str.equals("+") ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str + convert(i2) + ":" + convert(i3);
    }

    private String convert(int i2) {
        if (i2 < 10) {
            return com.coinbase.wallet.core.extensions.Strings.zero + i2;
        }
        return Integer.toString(i2);
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1GeneralizedTime)) {
            if (obj instanceof byte[]) {
                try {
                    return (ASN1GeneralizedTime) ASN1Primitive.fromByteArray((byte[]) obj);
                } catch (Exception e2) {
                    throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        return (ASN1GeneralizedTime) obj;
    }

    private boolean hasFractionalSeconds() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i2 == bArr.length) {
                return false;
            }
            if (bArr[i2] == 46 && i2 == 14) {
                return true;
            }
            i2++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            return Arrays.areEqual(this.time, ((ASN1GeneralizedTime) aSN1Primitive).time);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(24, this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        char charAt;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (fromByteArray.indexOf(45) <= 0 && fromByteArray.indexOf(43) <= 0) {
            if (hasFractionalSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpleDateFormat = simpleDateFormat2;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        } else {
            fromByteArray = getTime();
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        }
        if (hasFractionalSeconds()) {
            String substring = fromByteArray.substring(14);
            int i2 = 1;
            while (i2 < substring.length() && '0' <= (charAt = substring.charAt(i2)) && charAt <= '9') {
                i2++;
            }
            int i3 = i2 - 1;
            if (i3 > 3) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, 4) + substring.substring(i2));
            } else if (i3 == 1) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, i2) + "00" + substring.substring(i2));
            } else if (i3 == 2) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, i2) + com.coinbase.wallet.core.extensions.Strings.zero + substring.substring(i2));
            }
        }
        return simpleDateFormat.parse(fromByteArray);
    }

    public String getTime() {
        int length;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length2 = fromByteArray.length() - 5;
        char charAt = fromByteArray.charAt(length2);
        if (charAt != '-' && charAt != '+') {
            char charAt2 = fromByteArray.charAt(fromByteArray.length() - 3);
            if (charAt2 != '-' && charAt2 != '+') {
                return fromByteArray + calculateGMTOffset();
            }
            return fromByteArray.substring(0, length) + "GMT" + fromByteArray.substring(length) + ":00";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fromByteArray.substring(0, length2));
        sb.append("GMT");
        int i2 = length2 + 3;
        sb.append(fromByteArray.substring(length2, i2));
        sb.append(":");
        sb.append(fromByteArray.substring(i2));
        return sb.toString();
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public ASN1GeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof ASN1GeneralizedTime)) {
            return new ASN1GeneralizedTime(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }

    public ASN1GeneralizedTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1GeneralizedTime(byte[] bArr) {
        this.time = bArr;
    }
}
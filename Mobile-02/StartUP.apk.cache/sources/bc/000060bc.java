package org.spongycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.http.message.TokenParser;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500NameBuilder;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

/* loaded from: classes3.dex */
public class IETFUtils {
    public static void appendRDN(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
        if (rdn.isMultiValued()) {
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            boolean z = true;
            for (int i2 = 0; i2 != typesAndValues.length; i2++) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append('+');
                }
                appendTypeAndValue(stringBuffer, typesAndValues[i2], hashtable);
            }
        } else if (rdn.getFirst() != null) {
            appendTypeAndValue(stringBuffer, rdn.getFirst(), hashtable);
        }
    }

    public static void appendTypeAndValue(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String str = (String) hashtable.get(attributeTypeAndValue.getType());
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(attributeTypeAndValue.getType().getId());
        }
        stringBuffer.append('=');
        stringBuffer.append(valueToString(attributeTypeAndValue.getValue()));
    }

    private static boolean atvAreEqual(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        return attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.getType().equals(attributeTypeAndValue2.getType()) && canonicalize(valueToString(attributeTypeAndValue.getValue())).equals(canonicalize(valueToString(attributeTypeAndValue2.getValue())));
    }

    private static String bytesToString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 != length; i2++) {
            cArr[i2] = (char) (bArr[i2] & 255);
        }
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r0 >= (r6.length() - 1)) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String canonicalize(java.lang.String r6) {
        /*
            java.lang.String r6 = org.spongycastle.util.Strings.toLowerCase(r6)
            int r0 = r6.length()
            r1 = 0
            if (r0 <= 0) goto L25
            char r0 = r6.charAt(r1)
            r2 = 35
            if (r0 != r2) goto L25
            org.spongycastle.asn1.ASN1Primitive r0 = decodeObject(r6)
            boolean r2 = r0 instanceof org.spongycastle.asn1.ASN1String
            if (r2 == 0) goto L25
            org.spongycastle.asn1.ASN1String r0 = (org.spongycastle.asn1.ASN1String) r0
            java.lang.String r6 = r0.getString()
            java.lang.String r6 = org.spongycastle.util.Strings.toLowerCase(r6)
        L25:
            int r0 = r6.length()
            r2 = 1
            if (r0 <= r2) goto L6d
        L2c:
            int r0 = r1 + 1
            int r3 = r6.length()
            r4 = 32
            r5 = 92
            if (r0 >= r3) goto L47
            char r3 = r6.charAt(r1)
            if (r3 != r5) goto L47
            char r0 = r6.charAt(r0)
            if (r0 != r4) goto L47
            int r1 = r1 + 2
            goto L2c
        L47:
            int r0 = r6.length()
            int r0 = r0 - r2
        L4c:
            int r3 = r0 + (-1)
            if (r3 <= 0) goto L5f
            char r3 = r6.charAt(r3)
            if (r3 != r5) goto L5f
            char r3 = r6.charAt(r0)
            if (r3 != r4) goto L5f
            int r0 = r0 + (-2)
            goto L4c
        L5f:
            if (r1 > 0) goto L68
            int r3 = r6.length()
            int r3 = r3 - r2
            if (r0 >= r3) goto L6d
        L68:
            int r0 = r0 + r2
            java.lang.String r6 = r6.substring(r1, r0)
        L6d:
            java.lang.String r6 = stripInternalSpaces(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.style.IETFUtils.canonicalize(java.lang.String):java.lang.String");
    }

    private static int convertHex(char c2) {
        if ('0' > c2 || c2 > '9') {
            return (('a' > c2 || c2 > 'f') ? c2 - 'A' : c2 - 'a') + 10;
        }
        return c2 - '0';
    }

    public static ASN1ObjectIdentifier decodeAttrName(String str, Hashtable hashtable) {
        if (Strings.toUpperCase(str).startsWith("OID.")) {
            return new ASN1ObjectIdentifier(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new ASN1ObjectIdentifier(str);
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
    }

    private static ASN1Primitive decodeObject(String str) {
        try {
            return ASN1Primitive.fromByteArray(Hex.decode(str.substring(1)));
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    public static String[] findAttrNamesForOID(ASN1ObjectIdentifier aSN1ObjectIdentifier, Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        int i2 = 0;
        int i3 = 0;
        while (elements.hasMoreElements()) {
            if (aSN1ObjectIdentifier.equals(elements.nextElement())) {
                i3++;
            }
        }
        String[] strArr = new String[i3];
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (aSN1ObjectIdentifier.equals(hashtable.get(str))) {
                strArr[i2] = str;
                i2++;
            }
        }
        return strArr;
    }

    private static boolean isHexDigit(char c2) {
        return ('0' <= c2 && c2 <= '9') || ('a' <= c2 && c2 <= 'f') || ('A' <= c2 && c2 <= 'F');
    }

    public static boolean rDNAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.isMultiValued()) {
            if (rdn2.isMultiValued()) {
                AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
                AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
                if (typesAndValues.length != typesAndValues2.length) {
                    return false;
                }
                for (int i2 = 0; i2 != typesAndValues.length; i2++) {
                    if (!atvAreEqual(typesAndValues[i2], typesAndValues2[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } else if (rdn2.isMultiValued()) {
            return false;
        } else {
            return atvAreEqual(rdn.getFirst(), rdn2.getFirst());
        }
    }

    public static RDN[] rDNsFromString(String str, X500NameStyle x500NameStyle) {
        X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str);
        X500NameBuilder x500NameBuilder = new X500NameBuilder(x500NameStyle);
        while (x500NameTokenizer.hasMoreTokens()) {
            String nextToken = x500NameTokenizer.nextToken();
            if (nextToken.indexOf(43) > 0) {
                X500NameTokenizer x500NameTokenizer2 = new X500NameTokenizer(nextToken, '+');
                X500NameTokenizer x500NameTokenizer3 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), '=');
                String nextToken2 = x500NameTokenizer3.nextToken();
                if (x500NameTokenizer3.hasMoreTokens()) {
                    String nextToken3 = x500NameTokenizer3.nextToken();
                    ASN1ObjectIdentifier attrNameToOID = x500NameStyle.attrNameToOID(nextToken2.trim());
                    if (x500NameTokenizer2.hasMoreTokens()) {
                        Vector vector = new Vector();
                        Vector vector2 = new Vector();
                        vector.addElement(attrNameToOID);
                        vector2.addElement(unescape(nextToken3));
                        while (x500NameTokenizer2.hasMoreTokens()) {
                            X500NameTokenizer x500NameTokenizer4 = new X500NameTokenizer(x500NameTokenizer2.nextToken(), '=');
                            String nextToken4 = x500NameTokenizer4.nextToken();
                            if (x500NameTokenizer4.hasMoreTokens()) {
                                String nextToken5 = x500NameTokenizer4.nextToken();
                                vector.addElement(x500NameStyle.attrNameToOID(nextToken4.trim()));
                                vector2.addElement(unescape(nextToken5));
                            } else {
                                throw new IllegalArgumentException("badly formatted directory string");
                            }
                        }
                        x500NameBuilder.addMultiValuedRDN(toOIDArray(vector), toValueArray(vector2));
                    } else {
                        x500NameBuilder.addRDN(attrNameToOID, unescape(nextToken3));
                    }
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            } else {
                X500NameTokenizer x500NameTokenizer5 = new X500NameTokenizer(nextToken, '=');
                String nextToken6 = x500NameTokenizer5.nextToken();
                if (x500NameTokenizer5.hasMoreTokens()) {
                    x500NameBuilder.addRDN(x500NameStyle.attrNameToOID(nextToken6.trim()), unescape(x500NameTokenizer5.nextToken()));
                } else {
                    throw new IllegalArgumentException("badly formatted directory string");
                }
            }
        }
        return x500NameBuilder.build().getRDNs();
    }

    public static String stripInternalSpaces(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i2 = 1;
            while (i2 < str.length()) {
                char charAt2 = str.charAt(i2);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i2++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    private static ASN1ObjectIdentifier[] toOIDArray(Vector vector) {
        int size = vector.size();
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[size];
        for (int i2 = 0; i2 != size; i2++) {
            aSN1ObjectIdentifierArr[i2] = (ASN1ObjectIdentifier) vector.elementAt(i2);
        }
        return aSN1ObjectIdentifierArr;
    }

    private static String[] toValueArray(Vector vector) {
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 != size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    private static String unescape(String str) {
        int i2;
        if (str.length() != 0 && (str.indexOf(92) >= 0 || str.indexOf(34) >= 0)) {
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer(str.length());
            if (charArray[0] == '\\' && charArray[1] == '#') {
                i2 = 2;
                stringBuffer.append("\\#");
            } else {
                i2 = 0;
            }
            boolean z = false;
            int i3 = 0;
            boolean z2 = false;
            boolean z3 = false;
            char c2 = 0;
            while (i2 != charArray.length) {
                char c3 = charArray[i2];
                if (c3 != ' ') {
                    z3 = true;
                }
                if (c3 != '\"') {
                    if (c3 == '\\' && !z && !z2) {
                        i3 = stringBuffer.length();
                        z = true;
                    } else if (c3 != ' ' || z || z3) {
                        if (!z || !isHexDigit(c3)) {
                            stringBuffer.append(c3);
                        } else if (c2 != 0) {
                            stringBuffer.append((char) ((convertHex(c2) * 16) + convertHex(c3)));
                            z = false;
                            c2 = 0;
                        } else {
                            c2 = c3;
                        }
                    }
                    i2++;
                } else if (z) {
                    stringBuffer.append(c3);
                } else {
                    z2 = !z2;
                }
                z = false;
                i2++;
            }
            if (stringBuffer.length() > 0) {
                while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && i3 != stringBuffer.length() - 1) {
                    stringBuffer.setLength(stringBuffer.length() - 1);
                }
            }
            return stringBuffer.toString();
        }
        return str.trim();
    }

    public static ASN1Encodable valueFromHexString(String str, int i2) throws IOException {
        int length = (str.length() - i2) / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 != length; i3++) {
            int i4 = (i3 * 2) + i2;
            char charAt = str.charAt(i4);
            bArr[i3] = (byte) (convertHex(str.charAt(i4 + 1)) | (convertHex(charAt) << 4));
        }
        return ASN1Primitive.fromByteArray(bArr);
    }

    public static String valueToString(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((aSN1Encodable instanceof ASN1String) && !(aSN1Encodable instanceof DERUniversalString)) {
            String string = ((ASN1String) aSN1Encodable).getString();
            if (string.length() > 0 && string.charAt(0) == '#') {
                stringBuffer.append("\\" + string);
            } else {
                stringBuffer.append(string);
            }
        } else {
            try {
                stringBuffer.append("#" + bytesToString(Hex.encode(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER))));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        }
        int length = stringBuffer.length();
        int i2 = 2;
        i2 = (stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#') ? 0 : 0;
        while (i2 != length) {
            if (stringBuffer.charAt(i2) == ',' || stringBuffer.charAt(i2) == '\"' || stringBuffer.charAt(i2) == '\\' || stringBuffer.charAt(i2) == '+' || stringBuffer.charAt(i2) == '=' || stringBuffer.charAt(i2) == '<' || stringBuffer.charAt(i2) == '>' || stringBuffer.charAt(i2) == ';') {
                stringBuffer.insert(i2, "\\");
                i2++;
                length++;
            }
            i2++;
        }
        if (stringBuffer.length() > 0) {
            for (int i3 = 0; stringBuffer.length() > i3 && stringBuffer.charAt(i3) == ' '; i3 += 2) {
                stringBuffer.insert(i3, "\\");
            }
        }
        for (int length2 = stringBuffer.length() - 1; length2 >= 0 && stringBuffer.charAt(length2) == ' '; length2--) {
            stringBuffer.insert(length2, TokenParser.ESCAPE);
        }
        return stringBuffer.toString();
    }
}
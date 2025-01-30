package org.spongycastle.asn1.x509;

import java.io.IOException;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public abstract class X509NameEntryConverter {
    protected boolean canBePrintable(String str) {
        return DERPrintableString.isPrintableString(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Primitive convertHexEncoded(String str, int i2) throws IOException {
        String lowerCase = Strings.toLowerCase(str);
        int length = (lowerCase.length() - i2) / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 != length; i3++) {
            int i4 = (i3 * 2) + i2;
            char charAt = lowerCase.charAt(i4);
            char charAt2 = lowerCase.charAt(i4 + 1);
            if (charAt < 'a') {
                bArr[i3] = (byte) ((charAt - '0') << 4);
            } else {
                bArr[i3] = (byte) (((charAt - 'a') + 10) << 4);
            }
            if (charAt2 < 'a') {
                bArr[i3] = (byte) (((byte) (charAt2 - '0')) | bArr[i3]);
            } else {
                bArr[i3] = (byte) (((byte) ((charAt2 - 'a') + 10)) | bArr[i3]);
            }
        }
        return new ASN1InputStream(bArr).readObject();
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);
}
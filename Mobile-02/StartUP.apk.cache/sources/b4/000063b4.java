package org.spongycastle.i18n.filter;

/* loaded from: classes3.dex */
public class HTMLFilter implements Filter {
    @Override // org.spongycastle.i18n.filter.Filter
    public String doFilter(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i2 = 0;
        while (i2 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == '\"') {
                stringBuffer.replace(i2, i2 + 1, "&#34");
            } else if (charAt == '#') {
                stringBuffer.replace(i2, i2 + 1, "&#35");
            } else if (charAt == '+') {
                stringBuffer.replace(i2, i2 + 1, "&#43");
            } else if (charAt == '-') {
                stringBuffer.replace(i2, i2 + 1, "&#45");
            } else if (charAt == '>') {
                stringBuffer.replace(i2, i2 + 1, "&#62");
            } else if (charAt == ';') {
                stringBuffer.replace(i2, i2 + 1, "&#59");
            } else if (charAt != '<') {
                switch (charAt) {
                    case '%':
                        stringBuffer.replace(i2, i2 + 1, "&#37");
                        continue;
                    case '&':
                        stringBuffer.replace(i2, i2 + 1, "&#38");
                        continue;
                    case '\'':
                        stringBuffer.replace(i2, i2 + 1, "&#39");
                        continue;
                    case '(':
                        stringBuffer.replace(i2, i2 + 1, "&#40");
                        continue;
                    case ')':
                        stringBuffer.replace(i2, i2 + 1, "&#41");
                        continue;
                    default:
                        i2 -= 3;
                        continue;
                }
            } else {
                stringBuffer.replace(i2, i2 + 1, "&#60");
            }
            i2 += 4;
        }
        return stringBuffer.toString();
    }

    @Override // org.spongycastle.i18n.filter.Filter
    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
package com.google.android.gms.internal.clearcut;

import java.util.List;
import java.util.Map;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(i2 i2Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        b(i2Var, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e6, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e8, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f8, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0209, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x021b, code lost:
        if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(com.google.android.gms.internal.clearcut.i2 r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.l2.b(com.google.android.gms.internal.clearcut.i2, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void c(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                c(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                c(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(TokenParser.SP);
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(n3.a(a0.r((String) obj)));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof a0) {
                sb.append(": \"");
                sb.append(n3.a((a0) obj));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof e1) {
                sb.append(" {");
                b((e1) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(TokenParser.SP);
                    i3++;
                }
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj.toString());
            } else {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                c(sb, i5, "key", entry2.getKey());
                c(sb, i5, "value", entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(TokenParser.SP);
                    i3++;
                }
                sb.append("}");
            }
        }
    }

    private static final String d(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
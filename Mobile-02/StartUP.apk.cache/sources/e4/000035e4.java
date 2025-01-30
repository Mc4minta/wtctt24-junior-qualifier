package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class z5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(u5 u5Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(u5Var, sb, 0);
        return sb.toString();
    }

    private static final String b(String str) {
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

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e5, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e7, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f8, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0209, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x021b, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(com.google.android.gms.internal.measurement.u5 r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.z5.c(com.google.android.gms.internal.measurement.u5, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void d(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                d(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                d(sb, i2, str, entry);
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
                sb.append(a7.a(h3.o((String) obj)));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof h3) {
                sb.append(": \"");
                sb.append(a7.a((h3) obj));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof n4) {
                sb.append(" {");
                c((n4) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(TokenParser.SP);
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                d(sb, i5, "key", entry2.getKey());
                d(sb, i5, "value", entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(TokenParser.SP);
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }
}
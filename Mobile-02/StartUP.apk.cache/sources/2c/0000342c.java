package com.google.android.gms.internal.p000firebaseperf;

import java.util.List;
import java.util.Map;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w5  reason: invalid package */
/* loaded from: classes2.dex */
public final class w5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(v5 v5Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        b(v5Var, sb, 0);
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
    private static void b(com.google.android.gms.internal.p000firebaseperf.v5 r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.w5.b(com.google.android.gms.internal.firebase-perf.v5, java.lang.StringBuilder, int):void");
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
                sb.append(a7.a(i3.l((String) obj)));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof i3) {
                sb.append(": \"");
                sb.append(a7.a((i3) obj));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof m4) {
                sb.append(" {");
                b((m4) obj, sb, i2 + 2);
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
                c(sb, i5, "key", entry2.getKey());
                c(sb, i5, "value", entry2.getValue());
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
package com.google.android.gms.internal.p000firebaseperf;

import org.apache.http.message.TokenParser;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.a7  reason: invalid package */
/* loaded from: classes2.dex */
final class a7 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(i3 i3Var) {
        z6 z6Var = new z6(i3Var);
        StringBuilder sb = new StringBuilder(z6Var.size());
        for (int i2 = 0; i2 < z6Var.size(); i2++) {
            byte a = z6Var.a(i2);
            if (a == 34) {
                sb.append("\\\"");
            } else if (a == 39) {
                sb.append("\\'");
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (a >= 32 && a <= 126) {
                            sb.append((char) a);
                            continue;
                        } else {
                            sb.append(TokenParser.ESCAPE);
                            sb.append((char) (((a >>> 6) & 3) + 48));
                            sb.append((char) (((a >>> 3) & 7) + 48));
                            sb.append((char) ((a & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
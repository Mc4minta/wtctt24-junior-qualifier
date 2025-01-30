package com.google.android.gms.internal.measurement;

import org.apache.http.message.TokenParser;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class a7 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(h3 h3Var) {
        z6 z6Var = new z6(h3Var);
        StringBuilder sb = new StringBuilder(z6Var.a());
        for (int i2 = 0; i2 < z6Var.a(); i2++) {
            byte f2 = z6Var.f(i2);
            if (f2 == 34) {
                sb.append("\\\"");
            } else if (f2 == 39) {
                sb.append("\\'");
            } else if (f2 != 92) {
                switch (f2) {
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
                        if (f2 >= 32 && f2 <= 126) {
                            sb.append((char) f2);
                            continue;
                        } else {
                            sb.append(TokenParser.ESCAPE);
                            sb.append((char) (((f2 >>> 6) & 3) + 48));
                            sb.append((char) (((f2 >>> 3) & 7) + 48));
                            sb.append((char) ((f2 & 7) + 48));
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
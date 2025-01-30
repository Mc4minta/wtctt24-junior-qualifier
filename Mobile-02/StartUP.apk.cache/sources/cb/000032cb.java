package com.google.android.gms.internal.clearcut;

import org.apache.http.message.TokenParser;

/* loaded from: classes2.dex */
final class n3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(a0 a0Var) {
        String str;
        o3 o3Var = new o3(a0Var);
        StringBuilder sb = new StringBuilder(o3Var.size());
        for (int i2 = 0; i2 < o3Var.size(); i2++) {
            int a = o3Var.a(i2);
            if (a == 34) {
                str = "\\\"";
            } else if (a == 39) {
                str = "\\'";
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a < 32 || a > 126) {
                            sb.append(TokenParser.ESCAPE);
                            sb.append((char) (((a >>> 6) & 3) + 48));
                            sb.append((char) (((a >>> 3) & 7) + 48));
                            a = (a & 7) + 48;
                        }
                        sb.append((char) a);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
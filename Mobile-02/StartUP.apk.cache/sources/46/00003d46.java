package com.google.zxing.t.r.g.e;

/* compiled from: AI01decoder.java */
/* loaded from: classes2.dex */
abstract class h extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    private static void e(StringBuilder sb, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i2) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        sb.append(i5 != 10 ? i5 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i2, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int f2 = b().f((i4 * 10) + i2, 10);
            if (f2 / 100 == 0) {
                sb.append('0');
            }
            if (f2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(f2);
        }
        e(sb, i3);
    }
}
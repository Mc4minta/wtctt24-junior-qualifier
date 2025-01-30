package com.google.zxing.t.r.g.e;

/* compiled from: AI01weightDecoder.java */
/* loaded from: classes2.dex */
abstract class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb, int i2);

    protected abstract int i(int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(StringBuilder sb, int i2, int i3) {
        int f2 = b().f(i2, i3);
        h(sb, f2);
        int i4 = i(f2);
        int i5 = 100000;
        for (int i6 = 0; i6 < 5; i6++) {
            if (i4 / i5 == 0) {
                sb.append('0');
            }
            i5 /= 10;
        }
        sb.append(i4);
    }
}
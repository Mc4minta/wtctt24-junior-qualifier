package com.google.zxing.t.r.g.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01320xDecoder.java */
/* loaded from: classes2.dex */
public final class b extends f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.t.r.g.e.i
    protected void h(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.google.zxing.t.r.g.e.i
    protected int i(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}
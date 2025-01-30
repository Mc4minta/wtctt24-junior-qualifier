package com.google.zxing.t.r.g.e;

import com.google.zxing.NotFoundException;

/* compiled from: AI013x0xDecoder.java */
/* loaded from: classes2.dex */
abstract class f extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.t.r.g.e.j
    public String d() throws NotFoundException {
        if (c().o() == 60) {
            StringBuilder sb = new StringBuilder();
            f(sb, 5);
            j(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.a();
    }
}
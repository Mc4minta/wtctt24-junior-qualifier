package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01AndOtherAIs.java */
/* loaded from: classes2.dex */
public final class g extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.t.r.g.e.j
    public String d() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(b().f(4, 4));
        g(sb, 8, length);
        return b().a(sb, 48);
    }
}
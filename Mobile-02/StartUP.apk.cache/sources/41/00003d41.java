package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01392xDecoder.java */
/* loaded from: classes2.dex */
public final class c extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.t.r.g.e.j
    public String d() throws NotFoundException, FormatException {
        if (c().o() >= 48) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            int f2 = b().f(48, 2);
            sb.append("(392");
            sb.append(f2);
            sb.append(')');
            sb.append(b().c(50, null).b());
            return sb.toString();
        }
        throw NotFoundException.a();
    }
}
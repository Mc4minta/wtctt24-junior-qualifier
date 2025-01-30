package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01393xDecoder.java */
/* loaded from: classes2.dex */
public final class d extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.google.zxing.q.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.t.r.g.e.j
    public String d() throws NotFoundException, FormatException {
        if (c().o() >= 48) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            int f2 = b().f(48, 2);
            sb.append("(393");
            sb.append(f2);
            sb.append(')');
            int f3 = b().f(50, 10);
            if (f3 / 100 == 0) {
                sb.append('0');
            }
            if (f3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(f3);
            sb.append(b().c(60, null).b());
            return sb.toString();
        }
        throw NotFoundException.a();
    }
}
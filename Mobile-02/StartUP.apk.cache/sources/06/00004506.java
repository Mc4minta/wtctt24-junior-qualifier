package e.a.a.y;

import e.a.a.w.k.h;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class v {
    private static final c.a a = c.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.h a(e.a.a.y.k0.c cVar) throws IOException {
        String str = null;
        boolean z = false;
        h.a aVar = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                aVar = h.a.h(cVar.m());
            } else if (K != 2) {
                cVar.N();
                cVar.O();
            } else {
                z = cVar.g();
            }
        }
        return new e.a.a.w.k.h(str, aVar, z);
    }
}
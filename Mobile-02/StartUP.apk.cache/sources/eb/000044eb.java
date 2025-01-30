package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
class g0 {
    static c.a a = c.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.o a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        int i2 = 0;
        String str = null;
        e.a.a.w.j.h hVar = null;
        boolean z = false;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                i2 = cVar.m();
            } else if (K == 2) {
                hVar = d.k(cVar, eVar);
            } else if (K != 3) {
                cVar.O();
            } else {
                z = cVar.g();
            }
        }
        return new e.a.a.w.k.o(str, i2, hVar, z);
    }
}
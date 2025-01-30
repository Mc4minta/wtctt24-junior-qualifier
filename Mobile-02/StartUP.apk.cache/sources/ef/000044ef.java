package e.a.a.y;

import e.a.a.w.k.q;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class i0 {
    private static c.a a = c.a.a("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.q a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        boolean z = false;
        String str = null;
        q.a aVar = null;
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.b bVar2 = null;
        e.a.a.w.j.b bVar3 = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                bVar = d.f(cVar, eVar, false);
            } else if (K == 1) {
                bVar2 = d.f(cVar, eVar, false);
            } else if (K == 2) {
                bVar3 = d.f(cVar, eVar, false);
            } else if (K == 3) {
                str = cVar.v();
            } else if (K == 4) {
                aVar = q.a.h(cVar.m());
            } else if (K != 5) {
                cVar.O();
            } else {
                z = cVar.g();
            }
        }
        return new e.a.a.w.k.q(str, aVar, bVar, bVar2, bVar3, z);
    }
}
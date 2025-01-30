package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {
    private static c.a a = c.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f11918b = c.a.a("fc", "sc", "sw", "t");

    public static e.a.a.w.j.k a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        cVar.c();
        e.a.a.w.j.k kVar = null;
        while (cVar.f()) {
            if (cVar.K(a) != 0) {
                cVar.N();
                cVar.O();
            } else {
                kVar = b(cVar, eVar);
            }
        }
        cVar.e();
        return kVar == null ? new e.a.a.w.j.k(null, null, null, null) : kVar;
    }

    private static e.a.a.w.j.k b(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        cVar.c();
        e.a.a.w.j.a aVar = null;
        e.a.a.w.j.a aVar2 = null;
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.b bVar2 = null;
        while (cVar.f()) {
            int K = cVar.K(f11918b);
            if (K == 0) {
                aVar = d.c(cVar, eVar);
            } else if (K == 1) {
                aVar2 = d.c(cVar, eVar);
            } else if (K == 2) {
                bVar = d.e(cVar, eVar);
            } else if (K != 3) {
                cVar.N();
                cVar.O();
            } else {
                bVar2 = d.e(cVar, eVar);
            }
        }
        cVar.e();
        return new e.a.a.w.j.k(aVar, aVar2, bVar, bVar2);
    }
}
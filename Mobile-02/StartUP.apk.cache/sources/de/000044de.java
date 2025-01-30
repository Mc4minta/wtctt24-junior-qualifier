package e.a.a.y;

import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {
    private static c.a a = c.a.a("k", "x", "y");

    public static e.a.a.w.j.e a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
            while (cVar.f()) {
                arrayList.add(w.a(cVar, eVar));
            }
            cVar.d();
            r.b(arrayList);
        } else {
            arrayList.add(new e.a.a.a0.a(p.e(cVar, e.a.a.z.h.e())));
        }
        return new e.a.a.w.j.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.j.m<PointF, PointF> b(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        cVar.c();
        e.a.a.w.j.e eVar2 = null;
        e.a.a.w.j.b bVar = null;
        boolean z = false;
        e.a.a.w.j.b bVar2 = null;
        while (cVar.A() != c.b.END_OBJECT) {
            int K = cVar.K(a);
            if (K == 0) {
                eVar2 = a(cVar, eVar);
            } else if (K != 1) {
                if (K != 2) {
                    cVar.N();
                    cVar.O();
                } else if (cVar.A() == c.b.STRING) {
                    cVar.O();
                    z = true;
                } else {
                    bVar = d.e(cVar, eVar);
                }
            } else if (cVar.A() == c.b.STRING) {
                cVar.O();
                z = true;
            } else {
                bVar2 = d.e(cVar, eVar);
            }
        }
        cVar.e();
        if (z) {
            eVar.a("Lottie doesn't support expressions.");
        }
        return eVar2 != null ? eVar2 : new e.a.a.w.j.i(bVar2, bVar);
    }
}
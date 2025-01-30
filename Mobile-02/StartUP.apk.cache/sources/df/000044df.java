package e.a.a.y;

import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class a0 {
    private static c.a a = c.a.a("nm", "p", "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.j a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        String str = null;
        e.a.a.w.j.m<PointF, PointF> mVar = null;
        e.a.a.w.j.f fVar = null;
        e.a.a.w.j.b bVar = null;
        boolean z = false;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                mVar = a.b(cVar, eVar);
            } else if (K == 2) {
                fVar = d.i(cVar, eVar);
            } else if (K == 3) {
                bVar = d.e(cVar, eVar);
            } else if (K != 4) {
                cVar.O();
            } else {
                z = cVar.g();
            }
        }
        return new e.a.a.w.k.j(str, mVar, fVar, bVar, z);
    }
}
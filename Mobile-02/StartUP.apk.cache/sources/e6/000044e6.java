package e.a.a.y;

import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
public class e {
    private static c.a a = c.a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.a a(e.a.a.y.k0.c cVar, e.a.a.e eVar, int i2) throws IOException {
        boolean z = i2 == 3;
        boolean z2 = false;
        String str = null;
        e.a.a.w.j.m<PointF, PointF> mVar = null;
        e.a.a.w.j.f fVar = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                mVar = a.b(cVar, eVar);
            } else if (K == 2) {
                fVar = d.i(cVar, eVar);
            } else if (K == 3) {
                z2 = cVar.g();
            } else if (K != 4) {
                cVar.N();
                cVar.O();
            } else {
                z = cVar.m() == 3;
            }
        }
        return new e.a.a.w.k.a(str, mVar, fVar, z, z2);
    }
}
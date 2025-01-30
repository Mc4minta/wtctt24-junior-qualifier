package e.a.a.y;

import android.graphics.PointF;
import e.a.a.w.k.i;
import e.a.a.y.k0.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
public class z {
    private static final c.a a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.i a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        boolean z = false;
        String str = null;
        i.a aVar = null;
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.m<PointF, PointF> mVar = null;
        e.a.a.w.j.b bVar2 = null;
        e.a.a.w.j.b bVar3 = null;
        e.a.a.w.j.b bVar4 = null;
        e.a.a.w.j.b bVar5 = null;
        e.a.a.w.j.b bVar6 = null;
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    str = cVar.v();
                    break;
                case 1:
                    aVar = i.a.h(cVar.m());
                    break;
                case 2:
                    bVar = d.f(cVar, eVar, false);
                    break;
                case 3:
                    mVar = a.b(cVar, eVar);
                    break;
                case 4:
                    bVar2 = d.f(cVar, eVar, false);
                    break;
                case 5:
                    bVar4 = d.e(cVar, eVar);
                    break;
                case 6:
                    bVar6 = d.f(cVar, eVar, false);
                    break;
                case 7:
                    bVar3 = d.e(cVar, eVar);
                    break;
                case 8:
                    bVar5 = d.f(cVar, eVar, false);
                    break;
                case 9:
                    z = cVar.g();
                    break;
                default:
                    cVar.N();
                    cVar.O();
                    break;
            }
        }
        return new e.a.a.w.k.i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
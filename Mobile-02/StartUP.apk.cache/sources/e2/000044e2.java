package e.a.a.y;

import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c {
    private static c.a a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static c.a f11919b = c.a.a("k");

    private static boolean a(e.a.a.w.j.e eVar) {
        return eVar == null || (eVar.isStatic() && eVar.b().get(0).f11473b.equals(0.0f, 0.0f));
    }

    private static boolean b(e.a.a.w.j.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof e.a.a.w.j.i) && mVar.isStatic() && mVar.b().get(0).f11473b.equals(0.0f, 0.0f));
    }

    private static boolean c(e.a.a.w.j.b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((e.a.a.a0.a) bVar.b().get(0)).f11473b).floatValue() == 0.0f);
    }

    private static boolean d(e.a.a.w.j.g gVar) {
        return gVar == null || (gVar.isStatic() && ((e.a.a.a0.d) ((e.a.a.a0.a) gVar.b().get(0)).f11473b).a(1.0f, 1.0f));
    }

    private static boolean e(e.a.a.w.j.b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((e.a.a.a0.a) bVar.b().get(0)).f11473b).floatValue() == 0.0f);
    }

    private static boolean f(e.a.a.w.j.b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((e.a.a.a0.a) bVar.b().get(0)).f11473b).floatValue() == 0.0f);
    }

    public static e.a.a.w.j.l g(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        boolean z;
        boolean z2 = false;
        boolean z3 = cVar.A() == c.b.BEGIN_OBJECT;
        if (z3) {
            cVar.c();
        }
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.e eVar2 = null;
        e.a.a.w.j.m<PointF, PointF> mVar = null;
        e.a.a.w.j.g gVar = null;
        e.a.a.w.j.b bVar2 = null;
        e.a.a.w.j.b bVar3 = null;
        e.a.a.w.j.d dVar = null;
        e.a.a.w.j.b bVar4 = null;
        e.a.a.w.j.b bVar5 = null;
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    boolean z4 = z2;
                    cVar.c();
                    while (cVar.f()) {
                        if (cVar.K(f11919b) != 0) {
                            cVar.N();
                            cVar.O();
                        } else {
                            eVar2 = a.a(cVar, eVar);
                        }
                    }
                    cVar.e();
                    z2 = z4;
                    continue;
                case 1:
                    mVar = a.b(cVar, eVar);
                    continue;
                case 2:
                    gVar = d.j(cVar, eVar);
                    continue;
                case 3:
                    eVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.h(cVar, eVar);
                    continue;
                case 6:
                    bVar4 = d.f(cVar, eVar, z2);
                    continue;
                case 7:
                    bVar5 = d.f(cVar, eVar, z2);
                    continue;
                case 8:
                    bVar2 = d.f(cVar, eVar, z2);
                    continue;
                case 9:
                    bVar3 = d.f(cVar, eVar, z2);
                    continue;
                default:
                    cVar.N();
                    cVar.O();
                    continue;
            }
            e.a.a.w.j.b f2 = d.f(cVar, eVar, z2);
            if (f2.b().isEmpty()) {
                f2.b().add(new e.a.a.a0.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar.f())));
            } else if (((e.a.a.a0.a) f2.b().get(0)).f11473b == 0) {
                z = false;
                f2.b().set(0, new e.a.a.a0.a(eVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(eVar.f())));
                z2 = z;
                bVar = f2;
            }
            z = false;
            z2 = z;
            bVar = f2;
        }
        if (z3) {
            cVar.e();
        }
        e.a.a.w.j.e eVar3 = a(eVar2) ? null : eVar2;
        e.a.a.w.j.m<PointF, PointF> mVar2 = b(mVar) ? null : mVar;
        e.a.a.w.j.b bVar6 = c(bVar) ? null : bVar;
        if (d(gVar)) {
            gVar = null;
        }
        return new e.a.a.w.j.l(eVar3, mVar2, gVar, bVar6, dVar, bVar4, bVar5, f(bVar2) ? null : bVar2, e(bVar3) ? null : bVar3);
    }
}
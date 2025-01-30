package c.f.b.k;

import c.f.b.k.e;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class k {
    static boolean[] a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, c.f.b.d dVar, e eVar) {
        eVar.f2810k = -1;
        eVar.f2811l = -1;
        e.b bVar = fVar.P[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.P[0] == e.b.MATCH_PARENT) {
            int i2 = eVar.E.f2789e;
            int Q = fVar.Q() - eVar.G.f2789e;
            d dVar2 = eVar.E;
            dVar2.f2791g = dVar.q(dVar2);
            d dVar3 = eVar.G;
            dVar3.f2791g = dVar.q(dVar3);
            dVar.f(eVar.E.f2791g, i2);
            dVar.f(eVar.G.f2791g, Q);
            eVar.f2810k = 2;
            eVar.l0(i2, Q);
        }
        if (fVar.P[1] == bVar2 || eVar.P[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i3 = eVar.F.f2789e;
        int w = fVar.w() - eVar.H.f2789e;
        d dVar4 = eVar.F;
        dVar4.f2791g = dVar.q(dVar4);
        d dVar5 = eVar.H;
        dVar5.f2791g = dVar.q(dVar5);
        dVar.f(eVar.F.f2791g, i3);
        dVar.f(eVar.H.f2791g, w);
        if (eVar.b0 > 0 || eVar.P() == 8) {
            d dVar6 = eVar.I;
            dVar6.f2791g = dVar.q(dVar6);
            dVar.f(eVar.I.f2791g, eVar.b0 + i3);
        }
        eVar.f2811l = 2;
        eVar.A0(i3, w);
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
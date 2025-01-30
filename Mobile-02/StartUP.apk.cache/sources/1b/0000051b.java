package c.f.b.k.n;

import c.f.b.k.e;
import c.f.b.k.n.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DependencyGraph.java */
/* loaded from: classes.dex */
public class e {
    private c.f.b.k.f a;

    /* renamed from: d  reason: collision with root package name */
    private c.f.b.k.f f2843d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2841b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2842c = true;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<m> f2844e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<k> f2845f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private b.InterfaceC0060b f2846g = null;

    /* renamed from: h  reason: collision with root package name */
    private b.a f2847h = new b.a();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<k> f2848i = new ArrayList<>();

    public e(c.f.b.k.f fVar) {
        this.a = fVar;
        this.f2843d = fVar;
    }

    private void a(f fVar, int i2, int i3, f fVar2, ArrayList<k> arrayList, k kVar) {
        m mVar = fVar.f2851d;
        if (mVar.f2879c == null) {
            c.f.b.k.f fVar3 = this.a;
            if (mVar == fVar3.f2805f || mVar == fVar3.f2806g) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i3);
                arrayList.add(kVar);
            }
            mVar.f2879c = kVar;
            kVar.a(mVar);
            for (d dVar : mVar.f2884h.f2858k) {
                if (dVar instanceof f) {
                    a((f) dVar, i2, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.f2885i.f2858k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i2, 1, fVar2, arrayList, kVar);
                }
            }
            if (i2 == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).f2876k.f2858k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i2, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            for (f fVar4 : mVar.f2884h.f2859l) {
                if (fVar4 == fVar2) {
                    kVar.f2870c = true;
                }
                a(fVar4, i2, 0, fVar2, arrayList, kVar);
            }
            for (f fVar5 : mVar.f2885i.f2859l) {
                if (fVar5 == fVar2) {
                    kVar.f2870c = true;
                }
                a(fVar5, i2, 1, fVar2, arrayList, kVar);
            }
            if (i2 == 1 && (mVar instanceof l)) {
                for (f fVar6 : ((l) mVar).f2876k.f2859l) {
                    a(fVar6, i2, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    private boolean b(c.f.b.k.f fVar) {
        int i2;
        e.b bVar;
        int i3;
        e.b bVar2;
        e.b bVar3;
        e.b bVar4;
        Iterator<c.f.b.k.e> it = fVar.G0.iterator();
        while (it.hasNext()) {
            c.f.b.k.e next = it.next();
            e.b[] bVarArr = next.P;
            e.b bVar5 = bVarArr[0];
            e.b bVar6 = bVarArr[1];
            if (next.P() == 8) {
                next.f2801b = true;
            } else {
                if (next.r < 1.0f && bVar5 == e.b.MATCH_CONSTRAINT) {
                    next.m = 2;
                }
                if (next.u < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    next.n = 2;
                }
                if (next.u() > 0.0f) {
                    e.b bVar7 = e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == e.b.WRAP_CONTENT || bVar6 == e.b.FIXED)) {
                        next.m = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == e.b.WRAP_CONTENT || bVar5 == e.b.FIXED)) {
                        next.n = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (next.m == 0) {
                            next.m = 3;
                        }
                        if (next.n == 0) {
                            next.n = 3;
                        }
                    }
                }
                e.b bVar8 = e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && next.m == 1 && (next.E.f2788d == null || next.G.f2788d == null)) {
                    bVar5 = e.b.WRAP_CONTENT;
                }
                e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && next.n == 1 && (next.F.f2788d == null || next.H.f2788d == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                e.b bVar10 = bVar6;
                j jVar = next.f2805f;
                jVar.f2880d = bVar9;
                int i4 = next.m;
                jVar.a = i4;
                l lVar = next.f2806g;
                lVar.f2880d = bVar10;
                int i5 = next.n;
                lVar.a = i5;
                e.b bVar11 = e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == e.b.FIXED || bVar9 == e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == e.b.FIXED || bVar10 == e.b.WRAP_CONTENT)) {
                    int Q = next.Q();
                    if (bVar9 == bVar11) {
                        i2 = (fVar.Q() - next.E.f2789e) - next.G.f2789e;
                        bVar = e.b.FIXED;
                    } else {
                        i2 = Q;
                        bVar = bVar9;
                    }
                    int w = next.w();
                    if (bVar10 == bVar11) {
                        i3 = (fVar.w() - next.F.f2789e) - next.H.f2789e;
                        bVar2 = e.b.FIXED;
                    } else {
                        i3 = w;
                        bVar2 = bVar10;
                    }
                    l(next, bVar, i2, bVar2, i3);
                    next.f2805f.f2881e.d(next.Q());
                    next.f2806g.f2881e.d(next.w());
                    next.f2801b = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = e.b.WRAP_CONTENT) || bVar10 == e.b.FIXED)) {
                        if (i4 == 3) {
                            if (bVar10 == bVar4) {
                                l(next, bVar4, 0, bVar4, 0);
                            }
                            int w2 = next.w();
                            e.b bVar12 = e.b.FIXED;
                            l(next, bVar12, (int) ((w2 * next.T) + 0.5f), bVar12, w2);
                            next.f2805f.f2881e.d(next.Q());
                            next.f2806g.f2881e.d(next.w());
                            next.f2801b = true;
                        } else if (i4 == 1) {
                            l(next, bVar4, 0, bVar10, 0);
                            next.f2805f.f2881e.m = next.Q();
                        } else if (i4 == 2) {
                            e.b[] bVarArr2 = fVar.P;
                            e.b bVar13 = bVarArr2[0];
                            e.b bVar14 = e.b.FIXED;
                            if (bVar13 == bVar14 || bVarArr2[0] == bVar11) {
                                l(next, bVar14, (int) ((next.r * fVar.Q()) + 0.5f), bVar10, next.w());
                                next.f2805f.f2881e.d(next.Q());
                                next.f2806g.f2881e.d(next.w());
                                next.f2801b = true;
                            }
                        } else {
                            c.f.b.k.d[] dVarArr = next.M;
                            if (dVarArr[0].f2788d == null || dVarArr[1].f2788d == null) {
                                l(next, bVar4, 0, bVar10, 0);
                                next.f2805f.f2881e.d(next.Q());
                                next.f2806g.f2881e.d(next.w());
                                next.f2801b = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = e.b.WRAP_CONTENT) || bVar9 == e.b.FIXED)) {
                        if (i5 == 3) {
                            if (bVar9 == bVar3) {
                                l(next, bVar3, 0, bVar3, 0);
                            }
                            int Q2 = next.Q();
                            float f2 = next.T;
                            if (next.v() == -1) {
                                f2 = 1.0f / f2;
                            }
                            e.b bVar15 = e.b.FIXED;
                            l(next, bVar15, Q2, bVar15, (int) ((Q2 * f2) + 0.5f));
                            next.f2805f.f2881e.d(next.Q());
                            next.f2806g.f2881e.d(next.w());
                            next.f2801b = true;
                        } else if (i5 == 1) {
                            l(next, bVar9, 0, bVar3, 0);
                            next.f2806g.f2881e.m = next.w();
                        } else if (i5 == 2) {
                            e.b[] bVarArr3 = fVar.P;
                            e.b bVar16 = bVarArr3[1];
                            e.b bVar17 = e.b.FIXED;
                            if (bVar16 == bVar17 || bVarArr3[1] == bVar11) {
                                l(next, bVar9, next.Q(), bVar17, (int) ((next.u * fVar.w()) + 0.5f));
                                next.f2805f.f2881e.d(next.Q());
                                next.f2806g.f2881e.d(next.w());
                                next.f2801b = true;
                            }
                        } else {
                            c.f.b.k.d[] dVarArr2 = next.M;
                            if (dVarArr2[2].f2788d == null || dVarArr2[3].f2788d == null) {
                                l(next, bVar3, 0, bVar10, 0);
                                next.f2805f.f2881e.d(next.Q());
                                next.f2806g.f2881e.d(next.w());
                                next.f2801b = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i4 == 1 || i5 == 1) {
                            e.b bVar18 = e.b.WRAP_CONTENT;
                            l(next, bVar18, 0, bVar18, 0);
                            next.f2805f.f2881e.m = next.Q();
                            next.f2806g.f2881e.m = next.w();
                        } else if (i5 == 2 && i4 == 2) {
                            e.b[] bVarArr4 = fVar.P;
                            e.b bVar19 = bVarArr4[0];
                            e.b bVar20 = e.b.FIXED;
                            if (bVar19 == bVar20 || bVarArr4[0] == bVar20) {
                                if (bVarArr4[1] == bVar20 || bVarArr4[1] == bVar20) {
                                    l(next, bVar20, (int) ((next.r * fVar.Q()) + 0.5f), bVar20, (int) ((next.u * fVar.w()) + 0.5f));
                                    next.f2805f.f2881e.d(next.Q());
                                    next.f2806g.f2881e.d(next.w());
                                    next.f2801b = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(c.f.b.k.f fVar, int i2) {
        int size = this.f2848i.size();
        long j2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j2 = Math.max(j2, this.f2848i.get(i3).b(fVar, i2));
        }
        return (int) j2;
    }

    private void i(m mVar, int i2, ArrayList<k> arrayList) {
        for (d dVar : mVar.f2884h.f2858k) {
            if (dVar instanceof f) {
                a((f) dVar, i2, 0, mVar.f2885i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).f2884h, i2, 0, mVar.f2885i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.f2885i.f2858k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i2, 1, mVar.f2884h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).f2885i, i2, 1, mVar.f2884h, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (d dVar3 : ((l) mVar).f2876k.f2858k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(c.f.b.k.e eVar, e.b bVar, int i2, e.b bVar2, int i3) {
        b.a aVar = this.f2847h;
        aVar.a = bVar;
        aVar.f2830b = bVar2;
        aVar.f2831c = i2;
        aVar.f2832d = i3;
        this.f2846g.b(eVar, aVar);
        eVar.F0(this.f2847h.f2833e);
        eVar.i0(this.f2847h.f2834f);
        eVar.h0(this.f2847h.f2836h);
        eVar.c0(this.f2847h.f2835g);
    }

    public void c() {
        d(this.f2844e);
        this.f2848i.clear();
        k.a = 0;
        i(this.a.f2805f, 0, this.f2848i);
        i(this.a.f2806g, 1, this.f2848i);
        this.f2841b = false;
    }

    public void d(ArrayList<m> arrayList) {
        arrayList.clear();
        this.f2843d.f2805f.f();
        this.f2843d.f2806g.f();
        arrayList.add(this.f2843d.f2805f);
        arrayList.add(this.f2843d.f2806g);
        Iterator<c.f.b.k.e> it = this.f2843d.G0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            c.f.b.k.e next = it.next();
            if (next instanceof c.f.b.k.h) {
                arrayList.add(new h(next));
            } else {
                if (next.W()) {
                    if (next.f2803d == null) {
                        next.f2803d = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f2803d);
                } else {
                    arrayList.add(next.f2805f);
                }
                if (next.Y()) {
                    if (next.f2804e == null) {
                        next.f2804e = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f2804e);
                } else {
                    arrayList.add(next.f2806g);
                }
                if (next instanceof c.f.b.k.j) {
                    arrayList.add(new i(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<m> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<m> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            m next2 = it3.next();
            if (next2.f2878b != this.f2843d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.f2841b || this.f2842c) {
            Iterator<c.f.b.k.e> it = this.a.G0.iterator();
            while (it.hasNext()) {
                c.f.b.k.e next = it.next();
                next.f2801b = false;
                next.f2805f.r();
                next.f2806g.q();
            }
            c.f.b.k.f fVar = this.a;
            fVar.f2801b = false;
            fVar.f2805f.r();
            this.a.f2806g.q();
            this.f2842c = false;
        }
        if (b(this.f2843d)) {
            return false;
        }
        this.a.G0(0);
        this.a.H0(0);
        e.b t = this.a.t(0);
        e.b t2 = this.a.t(1);
        if (this.f2841b) {
            c();
        }
        int R = this.a.R();
        int S = this.a.S();
        this.a.f2805f.f2884h.d(R);
        this.a.f2806g.f2884h.d(S);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (t == bVar || t2 == bVar) {
            if (z4) {
                Iterator<m> it2 = this.f2844e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().m()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && t == e.b.WRAP_CONTENT) {
                this.a.m0(e.b.FIXED);
                c.f.b.k.f fVar2 = this.a;
                fVar2.F0(e(fVar2, 0));
                c.f.b.k.f fVar3 = this.a;
                fVar3.f2805f.f2881e.d(fVar3.Q());
            }
            if (z4 && t2 == e.b.WRAP_CONTENT) {
                this.a.B0(e.b.FIXED);
                c.f.b.k.f fVar4 = this.a;
                fVar4.i0(e(fVar4, 1));
                c.f.b.k.f fVar5 = this.a;
                fVar5.f2806g.f2881e.d(fVar5.w());
            }
        }
        c.f.b.k.f fVar6 = this.a;
        e.b[] bVarArr = fVar6.P;
        e.b bVar2 = bVarArr[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == e.b.MATCH_PARENT) {
            int Q = fVar6.Q() + R;
            this.a.f2805f.f2885i.d(Q);
            this.a.f2805f.f2881e.d(Q - R);
            m();
            c.f.b.k.f fVar7 = this.a;
            e.b[] bVarArr2 = fVar7.P;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == e.b.MATCH_PARENT) {
                int w = fVar7.w() + S;
                this.a.f2806g.f2885i.d(w);
                this.a.f2806g.f2881e.d(w - S);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<m> it3 = this.f2844e.iterator();
        while (it3.hasNext()) {
            m next2 = it3.next();
            if (next2.f2878b != this.a || next2.f2883g) {
                next2.e();
            }
        }
        Iterator<m> it4 = this.f2844e.iterator();
        while (it4.hasNext()) {
            m next3 = it4.next();
            if (z2 || next3.f2878b != this.a) {
                if (!next3.f2884h.f2857j || ((!next3.f2885i.f2857j && !(next3 instanceof h)) || (!next3.f2881e.f2857j && !(next3 instanceof c) && !(next3 instanceof h)))) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.m0(t);
        this.a.B0(t2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.f2841b) {
            Iterator<c.f.b.k.e> it = this.a.G0.iterator();
            while (it.hasNext()) {
                c.f.b.k.e next = it.next();
                next.f2801b = false;
                j jVar = next.f2805f;
                jVar.f2881e.f2857j = false;
                jVar.f2883g = false;
                jVar.r();
                l lVar = next.f2806g;
                lVar.f2881e.f2857j = false;
                lVar.f2883g = false;
                lVar.q();
            }
            c.f.b.k.f fVar = this.a;
            fVar.f2801b = false;
            j jVar2 = fVar.f2805f;
            jVar2.f2881e.f2857j = false;
            jVar2.f2883g = false;
            jVar2.r();
            l lVar2 = this.a.f2806g;
            lVar2.f2881e.f2857j = false;
            lVar2.f2883g = false;
            lVar2.q();
            c();
        }
        if (b(this.f2843d)) {
            return false;
        }
        this.a.G0(0);
        this.a.H0(0);
        this.a.f2805f.f2884h.d(0);
        this.a.f2806g.f2884h.d(0);
        return true;
    }

    public boolean h(boolean z, int i2) {
        boolean z2;
        e.b bVar;
        boolean z3 = true;
        boolean z4 = z & true;
        e.b t = this.a.t(0);
        e.b t2 = this.a.t(1);
        int R = this.a.R();
        int S = this.a.S();
        if (z4 && (t == (bVar = e.b.WRAP_CONTENT) || t2 == bVar)) {
            Iterator<m> it = this.f2844e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next.f2882f == i2 && !next.m()) {
                    z4 = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z4 && t == e.b.WRAP_CONTENT) {
                    this.a.m0(e.b.FIXED);
                    c.f.b.k.f fVar = this.a;
                    fVar.F0(e(fVar, 0));
                    c.f.b.k.f fVar2 = this.a;
                    fVar2.f2805f.f2881e.d(fVar2.Q());
                }
            } else if (z4 && t2 == e.b.WRAP_CONTENT) {
                this.a.B0(e.b.FIXED);
                c.f.b.k.f fVar3 = this.a;
                fVar3.i0(e(fVar3, 1));
                c.f.b.k.f fVar4 = this.a;
                fVar4.f2806g.f2881e.d(fVar4.w());
            }
        }
        if (i2 == 0) {
            c.f.b.k.f fVar5 = this.a;
            e.b[] bVarArr = fVar5.P;
            if (bVarArr[0] == e.b.FIXED || bVarArr[0] == e.b.MATCH_PARENT) {
                int Q = fVar5.Q() + R;
                this.a.f2805f.f2885i.d(Q);
                this.a.f2805f.f2881e.d(Q - R);
                z2 = true;
            }
            z2 = false;
        } else {
            c.f.b.k.f fVar6 = this.a;
            e.b[] bVarArr2 = fVar6.P;
            if (bVarArr2[1] == e.b.FIXED || bVarArr2[1] == e.b.MATCH_PARENT) {
                int w = fVar6.w() + S;
                this.a.f2806g.f2885i.d(w);
                this.a.f2806g.f2881e.d(w - S);
                z2 = true;
            }
            z2 = false;
        }
        m();
        Iterator<m> it2 = this.f2844e.iterator();
        while (it2.hasNext()) {
            m next2 = it2.next();
            if (next2.f2882f == i2 && (next2.f2878b != this.a || next2.f2883g)) {
                next2.e();
            }
        }
        Iterator<m> it3 = this.f2844e.iterator();
        while (it3.hasNext()) {
            m next3 = it3.next();
            if (next3.f2882f == i2 && (z2 || next3.f2878b != this.a)) {
                if (!next3.f2884h.f2857j || !next3.f2885i.f2857j || (!(next3 instanceof c) && !next3.f2881e.f2857j)) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.m0(t);
        this.a.B0(t2);
        return z3;
    }

    public void j() {
        this.f2841b = true;
    }

    public void k() {
        this.f2842c = true;
    }

    public void m() {
        g gVar;
        Iterator<c.f.b.k.e> it = this.a.G0.iterator();
        while (it.hasNext()) {
            c.f.b.k.e next = it.next();
            if (!next.f2801b) {
                e.b[] bVarArr = next.P;
                boolean z = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i2 = next.m;
                int i3 = next.n;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z2 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i2 == 1);
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                g gVar2 = next.f2805f.f2881e;
                boolean z3 = gVar2.f2857j;
                g gVar3 = next.f2806g.f2881e;
                boolean z4 = gVar3.f2857j;
                if (z3 && z4) {
                    e.b bVar4 = e.b.FIXED;
                    l(next, bVar4, gVar2.f2854g, bVar4, gVar3.f2854g);
                    next.f2801b = true;
                } else if (z3 && z) {
                    l(next, e.b.FIXED, gVar2.f2854g, bVar3, gVar3.f2854g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        next.f2806g.f2881e.m = next.w();
                    } else {
                        next.f2806g.f2881e.d(next.w());
                        next.f2801b = true;
                    }
                } else if (z4 && z2) {
                    l(next, bVar3, gVar2.f2854g, e.b.FIXED, gVar3.f2854g);
                    if (bVar == e.b.MATCH_CONSTRAINT) {
                        next.f2805f.f2881e.m = next.Q();
                    } else {
                        next.f2805f.f2881e.d(next.Q());
                        next.f2801b = true;
                    }
                }
                if (next.f2801b && (gVar = next.f2806g.f2877l) != null) {
                    gVar.d(next.o());
                }
            }
        }
    }

    public void n(b.InterfaceC0060b interfaceC0060b) {
        this.f2846g = interfaceC0060b;
    }
}
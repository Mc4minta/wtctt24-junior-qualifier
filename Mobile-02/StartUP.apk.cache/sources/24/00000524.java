package c.f.b.k.n;

import c.f.b.k.d;
import c.f.b.k.e;
import c.f.b.k.n.f;
import c.f.b.k.n.m;

/* compiled from: VerticalWidgetRun.java */
/* loaded from: classes.dex */
public class l extends m {

    /* renamed from: k  reason: collision with root package name */
    public f f2876k;

    /* renamed from: l  reason: collision with root package name */
    g f2877l;

    /* compiled from: VerticalWidgetRun.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[m.b.values().length];
            a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(c.f.b.k.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f2876k = fVar;
        this.f2877l = null;
        this.f2884h.f2852e = f.a.TOP;
        this.f2885i.f2852e = f.a.BOTTOM;
        fVar.f2852e = f.a.BASELINE;
        this.f2882f = 1;
    }

    @Override // c.f.b.k.n.m, c.f.b.k.n.d
    public void a(d dVar) {
        g gVar;
        float f2;
        float u;
        float f3;
        int i2;
        c.f.b.k.e eVar;
        int i3 = a.a[this.f2886j.ordinal()];
        if (i3 == 1) {
            p(dVar);
        } else if (i3 == 2) {
            o(dVar);
        } else if (i3 == 3) {
            c.f.b.k.e eVar2 = this.f2878b;
            n(dVar, eVar2.F, eVar2.H, 1);
            return;
        }
        g gVar2 = this.f2881e;
        if (gVar2.f2850c && !gVar2.f2857j && this.f2880d == e.b.MATCH_CONSTRAINT) {
            c.f.b.k.e eVar3 = this.f2878b;
            int i4 = eVar3.n;
            if (i4 != 2) {
                if (i4 == 3 && eVar3.f2805f.f2881e.f2857j) {
                    int v = eVar3.v();
                    if (v == -1) {
                        c.f.b.k.e eVar4 = this.f2878b;
                        f2 = eVar4.f2805f.f2881e.f2854g;
                        u = eVar4.u();
                    } else if (v == 0) {
                        f3 = eVar.f2805f.f2881e.f2854g * this.f2878b.u();
                        i2 = (int) (f3 + 0.5f);
                        this.f2881e.d(i2);
                    } else if (v == 1) {
                        c.f.b.k.e eVar5 = this.f2878b;
                        f2 = eVar5.f2805f.f2881e.f2854g;
                        u = eVar5.u();
                    } else {
                        i2 = 0;
                        this.f2881e.d(i2);
                    }
                    f3 = f2 / u;
                    i2 = (int) (f3 + 0.5f);
                    this.f2881e.d(i2);
                }
            } else {
                c.f.b.k.e H = eVar3.H();
                if (H != null) {
                    if (H.f2806g.f2881e.f2857j) {
                        this.f2881e.d((int) ((gVar.f2854g * this.f2878b.u) + 0.5f));
                    }
                }
            }
        }
        f fVar = this.f2884h;
        if (fVar.f2850c) {
            f fVar2 = this.f2885i;
            if (fVar2.f2850c) {
                if (fVar.f2857j && fVar2.f2857j && this.f2881e.f2857j) {
                    return;
                }
                if (!this.f2881e.f2857j && this.f2880d == e.b.MATCH_CONSTRAINT) {
                    c.f.b.k.e eVar6 = this.f2878b;
                    if (eVar6.m == 0 && !eVar6.Y()) {
                        int i5 = this.f2884h.f2859l.get(0).f2854g;
                        f fVar3 = this.f2884h;
                        int i6 = i5 + fVar3.f2853f;
                        int i7 = this.f2885i.f2859l.get(0).f2854g + this.f2885i.f2853f;
                        fVar3.d(i6);
                        this.f2885i.d(i7);
                        this.f2881e.d(i7 - i6);
                        return;
                    }
                }
                if (!this.f2881e.f2857j && this.f2880d == e.b.MATCH_CONSTRAINT && this.a == 1 && this.f2884h.f2859l.size() > 0 && this.f2885i.f2859l.size() > 0) {
                    int i8 = (this.f2885i.f2859l.get(0).f2854g + this.f2885i.f2853f) - (this.f2884h.f2859l.get(0).f2854g + this.f2884h.f2853f);
                    g gVar3 = this.f2881e;
                    int i9 = gVar3.m;
                    if (i8 < i9) {
                        gVar3.d(i8);
                    } else {
                        gVar3.d(i9);
                    }
                }
                if (this.f2881e.f2857j && this.f2884h.f2859l.size() > 0 && this.f2885i.f2859l.size() > 0) {
                    f fVar4 = this.f2884h.f2859l.get(0);
                    f fVar5 = this.f2885i.f2859l.get(0);
                    int i10 = fVar4.f2854g + this.f2884h.f2853f;
                    int i11 = fVar5.f2854g + this.f2885i.f2853f;
                    float L = this.f2878b.L();
                    if (fVar4 == fVar5) {
                        i10 = fVar4.f2854g;
                        i11 = fVar5.f2854g;
                        L = 0.5f;
                    }
                    this.f2884h.d((int) (i10 + 0.5f + (((i11 - i10) - this.f2881e.f2854g) * L)));
                    this.f2885i.d(this.f2884h.f2854g + this.f2881e.f2854g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void d() {
        c.f.b.k.e H;
        c.f.b.k.e H2;
        c.f.b.k.e eVar = this.f2878b;
        if (eVar.f2801b) {
            this.f2881e.d(eVar.w());
        }
        if (!this.f2881e.f2857j) {
            this.f2880d = this.f2878b.N();
            if (this.f2878b.T()) {
                this.f2877l = new c.f.b.k.n.a(this);
            }
            e.b bVar = this.f2880d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (H2 = this.f2878b.H()) != null && H2.N() == e.b.FIXED) {
                    int w = (H2.w() - this.f2878b.F.c()) - this.f2878b.H.c();
                    b(this.f2884h, H2.f2806g.f2884h, this.f2878b.F.c());
                    b(this.f2885i, H2.f2806g.f2885i, -this.f2878b.H.c());
                    this.f2881e.d(w);
                    return;
                } else if (this.f2880d == e.b.FIXED) {
                    this.f2881e.d(this.f2878b.w());
                }
            }
        } else if (this.f2880d == e.b.MATCH_PARENT && (H = this.f2878b.H()) != null && H.N() == e.b.FIXED) {
            b(this.f2884h, H.f2806g.f2884h, this.f2878b.F.c());
            b(this.f2885i, H.f2806g.f2885i, -this.f2878b.H.c());
            return;
        }
        g gVar = this.f2881e;
        boolean z = gVar.f2857j;
        if (z) {
            c.f.b.k.e eVar2 = this.f2878b;
            if (eVar2.f2801b) {
                c.f.b.k.d[] dVarArr = eVar2.M;
                if (dVarArr[2].f2788d != null && dVarArr[3].f2788d != null) {
                    if (eVar2.Y()) {
                        this.f2884h.f2853f = this.f2878b.M[2].c();
                        this.f2885i.f2853f = -this.f2878b.M[3].c();
                    } else {
                        f h2 = h(this.f2878b.M[2]);
                        if (h2 != null) {
                            b(this.f2884h, h2, this.f2878b.M[2].c());
                        }
                        f h3 = h(this.f2878b.M[3]);
                        if (h3 != null) {
                            b(this.f2885i, h3, -this.f2878b.M[3].c());
                        }
                        this.f2884h.f2849b = true;
                        this.f2885i.f2849b = true;
                    }
                    if (this.f2878b.T()) {
                        b(this.f2876k, this.f2884h, this.f2878b.o());
                        return;
                    }
                    return;
                } else if (dVarArr[2].f2788d != null) {
                    f h4 = h(dVarArr[2]);
                    if (h4 != null) {
                        b(this.f2884h, h4, this.f2878b.M[2].c());
                        b(this.f2885i, this.f2884h, this.f2881e.f2854g);
                        if (this.f2878b.T()) {
                            b(this.f2876k, this.f2884h, this.f2878b.o());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (dVarArr[3].f2788d != null) {
                    f h5 = h(dVarArr[3]);
                    if (h5 != null) {
                        b(this.f2885i, h5, -this.f2878b.M[3].c());
                        b(this.f2884h, this.f2885i, -this.f2881e.f2854g);
                    }
                    if (this.f2878b.T()) {
                        b(this.f2876k, this.f2884h, this.f2878b.o());
                        return;
                    }
                    return;
                } else if (dVarArr[4].f2788d != null) {
                    f h6 = h(dVarArr[4]);
                    if (h6 != null) {
                        b(this.f2876k, h6, 0);
                        b(this.f2884h, this.f2876k, -this.f2878b.o());
                        b(this.f2885i, this.f2884h, this.f2881e.f2854g);
                        return;
                    }
                    return;
                } else if ((eVar2 instanceof c.f.b.k.i) || eVar2.H() == null || this.f2878b.n(d.b.CENTER).f2788d != null) {
                    return;
                } else {
                    b(this.f2884h, this.f2878b.H().f2806g.f2884h, this.f2878b.S());
                    b(this.f2885i, this.f2884h, this.f2881e.f2854g);
                    if (this.f2878b.T()) {
                        b(this.f2876k, this.f2884h, this.f2878b.o());
                        return;
                    }
                    return;
                }
            }
        }
        if (!z && this.f2880d == e.b.MATCH_CONSTRAINT) {
            c.f.b.k.e eVar3 = this.f2878b;
            int i2 = eVar3.n;
            if (i2 != 2) {
                if (i2 == 3 && !eVar3.Y()) {
                    c.f.b.k.e eVar4 = this.f2878b;
                    if (eVar4.m != 3) {
                        g gVar2 = eVar4.f2805f.f2881e;
                        this.f2881e.f2859l.add(gVar2);
                        gVar2.f2858k.add(this.f2881e);
                        g gVar3 = this.f2881e;
                        gVar3.f2849b = true;
                        gVar3.f2858k.add(this.f2884h);
                        this.f2881e.f2858k.add(this.f2885i);
                    }
                }
            } else {
                c.f.b.k.e H3 = eVar3.H();
                if (H3 != null) {
                    g gVar4 = H3.f2806g.f2881e;
                    this.f2881e.f2859l.add(gVar4);
                    gVar4.f2858k.add(this.f2881e);
                    g gVar5 = this.f2881e;
                    gVar5.f2849b = true;
                    gVar5.f2858k.add(this.f2884h);
                    this.f2881e.f2858k.add(this.f2885i);
                }
            }
        } else {
            gVar.b(this);
        }
        c.f.b.k.e eVar5 = this.f2878b;
        c.f.b.k.d[] dVarArr2 = eVar5.M;
        if (dVarArr2[2].f2788d != null && dVarArr2[3].f2788d != null) {
            if (eVar5.Y()) {
                this.f2884h.f2853f = this.f2878b.M[2].c();
                this.f2885i.f2853f = -this.f2878b.M[3].c();
            } else {
                f h7 = h(this.f2878b.M[2]);
                f h8 = h(this.f2878b.M[3]);
                h7.b(this);
                h8.b(this);
                this.f2886j = m.b.CENTER;
            }
            if (this.f2878b.T()) {
                c(this.f2876k, this.f2884h, 1, this.f2877l);
            }
        } else if (dVarArr2[2].f2788d != null) {
            f h9 = h(dVarArr2[2]);
            if (h9 != null) {
                b(this.f2884h, h9, this.f2878b.M[2].c());
                c(this.f2885i, this.f2884h, 1, this.f2881e);
                if (this.f2878b.T()) {
                    c(this.f2876k, this.f2884h, 1, this.f2877l);
                }
                e.b bVar2 = this.f2880d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f2878b.u() > 0.0f) {
                    j jVar = this.f2878b.f2805f;
                    if (jVar.f2880d == bVar3) {
                        jVar.f2881e.f2858k.add(this.f2881e);
                        this.f2881e.f2859l.add(this.f2878b.f2805f.f2881e);
                        this.f2881e.a = this;
                    }
                }
            }
        } else if (dVarArr2[3].f2788d != null) {
            f h10 = h(dVarArr2[3]);
            if (h10 != null) {
                b(this.f2885i, h10, -this.f2878b.M[3].c());
                c(this.f2884h, this.f2885i, -1, this.f2881e);
                if (this.f2878b.T()) {
                    c(this.f2876k, this.f2884h, 1, this.f2877l);
                }
            }
        } else if (dVarArr2[4].f2788d != null) {
            f h11 = h(dVarArr2[4]);
            if (h11 != null) {
                b(this.f2876k, h11, 0);
                c(this.f2884h, this.f2876k, -1, this.f2877l);
                c(this.f2885i, this.f2884h, 1, this.f2881e);
            }
        } else if (!(eVar5 instanceof c.f.b.k.i) && eVar5.H() != null) {
            b(this.f2884h, this.f2878b.H().f2806g.f2884h, this.f2878b.S());
            c(this.f2885i, this.f2884h, 1, this.f2881e);
            if (this.f2878b.T()) {
                c(this.f2876k, this.f2884h, 1, this.f2877l);
            }
            e.b bVar4 = this.f2880d;
            e.b bVar5 = e.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar5 && this.f2878b.u() > 0.0f) {
                j jVar2 = this.f2878b.f2805f;
                if (jVar2.f2880d == bVar5) {
                    jVar2.f2881e.f2858k.add(this.f2881e);
                    this.f2881e.f2859l.add(this.f2878b.f2805f.f2881e);
                    this.f2881e.a = this;
                }
            }
        }
        if (this.f2881e.f2859l.size() == 0) {
            this.f2881e.f2850c = true;
        }
    }

    @Override // c.f.b.k.n.m
    public void e() {
        f fVar = this.f2884h;
        if (fVar.f2857j) {
            this.f2878b.H0(fVar.f2854g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void f() {
        this.f2879c = null;
        this.f2884h.c();
        this.f2885i.c();
        this.f2876k.c();
        this.f2881e.c();
        this.f2883g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public boolean m() {
        return this.f2880d != e.b.MATCH_CONSTRAINT || this.f2878b.n == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f2883g = false;
        this.f2884h.c();
        this.f2884h.f2857j = false;
        this.f2885i.c();
        this.f2885i.f2857j = false;
        this.f2876k.c();
        this.f2876k.f2857j = false;
        this.f2881e.f2857j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f2878b.s();
    }
}
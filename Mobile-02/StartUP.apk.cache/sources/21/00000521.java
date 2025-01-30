package c.f.b.k.n;

import c.f.b.k.d;
import c.f.b.k.e;
import c.f.b.k.n.f;
import c.f.b.k.n.m;

/* compiled from: HorizontalWidgetRun.java */
/* loaded from: classes.dex */
public class j extends m {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f2868k = new int[2];

    /* compiled from: HorizontalWidgetRun.java */
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

    public j(c.f.b.k.e eVar) {
        super(eVar);
        this.f2884h.f2852e = f.a.LEFT;
        this.f2885i.f2852e = f.a.RIGHT;
        this.f2882f = 0;
    }

    private void q(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 != -1) {
            if (i6 == 0) {
                iArr[0] = (int) ((i8 * f2) + 0.5f);
                iArr[1] = i8;
                return;
            } else if (i6 != 1) {
                return;
            } else {
                iArr[0] = i7;
                iArr[1] = (int) ((i7 * f2) + 0.5f);
                return;
            }
        }
        int i9 = (int) ((i8 * f2) + 0.5f);
        int i10 = (int) ((i7 / f2) + 0.5f);
        if (i9 <= i7 && i8 <= i8) {
            iArr[0] = i9;
            iArr[1] = i8;
        } else if (i7 > i7 || i10 > i8) {
        } else {
            iArr[0] = i7;
            iArr[1] = i10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x02b9, code lost:
        if (r14 != 1) goto L131;
     */
    @Override // c.f.b.k.n.m, c.f.b.k.n.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(c.f.b.k.n.d r17) {
        /*
            Method dump skipped, instructions count: 1087
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.k.n.j.a(c.f.b.k.n.d):void");
    }

    @Override // c.f.b.k.n.m
    void d() {
        c.f.b.k.e H;
        c.f.b.k.e H2;
        c.f.b.k.e eVar = this.f2878b;
        if (eVar.f2801b) {
            this.f2881e.d(eVar.Q());
        }
        if (!this.f2881e.f2857j) {
            e.b z = this.f2878b.z();
            this.f2880d = z;
            if (z != e.b.MATCH_CONSTRAINT) {
                e.b bVar = e.b.MATCH_PARENT;
                if (z == bVar && (((H2 = this.f2878b.H()) != null && H2.z() == e.b.FIXED) || H2.z() == bVar)) {
                    int Q = (H2.Q() - this.f2878b.E.c()) - this.f2878b.G.c();
                    b(this.f2884h, H2.f2805f.f2884h, this.f2878b.E.c());
                    b(this.f2885i, H2.f2805f.f2885i, -this.f2878b.G.c());
                    this.f2881e.d(Q);
                    return;
                } else if (this.f2880d == e.b.FIXED) {
                    this.f2881e.d(this.f2878b.Q());
                }
            }
        } else {
            e.b bVar2 = this.f2880d;
            e.b bVar3 = e.b.MATCH_PARENT;
            if (bVar2 == bVar3 && (((H = this.f2878b.H()) != null && H.z() == e.b.FIXED) || H.z() == bVar3)) {
                b(this.f2884h, H.f2805f.f2884h, this.f2878b.E.c());
                b(this.f2885i, H.f2805f.f2885i, -this.f2878b.G.c());
                return;
            }
        }
        g gVar = this.f2881e;
        if (gVar.f2857j) {
            c.f.b.k.e eVar2 = this.f2878b;
            if (eVar2.f2801b) {
                c.f.b.k.d[] dVarArr = eVar2.M;
                if (dVarArr[0].f2788d != null && dVarArr[1].f2788d != null) {
                    if (eVar2.W()) {
                        this.f2884h.f2853f = this.f2878b.M[0].c();
                        this.f2885i.f2853f = -this.f2878b.M[1].c();
                        return;
                    }
                    f h2 = h(this.f2878b.M[0]);
                    if (h2 != null) {
                        b(this.f2884h, h2, this.f2878b.M[0].c());
                    }
                    f h3 = h(this.f2878b.M[1]);
                    if (h3 != null) {
                        b(this.f2885i, h3, -this.f2878b.M[1].c());
                    }
                    this.f2884h.f2849b = true;
                    this.f2885i.f2849b = true;
                    return;
                } else if (dVarArr[0].f2788d != null) {
                    f h4 = h(dVarArr[0]);
                    if (h4 != null) {
                        b(this.f2884h, h4, this.f2878b.M[0].c());
                        b(this.f2885i, this.f2884h, this.f2881e.f2854g);
                        return;
                    }
                    return;
                } else if (dVarArr[1].f2788d != null) {
                    f h5 = h(dVarArr[1]);
                    if (h5 != null) {
                        b(this.f2885i, h5, -this.f2878b.M[1].c());
                        b(this.f2884h, this.f2885i, -this.f2881e.f2854g);
                        return;
                    }
                    return;
                } else if ((eVar2 instanceof c.f.b.k.i) || eVar2.H() == null || this.f2878b.n(d.b.CENTER).f2788d != null) {
                    return;
                } else {
                    b(this.f2884h, this.f2878b.H().f2805f.f2884h, this.f2878b.R());
                    b(this.f2885i, this.f2884h, this.f2881e.f2854g);
                    return;
                }
            }
        }
        if (this.f2880d == e.b.MATCH_CONSTRAINT) {
            c.f.b.k.e eVar3 = this.f2878b;
            int i2 = eVar3.m;
            if (i2 == 2) {
                c.f.b.k.e H3 = eVar3.H();
                if (H3 != null) {
                    g gVar2 = H3.f2806g.f2881e;
                    this.f2881e.f2859l.add(gVar2);
                    gVar2.f2858k.add(this.f2881e);
                    g gVar3 = this.f2881e;
                    gVar3.f2849b = true;
                    gVar3.f2858k.add(this.f2884h);
                    this.f2881e.f2858k.add(this.f2885i);
                }
            } else if (i2 == 3) {
                if (eVar3.n == 3) {
                    this.f2884h.a = this;
                    this.f2885i.a = this;
                    l lVar = eVar3.f2806g;
                    lVar.f2884h.a = this;
                    lVar.f2885i.a = this;
                    gVar.a = this;
                    if (eVar3.Y()) {
                        this.f2881e.f2859l.add(this.f2878b.f2806g.f2881e);
                        this.f2878b.f2806g.f2881e.f2858k.add(this.f2881e);
                        l lVar2 = this.f2878b.f2806g;
                        lVar2.f2881e.a = this;
                        this.f2881e.f2859l.add(lVar2.f2884h);
                        this.f2881e.f2859l.add(this.f2878b.f2806g.f2885i);
                        this.f2878b.f2806g.f2884h.f2858k.add(this.f2881e);
                        this.f2878b.f2806g.f2885i.f2858k.add(this.f2881e);
                    } else if (this.f2878b.W()) {
                        this.f2878b.f2806g.f2881e.f2859l.add(this.f2881e);
                        this.f2881e.f2858k.add(this.f2878b.f2806g.f2881e);
                    } else {
                        this.f2878b.f2806g.f2881e.f2859l.add(this.f2881e);
                    }
                } else {
                    g gVar4 = eVar3.f2806g.f2881e;
                    gVar.f2859l.add(gVar4);
                    gVar4.f2858k.add(this.f2881e);
                    this.f2878b.f2806g.f2884h.f2858k.add(this.f2881e);
                    this.f2878b.f2806g.f2885i.f2858k.add(this.f2881e);
                    g gVar5 = this.f2881e;
                    gVar5.f2849b = true;
                    gVar5.f2858k.add(this.f2884h);
                    this.f2881e.f2858k.add(this.f2885i);
                    this.f2884h.f2859l.add(this.f2881e);
                    this.f2885i.f2859l.add(this.f2881e);
                }
            }
        }
        c.f.b.k.e eVar4 = this.f2878b;
        c.f.b.k.d[] dVarArr2 = eVar4.M;
        if (dVarArr2[0].f2788d != null && dVarArr2[1].f2788d != null) {
            if (eVar4.W()) {
                this.f2884h.f2853f = this.f2878b.M[0].c();
                this.f2885i.f2853f = -this.f2878b.M[1].c();
                return;
            }
            f h6 = h(this.f2878b.M[0]);
            f h7 = h(this.f2878b.M[1]);
            h6.b(this);
            h7.b(this);
            this.f2886j = m.b.CENTER;
        } else if (dVarArr2[0].f2788d != null) {
            f h8 = h(dVarArr2[0]);
            if (h8 != null) {
                b(this.f2884h, h8, this.f2878b.M[0].c());
                c(this.f2885i, this.f2884h, 1, this.f2881e);
            }
        } else if (dVarArr2[1].f2788d != null) {
            f h9 = h(dVarArr2[1]);
            if (h9 != null) {
                b(this.f2885i, h9, -this.f2878b.M[1].c());
                c(this.f2884h, this.f2885i, -1, this.f2881e);
            }
        } else if ((eVar4 instanceof c.f.b.k.i) || eVar4.H() == null) {
        } else {
            b(this.f2884h, this.f2878b.H().f2805f.f2884h, this.f2878b.R());
            c(this.f2885i, this.f2884h, 1, this.f2881e);
        }
    }

    @Override // c.f.b.k.n.m
    public void e() {
        f fVar = this.f2884h;
        if (fVar.f2857j) {
            this.f2878b.G0(fVar.f2854g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void f() {
        this.f2879c = null;
        this.f2884h.c();
        this.f2885i.c();
        this.f2881e.c();
        this.f2883g = false;
    }

    @Override // c.f.b.k.n.m
    boolean m() {
        return this.f2880d != e.b.MATCH_CONSTRAINT || this.f2878b.m == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f2883g = false;
        this.f2884h.c();
        this.f2884h.f2857j = false;
        this.f2885i.c();
        this.f2885i.f2857j = false;
        this.f2881e.f2857j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f2878b.s();
    }
}
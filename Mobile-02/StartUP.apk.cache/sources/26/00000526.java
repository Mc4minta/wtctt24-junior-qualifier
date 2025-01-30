package c.f.b.k.n;

import c.f.b.k.d;
import c.f.b.k.e;

/* compiled from: WidgetRun.java */
/* loaded from: classes.dex */
public abstract class m implements d {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    c.f.b.k.e f2878b;

    /* renamed from: c  reason: collision with root package name */
    k f2879c;

    /* renamed from: d  reason: collision with root package name */
    protected e.b f2880d;

    /* renamed from: e  reason: collision with root package name */
    g f2881e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f2882f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f2883g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f2884h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f2885i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    protected b f2886j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: WidgetRun.java */
    /* loaded from: classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(c.f.b.k.e eVar) {
        this.f2878b = eVar;
    }

    private void l(int i2, int i3) {
        int i4;
        int i5 = this.a;
        if (i5 == 0) {
            this.f2881e.d(g(i3, i2));
        } else if (i5 == 1) {
            this.f2881e.d(Math.min(g(this.f2881e.m, i2), i3));
        } else if (i5 == 2) {
            c.f.b.k.e H = this.f2878b.H();
            if (H != null) {
                g gVar = (i2 == 0 ? H.f2805f : H.f2806g).f2881e;
                if (gVar.f2857j) {
                    c.f.b.k.e eVar = this.f2878b;
                    this.f2881e.d(g((int) ((gVar.f2854g * (i2 == 0 ? eVar.r : eVar.u)) + 0.5f), i2));
                }
            }
        } else if (i5 != 3) {
        } else {
            c.f.b.k.e eVar2 = this.f2878b;
            m mVar = eVar2.f2805f;
            e.b bVar = mVar.f2880d;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && mVar.a == 3) {
                l lVar = eVar2.f2806g;
                if (lVar.f2880d == bVar2 && lVar.a == 3) {
                    return;
                }
            }
            if (i2 == 0) {
                mVar = eVar2.f2806g;
            }
            if (mVar.f2881e.f2857j) {
                float u = eVar2.u();
                if (i2 == 1) {
                    i4 = (int) ((mVar.f2881e.f2854g / u) + 0.5f);
                } else {
                    i4 = (int) ((u * mVar.f2881e.f2854g) + 0.5f);
                }
                this.f2881e.d(i4);
            }
        }
    }

    @Override // c.f.b.k.n.d
    public void a(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i2) {
        fVar.f2859l.add(fVar2);
        fVar.f2853f = i2;
        fVar2.f2858k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.f2859l.add(fVar2);
        fVar.f2859l.add(this.f2881e);
        fVar.f2855h = i2;
        fVar.f2856i = gVar;
        fVar2.f2858k.add(fVar);
        gVar.f2858k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i2, int i3) {
        int max;
        if (i3 == 0) {
            c.f.b.k.e eVar = this.f2878b;
            int i4 = eVar.q;
            max = Math.max(eVar.p, i2);
            if (i4 > 0) {
                max = Math.min(i4, i2);
            }
            if (max == i2) {
                return i2;
            }
        } else {
            c.f.b.k.e eVar2 = this.f2878b;
            int i5 = eVar2.t;
            max = Math.max(eVar2.s, i2);
            if (i5 > 0) {
                max = Math.min(i5, i2);
            }
            if (max == i2) {
                return i2;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(c.f.b.k.d dVar) {
        c.f.b.k.d dVar2 = dVar.f2788d;
        if (dVar2 == null) {
            return null;
        }
        c.f.b.k.e eVar = dVar2.f2786b;
        int i2 = a.a[dVar2.f2787c.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return eVar.f2806g.f2885i;
                    }
                    return eVar.f2806g.f2876k;
                }
                return eVar.f2806g.f2884h;
            }
            return eVar.f2805f.f2885i;
        }
        return eVar.f2805f.f2884h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(c.f.b.k.d dVar, int i2) {
        c.f.b.k.d dVar2 = dVar.f2788d;
        if (dVar2 == null) {
            return null;
        }
        c.f.b.k.e eVar = dVar2.f2786b;
        m mVar = i2 == 0 ? eVar.f2805f : eVar.f2806g;
        int i3 = a.a[dVar2.f2787c.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f2885i;
        }
        return mVar.f2884h;
    }

    public long j() {
        g gVar = this.f2881e;
        if (gVar.f2857j) {
            return gVar.f2854g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f2883g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, c.f.b.k.d dVar2, c.f.b.k.d dVar3, int i2) {
        f h2 = h(dVar2);
        f h3 = h(dVar3);
        if (h2.f2857j && h3.f2857j) {
            int c2 = h2.f2854g + dVar2.c();
            int c3 = h3.f2854g - dVar3.c();
            int i3 = c3 - c2;
            if (!this.f2881e.f2857j && this.f2880d == e.b.MATCH_CONSTRAINT) {
                l(i2, i3);
            }
            g gVar = this.f2881e;
            if (gVar.f2857j) {
                if (gVar.f2854g == i3) {
                    this.f2884h.d(c2);
                    this.f2885i.d(c3);
                    return;
                }
                c.f.b.k.e eVar = this.f2878b;
                float x = i2 == 0 ? eVar.x() : eVar.L();
                if (h2 == h3) {
                    c2 = h2.f2854g;
                    c3 = h3.f2854g;
                    x = 0.5f;
                }
                this.f2884h.d((int) (c2 + 0.5f + (((c3 - c2) - this.f2881e.f2854g) * x)));
                this.f2885i.d(this.f2884h.f2854g + this.f2881e.f2854g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
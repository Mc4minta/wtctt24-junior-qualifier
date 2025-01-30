package c.f.b.k;

import c.f.b.k.e;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class c {
    protected e a;

    /* renamed from: b  reason: collision with root package name */
    protected e f2775b;

    /* renamed from: c  reason: collision with root package name */
    protected e f2776c;

    /* renamed from: d  reason: collision with root package name */
    protected e f2777d;

    /* renamed from: e  reason: collision with root package name */
    protected e f2778e;

    /* renamed from: f  reason: collision with root package name */
    protected e f2779f;

    /* renamed from: g  reason: collision with root package name */
    protected e f2780g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<e> f2781h;

    /* renamed from: i  reason: collision with root package name */
    protected int f2782i;

    /* renamed from: j  reason: collision with root package name */
    protected int f2783j;

    /* renamed from: k  reason: collision with root package name */
    protected float f2784k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f2785l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public c(e eVar, int i2, boolean z) {
        this.q = false;
        this.a = eVar;
        this.p = i2;
        this.q = z;
    }

    private void b() {
        int i2 = this.p * 2;
        e eVar = this.a;
        boolean z = true;
        this.o = true;
        e eVar2 = eVar;
        boolean z2 = false;
        while (!z2) {
            this.f2782i++;
            e[] eVarArr = eVar.D0;
            int i3 = this.p;
            e eVar3 = null;
            eVarArr[i3] = null;
            eVar.C0[i3] = null;
            if (eVar.P() != 8) {
                this.f2785l++;
                e.b t = eVar.t(this.p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (t != bVar) {
                    this.m += eVar.B(this.p);
                }
                int c2 = this.m + eVar.M[i2].c();
                this.m = c2;
                int i4 = i2 + 1;
                this.m = c2 + eVar.M[i4].c();
                int c3 = this.n + eVar.M[i2].c();
                this.n = c3;
                this.n = c3 + eVar.M[i4].c();
                if (this.f2775b == null) {
                    this.f2775b = eVar;
                }
                this.f2777d = eVar;
                e.b[] bVarArr = eVar.P;
                int i5 = this.p;
                if (bVarArr[i5] == bVar) {
                    int[] iArr = eVar.o;
                    if (iArr[i5] == 0 || iArr[i5] == 3 || iArr[i5] == 2) {
                        this.f2783j++;
                        float[] fArr = eVar.B0;
                        float f2 = fArr[i5];
                        if (f2 > 0.0f) {
                            this.f2784k += fArr[i5];
                        }
                        if (c(eVar, i5)) {
                            if (f2 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.f2781h == null) {
                                this.f2781h = new ArrayList<>();
                            }
                            this.f2781h.add(eVar);
                        }
                        if (this.f2779f == null) {
                            this.f2779f = eVar;
                        }
                        e eVar4 = this.f2780g;
                        if (eVar4 != null) {
                            eVar4.C0[this.p] = eVar;
                        }
                        this.f2780g = eVar;
                    }
                    if (this.p == 0) {
                        if (eVar.m != 0) {
                            this.o = false;
                        } else if (eVar.p != 0 || eVar.q != 0) {
                            this.o = false;
                        }
                    } else if (eVar.n != 0) {
                        this.o = false;
                    } else if (eVar.s != 0 || eVar.t != 0) {
                        this.o = false;
                    }
                    if (eVar.T != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.D0[this.p] = eVar;
            }
            d dVar = eVar.M[i2 + 1].f2788d;
            if (dVar != null) {
                e eVar5 = dVar.f2786b;
                d[] dVarArr = eVar5.M;
                if (dVarArr[i2].f2788d != null && dVarArr[i2].f2788d.f2786b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z2 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f2775b;
        if (eVar6 != null) {
            this.m -= eVar6.M[i2].c();
        }
        e eVar7 = this.f2777d;
        if (eVar7 != null) {
            this.m -= eVar7.M[i2 + 1].c();
        }
        this.f2776c = eVar;
        if (this.p == 0 && this.q) {
            this.f2778e = eVar;
        } else {
            this.f2778e = this.a;
        }
        if (!this.s || !this.r) {
            z = false;
        }
        this.t = z;
    }

    private static boolean c(e eVar, int i2) {
        if (eVar.P() != 8 && eVar.P[i2] == e.b.MATCH_CONSTRAINT) {
            int[] iArr = eVar.o;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
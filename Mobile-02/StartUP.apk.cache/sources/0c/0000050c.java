package c.f.b.k;

import c.f.b.k.e;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Flow.java */
/* loaded from: classes.dex */
public class g extends l {
    private e[] s1;
    private int V0 = -1;
    private int W0 = -1;
    private int X0 = -1;
    private int Y0 = -1;
    private int Z0 = -1;
    private int a1 = -1;
    private float b1 = 0.5f;
    private float c1 = 0.5f;
    private float d1 = 0.5f;
    private float e1 = 0.5f;
    private float f1 = 0.5f;
    private float g1 = 0.5f;
    private int h1 = 0;
    private int i1 = 0;
    private int j1 = 2;
    private int k1 = 2;
    private int l1 = 0;
    private int m1 = -1;
    private int n1 = 0;
    private ArrayList<a> o1 = new ArrayList<>();
    private e[] p1 = null;
    private e[] q1 = null;
    private int[] r1 = null;
    private int t1 = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Flow.java */
    /* loaded from: classes.dex */
    public class a {
        private int a;

        /* renamed from: d  reason: collision with root package name */
        private d f2819d;

        /* renamed from: e  reason: collision with root package name */
        private d f2820e;

        /* renamed from: f  reason: collision with root package name */
        private d f2821f;

        /* renamed from: g  reason: collision with root package name */
        private d f2822g;

        /* renamed from: h  reason: collision with root package name */
        private int f2823h;

        /* renamed from: i  reason: collision with root package name */
        private int f2824i;

        /* renamed from: j  reason: collision with root package name */
        private int f2825j;

        /* renamed from: k  reason: collision with root package name */
        private int f2826k;
        private int q;

        /* renamed from: b  reason: collision with root package name */
        private e f2817b = null;

        /* renamed from: c  reason: collision with root package name */
        int f2818c = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f2827l = 0;
        private int m = 0;
        private int n = 0;
        private int o = 0;
        private int p = 0;

        public a(int i2, d dVar, d dVar2, d dVar3, d dVar4, int i3) {
            this.a = 0;
            this.f2823h = 0;
            this.f2824i = 0;
            this.f2825j = 0;
            this.f2826k = 0;
            this.q = 0;
            this.a = i2;
            this.f2819d = dVar;
            this.f2820e = dVar2;
            this.f2821f = dVar3;
            this.f2822g = dVar4;
            this.f2823h = g.this.Q0();
            this.f2824i = g.this.S0();
            this.f2825j = g.this.R0();
            this.f2826k = g.this.P0();
            this.q = i3;
        }

        private void h() {
            this.f2827l = 0;
            this.m = 0;
            this.f2817b = null;
            this.f2818c = 0;
            int i2 = this.o;
            for (int i3 = 0; i3 < i2 && this.n + i3 < g.this.t1; i3++) {
                e eVar = g.this.s1[this.n + i3];
                if (this.a != 0) {
                    int C1 = g.this.C1(eVar, this.q);
                    int B1 = g.this.B1(eVar, this.q);
                    int i4 = g.this.i1;
                    if (eVar.P() == 8) {
                        i4 = 0;
                    }
                    this.m += B1 + i4;
                    if (this.f2817b == null || this.f2818c < C1) {
                        this.f2817b = eVar;
                        this.f2818c = C1;
                        this.f2827l = C1;
                    }
                } else {
                    int Q = eVar.Q();
                    int i5 = g.this.h1;
                    if (eVar.P() == 8) {
                        i5 = 0;
                    }
                    this.f2827l += Q + i5;
                    int B12 = g.this.B1(eVar, this.q);
                    if (this.f2817b == null || this.f2818c < B12) {
                        this.f2817b = eVar;
                        this.f2818c = B12;
                        this.m = B12;
                    }
                }
            }
        }

        public void b(e eVar) {
            if (this.a == 0) {
                int C1 = g.this.C1(eVar, this.q);
                if (eVar.z() == e.b.MATCH_CONSTRAINT) {
                    this.p++;
                    C1 = 0;
                }
                this.f2827l += C1 + (eVar.P() != 8 ? g.this.h1 : 0);
                int B1 = g.this.B1(eVar, this.q);
                if (this.f2817b == null || this.f2818c < B1) {
                    this.f2817b = eVar;
                    this.f2818c = B1;
                    this.m = B1;
                }
            } else {
                int C12 = g.this.C1(eVar, this.q);
                int B12 = g.this.B1(eVar, this.q);
                if (eVar.N() == e.b.MATCH_CONSTRAINT) {
                    this.p++;
                    B12 = 0;
                }
                this.m += B12 + (eVar.P() != 8 ? g.this.i1 : 0);
                if (this.f2817b == null || this.f2818c < C12) {
                    this.f2817b = eVar;
                    this.f2818c = C12;
                    this.f2827l = C12;
                }
            }
            this.o++;
        }

        public void c() {
            this.f2818c = 0;
            this.f2817b = null;
            this.f2827l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }

        public void d(boolean z, int i2, boolean z2) {
            e eVar;
            char c2;
            int i3 = this.o;
            for (int i4 = 0; i4 < i3 && this.n + i4 < g.this.t1; i4++) {
                e eVar2 = g.this.s1[this.n + i4];
                if (eVar2 != null) {
                    eVar2.a0();
                }
            }
            if (i3 == 0 || this.f2817b == null) {
                return;
            }
            boolean z3 = z2 && i2 == 0;
            int i5 = -1;
            int i6 = -1;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = z ? (i3 - 1) - i7 : i7;
                if (this.n + i8 >= g.this.t1) {
                    break;
                }
                if (g.this.s1[this.n + i8].P() == 0) {
                    if (i5 == -1) {
                        i5 = i7;
                    }
                    i6 = i7;
                }
            }
            e eVar3 = null;
            if (this.a == 0) {
                e eVar4 = this.f2817b;
                eVar4.z0(g.this.W0);
                int i9 = this.f2824i;
                if (i2 > 0) {
                    i9 += g.this.i1;
                }
                eVar4.F.a(this.f2820e, i9);
                if (z2) {
                    eVar4.H.a(this.f2822g, this.f2826k);
                }
                if (i2 > 0) {
                    this.f2820e.f2786b.H.a(eVar4.F, 0);
                }
                if (g.this.k1 == 3 && !eVar4.T()) {
                    for (int i10 = 0; i10 < i3; i10++) {
                        int i11 = z ? (i3 - 1) - i10 : i10;
                        if (this.n + i11 >= g.this.t1) {
                            break;
                        }
                        eVar = g.this.s1[this.n + i11];
                        if (eVar.T()) {
                            break;
                        }
                    }
                }
                eVar = eVar4;
                int i12 = 0;
                while (i12 < i3) {
                    int i13 = z ? (i3 - 1) - i12 : i12;
                    if (this.n + i13 >= g.this.t1) {
                        return;
                    }
                    e eVar5 = g.this.s1[this.n + i13];
                    if (i12 == 0) {
                        eVar5.j(eVar5.E, this.f2819d, this.f2823h);
                    }
                    if (i13 == 0) {
                        int i14 = g.this.V0;
                        float f2 = g.this.b1;
                        if (this.n != 0 || g.this.X0 == -1) {
                            if (z2 && g.this.Z0 != -1) {
                                i14 = g.this.Z0;
                                f2 = g.this.f1;
                            }
                        } else {
                            i14 = g.this.X0;
                            f2 = g.this.d1;
                        }
                        eVar5.k0(i14);
                        eVar5.j0(f2);
                    }
                    if (i12 == i3 - 1) {
                        eVar5.j(eVar5.G, this.f2821f, this.f2825j);
                    }
                    if (eVar3 != null) {
                        eVar5.E.a(eVar3.G, g.this.h1);
                        if (i12 == i5) {
                            eVar5.E.n(this.f2823h);
                        }
                        eVar3.G.a(eVar5.E, 0);
                        if (i12 == i6 + 1) {
                            eVar3.G.n(this.f2825j);
                        }
                    }
                    if (eVar5 != eVar4) {
                        c2 = 3;
                        if (g.this.k1 != 3 || !eVar.T() || eVar5 == eVar || !eVar5.T()) {
                            int i15 = g.this.k1;
                            if (i15 == 0) {
                                eVar5.F.a(eVar4.F, 0);
                            } else if (i15 == 1) {
                                eVar5.H.a(eVar4.H, 0);
                            } else if (z3) {
                                eVar5.F.a(this.f2820e, this.f2824i);
                                eVar5.H.a(this.f2822g, this.f2826k);
                            } else {
                                eVar5.F.a(eVar4.F, 0);
                                eVar5.H.a(eVar4.H, 0);
                            }
                        } else {
                            eVar5.I.a(eVar.I, 0);
                        }
                    } else {
                        c2 = 3;
                    }
                    i12++;
                    eVar3 = eVar5;
                }
                return;
            }
            e eVar6 = this.f2817b;
            eVar6.k0(g.this.V0);
            int i16 = this.f2823h;
            if (i2 > 0) {
                i16 += g.this.h1;
            }
            if (z) {
                eVar6.G.a(this.f2821f, i16);
                if (z2) {
                    eVar6.E.a(this.f2819d, this.f2825j);
                }
                if (i2 > 0) {
                    this.f2821f.f2786b.E.a(eVar6.G, 0);
                }
            } else {
                eVar6.E.a(this.f2819d, i16);
                if (z2) {
                    eVar6.G.a(this.f2821f, this.f2825j);
                }
                if (i2 > 0) {
                    this.f2819d.f2786b.G.a(eVar6.E, 0);
                }
            }
            int i17 = 0;
            while (i17 < i3 && this.n + i17 < g.this.t1) {
                e eVar7 = g.this.s1[this.n + i17];
                if (i17 == 0) {
                    eVar7.j(eVar7.F, this.f2820e, this.f2824i);
                    int i18 = g.this.W0;
                    float f3 = g.this.c1;
                    if (this.n != 0 || g.this.Y0 == -1) {
                        if (z2 && g.this.a1 != -1) {
                            i18 = g.this.a1;
                            f3 = g.this.g1;
                        }
                    } else {
                        i18 = g.this.Y0;
                        f3 = g.this.e1;
                    }
                    eVar7.z0(i18);
                    eVar7.y0(f3);
                }
                if (i17 == i3 - 1) {
                    eVar7.j(eVar7.H, this.f2822g, this.f2826k);
                }
                if (eVar3 != null) {
                    eVar7.F.a(eVar3.H, g.this.i1);
                    if (i17 == i5) {
                        eVar7.F.n(this.f2824i);
                    }
                    eVar3.H.a(eVar7.F, 0);
                    if (i17 == i6 + 1) {
                        eVar3.H.n(this.f2826k);
                    }
                }
                if (eVar7 != eVar6) {
                    if (z) {
                        int i19 = g.this.j1;
                        if (i19 == 0) {
                            eVar7.G.a(eVar6.G, 0);
                        } else if (i19 == 1) {
                            eVar7.E.a(eVar6.E, 0);
                        } else if (i19 == 2) {
                            eVar7.E.a(eVar6.E, 0);
                            eVar7.G.a(eVar6.G, 0);
                        }
                    } else {
                        int i20 = g.this.j1;
                        if (i20 == 0) {
                            eVar7.E.a(eVar6.E, 0);
                        } else if (i20 == 1) {
                            eVar7.G.a(eVar6.G, 0);
                        } else if (i20 == 2) {
                            if (z3) {
                                eVar7.E.a(this.f2819d, this.f2823h);
                                eVar7.G.a(this.f2821f, this.f2825j);
                            } else {
                                eVar7.E.a(eVar6.E, 0);
                                eVar7.G.a(eVar6.G, 0);
                            }
                        }
                        i17++;
                        eVar3 = eVar7;
                    }
                }
                i17++;
                eVar3 = eVar7;
            }
        }

        public int e() {
            if (this.a == 1) {
                return this.m - g.this.i1;
            }
            return this.m;
        }

        public int f() {
            if (this.a == 0) {
                return this.f2827l - g.this.h1;
            }
            return this.f2827l;
        }

        public void g(int i2) {
            int i3 = this.p;
            if (i3 == 0) {
                return;
            }
            int i4 = this.o;
            int i5 = i2 / i3;
            for (int i6 = 0; i6 < i4 && this.n + i6 < g.this.t1; i6++) {
                e eVar = g.this.s1[this.n + i6];
                if (this.a == 0) {
                    if (eVar != null && eVar.z() == e.b.MATCH_CONSTRAINT && eVar.m == 0) {
                        g.this.U0(eVar, e.b.FIXED, i5, eVar.N(), eVar.w());
                    }
                } else if (eVar != null && eVar.N() == e.b.MATCH_CONSTRAINT && eVar.n == 0) {
                    g.this.U0(eVar, eVar.z(), eVar.Q(), e.b.FIXED, i5);
                }
            }
            h();
        }

        public void i(int i2) {
            this.n = i2;
        }

        public void j(int i2, d dVar, d dVar2, d dVar3, d dVar4, int i3, int i4, int i5, int i6, int i7) {
            this.a = i2;
            this.f2819d = dVar;
            this.f2820e = dVar2;
            this.f2821f = dVar3;
            this.f2822g = dVar4;
            this.f2823h = i3;
            this.f2824i = i4;
            this.f2825j = i5;
            this.f2826k = i6;
            this.q = i7;
        }
    }

    private void A1(boolean z) {
        e eVar;
        if (this.r1 == null || this.q1 == null || this.p1 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t1; i2++) {
            this.s1[i2].a0();
        }
        int[] iArr = this.r1;
        int i3 = iArr[0];
        int i4 = iArr[1];
        e eVar2 = null;
        for (int i5 = 0; i5 < i3; i5++) {
            e eVar3 = this.q1[z ? (i3 - i5) - 1 : i5];
            if (eVar3 != null && eVar3.P() != 8) {
                if (i5 == 0) {
                    eVar3.j(eVar3.E, this.E, Q0());
                    eVar3.k0(this.V0);
                    eVar3.j0(this.b1);
                }
                if (i5 == i3 - 1) {
                    eVar3.j(eVar3.G, this.G, R0());
                }
                if (i5 > 0) {
                    eVar3.j(eVar3.E, eVar2.G, this.h1);
                    eVar2.j(eVar2.G, eVar3.E, 0);
                }
                eVar2 = eVar3;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            e eVar4 = this.p1[i6];
            if (eVar4 != null && eVar4.P() != 8) {
                if (i6 == 0) {
                    eVar4.j(eVar4.F, this.F, S0());
                    eVar4.z0(this.W0);
                    eVar4.y0(this.c1);
                }
                if (i6 == i4 - 1) {
                    eVar4.j(eVar4.H, this.H, P0());
                }
                if (i6 > 0) {
                    eVar4.j(eVar4.F, eVar2.H, this.i1);
                    eVar2.j(eVar2.H, eVar4.F, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.n1 == 1) {
                    i9 = (i7 * i4) + i8;
                }
                e[] eVarArr = this.s1;
                if (i9 < eVarArr.length && (eVar = eVarArr[i9]) != null && eVar.P() != 8) {
                    e eVar5 = this.q1[i7];
                    e eVar6 = this.p1[i8];
                    if (eVar != eVar5) {
                        eVar.j(eVar.E, eVar5.E, 0);
                        eVar.j(eVar.G, eVar5.G, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.j(eVar.F, eVar6.F, 0);
                        eVar.j(eVar.H, eVar6.H, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B1(e eVar, int i2) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.N() == e.b.MATCH_CONSTRAINT) {
            int i3 = eVar.n;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (eVar.u * i2);
                if (i4 != eVar.w()) {
                    U0(eVar, eVar.z(), eVar.Q(), e.b.FIXED, i4);
                }
                return i4;
            } else if (i3 == 1) {
                return eVar.w();
            } else {
                if (i3 == 3) {
                    return (int) ((eVar.Q() * eVar.T) + 0.5f);
                }
            }
        }
        return eVar.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C1(e eVar, int i2) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.z() == e.b.MATCH_CONSTRAINT) {
            int i3 = eVar.m;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (eVar.r * i2);
                if (i4 != eVar.Q()) {
                    U0(eVar, e.b.FIXED, i4, eVar.N(), eVar.w());
                }
                return i4;
            } else if (i3 == 1) {
                return eVar.Q();
            } else {
                if (i3 == 3) {
                    return (int) ((eVar.w() * eVar.T) + 0.5f);
                }
            }
        }
        return eVar.Q();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x011b -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x011d -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0123 -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0125 -> B:42:0x0063). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D1(c.f.b.k.e[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.k.g.D1(c.f.b.k.e[], int, int, int, int[]):void");
    }

    private void E1(e[] eVarArr, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7;
        d dVar;
        int R0;
        d dVar2;
        int P0;
        int i8;
        if (i2 == 0) {
            return;
        }
        this.o1.clear();
        a aVar = new a(i3, this.E, this.F, this.G, this.H, i4);
        this.o1.add(aVar);
        if (i3 == 0) {
            i5 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i2) {
                e eVar = eVarArr[i10];
                int C1 = C1(eVar, i4);
                if (eVar.z() == e.b.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i11 = i5;
                boolean z = (i9 == i4 || (this.h1 + i9) + C1 > i4) && aVar.f2817b != null;
                if (!z && i10 > 0 && (i8 = this.m1) > 0 && i10 % i8 == 0) {
                    z = true;
                }
                if (z) {
                    aVar = new a(i3, this.E, this.F, this.G, this.H, i4);
                    aVar.i(i10);
                    this.o1.add(aVar);
                } else if (i10 > 0) {
                    i9 += this.h1 + C1;
                    aVar.b(eVar);
                    i10++;
                    i5 = i11;
                }
                i9 = C1;
                aVar.b(eVar);
                i10++;
                i5 = i11;
            }
        } else {
            i5 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i2) {
                e eVar2 = eVarArr[i13];
                int B1 = B1(eVar2, i4);
                if (eVar2.N() == e.b.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i14 = i5;
                boolean z2 = (i12 == i4 || (this.i1 + i12) + B1 > i4) && aVar.f2817b != null;
                if (!z2 && i13 > 0 && (i6 = this.m1) > 0 && i13 % i6 == 0) {
                    z2 = true;
                }
                if (z2) {
                    aVar = new a(i3, this.E, this.F, this.G, this.H, i4);
                    aVar.i(i13);
                    this.o1.add(aVar);
                } else if (i13 > 0) {
                    i12 += this.i1 + B1;
                    aVar.b(eVar2);
                    i13++;
                    i5 = i14;
                }
                i12 = B1;
                aVar.b(eVar2);
                i13++;
                i5 = i14;
            }
        }
        int size = this.o1.size();
        d dVar3 = this.E;
        d dVar4 = this.F;
        d dVar5 = this.G;
        d dVar6 = this.H;
        int Q0 = Q0();
        int S0 = S0();
        int R02 = R0();
        int P02 = P0();
        e.b z3 = z();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z4 = z3 == bVar || N() == bVar;
        if (i5 > 0 && z4) {
            for (int i15 = 0; i15 < size; i15++) {
                a aVar2 = this.o1.get(i15);
                if (i3 == 0) {
                    aVar2.g(i4 - aVar2.f());
                } else {
                    aVar2.g(i4 - aVar2.e());
                }
            }
        }
        int i16 = S0;
        int i17 = R02;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = Q0;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i22 = P02;
        while (i20 < size) {
            a aVar3 = this.o1.get(i20);
            if (i3 == 0) {
                if (i20 < size - 1) {
                    dVar2 = this.o1.get(i20 + 1).f2817b.F;
                    P0 = 0;
                } else {
                    dVar2 = this.H;
                    P0 = P0();
                }
                d dVar9 = aVar3.f2817b.H;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i23 = i18;
                d dVar12 = dVar7;
                int i24 = i19;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i7 = i20;
                aVar3.j(i3, dVar10, dVar12, dVar13, dVar2, i21, i16, i17, P0, i4);
                int max = Math.max(i24, aVar3.f());
                i18 = i23 + aVar3.e();
                if (i7 > 0) {
                    i18 += this.i1;
                }
                dVar8 = dVar11;
                i19 = max;
                i16 = 0;
                dVar7 = dVar9;
                dVar = dVar14;
                int i25 = P0;
                dVar6 = dVar2;
                i22 = i25;
            } else {
                d dVar15 = dVar8;
                int i26 = i18;
                int i27 = i19;
                i7 = i20;
                if (i7 < size - 1) {
                    dVar = this.o1.get(i7 + 1).f2817b.E;
                    R0 = 0;
                } else {
                    dVar = this.G;
                    R0 = R0();
                }
                d dVar16 = aVar3.f2817b.G;
                aVar3.j(i3, dVar15, dVar7, dVar, dVar6, i21, i16, R0, i22, i4);
                i19 = i27 + aVar3.f();
                int max2 = Math.max(i26, aVar3.e());
                if (i7 > 0) {
                    i19 += this.h1;
                }
                i18 = max2;
                i21 = 0;
                i17 = R0;
                dVar8 = dVar16;
            }
            i20 = i7 + 1;
            dVar5 = dVar;
        }
        iArr[0] = i19;
        iArr[1] = i18;
    }

    private void F1(e[] eVarArr, int i2, int i3, int i4, int[] iArr) {
        a aVar;
        if (i2 == 0) {
            return;
        }
        if (this.o1.size() == 0) {
            aVar = new a(i3, this.E, this.F, this.G, this.H, i4);
            this.o1.add(aVar);
        } else {
            a aVar2 = this.o1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i3, this.E, this.F, this.G, this.H, Q0(), S0(), R0(), P0(), i4);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            aVar.b(eVarArr[i5]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void G1(float f2) {
        this.d1 = f2;
    }

    public void H1(int i2) {
        this.X0 = i2;
    }

    public void I1(float f2) {
        this.e1 = f2;
    }

    public void J1(int i2) {
        this.Y0 = i2;
    }

    public void K1(int i2) {
        this.j1 = i2;
    }

    public void L1(float f2) {
        this.b1 = f2;
    }

    public void M1(int i2) {
        this.h1 = i2;
    }

    public void N1(int i2) {
        this.V0 = i2;
    }

    public void O1(float f2) {
        this.f1 = f2;
    }

    public void P1(int i2) {
        this.Z0 = i2;
    }

    public void Q1(float f2) {
        this.g1 = f2;
    }

    public void R1(int i2) {
        this.a1 = i2;
    }

    public void S1(int i2) {
        this.m1 = i2;
    }

    @Override // c.f.b.k.l
    public void T0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr;
        boolean z;
        if (this.H0 > 0 && !V0()) {
            Y0(0, 0);
            X0(false);
            return;
        }
        int Q0 = Q0();
        int R0 = R0();
        int S0 = S0();
        int P0 = P0();
        int[] iArr2 = new int[2];
        int i8 = (i3 - Q0) - R0;
        int i9 = this.n1;
        if (i9 == 1) {
            i8 = (i5 - S0) - P0;
        }
        int i10 = i8;
        if (i9 == 0) {
            if (this.V0 == -1) {
                this.V0 = 0;
            }
            if (this.W0 == -1) {
                this.W0 = 0;
            }
        } else {
            if (this.V0 == -1) {
                this.V0 = 0;
            }
            if (this.W0 == -1) {
                this.W0 = 0;
            }
        }
        e[] eVarArr = this.G0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i6 = this.H0;
            if (i11 >= i6) {
                break;
            }
            if (this.G0[i11].P() == 8) {
                i12++;
            }
            i11++;
        }
        if (i12 > 0) {
            eVarArr = new e[i6 - i12];
            int i13 = 0;
            for (int i14 = 0; i14 < this.H0; i14++) {
                e eVar = this.G0[i14];
                if (eVar.P() != 8) {
                    eVarArr[i13] = eVar;
                    i13++;
                }
            }
            i7 = i13;
        } else {
            i7 = i6;
        }
        this.s1 = eVarArr;
        this.t1 = i7;
        int i15 = this.l1;
        if (i15 == 0) {
            iArr = iArr2;
            z = true;
            F1(eVarArr, i7, this.n1, i10, iArr2);
        } else if (i15 == 1) {
            z = true;
            iArr = iArr2;
            E1(eVarArr, i7, this.n1, i10, iArr2);
        } else if (i15 != 2) {
            z = true;
            iArr = iArr2;
        } else {
            z = true;
            iArr = iArr2;
            D1(eVarArr, i7, this.n1, i10, iArr2);
        }
        int i16 = iArr[0] + Q0 + R0;
        int i17 = iArr[z ? 1 : 0] + S0 + P0;
        if (i2 == 1073741824) {
            i16 = i3;
        } else if (i2 == Integer.MIN_VALUE) {
            i16 = Math.min(i16, i3);
        } else if (i2 != 0) {
            i16 = 0;
        }
        if (i4 == 1073741824) {
            i17 = i5;
        } else if (i4 == Integer.MIN_VALUE) {
            i17 = Math.min(i17, i5);
        } else if (i4 != 0) {
            i17 = 0;
        }
        Y0(i16, i17);
        F0(i16);
        i0(i17);
        if (this.H0 <= 0) {
            z = false;
        }
        X0(z);
    }

    public void T1(int i2) {
        this.n1 = i2;
    }

    public void U1(int i2) {
        this.k1 = i2;
    }

    public void V1(float f2) {
        this.c1 = f2;
    }

    public void W1(int i2) {
        this.i1 = i2;
    }

    public void X1(int i2) {
        this.W0 = i2;
    }

    public void Y1(int i2) {
        this.l1 = i2;
    }

    @Override // c.f.b.k.e
    public void f(c.f.b.d dVar) {
        super.f(dVar);
        boolean d1 = H() != null ? ((f) H()).d1() : false;
        int i2 = this.l1;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.o1.size();
                int i3 = 0;
                while (i3 < size) {
                    this.o1.get(i3).d(d1, i3, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 == 2) {
                A1(d1);
            }
        } else if (this.o1.size() > 0) {
            this.o1.get(0).d(d1, 0, true);
        }
        X0(false);
    }

    @Override // c.f.b.k.j, c.f.b.k.e
    public void l(e eVar, HashMap<e, e> hashMap) {
        super.l(eVar, hashMap);
        g gVar = (g) eVar;
        this.V0 = gVar.V0;
        this.W0 = gVar.W0;
        this.X0 = gVar.X0;
        this.Y0 = gVar.Y0;
        this.Z0 = gVar.Z0;
        this.a1 = gVar.a1;
        this.b1 = gVar.b1;
        this.c1 = gVar.c1;
        this.d1 = gVar.d1;
        this.e1 = gVar.e1;
        this.f1 = gVar.f1;
        this.g1 = gVar.g1;
        this.h1 = gVar.h1;
        this.i1 = gVar.i1;
        this.j1 = gVar.j1;
        this.k1 = gVar.k1;
        this.l1 = gVar.l1;
        this.m1 = gVar.m1;
        this.n1 = gVar.n1;
    }
}
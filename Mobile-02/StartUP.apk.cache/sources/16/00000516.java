package c.f.b.k.n;

import c.f.b.k.d;
import c.f.b.k.e;
import java.util.ArrayList;

/* compiled from: BasicMeasure.java */
/* loaded from: classes.dex */
public class b {
    private final ArrayList<c.f.b.k.e> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f2828b = new a();

    /* renamed from: c  reason: collision with root package name */
    private c.f.b.k.f f2829c;

    /* compiled from: BasicMeasure.java */
    /* loaded from: classes.dex */
    public static class a {
        public e.b a;

        /* renamed from: b  reason: collision with root package name */
        public e.b f2830b;

        /* renamed from: c  reason: collision with root package name */
        public int f2831c;

        /* renamed from: d  reason: collision with root package name */
        public int f2832d;

        /* renamed from: e  reason: collision with root package name */
        public int f2833e;

        /* renamed from: f  reason: collision with root package name */
        public int f2834f;

        /* renamed from: g  reason: collision with root package name */
        public int f2835g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2836h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2837i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f2838j;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: c.f.b.k.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060b {
        void a();

        void b(c.f.b.k.e eVar, a aVar);
    }

    public b(c.f.b.k.f fVar) {
        this.f2829c = fVar;
    }

    private boolean a(InterfaceC0060b interfaceC0060b, c.f.b.k.e eVar, boolean z) {
        this.f2828b.a = eVar.z();
        this.f2828b.f2830b = eVar.N();
        this.f2828b.f2831c = eVar.Q();
        this.f2828b.f2832d = eVar.w();
        a aVar = this.f2828b;
        aVar.f2837i = false;
        aVar.f2838j = z;
        e.b bVar = aVar.a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z2 = bVar == bVar2;
        boolean z3 = aVar.f2830b == bVar2;
        boolean z4 = z2 && eVar.T > 0.0f;
        boolean z5 = z3 && eVar.T > 0.0f;
        if (z4 && eVar.o[0] == 4) {
            aVar.a = e.b.FIXED;
        }
        if (z5 && eVar.o[1] == 4) {
            aVar.f2830b = e.b.FIXED;
        }
        interfaceC0060b.b(eVar, aVar);
        eVar.F0(this.f2828b.f2833e);
        eVar.i0(this.f2828b.f2834f);
        eVar.h0(this.f2828b.f2836h);
        eVar.c0(this.f2828b.f2835g);
        a aVar2 = this.f2828b;
        aVar2.f2838j = false;
        return aVar2.f2837i;
    }

    private void b(c.f.b.k.f fVar) {
        int size = fVar.G0.size();
        InterfaceC0060b X0 = fVar.X0();
        for (int i2 = 0; i2 < size; i2++) {
            c.f.b.k.e eVar = fVar.G0.get(i2);
            if (!(eVar instanceof c.f.b.k.h) && (!eVar.f2805f.f2881e.f2857j || !eVar.f2806g.f2881e.f2857j)) {
                e.b t = eVar.t(0);
                boolean z = true;
                e.b t2 = eVar.t(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if ((t != bVar || eVar.m == 1 || t2 != bVar || eVar.n == 1) ? false : false) {
                    continue;
                } else {
                    a(X0, eVar, false);
                    if (fVar.L0 != null) {
                        throw null;
                    }
                }
            }
        }
        X0.a();
    }

    private void c(c.f.b.k.f fVar, String str, int i2, int i3) {
        int F = fVar.F();
        int E = fVar.E();
        fVar.v0(0);
        fVar.u0(0);
        fVar.F0(i2);
        fVar.i0(i3);
        fVar.v0(F);
        fVar.u0(E);
        this.f2829c.M0();
    }

    public long d(c.f.b.k.f fVar, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        boolean z;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        InterfaceC0060b interfaceC0060b;
        int i14;
        boolean z4;
        boolean z5;
        int i15;
        InterfaceC0060b X0 = fVar.X0();
        int size = fVar.G0.size();
        int Q = fVar.Q();
        int w = fVar.w();
        boolean b2 = c.f.b.k.k.b(i2, 128);
        boolean z6 = b2 || c.f.b.k.k.b(i2, 64);
        if (z6) {
            for (int i16 = 0; i16 < size; i16++) {
                c.f.b.k.e eVar = fVar.G0.get(i16);
                e.b z7 = eVar.z();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z8 = (z7 == bVar) && (eVar.N() == bVar) && eVar.u() > 0.0f;
                if ((eVar.W() && z8) || ((eVar.Y() && z8) || (eVar instanceof c.f.b.k.l) || eVar.W() || eVar.Y())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (!z6 || c.f.b.d.f2727b == null) {
            int i17 = 2;
            if (z6 && ((i5 == 1073741824 && i7 == 1073741824) || b2)) {
                int min = Math.min(fVar.D(), i6);
                int min2 = Math.min(fVar.C(), i8);
                if (i5 == 1073741824 && fVar.Q() != min) {
                    fVar.F0(min);
                    fVar.a1();
                }
                if (i7 == 1073741824 && fVar.w() != min2) {
                    fVar.i0(min2);
                    fVar.a1();
                }
                if (i5 == 1073741824 && i7 == 1073741824) {
                    z = fVar.T0(b2);
                    i11 = 2;
                } else {
                    boolean U0 = fVar.U0(b2);
                    if (i5 == 1073741824) {
                        z5 = U0 & fVar.V0(b2, 0);
                        i15 = 1;
                    } else {
                        z5 = U0;
                        i15 = 0;
                    }
                    if (i7 == 1073741824) {
                        boolean V0 = fVar.V0(b2, 1) & z5;
                        i11 = i15 + 1;
                        z = V0;
                    } else {
                        i11 = i15;
                        z = z5;
                    }
                }
                if (z) {
                    fVar.J0(i5 == 1073741824, i7 == 1073741824);
                }
            } else {
                z = false;
                i11 = 0;
            }
            if (z && i11 == 2) {
                return 0L;
            }
            if (size > 0) {
                b(fVar);
            }
            int Y0 = fVar.Y0();
            int size2 = this.a.size();
            if (size > 0) {
                c(fVar, "First pass", Q, w);
            }
            if (size2 > 0) {
                e.b z9 = fVar.z();
                e.b bVar2 = e.b.WRAP_CONTENT;
                boolean z10 = z9 == bVar2;
                boolean z11 = fVar.N() == bVar2;
                int max = Math.max(fVar.Q(), this.f2829c.F());
                int max2 = Math.max(fVar.w(), this.f2829c.E());
                int i18 = 0;
                boolean z12 = false;
                while (i18 < size2) {
                    c.f.b.k.e eVar2 = this.a.get(i18);
                    if (eVar2 instanceof c.f.b.k.l) {
                        int Q2 = eVar2.Q();
                        int w2 = eVar2.w();
                        i14 = Y0;
                        boolean a2 = z12 | a(X0, eVar2, true);
                        if (fVar.L0 == null) {
                            int Q3 = eVar2.Q();
                            int w3 = eVar2.w();
                            if (Q3 != Q2) {
                                eVar2.F0(Q3);
                                if (z10 && eVar2.J() > max) {
                                    max = Math.max(max, eVar2.J() + eVar2.n(d.b.RIGHT).c());
                                }
                                z4 = true;
                            } else {
                                z4 = a2;
                            }
                            if (w3 != w2) {
                                eVar2.i0(w3);
                                if (z11 && eVar2.q() > max2) {
                                    max2 = Math.max(max2, eVar2.q() + eVar2.n(d.b.BOTTOM).c());
                                }
                                z4 = true;
                            }
                            z12 = z4 | ((c.f.b.k.l) eVar2).W0();
                        } else {
                            throw null;
                        }
                    } else {
                        i14 = Y0;
                    }
                    i18++;
                    Y0 = i14;
                    i17 = 2;
                }
                int i19 = Y0;
                int i20 = i17;
                int i21 = 0;
                while (i21 < i20) {
                    int i22 = 0;
                    while (i22 < size2) {
                        c.f.b.k.e eVar3 = this.a.get(i22);
                        if (((eVar3 instanceof c.f.b.k.i) && !(eVar3 instanceof c.f.b.k.l)) || (eVar3 instanceof c.f.b.k.h) || eVar3.P() == 8 || ((eVar3.f2805f.f2881e.f2857j && eVar3.f2806g.f2881e.f2857j) || (eVar3 instanceof c.f.b.k.l))) {
                            i13 = i21;
                            i12 = size2;
                            interfaceC0060b = X0;
                        } else {
                            int Q4 = eVar3.Q();
                            int w4 = eVar3.w();
                            i12 = size2;
                            int o = eVar3.o();
                            i13 = i21;
                            z12 |= a(X0, eVar3, true);
                            if (fVar.L0 == null) {
                                int Q5 = eVar3.Q();
                                interfaceC0060b = X0;
                                int w5 = eVar3.w();
                                if (Q5 != Q4) {
                                    eVar3.F0(Q5);
                                    if (z10 && eVar3.J() > max) {
                                        max = Math.max(max, eVar3.J() + eVar3.n(d.b.RIGHT).c());
                                    }
                                    z12 = true;
                                }
                                if (w5 != w4) {
                                    eVar3.i0(w5);
                                    if (z11 && eVar3.q() > max2) {
                                        max2 = Math.max(max2, eVar3.q() + eVar3.n(d.b.BOTTOM).c());
                                    }
                                    z12 = true;
                                }
                                if (eVar3.T() && o != eVar3.o()) {
                                    z12 = true;
                                }
                            } else {
                                throw null;
                            }
                        }
                        i22++;
                        size2 = i12;
                        X0 = interfaceC0060b;
                        i21 = i13;
                    }
                    int i23 = i21;
                    int i24 = size2;
                    InterfaceC0060b interfaceC0060b2 = X0;
                    if (z12) {
                        c(fVar, "intermediate pass", Q, w);
                        z12 = false;
                    }
                    X0 = interfaceC0060b2;
                    i21 = i23 + 1;
                    i20 = 2;
                    size2 = i24;
                }
                if (z12) {
                    c(fVar, "2nd pass", Q, w);
                    if (fVar.Q() < max) {
                        fVar.F0(max);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (fVar.w() < max2) {
                        fVar.i0(max2);
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (z3) {
                        c(fVar, "3rd pass", Q, w);
                    }
                }
                Y0 = i19;
            }
            fVar.j1(Y0);
            return 0L;
        }
        throw null;
    }

    public void e(c.f.b.k.f fVar) {
        int i2;
        this.a.clear();
        int size = fVar.G0.size();
        while (i2 < size) {
            c.f.b.k.e eVar = fVar.G0.get(i2);
            e.b z = eVar.z();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (z != bVar) {
                e.b z2 = eVar.z();
                e.b bVar2 = e.b.MATCH_PARENT;
                i2 = (z2 == bVar2 || eVar.N() == bVar || eVar.N() == bVar2) ? 0 : i2 + 1;
            }
            this.a.add(eVar);
        }
        fVar.a1();
    }
}
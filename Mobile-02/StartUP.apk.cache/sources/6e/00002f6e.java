package com.facebook.react.uimanager;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ReactShadowNodeImpl.java */
/* loaded from: classes2.dex */
public class z implements y<z> {
    private static final com.facebook.yoga.c a = b0.a();
    private Integer A;
    private Integer B;

    /* renamed from: b  reason: collision with root package name */
    private int f5272b;

    /* renamed from: c  reason: collision with root package name */
    private String f5273c;

    /* renamed from: d  reason: collision with root package name */
    private int f5274d;

    /* renamed from: e  reason: collision with root package name */
    private i0 f5275e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5276f;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<z> f5278h;

    /* renamed from: j  reason: collision with root package name */
    private z f5279j;

    /* renamed from: k  reason: collision with root package name */
    private z f5280k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5281l;
    private z n;
    private ArrayList<z> p;
    private int q;
    private int t;
    private int u;
    private int v;
    private final float[] x;
    private com.facebook.yoga.p z;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5277g = true;
    private int m = 0;
    private final boolean[] y = new boolean[9];
    private final g0 w = new g0(0.0f);

    public z() {
        float[] fArr = new float[9];
        this.x = fArr;
        if (!t()) {
            com.facebook.yoga.p acquire = b1.a().acquire();
            acquire = acquire == null ? com.facebook.yoga.q.a(a) : acquire;
            this.z = acquire;
            acquire.B(this);
            Arrays.fill(fArr, Float.NaN);
            return;
        }
        this.z = null;
    }

    private int l0() {
        k G = G();
        if (G == k.NONE) {
            return this.m;
        }
        if (G == k.LEAF) {
            return 1 + this.m;
        }
        return 1;
    }

    private void l1(int i2) {
        if (G() != k.PARENT) {
            for (z parent = getParent(); parent != null; parent = parent.getParent()) {
                parent.m += i2;
                if (parent.G() == k.PARENT) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 8
            if (r0 > r1) goto Lb6
            if (r0 == 0) goto L62
            r2 = 2
            if (r0 == r2) goto L62
            r2 = 4
            if (r0 == r2) goto L62
            r2 = 5
            if (r0 != r2) goto L11
            goto L62
        L11:
            r2 = 1
            if (r0 == r2) goto L33
            r2 = 3
            if (r0 != r2) goto L18
            goto L33
        L18:
            float[] r1 = r4.x
            r1 = r1[r0]
            boolean r1 = com.facebook.yoga.g.a(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.p r1 = r4.z
            com.facebook.yoga.j r2 = com.facebook.yoga.j.h(r0)
            com.facebook.react.uimanager.g0 r3 = r4.w
            float r3 = r3.b(r0)
            r1.h0(r2, r3)
            goto Lb2
        L33:
            float[] r2 = r4.x
            r2 = r2[r0]
            boolean r2 = com.facebook.yoga.g.a(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.x
            r3 = 7
            r2 = r2[r3]
            boolean r2 = com.facebook.yoga.g.a(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.x
            r1 = r2[r1]
            boolean r1 = com.facebook.yoga.g.a(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.p r1 = r4.z
            com.facebook.yoga.j r2 = com.facebook.yoga.j.h(r0)
            com.facebook.react.uimanager.g0 r3 = r4.w
            float r3 = r3.b(r0)
            r1.h0(r2, r3)
            goto Lb2
        L62:
            float[] r2 = r4.x
            r2 = r2[r0]
            boolean r2 = com.facebook.yoga.g.a(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.x
            r3 = 6
            r2 = r2[r3]
            boolean r2 = com.facebook.yoga.g.a(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.x
            r1 = r2[r1]
            boolean r1 = com.facebook.yoga.g.a(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.p r1 = r4.z
            com.facebook.yoga.j r2 = com.facebook.yoga.j.h(r0)
            com.facebook.react.uimanager.g0 r3 = r4.w
            float r3 = r3.b(r0)
            r1.h0(r2, r3)
            goto Lb2
        L91:
            boolean[] r1 = r4.y
            boolean r1 = r1[r0]
            if (r1 == 0) goto La5
            com.facebook.yoga.p r1 = r4.z
            com.facebook.yoga.j r2 = com.facebook.yoga.j.h(r0)
            float[] r3 = r4.x
            r3 = r3[r0]
            r1.i0(r2, r3)
            goto Lb2
        La5:
            com.facebook.yoga.p r1 = r4.z
            com.facebook.yoga.j r2 = com.facebook.yoga.j.h(r0)
            float[] r3 = r4.x
            r3 = r3[r0]
            r1.h0(r2, r3)
        Lb2:
            int r0 = r0 + 1
            goto L1
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.z.m1():void");
    }

    @Override // com.facebook.react.uimanager.y
    public void A(float f2) {
        this.z.n0(f2);
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: A0 */
    public final z R(int i2) {
        e.f.k.a.a.c(this.p);
        z remove = this.p.remove(i2);
        remove.n = null;
        return remove;
    }

    @Override // com.facebook.react.uimanager.y
    public int B() {
        return this.u;
    }

    public void B0(com.facebook.yoga.a aVar) {
        this.z.v(aVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final com.facebook.yoga.v C() {
        return this.z.o();
    }

    public void C0(com.facebook.yoga.a aVar) {
        this.z.w(aVar);
    }

    @Override // com.facebook.react.uimanager.y
    public int D() {
        return this.t;
    }

    public void D0(com.facebook.yoga.a aVar) {
        this.z.x(aVar);
    }

    @Override // com.facebook.react.uimanager.y
    public void E(Object obj) {
    }

    public void E0(int i2, float f2) {
        this.z.A(com.facebook.yoga.j.h(i2), f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final i0 F() {
        return (i0) e.f.k.a.a.c(this.f5275e);
    }

    public void F0(int i2, float f2) {
        this.w.d(i2, f2);
        m1();
    }

    @Override // com.facebook.react.uimanager.y
    public k G() {
        if (t() || a0()) {
            return k.NONE;
        }
        return n0() ? k.LEAF : k.PARENT;
    }

    public void G0(com.facebook.yoga.i iVar) {
        this.z.D(iVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final int H() {
        e.f.k.a.a.a(this.f5274d != 0);
        return this.f5274d;
    }

    public void H0(float f2) {
        this.z.F(f2);
    }

    public void I0() {
        this.z.G();
    }

    @Override // com.facebook.react.uimanager.y
    public final boolean J() {
        return this.f5276f;
    }

    public void J0(float f2) {
        this.z.H(f2);
    }

    public void K0(com.facebook.yoga.k kVar) {
        this.z.I(kVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final String L() {
        return (String) e.f.k.a.a.c(this.f5273c);
    }

    public void L0(com.facebook.yoga.w wVar) {
        this.z.r0(wVar);
    }

    public void M0(com.facebook.yoga.l lVar) {
        this.z.P(lVar);
    }

    @Override // com.facebook.react.uimanager.y
    public void N(int i2) {
        this.f5272b = i2;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: N0 */
    public final void M(z zVar) {
        this.f5280k = zVar;
    }

    @Override // com.facebook.react.uimanager.y
    public final float O() {
        return this.z.n();
    }

    public void O0(int i2, float f2) {
        this.z.Q(com.facebook.yoga.j.h(i2), f2);
    }

    @Override // com.facebook.react.uimanager.y
    public void P(float f2, float f3) {
        this.z.c(f2, f3);
    }

    public void P0(int i2) {
        this.z.R(com.facebook.yoga.j.h(i2));
    }

    @Override // com.facebook.react.uimanager.y
    public int Q() {
        return this.q;
    }

    public void Q0(int i2, float f2) {
        this.z.S(com.facebook.yoga.j.h(i2), f2);
    }

    public void R0(com.facebook.yoga.m mVar) {
        this.z.Y(mVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final float S() {
        return this.z.l();
    }

    public void S0(com.facebook.yoga.s sVar) {
        this.z.f0(sVar);
    }

    public void T0(int i2, float f2) {
        this.x[i2] = f2;
        this.y[i2] = false;
        m1();
    }

    @Override // com.facebook.react.uimanager.y
    public void U(m mVar) {
    }

    public void U0(int i2, float f2) {
        this.x[i2] = f2;
        this.y[i2] = !com.facebook.yoga.g.a(f2);
        m1();
    }

    public void V0(int i2, float f2) {
        this.z.j0(com.facebook.yoga.j.h(i2), f2);
    }

    public void W0(int i2, float f2) {
        this.z.l0(com.facebook.yoga.j.h(i2), f2);
    }

    public void X0(com.facebook.yoga.t tVar) {
        this.z.m0(tVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final void Y(boolean z) {
        e.f.k.a.a.b(getParent() == null, "Must remove from no opt parent first");
        e.f.k.a.a.b(this.n == null, "Must remove from native parent first");
        e.f.k.a.a.b(v() == 0, "Must remove all native children first");
        this.f5281l = z;
    }

    public void Y0(float f2) {
        this.z.y(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final void Z(a0 a0Var) {
        x0.f(this, a0Var);
        x0();
    }

    public void Z0() {
        this.z.M();
    }

    @Override // com.facebook.react.uimanager.y
    public final boolean a0() {
        return this.f5281l;
    }

    public void a1(float f2) {
        this.z.N(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final int b() {
        ArrayList<z> arrayList = this.f5278h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.facebook.react.uimanager.y
    public final float b0() {
        return this.z.k();
    }

    public void b1(float f2) {
        this.z.T(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public int c() {
        return this.v;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: c0 */
    public void I(z zVar, int i2) {
        if (this.f5278h == null) {
            this.f5278h = new ArrayList<>(4);
        }
        this.f5278h.add(i2, zVar);
        zVar.f5279j = this;
        if (this.z != null && !u0()) {
            com.facebook.yoga.p pVar = zVar.z;
            if (pVar != null) {
                this.z.b(pVar, i2);
            } else {
                throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + zVar.toString() + "' to a '" + toString() + "')");
            }
        }
        w0();
        int l0 = zVar.l0();
        this.m += l0;
        l1(l0);
    }

    public void c1(float f2) {
        this.z.U(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final void d() {
        this.f5277g = false;
        if (m0()) {
            v0();
        }
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: d0 */
    public final void x(z zVar, int i2) {
        e.f.k.a.a.a(G() == k.PARENT);
        e.f.k.a.a.a(zVar.G() != k.NONE);
        if (this.p == null) {
            this.p = new ArrayList<>(4);
        }
        this.p.add(i2, zVar);
        zVar.n = this;
    }

    public void d1(float f2) {
        this.z.W(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public void dispose() {
        com.facebook.yoga.p pVar = this.z;
        if (pVar != null) {
            pVar.u();
            b1.a().release(this.z);
        }
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: e0 */
    public final z a(int i2) {
        ArrayList<z> arrayList = this.f5278h;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i2 + " out of bounds: node has no children");
    }

    public void e1(float f2) {
        this.z.X(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public void f(float f2) {
        this.z.L(f2);
    }

    public final com.facebook.yoga.h f0() {
        return this.z.f();
    }

    public void f1(float f2) {
        this.z.Z(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public void g(int i2, int i3) {
        this.A = Integer.valueOf(i2);
        this.B = Integer.valueOf(i3);
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: g0 */
    public final z V() {
        z zVar = this.f5280k;
        return zVar != null ? zVar : X();
    }

    public void g1(float f2) {
        this.z.b0(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public Integer getHeightMeasureSpec() {
        return this.B;
    }

    @Override // com.facebook.react.uimanager.y
    public Integer getWidthMeasureSpec() {
        return this.A;
    }

    @Override // com.facebook.react.uimanager.y
    public void h() {
        if (!t()) {
            this.z.d();
        } else if (getParent() != null) {
            getParent().h();
        }
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: h0 */
    public final int u(z zVar) {
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= b()) {
                break;
            }
            z a2 = a(i2);
            if (zVar == a2) {
                z = true;
                break;
            }
            i3 += a2.l0();
            i2++;
        }
        if (z) {
            return i3;
        }
        throw new RuntimeException("Child " + zVar.q() + " was not a child of " + this.f5272b);
    }

    public void h1(float f2) {
        this.z.c0(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final void i(String str) {
        this.f5273c = str;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: i0 */
    public final z X() {
        return this.n;
    }

    public void i1(float f2) {
        this.z.e0(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public void j(com.facebook.yoga.h hVar) {
        this.z.C(hVar);
    }

    public final float j0(int i2) {
        return this.z.i(com.facebook.yoga.j.h(i2));
    }

    public void j1() {
        this.z.p0();
    }

    @Override // com.facebook.react.uimanager.y
    public final float k() {
        return this.z.h();
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: k0 */
    public final z getParent() {
        return this.f5279j;
    }

    public void k1(float f2) {
        this.z.q0(f2);
    }

    @Override // com.facebook.react.uimanager.y
    public final boolean l() {
        return this.f5277g || m0() || r0();
    }

    @Override // com.facebook.react.uimanager.y
    public final com.facebook.yoga.v m() {
        return this.z.e();
    }

    public final boolean m0() {
        com.facebook.yoga.p pVar = this.z;
        return pVar != null && pVar.p();
    }

    @Override // com.facebook.react.uimanager.y
    public Iterable<? extends y> n() {
        if (t0()) {
            return null;
        }
        return this.f5278h;
    }

    public boolean n0() {
        return false;
    }

    @Override // com.facebook.react.uimanager.y
    public boolean o(float f2, float f3, t0 t0Var, m mVar) {
        if (this.f5277g) {
            y0(t0Var);
        }
        boolean z = false;
        if (m0()) {
            float S = S();
            float O = O();
            float f4 = f2 + S;
            int round = Math.round(f4);
            float f5 = f3 + O;
            int round2 = Math.round(f5);
            int round3 = Math.round(f4 + b0());
            int round4 = Math.round(f5 + k());
            int round5 = Math.round(S);
            int round6 = Math.round(O);
            int i2 = round3 - round;
            int i3 = round4 - round2;
            z = (round5 == this.q && round6 == this.t && i2 == this.u && i3 == this.v) ? true : true;
            this.q = round5;
            this.t = round6;
            this.u = i2;
            this.v = i3;
            if (z) {
                if (mVar != null) {
                    mVar.l(this);
                } else {
                    t0Var.S(getParent().q(), q(), Q(), D(), B(), c());
                }
            }
        }
        return z;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: o0 */
    public final int K(z zVar) {
        ArrayList<z> arrayList = this.f5278h;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(zVar);
    }

    @Override // com.facebook.react.uimanager.y
    public void p() {
        if (b() == 0) {
            return;
        }
        int i2 = 0;
        for (int b2 = b() - 1; b2 >= 0; b2--) {
            if (this.z != null && !u0()) {
                this.z.t(b2);
            }
            z a2 = a(b2);
            a2.f5279j = null;
            i2 += a2.l0();
            a2.dispose();
        }
        ((ArrayList) e.f.k.a.a.c(this.f5278h)).clear();
        w0();
        this.m -= i2;
        l1(-i2);
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: p0 */
    public final int w(z zVar) {
        e.f.k.a.a.c(this.p);
        return this.p.indexOf(zVar);
    }

    @Override // com.facebook.react.uimanager.y
    public final int q() {
        return this.f5272b;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: q0 */
    public boolean W(z zVar) {
        for (z parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent == zVar) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.y
    public final void r() {
        ArrayList<z> arrayList = this.p;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.p.get(size).n = null;
            }
            this.p.clear();
        }
    }

    public final boolean r0() {
        com.facebook.yoga.p pVar = this.z;
        return pVar != null && pVar.q();
    }

    @Override // com.facebook.react.uimanager.y
    public void s() {
        P(Float.NaN, Float.NaN);
    }

    public boolean s0() {
        return this.z.r();
    }

    public void setFlex(float f2) {
        this.z.E(f2);
    }

    public void setFlexGrow(float f2) {
        this.z.J(f2);
    }

    public void setFlexShrink(float f2) {
        this.z.K(f2);
    }

    public void setShouldNotifyOnLayout(boolean z) {
        this.f5276f = z;
    }

    @Override // com.facebook.react.uimanager.y
    public boolean t() {
        return false;
    }

    public boolean t0() {
        return false;
    }

    public String toString() {
        return "[" + this.f5273c + " " + q() + "]";
    }

    public boolean u0() {
        return s0();
    }

    @Override // com.facebook.react.uimanager.y
    public final int v() {
        ArrayList<z> arrayList = this.p;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void v0() {
        com.facebook.yoga.p pVar = this.z;
        if (pVar != null) {
            pVar.s();
        }
    }

    public void w0() {
        if (this.f5277g) {
            return;
        }
        this.f5277g = true;
        z parent = getParent();
        if (parent != null) {
            parent.w0();
        }
    }

    public void x0() {
    }

    @Override // com.facebook.react.uimanager.y
    public final void y(int i2) {
        this.f5274d = i2;
    }

    public void y0(t0 t0Var) {
    }

    @Override // com.facebook.react.uimanager.y
    public void z(i0 i0Var) {
        this.f5275e = i0Var;
    }

    @Override // com.facebook.react.uimanager.y
    /* renamed from: z0 */
    public z e(int i2) {
        ArrayList<z> arrayList = this.f5278h;
        if (arrayList != null) {
            z remove = arrayList.remove(i2);
            remove.f5279j = null;
            if (this.z != null && !u0()) {
                this.z.t(i2);
            }
            w0();
            int l0 = remove.l0();
            this.m -= l0;
            l1(-l0);
            return remove;
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i2 + " out of bounds: node has no children");
    }
}
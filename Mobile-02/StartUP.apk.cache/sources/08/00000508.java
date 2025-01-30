package c.f.b.k;

import c.f.b.k.d;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class e {
    public static float a = 0.5f;
    boolean A0;
    public float[] B0;
    private boolean C;
    protected e[] C0;
    protected e[] D0;
    e E0;
    e F0;
    d L;
    public d[] M;
    protected ArrayList<d> N;
    private boolean[] O;
    public b[] P;
    public e Q;
    int R;
    int S;
    public float T;
    protected int U;
    protected int V;
    protected int W;
    int X;
    int Y;
    protected int Z;
    protected int a0;
    int b0;
    protected int c0;

    /* renamed from: d  reason: collision with root package name */
    public c.f.b.k.n.c f2803d;
    protected int d0;

    /* renamed from: e  reason: collision with root package name */
    public c.f.b.k.n.c f2804e;
    float e0;
    float f0;
    private Object g0;
    private int h0;
    private int i0;
    private String j0;
    private String k0;
    int l0;
    int m0;
    int n0;
    int o0;
    boolean p0;
    boolean q0;
    boolean r0;
    boolean s0;
    boolean t0;
    boolean u0;
    public boolean v;
    boolean v0;
    public boolean w;
    boolean w0;
    int x0;
    int y0;
    boolean z0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2801b = false;

    /* renamed from: c  reason: collision with root package name */
    public c.f.b.k.n.m[] f2802c = new c.f.b.k.n.m[2];

    /* renamed from: f  reason: collision with root package name */
    public c.f.b.k.n.j f2805f = new c.f.b.k.n.j(this);

    /* renamed from: g  reason: collision with root package name */
    public c.f.b.k.n.l f2806g = new c.f.b.k.n.l(this);

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f2807h = {true, true};

    /* renamed from: i  reason: collision with root package name */
    public int[] f2808i = {0, 0, 0, 0};

    /* renamed from: j  reason: collision with root package name */
    boolean f2809j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f2810k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f2811l = -1;
    public int m = 0;
    public int n = 0;
    public int[] o = new int[2];
    public int p = 0;
    public int q = 0;
    public float r = 1.0f;
    public int s = 0;
    public int t = 0;
    public float u = 1.0f;
    int x = -1;
    float y = 1.0f;
    private int[] z = {RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO};
    private float A = 0.0f;
    private boolean B = false;
    private boolean D = false;
    public d E = new d(this, d.b.LEFT);
    public d F = new d(this, d.b.TOP);
    public d G = new d(this, d.b.RIGHT);
    public d H = new d(this, d.b.BOTTOM);
    d I = new d(this, d.b.BASELINE);
    d J = new d(this, d.b.CENTER_X);
    d K = new d(this, d.b.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2812b;

        static {
            int[] iArr = new int[b.values().length];
            f2812b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2812b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2812b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2812b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        d dVar = new d(this, d.b.CENTER);
        this.L = dVar;
        this.M = new d[]{this.E, this.G, this.F, this.H, this.I, dVar};
        this.N = new ArrayList<>();
        this.O = new boolean[2];
        b bVar = b.FIXED;
        this.P = new b[]{bVar, bVar};
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = 0.0f;
        this.U = -1;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        float f2 = a;
        this.e0 = f2;
        this.f0 = f2;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = null;
        this.k0 = null;
        this.v0 = false;
        this.w0 = false;
        this.x0 = 0;
        this.y0 = 0;
        this.B0 = new float[]{-1.0f, -1.0f};
        this.C0 = new e[]{null, null};
        this.D0 = new e[]{null, null};
        this.E0 = null;
        this.F0 = null;
        d();
    }

    private boolean V(int i2) {
        int i3 = i2 * 2;
        d[] dVarArr = this.M;
        if (dVarArr[i3].f2788d != null && dVarArr[i3].f2788d.f2788d != dVarArr[i3]) {
            int i4 = i3 + 1;
            if (dVarArr[i4].f2788d != null && dVarArr[i4].f2788d.f2788d == dVarArr[i4]) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        this.N.add(this.E);
        this.N.add(this.F);
        this.N.add(this.G);
        this.N.add(this.H);
        this.N.add(this.J);
        this.N.add(this.K);
        this.N.add(this.L);
        this.N.add(this.I);
    }

    /* JADX WARN: Code restructure failed: missing block: B:294:0x046c, code lost:
        if (r1[r22] == r4) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0346 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x043b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:306:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(c.f.b.d r32, boolean r33, boolean r34, boolean r35, boolean r36, c.f.b.i r37, c.f.b.i r38, c.f.b.k.e.b r39, boolean r40, c.f.b.k.d r41, c.f.b.k.d r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.k.e.h(c.f.b.d, boolean, boolean, boolean, boolean, c.f.b.i, c.f.b.i, c.f.b.k.e$b, boolean, c.f.b.k.d, c.f.b.k.d, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public int A() {
        d dVar = this.E;
        int i2 = dVar != null ? 0 + dVar.f2789e : 0;
        d dVar2 = this.G;
        return dVar2 != null ? i2 + dVar2.f2789e : i2;
    }

    public void A0(int i2, int i3) {
        this.W = i2;
        int i4 = i3 - i2;
        this.S = i4;
        int i5 = this.d0;
        if (i4 < i5) {
            this.S = i5;
        }
    }

    public int B(int i2) {
        if (i2 == 0) {
            return Q();
        }
        if (i2 == 1) {
            return w();
        }
        return 0;
    }

    public void B0(b bVar) {
        this.P[1] = bVar;
    }

    public int C() {
        return this.z[1];
    }

    public void C0(int i2, int i3, int i4, float f2) {
        this.n = i2;
        this.s = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.t = i4;
        this.u = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.n = 2;
    }

    public int D() {
        return this.z[0];
    }

    public void D0(float f2) {
        this.B0[1] = f2;
    }

    public int E() {
        return this.d0;
    }

    public void E0(int i2) {
        this.i0 = i2;
    }

    public int F() {
        return this.c0;
    }

    public void F0(int i2) {
        this.R = i2;
        int i3 = this.c0;
        if (i2 < i3) {
            this.R = i3;
        }
    }

    public e G(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.H).f2788d) != null && dVar2.f2788d == dVar) {
                return dVar2.f2786b;
            }
            return null;
        }
        d dVar3 = this.G;
        d dVar4 = dVar3.f2788d;
        if (dVar4 == null || dVar4.f2788d != dVar3) {
            return null;
        }
        return dVar4.f2786b;
    }

    public void G0(int i2) {
        this.V = i2;
    }

    public e H() {
        return this.Q;
    }

    public void H0(int i2) {
        this.W = i2;
    }

    public e I(int i2) {
        d dVar;
        d dVar2;
        if (i2 != 0) {
            if (i2 == 1 && (dVar2 = (dVar = this.F).f2788d) != null && dVar2.f2788d == dVar) {
                return dVar2.f2786b;
            }
            return null;
        }
        d dVar3 = this.E;
        d dVar4 = dVar3.f2788d;
        if (dVar4 == null || dVar4.f2788d != dVar3) {
            return null;
        }
        return dVar4.f2786b;
    }

    public void I0(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.x == -1) {
            if (z3 && !z4) {
                this.x = 0;
            } else if (!z3 && z4) {
                this.x = 1;
                if (this.U == -1) {
                    this.y = 1.0f / this.y;
                }
            }
        }
        if (this.x == 0 && (!this.F.j() || !this.H.j())) {
            this.x = 1;
        } else if (this.x == 1 && (!this.E.j() || !this.G.j())) {
            this.x = 0;
        }
        if (this.x == -1 && (!this.F.j() || !this.H.j() || !this.E.j() || !this.G.j())) {
            if (this.F.j() && this.H.j()) {
                this.x = 0;
            } else if (this.E.j() && this.G.j()) {
                this.y = 1.0f / this.y;
                this.x = 1;
            }
        }
        if (this.x == -1) {
            int i2 = this.p;
            if (i2 > 0 && this.s == 0) {
                this.x = 0;
            } else if (i2 != 0 || this.s <= 0) {
            } else {
                this.y = 1.0f / this.y;
                this.x = 1;
            }
        }
    }

    public int J() {
        return R() + this.R;
    }

    public void J0(boolean z, boolean z2) {
        int i2;
        int i3;
        boolean k2 = z & this.f2805f.k();
        boolean k3 = z2 & this.f2806g.k();
        c.f.b.k.n.j jVar = this.f2805f;
        int i4 = jVar.f2884h.f2854g;
        c.f.b.k.n.l lVar = this.f2806g;
        int i5 = lVar.f2884h.f2854g;
        int i6 = jVar.f2885i.f2854g;
        int i7 = lVar.f2885i.f2854g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (k2) {
            this.V = i4;
        }
        if (k3) {
            this.W = i5;
        }
        if (this.i0 == 8) {
            this.R = 0;
            this.S = 0;
            return;
        }
        if (k2) {
            if (this.P[0] == b.FIXED && i9 < (i3 = this.R)) {
                i9 = i3;
            }
            this.R = i9;
            int i11 = this.c0;
            if (i9 < i11) {
                this.R = i11;
            }
        }
        if (k3) {
            if (this.P[1] == b.FIXED && i10 < (i2 = this.S)) {
                i10 = i2;
            }
            this.S = i10;
            int i12 = this.d0;
            if (i10 < i12) {
                this.S = i12;
            }
        }
    }

    public c.f.b.k.n.m K(int i2) {
        if (i2 == 0) {
            return this.f2805f;
        }
        if (i2 == 1) {
            return this.f2806g;
        }
        return null;
    }

    public void K0(c.f.b.d dVar) {
        int y = dVar.y(this.E);
        int y2 = dVar.y(this.F);
        int y3 = dVar.y(this.G);
        int y4 = dVar.y(this.H);
        c.f.b.k.n.j jVar = this.f2805f;
        c.f.b.k.n.f fVar = jVar.f2884h;
        if (fVar.f2857j) {
            c.f.b.k.n.f fVar2 = jVar.f2885i;
            if (fVar2.f2857j) {
                y = fVar.f2854g;
                y3 = fVar2.f2854g;
            }
        }
        c.f.b.k.n.l lVar = this.f2806g;
        c.f.b.k.n.f fVar3 = lVar.f2884h;
        if (fVar3.f2857j) {
            c.f.b.k.n.f fVar4 = lVar.f2885i;
            if (fVar4.f2857j) {
                y2 = fVar3.f2854g;
                y4 = fVar4.f2854g;
            }
        }
        int i2 = y4 - y2;
        if (y3 - y < 0 || i2 < 0 || y == Integer.MIN_VALUE || y == Integer.MAX_VALUE || y2 == Integer.MIN_VALUE || y2 == Integer.MAX_VALUE || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE) {
            y4 = 0;
            y = 0;
            y2 = 0;
            y3 = 0;
        }
        g0(y, y2, y3, y4);
    }

    public float L() {
        return this.f0;
    }

    public int M() {
        return this.y0;
    }

    public b N() {
        return this.P[1];
    }

    public int O() {
        int i2 = this.E != null ? 0 + this.F.f2789e : 0;
        return this.G != null ? i2 + this.H.f2789e : i2;
    }

    public int P() {
        return this.i0;
    }

    public int Q() {
        if (this.i0 == 8) {
            return 0;
        }
        return this.R;
    }

    public int R() {
        e eVar = this.Q;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).N0 + this.V;
        }
        return this.V;
    }

    public int S() {
        e eVar = this.Q;
        if (eVar != null && (eVar instanceof f)) {
            return ((f) eVar).O0 + this.W;
        }
        return this.W;
    }

    public boolean T() {
        return this.B;
    }

    public void U(d.b bVar, e eVar, d.b bVar2, int i2, int i3) {
        n(bVar).b(eVar.n(bVar2), i2, i3, true);
    }

    public boolean W() {
        d dVar = this.E;
        d dVar2 = dVar.f2788d;
        if (dVar2 == null || dVar2.f2788d != dVar) {
            d dVar3 = this.G;
            d dVar4 = dVar3.f2788d;
            return dVar4 != null && dVar4.f2788d == dVar3;
        }
        return true;
    }

    public boolean X() {
        return this.C;
    }

    public boolean Y() {
        d dVar = this.F;
        d dVar2 = dVar.f2788d;
        if (dVar2 == null || dVar2.f2788d != dVar) {
            d dVar3 = this.H;
            d dVar4 = dVar3.f2788d;
            return dVar4 != null && dVar4.f2788d == dVar3;
        }
        return true;
    }

    public void Z() {
        this.E.l();
        this.F.l();
        this.G.l();
        this.H.l();
        this.I.l();
        this.J.l();
        this.K.l();
        this.L.l();
        this.Q = null;
        this.A = 0.0f;
        this.R = 0;
        this.S = 0;
        this.T = 0.0f;
        this.U = -1;
        this.V = 0;
        this.W = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        float f2 = a;
        this.e0 = f2;
        this.f0 = f2;
        b[] bVarArr = this.P;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        this.k0 = null;
        this.t0 = false;
        this.u0 = false;
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = false;
        this.A0 = false;
        float[] fArr = this.B0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f2810k = -1;
        this.f2811l = -1;
        int[] iArr = this.z;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.m = 0;
        this.n = 0;
        this.r = 1.0f;
        this.u = 1.0f;
        this.q = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.t = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.p = 0;
        this.s = 0;
        this.f2809j = false;
        this.x = -1;
        this.y = 1.0f;
        this.v0 = false;
        this.w0 = false;
        boolean[] zArr = this.f2807h;
        zArr[0] = true;
        zArr[1] = true;
        this.D = false;
        boolean[] zArr2 = this.O;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void a0() {
        e H = H();
        if (H != null && (H instanceof f) && ((f) H()).Z0()) {
            return;
        }
        int size = this.N.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.N.get(i2).l();
        }
    }

    public void b0(c.f.b.c cVar) {
        this.E.m(cVar);
        this.F.m(cVar);
        this.G.m(cVar);
        this.H.m(cVar);
        this.I.m(cVar);
        this.L.m(cVar);
        this.J.m(cVar);
        this.K.m(cVar);
    }

    public void c0(int i2) {
        this.b0 = i2;
        this.B = i2 > 0;
    }

    public void d0(Object obj) {
        this.g0 = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return (this instanceof l) || (this instanceof h);
    }

    public void e0(String str) {
        this.j0 = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x024d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(c.f.b.d r48) {
        /*
            Method dump skipped, instructions count: 1273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.k.e.f(c.f.b.d):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    public void f0(String str) {
        float f2;
        int i2 = 0;
        if (str != null && str.length() != 0) {
            int i3 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i4 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i4, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i3 == 1) {
                            f2 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f2 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f2 = i2;
            } else {
                String substring4 = str.substring(i4);
                if (substring4.length() > 0) {
                    f2 = Float.parseFloat(substring4);
                }
                f2 = i2;
            }
            i2 = (f2 > i2 ? 1 : (f2 == i2 ? 0 : -1));
            if (i2 > 0) {
                this.T = f2;
                this.U = i3;
                return;
            }
            return;
        }
        this.T = 0.0f;
    }

    public boolean g() {
        return this.i0 != 8;
    }

    public void g0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.V = i2;
        this.W = i3;
        if (this.i0 == 8) {
            this.R = 0;
            this.S = 0;
            return;
        }
        b[] bVarArr = this.P;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i8 < (i7 = this.R)) {
            i8 = i7;
        }
        if (bVarArr[1] == bVar2 && i9 < (i6 = this.S)) {
            i9 = i6;
        }
        this.R = i8;
        this.S = i9;
        int i10 = this.d0;
        if (i9 < i10) {
            this.S = i10;
        }
        int i11 = this.c0;
        if (i8 < i11) {
            this.R = i11;
        }
    }

    public void h0(boolean z) {
        this.B = z;
    }

    public void i(d.b bVar, e eVar, d.b bVar2, int i2) {
        d.b bVar3;
        d.b bVar4;
        boolean z;
        d.b bVar5 = d.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 == bVar5) {
                d.b bVar6 = d.b.LEFT;
                d n = n(bVar6);
                d.b bVar7 = d.b.RIGHT;
                d n2 = n(bVar7);
                d.b bVar8 = d.b.TOP;
                d n3 = n(bVar8);
                d.b bVar9 = d.b.BOTTOM;
                d n4 = n(bVar9);
                boolean z2 = true;
                if ((n == null || !n.j()) && (n2 == null || !n2.j())) {
                    i(bVar6, eVar, bVar6, 0);
                    i(bVar7, eVar, bVar7, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((n3 == null || !n3.j()) && (n4 == null || !n4.j())) {
                    i(bVar8, eVar, bVar8, 0);
                    i(bVar9, eVar, bVar9, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    n(bVar5).a(eVar.n(bVar5), 0);
                    return;
                } else if (z) {
                    d.b bVar10 = d.b.CENTER_X;
                    n(bVar10).a(eVar.n(bVar10), 0);
                    return;
                } else if (z2) {
                    d.b bVar11 = d.b.CENTER_Y;
                    n(bVar11).a(eVar.n(bVar11), 0);
                    return;
                } else {
                    return;
                }
            }
            d.b bVar12 = d.b.LEFT;
            if (bVar2 != bVar12 && bVar2 != d.b.RIGHT) {
                d.b bVar13 = d.b.TOP;
                if (bVar2 == bVar13 || bVar2 == d.b.BOTTOM) {
                    i(bVar13, eVar, bVar2, 0);
                    i(d.b.BOTTOM, eVar, bVar2, 0);
                    n(bVar5).a(eVar.n(bVar2), 0);
                    return;
                }
                return;
            }
            i(bVar12, eVar, bVar2, 0);
            i(d.b.RIGHT, eVar, bVar2, 0);
            n(bVar5).a(eVar.n(bVar2), 0);
            return;
        }
        d.b bVar14 = d.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
            d n5 = n(bVar4);
            d n6 = eVar.n(bVar2);
            d n7 = n(d.b.RIGHT);
            n5.a(n6, 0);
            n7.a(n6, 0);
            n(bVar14).a(n6, 0);
            return;
        }
        d.b bVar15 = d.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
            d n8 = eVar.n(bVar2);
            n(bVar3).a(n8, 0);
            n(d.b.BOTTOM).a(n8, 0);
            n(bVar15).a(n8, 0);
        } else if (bVar == bVar14 && bVar2 == bVar14) {
            d.b bVar16 = d.b.LEFT;
            n(bVar16).a(eVar.n(bVar16), 0);
            d.b bVar17 = d.b.RIGHT;
            n(bVar17).a(eVar.n(bVar17), 0);
            n(bVar14).a(eVar.n(bVar2), 0);
        } else if (bVar == bVar15 && bVar2 == bVar15) {
            d.b bVar18 = d.b.TOP;
            n(bVar18).a(eVar.n(bVar18), 0);
            d.b bVar19 = d.b.BOTTOM;
            n(bVar19).a(eVar.n(bVar19), 0);
            n(bVar15).a(eVar.n(bVar2), 0);
        } else {
            d n9 = n(bVar);
            d n10 = eVar.n(bVar2);
            if (n9.k(n10)) {
                d.b bVar20 = d.b.BASELINE;
                if (bVar == bVar20) {
                    d n11 = n(d.b.TOP);
                    d n12 = n(d.b.BOTTOM);
                    if (n11 != null) {
                        n11.l();
                    }
                    if (n12 != null) {
                        n12.l();
                    }
                    i2 = 0;
                } else if (bVar != d.b.TOP && bVar != d.b.BOTTOM) {
                    if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                        d n13 = n(bVar5);
                        if (n13.g() != n10) {
                            n13.l();
                        }
                        d d2 = n(bVar).d();
                        d n14 = n(bVar14);
                        if (n14.j()) {
                            d2.l();
                            n14.l();
                        }
                    }
                } else {
                    d n15 = n(bVar20);
                    if (n15 != null) {
                        n15.l();
                    }
                    d n16 = n(bVar5);
                    if (n16.g() != n10) {
                        n16.l();
                    }
                    d d3 = n(bVar).d();
                    d n17 = n(bVar15);
                    if (n17.j()) {
                        d3.l();
                        n17.l();
                    }
                }
                n9.a(n10, i2);
            }
        }
    }

    public void i0(int i2) {
        this.S = i2;
        int i3 = this.d0;
        if (i2 < i3) {
            this.S = i3;
        }
    }

    public void j(d dVar, d dVar2, int i2) {
        if (dVar.e() == this) {
            i(dVar.h(), dVar2.e(), dVar2.h(), i2);
        }
    }

    public void j0(float f2) {
        this.e0 = f2;
    }

    public void k(e eVar, float f2, int i2) {
        d.b bVar = d.b.CENTER;
        U(bVar, eVar, bVar, i2, 0);
        this.A = f2;
    }

    public void k0(int i2) {
        this.x0 = i2;
    }

    public void l(e eVar, HashMap<e, e> hashMap) {
        this.f2810k = eVar.f2810k;
        this.f2811l = eVar.f2811l;
        this.m = eVar.m;
        this.n = eVar.n;
        int[] iArr = this.o;
        int[] iArr2 = eVar.o;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.p = eVar.p;
        this.q = eVar.q;
        this.s = eVar.s;
        this.t = eVar.t;
        this.u = eVar.u;
        this.v = eVar.v;
        this.w = eVar.w;
        this.x = eVar.x;
        this.y = eVar.y;
        int[] iArr3 = eVar.z;
        this.z = Arrays.copyOf(iArr3, iArr3.length);
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.E.l();
        this.F.l();
        this.G.l();
        this.H.l();
        this.I.l();
        this.J.l();
        this.K.l();
        this.L.l();
        this.P = (b[]) Arrays.copyOf(this.P, 2);
        this.Q = this.Q == null ? null : hashMap.get(eVar.Q);
        this.R = eVar.R;
        this.S = eVar.S;
        this.T = eVar.T;
        this.U = eVar.U;
        this.V = eVar.V;
        this.W = eVar.W;
        this.X = eVar.X;
        this.Y = eVar.Y;
        this.Z = eVar.Z;
        this.a0 = eVar.a0;
        this.b0 = eVar.b0;
        this.c0 = eVar.c0;
        this.d0 = eVar.d0;
        this.e0 = eVar.e0;
        this.f0 = eVar.f0;
        this.g0 = eVar.g0;
        this.h0 = eVar.h0;
        this.i0 = eVar.i0;
        this.j0 = eVar.j0;
        this.k0 = eVar.k0;
        this.l0 = eVar.l0;
        this.m0 = eVar.m0;
        this.n0 = eVar.n0;
        this.o0 = eVar.o0;
        this.p0 = eVar.p0;
        this.q0 = eVar.q0;
        this.r0 = eVar.r0;
        this.s0 = eVar.s0;
        this.t0 = eVar.t0;
        this.u0 = eVar.u0;
        this.v0 = eVar.v0;
        this.w0 = eVar.w0;
        this.x0 = eVar.x0;
        this.y0 = eVar.y0;
        this.z0 = eVar.z0;
        this.A0 = eVar.A0;
        float[] fArr = this.B0;
        float[] fArr2 = eVar.B0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        e[] eVarArr = this.C0;
        e[] eVarArr2 = eVar.C0;
        eVarArr[0] = eVarArr2[0];
        eVarArr[1] = eVarArr2[1];
        e[] eVarArr3 = this.D0;
        e[] eVarArr4 = eVar.D0;
        eVarArr3[0] = eVarArr4[0];
        eVarArr3[1] = eVarArr4[1];
        e eVar2 = eVar.E0;
        this.E0 = eVar2 == null ? null : hashMap.get(eVar2);
        e eVar3 = eVar.F0;
        this.F0 = eVar3 != null ? hashMap.get(eVar3) : null;
    }

    public void l0(int i2, int i3) {
        this.V = i2;
        int i4 = i3 - i2;
        this.R = i4;
        int i5 = this.c0;
        if (i4 < i5) {
            this.R = i5;
        }
    }

    public void m(c.f.b.d dVar) {
        dVar.q(this.E);
        dVar.q(this.F);
        dVar.q(this.G);
        dVar.q(this.H);
        if (this.b0 > 0) {
            dVar.q(this.I);
        }
    }

    public void m0(b bVar) {
        this.P[0] = bVar;
    }

    public d n(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return this.E;
            case 2:
                return this.F;
            case 3:
                return this.G;
            case 4:
                return this.H;
            case 5:
                return this.I;
            case 6:
                return this.L;
            case 7:
                return this.J;
            case 8:
                return this.K;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public void n0(int i2, int i3, int i4, float f2) {
        this.m = i2;
        this.p = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.q = i4;
        this.r = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.m = 2;
    }

    public int o() {
        return this.b0;
    }

    public void o0(float f2) {
        this.B0[0] = f2;
    }

    public float p(int i2) {
        if (i2 == 0) {
            return this.e0;
        }
        if (i2 == 1) {
            return this.f0;
        }
        return -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(int i2, boolean z) {
        this.O[i2] = z;
    }

    public int q() {
        return S() + this.S;
    }

    public void q0(boolean z) {
        this.C = z;
    }

    public Object r() {
        return this.g0;
    }

    public void r0(boolean z) {
        this.D = z;
    }

    public String s() {
        return this.j0;
    }

    public void s0(int i2) {
        this.z[1] = i2;
    }

    public b t(int i2) {
        if (i2 == 0) {
            return z();
        }
        if (i2 == 1) {
            return N();
        }
        return null;
    }

    public void t0(int i2) {
        this.z[0] = i2;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.k0 != null) {
            str = "type: " + this.k0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.j0 != null) {
            str2 = "id: " + this.j0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.V);
        sb.append(", ");
        sb.append(this.W);
        sb.append(") - (");
        sb.append(this.R);
        sb.append(" x ");
        sb.append(this.S);
        sb.append(")");
        return sb.toString();
    }

    public float u() {
        return this.T;
    }

    public void u0(int i2) {
        if (i2 < 0) {
            this.d0 = 0;
        } else {
            this.d0 = i2;
        }
    }

    public int v() {
        return this.U;
    }

    public void v0(int i2) {
        if (i2 < 0) {
            this.c0 = 0;
        } else {
            this.c0 = i2;
        }
    }

    public int w() {
        if (this.i0 == 8) {
            return 0;
        }
        return this.S;
    }

    public void w0(int i2, int i3) {
        this.V = i2;
        this.W = i3;
    }

    public float x() {
        return this.e0;
    }

    public void x0(e eVar) {
        this.Q = eVar;
    }

    public int y() {
        return this.x0;
    }

    public void y0(float f2) {
        this.f0 = f2;
    }

    public b z() {
        return this.P[0];
    }

    public void z0(int i2) {
        this.y0 = i2;
    }
}
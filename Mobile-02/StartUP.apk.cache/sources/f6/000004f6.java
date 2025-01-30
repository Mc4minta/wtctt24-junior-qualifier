package c.f.b;

import c.f.b.i;
import c.f.b.k.d;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class d {
    private static int a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static e f2727b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2728c = true;

    /* renamed from: d  reason: collision with root package name */
    public static long f2729d;

    /* renamed from: e  reason: collision with root package name */
    public static long f2730e;

    /* renamed from: h  reason: collision with root package name */
    private a f2733h;

    /* renamed from: k  reason: collision with root package name */
    c.f.b.b[] f2736k;
    final c r;
    private a u;

    /* renamed from: f  reason: collision with root package name */
    int f2731f = 0;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, i> f2732g = null;

    /* renamed from: i  reason: collision with root package name */
    private int f2734i = 32;

    /* renamed from: j  reason: collision with root package name */
    private int f2735j = 32;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2737l = false;
    public boolean m = false;
    private boolean[] n = new boolean[32];
    int o = 1;
    int p = 0;
    private int q = 32;
    private i[] s = new i[a];
    private int t = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public class b extends c.f.b.b {
        public b(c cVar) {
            this.f2722e = new j(this, cVar);
        }
    }

    public d() {
        this.f2736k = null;
        this.f2736k = new c.f.b.b[32];
        D();
        c cVar = new c();
        this.r = cVar;
        this.f2733h = new h(cVar);
        if (f2728c) {
            this.u = new b(cVar);
        } else {
            this.u = new c.f.b.b(cVar);
        }
    }

    private final int C(a aVar, boolean z) {
        if (f2727b == null) {
            for (int i2 = 0; i2 < this.o; i2++) {
                this.n[i2] = false;
            }
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                if (f2727b == null) {
                    i3++;
                    if (i3 >= this.o * 2) {
                        return i3;
                    }
                    if (aVar.getKey() != null) {
                        this.n[aVar.getKey().f2750d] = true;
                    }
                    i b2 = aVar.b(this, this.n);
                    if (b2 != null) {
                        boolean[] zArr = this.n;
                        int i4 = b2.f2750d;
                        if (zArr[i4]) {
                            return i3;
                        }
                        zArr[i4] = true;
                    }
                    if (b2 != null) {
                        float f2 = Float.MAX_VALUE;
                        int i5 = -1;
                        for (int i6 = 0; i6 < this.p; i6++) {
                            c.f.b.b bVar = this.f2736k[i6];
                            if (bVar.a.f2757k != i.a.UNRESTRICTED && !bVar.f2723f && bVar.t(b2)) {
                                float d2 = bVar.f2722e.d(b2);
                                if (d2 < 0.0f) {
                                    float f3 = (-bVar.f2719b) / d2;
                                    if (f3 < f2) {
                                        i5 = i6;
                                        f2 = f3;
                                    }
                                }
                            }
                        }
                        if (i5 > -1) {
                            c.f.b.b bVar2 = this.f2736k[i5];
                            bVar2.a.f2751e = -1;
                            if (f2727b == null) {
                                bVar2.y(b2);
                                i iVar = bVar2.a;
                                iVar.f2751e = i5;
                                iVar.g(bVar2);
                            } else {
                                throw null;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        z2 = true;
                    }
                } else {
                    throw null;
                }
            }
            return i3;
        }
        throw null;
    }

    private void D() {
        int i2 = 0;
        if (f2728c) {
            while (true) {
                c.f.b.b[] bVarArr = this.f2736k;
                if (i2 >= bVarArr.length) {
                    return;
                }
                c.f.b.b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.r.a.release(bVar);
                }
                this.f2736k[i2] = null;
                i2++;
            }
        } else {
            while (true) {
                c.f.b.b[] bVarArr2 = this.f2736k;
                if (i2 >= bVarArr2.length) {
                    return;
                }
                c.f.b.b bVar2 = bVarArr2[i2];
                if (bVar2 != null) {
                    this.r.f2724b.release(bVar2);
                }
                this.f2736k[i2] = null;
                i2++;
            }
        }
    }

    private i a(i.a aVar, String str) {
        i acquire = this.r.f2725c.acquire();
        if (acquire == null) {
            acquire = new i(aVar, str);
            acquire.f(aVar, str);
        } else {
            acquire.d();
            acquire.f(aVar, str);
        }
        int i2 = this.t;
        int i3 = a;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            a = i4;
            this.s = (i[]) Arrays.copyOf(this.s, i4);
        }
        i[] iVarArr = this.s;
        int i5 = this.t;
        this.t = i5 + 1;
        iVarArr[i5] = acquire;
        return acquire;
    }

    private final void l(c.f.b.b bVar) {
        if (f2728c) {
            c.f.b.b[] bVarArr = this.f2736k;
            int i2 = this.p;
            if (bVarArr[i2] != null) {
                this.r.a.release(bVarArr[i2]);
            }
        } else {
            c.f.b.b[] bVarArr2 = this.f2736k;
            int i3 = this.p;
            if (bVarArr2[i3] != null) {
                this.r.f2724b.release(bVarArr2[i3]);
            }
        }
        c.f.b.b[] bVarArr3 = this.f2736k;
        int i4 = this.p;
        bVarArr3[i4] = bVar;
        i iVar = bVar.a;
        iVar.f2751e = i4;
        this.p = i4 + 1;
        iVar.g(bVar);
    }

    private void n() {
        for (int i2 = 0; i2 < this.p; i2++) {
            c.f.b.b bVar = this.f2736k[i2];
            bVar.a.f2753g = bVar.f2719b;
        }
    }

    public static c.f.b.b s(d dVar, i iVar, i iVar2, float f2) {
        return dVar.r().j(iVar, iVar2, f2);
    }

    private int u(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.p) {
                z = false;
                break;
            }
            c.f.b.b[] bVarArr = this.f2736k;
            if (bVarArr[i2].a.f2757k != i.a.UNRESTRICTED && bVarArr[i2].f2719b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                if (f2727b == null) {
                    i3++;
                    float f3 = Float.MAX_VALUE;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < this.p) {
                        c.f.b.b bVar = this.f2736k[i6];
                        if (bVar.a.f2757k != i.a.UNRESTRICTED && !bVar.f2723f && bVar.f2719b < f2) {
                            int i8 = 1;
                            while (i8 < this.o) {
                                i iVar = this.r.f2726d[i8];
                                float d2 = bVar.f2722e.d(iVar);
                                if (d2 > f2) {
                                    for (int i9 = 0; i9 < 9; i9++) {
                                        float f4 = iVar.f2755i[i9] / d2;
                                        if ((f4 < f3 && i9 == i7) || i9 > i7) {
                                            i7 = i9;
                                            f3 = f4;
                                            i4 = i6;
                                            i5 = i8;
                                        }
                                    }
                                }
                                i8++;
                                f2 = 0.0f;
                            }
                        }
                        i6++;
                        f2 = 0.0f;
                    }
                    if (i4 != -1) {
                        c.f.b.b bVar2 = this.f2736k[i4];
                        bVar2.a.f2751e = -1;
                        if (f2727b == null) {
                            bVar2.y(this.r.f2726d[i5]);
                            i iVar2 = bVar2.a;
                            iVar2.f2751e = i4;
                            iVar2.g(bVar2);
                        } else {
                            throw null;
                        }
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.o / 2) {
                        z2 = true;
                    }
                    f2 = 0.0f;
                } else {
                    throw null;
                }
            }
            return i3;
        }
        return 0;
    }

    public static e x() {
        return f2727b;
    }

    private void z() {
        int i2 = this.f2734i * 2;
        this.f2734i = i2;
        this.f2736k = (c.f.b.b[]) Arrays.copyOf(this.f2736k, i2);
        c cVar = this.r;
        cVar.f2726d = (i[]) Arrays.copyOf(cVar.f2726d, this.f2734i);
        int i3 = this.f2734i;
        this.n = new boolean[i3];
        this.f2735j = i3;
        this.q = i3;
        if (f2727b != null) {
            throw null;
        }
    }

    public void A() throws Exception {
        e eVar = f2727b;
        if (eVar == null) {
            if (!this.f2737l && !this.m) {
                B(this.f2733h);
                return;
            } else if (eVar != null) {
                throw null;
            } else {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.p) {
                        z = true;
                        break;
                    } else if (!this.f2736k[i2].f2723f) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    B(this.f2733h);
                    return;
                } else if (f2727b == null) {
                    n();
                    return;
                } else {
                    throw null;
                }
            }
        }
        throw null;
    }

    void B(a aVar) throws Exception {
        if (f2727b == null) {
            u(aVar);
            C(aVar, false);
            n();
            return;
        }
        throw null;
    }

    public void E() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.r;
            i[] iVarArr = cVar.f2726d;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.d();
            }
            i2++;
        }
        cVar.f2725c.a(this.s, this.t);
        this.t = 0;
        Arrays.fill(this.r.f2726d, (Object) null);
        HashMap<String, i> hashMap = this.f2732g;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2731f = 0;
        this.f2733h.clear();
        this.o = 1;
        for (int i3 = 0; i3 < this.p; i3++) {
            this.f2736k[i3].f2720c = false;
        }
        D();
        this.p = 0;
        if (f2728c) {
            this.u = new b(this.r);
        } else {
            this.u = new c.f.b.b(this.r);
        }
    }

    public void b(c.f.b.k.e eVar, c.f.b.k.e eVar2, float f2, int i2) {
        d.b bVar = d.b.LEFT;
        i q = q(eVar.n(bVar));
        d.b bVar2 = d.b.TOP;
        i q2 = q(eVar.n(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q3 = q(eVar.n(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q4 = q(eVar.n(bVar4));
        i q5 = q(eVar2.n(bVar));
        i q6 = q(eVar2.n(bVar2));
        i q7 = q(eVar2.n(bVar3));
        i q8 = q(eVar2.n(bVar4));
        c.f.b.b r = r();
        double d2 = f2;
        double d3 = i2;
        r.q(q2, q4, q6, q8, (float) (Math.sin(d2) * d3));
        d(r);
        c.f.b.b r2 = r();
        r2.q(q, q3, q5, q7, (float) (Math.cos(d2) * d3));
        d(r2);
    }

    public void c(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        c.f.b.b r = r();
        r.h(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 8) {
            r.d(this, i4);
        }
        d(r);
    }

    public void d(c.f.b.b bVar) {
        i w;
        if (bVar == null) {
            return;
        }
        if (f2727b == null) {
            boolean z = true;
            if (this.p + 1 >= this.q || this.o + 1 >= this.f2735j) {
                z();
            }
            boolean z2 = false;
            if (!bVar.f2723f) {
                bVar.D(this);
                if (bVar.u()) {
                    return;
                }
                bVar.r();
                if (bVar.f(this)) {
                    i p = p();
                    bVar.a = p;
                    l(bVar);
                    this.u.c(bVar);
                    C(this.u, true);
                    if (p.f2751e == -1) {
                        if (bVar.a == p && (w = bVar.w(p)) != null) {
                            if (f2727b == null) {
                                bVar.y(w);
                            } else {
                                throw null;
                            }
                        }
                        if (!bVar.f2723f) {
                            bVar.a.g(bVar);
                        }
                        this.p--;
                    }
                } else {
                    z = false;
                }
                if (!bVar.s()) {
                    return;
                }
                z2 = z;
            }
            if (z2) {
                return;
            }
            l(bVar);
            return;
        }
        throw null;
    }

    public c.f.b.b e(i iVar, i iVar2, int i2, int i3) {
        if (i3 == 8 && iVar2.f2754h && iVar.f2751e == -1) {
            iVar.e(this, iVar2.f2753g + i2);
            return null;
        }
        c.f.b.b r = r();
        r.n(iVar, iVar2, i2);
        if (i3 != 8) {
            r.d(this, i3);
        }
        d(r);
        return r;
    }

    public void f(i iVar, int i2) {
        int i3 = iVar.f2751e;
        if (i3 == -1) {
            iVar.e(this, i2);
        } else if (i3 != -1) {
            c.f.b.b bVar = this.f2736k[i3];
            if (bVar.f2723f) {
                bVar.f2719b = i2;
            } else if (bVar.f2722e.getCurrentSize() == 0) {
                bVar.f2723f = true;
                bVar.f2719b = i2;
            } else {
                c.f.b.b r = r();
                r.m(iVar, i2);
                d(r);
            }
        } else {
            c.f.b.b r2 = r();
            r2.i(iVar, i2);
            d(r2);
        }
    }

    public void g(i iVar, i iVar2, int i2, boolean z) {
        c.f.b.b r = r();
        i t = t();
        t.f2752f = 0;
        r.o(iVar, iVar2, t, i2);
        d(r);
    }

    public void h(i iVar, i iVar2, int i2, int i3) {
        c.f.b.b r = r();
        i t = t();
        t.f2752f = 0;
        r.o(iVar, iVar2, t, i2);
        if (i3 != 8) {
            m(r, (int) (r.f2722e.d(t) * (-1.0f)), i3);
        }
        d(r);
    }

    public void i(i iVar, i iVar2, int i2, boolean z) {
        c.f.b.b r = r();
        i t = t();
        t.f2752f = 0;
        r.p(iVar, iVar2, t, i2);
        d(r);
    }

    public void j(i iVar, i iVar2, int i2, int i3) {
        c.f.b.b r = r();
        i t = t();
        t.f2752f = 0;
        r.p(iVar, iVar2, t, i2);
        if (i3 != 8) {
            m(r, (int) (r.f2722e.d(t) * (-1.0f)), i3);
        }
        d(r);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        c.f.b.b r = r();
        r.k(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 8) {
            r.d(this, i2);
        }
        d(r);
    }

    void m(c.f.b.b bVar, int i2, int i3) {
        bVar.e(o(i3, null), i2);
    }

    public i o(int i2, String str) {
        if (f2727b == null) {
            if (this.o + 1 >= this.f2735j) {
                z();
            }
            i a2 = a(i.a.ERROR, str);
            int i3 = this.f2731f + 1;
            this.f2731f = i3;
            this.o++;
            a2.f2750d = i3;
            a2.f2752f = i2;
            this.r.f2726d[i3] = a2;
            this.f2733h.a(a2);
            return a2;
        }
        throw null;
    }

    public i p() {
        if (f2727b == null) {
            if (this.o + 1 >= this.f2735j) {
                z();
            }
            i a2 = a(i.a.SLACK, null);
            int i2 = this.f2731f + 1;
            this.f2731f = i2;
            this.o++;
            a2.f2750d = i2;
            this.r.f2726d[i2] = a2;
            return a2;
        }
        throw null;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.o + 1 >= this.f2735j) {
            z();
        }
        if (obj instanceof c.f.b.k.d) {
            c.f.b.k.d dVar = (c.f.b.k.d) obj;
            iVar = dVar.f();
            if (iVar == null) {
                dVar.m(this.r);
                iVar = dVar.f();
            }
            int i2 = iVar.f2750d;
            if (i2 == -1 || i2 > this.f2731f || this.r.f2726d[i2] == null) {
                if (i2 != -1) {
                    iVar.d();
                }
                int i3 = this.f2731f + 1;
                this.f2731f = i3;
                this.o++;
                iVar.f2750d = i3;
                iVar.f2757k = i.a.UNRESTRICTED;
                this.r.f2726d[i3] = iVar;
            }
        }
        return iVar;
    }

    public c.f.b.b r() {
        c.f.b.b acquire;
        if (f2728c) {
            acquire = this.r.a.acquire();
            if (acquire == null) {
                acquire = new b(this.r);
                f2730e++;
            } else {
                acquire.z();
            }
        } else {
            acquire = this.r.f2724b.acquire();
            if (acquire == null) {
                acquire = new c.f.b.b(this.r);
                f2729d++;
            } else {
                acquire.z();
            }
        }
        i.b();
        return acquire;
    }

    public i t() {
        if (f2727b == null) {
            if (this.o + 1 >= this.f2735j) {
                z();
            }
            i a2 = a(i.a.SLACK, null);
            int i2 = this.f2731f + 1;
            this.f2731f = i2;
            this.o++;
            a2.f2750d = i2;
            this.r.f2726d[i2] = a2;
            return a2;
        }
        throw null;
    }

    public void v(e eVar) {
    }

    public c w() {
        return this.r;
    }

    public int y(Object obj) {
        i f2 = ((c.f.b.k.d) obj).f();
        if (f2 != null) {
            return (int) (f2.f2753g + 0.5f);
        }
        return 0;
    }
}
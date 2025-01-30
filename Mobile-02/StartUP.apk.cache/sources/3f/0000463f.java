package e.f.j.e;

import android.content.Context;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import e.f.j.d.o;
import e.f.j.l.t0;

/* compiled from: ImagePipelineFactory.java */
/* loaded from: classes2.dex */
public class k {
    private static final Class<?> a = k.class;

    /* renamed from: b  reason: collision with root package name */
    private static k f12524b;

    /* renamed from: c  reason: collision with root package name */
    private final t0 f12525c;

    /* renamed from: d  reason: collision with root package name */
    private final i f12526d;

    /* renamed from: e  reason: collision with root package name */
    private final a f12527e;

    /* renamed from: f  reason: collision with root package name */
    private e.f.j.d.h<e.f.b.a.d, e.f.j.i.b> f12528f;

    /* renamed from: g  reason: collision with root package name */
    private o<e.f.b.a.d, e.f.j.i.b> f12529g;

    /* renamed from: h  reason: collision with root package name */
    private e.f.j.d.h<e.f.b.a.d, PooledByteBuffer> f12530h;

    /* renamed from: i  reason: collision with root package name */
    private o<e.f.b.a.d, PooledByteBuffer> f12531i;

    /* renamed from: j  reason: collision with root package name */
    private e.f.j.d.e f12532j;

    /* renamed from: k  reason: collision with root package name */
    private e.f.b.b.i f12533k;

    /* renamed from: l  reason: collision with root package name */
    private com.facebook.imagepipeline.decoder.b f12534l;
    private h m;
    private e.f.j.n.d n;
    private m o;
    private n p;
    private e.f.j.d.e q;
    private e.f.b.b.i r;
    private e.f.j.c.f s;
    private com.facebook.imagepipeline.platform.f t;
    private e.f.j.a.a.a u;

    public k(i iVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("ImagePipelineConfig()");
        }
        this.f12526d = (i) e.f.d.c.i.g(iVar);
        this.f12525c = new t0(iVar.k().b());
        this.f12527e = new a(iVar.f());
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    private e.f.j.a.a.a b() {
        if (this.u == null) {
            this.u = e.f.j.a.a.b.a(n(), this.f12526d.k(), c(), this.f12526d.l().p());
        }
        return this.u;
    }

    private com.facebook.imagepipeline.decoder.b h() {
        com.facebook.imagepipeline.decoder.b bVar;
        com.facebook.imagepipeline.decoder.b bVar2;
        if (this.f12534l == null) {
            if (this.f12526d.o() != null) {
                this.f12534l = this.f12526d.o();
            } else {
                e.f.j.a.a.a b2 = b();
                if (b2 != null) {
                    bVar2 = b2.b(this.f12526d.a());
                    bVar = b2.c(this.f12526d.a());
                } else {
                    bVar = null;
                    bVar2 = null;
                }
                if (this.f12526d.p() == null) {
                    this.f12534l = new com.facebook.imagepipeline.decoder.a(bVar2, bVar, o());
                } else {
                    o();
                    this.f12526d.p();
                    throw null;
                }
            }
        }
        return this.f12534l;
    }

    private e.f.j.n.d j() {
        if (this.n == null) {
            if (this.f12526d.q() == null && this.f12526d.s() == null && this.f12526d.l().m()) {
                this.n = new e.f.j.n.h(this.f12526d.l().d());
            } else {
                this.n = new e.f.j.n.f(this.f12526d.l().d(), this.f12526d.l().g(), this.f12526d.q(), this.f12526d.s());
            }
        }
        return this.n;
    }

    public static k k() {
        return (k) e.f.d.c.i.h(f12524b, "ImagePipelineFactory was not initialized!");
    }

    private m p() {
        if (this.o == null) {
            this.o = this.f12526d.l().e().a(this.f12526d.g(), this.f12526d.z().j(), h(), this.f12526d.A(), this.f12526d.E(), this.f12526d.F(), this.f12526d.l().j(), this.f12526d.k(), this.f12526d.z().h(this.f12526d.v()), d(), g(), l(), r(), this.f12526d.d(), n(), this.f12526d.l().c(), this.f12526d.l().b(), this.f12526d.l().a(), this.f12526d.l().d(), e());
        }
        return this.o;
    }

    private n q() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.f12526d.l().f();
        if (this.p == null) {
            this.p = new n(this.f12526d.g().getApplicationContext().getContentResolver(), p(), this.f12526d.y(), this.f12526d.F(), this.f12526d.l().o(), this.f12525c, this.f12526d.E(), z, this.f12526d.l().n(), this.f12526d.D(), j());
        }
        return this.p;
    }

    private e.f.j.d.e r() {
        if (this.q == null) {
            this.q = new e.f.j.d.e(s(), this.f12526d.z().h(this.f12526d.v()), this.f12526d.z().i(), this.f12526d.k().e(), this.f12526d.k().d(), this.f12526d.n());
        }
        return this.q;
    }

    public static synchronized void t(Context context) {
        synchronized (k.class) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("ImagePipelineFactory#initialize");
            }
            u(i.G(context).E());
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    public static synchronized void u(i iVar) {
        synchronized (k.class) {
            if (f12524b != null) {
                e.f.d.d.a.w(a, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            f12524b = new k(iVar);
        }
    }

    public e.f.j.h.a a(Context context) {
        e.f.j.a.a.a b2 = b();
        if (b2 == null) {
            return null;
        }
        return b2.a(context);
    }

    public e.f.j.d.h<e.f.b.a.d, e.f.j.i.b> c() {
        if (this.f12528f == null) {
            this.f12528f = e.f.j.d.a.a(this.f12526d.b(), this.f12526d.x(), this.f12526d.c());
        }
        return this.f12528f;
    }

    public o<e.f.b.a.d, e.f.j.i.b> d() {
        if (this.f12529g == null) {
            this.f12529g = e.f.j.d.b.a(c(), this.f12526d.n());
        }
        return this.f12529g;
    }

    public a e() {
        return this.f12527e;
    }

    public e.f.j.d.h<e.f.b.a.d, PooledByteBuffer> f() {
        if (this.f12530h == null) {
            this.f12530h = e.f.j.d.l.a(this.f12526d.j(), this.f12526d.x());
        }
        return this.f12530h;
    }

    public o<e.f.b.a.d, PooledByteBuffer> g() {
        if (this.f12531i == null) {
            this.f12531i = e.f.j.d.m.a(f(), this.f12526d.n());
        }
        return this.f12531i;
    }

    public h i() {
        if (this.m == null) {
            this.m = new h(q(), this.f12526d.B(), this.f12526d.t(), d(), g(), l(), r(), this.f12526d.d(), this.f12525c, e.f.d.c.m.a(Boolean.FALSE), this.f12526d.l().l(), this.f12526d.e());
        }
        return this.m;
    }

    public e.f.j.d.e l() {
        if (this.f12532j == null) {
            this.f12532j = new e.f.j.d.e(m(), this.f12526d.z().h(this.f12526d.v()), this.f12526d.z().i(), this.f12526d.k().e(), this.f12526d.k().d(), this.f12526d.n());
        }
        return this.f12532j;
    }

    public e.f.b.b.i m() {
        if (this.f12533k == null) {
            this.f12533k = this.f12526d.m().a(this.f12526d.u());
        }
        return this.f12533k;
    }

    public e.f.j.c.f n() {
        if (this.s == null) {
            this.s = e.f.j.c.g.a(this.f12526d.z(), o(), e());
        }
        return this.s;
    }

    public com.facebook.imagepipeline.platform.f o() {
        if (this.t == null) {
            this.t = com.facebook.imagepipeline.platform.g.a(this.f12526d.z(), this.f12526d.l().k());
        }
        return this.t;
    }

    public e.f.b.b.i s() {
        if (this.r == null) {
            this.r = this.f12526d.m().a(this.f12526d.C());
        }
        return this.r;
    }
}
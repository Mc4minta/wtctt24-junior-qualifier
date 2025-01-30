package h.c.u0;

import h.c.a0;
import h.c.n0.g.p;
import h.c.n0.g.q;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers.java */
/* loaded from: classes3.dex */
public final class a {
    static final a0 a = h.c.r0.a.h(new h());

    /* renamed from: b  reason: collision with root package name */
    static final a0 f16824b = h.c.r0.a.e(new b());

    /* renamed from: c  reason: collision with root package name */
    static final a0 f16825c = h.c.r0.a.f(new c());

    /* renamed from: d  reason: collision with root package name */
    static final a0 f16826d = q.f();

    /* renamed from: e  reason: collision with root package name */
    static final a0 f16827e = h.c.r0.a.g(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: h.c.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0402a {
        static final a0 a = new h.c.n0.g.b();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class b implements Callable<a0> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public a0 call() throws Exception {
            return C0402a.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class c implements Callable<a0> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public a0 call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class d {
        static final a0 a = new h.c.n0.g.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class e {
        static final a0 a = new h.c.n0.g.h();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class f implements Callable<a0> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public a0 call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class g {
        static final a0 a = new p();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class h implements Callable<a0> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public a0 call() throws Exception {
            return g.a;
        }
    }

    public static a0 a() {
        return h.c.r0.a.t(f16824b);
    }

    public static a0 b(Executor executor) {
        return new h.c.n0.g.d(executor, false);
    }

    public static a0 c() {
        return h.c.r0.a.v(f16825c);
    }

    public static a0 d() {
        return h.c.r0.a.x(a);
    }

    public static a0 e() {
        return f16826d;
    }
}
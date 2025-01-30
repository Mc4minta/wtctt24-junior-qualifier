package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes3.dex */
public final class b extends a0 {

    /* renamed from: b  reason: collision with root package name */
    static final C0398b f16627b;

    /* renamed from: c  reason: collision with root package name */
    static final k f16628c;

    /* renamed from: d  reason: collision with root package name */
    static final int f16629d = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e  reason: collision with root package name */
    static final c f16630e;

    /* renamed from: f  reason: collision with root package name */
    final ThreadFactory f16631f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<C0398b> f16632g;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends a0.c {
        private final h.c.n0.a.e a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.k0.a f16633b;

        /* renamed from: c  reason: collision with root package name */
        private final h.c.n0.a.e f16634c;

        /* renamed from: d  reason: collision with root package name */
        private final c f16635d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f16636e;

        a(c cVar) {
            this.f16635d = cVar;
            h.c.n0.a.e eVar = new h.c.n0.a.e();
            this.a = eVar;
            h.c.k0.a aVar = new h.c.k0.a();
            this.f16633b = aVar;
            h.c.n0.a.e eVar2 = new h.c.n0.a.e();
            this.f16634c = eVar2;
            eVar2.b(eVar);
            eVar2.b(aVar);
        }

        @Override // h.c.a0.c
        public h.c.k0.b b(Runnable runnable) {
            if (this.f16636e) {
                return h.c.n0.a.d.INSTANCE;
            }
            return this.f16635d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f16636e) {
                return h.c.n0.a.d.INSTANCE;
            }
            return this.f16635d.e(runnable, j2, timeUnit, this.f16633b);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16636e) {
                return;
            }
            this.f16636e = true;
            this.f16634c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16636e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: h.c.n0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0398b {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f16637b;

        /* renamed from: c  reason: collision with root package name */
        long f16638c;

        C0398b(int i2, ThreadFactory threadFactory) {
            this.a = i2;
            this.f16637b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f16637b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.a;
            if (i2 == 0) {
                return b.f16630e;
            }
            c[] cVarArr = this.f16637b;
            long j2 = this.f16638c;
            this.f16638c = 1 + j2;
            return cVarArr[(int) (j2 % i2)];
        }

        public void b() {
            for (c cVar : this.f16637b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends i {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new k("RxComputationShutdown"));
        f16630e = cVar;
        cVar.dispose();
        k kVar = new k("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f16628c = kVar;
        C0398b c0398b = new C0398b(0, kVar);
        f16627b = c0398b;
        c0398b.b();
    }

    public b() {
        this(f16628c);
    }

    static int f(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // h.c.a0
    public a0.c a() {
        return new a(this.f16632g.get().a());
    }

    @Override // h.c.a0
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f16632g.get().a().f(runnable, j2, timeUnit);
    }

    @Override // h.c.a0
    public h.c.k0.b e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.f16632g.get().a().g(runnable, j2, j3, timeUnit);
    }

    public void g() {
        C0398b c0398b = new C0398b(f16629d, this.f16631f);
        if (this.f16632g.compareAndSet(f16627b, c0398b)) {
            return;
        }
        c0398b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f16631f = threadFactory;
        this.f16632g = new AtomicReference<>(f16627b);
        g();
    }
}
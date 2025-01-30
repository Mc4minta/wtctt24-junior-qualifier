package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExecutorScheduler.java */
/* loaded from: classes3.dex */
public final class d extends a0 {

    /* renamed from: b  reason: collision with root package name */
    static final a0 f16639b = h.c.u0.a.d();

    /* renamed from: c  reason: collision with root package name */
    final boolean f16640c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f16641d;

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private final b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.a;
            bVar.f16643b.a(d.this.c(bVar));
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends AtomicReference<Runnable> implements Runnable, h.c.k0.b {
        final h.c.n0.a.g a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16643b;

        b(Runnable runnable) {
            super(runnable);
            this.a = new h.c.n0.a.g();
            this.f16643b = new h.c.n0.a.g();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.a.dispose();
                this.f16643b.dispose();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    h.c.n0.a.g gVar = this.a;
                    h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
                    gVar.lazySet(cVar);
                    this.f16643b.lazySet(cVar);
                } catch (Throwable th) {
                    lazySet(null);
                    this.a.lazySet(h.c.n0.a.c.DISPOSED);
                    this.f16643b.lazySet(h.c.n0.a.c.DISPOSED);
                    throw th;
                }
            }
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends a0.c implements Runnable {
        final boolean a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f16644b;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16646d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f16647e = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        final h.c.k0.a f16648f = new h.c.k0.a();

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.f.a<Runnable> f16645c = new h.c.n0.f.a<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes3.dex */
        public static final class a extends AtomicBoolean implements Runnable, h.c.k0.b {
            final Runnable a;

            a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // h.c.k0.b
            public void dispose() {
                lazySet(true);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.a.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes3.dex */
        public static final class b extends AtomicInteger implements Runnable, h.c.k0.b {
            final Runnable a;

            /* renamed from: b  reason: collision with root package name */
            final h.c.n0.a.b f16649b;

            /* renamed from: c  reason: collision with root package name */
            volatile Thread f16650c;

            b(Runnable runnable, h.c.n0.a.b bVar) {
                this.a = runnable;
                this.f16649b = bVar;
            }

            void a() {
                h.c.n0.a.b bVar = this.f16649b;
                if (bVar != null) {
                    bVar.c(this);
                }
            }

            @Override // h.c.k0.b
            public void dispose() {
                while (true) {
                    int i2 = get();
                    if (i2 >= 2) {
                        return;
                    }
                    if (i2 == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.f16650c;
                        if (thread != null) {
                            thread.interrupt();
                            this.f16650c = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f16650c = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.a.run();
                            this.f16650c = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                            return;
                        } catch (Throwable th) {
                            this.f16650c = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    }
                    this.f16650c = null;
                }
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: h.c.n0.g.d$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0399c implements Runnable {
            private final h.c.n0.a.g a;

            /* renamed from: b  reason: collision with root package name */
            private final Runnable f16651b;

            RunnableC0399c(h.c.n0.a.g gVar, Runnable runnable) {
                this.a = gVar;
                this.f16651b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.a(c.this.b(this.f16651b));
            }
        }

        public c(Executor executor, boolean z) {
            this.f16644b = executor;
            this.a = z;
        }

        @Override // h.c.a0.c
        public h.c.k0.b b(Runnable runnable) {
            h.c.k0.b aVar;
            if (this.f16646d) {
                return h.c.n0.a.d.INSTANCE;
            }
            Runnable w = h.c.r0.a.w(runnable);
            if (this.a) {
                aVar = new b(w, this.f16648f);
                this.f16648f.b(aVar);
            } else {
                aVar = new a(w);
            }
            this.f16645c.offer(aVar);
            if (this.f16647e.getAndIncrement() == 0) {
                try {
                    this.f16644b.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f16646d = true;
                    this.f16645c.clear();
                    h.c.r0.a.u(e2);
                    return h.c.n0.a.d.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return b(runnable);
            }
            if (this.f16646d) {
                return h.c.n0.a.d.INSTANCE;
            }
            h.c.n0.a.g gVar = new h.c.n0.a.g();
            h.c.n0.a.g gVar2 = new h.c.n0.a.g(gVar);
            n nVar = new n(new RunnableC0399c(gVar2, h.c.r0.a.w(runnable)), this.f16648f);
            this.f16648f.b(nVar);
            Executor executor = this.f16644b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    nVar.a(((ScheduledExecutorService) executor).schedule((Callable) nVar, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f16646d = true;
                    h.c.r0.a.u(e2);
                    return h.c.n0.a.d.INSTANCE;
                }
            } else {
                nVar.a(new h.c.n0.g.c(d.f16639b.d(nVar, j2, timeUnit)));
            }
            gVar.a(nVar);
            return gVar2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16646d) {
                return;
            }
            this.f16646d = true;
            this.f16648f.dispose();
            if (this.f16647e.getAndIncrement() == 0) {
                this.f16645c.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16646d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r3.f16646d == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
            r1 = r3.f16647e.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 != 0) goto L2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                h.c.n0.f.a<java.lang.Runnable> r0 = r3.f16645c
                r1 = 1
            L3:
                boolean r2 = r3.f16646d
                if (r2 == 0) goto Lb
                r0.clear()
                return
            Lb:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L25
                boolean r2 = r3.f16646d
                if (r2 == 0) goto L1b
                r0.clear()
                return
            L1b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f16647e
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L3
                return
            L25:
                r2.run()
                boolean r2 = r3.f16646d
                if (r2 == 0) goto Lb
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.g.d.c.run():void");
        }
    }

    public d(Executor executor, boolean z) {
        this.f16641d = executor;
        this.f16640c = z;
    }

    @Override // h.c.a0
    public a0.c a() {
        return new c(this.f16641d, this.f16640c);
    }

    @Override // h.c.a0
    public h.c.k0.b c(Runnable runnable) {
        Runnable w = h.c.r0.a.w(runnable);
        try {
            if (this.f16641d instanceof ExecutorService) {
                m mVar = new m(w);
                mVar.a(((ExecutorService) this.f16641d).submit(mVar));
                return mVar;
            } else if (this.f16640c) {
                c.b bVar = new c.b(w, null);
                this.f16641d.execute(bVar);
                return bVar;
            } else {
                c.a aVar = new c.a(w);
                this.f16641d.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e2) {
            h.c.r0.a.u(e2);
            return h.c.n0.a.d.INSTANCE;
        }
    }

    @Override // h.c.a0
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable w = h.c.r0.a.w(runnable);
        if (this.f16641d instanceof ScheduledExecutorService) {
            try {
                m mVar = new m(w);
                mVar.a(((ScheduledExecutorService) this.f16641d).schedule(mVar, j2, timeUnit));
                return mVar;
            } catch (RejectedExecutionException e2) {
                h.c.r0.a.u(e2);
                return h.c.n0.a.d.INSTANCE;
            }
        }
        b bVar = new b(w);
        bVar.a.a(f16639b.d(new a(bVar), j2, timeUnit));
        return bVar;
    }

    @Override // h.c.a0
    public h.c.k0.b e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (this.f16641d instanceof ScheduledExecutorService) {
            try {
                l lVar = new l(h.c.r0.a.w(runnable));
                lVar.a(((ScheduledExecutorService) this.f16641d).scheduleAtFixedRate(lVar, j2, j3, timeUnit));
                return lVar;
            } catch (RejectedExecutionException e2) {
                h.c.r0.a.u(e2);
                return h.c.n0.a.d.INSTANCE;
            }
        }
        return super.e(runnable, j2, j3, timeUnit);
    }
}
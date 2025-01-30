package h.c.n0.g;

import h.c.a0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes3.dex */
public final class g extends a0 {

    /* renamed from: b  reason: collision with root package name */
    static final k f16661b;

    /* renamed from: c  reason: collision with root package name */
    static final k f16662c;

    /* renamed from: f  reason: collision with root package name */
    static final c f16665f;

    /* renamed from: g  reason: collision with root package name */
    static final a f16666g;

    /* renamed from: h  reason: collision with root package name */
    final ThreadFactory f16667h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicReference<a> f16668i;

    /* renamed from: e  reason: collision with root package name */
    private static final TimeUnit f16664e = TimeUnit.SECONDS;

    /* renamed from: d  reason: collision with root package name */
    private static final long f16663d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {
        private final long a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f16669b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.k0.a f16670c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f16671d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f16672e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f16673f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.a = nanos;
            this.f16669b = new ConcurrentLinkedQueue<>();
            this.f16670c = new h.c.k0.a();
            this.f16673f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, g.f16662c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f16671d = scheduledExecutorService;
            this.f16672e = scheduledFuture;
        }

        void a() {
            if (this.f16669b.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f16669b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.i() > c2) {
                    return;
                }
                if (this.f16669b.remove(next)) {
                    this.f16670c.a(next);
                }
            }
        }

        c b() {
            if (this.f16670c.isDisposed()) {
                return g.f16665f;
            }
            while (!this.f16669b.isEmpty()) {
                c poll = this.f16669b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f16673f);
            this.f16670c.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.j(c() + this.a);
            this.f16669b.offer(cVar);
        }

        void e() {
            this.f16670c.dispose();
            Future<?> future = this.f16672e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f16671d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends a0.c {

        /* renamed from: b  reason: collision with root package name */
        private final a f16674b;

        /* renamed from: c  reason: collision with root package name */
        private final c f16675c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f16676d = new AtomicBoolean();
        private final h.c.k0.a a = new h.c.k0.a();

        b(a aVar) {
            this.f16674b = aVar;
            this.f16675c = aVar.b();
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.a.isDisposed()) {
                return h.c.n0.a.d.INSTANCE;
            }
            return this.f16675c.e(runnable, j2, timeUnit, this.a);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16676d.compareAndSet(false, true)) {
                this.a.dispose();
                this.f16674b.d(this.f16675c);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16676d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends i {

        /* renamed from: c  reason: collision with root package name */
        private long f16677c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f16677c = 0L;
        }

        public long i() {
            return this.f16677c;
        }

        public void j(long j2) {
            this.f16677c = j2;
        }
    }

    static {
        c cVar = new c(new k("RxCachedThreadSchedulerShutdown"));
        f16665f = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        k kVar = new k("RxCachedThreadScheduler", max);
        f16661b = kVar;
        f16662c = new k("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, kVar);
        f16666g = aVar;
        aVar.e();
    }

    public g() {
        this(f16661b);
    }

    @Override // h.c.a0
    public a0.c a() {
        return new b(this.f16668i.get());
    }

    public void f() {
        a aVar = new a(f16663d, f16664e, this.f16667h);
        if (this.f16668i.compareAndSet(f16666g, aVar)) {
            return;
        }
        aVar.e();
    }

    public g(ThreadFactory threadFactory) {
        this.f16667h = threadFactory;
        this.f16668i = new AtomicReference<>(f16666g);
        f();
    }
}
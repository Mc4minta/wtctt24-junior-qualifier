package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes3.dex */
public final class p extends a0 {

    /* renamed from: b  reason: collision with root package name */
    static final k f16691b;

    /* renamed from: c  reason: collision with root package name */
    static final ScheduledExecutorService f16692c;

    /* renamed from: d  reason: collision with root package name */
    final ThreadFactory f16693d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f16694e;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends a0.c {
        final ScheduledExecutorService a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.k0.a f16695b = new h.c.k0.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f16696c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f16696c) {
                return h.c.n0.a.d.INSTANCE;
            }
            n nVar = new n(h.c.r0.a.w(runnable), this.f16695b);
            this.f16695b.b(nVar);
            try {
                if (j2 <= 0) {
                    schedule = this.a.submit((Callable) nVar);
                } else {
                    schedule = this.a.schedule((Callable) nVar, j2, timeUnit);
                }
                nVar.a(schedule);
                return nVar;
            } catch (RejectedExecutionException e2) {
                dispose();
                h.c.r0.a.u(e2);
                return h.c.n0.a.d.INSTANCE;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16696c) {
                return;
            }
            this.f16696c = true;
            this.f16695b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16696c;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f16692c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f16691b = new k("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public p() {
        this(f16691b);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return o.a(threadFactory);
    }

    @Override // h.c.a0
    public a0.c a() {
        return new a(this.f16694e.get());
    }

    @Override // h.c.a0
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        m mVar = new m(h.c.r0.a.w(runnable));
        try {
            if (j2 <= 0) {
                schedule = this.f16694e.get().submit(mVar);
            } else {
                schedule = this.f16694e.get().schedule(mVar, j2, timeUnit);
            }
            mVar.a(schedule);
            return mVar;
        } catch (RejectedExecutionException e2) {
            h.c.r0.a.u(e2);
            return h.c.n0.a.d.INSTANCE;
        }
    }

    @Override // h.c.a0
    public h.c.k0.b e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable w = h.c.r0.a.w(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f16694e.get();
            f fVar = new f(w, scheduledExecutorService);
            try {
                if (j2 <= 0) {
                    schedule = scheduledExecutorService.submit(fVar);
                } else {
                    schedule = scheduledExecutorService.schedule(fVar, j2, timeUnit);
                }
                fVar.b(schedule);
                return fVar;
            } catch (RejectedExecutionException e2) {
                h.c.r0.a.u(e2);
                return h.c.n0.a.d.INSTANCE;
            }
        }
        l lVar = new l(w);
        try {
            lVar.a(this.f16694e.get().scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            h.c.r0.a.u(e3);
            return h.c.n0.a.d.INSTANCE;
        }
    }

    public p(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f16694e = atomicReference;
        this.f16693d = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }
}
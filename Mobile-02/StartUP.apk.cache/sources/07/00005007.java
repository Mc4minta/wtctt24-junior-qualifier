package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class i extends a0.c implements h.c.k0.b {
    private final ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f16680b;

    public i(ThreadFactory threadFactory) {
        this.a = o.a(threadFactory);
    }

    @Override // h.c.a0.c
    public h.c.k0.b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // h.c.a0.c
    public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (this.f16680b) {
            return h.c.n0.a.d.INSTANCE;
        }
        return e(runnable, j2, timeUnit, null);
    }

    @Override // h.c.k0.b
    public void dispose() {
        if (this.f16680b) {
            return;
        }
        this.f16680b = true;
        this.a.shutdownNow();
    }

    public n e(Runnable runnable, long j2, TimeUnit timeUnit, h.c.n0.a.b bVar) {
        Future<?> schedule;
        n nVar = new n(h.c.r0.a.w(runnable), bVar);
        if (bVar == null || bVar.b(nVar)) {
            try {
                if (j2 <= 0) {
                    schedule = this.a.submit((Callable) nVar);
                } else {
                    schedule = this.a.schedule((Callable) nVar, j2, timeUnit);
                }
                nVar.a(schedule);
            } catch (RejectedExecutionException e2) {
                if (bVar != null) {
                    bVar.a(nVar);
                }
                h.c.r0.a.u(e2);
            }
            return nVar;
        }
        return nVar;
    }

    public h.c.k0.b f(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        m mVar = new m(h.c.r0.a.w(runnable));
        try {
            if (j2 <= 0) {
                schedule = this.a.submit(mVar);
            } else {
                schedule = this.a.schedule(mVar, j2, timeUnit);
            }
            mVar.a(schedule);
            return mVar;
        } catch (RejectedExecutionException e2) {
            h.c.r0.a.u(e2);
            return h.c.n0.a.d.INSTANCE;
        }
    }

    public h.c.k0.b g(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable w = h.c.r0.a.w(runnable);
        if (j3 <= 0) {
            f fVar = new f(w, this.a);
            try {
                if (j2 <= 0) {
                    schedule = this.a.submit(fVar);
                } else {
                    schedule = this.a.schedule(fVar, j2, timeUnit);
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
            lVar.a(this.a.scheduleAtFixedRate(lVar, j2, j3, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e3) {
            h.c.r0.a.u(e3);
            return h.c.n0.a.d.INSTANCE;
        }
    }

    public void h() {
        if (this.f16680b) {
            return;
        }
        this.f16680b = true;
        this.a.shutdown();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f16680b;
    }
}
package h.c.n0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes3.dex */
public final class f implements Callable<Void>, h.c.k0.b {
    static final FutureTask<Void> a = new FutureTask<>(h.c.n0.b.a.f14095b, null);

    /* renamed from: b  reason: collision with root package name */
    final Runnable f16656b;

    /* renamed from: e  reason: collision with root package name */
    final ExecutorService f16659e;

    /* renamed from: f  reason: collision with root package name */
    Thread f16660f;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<Future<?>> f16658d = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f16657c = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Runnable runnable, ExecutorService executorService) {
        this.f16656b = runnable;
        this.f16659e = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.f16660f = Thread.currentThread();
        try {
            this.f16656b.run();
            c(this.f16659e.submit(this));
            this.f16660f = null;
        } catch (Throwable th) {
            this.f16660f = null;
            h.c.r0.a.u(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f16658d.get();
            if (future2 == a) {
                future.cancel(this.f16660f != Thread.currentThread());
                return;
            }
        } while (!this.f16658d.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f16657c.get();
            if (future2 == a) {
                future.cancel(this.f16660f != Thread.currentThread());
                return;
            }
        } while (!this.f16657c.compareAndSet(future2, future));
    }

    @Override // h.c.k0.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f16658d;
        FutureTask<Void> futureTask = a;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f16660f != Thread.currentThread());
        }
        Future<?> andSet2 = this.f16657c.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f16660f != Thread.currentThread());
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f16658d.get() == a;
    }
}
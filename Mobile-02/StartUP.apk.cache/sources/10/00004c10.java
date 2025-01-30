package h.c.n0.d;

import h.c.e0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSingleObserver.java */
/* loaded from: classes.dex */
public final class q<T> extends CountDownLatch implements e0<T>, Future<T>, h.c.k0.b {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f14134b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f14135c;

    public q() {
        super(1);
        this.f14135c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        h.c.k0.b bVar;
        h.c.n0.a.c cVar;
        do {
            bVar = this.f14135c.get();
            if (bVar == this || bVar == (cVar = h.c.n0.a.c.DISPOSED)) {
                return false;
            }
        } while (!this.f14135c.compareAndSet(bVar, cVar));
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // h.c.k0.b
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            h.c.n0.j.e.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f14134b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return h.c.n0.a.c.n(this.f14135c.get());
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        h.c.k0.b bVar;
        do {
            bVar = this.f14135c.get();
            if (bVar == h.c.n0.a.c.DISPOSED) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14134b = th;
        } while (!this.f14135c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this.f14135c, bVar);
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        h.c.k0.b bVar = this.f14135c.get();
        if (bVar == h.c.n0.a.c.DISPOSED) {
            return;
        }
        this.a = t;
        this.f14135c.compareAndSet(bVar, this);
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            h.c.n0.j.e.b();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException(h.c.n0.j.j.d(j2, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f14134b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
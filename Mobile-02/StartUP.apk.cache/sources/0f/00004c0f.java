package h.c.n0.d;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureObserver.java */
/* loaded from: classes.dex */
public final class p<T> extends CountDownLatch implements h.c.z<T>, Future<T>, h.c.k0.b {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f14132b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f14133c;

    public p() {
        super(1);
        this.f14133c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        h.c.k0.b bVar;
        h.c.n0.a.c cVar;
        do {
            bVar = this.f14133c.get();
            if (bVar == this || bVar == (cVar = h.c.n0.a.c.DISPOSED)) {
                return false;
            }
        } while (!this.f14133c.compareAndSet(bVar, cVar));
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
            Throwable th = this.f14132b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return h.c.n0.a.c.n(this.f14133c.get());
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        h.c.k0.b bVar;
        if (this.a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            bVar = this.f14133c.get();
            if (bVar == this || bVar == h.c.n0.a.c.DISPOSED) {
                return;
            }
        } while (!this.f14133c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.k0.b bVar;
        if (this.f14132b == null) {
            this.f14132b = th;
            do {
                bVar = this.f14133c.get();
                if (bVar == this || bVar == h.c.n0.a.c.DISPOSED) {
                    h.c.r0.a.u(th);
                    return;
                }
            } while (!this.f14133c.compareAndSet(bVar, this));
            countDown();
            return;
        }
        h.c.r0.a.u(th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.a != null) {
            this.f14133c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.a = t;
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this.f14133c, bVar);
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
            Throwable th = this.f14132b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
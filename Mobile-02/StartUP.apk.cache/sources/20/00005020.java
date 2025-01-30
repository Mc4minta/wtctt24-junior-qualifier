package h.c.n0.h;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSubscriber.java */
/* loaded from: classes3.dex */
public final class i<T> extends CountDownLatch implements h.c.m<T>, Future<T>, k.a.d {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f16728b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<k.a.d> f16729c;

    public i() {
        super(1);
        this.f16729c = new AtomicReference<>();
    }

    @Override // k.a.d
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        k.a.d dVar;
        h.c.n0.i.g gVar;
        do {
            dVar = this.f16729c.get();
            if (dVar == this || dVar == (gVar = h.c.n0.i.g.CANCELLED)) {
                return false;
            }
        } while (!this.f16729c.compareAndSet(dVar, gVar));
        if (dVar != null) {
            dVar.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            h.c.n0.j.e.b();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f16728b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f16729c.get() == h.c.n0.i.g.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // k.a.c
    public void onComplete() {
        k.a.d dVar;
        if (this.a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            dVar = this.f16729c.get();
            if (dVar == this || dVar == h.c.n0.i.g.CANCELLED) {
                return;
            }
        } while (!this.f16729c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        k.a.d dVar;
        do {
            dVar = this.f16729c.get();
            if (dVar != this && dVar != h.c.n0.i.g.CANCELLED) {
                this.f16728b = th;
            } else {
                h.c.r0.a.u(th);
                return;
            }
        } while (!this.f16729c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (this.a != null) {
            this.f16729c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.a = t;
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        h.c.n0.i.g.A(this.f16729c, dVar, Long.MAX_VALUE);
    }

    @Override // k.a.d
    public void request(long j2) {
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
            Throwable th = this.f16728b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
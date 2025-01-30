package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: BlockingFlowableIterable.java */
/* loaded from: classes3.dex */
public final class b<T> implements Iterable<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f14207b;

    /* compiled from: BlockingFlowableIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<k.a.d> implements h.c.m<T>, Iterator<T>, Runnable, h.c.k0.b {
        final h.c.n0.f.b<T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14208b;

        /* renamed from: c  reason: collision with root package name */
        final long f14209c;

        /* renamed from: d  reason: collision with root package name */
        final Lock f14210d;

        /* renamed from: e  reason: collision with root package name */
        final Condition f14211e;

        /* renamed from: f  reason: collision with root package name */
        long f14212f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14213g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f14214h;

        a(int i2) {
            this.a = new h.c.n0.f.b<>(i2);
            this.f14208b = i2;
            this.f14209c = i2 - (i2 >> 2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f14210d = reentrantLock;
            this.f14211e = reentrantLock.newCondition();
        }

        void b() {
            this.f14210d.lock();
            try {
                this.f14211e.signalAll();
            } finally {
                this.f14210d.unlock();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.i.g.h(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.f14213g;
                boolean isEmpty = this.a.isEmpty();
                if (z) {
                    Throwable th = this.f14214h;
                    if (th != null) {
                        throw h.c.n0.j.j.e(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                h.c.n0.j.e.b();
                this.f14210d.lock();
                while (!this.f14213g && this.a.isEmpty()) {
                    try {
                        try {
                            this.f14211e.await();
                        } catch (InterruptedException e2) {
                            run();
                            throw h.c.n0.j.j.e(e2);
                        }
                    } finally {
                        this.f14210d.unlock();
                    }
                }
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.i.g.CANCELLED;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T poll = this.a.poll();
                long j2 = this.f14212f + 1;
                if (j2 == this.f14209c) {
                    this.f14212f = 0L;
                    get().request(j2);
                } else {
                    this.f14212f = j2;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14213g = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14214h = th;
            this.f14213g = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (!this.a.offer(t)) {
                h.c.n0.i.g.h(this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, this.f14208b);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            h.c.n0.i.g.h(this);
            b();
        }
    }

    public b(h.c.h<T> hVar, int i2) {
        this.a = hVar;
        this.f14207b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f14207b);
        this.a.subscribe((h.c.m) aVar);
        return aVar;
    }
}
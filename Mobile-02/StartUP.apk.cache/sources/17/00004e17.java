package h.c.n0.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: BlockingObservableIterable.java */
/* loaded from: classes3.dex */
public final class b<T> implements Iterable<T> {
    final h.c.x<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f15518b;

    /* compiled from: BlockingObservableIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, Iterator<T>, h.c.k0.b {
        final h.c.n0.f.c<T> a;

        /* renamed from: b  reason: collision with root package name */
        final Lock f15519b;

        /* renamed from: c  reason: collision with root package name */
        final Condition f15520c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f15521d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f15522e;

        a(int i2) {
            this.a = new h.c.n0.f.c<>(i2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f15519b = reentrantLock;
            this.f15520c = reentrantLock.newCondition();
        }

        void b() {
            this.f15519b.lock();
            try {
                this.f15520c.signalAll();
            } finally {
                this.f15519b.unlock();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.f15521d;
                boolean isEmpty = this.a.isEmpty();
                if (z) {
                    Throwable th = this.f15522e;
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
                try {
                    h.c.n0.j.e.b();
                    this.f15519b.lock();
                    while (!this.f15521d && this.a.isEmpty()) {
                        this.f15520c.await();
                    }
                    this.f15519b.unlock();
                } catch (InterruptedException e2) {
                    h.c.n0.a.c.h(this);
                    b();
                    throw h.c.n0.j.j.e(e2);
                }
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.a.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15521d = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15522e = th;
            this.f15521d = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.offer(t);
            b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public b(h.c.x<? extends T> xVar, int i2) {
        this.a = xVar;
        this.f15518b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f15518b);
        this.a.subscribe(aVar);
        return aVar;
    }
}
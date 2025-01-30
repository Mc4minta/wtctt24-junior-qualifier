package h.c.n0.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObservableLatest.java */
/* loaded from: classes3.dex */
public final class c<T> implements Iterable<T> {
    final h.c.x<T> a;

    /* compiled from: BlockingObservableLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.p0.d<h.c.r<T>> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        h.c.r<T> f15530b;

        /* renamed from: c  reason: collision with root package name */
        final Semaphore f15531c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.r<T>> f15532d = new AtomicReference<>();

        a() {
        }

        @Override // h.c.z, k.a.c
        /* renamed from: c */
        public void onNext(h.c.r<T> rVar) {
            if (this.f15532d.getAndSet(rVar) == null) {
                this.f15531c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            h.c.r<T> rVar = this.f15530b;
            if (rVar != null && rVar.g()) {
                throw h.c.n0.j.j.e(this.f15530b.d());
            }
            if (this.f15530b == null) {
                try {
                    h.c.n0.j.e.b();
                    this.f15531c.acquire();
                    h.c.r<T> andSet = this.f15532d.getAndSet(null);
                    this.f15530b = andSet;
                    if (andSet.g()) {
                        throw h.c.n0.j.j.e(andSet.d());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f15530b = h.c.r.b(e2);
                    throw h.c.n0.j.j.e(e2);
                }
            }
            return this.f15530b.h();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T e2 = this.f15530b.e();
                this.f15530b = null;
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.r0.a.u(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        h.c.s.wrap(this.a).materialize().subscribe(aVar);
        return aVar;
    }
}
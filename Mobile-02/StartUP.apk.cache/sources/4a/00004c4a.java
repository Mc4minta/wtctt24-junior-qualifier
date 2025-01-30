package h.c.n0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingFlowableLatest.java */
/* loaded from: classes3.dex */
public final class c<T> implements Iterable<T> {
    final k.a.b<? extends T> a;

    /* compiled from: BlockingFlowableLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.w0.b<h.c.r<T>> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        final Semaphore f14245b = new Semaphore(0);

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<h.c.r<T>> f14246c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        h.c.r<T> f14247d;

        a() {
        }

        @Override // k.a.c
        /* renamed from: d */
        public void onNext(h.c.r<T> rVar) {
            if (this.f14246c.getAndSet(rVar) == null) {
                this.f14245b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            h.c.r<T> rVar = this.f14247d;
            if (rVar != null && rVar.g()) {
                throw h.c.n0.j.j.e(this.f14247d.d());
            }
            h.c.r<T> rVar2 = this.f14247d;
            if ((rVar2 == null || rVar2.h()) && this.f14247d == null) {
                try {
                    h.c.n0.j.e.b();
                    this.f14245b.acquire();
                    h.c.r<T> andSet = this.f14246c.getAndSet(null);
                    this.f14247d = andSet;
                    if (andSet.g()) {
                        throw h.c.n0.j.j.e(andSet.d());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f14247d = h.c.r.b(e2);
                    throw h.c.n0.j.j.e(e2);
                }
            }
            return this.f14247d.h();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.f14247d.h()) {
                T e2 = this.f14247d.e();
                this.f14247d = null;
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // k.a.c
        public void onComplete() {
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.r0.a.u(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(k.a.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        h.c.h.fromPublisher(this.a).materialize().subscribe((h.c.m<? super h.c.r<T>>) aVar);
        return aVar;
    }
}
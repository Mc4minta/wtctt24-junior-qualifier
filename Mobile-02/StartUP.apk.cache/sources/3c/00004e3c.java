package h.c.n0.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingObservableNext.java */
/* loaded from: classes3.dex */
public final class e<T> implements Iterable<T> {
    final h.c.x<T> a;

    /* compiled from: BlockingObservableNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements Iterator<T> {
        private final b<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.x<T> f15615b;

        /* renamed from: c  reason: collision with root package name */
        private T f15616c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15617d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15618e = true;

        /* renamed from: f  reason: collision with root package name */
        private Throwable f15619f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f15620g;

        a(h.c.x<T> xVar, b<T> bVar) {
            this.f15615b = xVar;
            this.a = bVar;
        }

        private boolean b() {
            if (!this.f15620g) {
                this.f15620g = true;
                this.a.d();
                new x1(this.f15615b).subscribe(this.a);
            }
            try {
                h.c.r<T> e2 = this.a.e();
                if (e2.h()) {
                    this.f15618e = false;
                    this.f15616c = e2.e();
                    return true;
                }
                this.f15617d = false;
                if (e2.f()) {
                    return false;
                }
                Throwable d2 = e2.d();
                this.f15619f = d2;
                throw h.c.n0.j.j.e(d2);
            } catch (InterruptedException e3) {
                this.a.dispose();
                this.f15619f = e3;
                throw h.c.n0.j.j.e(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f15619f;
            if (th == null) {
                if (this.f15617d) {
                    return !this.f15618e || b();
                }
                return false;
            }
            throw h.c.n0.j.j.e(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f15619f;
            if (th == null) {
                if (hasNext()) {
                    this.f15618e = true;
                    return this.f15616c;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw h.c.n0.j.j.e(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingObservableNext.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends h.c.p0.d<h.c.r<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue<h.c.r<T>> f15621b = new ArrayBlockingQueue(1);

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f15622c = new AtomicInteger();

        b() {
        }

        @Override // h.c.z, k.a.c
        /* renamed from: c */
        public void onNext(h.c.r<T> rVar) {
            if (this.f15622c.getAndSet(0) == 1 || !rVar.h()) {
                while (!this.f15621b.offer(rVar)) {
                    h.c.r<T> poll = this.f15621b.poll();
                    if (poll != null && !poll.h()) {
                        rVar = poll;
                    }
                }
            }
        }

        void d() {
            this.f15622c.set(1);
        }

        public h.c.r<T> e() throws InterruptedException {
            d();
            h.c.n0.j.e.b();
            return this.f15621b.take();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.r0.a.u(th);
        }
    }

    public e(h.c.x<T> xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
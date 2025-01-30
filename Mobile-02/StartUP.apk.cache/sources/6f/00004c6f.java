package h.c.n0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BlockingFlowableNext.java */
/* loaded from: classes3.dex */
public final class e<T> implements Iterable<T> {
    final k.a.b<? extends T> a;

    /* compiled from: BlockingFlowableNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements Iterator<T> {
        private final b<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final k.a.b<? extends T> f14328b;

        /* renamed from: c  reason: collision with root package name */
        private T f14329c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14330d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14331e = true;

        /* renamed from: f  reason: collision with root package name */
        private Throwable f14332f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f14333g;

        a(k.a.b<? extends T> bVar, b<T> bVar2) {
            this.f14328b = bVar;
            this.a = bVar2;
        }

        private boolean b() {
            try {
                if (!this.f14333g) {
                    this.f14333g = true;
                    this.a.e();
                    h.c.h.fromPublisher(this.f14328b).materialize().subscribe((h.c.m<? super h.c.r<T>>) this.a);
                }
                h.c.r<T> f2 = this.a.f();
                if (f2.h()) {
                    this.f14331e = false;
                    this.f14329c = f2.e();
                    return true;
                }
                this.f14330d = false;
                if (f2.f()) {
                    return false;
                }
                if (f2.g()) {
                    Throwable d2 = f2.d();
                    this.f14332f = d2;
                    throw h.c.n0.j.j.e(d2);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e2) {
                this.a.dispose();
                this.f14332f = e2;
                throw h.c.n0.j.j.e(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f14332f;
            if (th == null) {
                if (this.f14330d) {
                    return !this.f14331e || b();
                }
                return false;
            }
            throw h.c.n0.j.j.e(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f14332f;
            if (th == null) {
                if (hasNext()) {
                    this.f14331e = true;
                    return this.f14329c;
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
    /* compiled from: BlockingFlowableNext.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends h.c.w0.b<h.c.r<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue<h.c.r<T>> f14334b = new ArrayBlockingQueue(1);

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f14335c = new AtomicInteger();

        b() {
        }

        @Override // k.a.c
        /* renamed from: d */
        public void onNext(h.c.r<T> rVar) {
            if (this.f14335c.getAndSet(0) == 1 || !rVar.h()) {
                while (!this.f14334b.offer(rVar)) {
                    h.c.r<T> poll = this.f14334b.poll();
                    if (poll != null && !poll.h()) {
                        rVar = poll;
                    }
                }
            }
        }

        void e() {
            this.f14335c.set(1);
        }

        public h.c.r<T> f() throws InterruptedException {
            e();
            h.c.n0.j.e.b();
            return this.f14334b.take();
        }

        @Override // k.a.c
        public void onComplete() {
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.r0.a.u(th);
        }
    }

    public e(k.a.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.a, new b());
    }
}
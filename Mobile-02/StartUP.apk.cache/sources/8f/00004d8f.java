package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class u4<T, B> extends h.c.n0.e.b.a<T, h.c.h<T>> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends k.a.b<B>> f15102b;

    /* renamed from: c  reason: collision with root package name */
    final int f15103c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, B> extends h.c.w0.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f15104b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15105c;

        a(b<T, B> bVar) {
            this.f15104b = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15105c) {
                return;
            }
            this.f15105c = true;
            this.f15104b.c();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15105c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15105c = true;
            this.f15104b.d(th);
        }

        @Override // k.a.c
        public void onNext(B b2) {
            if (this.f15105c) {
                return;
            }
            this.f15105c = true;
            dispose();
            this.f15104b.e(this);
        }
    }

    /* compiled from: FlowableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        static final a<Object, Object> a = new a<>(null);

        /* renamed from: b  reason: collision with root package name */
        static final Object f15106b = new Object();

        /* renamed from: c  reason: collision with root package name */
        final k.a.c<? super h.c.h<T>> f15107c;

        /* renamed from: d  reason: collision with root package name */
        final int f15108d;

        /* renamed from: k  reason: collision with root package name */
        final Callable<? extends k.a.b<B>> f15114k;
        k.a.d m;
        volatile boolean n;
        h.c.s0.c<T> p;
        long q;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<a<T, B>> f15109e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f15110f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.a<Object> f15111g = new h.c.n0.f.a<>();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.c f15112h = new h.c.n0.j.c();

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f15113j = new AtomicBoolean();

        /* renamed from: l  reason: collision with root package name */
        final AtomicLong f15115l = new AtomicLong();

        b(k.a.c<? super h.c.h<T>> cVar, int i2, Callable<? extends k.a.b<B>> callable) {
            this.f15107c = cVar;
            this.f15108d = i2;
            this.f15114k = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar = a;
            h.c.k0.b bVar = (h.c.k0.b) this.f15109e.getAndSet(aVar);
            if (bVar == null || bVar == aVar) {
                return;
            }
            bVar.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super h.c.h<T>> cVar = this.f15107c;
            h.c.n0.f.a<Object> aVar = this.f15111g;
            h.c.n0.j.c cVar2 = this.f15112h;
            long j2 = this.q;
            int i2 = 1;
            while (this.f15110f.get() != 0) {
                h.c.s0.c<T> cVar3 = this.p;
                boolean z = this.n;
                if (z && cVar2.get() != null) {
                    aVar.clear();
                    Throwable b2 = cVar2.b();
                    if (cVar3 != 0) {
                        this.p = null;
                        cVar3.onError(b2);
                    }
                    cVar.onError(b2);
                    return;
                }
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = cVar2.b();
                    if (b3 == null) {
                        if (cVar3 != 0) {
                            this.p = null;
                            cVar3.onComplete();
                        }
                        cVar.onComplete();
                        return;
                    }
                    if (cVar3 != 0) {
                        this.p = null;
                        cVar3.onError(b3);
                    }
                    cVar.onError(b3);
                    return;
                } else if (z2) {
                    this.q = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll != f15106b) {
                    cVar3.onNext(poll);
                } else {
                    if (cVar3 != 0) {
                        this.p = null;
                        cVar3.onComplete();
                    }
                    if (!this.f15113j.get()) {
                        if (j2 != this.f15115l.get()) {
                            h.c.s0.c<T> f2 = h.c.s0.c.f(this.f15108d, this);
                            this.p = f2;
                            this.f15110f.getAndIncrement();
                            try {
                                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15114k.call(), "The other Callable returned a null Publisher");
                                a<T, B> aVar2 = new a<>(this);
                                if (this.f15109e.compareAndSet(null, aVar2)) {
                                    bVar.subscribe(aVar2);
                                    j2++;
                                    cVar.onNext(f2);
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                cVar2.a(th);
                                this.n = true;
                            }
                        } else {
                            this.m.cancel();
                            a();
                            cVar2.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.n = true;
                        }
                    }
                }
            }
            aVar.clear();
            this.p = null;
        }

        void c() {
            this.m.cancel();
            this.n = true;
            b();
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15113j.compareAndSet(false, true)) {
                a();
                if (this.f15110f.decrementAndGet() == 0) {
                    this.m.cancel();
                }
            }
        }

        void d(Throwable th) {
            this.m.cancel();
            if (this.f15112h.a(th)) {
                this.n = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        void e(a<T, B> aVar) {
            this.f15109e.compareAndSet(aVar, null);
            this.f15111g.offer(f15106b);
            b();
        }

        @Override // k.a.c
        public void onComplete() {
            a();
            this.n = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            a();
            if (this.f15112h.a(th)) {
                this.n = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15111g.offer(t);
            b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.m, dVar)) {
                this.m = dVar;
                this.f15107c.onSubscribe(this);
                this.f15111g.offer(f15106b);
                b();
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15115l, j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15110f.decrementAndGet() == 0) {
                this.m.cancel();
            }
        }
    }

    public u4(h.c.h<T> hVar, Callable<? extends k.a.b<B>> callable, int i2) {
        super(hVar);
        this.f15102b = callable;
        this.f15103c = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.h<T>> cVar) {
        this.a.subscribe((h.c.m) new b(cVar, this.f15103c, this.f15102b));
    }
}
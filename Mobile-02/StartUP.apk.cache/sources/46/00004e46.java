package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundary.java */
/* loaded from: classes3.dex */
public final class e4<T, B> extends h.c.n0.e.e.a<T, h.c.s<T>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<B> f15634b;

    /* renamed from: c  reason: collision with root package name */
    final int f15635c;

    /* compiled from: ObservableWindowBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, B> extends h.c.p0.d<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f15636b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15637c;

        a(b<T, B> bVar) {
            this.f15636b = bVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15637c) {
                return;
            }
            this.f15637c = true;
            this.f15636b.b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15637c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15637c = true;
            this.f15636b.c(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(B b2) {
            if (this.f15637c) {
                return;
            }
            this.f15636b.d();
        }
    }

    /* compiled from: ObservableWindowBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements h.c.z<T>, h.c.k0.b, Runnable {
        static final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final h.c.z<? super h.c.s<T>> f15638b;

        /* renamed from: c  reason: collision with root package name */
        final int f15639c;

        /* renamed from: d  reason: collision with root package name */
        final a<T, B> f15640d = new a<>(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15641e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f15642f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.a<Object> f15643g = new h.c.n0.f.a<>();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.c f15644h = new h.c.n0.j.c();

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f15645j = new AtomicBoolean();

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15646k;

        /* renamed from: l  reason: collision with root package name */
        h.c.v0.g<T> f15647l;

        b(h.c.z<? super h.c.s<T>> zVar, int i2) {
            this.f15638b = zVar;
            this.f15639c = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super h.c.s<T>> zVar = this.f15638b;
            h.c.n0.f.a<Object> aVar = this.f15643g;
            h.c.n0.j.c cVar = this.f15644h;
            int i2 = 1;
            while (this.f15642f.get() != 0) {
                h.c.v0.g<T> gVar = this.f15647l;
                boolean z = this.f15646k;
                if (z && cVar.get() != null) {
                    aVar.clear();
                    Throwable b2 = cVar.b();
                    if (gVar != 0) {
                        this.f15647l = null;
                        gVar.onError(b2);
                    }
                    zVar.onError(b2);
                    return;
                }
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = cVar.b();
                    if (b3 == null) {
                        if (gVar != 0) {
                            this.f15647l = null;
                            gVar.onComplete();
                        }
                        zVar.onComplete();
                        return;
                    }
                    if (gVar != 0) {
                        this.f15647l = null;
                        gVar.onError(b3);
                    }
                    zVar.onError(b3);
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll != a) {
                    gVar.onNext(poll);
                } else {
                    if (gVar != 0) {
                        this.f15647l = null;
                        gVar.onComplete();
                    }
                    if (!this.f15645j.get()) {
                        h.c.v0.g<T> e2 = h.c.v0.g.e(this.f15639c, this);
                        this.f15647l = e2;
                        this.f15642f.getAndIncrement();
                        zVar.onNext(e2);
                    }
                }
            }
            aVar.clear();
            this.f15647l = null;
        }

        void b() {
            h.c.n0.a.c.h(this.f15641e);
            this.f15646k = true;
            a();
        }

        void c(Throwable th) {
            h.c.n0.a.c.h(this.f15641e);
            if (this.f15644h.a(th)) {
                this.f15646k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void d() {
            this.f15643g.offer(a);
            a();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15645j.compareAndSet(false, true)) {
                this.f15640d.dispose();
                if (this.f15642f.decrementAndGet() == 0) {
                    h.c.n0.a.c.h(this.f15641e);
                }
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15645j.get();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15640d.dispose();
            this.f15646k = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15640d.dispose();
            if (this.f15644h.a(th)) {
                this.f15646k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15643g.offer(t);
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this.f15641e, bVar)) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15642f.decrementAndGet() == 0) {
                h.c.n0.a.c.h(this.f15641e);
            }
        }
    }

    public e4(h.c.x<T> xVar, h.c.x<B> xVar2, int i2) {
        super(xVar);
        this.f15634b = xVar2;
        this.f15635c = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.s<T>> zVar) {
        b bVar = new b(zVar, this.f15635c);
        zVar.onSubscribe(bVar);
        this.f15634b.subscribe(bVar.f15640d);
        this.a.subscribe(bVar);
    }
}
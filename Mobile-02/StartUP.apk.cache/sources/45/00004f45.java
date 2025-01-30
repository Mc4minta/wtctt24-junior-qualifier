package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSampleWithObservable.java */
/* loaded from: classes3.dex */
public final class v2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<?> f16319b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16320c;

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f16321e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16322f;

        a(h.c.z<? super T> zVar, h.c.x<?> xVar) {
            super(zVar, xVar);
            this.f16321e = new AtomicInteger();
        }

        @Override // h.c.n0.e.e.v2.c
        void b() {
            this.f16322f = true;
            if (this.f16321e.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // h.c.n0.e.e.v2.c
        void e() {
            if (this.f16321e.getAndIncrement() == 0) {
                do {
                    boolean z = this.f16322f;
                    c();
                    if (z) {
                        this.a.onComplete();
                        return;
                    }
                } while (this.f16321e.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        b(h.c.z<? super T> zVar, h.c.x<?> xVar) {
            super(zVar, xVar);
        }

        @Override // h.c.n0.e.e.v2.c
        void b() {
            this.a.onComplete();
        }

        @Override // h.c.n0.e.e.v2.c
        void e() {
            c();
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.x<?> f16323b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16324c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16325d;

        c(h.c.z<? super T> zVar, h.c.x<?> xVar) {
            this.a = zVar;
            this.f16323b = xVar;
        }

        public void a() {
            this.f16325d.dispose();
            b();
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.a.onNext(andSet);
            }
        }

        public void d(Throwable th) {
            this.f16325d.dispose();
            this.a.onError(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16324c);
            this.f16325d.dispose();
        }

        abstract void e();

        boolean f(h.c.k0.b bVar) {
            return h.c.n0.a.c.z(this.f16324c, bVar);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16324c.get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this.f16324c);
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f16324c);
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16325d, bVar)) {
                this.f16325d = bVar;
                this.a.onSubscribe(this);
                if (this.f16324c.get() == null) {
                    this.f16323b.subscribe(new d(this));
                }
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class d<T> implements h.c.z<Object> {
        final c<T> a;

        d(c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.d(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            this.a.e();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.f(bVar);
        }
    }

    public v2(h.c.x<T> xVar, h.c.x<?> xVar2, boolean z) {
        super(xVar);
        this.f16319b = xVar2;
        this.f16320c = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.p0.f fVar = new h.c.p0.f(zVar);
        if (this.f16320c) {
            this.a.subscribe(new a(fVar, this.f16319b));
        } else {
            this.a.subscribe(new b(fVar, this.f16319b));
        }
    }
}
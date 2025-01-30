package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRetryWhen.java */
/* loaded from: classes3.dex */
public final class t2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super h.c.s<Throwable>, ? extends h.c.x<?>> f16217b;

    /* compiled from: ObservableRetryWhen.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: d  reason: collision with root package name */
        final h.c.v0.f<Throwable> f16220d;

        /* renamed from: g  reason: collision with root package name */
        final h.c.x<T> f16223g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f16224h;

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f16218b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.j.c f16219c = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final a<T>.C0385a f16221e = new C0385a();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16222f = new AtomicReference<>();

        /* compiled from: ObservableRetryWhen.java */
        /* renamed from: h.c.n0.e.e.t2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0385a extends AtomicReference<h.c.k0.b> implements h.c.z<Object> {
            C0385a() {
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                a.this.a();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(Object obj) {
                a.this.c();
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.z<? super T> zVar, h.c.v0.f<Throwable> fVar, h.c.x<T> xVar) {
            this.a = zVar;
            this.f16220d = fVar;
            this.f16223g = xVar;
        }

        void a() {
            h.c.n0.a.c.h(this.f16222f);
            h.c.n0.j.k.a(this.a, this, this.f16219c);
        }

        void b(Throwable th) {
            h.c.n0.a.c.h(this.f16222f);
            h.c.n0.j.k.c(this.a, th, this, this.f16219c);
        }

        void c() {
            d();
        }

        void d() {
            if (this.f16218b.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f16224h) {
                        this.f16224h = true;
                        this.f16223g.subscribe(this);
                    }
                    if (this.f16218b.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16222f);
            h.c.n0.a.c.h(this.f16221e);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16222f.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this.f16221e);
            h.c.n0.j.k.a(this.a, this, this.f16219c);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.q(this.f16222f, null);
            this.f16224h = false;
            this.f16220d.onNext(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            h.c.n0.j.k.e(this.a, t, this, this.f16219c);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this.f16222f, bVar);
        }
    }

    public t2(h.c.x<T> xVar, h.c.m0.n<? super h.c.s<Throwable>, ? extends h.c.x<?>> nVar) {
        super(xVar);
        this.f16217b = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        h.c.v0.f<T> b2 = h.c.v0.b.d().b();
        try {
            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16217b.apply(b2), "The handler returned a null ObservableSource");
            a aVar = new a(zVar, b2, this.a);
            zVar.onSubscribe(aVar);
            xVar.subscribe(aVar.f16221e);
            aVar.d();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}
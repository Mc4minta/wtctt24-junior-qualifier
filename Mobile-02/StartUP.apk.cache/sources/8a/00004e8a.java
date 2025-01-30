package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWithLatestFrom.java */
/* loaded from: classes3.dex */
public final class i4<T, U, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<? super T, ? super U, ? extends R> f15816b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.x<? extends U> f15817c;

    /* compiled from: ObservableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    static final class a<T, U, R> extends AtomicReference<U> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<? super T, ? super U, ? extends R> f15818b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15819c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15820d = new AtomicReference<>();

        a(h.c.z<? super R> zVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar) {
            this.a = zVar;
            this.f15818b = cVar;
        }

        public void a(Throwable th) {
            h.c.n0.a.c.h(this.f15819c);
            this.a.onError(th);
        }

        public boolean b(h.c.k0.b bVar) {
            return h.c.n0.a.c.z(this.f15820d, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f15819c);
            h.c.n0.a.c.h(this.f15820d);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f15819c.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this.f15820d);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f15820d);
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.a.onNext(h.c.n0.b.b.e(this.f15818b.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    dispose();
                    this.a.onError(th);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15819c, bVar);
        }
    }

    /* compiled from: ObservableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    final class b implements h.c.z<U> {
        private final a<T, U, R> a;

        b(a<T, U, R> aVar) {
            this.a = aVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.b(bVar);
        }
    }

    public i4(h.c.x<T> xVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, h.c.x<? extends U> xVar2) {
        super(xVar);
        this.f15816b = cVar;
        this.f15817c = xVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        h.c.p0.f fVar = new h.c.p0.f(zVar);
        a aVar = new a(fVar, this.f15816b);
        fVar.onSubscribe(aVar);
        this.f15817c.subscribe(new b(aVar));
        this.a.subscribe(aVar);
    }
}
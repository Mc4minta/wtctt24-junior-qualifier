package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class j3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f15852b;

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15853b = new AtomicReference<>();

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f15853b);
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15853b, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes3.dex */
    final class b implements Runnable {
        private final a<T> a;

        b(a<T> aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j3.this.a.subscribe(this.a);
        }
    }

    public j3(h.c.x<T> xVar, h.c.a0 a0Var) {
        super(xVar);
        this.f15852b = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        aVar.a(this.f15852b.c(new b(aVar)));
    }
}
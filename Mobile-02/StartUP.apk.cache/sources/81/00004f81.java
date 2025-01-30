package h.c.n0.e.e;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToList.java */
/* loaded from: classes3.dex */
public final class z3<T, U extends Collection<? super T>> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f16462b;

    /* compiled from: ObservableToList.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f16463b;

        /* renamed from: c  reason: collision with root package name */
        U f16464c;

        a(h.c.z<? super U> zVar, U u) {
            this.a = zVar;
            this.f16464c = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16463b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16463b.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            U u = this.f16464c;
            this.f16464c = null;
            this.a.onNext(u);
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16464c = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16464c.add(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16463b, bVar)) {
                this.f16463b = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public z3(h.c.x<T> xVar, int i2) {
        super(xVar);
        this.f16462b = h.c.n0.b.a.f(i2);
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super U> zVar) {
        try {
            this.a.subscribe(new a(zVar, (Collection) h.c.n0.b.b.e(this.f16462b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }

    public z3(h.c.x<T> xVar, Callable<U> callable) {
        super(xVar);
        this.f16462b = callable;
    }
}
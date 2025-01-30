package h.c.n0.e.e;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* loaded from: classes3.dex */
public final class a4<T, U extends Collection<? super T>> extends h.c.b0<U> implements h.c.n0.c.d<U> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f15515b;

    /* compiled from: ObservableToListSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        U f15516b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15517c;

        a(h.c.e0<? super U> e0Var, U u) {
            this.a = e0Var;
            this.f15516b = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15517c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15517c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            U u = this.f15516b;
            this.f15516b = null;
            this.a.onSuccess(u);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15516b = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15516b.add(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15517c, bVar)) {
                this.f15517c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public a4(h.c.x<T> xVar, int i2) {
        this.a = xVar;
        this.f15515b = h.c.n0.b.a.f(i2);
    }

    @Override // h.c.n0.c.d
    public h.c.s<U> a() {
        return h.c.r0.a.n(new z3(this.a, this.f15515b));
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super U> e0Var) {
        try {
            this.a.subscribe(new a(e0Var, (Collection) h.c.n0.b.b.e(this.f15515b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }

    public a4(h.c.x<T> xVar, Callable<U> callable) {
        this.a = xVar;
        this.f15515b = callable;
    }
}
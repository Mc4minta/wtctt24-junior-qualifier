package h.c.n0.e.e;

import java.util.NoSuchElementException;

/* compiled from: ObservableLastSingle.java */
/* loaded from: classes3.dex */
public final class t1<T> extends h.c.b0<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f16213b;

    /* compiled from: ObservableLastSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f16214b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f16215c;

        /* renamed from: d  reason: collision with root package name */
        T f16216d;

        a(h.c.e0<? super T> e0Var, T t) {
            this.a = e0Var;
            this.f16214b = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16215c.dispose();
            this.f16215c = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16215c == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16215c = h.c.n0.a.c.DISPOSED;
            T t = this.f16216d;
            if (t != null) {
                this.f16216d = null;
                this.a.onSuccess(t);
                return;
            }
            T t2 = this.f16214b;
            if (t2 != null) {
                this.a.onSuccess(t2);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16215c = h.c.n0.a.c.DISPOSED;
            this.f16216d = null;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16216d = t;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16215c, bVar)) {
                this.f16215c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public t1(h.c.x<T> xVar, T t) {
        this.a = xVar;
        this.f16213b = t;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16213b));
    }
}
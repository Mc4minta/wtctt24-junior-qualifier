package h.c.n0.e.e;

import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes3.dex */
public final class d3<T> extends h.c.b0<T> {
    final h.c.x<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f15592b;

    /* compiled from: ObservableSingleSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f15593b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15594c;

        /* renamed from: d  reason: collision with root package name */
        T f15595d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15596e;

        a(h.c.e0<? super T> e0Var, T t) {
            this.a = e0Var;
            this.f15593b = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15594c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15594c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15596e) {
                return;
            }
            this.f15596e = true;
            T t = this.f15595d;
            this.f15595d = null;
            if (t == null) {
                t = this.f15593b;
            }
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15596e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15596e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15596e) {
                return;
            }
            if (this.f15595d != null) {
                this.f15596e = true;
                this.f15594c.dispose();
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f15595d = t;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15594c, bVar)) {
                this.f15594c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public d3(h.c.x<? extends T> xVar, T t) {
        this.a = xVar;
        this.f15592b = t;
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15592b));
    }
}
package h.c.n0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableLastSingle.java */
/* loaded from: classes3.dex */
public final class x1<T> extends h.c.b0<T> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f15207b;

    /* compiled from: FlowableLastSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f15208b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f15209c;

        /* renamed from: d  reason: collision with root package name */
        T f15210d;

        a(h.c.e0<? super T> e0Var, T t) {
            this.a = e0Var;
            this.f15208b = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15209c.cancel();
            this.f15209c = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15209c == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15209c = h.c.n0.i.g.CANCELLED;
            T t = this.f15210d;
            if (t != null) {
                this.f15210d = null;
                this.a.onSuccess(t);
                return;
            }
            T t2 = this.f15208b;
            if (t2 != null) {
                this.a.onSuccess(t2);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f15209c = h.c.n0.i.g.CANCELLED;
            this.f15210d = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15210d = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15209c, dVar)) {
                this.f15209c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public x1(k.a.b<T> bVar, T t) {
        this.a = bVar;
        this.f15207b = t;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f15207b));
    }
}
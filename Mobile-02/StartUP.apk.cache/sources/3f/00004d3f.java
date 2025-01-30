package h.c.n0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableSingleSingle.java */
/* loaded from: classes3.dex */
public final class q3<T> extends h.c.b0<T> implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f14879b;

    /* compiled from: FlowableSingleSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f14880b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14881c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14882d;

        /* renamed from: e  reason: collision with root package name */
        T f14883e;

        a(h.c.e0<? super T> e0Var, T t) {
            this.a = e0Var;
            this.f14880b = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14881c.cancel();
            this.f14881c = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14881c == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14882d) {
                return;
            }
            this.f14882d = true;
            this.f14881c = h.c.n0.i.g.CANCELLED;
            T t = this.f14883e;
            this.f14883e = null;
            if (t == null) {
                t = this.f14880b;
            }
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14882d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14882d = true;
            this.f14881c = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14882d) {
                return;
            }
            if (this.f14883e != null) {
                this.f14882d = true;
                this.f14881c.cancel();
                this.f14881c = h.c.n0.i.g.CANCELLED;
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f14883e = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14881c, dVar)) {
                this.f14881c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public q3(h.c.h<T> hVar, T t) {
        this.a = hVar;
        this.f14879b = t;
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new o3(this.a, this.f14879b, true));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe((h.c.m) new a(e0Var, this.f14879b));
    }
}
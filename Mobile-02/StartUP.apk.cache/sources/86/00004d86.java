package h.c.n0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableElementAtSingle.java */
/* loaded from: classes3.dex */
public final class u0<T> extends h.c.b0<T> implements h.c.n0.c.b<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f15072b;

    /* renamed from: c  reason: collision with root package name */
    final T f15073c;

    /* compiled from: FlowableElementAtSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15074b;

        /* renamed from: c  reason: collision with root package name */
        final T f15075c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15076d;

        /* renamed from: e  reason: collision with root package name */
        long f15077e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15078f;

        a(h.c.e0<? super T> e0Var, long j2, T t) {
            this.a = e0Var;
            this.f15074b = j2;
            this.f15075c = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15076d.cancel();
            this.f15076d = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15076d == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15076d = h.c.n0.i.g.CANCELLED;
            if (this.f15078f) {
                return;
            }
            this.f15078f = true;
            T t = this.f15075c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15078f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15078f = true;
            this.f15076d = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15078f) {
                return;
            }
            long j2 = this.f15077e;
            if (j2 == this.f15074b) {
                this.f15078f = true;
                this.f15076d.cancel();
                this.f15076d = h.c.n0.i.g.CANCELLED;
                this.a.onSuccess(t);
                return;
            }
            this.f15077e = j2 + 1;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15076d, dVar)) {
                this.f15076d = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public u0(h.c.h<T> hVar, long j2, T t) {
        this.a = hVar;
        this.f15072b = j2;
        this.f15073c = t;
    }

    @Override // h.c.n0.c.b
    public h.c.h<T> e() {
        return h.c.r0.a.l(new s0(this.a, this.f15072b, this.f15073c, true));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe((h.c.m) new a(e0Var, this.f15072b, this.f15073c));
    }
}
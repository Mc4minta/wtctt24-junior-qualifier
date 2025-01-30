package h.c.n0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableSingle.java */
/* loaded from: classes3.dex */
public final class o3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final T f14788b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14789c;

    /* compiled from: FlowableSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<T> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final T f14790c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f14791d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14792e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14793f;

        a(k.a.c<? super T> cVar, T t, boolean z) {
            super(cVar);
            this.f14790c = t;
            this.f14791d = z;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14792e.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14793f) {
                return;
            }
            this.f14793f = true;
            T t = this.f16754b;
            this.f16754b = null;
            if (t == null) {
                t = this.f14790c;
            }
            if (t == null) {
                if (this.f14791d) {
                    this.a.onError(new NoSuchElementException());
                    return;
                } else {
                    this.a.onComplete();
                    return;
                }
            }
            c(t);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14793f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14793f = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14793f) {
                return;
            }
            if (this.f16754b != null) {
                this.f14793f = true;
                this.f14792e.cancel();
                this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f16754b = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14792e, dVar)) {
                this.f14792e = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public o3(h.c.h<T> hVar, T t, boolean z) {
        super(hVar);
        this.f14788b = t;
        this.f14789c = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14788b, this.f14789c));
    }
}
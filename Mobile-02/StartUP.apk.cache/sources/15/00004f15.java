package h.c.n0.e.e;

import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle.java */
/* loaded from: classes3.dex */
public final class r0<T> extends h.c.b0<T> implements h.c.n0.c.d<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f16164b;

    /* renamed from: c  reason: collision with root package name */
    final T f16165c;

    /* compiled from: ObservableElementAtSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16166b;

        /* renamed from: c  reason: collision with root package name */
        final T f16167c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16168d;

        /* renamed from: e  reason: collision with root package name */
        long f16169e;

        /* renamed from: f  reason: collision with root package name */
        boolean f16170f;

        a(h.c.e0<? super T> e0Var, long j2, T t) {
            this.a = e0Var;
            this.f16166b = j2;
            this.f16167c = t;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16168d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16168d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16170f) {
                return;
            }
            this.f16170f = true;
            T t = this.f16167c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16170f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16170f = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16170f) {
                return;
            }
            long j2 = this.f16169e;
            if (j2 == this.f16166b) {
                this.f16170f = true;
                this.f16168d.dispose();
                this.a.onSuccess(t);
                return;
            }
            this.f16169e = j2 + 1;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16168d, bVar)) {
                this.f16168d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public r0(h.c.x<T> xVar, long j2, T t) {
        this.a = xVar;
        this.f16164b = j2;
        this.f16165c = t;
    }

    @Override // h.c.n0.c.d
    public h.c.s<T> a() {
        return h.c.r0.a.n(new p0(this.a, this.f16164b, this.f16165c, true));
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16164b, this.f16165c));
    }
}
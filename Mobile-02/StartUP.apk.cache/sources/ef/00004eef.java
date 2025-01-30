package h.c.n0.e.e;

import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* loaded from: classes3.dex */
public final class p0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16056b;

    /* renamed from: c  reason: collision with root package name */
    final T f16057c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f16058d;

    /* compiled from: ObservableElementAt.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16059b;

        /* renamed from: c  reason: collision with root package name */
        final T f16060c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f16061d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f16062e;

        /* renamed from: f  reason: collision with root package name */
        long f16063f;

        /* renamed from: g  reason: collision with root package name */
        boolean f16064g;

        a(h.c.z<? super T> zVar, long j2, T t, boolean z) {
            this.a = zVar;
            this.f16059b = j2;
            this.f16060c = t;
            this.f16061d = z;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16062e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16062e.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16064g) {
                return;
            }
            this.f16064g = true;
            T t = this.f16060c;
            if (t == null && this.f16061d) {
                this.a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.a.onNext(t);
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16064g) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16064g = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16064g) {
                return;
            }
            long j2 = this.f16063f;
            if (j2 == this.f16059b) {
                this.f16064g = true;
                this.f16062e.dispose();
                this.a.onNext(t);
                this.a.onComplete();
                return;
            }
            this.f16063f = j2 + 1;
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16062e, bVar)) {
                this.f16062e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public p0(h.c.x<T> xVar, long j2, T t, boolean z) {
        super(xVar);
        this.f16056b = j2;
        this.f16057c = t;
        this.f16058d = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16056b, this.f16057c, this.f16058d));
    }
}
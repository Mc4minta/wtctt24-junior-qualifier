package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;

/* compiled from: ObservableTimeInterval.java */
/* loaded from: classes3.dex */
public final class v3<T> extends h.c.n0.e.e.a<T, h.c.u0.b<T>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f16326b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16327c;

    /* compiled from: ObservableTimeInterval.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super h.c.u0.b<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final TimeUnit f16328b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.a0 f16329c;

        /* renamed from: d  reason: collision with root package name */
        long f16330d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f16331e;

        a(h.c.z<? super h.c.u0.b<T>> zVar, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = zVar;
            this.f16329c = a0Var;
            this.f16328b = timeUnit;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16331e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16331e.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long b2 = this.f16329c.b(this.f16328b);
            long j2 = this.f16330d;
            this.f16330d = b2;
            this.a.onNext(new h.c.u0.b(t, b2 - j2, this.f16328b));
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16331e, bVar)) {
                this.f16331e = bVar;
                this.f16330d = this.f16329c.b(this.f16328b);
                this.a.onSubscribe(this);
            }
        }
    }

    public v3(h.c.x<T> xVar, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(xVar);
        this.f16326b = a0Var;
        this.f16327c = timeUnit;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.u0.b<T>> zVar) {
        this.a.subscribe(new a(zVar, this.f16327c, this.f16326b));
    }
}
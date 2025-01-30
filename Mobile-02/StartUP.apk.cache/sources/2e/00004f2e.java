package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableThrottleFirstTimed.java */
/* loaded from: classes3.dex */
public final class t3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16225b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16226c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16227d;

    /* compiled from: ObservableThrottleFirstTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b, Runnable {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16228b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f16229c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f16230d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f16231e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16232f;

        /* renamed from: g  reason: collision with root package name */
        boolean f16233g;

        a(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar) {
            this.a = zVar;
            this.f16228b = j2;
            this.f16229c = timeUnit;
            this.f16230d = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16231e.dispose();
            this.f16230d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16230d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16233g) {
                return;
            }
            this.f16233g = true;
            this.a.onComplete();
            this.f16230d.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16233g) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16233g = true;
            this.a.onError(th);
            this.f16230d.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16232f || this.f16233g) {
                return;
            }
            this.f16232f = true;
            this.a.onNext(t);
            h.c.k0.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            h.c.n0.a.c.q(this, this.f16230d.c(this, this.f16228b, this.f16229c));
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16231e, bVar)) {
                this.f16231e = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16232f = false;
        }
    }

    public t3(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(xVar);
        this.f16225b = j2;
        this.f16226c = timeUnit;
        this.f16227d = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(new h.c.p0.f(zVar), this.f16225b, this.f16226c, this.f16227d.a()));
    }
}
package h.c.n0.e.a;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableDelay.java */
/* loaded from: classes.dex */
public final class c extends h.c.c {
    final h.c.f a;

    /* renamed from: b  reason: collision with root package name */
    final long f14153b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14154c;

    /* renamed from: d  reason: collision with root package name */
    final a0 f14155d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14156e;

    /* compiled from: CompletableDelay.java */
    /* loaded from: classes.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.e, Runnable, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final long f14157b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14158c;

        /* renamed from: d  reason: collision with root package name */
        final a0 f14159d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f14160e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f14161f;

        a(h.c.e eVar, long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
            this.a = eVar;
            this.f14157b = j2;
            this.f14158c = timeUnit;
            this.f14159d = a0Var;
            this.f14160e = z;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e
        public void onComplete() {
            h.c.n0.a.c.q(this, this.f14159d.d(this, this.f14157b, this.f14158c));
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.f14161f = th;
            h.c.n0.a.c.q(this, this.f14159d.d(this, this.f14160e ? this.f14157b : 0L, this.f14158c));
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f14161f;
            this.f14161f = null;
            if (th != null) {
                this.a.onError(th);
            } else {
                this.a.onComplete();
            }
        }
    }

    public c(h.c.f fVar, long j2, TimeUnit timeUnit, a0 a0Var, boolean z) {
        this.a = fVar;
        this.f14153b = j2;
        this.f14154c = timeUnit;
        this.f14155d = a0Var;
        this.f14156e = z;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.c(new a(eVar, this.f14153b, this.f14154c, this.f14155d, this.f14156e));
    }
}
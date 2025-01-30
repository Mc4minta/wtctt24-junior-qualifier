package h.c.n0.e.a;

import h.c.a0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableObserveOn.java */
/* loaded from: classes.dex */
public final class h extends h.c.c {
    final h.c.f a;

    /* renamed from: b  reason: collision with root package name */
    final a0 f14162b;

    /* compiled from: CompletableObserveOn.java */
    /* loaded from: classes.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b, Runnable {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final a0 f14163b;

        /* renamed from: c  reason: collision with root package name */
        Throwable f14164c;

        a(h.c.e eVar, a0 a0Var) {
            this.a = eVar;
            this.f14163b = a0Var;
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
            h.c.n0.a.c.q(this, this.f14163b.c(this));
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.f14164c = th;
            h.c.n0.a.c.q(this, this.f14163b.c(this));
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f14164c;
            if (th != null) {
                this.f14164c = null;
                this.a.onError(th);
                return;
            }
            this.a.onComplete();
        }
    }

    public h(h.c.f fVar, a0 a0Var) {
        this.a = fVar;
        this.f14162b = a0Var;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.c(new a(eVar, this.f14162b));
    }
}
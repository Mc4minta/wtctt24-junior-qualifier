package h.c.n0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableAndThenCompletable.java */
/* loaded from: classes.dex */
public final class a extends h.c.c {
    final h.c.f a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f14150b;

    /* compiled from: CompletableAndThenCompletable.java */
    /* renamed from: h.c.n0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0343a implements h.c.e {
        final AtomicReference<h.c.k0.b> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.e f14151b;

        public C0343a(AtomicReference<h.c.k0.b> atomicReference, h.c.e eVar) {
            this.a = atomicReference;
            this.f14151b = eVar;
        }

        @Override // h.c.e
        public void onComplete() {
            this.f14151b.onComplete();
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.f14151b.onError(th);
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this.a, bVar);
        }
    }

    /* compiled from: CompletableAndThenCompletable.java */
    /* loaded from: classes.dex */
    static final class b extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.f f14152b;

        b(h.c.e eVar, h.c.f fVar) {
            this.a = eVar;
            this.f14152b = fVar;
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
            this.f14152b.c(new C0343a(this, this.a));
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }
    }

    public a(h.c.f fVar, h.c.f fVar2) {
        this.a = fVar;
        this.f14150b = fVar2;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.c(new b(eVar, this.f14150b));
    }
}
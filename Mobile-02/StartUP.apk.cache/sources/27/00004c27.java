package h.c.n0.e.a;

import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletablePeek.java */
/* loaded from: classes.dex */
public final class i extends h.c.c {
    final h.c.f a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super h.c.k0.b> f14165b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f14166c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.a f14167d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.a f14168e;

    /* renamed from: f  reason: collision with root package name */
    final h.c.m0.a f14169f;

    /* renamed from: g  reason: collision with root package name */
    final h.c.m0.a f14170g;

    /* compiled from: CompletablePeek.java */
    /* loaded from: classes.dex */
    final class a implements h.c.e, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f14171b;

        a(h.c.e eVar) {
            this.a = eVar;
        }

        void a() {
            try {
                i.this.f14169f.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            try {
                i.this.f14170g.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
            this.f14171b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14171b.isDisposed();
        }

        @Override // h.c.e
        public void onComplete() {
            if (this.f14171b == h.c.n0.a.c.DISPOSED) {
                return;
            }
            try {
                i.this.f14167d.run();
                i.this.f14168e.run();
                this.a.onComplete();
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            if (this.f14171b == h.c.n0.a.c.DISPOSED) {
                h.c.r0.a.u(th);
                return;
            }
            try {
                i.this.f14166c.accept(th);
                i.this.f14168e.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
            a();
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            try {
                i.this.f14165b.accept(bVar);
                if (h.c.n0.a.c.B(this.f14171b, bVar)) {
                    this.f14171b = bVar;
                    this.a.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                this.f14171b = h.c.n0.a.c.DISPOSED;
                h.c.n0.a.d.s(th, this.a);
            }
        }
    }

    public i(h.c.f fVar, h.c.m0.f<? super h.c.k0.b> fVar2, h.c.m0.f<? super Throwable> fVar3, h.c.m0.a aVar, h.c.m0.a aVar2, h.c.m0.a aVar3, h.c.m0.a aVar4) {
        this.a = fVar;
        this.f14165b = fVar2;
        this.f14166c = fVar3;
        this.f14167d = aVar;
        this.f14168e = aVar2;
        this.f14169f = aVar3;
        this.f14170g = aVar4;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.c(new a(eVar));
    }
}
package h.c.n0.e.g;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleTakeUntil.java */
/* loaded from: classes3.dex */
public final class r0<T, U> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<U> f16555b;

    /* compiled from: SingleTakeUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final b f16556b = new b(this);

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        void a(Throwable th) {
            h.c.k0.b andSet;
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar && (andSet = getAndSet(cVar)) != cVar) {
                if (andSet != null) {
                    andSet.dispose();
                }
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
            this.f16556b.a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16556b.a();
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar && getAndSet(cVar) != cVar) {
                this.a.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f16556b.a();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (getAndSet(cVar) != cVar) {
                this.a.onSuccess(t);
            }
        }
    }

    /* compiled from: SingleTakeUntil.java */
    /* loaded from: classes3.dex */
    static final class b extends AtomicReference<k.a.d> implements h.c.m<Object> {
        final a<?> a;

        b(a<?> aVar) {
            this.a = aVar;
        }

        public void a() {
            h.c.n0.i.g.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            k.a.d dVar = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                lazySet(gVar);
                this.a.a(new CancellationException());
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            if (h.c.n0.i.g.h(this)) {
                this.a.a(new CancellationException());
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    public r0(h.c.h0<T> h0Var, k.a.b<U> bVar) {
        this.a = h0Var;
        this.f16555b = bVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        a aVar = new a(e0Var);
        e0Var.onSubscribe(aVar);
        this.f16555b.subscribe(aVar.f16556b);
        this.a.subscribe(aVar);
    }
}
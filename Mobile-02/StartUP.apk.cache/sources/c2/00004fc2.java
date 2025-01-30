package h.c.n0.e.g;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnError.java */
/* loaded from: classes3.dex */
public final class q<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f16548b;

    /* compiled from: SingleDoOnError.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        private final h.c.e0<? super T> a;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            try {
                q.this.f16548b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public q(h.c.h0<T> h0Var, h.c.m0.f<? super Throwable> fVar) {
        this.a = h0Var;
        this.f16548b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}
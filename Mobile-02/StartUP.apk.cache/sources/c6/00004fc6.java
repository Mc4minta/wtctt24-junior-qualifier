package h.c.n0.e.g;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnEvent.java */
/* loaded from: classes3.dex */
public final class r<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.b<? super T, ? super Throwable> f16553b;

    /* compiled from: SingleDoOnEvent.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        private final h.c.e0<? super T> a;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            try {
                r.this.f16553b.a(null, th);
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
            try {
                r.this.f16553b.a(t, null);
                this.a.onSuccess(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public r(h.c.h0<T> h0Var, h.c.m0.b<? super T, ? super Throwable> bVar) {
        this.a = h0Var;
        this.f16553b = bVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}
package h.c.n0.e.g;

import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class o0<T> extends h.c.b0<T> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends T> f16541b;

    /* renamed from: c  reason: collision with root package name */
    final T f16542c;

    /* compiled from: SingleOnErrorReturn.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.e0<T> {
        private final h.c.e0<? super T> a;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            T apply;
            o0 o0Var = o0.this;
            h.c.m0.n<? super Throwable, ? extends T> nVar = o0Var.f16541b;
            if (nVar != null) {
                try {
                    apply = nVar.apply(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.a.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                apply = o0Var.f16542c;
            }
            if (apply == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
                return;
            }
            this.a.onSuccess(apply);
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

    public o0(h.c.h0<? extends T> h0Var, h.c.m0.n<? super Throwable, ? extends T> nVar, T t) {
        this.a = h0Var;
        this.f16541b = nVar;
        this.f16542c = t;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}
package h.c.n0.e.a;

import h.c.b0;
import h.c.e0;
import java.util.concurrent.Callable;

/* compiled from: CompletableToSingle.java */
/* loaded from: classes.dex */
public final class l<T> extends b0<T> {
    final h.c.f a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends T> f14175b;

    /* renamed from: c  reason: collision with root package name */
    final T f14176c;

    /* compiled from: CompletableToSingle.java */
    /* loaded from: classes.dex */
    final class a implements h.c.e {
        private final e0<? super T> a;

        a(e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.e
        public void onComplete() {
            T call;
            l lVar = l.this;
            Callable<? extends T> callable = lVar.f14175b;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.a.onError(th);
                    return;
                }
            } else {
                call = lVar.f14176c;
            }
            if (call == null) {
                this.a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.a.onSuccess(call);
            }
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }

    public l(h.c.f fVar, Callable<? extends T> callable, T t) {
        this.a = fVar;
        this.f14176c = t;
        this.f14175b = callable;
    }

    @Override // h.c.b0
    protected void subscribeActual(e0<? super T> e0Var) {
        this.a.c(new a(e0Var));
    }
}
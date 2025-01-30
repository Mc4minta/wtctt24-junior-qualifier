package h.c.n0.e.a;

import h.c.e0;
import h.c.h0;

/* compiled from: CompletableFromSingle.java */
/* loaded from: classes.dex */
public final class g<T> extends h.c.c {
    final h0<T> a;

    /* compiled from: CompletableFromSingle.java */
    /* loaded from: classes.dex */
    static final class a<T> implements e0<T> {
        final h.c.e a;

        a(h.c.e eVar) {
            this.a = eVar;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onComplete();
        }
    }

    public g(h0<T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe(new a(eVar));
    }
}
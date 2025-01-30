package h.c.n0.e.c;

import h.c.e0;
import h.c.h0;
import h.c.o;
import h.c.p;

/* compiled from: MaybeFromSingle.java */
/* loaded from: classes3.dex */
public final class b<T> extends o<T> {
    final h0<T> a;

    /* compiled from: MaybeFromSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements e0<T>, h.c.k0.b {
        final p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15337b;

        a(p<? super T> pVar) {
            this.a = pVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15337b.dispose();
            this.f15337b = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15337b.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f15337b = h.c.n0.a.c.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15337b, bVar)) {
                this.f15337b = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f15337b = h.c.n0.a.c.DISPOSED;
            this.a.onSuccess(t);
        }
    }

    public b(h0<T> h0Var) {
        this.a = h0Var;
    }

    @Override // h.c.o
    protected void d(p<? super T> pVar) {
        this.a.subscribe(new a(pVar));
    }
}
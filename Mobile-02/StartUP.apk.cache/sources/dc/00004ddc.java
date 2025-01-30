package h.c.n0.e.c;

import h.c.e0;
import h.c.h0;
import h.c.m0.p;
import h.c.o;

/* compiled from: MaybeFilterSingle.java */
/* loaded from: classes3.dex */
public final class a<T> extends o<T> {
    final h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f15334b;

    /* compiled from: MaybeFilterSingle.java */
    /* renamed from: h.c.n0.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0361a<T> implements e0<T>, h.c.k0.b {
        final h.c.p<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f15335b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15336c;

        C0361a(h.c.p<? super T> pVar, p<? super T> pVar2) {
            this.a = pVar;
            this.f15335b = pVar2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.k0.b bVar = this.f15336c;
            this.f15336c = h.c.n0.a.c.DISPOSED;
            bVar.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15336c.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15336c, bVar)) {
                this.f15336c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                if (this.f15335b.test(t)) {
                    this.a.onSuccess(t);
                } else {
                    this.a.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public a(h0<T> h0Var, p<? super T> pVar) {
        this.a = h0Var;
        this.f15334b = pVar;
    }

    @Override // h.c.o
    protected void d(h.c.p<? super T> pVar) {
        this.a.subscribe(new C0361a(pVar, this.f15334b));
    }
}
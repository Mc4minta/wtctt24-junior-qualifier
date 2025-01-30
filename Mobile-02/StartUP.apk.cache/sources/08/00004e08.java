package h.c.n0.e.d;

import h.c.e0;
import h.c.h0;
import h.c.s;
import h.c.x;
import h.c.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapObservable.java */
/* loaded from: classes3.dex */
public final class o<T, R> extends s<R> {
    final h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends x<? extends R>> f15484b;

    /* compiled from: SingleFlatMapObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicReference<h.c.k0.b> implements z<R>, e0<T>, h.c.k0.b {
        final z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends x<? extends R>> f15485b;

        a(z<? super R> zVar, h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
            this.a = zVar;
            this.f15485b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                ((x) h.c.n0.b.b.e(this.f15485b.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public o(h0<T> h0Var, h.c.m0.n<? super T, ? extends x<? extends R>> nVar) {
        this.a = h0Var;
        this.f15484b = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super R> zVar) {
        a aVar = new a(zVar, this.f15484b);
        zVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}
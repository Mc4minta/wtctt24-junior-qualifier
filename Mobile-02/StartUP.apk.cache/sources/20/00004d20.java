package h.c.n0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToListSingle.java */
/* loaded from: classes3.dex */
public final class o4<T, U extends Collection<? super T>> extends h.c.b0<U> implements h.c.n0.c.b<U> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f14794b;

    /* compiled from: FlowableToListSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super U> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14795b;

        /* renamed from: c  reason: collision with root package name */
        U f14796c;

        a(h.c.e0<? super U> e0Var, U u) {
            this.a = e0Var;
            this.f14796c = u;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14795b.cancel();
            this.f14795b = h.c.n0.i.g.CANCELLED;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14795b == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14795b = h.c.n0.i.g.CANCELLED;
            this.a.onSuccess(this.f14796c);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14796c = null;
            this.f14795b = h.c.n0.i.g.CANCELLED;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14796c.add(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14795b, dVar)) {
                this.f14795b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public o4(h.c.h<T> hVar) {
        this(hVar, h.c.n0.j.b.n());
    }

    @Override // h.c.n0.c.b
    public h.c.h<U> e() {
        return h.c.r0.a.l(new n4(this.a, this.f14794b));
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super U> e0Var) {
        try {
            this.a.subscribe((h.c.m) new a(e0Var, (Collection) h.c.n0.b.b.e(this.f14794b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }

    public o4(h.c.h<T> hVar, Callable<U> callable) {
        this.a = hVar;
        this.f14794b = callable;
    }
}
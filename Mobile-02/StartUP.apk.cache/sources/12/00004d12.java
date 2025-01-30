package h.c.n0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableToList.java */
/* loaded from: classes3.dex */
public final class n4<T, U extends Collection<? super T>> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f14770b;

    /* compiled from: FlowableToList.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> extends h.c.n0.i.c<U> implements h.c.m<T>, k.a.d {

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14771c;

        /* JADX WARN: Multi-variable type inference failed */
        a(k.a.c<? super U> cVar, U u) {
            super(cVar);
            this.f16754b = u;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14771c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            c(this.f16754b);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16754b = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            Collection collection = (Collection) this.f16754b;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14771c, dVar)) {
                this.f14771c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public n4(h.c.h<T> hVar, Callable<U> callable) {
        super(hVar);
        this.f14770b = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        try {
            this.a.subscribe((h.c.m) new a(cVar, (Collection) h.c.n0.b.b.e(this.f14770b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}
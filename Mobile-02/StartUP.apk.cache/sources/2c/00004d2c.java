package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;

/* compiled from: FlowableOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class p2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends T> f14827b;

    /* compiled from: FlowableOnErrorReturn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.s<T, T> {

        /* renamed from: e  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends T> f14828e;

        a(k.a.c<? super T> cVar, h.c.m0.n<? super Throwable, ? extends T> nVar) {
            super(cVar);
            this.f14828e = nVar;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            try {
                a(h.c.n0.b.b.e(this.f14828e.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f16747d++;
            this.a.onNext(t);
        }
    }

    public p2(h.c.h<T> hVar, h.c.m0.n<? super Throwable, ? extends T> nVar) {
        super(hVar);
        this.f14827b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14827b));
    }
}
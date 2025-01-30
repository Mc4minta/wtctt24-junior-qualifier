package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;

/* compiled from: FlowableOnErrorNext.java */
/* loaded from: classes3.dex */
public final class o2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends k.a.b<? extends T>> f14783b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14784c;

    /* compiled from: FlowableOnErrorNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.f implements h.c.m<T> {

        /* renamed from: j  reason: collision with root package name */
        final k.a.c<? super T> f14785j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends k.a.b<? extends T>> f14786k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f14787l;
        boolean m;
        boolean n;
        long p;

        a(k.a.c<? super T> cVar, h.c.m0.n<? super Throwable, ? extends k.a.b<? extends T>> nVar, boolean z) {
            super(false);
            this.f14785j = cVar;
            this.f14786k = nVar;
            this.f14787l = z;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.n) {
                return;
            }
            this.n = true;
            this.m = true;
            this.f14785j.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.m) {
                if (this.n) {
                    h.c.r0.a.u(th);
                    return;
                } else {
                    this.f14785j.onError(th);
                    return;
                }
            }
            this.m = true;
            if (this.f14787l && !(th instanceof Exception)) {
                this.f14785j.onError(th);
                return;
            }
            try {
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14786k.apply(th), "The nextSupplier returned a null Publisher");
                long j2 = this.p;
                if (j2 != 0) {
                    g(j2);
                }
                bVar.subscribe(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f14785j.onError(new CompositeException(th, th2));
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            if (!this.m) {
                this.p++;
            }
            this.f14785j.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            i(dVar);
        }
    }

    public o2(h.c.h<T> hVar, h.c.m0.n<? super Throwable, ? extends k.a.b<? extends T>> nVar, boolean z) {
        super(hVar);
        this.f14783b = nVar;
        this.f14784c = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar, this.f14783b, this.f14784c);
        cVar.onSubscribe(aVar);
        this.a.subscribe((h.c.m) aVar);
    }
}
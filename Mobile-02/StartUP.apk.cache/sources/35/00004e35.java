package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes3.dex */
public final class d2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends h.c.x<? extends T>> f15585b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15586c;

    /* compiled from: ObservableOnErrorNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends h.c.x<? extends T>> f15587b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f15588c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.a.g f15589d = new h.c.n0.a.g();

        /* renamed from: e  reason: collision with root package name */
        boolean f15590e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15591f;

        a(h.c.z<? super T> zVar, h.c.m0.n<? super Throwable, ? extends h.c.x<? extends T>> nVar, boolean z) {
            this.a = zVar;
            this.f15587b = nVar;
            this.f15588c = z;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15591f) {
                return;
            }
            this.f15591f = true;
            this.f15590e = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15590e) {
                if (this.f15591f) {
                    h.c.r0.a.u(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.f15590e = true;
            if (this.f15588c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                h.c.x<? extends T> apply = this.f15587b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.a.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15591f) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f15589d.a(bVar);
        }
    }

    public d2(h.c.x<T> xVar, h.c.m0.n<? super Throwable, ? extends h.c.x<? extends T>> nVar, boolean z) {
        super(xVar);
        this.f15585b = nVar;
        this.f15586c = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar, this.f15585b, this.f15586c);
        zVar.onSubscribe(aVar.f15589d);
        this.a.subscribe(aVar);
    }
}
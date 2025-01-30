package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class e2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends T> f15628b;

    /* compiled from: ObservableOnErrorReturn.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends T> f15629b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15630c;

        a(h.c.z<? super T> zVar, h.c.m0.n<? super Throwable, ? extends T> nVar) {
            this.a = zVar;
            this.f15629b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15630c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15630c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            try {
                T apply = this.f15629b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.a.onError(nullPointerException);
                    return;
                }
                this.a.onNext(apply);
                this.a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15630c, bVar)) {
                this.f15630c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e2(h.c.x<T> xVar, h.c.m0.n<? super Throwable, ? extends T> nVar) {
        super(xVar);
        this.f15628b = nVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15628b));
    }
}
package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes3.dex */
public final class n0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f15983b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f15984c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.a f15985d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.a f15986e;

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super T> f15987b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.f<? super Throwable> f15988c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.a f15989d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.m0.a f15990e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f15991f;

        /* renamed from: g  reason: collision with root package name */
        boolean f15992g;

        a(h.c.z<? super T> zVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
            this.a = zVar;
            this.f15987b = fVar;
            this.f15988c = fVar2;
            this.f15989d = aVar;
            this.f15990e = aVar2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15991f.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15991f.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15992g) {
                return;
            }
            try {
                this.f15989d.run();
                this.f15992g = true;
                this.a.onComplete();
                try {
                    this.f15990e.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15992g) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15992g = true;
            try {
                this.f15988c.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
            try {
                this.f15990e.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.r0.a.u(th3);
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15992g) {
                return;
            }
            try {
                this.f15987b.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15991f.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15991f, bVar)) {
                this.f15991f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public n0(h.c.x<T> xVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
        super(xVar);
        this.f15983b = fVar;
        this.f15984c = fVar2;
        this.f15985d = aVar;
        this.f15986e = aVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15983b, this.f15984c, this.f15985d, this.f15986e));
    }
}
package h.c.n0.e.e;

import java.util.concurrent.Callable;

/* compiled from: ObservableGenerate.java */
/* loaded from: classes3.dex */
public final class h1<T, S> extends h.c.s<T> {
    final Callable<S> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<S, h.c.g<T>, S> f15736b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super S> f15737c;

    /* compiled from: ObservableGenerate.java */
    /* loaded from: classes3.dex */
    static final class a<T, S> implements h.c.g<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<S, ? super h.c.g<T>, S> f15738b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.f<? super S> f15739c;

        /* renamed from: d  reason: collision with root package name */
        S f15740d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15741e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15742f;

        /* renamed from: g  reason: collision with root package name */
        boolean f15743g;

        a(h.c.z<? super T> zVar, h.c.m0.c<S, ? super h.c.g<T>, S> cVar, h.c.m0.f<? super S> fVar, S s) {
            this.a = zVar;
            this.f15738b = cVar;
            this.f15739c = fVar;
            this.f15740d = s;
        }

        private void a(S s) {
            try {
                this.f15739c.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }

        public void b(Throwable th) {
            if (this.f15742f) {
                h.c.r0.a.u(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f15742f = true;
            this.a.onError(th);
        }

        public void c() {
            S s = this.f15740d;
            if (this.f15741e) {
                this.f15740d = null;
                a(s);
                return;
            }
            h.c.m0.c<S, ? super h.c.g<T>, S> cVar = this.f15738b;
            while (!this.f15741e) {
                this.f15743g = false;
                try {
                    s = cVar.apply(s, this);
                    if (this.f15742f) {
                        this.f15741e = true;
                        this.f15740d = null;
                        a(s);
                        return;
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f15740d = null;
                    this.f15741e = true;
                    b(th);
                    a(s);
                    return;
                }
            }
            this.f15740d = null;
            a(s);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15741e = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15741e;
        }

        @Override // h.c.g
        public void onComplete() {
            if (this.f15742f) {
                return;
            }
            this.f15742f = true;
            this.a.onComplete();
        }

        @Override // h.c.g
        public void onNext(T t) {
            if (this.f15742f) {
                return;
            }
            if (this.f15743g) {
                b(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f15743g = true;
                this.a.onNext(t);
            }
        }
    }

    public h1(Callable<S> callable, h.c.m0.c<S, h.c.g<T>, S> cVar, h.c.m0.f<? super S> fVar) {
        this.a = callable;
        this.f15736b = cVar;
        this.f15737c = fVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        try {
            a aVar = new a(zVar, this.f15736b, this.f15737c, this.a.call());
            zVar.onSubscribe(aVar);
            aVar.c();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}
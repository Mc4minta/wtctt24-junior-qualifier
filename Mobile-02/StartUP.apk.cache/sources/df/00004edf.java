package h.c.n0.e.e;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableBufferExactBoundary.java */
/* loaded from: classes3.dex */
public final class o<T, U extends Collection<? super T>, B> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<B> f16012b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f16013c;

    /* compiled from: ObservableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>, B> extends h.c.p0.d<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f16014b;

        a(b<T, U, B> bVar) {
            this.f16014b = bVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16014b.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16014b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(B b2) {
            this.f16014b.j();
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends h.c.n0.d.u<T, U, U> implements h.c.z<T>, h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f16015g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.x<B> f16016h;

        /* renamed from: j  reason: collision with root package name */
        h.c.k0.b f16017j;

        /* renamed from: k  reason: collision with root package name */
        h.c.k0.b f16018k;

        /* renamed from: l  reason: collision with root package name */
        U f16019l;

        b(h.c.z<? super U> zVar, Callable<U> callable, h.c.x<B> xVar) {
            super(zVar, new h.c.n0.f.a());
            this.f16015g = callable;
            this.f16016h = xVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f14145d) {
                return;
            }
            this.f14145d = true;
            this.f16018k.dispose();
            this.f16017j.dispose();
            if (e()) {
                this.f14144c.clear();
            }
        }

        @Override // h.c.n0.d.u, h.c.n0.j.n
        /* renamed from: i */
        public void d(h.c.z<? super U> zVar, U u) {
            this.f14143b.onNext(u);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        void j() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f16015g.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.f16019l;
                    if (u2 == null) {
                        return;
                    }
                    this.f16019l = u;
                    g(u2, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.f14143b.onError(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            synchronized (this) {
                U u = this.f16019l;
                if (u == null) {
                    return;
                }
                this.f16019l = null;
                this.f14144c.offer(u);
                this.f14146e = true;
                if (e()) {
                    h.c.n0.j.r.d(this.f14144c, this.f14143b, false, this, this);
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            dispose();
            this.f14143b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f16019l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16017j, bVar)) {
                this.f16017j = bVar;
                try {
                    this.f16019l = (U) h.c.n0.b.b.e(this.f16015g.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f16018k = aVar;
                    this.f14143b.onSubscribe(this);
                    if (this.f14145d) {
                        return;
                    }
                    this.f16016h.subscribe(aVar);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f14145d = true;
                    bVar.dispose();
                    h.c.n0.a.d.y(th, this.f14143b);
                }
            }
        }
    }

    public o(h.c.x<T> xVar, h.c.x<B> xVar2, Callable<U> callable) {
        super(xVar);
        this.f16012b = xVar2;
        this.f16013c = callable;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        this.a.subscribe(new b(new h.c.p0.f(zVar), this.f16013c, this.f16012b));
    }
}
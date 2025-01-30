package h.c.n0.e.e;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class n<T, U extends Collection<? super T>, B> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends h.c.x<B>> f15974b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f15975c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U extends Collection<? super T>, B> extends h.c.p0.d<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f15976b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15977c;

        a(b<T, U, B> bVar) {
            this.f15976b = bVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15977c) {
                return;
            }
            this.f15977c = true;
            this.f15976b.k();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15977c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15977c = true;
            this.f15976b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(B b2) {
            if (this.f15977c) {
                return;
            }
            this.f15977c = true;
            dispose();
            this.f15976b.k();
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends h.c.n0.d.u<T, U, U> implements h.c.z<T>, h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f15978g;

        /* renamed from: h  reason: collision with root package name */
        final Callable<? extends h.c.x<B>> f15979h;

        /* renamed from: j  reason: collision with root package name */
        h.c.k0.b f15980j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15981k;

        /* renamed from: l  reason: collision with root package name */
        U f15982l;

        b(h.c.z<? super U> zVar, Callable<U> callable, Callable<? extends h.c.x<B>> callable2) {
            super(zVar, new h.c.n0.f.a());
            this.f15981k = new AtomicReference<>();
            this.f15978g = callable;
            this.f15979h = callable2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f14145d) {
                return;
            }
            this.f14145d = true;
            this.f15980j.dispose();
            j();
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
            h.c.n0.a.c.h(this.f15981k);
        }

        void k() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f15978g.call(), "The buffer supplied is null");
                try {
                    h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15979h.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (h.c.n0.a.c.q(this.f15981k, aVar)) {
                        synchronized (this) {
                            U u2 = this.f15982l;
                            if (u2 == null) {
                                return;
                            }
                            this.f15982l = u;
                            xVar.subscribe(aVar);
                            g(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f14145d = true;
                    this.f15980j.dispose();
                    this.f14143b.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.f14143b.onError(th2);
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            synchronized (this) {
                U u = this.f15982l;
                if (u == null) {
                    return;
                }
                this.f15982l = null;
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
                U u = this.f15982l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15980j, bVar)) {
                this.f15980j = bVar;
                h.c.z<? super V> zVar = this.f14143b;
                try {
                    this.f15982l = (U) h.c.n0.b.b.e(this.f15978g.call(), "The buffer supplied is null");
                    try {
                        h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15979h.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.f15981k.set(aVar);
                        zVar.onSubscribe(this);
                        if (this.f14145d) {
                            return;
                        }
                        xVar.subscribe(aVar);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14145d = true;
                        bVar.dispose();
                        h.c.n0.a.d.y(th, zVar);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f14145d = true;
                    bVar.dispose();
                    h.c.n0.a.d.y(th2, zVar);
                }
            }
        }
    }

    public n(h.c.x<T> xVar, Callable<? extends h.c.x<B>> callable, Callable<U> callable2) {
        super(xVar);
        this.f15974b = callable;
        this.f15975c = callable2;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        this.a.subscribe(new b(new h.c.p0.f(zVar), this.f15975c, this.f15974b));
    }
}
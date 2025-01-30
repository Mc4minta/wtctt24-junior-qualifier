package h.c.n0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableBufferBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class n<T, U extends Collection<? super T>, B> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends k.a.b<B>> f14729b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f14730c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U extends Collection<? super T>, B> extends h.c.w0.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f14731b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14732c;

        a(b<T, U, B> bVar) {
            this.f14731b = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14732c) {
                return;
            }
            this.f14732c = true;
            this.f14731b.o();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14732c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14732c = true;
            this.f14731b.onError(th);
        }

        @Override // k.a.c
        public void onNext(B b2) {
            if (this.f14732c) {
                return;
            }
            this.f14732c = true;
            b();
            this.f14731b.o();
        }
    }

    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends h.c.n0.h.m<T, U, U> implements h.c.m<T>, k.a.d, h.c.k0.b {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f14733h;

        /* renamed from: j  reason: collision with root package name */
        final Callable<? extends k.a.b<B>> f14734j;

        /* renamed from: k  reason: collision with root package name */
        k.a.d f14735k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f14736l;
        U m;

        b(k.a.c<? super U> cVar, Callable<U> callable, Callable<? extends k.a.b<B>> callable2) {
            super(cVar, new h.c.n0.f.a());
            this.f14736l = new AtomicReference<>();
            this.f14733h = callable;
            this.f14734j = callable2;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f16741e) {
                return;
            }
            this.f16741e = true;
            this.f14735k.cancel();
            n();
            if (g()) {
                this.f16740d.clear();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14735k.cancel();
            n();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14736l.get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        /* renamed from: m */
        public boolean e(k.a.c<? super U> cVar, U u) {
            this.f16739c.onNext(u);
            return true;
        }

        void n() {
            h.c.n0.a.c.h(this.f14736l);
        }

        void o() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f14733h.call(), "The buffer supplied is null");
                try {
                    k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14734j.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (h.c.n0.a.c.q(this.f14736l, aVar)) {
                        synchronized (this) {
                            U u2 = this.m;
                            if (u2 == null) {
                                return;
                            }
                            this.m = u;
                            bVar.subscribe(aVar);
                            j(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f16741e = true;
                    this.f14735k.cancel();
                    this.f16739c.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.f16739c.onError(th2);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                this.m = null;
                this.f16740d.offer(u);
                this.f16742f = true;
                if (g()) {
                    h.c.n0.j.r.e(this.f16740d, this.f16739c, false, this, this);
                }
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            cancel();
            this.f16739c.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14735k, dVar)) {
                this.f14735k = dVar;
                k.a.c<? super V> cVar = this.f16739c;
                try {
                    this.m = (U) h.c.n0.b.b.e(this.f14733h.call(), "The buffer supplied is null");
                    try {
                        k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14734j.call(), "The boundary publisher supplied is null");
                        a aVar = new a(this);
                        this.f14736l.set(aVar);
                        cVar.onSubscribe(this);
                        if (this.f16741e) {
                            return;
                        }
                        dVar.request(Long.MAX_VALUE);
                        bVar.subscribe(aVar);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f16741e = true;
                        dVar.cancel();
                        h.c.n0.i.d.q(th, cVar);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f16741e = true;
                    dVar.cancel();
                    h.c.n0.i.d.q(th2, cVar);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }
    }

    public n(h.c.h<T> hVar, Callable<? extends k.a.b<B>> callable, Callable<U> callable2) {
        super(hVar);
        this.f14729b = callable;
        this.f14730c = callable2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        this.a.subscribe((h.c.m) new b(new h.c.w0.d(cVar), this.f14730c, this.f14729b));
    }
}
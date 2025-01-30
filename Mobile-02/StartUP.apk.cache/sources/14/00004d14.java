package h.c.n0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableBufferExactBoundary.java */
/* loaded from: classes3.dex */
public final class o<T, U extends Collection<? super T>, B> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<B> f14772b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f14773c;

    /* compiled from: FlowableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>, B> extends h.c.w0.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f14774b;

        a(b<T, U, B> bVar) {
            this.f14774b = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14774b.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14774b.onError(th);
        }

        @Override // k.a.c
        public void onNext(B b2) {
            this.f14774b.n();
        }
    }

    /* compiled from: FlowableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends h.c.n0.h.m<T, U, U> implements h.c.m<T>, k.a.d, h.c.k0.b {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f14775h;

        /* renamed from: j  reason: collision with root package name */
        final k.a.b<B> f14776j;

        /* renamed from: k  reason: collision with root package name */
        k.a.d f14777k;

        /* renamed from: l  reason: collision with root package name */
        h.c.k0.b f14778l;
        U m;

        b(k.a.c<? super U> cVar, Callable<U> callable, k.a.b<B> bVar) {
            super(cVar, new h.c.n0.f.a());
            this.f14775h = callable;
            this.f14776j = bVar;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f16741e) {
                return;
            }
            this.f16741e = true;
            this.f14778l.dispose();
            this.f14777k.cancel();
            if (g()) {
                this.f16740d.clear();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            cancel();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16741e;
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        /* renamed from: m */
        public boolean e(k.a.c<? super U> cVar, U u) {
            this.f16739c.onNext(u);
            return true;
        }

        void n() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f14775h.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 == null) {
                        return;
                    }
                    this.m = u;
                    j(u2, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                this.f16739c.onError(th);
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
            if (h.c.n0.i.g.C(this.f14777k, dVar)) {
                this.f14777k = dVar;
                try {
                    this.m = (U) h.c.n0.b.b.e(this.f14775h.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f14778l = aVar;
                    this.f16739c.onSubscribe(this);
                    if (this.f16741e) {
                        return;
                    }
                    dVar.request(Long.MAX_VALUE);
                    this.f14776j.subscribe(aVar);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f16741e = true;
                    dVar.cancel();
                    h.c.n0.i.d.q(th, this.f16739c);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }
    }

    public o(h.c.h<T> hVar, k.a.b<B> bVar, Callable<U> callable) {
        super(hVar);
        this.f14772b = bVar;
        this.f14773c = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        this.a.subscribe((h.c.m) new b(new h.c.w0.d(cVar), this.f14773c, this.f14772b));
    }
}
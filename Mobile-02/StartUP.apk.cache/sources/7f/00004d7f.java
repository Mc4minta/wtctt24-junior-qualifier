package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundarySelector.java */
/* loaded from: classes3.dex */
public final class t4<T, B, V> extends h.c.n0.e.b.a<T, h.c.h<T>> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<B> f15056b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super B, ? extends k.a.b<V>> f15057c;

    /* renamed from: d  reason: collision with root package name */
    final int f15058d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class a<T, V> extends h.c.w0.b<V> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, ?, V> f15059b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.s0.c<T> f15060c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15061d;

        a(c<T, ?, V> cVar, h.c.s0.c<T> cVar2) {
            this.f15059b = cVar;
            this.f15060c = cVar2;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15061d) {
                return;
            }
            this.f15061d = true;
            this.f15059b.m(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15061d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15061d = true;
            this.f15059b.o(th);
        }

        @Override // k.a.c
        public void onNext(V v) {
            b();
            onComplete();
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends h.c.w0.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, B, ?> f15062b;

        b(c<T, B, ?> cVar) {
            this.f15062b = cVar;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15062b.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f15062b.o(th);
        }

        @Override // k.a.c
        public void onNext(B b2) {
            this.f15062b.p(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class c<T, B, V> extends h.c.n0.h.m<T, Object, h.c.h<T>> implements k.a.d {

        /* renamed from: h  reason: collision with root package name */
        final k.a.b<B> f15063h;

        /* renamed from: j  reason: collision with root package name */
        final h.c.m0.n<? super B, ? extends k.a.b<V>> f15064j;

        /* renamed from: k  reason: collision with root package name */
        final int f15065k;

        /* renamed from: l  reason: collision with root package name */
        final h.c.k0.a f15066l;
        k.a.d m;
        final AtomicReference<h.c.k0.b> n;
        final List<h.c.s0.c<T>> p;
        final AtomicLong q;
        final AtomicBoolean t;

        c(k.a.c<? super h.c.h<T>> cVar, k.a.b<B> bVar, h.c.m0.n<? super B, ? extends k.a.b<V>> nVar, int i2) {
            super(cVar, new h.c.n0.f.a());
            this.n = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.q = atomicLong;
            this.t = new AtomicBoolean();
            this.f15063h = bVar;
            this.f15064j = nVar;
            this.f15065k = i2;
            this.f15066l = new h.c.k0.a();
            this.p = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.t.compareAndSet(false, true)) {
                h.c.n0.a.c.h(this.n);
                if (this.q.decrementAndGet() == 0) {
                    this.m.cancel();
                }
            }
        }

        void dispose() {
            this.f15066l.dispose();
            h.c.n0.a.c.h(this.n);
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        public boolean e(k.a.c<? super h.c.h<T>> cVar, Object obj) {
            return false;
        }

        void m(a<T, V> aVar) {
            this.f15066l.c(aVar);
            this.f16740d.offer(new d(aVar.f15060c, null));
            if (g()) {
                n();
            }
        }

        void n() {
            h.c.n0.c.j jVar = this.f16740d;
            k.a.c<? super V> cVar = this.f16739c;
            List<h.c.s0.c<T>> list = this.p;
            int i2 = 1;
            while (true) {
                boolean z = this.f16742f;
                Object poll = jVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.f16743g;
                    if (th != null) {
                        for (h.c.s0.c<T> cVar2 : list) {
                            cVar2.onError(th);
                        }
                    } else {
                        for (h.c.s0.c<T> cVar3 : list) {
                            cVar3.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    h.c.s0.c<T> cVar4 = dVar.a;
                    if (cVar4 != null) {
                        if (list.remove(cVar4)) {
                            dVar.a.onComplete();
                            if (this.q.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.t.get()) {
                        h.c.s0.c<T> e2 = h.c.s0.c.e(this.f15065k);
                        long d2 = d();
                        if (d2 != 0) {
                            list.add(e2);
                            cVar.onNext(e2);
                            if (d2 != Long.MAX_VALUE) {
                                f(1L);
                            }
                            try {
                                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15064j.apply((B) dVar.f15067b), "The publisher supplied is null");
                                a aVar = new a(this, e2);
                                if (this.f15066l.b(aVar)) {
                                    this.q.getAndIncrement();
                                    bVar.subscribe(aVar);
                                }
                            } catch (Throwable th2) {
                                cancel();
                                cVar.onError(th2);
                            }
                        } else {
                            cancel();
                            cVar.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    for (h.c.s0.c<T> cVar5 : list) {
                        cVar5.onNext((T) h.c.n0.j.m.C(poll));
                    }
                }
            }
        }

        void o(Throwable th) {
            this.m.cancel();
            this.f15066l.dispose();
            h.c.n0.a.c.h(this.n);
            this.f16739c.onError(th);
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f16742f) {
                return;
            }
            this.f16742f = true;
            if (g()) {
                n();
            }
            if (this.q.decrementAndGet() == 0) {
                this.f15066l.dispose();
            }
            this.f16739c.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f16742f) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16743g = th;
            this.f16742f = true;
            if (g()) {
                n();
            }
            if (this.q.decrementAndGet() == 0) {
                this.f15066l.dispose();
            }
            this.f16739c.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16742f) {
                return;
            }
            if (i()) {
                for (h.c.s0.c<T> cVar : this.p) {
                    cVar.onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f16740d.offer(h.c.n0.j.m.F(t));
                if (!g()) {
                    return;
                }
            }
            n();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.m, dVar)) {
                this.m = dVar;
                this.f16739c.onSubscribe(this);
                if (this.t.get()) {
                    return;
                }
                b bVar = new b(this);
                if (this.n.compareAndSet(null, bVar)) {
                    dVar.request(Long.MAX_VALUE);
                    this.f15063h.subscribe(bVar);
                }
            }
        }

        void p(B b2) {
            this.f16740d.offer(new d(null, b2));
            if (g()) {
                n();
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class d<T, B> {
        final h.c.s0.c<T> a;

        /* renamed from: b  reason: collision with root package name */
        final B f15067b;

        d(h.c.s0.c<T> cVar, B b2) {
            this.a = cVar;
            this.f15067b = b2;
        }
    }

    public t4(h.c.h<T> hVar, k.a.b<B> bVar, h.c.m0.n<? super B, ? extends k.a.b<V>> nVar, int i2) {
        super(hVar);
        this.f15056b = bVar;
        this.f15057c = nVar;
        this.f15058d = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.h<T>> cVar) {
        this.a.subscribe((h.c.m) new c(new h.c.w0.d(cVar), this.f15056b, this.f15057c, this.f15058d));
    }
}
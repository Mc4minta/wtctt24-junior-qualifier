package h.c.n0.e.e;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySelector.java */
/* loaded from: classes3.dex */
public final class f4<T, B, V> extends h.c.n0.e.e.a<T, h.c.s<T>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<B> f15674b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super B, ? extends h.c.x<V>> f15675c;

    /* renamed from: d  reason: collision with root package name */
    final int f15676d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class a<T, V> extends h.c.p0.d<V> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, ?, V> f15677b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.v0.g<T> f15678c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15679d;

        a(c<T, ?, V> cVar, h.c.v0.g<T> gVar) {
            this.f15677b = cVar;
            this.f15678c = gVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15679d) {
                return;
            }
            this.f15679d = true;
            this.f15677b.i(this);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15679d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15679d = true;
            this.f15677b.l(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends h.c.p0.d<B> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, B, ?> f15680b;

        b(c<T, B, ?> cVar) {
            this.f15680b = cVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15680b.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15680b.l(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(B b2) {
            this.f15680b.m(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class c<T, B, V> extends h.c.n0.d.u<T, Object, h.c.s<T>> implements h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final h.c.x<B> f15681g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.m0.n<? super B, ? extends h.c.x<V>> f15682h;

        /* renamed from: j  reason: collision with root package name */
        final int f15683j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.k0.a f15684k;

        /* renamed from: l  reason: collision with root package name */
        h.c.k0.b f15685l;
        final AtomicReference<h.c.k0.b> m;
        final List<h.c.v0.g<T>> n;
        final AtomicLong p;
        final AtomicBoolean q;

        c(h.c.z<? super h.c.s<T>> zVar, h.c.x<B> xVar, h.c.m0.n<? super B, ? extends h.c.x<V>> nVar, int i2) {
            super(zVar, new h.c.n0.f.a());
            this.m = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.p = atomicLong;
            this.q = new AtomicBoolean();
            this.f15681g = xVar;
            this.f15682h = nVar;
            this.f15683j = i2;
            this.f15684k = new h.c.k0.a();
            this.n = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // h.c.n0.d.u, h.c.n0.j.n
        public void d(h.c.z<? super h.c.s<T>> zVar, Object obj) {
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.q.compareAndSet(false, true)) {
                h.c.n0.a.c.h(this.m);
                if (this.p.decrementAndGet() == 0) {
                    this.f15685l.dispose();
                }
            }
        }

        void i(a<T, V> aVar) {
            this.f15684k.c(aVar);
            this.f14144c.offer(new d(aVar.f15678c, null));
            if (e()) {
                k();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.q.get();
        }

        void j() {
            this.f15684k.dispose();
            h.c.n0.a.c.h(this.m);
        }

        void k() {
            h.c.n0.f.a aVar = (h.c.n0.f.a) this.f14144c;
            h.c.z<? super V> zVar = this.f14143b;
            List<h.c.v0.g<T>> list = this.n;
            int i2 = 1;
            while (true) {
                boolean z = this.f14146e;
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    j();
                    Throwable th = this.f14147f;
                    if (th != null) {
                        for (h.c.v0.g<T> gVar : list) {
                            gVar.onError(th);
                        }
                    } else {
                        for (h.c.v0.g<T> gVar2 : list) {
                            gVar2.onComplete();
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
                    h.c.v0.g<T> gVar3 = dVar.a;
                    if (gVar3 != null) {
                        if (list.remove(gVar3)) {
                            dVar.a.onComplete();
                            if (this.p.decrementAndGet() == 0) {
                                j();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.q.get()) {
                        h.c.v0.g<T> d2 = h.c.v0.g.d(this.f15683j);
                        list.add(d2);
                        zVar.onNext(d2);
                        try {
                            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15682h.apply((B) dVar.f15686b), "The ObservableSource supplied is null");
                            a aVar2 = new a(this, d2);
                            if (this.f15684k.b(aVar2)) {
                                this.p.getAndIncrement();
                                xVar.subscribe(aVar2);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.q.set(true);
                            zVar.onError(th2);
                        }
                    }
                } else {
                    for (h.c.v0.g<T> gVar4 : list) {
                        gVar4.onNext((T) h.c.n0.j.m.C(poll));
                    }
                }
            }
        }

        void l(Throwable th) {
            this.f15685l.dispose();
            this.f15684k.dispose();
            onError(th);
        }

        void m(B b2) {
            this.f14144c.offer(new d(null, b2));
            if (e()) {
                k();
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f14146e) {
                return;
            }
            this.f14146e = true;
            if (e()) {
                k();
            }
            if (this.p.decrementAndGet() == 0) {
                this.f15684k.dispose();
            }
            this.f14143b.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f14146e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14147f = th;
            this.f14146e = true;
            if (e()) {
                k();
            }
            if (this.p.decrementAndGet() == 0) {
                this.f15684k.dispose();
            }
            this.f14143b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (f()) {
                for (h.c.v0.g<T> gVar : this.n) {
                    gVar.onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f14144c.offer(h.c.n0.j.m.F(t));
                if (!e()) {
                    return;
                }
            }
            k();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15685l, bVar)) {
                this.f15685l = bVar;
                this.f14143b.onSubscribe(this);
                if (this.q.get()) {
                    return;
                }
                b bVar2 = new b(this);
                if (this.m.compareAndSet(null, bVar2)) {
                    this.f15681g.subscribe(bVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class d<T, B> {
        final h.c.v0.g<T> a;

        /* renamed from: b  reason: collision with root package name */
        final B f15686b;

        d(h.c.v0.g<T> gVar, B b2) {
            this.a = gVar;
            this.f15686b = b2;
        }
    }

    public f4(h.c.x<T> xVar, h.c.x<B> xVar2, h.c.m0.n<? super B, ? extends h.c.x<V>> nVar, int i2) {
        super(xVar);
        this.f15674b = xVar2;
        this.f15675c = nVar;
        this.f15676d = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.s<T>> zVar) {
        this.a.subscribe(new c(new h.c.p0.f(zVar), this.f15674b, this.f15675c, this.f15676d));
    }
}
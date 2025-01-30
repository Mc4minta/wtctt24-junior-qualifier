package h.c.n0.e.e;

import h.c.a0;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowTimed.java */
/* loaded from: classes3.dex */
public final class h4<T> extends h.c.n0.e.e.a<T, h.c.s<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f15757b;

    /* renamed from: c  reason: collision with root package name */
    final long f15758c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f15759d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f15760e;

    /* renamed from: f  reason: collision with root package name */
    final long f15761f;

    /* renamed from: g  reason: collision with root package name */
    final int f15762g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f15763h;

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.u<T, Object, h.c.s<T>> implements h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final long f15764g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f15765h;

        /* renamed from: j  reason: collision with root package name */
        final h.c.a0 f15766j;

        /* renamed from: k  reason: collision with root package name */
        final int f15767k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f15768l;
        final long m;
        final a0.c n;
        long p;
        long q;
        h.c.k0.b t;
        h.c.v0.g<T> u;
        volatile boolean v;
        final AtomicReference<h.c.k0.b> w;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: h.c.n0.e.e.h4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class RunnableC0381a implements Runnable {
            final long a;

            /* renamed from: b  reason: collision with root package name */
            final a<?> f15769b;

            RunnableC0381a(long j2, a<?> aVar) {
                this.a = j2;
                this.f15769b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f15769b;
                if (!((h.c.n0.d.u) aVar).f14145d) {
                    ((h.c.n0.d.u) aVar).f14144c.offer(this);
                } else {
                    aVar.v = true;
                    aVar.k();
                }
                if (aVar.e()) {
                    aVar.l();
                }
            }
        }

        a(h.c.z<? super h.c.s<T>> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, long j3, boolean z) {
            super(zVar, new h.c.n0.f.a());
            this.w = new AtomicReference<>();
            this.f15764g = j2;
            this.f15765h = timeUnit;
            this.f15766j = a0Var;
            this.f15767k = i2;
            this.m = j3;
            this.f15768l = z;
            if (z) {
                this.n = a0Var.a();
            } else {
                this.n = null;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14145d = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        void k() {
            h.c.n0.a.c.h(this.w);
            a0.c cVar = this.n;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void l() {
            h.c.n0.f.a aVar = (h.c.n0.f.a) this.f14144c;
            h.c.z<? super V> zVar = this.f14143b;
            h.c.v0.g<T> gVar = this.u;
            int i2 = 1;
            while (!this.v) {
                boolean z = this.f14146e;
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof RunnableC0381a;
                if (z && (z2 || z3)) {
                    this.u = null;
                    aVar.clear();
                    k();
                    Throwable th = this.f14147f;
                    if (th != null) {
                        gVar.onError(th);
                        return;
                    } else {
                        gVar.onComplete();
                        return;
                    }
                } else if (z2) {
                    i2 = c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0381a runnableC0381a = (RunnableC0381a) poll;
                    if (this.f15768l || this.q == runnableC0381a.a) {
                        gVar.onComplete();
                        this.p = 0L;
                        gVar = (h.c.v0.g<T>) h.c.v0.g.d(this.f15767k);
                        this.u = gVar;
                        zVar.onNext(gVar);
                    }
                } else {
                    gVar.onNext(h.c.n0.j.m.C(poll));
                    long j2 = this.p + 1;
                    if (j2 >= this.m) {
                        this.q++;
                        this.p = 0L;
                        gVar.onComplete();
                        gVar = (h.c.v0.g<T>) h.c.v0.g.d(this.f15767k);
                        this.u = gVar;
                        this.f14143b.onNext(gVar);
                        if (this.f15768l) {
                            h.c.k0.b bVar = this.w.get();
                            bVar.dispose();
                            a0.c cVar = this.n;
                            RunnableC0381a runnableC0381a2 = new RunnableC0381a(this.q, this);
                            long j3 = this.f15764g;
                            h.c.k0.b d2 = cVar.d(runnableC0381a2, j3, j3, this.f15765h);
                            if (!this.w.compareAndSet(bVar, d2)) {
                                d2.dispose();
                            }
                        }
                    } else {
                        this.p = j2;
                    }
                }
            }
            this.t.dispose();
            aVar.clear();
            k();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f14146e = true;
            if (e()) {
                l();
            }
            this.f14143b.onComplete();
            k();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f14147f = th;
            this.f14146e = true;
            if (e()) {
                l();
            }
            this.f14143b.onError(th);
            k();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (f()) {
                h.c.v0.g<T> gVar = this.u;
                gVar.onNext(t);
                long j2 = this.p + 1;
                if (j2 >= this.m) {
                    this.q++;
                    this.p = 0L;
                    gVar.onComplete();
                    h.c.v0.g<T> d2 = h.c.v0.g.d(this.f15767k);
                    this.u = d2;
                    this.f14143b.onNext(d2);
                    if (this.f15768l) {
                        this.w.get().dispose();
                        a0.c cVar = this.n;
                        RunnableC0381a runnableC0381a = new RunnableC0381a(this.q, this);
                        long j3 = this.f15764g;
                        h.c.n0.a.c.q(this.w, cVar.d(runnableC0381a, j3, j3, this.f15765h));
                    }
                } else {
                    this.p = j2;
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
            l();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.k0.b e2;
            if (h.c.n0.a.c.B(this.t, bVar)) {
                this.t = bVar;
                h.c.z<? super V> zVar = this.f14143b;
                zVar.onSubscribe(this);
                if (this.f14145d) {
                    return;
                }
                h.c.v0.g<T> d2 = h.c.v0.g.d(this.f15767k);
                this.u = d2;
                zVar.onNext(d2);
                RunnableC0381a runnableC0381a = new RunnableC0381a(this.q, this);
                if (this.f15768l) {
                    a0.c cVar = this.n;
                    long j2 = this.f15764g;
                    e2 = cVar.d(runnableC0381a, j2, j2, this.f15765h);
                } else {
                    h.c.a0 a0Var = this.f15766j;
                    long j3 = this.f15764g;
                    e2 = a0Var.e(runnableC0381a, j3, j3, this.f15765h);
                }
                h.c.n0.a.c.q(this.w, e2);
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.d.u<T, Object, h.c.s<T>> implements h.c.z<T>, h.c.k0.b, Runnable {

        /* renamed from: g  reason: collision with root package name */
        static final Object f15770g = new Object();

        /* renamed from: h  reason: collision with root package name */
        final long f15771h;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f15772j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.a0 f15773k;

        /* renamed from: l  reason: collision with root package name */
        final int f15774l;
        h.c.k0.b m;
        h.c.v0.g<T> n;
        final AtomicReference<h.c.k0.b> p;
        volatile boolean q;

        b(h.c.z<? super h.c.s<T>> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2) {
            super(zVar, new h.c.n0.f.a());
            this.p = new AtomicReference<>();
            this.f15771h = j2;
            this.f15772j = timeUnit;
            this.f15773k = a0Var;
            this.f15774l = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14145d = true;
        }

        void i() {
            h.c.n0.a.c.h(this.p);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            r7.n = null;
            r0.clear();
            i();
            r0 = r7.f14147f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r0 == null) goto L13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j() {
            /*
                r7 = this;
                h.c.n0.c.i<U> r0 = r7.f14144c
                h.c.n0.f.a r0 = (h.c.n0.f.a) r0
                h.c.z<? super V> r1 = r7.f14143b
                h.c.v0.g<T> r2 = r7.n
                r3 = 1
            L9:
                boolean r4 = r7.q
                boolean r5 = r7.f14146e
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = h.c.n0.e.e.h4.b.f15770g
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.n = r1
                r0.clear()
                r7.i()
                java.lang.Throwable r0 = r7.f14147f
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.c(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = h.c.n0.e.e.h4.b.f15770g
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.f15774l
                h.c.v0.g r2 = h.c.v0.g.d(r2)
                r7.n = r2
                r1.onNext(r2)
                goto L9
            L4d:
                h.c.k0.b r4 = r7.m
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = h.c.n0.j.m.C(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.h4.b.j():void");
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f14146e = true;
            if (e()) {
                j();
            }
            i();
            this.f14143b.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f14147f = th;
            this.f14146e = true;
            if (e()) {
                j();
            }
            i();
            this.f14143b.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.q) {
                return;
            }
            if (f()) {
                this.n.onNext(t);
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f14144c.offer(h.c.n0.j.m.F(t));
                if (!e()) {
                    return;
                }
            }
            j();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.m, bVar)) {
                this.m = bVar;
                this.n = h.c.v0.g.d(this.f15774l);
                h.c.z<? super V> zVar = this.f14143b;
                zVar.onSubscribe(this);
                zVar.onNext(this.n);
                if (this.f14145d) {
                    return;
                }
                h.c.a0 a0Var = this.f15773k;
                long j2 = this.f15771h;
                h.c.n0.a.c.q(this.p, a0Var.e(this, j2, j2, this.f15772j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14145d) {
                this.q = true;
                i();
            }
            this.f14144c.offer(f15770g);
            if (e()) {
                j();
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends h.c.n0.d.u<T, Object, h.c.s<T>> implements h.c.k0.b, Runnable {

        /* renamed from: g  reason: collision with root package name */
        final long f15775g;

        /* renamed from: h  reason: collision with root package name */
        final long f15776h;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f15777j;

        /* renamed from: k  reason: collision with root package name */
        final a0.c f15778k;

        /* renamed from: l  reason: collision with root package name */
        final int f15779l;
        final List<h.c.v0.g<T>> m;
        h.c.k0.b n;
        volatile boolean p;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {
            private final h.c.v0.g<T> a;

            a(h.c.v0.g<T> gVar) {
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.i(this.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* loaded from: classes3.dex */
        public static final class b<T> {
            final h.c.v0.g<T> a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f15781b;

            b(h.c.v0.g<T> gVar, boolean z) {
                this.a = gVar;
                this.f15781b = z;
            }
        }

        c(h.c.z<? super h.c.s<T>> zVar, long j2, long j3, TimeUnit timeUnit, a0.c cVar, int i2) {
            super(zVar, new h.c.n0.f.a());
            this.f15775g = j2;
            this.f15776h = j3;
            this.f15777j = timeUnit;
            this.f15778k = cVar;
            this.f15779l = i2;
            this.m = new LinkedList();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14145d = true;
        }

        void i(h.c.v0.g<T> gVar) {
            this.f14144c.offer(new b(gVar, false));
            if (e()) {
                k();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        void j() {
            this.f15778k.dispose();
        }

        void k() {
            h.c.n0.f.a aVar = (h.c.n0.f.a) this.f14144c;
            h.c.z<? super V> zVar = this.f14143b;
            List<h.c.v0.g<T>> list = this.m;
            int i2 = 1;
            while (!this.p) {
                boolean z = this.f14146e;
                T t = (T) aVar.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof b;
                if (z && (z2 || z3)) {
                    aVar.clear();
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
                    j();
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) t;
                    if (bVar.f15781b) {
                        if (!this.f14145d) {
                            h.c.v0.g<T> d2 = h.c.v0.g.d(this.f15779l);
                            list.add(d2);
                            zVar.onNext(d2);
                            this.f15778k.c(new a(d2), this.f15775g, this.f15777j);
                        }
                    } else {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.f14145d) {
                            this.p = true;
                        }
                    }
                } else {
                    for (h.c.v0.g<T> gVar3 : list) {
                        gVar3.onNext(t);
                    }
                }
            }
            this.n.dispose();
            j();
            aVar.clear();
            list.clear();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f14146e = true;
            if (e()) {
                k();
            }
            this.f14143b.onComplete();
            j();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f14147f = th;
            this.f14146e = true;
            if (e()) {
                k();
            }
            this.f14143b.onError(th);
            j();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (f()) {
                for (h.c.v0.g<T> gVar : this.m) {
                    gVar.onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f14144c.offer(t);
                if (!e()) {
                    return;
                }
            }
            k();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.n, bVar)) {
                this.n = bVar;
                this.f14143b.onSubscribe(this);
                if (this.f14145d) {
                    return;
                }
                h.c.v0.g<T> d2 = h.c.v0.g.d(this.f15779l);
                this.m.add(d2);
                this.f14143b.onNext(d2);
                this.f15778k.c(new a(d2), this.f15775g, this.f15777j);
                a0.c cVar = this.f15778k;
                long j2 = this.f15776h;
                cVar.d(this, j2, j2, this.f15777j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(h.c.v0.g.d(this.f15779l), true);
            if (!this.f14145d) {
                this.f14144c.offer(bVar);
            }
            if (e()) {
                k();
            }
        }
    }

    public h4(h.c.x<T> xVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, long j4, int i2, boolean z) {
        super(xVar);
        this.f15757b = j2;
        this.f15758c = j3;
        this.f15759d = timeUnit;
        this.f15760e = a0Var;
        this.f15761f = j4;
        this.f15762g = i2;
        this.f15763h = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.s<T>> zVar) {
        h.c.p0.f fVar = new h.c.p0.f(zVar);
        long j2 = this.f15757b;
        long j3 = this.f15758c;
        if (j2 == j3) {
            long j4 = this.f15761f;
            if (j4 == Long.MAX_VALUE) {
                this.a.subscribe(new b(fVar, this.f15757b, this.f15759d, this.f15760e, this.f15762g));
                return;
            } else {
                this.a.subscribe(new a(fVar, j2, this.f15759d, this.f15760e, this.f15762g, j4, this.f15763h));
                return;
            }
        }
        this.a.subscribe(new c(fVar, j2, j3, this.f15759d, this.f15760e.a(), this.f15762g));
    }
}
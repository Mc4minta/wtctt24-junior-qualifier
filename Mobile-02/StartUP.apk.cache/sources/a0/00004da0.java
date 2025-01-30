package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableWindowTimed.java */
/* loaded from: classes3.dex */
public final class v4<T> extends h.c.n0.e.b.a<T, h.c.h<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f15142b;

    /* renamed from: c  reason: collision with root package name */
    final long f15143c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f15144d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f15145e;

    /* renamed from: f  reason: collision with root package name */
    final long f15146f;

    /* renamed from: g  reason: collision with root package name */
    final int f15147g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f15148h;

    /* compiled from: FlowableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.m<T, Object, h.c.h<T>> implements k.a.d {

        /* renamed from: h  reason: collision with root package name */
        final long f15149h;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f15150j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.a0 f15151k;

        /* renamed from: l  reason: collision with root package name */
        final int f15152l;
        final boolean m;
        final long n;
        final a0.c p;
        long q;
        long t;
        k.a.d u;
        h.c.s0.c<T> v;
        volatile boolean w;
        final h.c.n0.a.g x;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableWindowTimed.java */
        /* renamed from: h.c.n0.e.b.v4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class RunnableC0358a implements Runnable {
            final long a;

            /* renamed from: b  reason: collision with root package name */
            final a<?> f15153b;

            RunnableC0358a(long j2, a<?> aVar) {
                this.a = j2;
                this.f15153b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f15153b;
                if (!((h.c.n0.h.m) aVar).f16741e) {
                    ((h.c.n0.h.m) aVar).f16740d.offer(this);
                } else {
                    aVar.w = true;
                    aVar.dispose();
                }
                if (aVar.g()) {
                    aVar.o();
                }
            }
        }

        a(k.a.c<? super h.c.h<T>> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, long j3, boolean z) {
            super(cVar, new h.c.n0.f.a());
            this.x = new h.c.n0.a.g();
            this.f15149h = j2;
            this.f15150j = timeUnit;
            this.f15151k = a0Var;
            this.f15152l = i2;
            this.n = j3;
            this.m = z;
            if (z) {
                this.p = a0Var.a();
            } else {
                this.p = null;
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f16741e = true;
        }

        public void dispose() {
            h.c.n0.a.c.h(this.x);
            a0.c cVar = this.p;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        void o() {
            h.c.n0.c.j jVar = this.f16740d;
            k.a.c<? super V> cVar = this.f16739c;
            h.c.s0.c<T> cVar2 = this.v;
            int i2 = 1;
            while (!this.w) {
                boolean z = this.f16742f;
                Object poll = jVar.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof RunnableC0358a;
                if (z && (z2 || z3)) {
                    this.v = null;
                    jVar.clear();
                    Throwable th = this.f16743g;
                    if (th != null) {
                        cVar2.onError(th);
                    } else {
                        cVar2.onComplete();
                    }
                    dispose();
                    return;
                } else if (z2) {
                    i2 = c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    int i3 = i2;
                    if (z3) {
                        RunnableC0358a runnableC0358a = (RunnableC0358a) poll;
                        if (this.m || this.t == runnableC0358a.a) {
                            cVar2.onComplete();
                            this.q = 0L;
                            cVar2 = h.c.s0.c.e(this.f15152l);
                            this.v = cVar2;
                            long d2 = d();
                            if (d2 != 0) {
                                cVar.onNext(cVar2);
                                if (d2 != Long.MAX_VALUE) {
                                    f(1L);
                                }
                            } else {
                                this.v = null;
                                this.f16740d.clear();
                                this.u.cancel();
                                cVar.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                dispose();
                                return;
                            }
                        }
                    } else {
                        cVar2.onNext(h.c.n0.j.m.C(poll));
                        long j2 = this.q + 1;
                        if (j2 >= this.n) {
                            this.t++;
                            this.q = 0L;
                            cVar2.onComplete();
                            long d3 = d();
                            if (d3 != 0) {
                                h.c.s0.c<T> e2 = h.c.s0.c.e(this.f15152l);
                                this.v = e2;
                                this.f16739c.onNext(e2);
                                if (d3 != Long.MAX_VALUE) {
                                    f(1L);
                                }
                                if (this.m) {
                                    this.x.get().dispose();
                                    a0.c cVar3 = this.p;
                                    RunnableC0358a runnableC0358a2 = new RunnableC0358a(this.t, this);
                                    long j3 = this.f15149h;
                                    this.x.a(cVar3.d(runnableC0358a2, j3, j3, this.f15150j));
                                }
                                cVar2 = e2;
                            } else {
                                this.v = null;
                                this.u.cancel();
                                this.f16739c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                        } else {
                            this.q = j2;
                        }
                    }
                    i2 = i3;
                }
            }
            this.u.cancel();
            jVar.clear();
            dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f16742f = true;
            if (g()) {
                o();
            }
            this.f16739c.onComplete();
            dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16743g = th;
            this.f16742f = true;
            if (g()) {
                o();
            }
            this.f16739c.onError(th);
            dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.w) {
                return;
            }
            if (i()) {
                h.c.s0.c<T> cVar = this.v;
                cVar.onNext(t);
                long j2 = this.q + 1;
                if (j2 >= this.n) {
                    this.t++;
                    this.q = 0L;
                    cVar.onComplete();
                    long d2 = d();
                    if (d2 != 0) {
                        h.c.s0.c<T> e2 = h.c.s0.c.e(this.f15152l);
                        this.v = e2;
                        this.f16739c.onNext(e2);
                        if (d2 != Long.MAX_VALUE) {
                            f(1L);
                        }
                        if (this.m) {
                            this.x.get().dispose();
                            a0.c cVar2 = this.p;
                            RunnableC0358a runnableC0358a = new RunnableC0358a(this.t, this);
                            long j3 = this.f15149h;
                            this.x.a(cVar2.d(runnableC0358a, j3, j3, this.f15150j));
                        }
                    } else {
                        this.v = null;
                        this.u.cancel();
                        this.f16739c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                } else {
                    this.q = j2;
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
            o();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.k0.b e2;
            if (h.c.n0.i.g.C(this.u, dVar)) {
                this.u = dVar;
                k.a.c<? super V> cVar = this.f16739c;
                cVar.onSubscribe(this);
                if (this.f16741e) {
                    return;
                }
                h.c.s0.c<T> e3 = h.c.s0.c.e(this.f15152l);
                this.v = e3;
                long d2 = d();
                if (d2 != 0) {
                    cVar.onNext(e3);
                    if (d2 != Long.MAX_VALUE) {
                        f(1L);
                    }
                    RunnableC0358a runnableC0358a = new RunnableC0358a(this.t, this);
                    if (this.m) {
                        a0.c cVar2 = this.p;
                        long j2 = this.f15149h;
                        e2 = cVar2.d(runnableC0358a, j2, j2, this.f15150j);
                    } else {
                        h.c.a0 a0Var = this.f15151k;
                        long j3 = this.f15149h;
                        e2 = a0Var.e(runnableC0358a, j3, j3, this.f15150j);
                    }
                    if (this.x.a(e2)) {
                        dVar.request(Long.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.f16741e = true;
                dVar.cancel();
                cVar.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.h.m<T, Object, h.c.h<T>> implements h.c.m<T>, k.a.d, Runnable {

        /* renamed from: h  reason: collision with root package name */
        static final Object f15154h = new Object();

        /* renamed from: j  reason: collision with root package name */
        final long f15155j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f15156k;

        /* renamed from: l  reason: collision with root package name */
        final h.c.a0 f15157l;
        final int m;
        k.a.d n;
        h.c.s0.c<T> p;
        final h.c.n0.a.g q;
        volatile boolean t;

        b(k.a.c<? super h.c.h<T>> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2) {
            super(cVar, new h.c.n0.f.a());
            this.q = new h.c.n0.a.g();
            this.f15155j = j2;
            this.f15156k = timeUnit;
            this.f15157l = a0Var;
            this.m = i2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f16741e = true;
        }

        public void dispose() {
            h.c.n0.a.c.h(this.q);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
            r10.p = null;
            r0.clear();
            dispose();
            r0 = r10.f16743g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r0 == null) goto L13;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r10 = this;
                h.c.n0.c.i<U> r0 = r10.f16740d
                k.a.c<? super V> r1 = r10.f16739c
                h.c.s0.c<T> r2 = r10.p
                r3 = 1
            L7:
                boolean r4 = r10.t
                boolean r5 = r10.f16742f
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = h.c.n0.e.b.v4.b.f15154h
                if (r6 != r5) goto L2c
            L18:
                r10.p = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.f16743g
                if (r0 == 0) goto L28
                r2.onError(r0)
                goto L2b
            L28:
                r2.onComplete()
            L2b:
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.c(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = h.c.n0.e.b.v4.b.f15154h
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.m
                h.c.s0.c r2 = h.c.s0.c.e(r2)
                r10.p = r2
                long r4 = r10.d()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L7
                r4 = 1
                r10.f(r4)
                goto L7
            L63:
                r10.p = r7
                h.c.n0.c.i<U> r0 = r10.f16740d
                r0.clear()
                k.a.d r0 = r10.n
                r0.cancel()
                r10.dispose()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                k.a.d r4 = r10.n
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = h.c.n0.j.m.C(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.v4.b.m():void");
        }

        @Override // k.a.c
        public void onComplete() {
            this.f16742f = true;
            if (g()) {
                m();
            }
            this.f16739c.onComplete();
            dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16743g = th;
            this.f16742f = true;
            if (g()) {
                m();
            }
            this.f16739c.onError(th);
            dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.t) {
                return;
            }
            if (i()) {
                this.p.onNext(t);
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f16740d.offer(h.c.n0.j.m.F(t));
                if (!g()) {
                    return;
                }
            }
            m();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.n, dVar)) {
                this.n = dVar;
                this.p = h.c.s0.c.e(this.m);
                k.a.c<? super V> cVar = this.f16739c;
                cVar.onSubscribe(this);
                long d2 = d();
                if (d2 != 0) {
                    cVar.onNext(this.p);
                    if (d2 != Long.MAX_VALUE) {
                        f(1L);
                    }
                    if (this.f16741e) {
                        return;
                    }
                    h.c.n0.a.g gVar = this.q;
                    h.c.a0 a0Var = this.f15157l;
                    long j2 = this.f15155j;
                    if (gVar.a(a0Var.e(this, j2, j2, this.f15156k))) {
                        dVar.request(Long.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.f16741e = true;
                dVar.cancel();
                cVar.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16741e) {
                this.t = true;
                dispose();
            }
            this.f16740d.offer(f15154h);
            if (g()) {
                m();
            }
        }
    }

    /* compiled from: FlowableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends h.c.n0.h.m<T, Object, h.c.h<T>> implements k.a.d, Runnable {

        /* renamed from: h  reason: collision with root package name */
        final long f15158h;

        /* renamed from: j  reason: collision with root package name */
        final long f15159j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f15160k;

        /* renamed from: l  reason: collision with root package name */
        final a0.c f15161l;
        final int m;
        final List<h.c.s0.c<T>> n;
        k.a.d p;
        volatile boolean q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableWindowTimed.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {
            private final h.c.s0.c<T> a;

            a(h.c.s0.c<T> cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.m(this.a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableWindowTimed.java */
        /* loaded from: classes3.dex */
        public static final class b<T> {
            final h.c.s0.c<T> a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f15163b;

            b(h.c.s0.c<T> cVar, boolean z) {
                this.a = cVar;
                this.f15163b = z;
            }
        }

        c(k.a.c<? super h.c.h<T>> cVar, long j2, long j3, TimeUnit timeUnit, a0.c cVar2, int i2) {
            super(cVar, new h.c.n0.f.a());
            this.f15158h = j2;
            this.f15159j = j3;
            this.f15160k = timeUnit;
            this.f15161l = cVar2;
            this.m = i2;
            this.n = new LinkedList();
        }

        @Override // k.a.d
        public void cancel() {
            this.f16741e = true;
        }

        public void dispose() {
            this.f15161l.dispose();
        }

        void m(h.c.s0.c<T> cVar) {
            this.f16740d.offer(new b(cVar, false));
            if (g()) {
                n();
            }
        }

        void n() {
            h.c.n0.c.j jVar = this.f16740d;
            k.a.c<? super V> cVar = this.f16739c;
            List<h.c.s0.c<T>> list = this.n;
            int i2 = 1;
            while (!this.q) {
                boolean z = this.f16742f;
                T t = (T) jVar.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof b;
                if (z && (z2 || z3)) {
                    jVar.clear();
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
                    dispose();
                    return;
                } else if (z2) {
                    i2 = c(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) t;
                    if (bVar.f15163b) {
                        if (!this.f16741e) {
                            long d2 = d();
                            if (d2 != 0) {
                                h.c.s0.c<T> e2 = h.c.s0.c.e(this.m);
                                list.add(e2);
                                cVar.onNext(e2);
                                if (d2 != Long.MAX_VALUE) {
                                    f(1L);
                                }
                                this.f15161l.c(new a(e2), this.f15158h, this.f15160k);
                            } else {
                                cVar.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                            }
                        }
                    } else {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.f16741e) {
                            this.q = true;
                        }
                    }
                } else {
                    for (h.c.s0.c<T> cVar4 : list) {
                        cVar4.onNext(t);
                    }
                }
            }
            this.p.cancel();
            dispose();
            jVar.clear();
            list.clear();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f16742f = true;
            if (g()) {
                n();
            }
            this.f16739c.onComplete();
            dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16743g = th;
            this.f16742f = true;
            if (g()) {
                n();
            }
            this.f16739c.onError(th);
            dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (i()) {
                for (h.c.s0.c<T> cVar : this.n) {
                    cVar.onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.f16740d.offer(t);
                if (!g()) {
                    return;
                }
            }
            n();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.p, dVar)) {
                this.p = dVar;
                this.f16739c.onSubscribe(this);
                if (this.f16741e) {
                    return;
                }
                long d2 = d();
                if (d2 != 0) {
                    h.c.s0.c<T> e2 = h.c.s0.c.e(this.m);
                    this.n.add(e2);
                    this.f16739c.onNext(e2);
                    if (d2 != Long.MAX_VALUE) {
                        f(1L);
                    }
                    this.f15161l.c(new a(e2), this.f15158h, this.f15160k);
                    a0.c cVar = this.f15161l;
                    long j2 = this.f15159j;
                    cVar.d(this, j2, j2, this.f15160k);
                    dVar.request(Long.MAX_VALUE);
                    return;
                }
                dVar.cancel();
                this.f16739c.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(h.c.s0.c.e(this.m), true);
            if (!this.f16741e) {
                this.f16740d.offer(bVar);
            }
            if (g()) {
                n();
            }
        }
    }

    public v4(h.c.h<T> hVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, long j4, int i2, boolean z) {
        super(hVar);
        this.f15142b = j2;
        this.f15143c = j3;
        this.f15144d = timeUnit;
        this.f15145e = a0Var;
        this.f15146f = j4;
        this.f15147g = i2;
        this.f15148h = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.h<T>> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        long j2 = this.f15142b;
        long j3 = this.f15143c;
        if (j2 == j3) {
            long j4 = this.f15146f;
            if (j4 == Long.MAX_VALUE) {
                this.a.subscribe((h.c.m) new b(dVar, this.f15142b, this.f15144d, this.f15145e, this.f15147g));
                return;
            } else {
                this.a.subscribe((h.c.m) new a(dVar, j2, this.f15144d, this.f15145e, this.f15147g, j4, this.f15148h));
                return;
            }
        }
        this.a.subscribe((h.c.m) new c(dVar, j2, j3, this.f15144d, this.f15145e.a(), this.f15147g));
    }
}
package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapSingle.java */
/* loaded from: classes3.dex */
public final class d1<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f14308b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14309c;

    /* renamed from: d  reason: collision with root package name */
    final int f14310d;

    /* compiled from: FlowableFlatMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f14311b;

        /* renamed from: c  reason: collision with root package name */
        final int f14312c;

        /* renamed from: h  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> f14317h;

        /* renamed from: k  reason: collision with root package name */
        k.a.d f14319k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14320l;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f14313d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f14314e = new h.c.k0.a();

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.j.c f14316g = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f14315f = new AtomicInteger(1);

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<h.c.n0.f.c<R>> f14318j = new AtomicReference<>();

        /* compiled from: FlowableFlatMapSingle.java */
        /* renamed from: h.c.n0.e.b.d1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0347a extends AtomicReference<h.c.k0.b> implements h.c.e0<R>, h.c.k0.b {
            C0347a() {
            }

            @Override // h.c.k0.b
            public void dispose() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return h.c.n0.a.c.n(get());
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                a.this.e(this, th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                a.this.f(this, r);
            }
        }

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar, boolean z, int i2) {
            this.a = cVar;
            this.f14317h = nVar;
            this.f14311b = z;
            this.f14312c = i2;
        }

        void a() {
            h.c.n0.f.c<R> cVar = this.f14318j.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
            if (r12 != 0) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
            if (r17.f14320l == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
            if (r17.f14311b != false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
            if (r17.f14316g.get() == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
            r2 = r17.f14316g.b();
            a();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
            if (r2.get() != 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
            if (r7 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
            if (r7.isEmpty() == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
            if (r6 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
            if (r13 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
            r2 = r17.f14316g.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
            if (r2 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
            if (r10 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
            h.c.n0.j.d.e(r17.f14313d, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
            if (r17.f14312c == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
            r17.f14319k.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.d1.a.c():void");
        }

        @Override // k.a.d
        public void cancel() {
            this.f14320l = true;
            this.f14319k.cancel();
            this.f14314e.dispose();
        }

        h.c.n0.f.c<R> d() {
            h.c.n0.f.c<R> cVar;
            do {
                h.c.n0.f.c<R> cVar2 = this.f14318j.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.c.n0.f.c<>(h.c.h.bufferSize());
            } while (!this.f14318j.compareAndSet(null, cVar));
            return cVar;
        }

        void e(a<T, R>.C0347a c0347a, Throwable th) {
            this.f14314e.c(c0347a);
            if (this.f14316g.a(th)) {
                if (!this.f14311b) {
                    this.f14319k.cancel();
                    this.f14314e.dispose();
                } else if (this.f14312c != Integer.MAX_VALUE) {
                    this.f14319k.request(1L);
                }
                this.f14315f.decrementAndGet();
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        void f(a<T, R>.C0347a c0347a, R r) {
            this.f14314e.c(c0347a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f14315f.decrementAndGet() == 0;
                    if (this.f14313d.get() != 0) {
                        this.a.onNext(r);
                        h.c.n0.f.c<R> cVar = this.f14318j.get();
                        if (z && (cVar == null || cVar.isEmpty())) {
                            Throwable b2 = this.f14316g.b();
                            if (b2 != null) {
                                this.a.onError(b2);
                                return;
                            } else {
                                this.a.onComplete();
                                return;
                            }
                        }
                        h.c.n0.j.d.e(this.f14313d, 1L);
                        if (this.f14312c != Integer.MAX_VALUE) {
                            this.f14319k.request(1L);
                        }
                    } else {
                        h.c.n0.f.c<R> d2 = d();
                        synchronized (d2) {
                            d2.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            h.c.n0.f.c<R> d3 = d();
            synchronized (d3) {
                d3.offer(r);
            }
            this.f14315f.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14315f.decrementAndGet();
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14315f.decrementAndGet();
            if (this.f14316g.a(th)) {
                if (!this.f14311b) {
                    this.f14314e.dispose();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            try {
                h.c.h0 h0Var = (h.c.h0) h.c.n0.b.b.e(this.f14317h.apply(t), "The mapper returned a null SingleSource");
                this.f14315f.getAndIncrement();
                C0347a c0347a = new C0347a();
                if (this.f14320l || !this.f14314e.b(c0347a)) {
                    return;
                }
                h0Var.subscribe(c0347a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14319k.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14319k, dVar)) {
                this.f14319k = dVar;
                this.a.onSubscribe(this);
                int i2 = this.f14312c;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i2);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14313d, j2);
                b();
            }
        }
    }

    public d1(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.h0<? extends R>> nVar, boolean z, int i2) {
        super(hVar);
        this.f14308b = nVar;
        this.f14309c = z;
        this.f14310d = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14308b, this.f14309c, this.f14310d));
    }
}
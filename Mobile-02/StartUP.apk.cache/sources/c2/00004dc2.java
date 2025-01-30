package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMap.java */
/* loaded from: classes3.dex */
public final class y0<T, U> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends U>> f15232b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15233c;

    /* renamed from: d  reason: collision with root package name */
    final int f15234d;

    /* renamed from: e  reason: collision with root package name */
    final int f15235e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> extends AtomicReference<k.a.d> implements h.c.m<U>, h.c.k0.b {
        final long a;

        /* renamed from: b  reason: collision with root package name */
        final b<T, U> f15236b;

        /* renamed from: c  reason: collision with root package name */
        final int f15237c;

        /* renamed from: d  reason: collision with root package name */
        final int f15238d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15239e;

        /* renamed from: f  reason: collision with root package name */
        volatile h.c.n0.c.j<U> f15240f;

        /* renamed from: g  reason: collision with root package name */
        long f15241g;

        /* renamed from: h  reason: collision with root package name */
        int f15242h;

        a(b<T, U> bVar, long j2) {
            this.a = j2;
            this.f15236b = bVar;
            int i2 = bVar.f15248g;
            this.f15238d = i2;
            this.f15237c = i2 >> 2;
        }

        void a(long j2) {
            if (this.f15242h != 1) {
                long j3 = this.f15241g + j2;
                if (j3 >= this.f15237c) {
                    this.f15241g = 0L;
                    get().request(j3);
                    return;
                }
                this.f15241g = j3;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.i.g.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15239e = true;
            this.f15236b.e();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            lazySet(h.c.n0.i.g.CANCELLED);
            this.f15236b.j(this, th);
        }

        @Override // k.a.c
        public void onNext(U u) {
            if (this.f15242h != 2) {
                this.f15236b.l(u, this);
            } else {
                this.f15236b.e();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f15242h = n;
                        this.f15240f = gVar;
                        this.f15239e = true;
                        this.f15236b.e();
                        return;
                    } else if (n == 2) {
                        this.f15242h = n;
                        this.f15240f = gVar;
                    }
                }
                dVar.request(this.f15238d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T, U> extends AtomicInteger implements h.c.m<T>, k.a.d {
        static final a<?, ?>[] a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a<?, ?>[] f15243b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        final k.a.c<? super U> f15244c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<? extends U>> f15245d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f15246e;

        /* renamed from: f  reason: collision with root package name */
        final int f15247f;

        /* renamed from: g  reason: collision with root package name */
        final int f15248g;

        /* renamed from: h  reason: collision with root package name */
        volatile h.c.n0.c.i<U> f15249h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15250j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.n0.j.c f15251k = new h.c.n0.j.c();

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15252l;
        final AtomicReference<a<?, ?>[]> m;
        final AtomicLong n;
        k.a.d p;
        long q;
        long t;
        int u;
        int v;
        final int w;

        b(k.a.c<? super U> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, boolean z, int i2, int i3) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.m = atomicReference;
            this.n = new AtomicLong();
            this.f15244c = cVar;
            this.f15245d = nVar;
            this.f15246e = z;
            this.f15247f = i2;
            this.f15248g = i3;
            this.w = Math.max(1, i2 >> 1);
            atomicReference.lazySet(a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.m.get();
                if (aVarArr == f15243b) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.m.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            if (this.f15252l) {
                c();
                return true;
            } else if (this.f15246e || this.f15251k.get() == null) {
                return false;
            } else {
                c();
                Throwable b2 = this.f15251k.b();
                if (b2 != h.c.n0.j.j.a) {
                    this.f15244c.onError(b2);
                }
                return true;
            }
        }

        void c() {
            h.c.n0.c.i<U> iVar = this.f15249h;
            if (iVar != null) {
                iVar.clear();
            }
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.c.i<U> iVar;
            if (this.f15252l) {
                return;
            }
            this.f15252l = true;
            this.p.cancel();
            d();
            if (getAndIncrement() != 0 || (iVar = this.f15249h) == null) {
                return;
            }
            iVar.clear();
        }

        void d() {
            a<?, ?>[] andSet;
            a<?, ?>[] aVarArr = this.m.get();
            a<?, ?>[] aVarArr2 = f15243b;
            if (aVarArr == aVarArr2 || (andSet = this.m.getAndSet(aVarArr2)) == aVarArr2) {
                return;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.dispose();
            }
            Throwable b2 = this.f15251k.b();
            if (b2 == null || b2 == h.c.n0.j.j.a) {
                return;
            }
            h.c.r0.a.u(b2);
        }

        void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0151, code lost:
            if (r22 != null) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x0154, code lost:
            r10 = r13;
            r11 = r22;
            r14 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0135, code lost:
            if (r10 == r14) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0137, code lost:
            if (r9 != false) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0139, code lost:
            r5 = r24.n.addAndGet(-r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0141, code lost:
            r5 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0146, code lost:
            r7.a(r10);
            r10 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x014c, code lost:
            r10 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x014f, code lost:
            if (r5 == r10) goto L124;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                Method dump skipped, instructions count: 449
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.y0.b.f():void");
        }

        h.c.n0.c.j<U> g(a<T, U> aVar) {
            h.c.n0.c.j<U> jVar = aVar.f15240f;
            if (jVar == null) {
                h.c.n0.f.b bVar = new h.c.n0.f.b(this.f15248g);
                aVar.f15240f = bVar;
                return bVar;
            }
            return jVar;
        }

        h.c.n0.c.j<U> i() {
            h.c.n0.c.i<U> iVar = this.f15249h;
            if (iVar == null) {
                if (this.f15247f == Integer.MAX_VALUE) {
                    iVar = new h.c.n0.f.c<>(this.f15248g);
                } else {
                    iVar = new h.c.n0.f.b<>(this.f15247f);
                }
                this.f15249h = iVar;
            }
            return iVar;
        }

        void j(a<T, U> aVar, Throwable th) {
            if (this.f15251k.a(th)) {
                aVar.f15239e = true;
                if (!this.f15246e) {
                    this.p.cancel();
                    for (a<?, ?> aVar2 : this.m.getAndSet(f15243b)) {
                        aVar2.dispose();
                    }
                }
                e();
                return;
            }
            h.c.r0.a.u(th);
        }

        void k(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.m.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = a;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.m.compareAndSet(aVarArr, aVarArr2));
        }

        void l(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.n.get();
                h.c.n0.c.j<U> jVar = aVar.f15240f;
                if (j2 != 0 && (jVar == null || jVar.isEmpty())) {
                    this.f15244c.onNext(u);
                    if (j2 != Long.MAX_VALUE) {
                        this.n.decrementAndGet();
                    }
                    aVar.a(1L);
                } else {
                    if (jVar == null) {
                        jVar = g(aVar);
                    }
                    if (!jVar.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.c.n0.c.j jVar2 = aVar.f15240f;
                if (jVar2 == null) {
                    jVar2 = new h.c.n0.f.b(this.f15248g);
                    aVar.f15240f = jVar2;
                }
                if (!jVar2.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            f();
        }

        void m(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.n.get();
                h.c.n0.c.j<U> jVar = this.f15249h;
                if (j2 != 0 && (jVar == null || jVar.isEmpty())) {
                    this.f15244c.onNext(u);
                    if (j2 != Long.MAX_VALUE) {
                        this.n.decrementAndGet();
                    }
                    if (this.f15247f != Integer.MAX_VALUE && !this.f15252l) {
                        int i2 = this.v + 1;
                        this.v = i2;
                        int i3 = this.w;
                        if (i2 == i3) {
                            this.v = 0;
                            this.p.request(i3);
                        }
                    }
                } else {
                    if (jVar == null) {
                        jVar = i();
                    }
                    if (!jVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!i().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15250j) {
                return;
            }
            this.f15250j = true;
            e();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15250j) {
                h.c.r0.a.u(th);
            } else if (this.f15251k.a(th)) {
                this.f15250j = true;
                e();
            } else {
                h.c.r0.a.u(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15250j) {
                return;
            }
            try {
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15245d.apply(t), "The mapper returned a null Publisher");
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call != null) {
                            m(call);
                            return;
                        } else if (this.f15247f == Integer.MAX_VALUE || this.f15252l) {
                            return;
                        } else {
                            int i2 = this.v + 1;
                            this.v = i2;
                            int i3 = this.w;
                            if (i2 == i3) {
                                this.v = 0;
                                this.p.request(i3);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f15251k.a(th);
                        e();
                        return;
                    }
                }
                long j2 = this.q;
                this.q = 1 + j2;
                a aVar = new a(this, j2);
                if (a(aVar)) {
                    bVar.subscribe(aVar);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.p.cancel();
                onError(th2);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.p, dVar)) {
                this.p = dVar;
                this.f15244c.onSubscribe(this);
                if (this.f15252l) {
                    return;
                }
                int i2 = this.f15247f;
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
                h.c.n0.j.d.a(this.n, j2);
                e();
            }
        }
    }

    public y0(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, boolean z, int i2, int i3) {
        super(hVar);
        this.f15232b = nVar;
        this.f15233c = z;
        this.f15234d = i2;
        this.f15235e = i3;
    }

    public static <T, U> h.c.m<T> b(k.a.c<? super U> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, boolean z, int i2, int i3) {
        return new b(cVar, nVar, z, i2, i3);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        if (i3.b(this.a, cVar, this.f15232b)) {
            return;
        }
        this.a.subscribe((h.c.m) b(cVar, this.f15232b, this.f15233c, this.f15234d, this.f15235e));
    }
}
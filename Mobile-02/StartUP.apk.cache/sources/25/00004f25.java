package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCombineLatest.java */
/* loaded from: classes3.dex */
public final class t<T, R> extends h.c.s<R> {
    final h.c.x<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends h.c.x<? extends T>> f16198b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f16199c;

    /* renamed from: d  reason: collision with root package name */
    final int f16200d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f16201e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCombineLatest.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends AtomicReference<h.c.k0.b> implements h.c.z<T> {
        final b<T, R> a;

        /* renamed from: b  reason: collision with root package name */
        final int f16202b;

        a(b<T, R> bVar, int i2) {
            this.a = bVar;
            this.f16202b = i2;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.d(this.f16202b);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.e(this.f16202b, th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.f(this.f16202b, t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    /* compiled from: ObservableCombineLatest.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], ? extends R> f16203b;

        /* renamed from: c  reason: collision with root package name */
        final a<T, R>[] f16204c;

        /* renamed from: d  reason: collision with root package name */
        Object[] f16205d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.f.c<Object[]> f16206e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f16207f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16208g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f16209h;

        /* renamed from: j  reason: collision with root package name */
        final h.c.n0.j.c f16210j = new h.c.n0.j.c();

        /* renamed from: k  reason: collision with root package name */
        int f16211k;

        /* renamed from: l  reason: collision with root package name */
        int f16212l;

        b(h.c.z<? super R> zVar, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, int i3, boolean z) {
            this.a = zVar;
            this.f16203b = nVar;
            this.f16207f = z;
            this.f16205d = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.f16204c = aVarArr;
            this.f16206e = new h.c.n0.f.c<>(i3);
        }

        void a() {
            for (a<T, R> aVar : this.f16204c) {
                aVar.a();
            }
        }

        void b(h.c.n0.f.c<?> cVar) {
            synchronized (this) {
                this.f16205d = null;
            }
            cVar.clear();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<Object[]> cVar = this.f16206e;
            h.c.z<? super R> zVar = this.a;
            boolean z = this.f16207f;
            int i2 = 1;
            while (!this.f16208g) {
                if (!z && this.f16210j.get() != null) {
                    a();
                    b(cVar);
                    zVar.onError(this.f16210j.b());
                    return;
                }
                boolean z2 = this.f16209h;
                Object[] poll = cVar.poll();
                boolean z3 = poll == null;
                if (z2 && z3) {
                    b(cVar);
                    Throwable b2 = this.f16210j.b();
                    if (b2 == null) {
                        zVar.onComplete();
                        return;
                    } else {
                        zVar.onError(b2);
                        return;
                    }
                } else if (z3) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    try {
                        zVar.onNext((Object) h.c.n0.b.b.e(this.f16203b.apply(poll), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f16210j.a(th);
                        a();
                        b(cVar);
                        zVar.onError(this.f16210j.b());
                        return;
                    }
                }
            }
            b(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
            if (r2 == r0.length) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f16205d     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = r1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.f16212l     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.f16212l = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.f16209h = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.a()
            L21:
                r3.c()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.t.b.d(int):void");
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16208g) {
                return;
            }
            this.f16208g = true;
            a();
            if (getAndIncrement() == 0) {
                b(this.f16206e);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
            if (r1 == r4.length) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void e(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                h.c.n0.j.c r0 = r2.f16210j
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.f16207f
                r0 = 1
                if (r4 == 0) goto L2d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f16205d     // Catch: java.lang.Throwable -> L2a
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L2a
                if (r3 != 0) goto L1a
                r3 = r0
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.f16212l     // Catch: java.lang.Throwable -> L2a
                int r1 = r1 + r0
                r2.f16212l = r1     // Catch: java.lang.Throwable -> L2a
                int r4 = r4.length     // Catch: java.lang.Throwable -> L2a
                if (r1 != r4) goto L27
            L25:
                r2.f16209h = r0     // Catch: java.lang.Throwable -> L2a
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                r0 = r3
                goto L2d
            L2a:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                throw r3
            L2d:
                if (r0 == 0) goto L32
                r2.a()
            L32:
                r2.c()
                goto L39
            L36:
                h.c.r0.a.u(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.t.b.e(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.f16205d;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i2];
                int i3 = this.f16211k;
                if (obj == null) {
                    i3++;
                    this.f16211k = i3;
                }
                objArr[i2] = t;
                if (i3 == objArr.length) {
                    this.f16206e.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c();
                }
            }
        }

        public void g(h.c.x<? extends T>[] xVarArr) {
            a<T, R>[] aVarArr = this.f16204c;
            int length = aVarArr.length;
            this.a.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.f16209h && !this.f16208g; i2++) {
                xVarArr[i2].subscribe(aVarArr[i2]);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16208g;
        }
    }

    public t(h.c.x<? extends T>[] xVarArr, Iterable<? extends h.c.x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
        this.a = xVarArr;
        this.f16198b = iterable;
        this.f16199c = nVar;
        this.f16200d = i2;
        this.f16201e = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        int length;
        h.c.x<? extends T>[] xVarArr = this.a;
        if (xVarArr == null) {
            xVarArr = new h.c.s[8];
            length = 0;
            for (h.c.x<? extends T> xVar : this.f16198b) {
                if (length == xVarArr.length) {
                    h.c.x<? extends T>[] xVarArr2 = new h.c.x[(length >> 2) + length];
                    System.arraycopy(xVarArr, 0, xVarArr2, 0, length);
                    xVarArr = xVarArr2;
                }
                xVarArr[length] = xVar;
                length++;
            }
        } else {
            length = xVarArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            h.c.n0.a.d.q(zVar);
        } else {
            new b(zVar, this.f16199c, i2, this.f16200d, this.f16201e).g(xVarArr);
        }
    }
}
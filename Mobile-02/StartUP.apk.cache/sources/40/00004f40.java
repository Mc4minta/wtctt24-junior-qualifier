package h.c.n0.e.e;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMap.java */
/* loaded from: classes3.dex */
public final class v0<T, U> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<? extends U>> f16299b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16300c;

    /* renamed from: d  reason: collision with root package name */
    final int f16301d;

    /* renamed from: e  reason: collision with root package name */
    final int f16302e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> extends AtomicReference<h.c.k0.b> implements h.c.z<U> {
        final long a;

        /* renamed from: b  reason: collision with root package name */
        final b<T, U> f16303b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f16304c;

        /* renamed from: d  reason: collision with root package name */
        volatile h.c.n0.c.j<U> f16305d;

        /* renamed from: e  reason: collision with root package name */
        int f16306e;

        a(b<T, U> bVar, long j2) {
            this.a = j2;
            this.f16303b = bVar;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16304c = true;
            this.f16303b.d();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16303b.f16315k.a(th)) {
                b<T, U> bVar = this.f16303b;
                if (!bVar.f16310e) {
                    bVar.c();
                }
                this.f16304c = true;
                this.f16303b.d();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(U u) {
            if (this.f16306e == 0) {
                this.f16303b.h(u, this);
            } else {
                this.f16303b.d();
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar) && (bVar instanceof h.c.n0.c.e)) {
                h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                int n = eVar.n(7);
                if (n == 1) {
                    this.f16306e = n;
                    this.f16305d = eVar;
                    this.f16304c = true;
                    this.f16303b.d();
                } else if (n == 2) {
                    this.f16306e = n;
                    this.f16305d = eVar;
                }
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends AtomicInteger implements h.c.k0.b, h.c.z<T> {
        static final a<?, ?>[] a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a<?, ?>[] f16307b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        final h.c.z<? super U> f16308c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends U>> f16309d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f16310e;

        /* renamed from: f  reason: collision with root package name */
        final int f16311f;

        /* renamed from: g  reason: collision with root package name */
        final int f16312g;

        /* renamed from: h  reason: collision with root package name */
        volatile h.c.n0.c.i<U> f16313h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16314j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.n0.j.c f16315k = new h.c.n0.j.c();

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f16316l;
        final AtomicReference<a<?, ?>[]> m;
        h.c.k0.b n;
        long p;
        long q;
        int t;
        Queue<h.c.x<? extends U>> u;
        int v;

        b(h.c.z<? super U> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar, boolean z, int i2, int i3) {
            this.f16308c = zVar;
            this.f16309d = nVar;
            this.f16310e = z;
            this.f16311f = i2;
            this.f16312g = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.u = new ArrayDeque(i2);
            }
            this.m = new AtomicReference<>(a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.m.get();
                if (aVarArr == f16307b) {
                    aVar.a();
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
            if (this.f16316l) {
                return true;
            }
            Throwable th = this.f16315k.get();
            if (this.f16310e || th == null) {
                return false;
            }
            c();
            Throwable b2 = this.f16315k.b();
            if (b2 != h.c.n0.j.j.a) {
                this.f16308c.onError(b2);
            }
            return true;
        }

        boolean c() {
            a<?, ?>[] andSet;
            this.n.dispose();
            a<?, ?>[] aVarArr = this.m.get();
            a<?, ?>[] aVarArr2 = f16307b;
            if (aVarArr == aVarArr2 || (andSet = this.m.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            Throwable b2;
            if (this.f16316l) {
                return;
            }
            this.f16316l = true;
            if (!c() || (b2 = this.f16315k.b()) == null || b2 == h.c.n0.j.j.a) {
                return;
            }
            h.c.r0.a.u(b2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:128:0x0004, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void e() {
            /*
                Method dump skipped, instructions count: 299
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.v0.b.e():void");
        }

        void f(a<T, U> aVar) {
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

        void g(h.c.x<? extends U> xVar) {
            h.c.x<? extends U> poll;
            while (xVar instanceof Callable) {
                if (!i((Callable) xVar) || this.f16311f == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    poll = this.u.poll();
                    if (poll == null) {
                        this.v--;
                        z = true;
                    }
                }
                if (z) {
                    d();
                    return;
                }
                xVar = poll;
            }
            long j2 = this.p;
            this.p = 1 + j2;
            a<T, U> aVar = new a<>(this, j2);
            if (a(aVar)) {
                xVar.subscribe(aVar);
            }
        }

        void h(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f16308c.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.c.n0.c.j jVar = aVar.f16305d;
                if (jVar == null) {
                    jVar = new h.c.n0.f.c(this.f16312g);
                    aVar.f16305d = jVar;
                }
                jVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            e();
        }

        boolean i(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f16308c.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    h.c.n0.c.i<U> iVar = this.f16313h;
                    if (iVar == null) {
                        if (this.f16311f == Integer.MAX_VALUE) {
                            iVar = new h.c.n0.f.c<>(this.f16312g);
                        } else {
                            iVar = new h.c.n0.f.b<>(this.f16311f);
                        }
                        this.f16313h = iVar;
                    }
                    if (!iVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                e();
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16315k.a(th);
                d();
                return true;
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16316l;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16314j) {
                return;
            }
            this.f16314j = true;
            d();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16314j) {
                h.c.r0.a.u(th);
            } else if (this.f16315k.a(th)) {
                this.f16314j = true;
                d();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16314j) {
                return;
            }
            try {
                h.c.x<? extends U> xVar = (h.c.x) h.c.n0.b.b.e(this.f16309d.apply(t), "The mapper returned a null ObservableSource");
                if (this.f16311f != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i2 = this.v;
                        if (i2 == this.f16311f) {
                            this.u.offer(xVar);
                            return;
                        }
                        this.v = i2 + 1;
                    }
                }
                g(xVar);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.n.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.n, bVar)) {
                this.n = bVar;
                this.f16308c.onSubscribe(this);
            }
        }
    }

    public v0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar, boolean z, int i2, int i3) {
        super(xVar);
        this.f16299b = nVar;
        this.f16300c = z;
        this.f16301d = i2;
        this.f16302e = i3;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super U> zVar) {
        if (w2.b(this.a, zVar, this.f16299b)) {
            return;
        }
        this.a.subscribe(new b(zVar, this.f16299b, this.f16300c, this.f16301d, this.f16302e));
    }
}
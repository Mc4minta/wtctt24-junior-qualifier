package h.c.n0.e.b;

import h.c.n0.e.b.a2;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCombineLatest.java */
/* loaded from: classes3.dex */
public final class t<T, R> extends h.c.h<R> {
    final k.a.b<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends k.a.b<? extends T>> f15005b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f15006c;

    /* renamed from: d  reason: collision with root package name */
    final int f15007d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15008e;

    /* compiled from: FlowableCombineLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends h.c.n0.i.a<R> {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], ? extends R> f15009b;

        /* renamed from: c  reason: collision with root package name */
        final b<T>[] f15010c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.f.c<Object> f15011d;

        /* renamed from: e  reason: collision with root package name */
        final Object[] f15012e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15013f;

        /* renamed from: g  reason: collision with root package name */
        boolean f15014g;

        /* renamed from: h  reason: collision with root package name */
        int f15015h;

        /* renamed from: j  reason: collision with root package name */
        int f15016j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15017k;

        /* renamed from: l  reason: collision with root package name */
        final AtomicLong f15018l;
        volatile boolean m;
        final AtomicReference<Throwable> n;

        a(k.a.c<? super R> cVar, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, int i3, boolean z) {
            this.a = cVar;
            this.f15009b = nVar;
            b<T>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i4, i3);
            }
            this.f15010c = bVarArr;
            this.f15012e = new Object[i2];
            this.f15011d = new h.c.n0.f.c<>(i3);
            this.f15018l = new AtomicLong();
            this.n = new AtomicReference<>();
            this.f15013f = z;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f15014g) {
                f();
            } else {
                e();
            }
        }

        void c() {
            for (b<T> bVar : this.f15010c) {
                bVar.a();
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f15017k = true;
            c();
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15011d.clear();
        }

        boolean d(boolean z, boolean z2, k.a.c<?> cVar, h.c.n0.f.c<?> cVar2) {
            if (this.f15017k) {
                c();
                cVar2.clear();
                return true;
            } else if (z) {
                if (this.f15013f) {
                    if (z2) {
                        c();
                        Throwable b2 = h.c.n0.j.j.b(this.n);
                        if (b2 != null && b2 != h.c.n0.j.j.a) {
                            cVar.onError(b2);
                        } else {
                            cVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable b3 = h.c.n0.j.j.b(this.n);
                if (b3 != null && b3 != h.c.n0.j.j.a) {
                    c();
                    cVar2.clear();
                    cVar.onError(b3);
                    return true;
                } else if (z2) {
                    c();
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void e() {
            int i2;
            k.a.c<? super R> cVar = this.a;
            h.c.n0.f.c<?> cVar2 = this.f15011d;
            int i3 = 1;
            do {
                long j2 = this.f15018l.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.m;
                    Object poll = cVar2.poll();
                    boolean z2 = poll == null;
                    if (d(z, z2, cVar, cVar2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        cVar.onNext((Object) h.c.n0.b.b.e(this.f15009b.apply((Object[]) cVar2.poll()), "The combiner returned a null value"));
                        ((b) poll).b();
                        j3++;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        c();
                        h.c.n0.j.j.a(this.n, th);
                        cVar.onError(h.c.n0.j.j.b(this.n));
                        return;
                    }
                }
                if (i2 == 0 && d(this.m, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
                if (j3 != 0 && j2 != Long.MAX_VALUE) {
                    this.f15018l.addAndGet(-j3);
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        void f() {
            k.a.c<? super R> cVar = this.a;
            h.c.n0.f.c<Object> cVar2 = this.f15011d;
            int i2 = 1;
            while (!this.f15017k) {
                Throwable th = this.n.get();
                if (th != null) {
                    cVar2.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = this.m;
                boolean isEmpty = cVar2.isEmpty();
                if (!isEmpty) {
                    cVar.onNext(null);
                }
                if (z && isEmpty) {
                    cVar.onComplete();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            cVar2.clear();
        }

        void g(int i2) {
            synchronized (this) {
                Object[] objArr = this.f15012e;
                if (objArr[i2] != null) {
                    int i3 = this.f15016j + 1;
                    if (i3 == objArr.length) {
                        this.m = true;
                    } else {
                        this.f15016j = i3;
                        return;
                    }
                } else {
                    this.m = true;
                }
                b();
            }
        }

        void i(int i2, Throwable th) {
            if (h.c.n0.j.j.a(this.n, th)) {
                if (!this.f15013f) {
                    c();
                    this.m = true;
                    b();
                    return;
                }
                g(i2);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15011d.isEmpty();
        }

        void j(int i2, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.f15012e;
                int i3 = this.f15015h;
                if (objArr[i2] == null) {
                    i3++;
                    this.f15015h = i3;
                }
                objArr[i2] = t;
                if (objArr.length == i3) {
                    this.f15011d.l(this.f15010c[i2], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.f15010c[i2].b();
            } else {
                b();
            }
        }

        void k(k.a.b<? extends T>[] bVarArr, int i2) {
            b<T>[] bVarArr2 = this.f15010c;
            for (int i3 = 0; i3 < i2 && !this.m && !this.f15017k; i3++) {
                bVarArr[i3].subscribe(bVarArr2[i3]);
            }
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 4) != 0) {
                return 0;
            }
            int i3 = i2 & 2;
            this.f15014g = i3 != 0;
            return i3;
        }

        @Override // h.c.n0.c.j
        public R poll() throws Exception {
            Object poll = this.f15011d.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) h.c.n0.b.b.e(this.f15009b.apply((Object[]) this.f15011d.poll()), "The combiner returned a null value");
            ((b) poll).b();
            return r;
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15018l, j2);
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableCombineLatest.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicReference<k.a.d> implements h.c.m<T> {
        final a<T, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15019b;

        /* renamed from: c  reason: collision with root package name */
        final int f15020c;

        /* renamed from: d  reason: collision with root package name */
        final int f15021d;

        /* renamed from: e  reason: collision with root package name */
        int f15022e;

        b(a<T, ?> aVar, int i2, int i3) {
            this.a = aVar;
            this.f15019b = i2;
            this.f15020c = i3;
            this.f15021d = i3 - (i3 >> 2);
        }

        public void a() {
            h.c.n0.i.g.h(this);
        }

        public void b() {
            int i2 = this.f15022e + 1;
            if (i2 == this.f15021d) {
                this.f15022e = 0;
                get().request(i2);
                return;
            }
            this.f15022e = i2;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.g(this.f15019b);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.i(this.f15019b, th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.j(this.f15019b, t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, this.f15020c);
        }
    }

    /* compiled from: FlowableCombineLatest.java */
    /* loaded from: classes3.dex */
    final class c implements h.c.m0.n<T, R> {
        c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // h.c.m0.n
        public R apply(T t) throws Exception {
            return t.this.f15006c.apply(new Object[]{t});
        }
    }

    public t(k.a.b<? extends T>[] bVarArr, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
        this.a = bVarArr;
        this.f15005b = null;
        this.f15006c = nVar;
        this.f15007d = i2;
        this.f15008e = z;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super R> cVar) {
        int length;
        k.a.b<? extends T>[] bVarArr = this.a;
        if (bVarArr == null) {
            bVarArr = new k.a.b[8];
            try {
                Iterator it = (Iterator) h.c.n0.b.b.e(this.f15005b.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            k.a.b<? extends T> bVar = (k.a.b) h.c.n0.b.b.e(it.next(), "The publisher returned by the iterator is null");
                            if (length == bVarArr.length) {
                                k.a.b<? extends T>[] bVarArr2 = new k.a.b[(length >> 2) + length];
                                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                bVarArr = bVarArr2;
                            }
                            bVarArr[length] = bVar;
                            length++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            h.c.n0.i.d.q(th, cVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        h.c.n0.i.d.q(th2, cVar);
                        return;
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.n0.i.d.q(th3, cVar);
                return;
            }
        } else {
            length = bVarArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            h.c.n0.i.d.h(cVar);
        } else if (i2 == 1) {
            bVarArr[0].subscribe(new a2.b(cVar, new c()));
        } else {
            a aVar = new a(cVar, this.f15006c, i2, this.f15007d, this.f15008e);
            cVar.onSubscribe(aVar);
            aVar.k(bVarArr, i2);
        }
    }

    public t(Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
        this.a = null;
        this.f15005b = iterable;
        this.f15006c = nVar;
        this.f15007d = i2;
        this.f15008e = z;
    }
}
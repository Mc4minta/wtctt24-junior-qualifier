package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableCache.java */
/* loaded from: classes3.dex */
public final class q<T> extends h.c.n0.e.b.a<T, T> implements h.c.m<T> {

    /* renamed from: b  reason: collision with root package name */
    static final a[] f14835b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    static final a[] f14836c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f14837d;

    /* renamed from: e  reason: collision with root package name */
    final int f14838e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a<T>[]> f14839f;

    /* renamed from: g  reason: collision with root package name */
    volatile long f14840g;

    /* renamed from: h  reason: collision with root package name */
    final b<T> f14841h;

    /* renamed from: j  reason: collision with root package name */
    b<T> f14842j;

    /* renamed from: k  reason: collision with root package name */
    int f14843k;

    /* renamed from: l  reason: collision with root package name */
    Throwable f14844l;
    volatile boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableCache.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicInteger implements k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final q<T> f14845b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f14846c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        b<T> f14847d;

        /* renamed from: e  reason: collision with root package name */
        int f14848e;

        /* renamed from: f  reason: collision with root package name */
        long f14849f;

        a(k.a.c<? super T> cVar, q<T> qVar) {
            this.a = cVar;
            this.f14845b = qVar;
            this.f14847d = qVar.f14841h;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14846c.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f14845b.c(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.b(this.f14846c, j2);
                this.f14845b.d(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableCache.java */
    /* loaded from: classes3.dex */
    public static final class b<T> {
        final T[] a;

        /* renamed from: b  reason: collision with root package name */
        volatile b<T> f14850b;

        b(int i2) {
            this.a = (T[]) new Object[i2];
        }
    }

    public q(h.c.h<T> hVar, int i2) {
        super(hVar);
        this.f14838e = i2;
        this.f14837d = new AtomicBoolean();
        b<T> bVar = new b<>(i2);
        this.f14841h = bVar;
        this.f14842j = bVar;
        this.f14839f = new AtomicReference<>(f14835b);
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f14839f.get();
            if (aVarArr == f14836c) {
                return;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f14839f.compareAndSet(aVarArr, aVarArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void c(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f14839f.get();
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
                aVarArr2 = f14835b;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f14839f.compareAndSet(aVarArr, aVarArr2));
    }

    void d(a<T> aVar) {
        if (aVar.getAndIncrement() != 0) {
            return;
        }
        long j2 = aVar.f14849f;
        int i2 = aVar.f14848e;
        b<T> bVar = aVar.f14847d;
        AtomicLong atomicLong = aVar.f14846c;
        k.a.c<? super T> cVar = aVar.a;
        int i3 = this.f14838e;
        int i4 = 1;
        while (true) {
            boolean z = this.m;
            boolean z2 = this.f14840g == j2;
            if (z && z2) {
                aVar.f14847d = null;
                Throwable th = this.f14844l;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            if (!z2) {
                long j3 = atomicLong.get();
                if (j3 == Long.MIN_VALUE) {
                    aVar.f14847d = null;
                    return;
                } else if (j3 != j2) {
                    if (i2 == i3) {
                        bVar = bVar.f14850b;
                        i2 = 0;
                    }
                    cVar.onNext((Object) bVar.a[i2]);
                    i2++;
                    j2++;
                }
            }
            aVar.f14849f = j2;
            aVar.f14848e = i2;
            aVar.f14847d = bVar;
            i4 = aVar.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
    }

    @Override // k.a.c
    public void onComplete() {
        this.m = true;
        for (a<T> aVar : this.f14839f.getAndSet(f14836c)) {
            d(aVar);
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.m) {
            h.c.r0.a.u(th);
            return;
        }
        this.f14844l = th;
        this.m = true;
        for (a<T> aVar : this.f14839f.getAndSet(f14836c)) {
            d(aVar);
        }
    }

    @Override // k.a.c
    public void onNext(T t) {
        int i2 = this.f14843k;
        if (i2 == this.f14838e) {
            b<T> bVar = new b<>(i2);
            bVar.a[0] = t;
            this.f14843k = 1;
            this.f14842j.f14850b = bVar;
            this.f14842j = bVar;
        } else {
            this.f14842j.a[i2] = t;
            this.f14843k = i2 + 1;
        }
        this.f14840g++;
        for (a<T> aVar : this.f14839f.get()) {
            d(aVar);
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        dVar.request(Long.MAX_VALUE);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a<T> aVar = new a<>(cVar, this);
        cVar.onSubscribe(aVar);
        b(aVar);
        if (!this.f14837d.get() && this.f14837d.compareAndSet(false, true)) {
            this.a.subscribe((h.c.m) this);
        } else {
            d(aVar);
        }
    }
}
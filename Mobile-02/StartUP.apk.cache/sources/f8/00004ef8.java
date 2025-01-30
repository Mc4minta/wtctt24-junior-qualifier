package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCache.java */
/* loaded from: classes3.dex */
public final class q<T> extends h.c.n0.e.e.a<T, T> implements h.c.z<T> {

    /* renamed from: b  reason: collision with root package name */
    static final a[] f16095b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    static final a[] f16096c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f16097d;

    /* renamed from: e  reason: collision with root package name */
    final int f16098e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a<T>[]> f16099f;

    /* renamed from: g  reason: collision with root package name */
    volatile long f16100g;

    /* renamed from: h  reason: collision with root package name */
    final b<T> f16101h;

    /* renamed from: j  reason: collision with root package name */
    b<T> f16102j;

    /* renamed from: k  reason: collision with root package name */
    int f16103k;

    /* renamed from: l  reason: collision with root package name */
    Throwable f16104l;
    volatile boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCache.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicInteger implements h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final q<T> f16105b;

        /* renamed from: c  reason: collision with root package name */
        b<T> f16106c;

        /* renamed from: d  reason: collision with root package name */
        int f16107d;

        /* renamed from: e  reason: collision with root package name */
        long f16108e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16109f;

        a(h.c.z<? super T> zVar, q<T> qVar) {
            this.a = zVar;
            this.f16105b = qVar;
            this.f16106c = qVar.f16101h;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16109f) {
                return;
            }
            this.f16109f = true;
            this.f16105b.c(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16109f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCache.java */
    /* loaded from: classes3.dex */
    public static final class b<T> {
        final T[] a;

        /* renamed from: b  reason: collision with root package name */
        volatile b<T> f16110b;

        b(int i2) {
            this.a = (T[]) new Object[i2];
        }
    }

    public q(h.c.s<T> sVar, int i2) {
        super(sVar);
        this.f16098e = i2;
        this.f16097d = new AtomicBoolean();
        b<T> bVar = new b<>(i2);
        this.f16101h = bVar;
        this.f16102j = bVar;
        this.f16099f = new AtomicReference<>(f16095b);
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16099f.get();
            if (aVarArr == f16096c) {
                return;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16099f.compareAndSet(aVarArr, aVarArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void c(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16099f.get();
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
                aVarArr2 = f16095b;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f16099f.compareAndSet(aVarArr, aVarArr2));
    }

    void d(a<T> aVar) {
        if (aVar.getAndIncrement() != 0) {
            return;
        }
        long j2 = aVar.f16108e;
        int i2 = aVar.f16107d;
        b<T> bVar = aVar.f16106c;
        h.c.z<? super T> zVar = aVar.a;
        int i3 = this.f16098e;
        int i4 = 1;
        while (!aVar.f16109f) {
            boolean z = this.m;
            boolean z2 = this.f16100g == j2;
            if (z && z2) {
                aVar.f16106c = null;
                Throwable th = this.f16104l;
                if (th != null) {
                    zVar.onError(th);
                    return;
                } else {
                    zVar.onComplete();
                    return;
                }
            } else if (!z2) {
                if (i2 == i3) {
                    bVar = bVar.f16110b;
                    i2 = 0;
                }
                zVar.onNext((Object) bVar.a[i2]);
                i2++;
                j2++;
            } else {
                aVar.f16108e = j2;
                aVar.f16107d = i2;
                aVar.f16106c = bVar;
                i4 = aVar.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
        }
        aVar.f16106c = null;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        this.m = true;
        for (a<T> aVar : this.f16099f.getAndSet(f16096c)) {
            d(aVar);
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        this.f16104l = th;
        this.m = true;
        for (a<T> aVar : this.f16099f.getAndSet(f16096c)) {
            d(aVar);
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        int i2 = this.f16103k;
        if (i2 == this.f16098e) {
            b<T> bVar = new b<>(i2);
            bVar.a[0] = t;
            this.f16103k = 1;
            this.f16102j.f16110b = bVar;
            this.f16102j = bVar;
        } else {
            this.f16102j.a[i2] = t;
            this.f16103k = i2 + 1;
        }
        this.f16100g++;
        for (a<T> aVar : this.f16099f.get()) {
            d(aVar);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a<T> aVar = new a<>(zVar, this);
        zVar.onSubscribe(aVar);
        b(aVar);
        if (!this.f16097d.get() && this.f16097d.compareAndSet(false, true)) {
            this.a.subscribe(this);
        } else {
            d(aVar);
        }
    }
}
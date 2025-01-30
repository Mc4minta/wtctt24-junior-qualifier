package h.c.n0.e.e;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableZip.java */
/* loaded from: classes3.dex */
public final class k4<T, R> extends h.c.s<R> {
    final h.c.x<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends h.c.x<? extends T>> f15882b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f15883c;

    /* renamed from: d  reason: collision with root package name */
    final int f15884d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15885e;

    /* compiled from: ObservableZip.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], ? extends R> f15886b;

        /* renamed from: c  reason: collision with root package name */
        final b<T, R>[] f15887c;

        /* renamed from: d  reason: collision with root package name */
        final T[] f15888d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f15889e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f15890f;

        a(h.c.z<? super R> zVar, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
            this.a = zVar;
            this.f15886b = nVar;
            this.f15887c = new b[i2];
            this.f15888d = (T[]) new Object[i2];
            this.f15889e = z;
        }

        void a() {
            d();
            b();
        }

        void b() {
            for (b<T, R> bVar : this.f15887c) {
                bVar.a();
            }
        }

        boolean c(boolean z, boolean z2, h.c.z<? super R> zVar, boolean z3, b<?, ?> bVar) {
            if (this.f15890f) {
                a();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = bVar.f15893d;
                        this.f15890f = true;
                        a();
                        if (th != null) {
                            zVar.onError(th);
                        } else {
                            zVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = bVar.f15893d;
                if (th2 != null) {
                    this.f15890f = true;
                    a();
                    zVar.onError(th2);
                    return true;
                } else if (z2) {
                    this.f15890f = true;
                    a();
                    zVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void d() {
            for (b<T, R> bVar : this.f15887c) {
                bVar.f15891b.clear();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15890f) {
                return;
            }
            this.f15890f = true;
            b();
            if (getAndIncrement() == 0) {
                d();
            }
        }

        public void e() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.f15887c;
            h.c.z<? super R> zVar = this.a;
            T[] tArr = this.f15888d;
            boolean z = this.f15889e;
            int i2 = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i4] == null) {
                        boolean z2 = bVar.f15892c;
                        T poll = bVar.f15891b.poll();
                        boolean z3 = poll == null;
                        if (c(z2, z3, zVar, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i3++;
                        } else {
                            tArr[i4] = poll;
                        }
                    } else if (bVar.f15892c && !z && (th = bVar.f15893d) != null) {
                        this.f15890f = true;
                        a();
                        zVar.onError(th);
                        return;
                    }
                    i4++;
                }
                if (i3 != 0) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    try {
                        zVar.onNext((Object) h.c.n0.b.b.e(this.f15886b.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        a();
                        zVar.onError(th2);
                        return;
                    }
                }
            }
        }

        public void f(h.c.x<? extends T>[] xVarArr, int i2) {
            b<T, R>[] bVarArr = this.f15887c;
            int length = bVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                bVarArr[i3] = new b<>(this, i2);
            }
            lazySet(0);
            this.a.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.f15890f; i4++) {
                xVarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15890f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableZip.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements h.c.z<T> {
        final a<T, R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<T> f15891b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f15892c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f15893d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15894e = new AtomicReference<>();

        b(a<T, R> aVar, int i2) {
            this.a = aVar;
            this.f15891b = new h.c.n0.f.c<>(i2);
        }

        public void a() {
            h.c.n0.a.c.h(this.f15894e);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15892c = true;
            this.a.e();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15893d = th;
            this.f15892c = true;
            this.a.e();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15891b.offer(t);
            this.a.e();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15894e, bVar);
        }
    }

    public k4(h.c.x<? extends T>[] xVarArr, Iterable<? extends h.c.x<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
        this.a = xVarArr;
        this.f15882b = iterable;
        this.f15883c = nVar;
        this.f15884d = i2;
        this.f15885e = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        int length;
        h.c.x<? extends T>[] xVarArr = this.a;
        if (xVarArr == null) {
            xVarArr = new h.c.s[8];
            length = 0;
            for (h.c.x<? extends T> xVar : this.f15882b) {
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
        if (length == 0) {
            h.c.n0.a.d.q(zVar);
        } else {
            new a(zVar, this.f15883c, length, this.f15885e).f(xVarArr, this.f15884d);
        }
    }
}
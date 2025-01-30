package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableAmb.java */
/* loaded from: classes3.dex */
public final class h<T> extends h.c.s<T> {
    final h.c.x<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends h.c.x<? extends T>> f15726b;

    /* compiled from: ObservableAmb.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final b<T>[] f15727b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f15728c = new AtomicInteger();

        a(h.c.z<? super T> zVar, int i2) {
            this.a = zVar;
            this.f15727b = new b[i2];
        }

        public void a(h.c.x<? extends T>[] xVarArr) {
            b<T>[] bVarArr = this.f15727b;
            int length = bVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                bVarArr[i2] = new b<>(this, i3, this.a);
                i2 = i3;
            }
            this.f15728c.lazySet(0);
            this.a.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f15728c.get() == 0; i4++) {
                xVarArr[i4].subscribe(bVarArr[i4]);
            }
        }

        public boolean b(int i2) {
            int i3 = this.f15728c.get();
            int i4 = 0;
            if (i3 != 0) {
                return i3 == i2;
            } else if (this.f15728c.compareAndSet(0, i2)) {
                b<T>[] bVarArr = this.f15727b;
                int length = bVarArr.length;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    if (i5 != i2) {
                        bVarArr[i4].a();
                    }
                    i4 = i5;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15728c.get() != -1) {
                this.f15728c.lazySet(-1);
                for (b<T> bVar : this.f15727b) {
                    bVar.a();
                }
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15728c.get() == -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableAmb.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T> {
        final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15729b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.z<? super T> f15730c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15731d;

        b(a<T> aVar, int i2, h.c.z<? super T> zVar) {
            this.a = aVar;
            this.f15729b = i2;
            this.f15730c = zVar;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15731d) {
                this.f15730c.onComplete();
            } else if (this.a.b(this.f15729b)) {
                this.f15731d = true;
                this.f15730c.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15731d) {
                this.f15730c.onError(th);
            } else if (this.a.b(this.f15729b)) {
                this.f15731d = true;
                this.f15730c.onError(th);
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15731d) {
                this.f15730c.onNext(t);
            } else if (this.a.b(this.f15729b)) {
                this.f15731d = true;
                this.f15730c.onNext(t);
            } else {
                get().dispose();
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    public h(h.c.x<? extends T>[] xVarArr, Iterable<? extends h.c.x<? extends T>> iterable) {
        this.a = xVarArr;
        this.f15726b = iterable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        int length;
        h.c.x<? extends T>[] xVarArr = this.a;
        if (xVarArr == null) {
            xVarArr = new h.c.s[8];
            try {
                length = 0;
                for (h.c.x<? extends T> xVar : this.f15726b) {
                    if (xVar == null) {
                        h.c.n0.a.d.y(new NullPointerException("One of the sources is null"), zVar);
                        return;
                    }
                    if (length == xVarArr.length) {
                        h.c.x<? extends T>[] xVarArr2 = new h.c.x[(length >> 2) + length];
                        System.arraycopy(xVarArr, 0, xVarArr2, 0, length);
                        xVarArr = xVarArr2;
                    }
                    int i2 = length + 1;
                    xVarArr[length] = xVar;
                    length = i2;
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.y(th, zVar);
                return;
            }
        } else {
            length = xVarArr.length;
        }
        if (length == 0) {
            h.c.n0.a.d.q(zVar);
        } else if (length == 1) {
            xVarArr[0].subscribe(zVar);
        } else {
            new a(zVar, length).a(xVarArr);
        }
    }
}
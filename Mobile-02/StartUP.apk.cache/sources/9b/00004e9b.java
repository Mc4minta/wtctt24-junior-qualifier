package h.c.n0.e.e;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ObservableWithLatestFromMany.java */
/* loaded from: classes3.dex */
public final class j4<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<?>[] f15855b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends h.c.x<?>> f15856c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super Object[], R> f15857d;

    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.m0.n<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // h.c.m0.n
        public R apply(T t) throws Exception {
            return (R) h.c.n0.b.b.e(j4.this.f15857d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], R> f15858b;

        /* renamed from: c  reason: collision with root package name */
        final c[] f15859c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceArray<Object> f15860d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15861e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.c f15862f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15863g;

        b(h.c.z<? super R> zVar, h.c.m0.n<? super Object[], R> nVar, int i2) {
            this.a = zVar;
            this.f15858b = nVar;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.f15859c = cVarArr;
            this.f15860d = new AtomicReferenceArray<>(i2);
            this.f15861e = new AtomicReference<>();
            this.f15862f = new h.c.n0.j.c();
        }

        void a(int i2) {
            c[] cVarArr = this.f15859c;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].a();
                }
            }
        }

        void b(int i2, boolean z) {
            if (z) {
                return;
            }
            this.f15863g = true;
            a(i2);
            h.c.n0.j.k.a(this.a, this, this.f15862f);
        }

        void c(int i2, Throwable th) {
            this.f15863g = true;
            h.c.n0.a.c.h(this.f15861e);
            a(i2);
            h.c.n0.j.k.c(this.a, th, this, this.f15862f);
        }

        void d(int i2, Object obj) {
            this.f15860d.set(i2, obj);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f15861e);
            for (c cVar : this.f15859c) {
                cVar.a();
            }
        }

        void e(h.c.x<?>[] xVarArr, int i2) {
            c[] cVarArr = this.f15859c;
            AtomicReference<h.c.k0.b> atomicReference = this.f15861e;
            for (int i3 = 0; i3 < i2 && !h.c.n0.a.c.n(atomicReference.get()) && !this.f15863g; i3++) {
                xVarArr[i3].subscribe(cVarArr[i3]);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f15861e.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15863g) {
                return;
            }
            this.f15863g = true;
            a(-1);
            h.c.n0.j.k.a(this.a, this, this.f15862f);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15863g) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15863g = true;
            a(-1);
            h.c.n0.j.k.c(this.a, th, this, this.f15862f);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15863g) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f15860d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i2 = 0;
            objArr[0] = t;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                h.c.n0.j.k.e(this.a, h.c.n0.b.b.e(this.f15858b.apply(objArr), "combiner returned a null value"), this, this.f15862f);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15861e, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<h.c.k0.b> implements h.c.z<Object> {
        final b<?, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15864b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15865c;

        c(b<?, ?> bVar, int i2) {
            this.a = bVar;
            this.f15864b = i2;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.b(this.f15864b, this.f15865c);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.c(this.f15864b, th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            if (!this.f15865c) {
                this.f15865c = true;
            }
            this.a.d(this.f15864b, obj);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    public j4(h.c.x<T> xVar, h.c.x<?>[] xVarArr, h.c.m0.n<? super Object[], R> nVar) {
        super(xVar);
        this.f15855b = xVarArr;
        this.f15856c = null;
        this.f15857d = nVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        int length;
        h.c.x<?>[] xVarArr = this.f15855b;
        if (xVarArr == null) {
            xVarArr = new h.c.x[8];
            try {
                length = 0;
                for (h.c.x<?> xVar : this.f15856c) {
                    if (length == xVarArr.length) {
                        xVarArr = (h.c.x[]) Arrays.copyOf(xVarArr, (length >> 1) + length);
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
            new v1(this.a, new a()).subscribeActual(zVar);
            return;
        }
        b bVar = new b(zVar, this.f15857d, length);
        zVar.onSubscribe(bVar);
        bVar.e(xVarArr, length);
        this.a.subscribe(bVar);
    }

    public j4(h.c.x<T> xVar, Iterable<? extends h.c.x<?>> iterable, h.c.m0.n<? super Object[], R> nVar) {
        super(xVar);
        this.f15855b = null;
        this.f15856c = iterable;
        this.f15857d = nVar;
    }
}
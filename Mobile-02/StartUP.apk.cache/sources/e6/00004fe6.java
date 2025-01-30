package h.c.n0.e.g;

import h.c.n0.e.g.k0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleZipArray.java */
/* loaded from: classes3.dex */
public final class y0<T, R> extends h.c.b0<R> {
    final h.c.h0<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f16596b;

    /* compiled from: SingleZipArray.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.m0.n<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // h.c.m0.n
        public R apply(T t) throws Exception {
            return (R) h.c.n0.b.b.e(y0.this.f16596b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* compiled from: SingleZipArray.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements h.c.k0.b {
        final h.c.e0<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Object[], ? extends R> f16597b;

        /* renamed from: c  reason: collision with root package name */
        final c<T>[] f16598c;

        /* renamed from: d  reason: collision with root package name */
        final Object[] f16599d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(h.c.e0<? super R> e0Var, int i2, h.c.m0.n<? super Object[], ? extends R> nVar) {
            super(i2);
            this.a = e0Var;
            this.f16597b = nVar;
            c<T>[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c<>(this, i3);
            }
            this.f16598c = cVarArr;
            this.f16599d = new Object[i2];
        }

        void a(int i2) {
            c<T>[] cVarArr = this.f16598c;
            int length = cVarArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3].a();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                }
                cVarArr[i2].a();
            }
        }

        void b(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(T t, int i2) {
            this.f16599d[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.a.onSuccess(h.c.n0.b.b.e(this.f16597b.apply(this.f16599d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.a.onError(th);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.f16598c) {
                    cVar.a();
                }
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleZipArray.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T> {
        final b<T, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final int f16600b;

        c(b<T, ?> bVar, int i2) {
            this.a = bVar;
            this.f16600b = i2;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.b(th, this.f16600b);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.c(t, this.f16600b);
        }
    }

    public y0(h.c.h0<? extends T>[] h0VarArr, h.c.m0.n<? super Object[], ? extends R> nVar) {
        this.a = h0VarArr;
        this.f16596b = nVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        h.c.h0<? extends T>[] h0VarArr = this.a;
        int length = h0VarArr.length;
        if (length == 1) {
            h0VarArr[0].subscribe(new k0.a(e0Var, new a()));
            return;
        }
        b bVar = new b(e0Var, length, this.f16596b);
        e0Var.onSubscribe(bVar);
        for (int i2 = 0; i2 < length && !bVar.isDisposed(); i2++) {
            h.c.h0<? extends T> h0Var = h0VarArr[i2];
            if (h0Var == null) {
                bVar.b(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            h0Var.subscribe(bVar.f16598c[i2]);
        }
    }
}
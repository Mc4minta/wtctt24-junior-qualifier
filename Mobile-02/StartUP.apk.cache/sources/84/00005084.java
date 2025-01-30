package h.c.v0;

import h.c.z;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishSubject.java */
/* loaded from: classes3.dex */
public final class b<T> extends f<T> {
    static final a[] a = new a[0];

    /* renamed from: b  reason: collision with root package name */
    static final a[] f16846b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a<T>[]> f16847c = new AtomicReference<>(f16846b);

    /* renamed from: d  reason: collision with root package name */
    Throwable f16848d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicBoolean implements h.c.k0.b {
        final z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f16849b;

        a(z<? super T> zVar, b<T> bVar) {
            this.a = zVar;
            this.f16849b = bVar;
        }

        public void a() {
            if (get()) {
                return;
            }
            this.a.onComplete();
        }

        public void b(Throwable th) {
            if (get()) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }

        public void c(T t) {
            if (get()) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f16849b.f(this);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get();
        }
    }

    b() {
    }

    public static <T> b<T> d() {
        return new b<>();
    }

    boolean c(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16847c.get();
            if (aVarArr == a) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16847c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    public boolean e() {
        return this.f16847c.get().length != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void f(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16847c.get();
            if (aVarArr == a || aVarArr == f16846b) {
                return;
            }
            int length = aVarArr.length;
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
                aVarArr2 = f16846b;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f16847c.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        a<T>[] aVarArr = this.f16847c.get();
        a<T>[] aVarArr2 = a;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f16847c.getAndSet(aVarArr2)) {
            aVar.a();
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.f16847c.get();
        a<T>[] aVarArr2 = a;
        if (aVarArr == aVarArr2) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16848d = th;
        for (a<T> aVar : this.f16847c.getAndSet(aVarArr2)) {
            aVar.b(th);
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        h.c.n0.b.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.f16847c.get()) {
            aVar.c(t);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (this.f16847c.get() == a) {
            bVar.dispose();
        }
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        a<T> aVar = new a<>(zVar, this);
        zVar.onSubscribe(aVar);
        if (c(aVar)) {
            if (aVar.isDisposed()) {
                f(aVar);
                return;
            }
            return;
        }
        Throwable th = this.f16848d;
        if (th != null) {
            zVar.onError(th);
        } else {
            zVar.onComplete();
        }
    }
}
package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCache.java */
/* loaded from: classes3.dex */
public final class b<T> extends h.c.b0<T> implements h.c.e0<T> {
    static final a[] a = new a[0];

    /* renamed from: b  reason: collision with root package name */
    static final a[] f16477b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    final h.c.h0<? extends T> f16478c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicInteger f16479d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<a<T>[]> f16480e = new AtomicReference<>(a);

    /* renamed from: f  reason: collision with root package name */
    T f16481f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f16482g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleCache.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicBoolean implements h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f16483b;

        a(h.c.e0<? super T> e0Var, b<T> bVar) {
            this.a = e0Var;
            this.f16483b = bVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f16483b.c(this);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get();
        }
    }

    public b(h.c.h0<? extends T> h0Var) {
        this.f16478c = h0Var;
    }

    boolean b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16480e.get();
            if (aVarArr == f16477b) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16480e.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void c(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16480e.get();
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
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f16480e.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        a<T>[] andSet;
        this.f16482g = th;
        for (a<T> aVar : this.f16480e.getAndSet(f16477b)) {
            if (!aVar.isDisposed()) {
                aVar.a.onError(th);
            }
        }
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        a<T>[] andSet;
        this.f16481f = t;
        for (a<T> aVar : this.f16480e.getAndSet(f16477b)) {
            if (!aVar.isDisposed()) {
                aVar.a.onSuccess(t);
            }
        }
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        a<T> aVar = new a<>(e0Var, this);
        e0Var.onSubscribe(aVar);
        if (b(aVar)) {
            if (aVar.isDisposed()) {
                c(aVar);
            }
            if (this.f16479d.getAndIncrement() == 0) {
                this.f16478c.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f16482g;
        if (th != null) {
            e0Var.onError(th);
        } else {
            e0Var.onSuccess((T) this.f16481f);
        }
    }
}
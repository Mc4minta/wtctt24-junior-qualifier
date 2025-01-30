package h.c.v0;

import h.c.b0;
import h.c.e0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubject.java */
/* loaded from: classes3.dex */
public final class e<T> extends b0<T> implements e0<T> {
    static final a[] a = new a[0];

    /* renamed from: b  reason: collision with root package name */
    static final a[] f16865b = new a[0];

    /* renamed from: e  reason: collision with root package name */
    T f16868e;

    /* renamed from: f  reason: collision with root package name */
    Throwable f16869f;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f16867d = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a<T>[]> f16866c = new AtomicReference<>(a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleSubject.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<e<T>> implements h.c.k0.b {
        final e0<? super T> a;

        a(e0<? super T> e0Var, e<T> eVar) {
            this.a = e0Var;
            lazySet(eVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            e<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.d(this);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    e() {
    }

    public static <T> e<T> c() {
        return new e<>();
    }

    boolean b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16866c.get();
            if (aVarArr == f16865b) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16866c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void d(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16866c.get();
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
        } while (!this.f16866c.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        h.c.n0.b.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16867d.compareAndSet(false, true)) {
            this.f16869f = th;
            for (a<T> aVar : this.f16866c.getAndSet(f16865b)) {
                aVar.a.onError(th);
            }
            return;
        }
        h.c.r0.a.u(th);
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        if (this.f16866c.get() == f16865b) {
            bVar.dispose();
        }
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        h.c.n0.b.b.e(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16867d.compareAndSet(false, true)) {
            this.f16868e = t;
            for (a<T> aVar : this.f16866c.getAndSet(f16865b)) {
                aVar.a.onSuccess(t);
            }
        }
    }

    @Override // h.c.b0
    protected void subscribeActual(e0<? super T> e0Var) {
        a<T> aVar = new a<>(e0Var, this);
        e0Var.onSubscribe(aVar);
        if (b(aVar)) {
            if (aVar.isDisposed()) {
                d(aVar);
                return;
            }
            return;
        }
        Throwable th = this.f16869f;
        if (th != null) {
            e0Var.onError(th);
        } else {
            e0Var.onSuccess((T) this.f16868e);
        }
    }
}
package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SingleAmb.java */
/* loaded from: classes3.dex */
public final class a<T> extends h.c.b0<T> {
    private final h.c.h0<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    private final Iterable<? extends h.c.h0<? extends T>> f16467b;

    /* compiled from: SingleAmb.java */
    /* renamed from: h.c.n0.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0393a<T> implements h.c.e0<T> {
        final h.c.k0.a a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.e0<? super T> f16468b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f16469c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16470d;

        C0393a(h.c.e0<? super T> e0Var, h.c.k0.a aVar, AtomicBoolean atomicBoolean) {
            this.f16468b = e0Var;
            this.a = aVar;
            this.f16469c = atomicBoolean;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            if (this.f16469c.compareAndSet(false, true)) {
                this.a.c(this.f16470d);
                this.a.dispose();
                this.f16468b.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16470d = bVar;
            this.a.b(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            if (this.f16469c.compareAndSet(false, true)) {
                this.a.c(this.f16470d);
                this.a.dispose();
                this.f16468b.onSuccess(t);
            }
        }
    }

    public a(h.c.h0<? extends T>[] h0VarArr, Iterable<? extends h.c.h0<? extends T>> iterable) {
        this.a = h0VarArr;
        this.f16467b = iterable;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        int length;
        h.c.h0<? extends T>[] h0VarArr = this.a;
        if (h0VarArr == null) {
            h0VarArr = new h.c.h0[8];
            try {
                length = 0;
                for (h.c.h0<? extends T> h0Var : this.f16467b) {
                    if (h0Var == null) {
                        h.c.n0.a.d.z(new NullPointerException("One of the sources is null"), e0Var);
                        return;
                    }
                    if (length == h0VarArr.length) {
                        h.c.h0<? extends T>[] h0VarArr2 = new h.c.h0[(length >> 2) + length];
                        System.arraycopy(h0VarArr, 0, h0VarArr2, 0, length);
                        h0VarArr = h0VarArr2;
                    }
                    int i2 = length + 1;
                    h0VarArr[length] = h0Var;
                    length = i2;
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.z(th, e0Var);
                return;
            }
        } else {
            length = h0VarArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        h.c.k0.a aVar = new h.c.k0.a();
        e0Var.onSubscribe(aVar);
        for (int i3 = 0; i3 < length; i3++) {
            h.c.h0<? extends T> h0Var2 = h0VarArr[i3];
            if (aVar.isDisposed()) {
                return;
            }
            if (h0Var2 == null) {
                aVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    e0Var.onError(nullPointerException);
                    return;
                } else {
                    h.c.r0.a.u(nullPointerException);
                    return;
                }
            }
            h0Var2.subscribe(new C0393a(e0Var, aVar, atomicBoolean));
        }
    }
}
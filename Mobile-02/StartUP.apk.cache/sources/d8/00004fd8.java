package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleEquals.java */
/* loaded from: classes3.dex */
public final class v<T> extends h.c.b0<Boolean> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<? extends T> f16576b;

    /* compiled from: SingleEquals.java */
    /* loaded from: classes3.dex */
    static class a<T> implements h.c.e0<T> {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.k0.a f16577b;

        /* renamed from: c  reason: collision with root package name */
        final Object[] f16578c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.e0<? super Boolean> f16579d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicInteger f16580e;

        a(int i2, h.c.k0.a aVar, Object[] objArr, h.c.e0<? super Boolean> e0Var, AtomicInteger atomicInteger) {
            this.a = i2;
            this.f16577b = aVar;
            this.f16578c = objArr;
            this.f16579d = e0Var;
            this.f16580e = atomicInteger;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            int i2;
            do {
                i2 = this.f16580e.get();
                if (i2 >= 2) {
                    h.c.r0.a.u(th);
                    return;
                }
            } while (!this.f16580e.compareAndSet(i2, 2));
            this.f16577b.dispose();
            this.f16579d.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16577b.b(bVar);
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f16578c[this.a] = t;
            if (this.f16580e.incrementAndGet() == 2) {
                h.c.e0<? super Boolean> e0Var = this.f16579d;
                Object[] objArr = this.f16578c;
                e0Var.onSuccess(Boolean.valueOf(h.c.n0.b.b.c(objArr[0], objArr[1])));
            }
        }
    }

    public v(h.c.h0<? extends T> h0Var, h.c.h0<? extends T> h0Var2) {
        this.a = h0Var;
        this.f16576b = h0Var2;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        h.c.k0.a aVar = new h.c.k0.a();
        e0Var.onSubscribe(aVar);
        this.a.subscribe(new a(0, aVar, objArr, e0Var, atomicInteger));
        this.f16576b.subscribe(new a(1, aVar, objArr, e0Var, atomicInteger));
    }
}
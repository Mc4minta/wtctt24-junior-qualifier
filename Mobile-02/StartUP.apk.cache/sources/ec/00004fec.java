package h.c.n0.e.g;

import h.c.n0.e.g.k0;
import h.c.n0.e.g.y0;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* compiled from: SingleZipIterable.java */
/* loaded from: classes3.dex */
public final class z0<T, R> extends h.c.b0<R> {
    final Iterable<? extends h.c.h0<? extends T>> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f16608b;

    /* compiled from: SingleZipIterable.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.m0.n<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // h.c.m0.n
        public R apply(T t) throws Exception {
            return (R) h.c.n0.b.b.e(z0.this.f16608b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    public z0(Iterable<? extends h.c.h0<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar) {
        this.a = iterable;
        this.f16608b = nVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        h.c.h0[] h0VarArr = new h.c.h0[8];
        try {
            int i2 = 0;
            for (h.c.h0<? extends T> h0Var : this.a) {
                if (h0Var == null) {
                    h.c.n0.a.d.z(new NullPointerException("One of the sources is null"), e0Var);
                    return;
                }
                if (i2 == h0VarArr.length) {
                    h0VarArr = (h.c.h0[]) Arrays.copyOf(h0VarArr, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                h0VarArr[i2] = h0Var;
                i2 = i3;
            }
            if (i2 == 0) {
                h.c.n0.a.d.z(new NoSuchElementException(), e0Var);
            } else if (i2 == 1) {
                h0VarArr[0].subscribe(new k0.a(e0Var, new a()));
            } else {
                y0.b bVar = new y0.b(e0Var, i2, this.f16608b);
                e0Var.onSubscribe(bVar);
                for (int i4 = 0; i4 < i2 && !bVar.isDisposed(); i4++) {
                    h0VarArr[i4].subscribe(bVar.f16598c[i4]);
                }
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}
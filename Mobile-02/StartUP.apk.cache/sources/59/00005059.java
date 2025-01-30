package h.c.q0;

import com.appsflyer.internal.referrer.Payload;
import h.c.h;
import k.a.b;

/* compiled from: ParallelFlowable.java */
/* loaded from: classes3.dex */
public abstract class a<T> {
    public static <T> a<T> a(b<? extends T> bVar) {
        return c(bVar, Runtime.getRuntime().availableProcessors(), h.bufferSize());
    }

    public static <T> a<T> b(b<? extends T> bVar, int i2) {
        return c(bVar, i2, h.bufferSize());
    }

    public static <T> a<T> c(b<? extends T> bVar, int i2, int i3) {
        h.c.n0.b.b.e(bVar, Payload.SOURCE);
        h.c.n0.b.b.f(i2, "parallelism");
        h.c.n0.b.b.f(i3, "prefetch");
        return h.c.r0.a.r(new h.c.n0.e.f.a(bVar, i2, i3));
    }
}
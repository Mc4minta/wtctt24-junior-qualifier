package h.c.n0.j;

import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HalfSerializer.java */
/* loaded from: classes3.dex */
public final class k {
    public static void a(z<?> zVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = cVar.b();
            if (b2 != null) {
                zVar.onError(b2);
            } else {
                zVar.onComplete();
            }
        }
    }

    public static void b(k.a.c<?> cVar, AtomicInteger atomicInteger, c cVar2) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = cVar2.b();
            if (b2 != null) {
                cVar.onError(b2);
            } else {
                cVar.onComplete();
            }
        }
    }

    public static void c(z<?> zVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (cVar.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                zVar.onError(cVar.b());
                return;
            }
            return;
        }
        h.c.r0.a.u(th);
    }

    public static void d(k.a.c<?> cVar, Throwable th, AtomicInteger atomicInteger, c cVar2) {
        if (cVar2.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(cVar2.b());
                return;
            }
            return;
        }
        h.c.r0.a.u(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(z<? super T> zVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            zVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = cVar.b();
                if (b2 != null) {
                    zVar.onError(b2);
                } else {
                    zVar.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(k.a.c<? super T> cVar, T t, AtomicInteger atomicInteger, c cVar2) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = cVar2.b();
                if (b2 != null) {
                    cVar.onError(b2);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }
}
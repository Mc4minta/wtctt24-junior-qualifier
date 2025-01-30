package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HalfSerializer.java */
/* loaded from: classes2.dex */
final class v {
    public static void a(h.c.z<?> zVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = bVar.b();
            if (b2 != null) {
                zVar.onError(b2);
            } else {
                zVar.onComplete();
            }
        }
    }

    public static void b(k.a.c<?> cVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b2 = bVar.b();
            if (b2 != null) {
                cVar.onError(b2);
            } else {
                cVar.onComplete();
            }
        }
    }

    public static void c(h.c.z<?> zVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (bVar.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                zVar.onError(bVar.b());
                return;
            }
            return;
        }
        h.c.r0.a.u(th);
    }

    public static void d(k.a.c<?> cVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (bVar.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(bVar.b());
                return;
            }
            return;
        }
        h.c.r0.a.u(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean e(h.c.z<? super T> zVar, T t, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            zVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = bVar.b();
                if (b2 != null) {
                    zVar.onError(b2);
                } else {
                    zVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean f(k.a.c<? super T> cVar, T t, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b2 = bVar.b();
                if (b2 != null) {
                    cVar.onError(b2);
                } else {
                    cVar.onComplete();
                }
                return true;
            }
        }
        return false;
    }
}
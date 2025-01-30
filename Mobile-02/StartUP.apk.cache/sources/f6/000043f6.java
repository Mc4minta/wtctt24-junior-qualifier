package com.uber.autodispose;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposeEndConsumerHelper.java */
/* loaded from: classes2.dex */
final class h {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        h.c.r0.a.u(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar, Class<?> cls) {
        m.a(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != c.DISPOSED) {
            b(cls);
            return false;
        }
        return false;
    }

    public static boolean d(AtomicReference<k.a.d> atomicReference, k.a.d dVar, Class<?> cls) {
        m.a(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != r.CANCELLED) {
            b(cls);
            return false;
        }
        return false;
    }
}
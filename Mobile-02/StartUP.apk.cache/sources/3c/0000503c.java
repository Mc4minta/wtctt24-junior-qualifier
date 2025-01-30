package h.c.n0.j;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EndConsumerHelper.java */
/* loaded from: classes3.dex */
public final class h {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        h.c.r0.a.u(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar, Class<?> cls) {
        h.c.n0.b.b.e(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != h.c.n0.a.c.DISPOSED) {
            b(cls);
            return false;
        }
        return false;
    }

    public static boolean d(AtomicReference<k.a.d> atomicReference, k.a.d dVar, Class<?> cls) {
        h.c.n0.b.b.e(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != h.c.n0.i.g.CANCELLED) {
            b(cls);
            return false;
        }
        return false;
    }

    public static boolean e(h.c.k0.b bVar, h.c.k0.b bVar2, Class<?> cls) {
        h.c.n0.b.b.e(bVar2, "next is null");
        if (bVar != null) {
            bVar2.dispose();
            if (bVar != h.c.n0.a.c.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean f(k.a.d dVar, k.a.d dVar2, Class<?> cls) {
        h.c.n0.b.b.e(dVar2, "next is null");
        if (dVar != null) {
            dVar2.cancel();
            if (dVar != h.c.n0.i.g.CANCELLED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }
}
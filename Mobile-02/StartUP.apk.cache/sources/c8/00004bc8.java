package h.c.n0.a;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableHelper.java */
/* loaded from: classes.dex */
public enum c implements h.c.k0.b {
    DISPOSED;

    public static boolean A(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
            return false;
        }
        return false;
    }

    public static boolean B(h.c.k0.b bVar, h.c.k0.b bVar2) {
        if (bVar2 == null) {
            h.c.r0.a.u(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.dispose();
            s();
            return false;
        } else {
            return true;
        }
    }

    public static boolean h(AtomicReference<h.c.k0.b> atomicReference) {
        h.c.k0.b andSet;
        h.c.k0.b bVar = atomicReference.get();
        c cVar = DISPOSED;
        if (bVar == cVar || (andSet = atomicReference.getAndSet(cVar)) == cVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    public static boolean n(h.c.k0.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean q(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar) {
        h.c.k0.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static void s() {
        h.c.r0.a.u(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean y(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar) {
        h.c.k0.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean z(AtomicReference<h.c.k0.b> atomicReference, h.c.k0.b bVar) {
        h.c.n0.b.b.e(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            s();
            return false;
        }
        return false;
    }

    @Override // h.c.k0.b
    public void dispose() {
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return true;
    }
}
package h.c.n0.i;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriptionHelper.java */
/* loaded from: classes3.dex */
public enum g implements k.a.d {
    CANCELLED;

    public static boolean A(AtomicReference<k.a.d> atomicReference, k.a.d dVar, long j2) {
        if (z(atomicReference, dVar)) {
            dVar.request(j2);
            return true;
        }
        return false;
    }

    public static boolean B(long j2) {
        if (j2 <= 0) {
            h.c.r0.a.u(new IllegalArgumentException("n > 0 required but it was " + j2));
            return false;
        }
        return true;
    }

    public static boolean C(k.a.d dVar, k.a.d dVar2) {
        if (dVar2 == null) {
            h.c.r0.a.u(new NullPointerException("next is null"));
            return false;
        } else if (dVar != null) {
            dVar2.cancel();
            y();
            return false;
        } else {
            return true;
        }
    }

    public static boolean h(AtomicReference<k.a.d> atomicReference) {
        k.a.d andSet;
        k.a.d dVar = atomicReference.get();
        g gVar = CANCELLED;
        if (dVar == gVar || (andSet = atomicReference.getAndSet(gVar)) == gVar) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
            return true;
        }
        return true;
    }

    public static void n(AtomicReference<k.a.d> atomicReference, AtomicLong atomicLong, long j2) {
        k.a.d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j2);
        } else if (B(j2)) {
            h.c.n0.j.d.a(atomicLong, j2);
            k.a.d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static boolean q(AtomicReference<k.a.d> atomicReference, AtomicLong atomicLong, k.a.d dVar) {
        if (z(atomicReference, dVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void s(long j2) {
        h.c.r0.a.u(new ProtocolViolationException("More produced than requested: " + j2));
    }

    public static void y() {
        h.c.r0.a.u(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean z(AtomicReference<k.a.d> atomicReference, k.a.d dVar) {
        h.c.n0.b.b.e(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            y();
            return false;
        }
        return false;
    }

    @Override // k.a.d
    public void cancel() {
    }

    @Override // k.a.d
    public void request(long j2) {
    }
}
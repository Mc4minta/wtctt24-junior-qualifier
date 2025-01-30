package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoSubscriptionHelper.java */
/* loaded from: classes2.dex */
enum r implements k.a.d {
    CANCELLED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(AtomicReference<k.a.d> atomicReference) {
        k.a.d andSet;
        k.a.d dVar = atomicReference.get();
        r rVar = CANCELLED;
        if (dVar == rVar || (andSet = atomicReference.getAndSet(rVar)) == rVar) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(AtomicReference<k.a.d> atomicReference, AtomicLong atomicLong, long j2) {
        k.a.d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j2);
        } else if (z(j2)) {
            e.a(atomicLong, j2);
            k.a.d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(AtomicReference<k.a.d> atomicReference, AtomicLong atomicLong, k.a.d dVar) {
        if (y(atomicReference, dVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    static void s() {
        h.c.r0.a.u(new IllegalStateException("Subscription already set!"));
    }

    static boolean y(AtomicReference<k.a.d> atomicReference, k.a.d dVar) {
        m.a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            s();
            return false;
        }
        return false;
    }

    static boolean z(long j2) {
        if (j2 <= 0) {
            h.c.r0.a.u(new IllegalArgumentException("n > 0 required but it was " + j2));
            return false;
        }
        return true;
    }

    @Override // k.a.d
    public void cancel() {
    }

    @Override // k.a.d
    public void request(long j2) {
    }
}
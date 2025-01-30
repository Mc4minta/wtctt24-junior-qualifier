package h.c.n0.j;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingHelper.java */
/* loaded from: classes3.dex */
public final class e {
    public static void a(CountDownLatch countDownLatch, h.c.k0.b bVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            b();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            bVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    public static void b() {
        if (h.c.r0.a.j()) {
            if ((Thread.currentThread() instanceof h.c.n0.g.j) || h.c.r0.a.s()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
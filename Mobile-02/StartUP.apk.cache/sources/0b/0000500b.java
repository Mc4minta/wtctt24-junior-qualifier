package h.c.n0.g;

/* compiled from: ScheduledDirectPeriodicTask.java */
/* loaded from: classes3.dex */
public final class l extends a implements Runnable {
    public l(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16626d = Thread.currentThread();
        try {
            this.f16625c.run();
            this.f16626d = null;
        } catch (Throwable th) {
            this.f16626d = null;
            lazySet(a.a);
            h.c.r0.a.u(th);
        }
    }
}
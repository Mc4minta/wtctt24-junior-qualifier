package h.c.n0.g;

import java.util.concurrent.Callable;

/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes3.dex */
public final class m extends a implements Callable<Void> {
    public m(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() throws Exception {
        this.f16626d = Thread.currentThread();
        try {
            this.f16625c.run();
            return null;
        } finally {
            lazySet(a.a);
            this.f16626d = null;
        }
    }
}
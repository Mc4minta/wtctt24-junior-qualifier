package h.c.n0.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AbstractDirectTask.java */
/* loaded from: classes3.dex */
abstract class a extends AtomicReference<Future<?>> implements h.c.k0.b {
    protected static final FutureTask<Void> a;

    /* renamed from: b  reason: collision with root package name */
    protected static final FutureTask<Void> f16624b;

    /* renamed from: c  reason: collision with root package name */
    protected final Runnable f16625c;

    /* renamed from: d  reason: collision with root package name */
    protected Thread f16626d;

    static {
        Runnable runnable = h.c.n0.b.a.f14095b;
        a = new FutureTask<>(runnable, null);
        f16624b = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f16625c = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == a) {
                return;
            }
            if (future2 == f16624b) {
                future.cancel(this.f16626d != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // h.c.k0.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == a || future == (futureTask = f16624b) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f16626d != Thread.currentThread());
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == a || future == f16624b;
    }
}
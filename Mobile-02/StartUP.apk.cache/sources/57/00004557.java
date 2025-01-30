package e.f.d.b;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: ScheduledFutureImpl.java */
/* loaded from: classes2.dex */
public class c<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final Handler a;

    /* renamed from: b  reason: collision with root package name */
    private final FutureTask<V> f12066b;

    public c(Handler handler, Callable<V> callable) {
        this.a = handler;
        this.f12066b = new FutureTask<>(callable);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.f12066b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.f12066b.get();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f12066b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f12066b.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f12066b.run();
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f12066b.get(j2, timeUnit);
    }

    public c(Handler handler, Runnable runnable, V v) {
        this.a = handler;
        this.f12066b = new FutureTask<>(runnable, v);
    }
}
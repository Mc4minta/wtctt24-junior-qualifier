package org.apache.http.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* loaded from: classes3.dex */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() throws ExecutionException {
        if (this.ex == null) {
            if (!this.cancelled) {
                return this.result;
            }
            throw new CancellationException();
        }
        throw new ExecutionException(this.ex);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.cancelled();
            }
            return true;
        }
    }

    public boolean completed(T t) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.result = t;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.completed(t);
            }
            return true;
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.ex = exc;
            notifyAll();
            FutureCallback<T> futureCallback = this.callback;
            if (futureCallback != null) {
                futureCallback.failed(exc);
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.completed;
    }

    @Override // java.util.concurrent.Future
    public synchronized T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j2);
        int i2 = (millis > 0L ? 1 : (millis == 0L ? 0 : -1));
        long currentTimeMillis = i2 <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        } else if (i2 <= 0) {
            throw new TimeoutException();
        } else {
            long j3 = millis;
            while (true) {
                wait(j3);
                if (this.completed) {
                    return getResult();
                }
                j3 = millis - (System.currentTimeMillis() - currentTimeMillis);
                if (j3 <= 0) {
                    throw new TimeoutException();
                }
            }
        }
    }

    @Override // org.apache.http.concurrent.Cancellable
    public boolean cancel() {
        return cancel(true);
    }
}
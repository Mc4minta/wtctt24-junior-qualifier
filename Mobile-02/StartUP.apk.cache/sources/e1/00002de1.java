package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class SimpleSettableFuture<T> implements Future<T> {
    private final CountDownLatch a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    private T f4791b;

    /* renamed from: c  reason: collision with root package name */
    private Exception f4792c;

    private void a() {
        if (this.a.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }

    public T b() {
        try {
            return get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void c(T t) {
        a();
        this.f4791b = t;
        this.a.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void d(Exception exc) {
        a();
        this.f4792c = exc;
        this.a.countDown();
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        this.a.await();
        if (this.f4792c == null) {
            return this.f4791b;
        }
        throw new ExecutionException(this.f4792c);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.a.await(j2, timeUnit)) {
            if (this.f4792c == null) {
                return this.f4791b;
            }
            throw new ExecutionException(this.f4792c);
        }
        throw new TimeoutException("Timed out waiting for result");
    }
}
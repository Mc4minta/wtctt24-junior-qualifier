package com.bugsnag.android;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Async.java */
/* loaded from: classes.dex */
class e {
    private static final int a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3640b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3641c;

    /* renamed from: d  reason: collision with root package name */
    static final BlockingQueue<Runnable> f3642d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f3643e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadPoolExecutor f3644f;

    /* compiled from: Async.java */
    /* loaded from: classes.dex */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Bugsnag Thread #" + this.a.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        int max = Math.max(1, Math.min(availableProcessors - 1, 4));
        f3640b = max;
        int i2 = (availableProcessors * 2) + 1;
        f3641c = i2;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f3642d = linkedBlockingQueue;
        a aVar = new a();
        f3643e = aVar;
        f3644f = new ThreadPoolExecutor(max, i2, 30L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Runnable runnable) throws RejectedExecutionException {
        f3644f.execute(runnable);
    }
}
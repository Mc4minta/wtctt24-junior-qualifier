package com.google.firebase.crashlytics.c.g;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a implements ThreadFactory {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicLong f8795b;

        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* renamed from: com.google.firebase.crashlytics.c.g.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0167a extends d {
            final /* synthetic */ Runnable a;

            C0167a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // com.google.firebase.crashlytics.c.g.d
            public void a() {
                this.a.run();
            }
        }

        a(String str, AtomicLong atomicLong) {
            this.a = str;
            this.f8795b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0167a(runnable));
            newThread.setName(this.a + this.f8795b.getAndIncrement());
            return newThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class b extends d {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExecutorService f8797b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f8798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TimeUnit f8799d;

        b(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
            this.a = str;
            this.f8797b = executorService;
            this.f8798c = j2;
            this.f8799d = timeUnit;
        }

        @Override // com.google.firebase.crashlytics.c.g.d
        public void a() {
            try {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.b("Executing shutdown hook for " + this.a);
                this.f8797b.shutdown();
                if (this.f8797b.awaitTermination(this.f8798c, this.f8799d)) {
                    return;
                }
                com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                f3.b(this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f8797b.shutdownNow();
            } catch (InterruptedException unused) {
                com.google.firebase.crashlytics.c.b.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.a));
                this.f8797b.shutdownNow();
            }
        }
    }

    private static final void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static final void b(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        b bVar = new b(str, executorService, j2, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(d(str));
        a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static final ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }
}
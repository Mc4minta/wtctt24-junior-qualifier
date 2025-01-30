package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AndroidExecutors.java */
/* loaded from: classes.dex */
final class a {
    private static final a a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final int f2393b;

    /* renamed from: c  reason: collision with root package name */
    static final int f2394c;

    /* renamed from: d  reason: collision with root package name */
    static final int f2395d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f2396e = new b();

    /* compiled from: AndroidExecutors.java */
    /* loaded from: classes.dex */
    private static class b implements Executor {
        private b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2393b = availableProcessors;
        f2394c = availableProcessors + 1;
        f2395d = (availableProcessors * 2) + 1;
    }

    private a() {
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f2394c, f2395d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor c() {
        return a.f2396e;
    }
}
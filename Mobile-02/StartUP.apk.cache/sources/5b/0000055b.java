package c.h.i;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
class g {

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    private static class a implements ThreadFactory {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private int f2974b;

        /* compiled from: RequestExecutor.java */
        /* renamed from: c.h.i.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0064a extends Thread {
            private final int a;

            C0064a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.a = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }

        a(String str, int i2) {
            this.a = str;
            this.f2974b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0064a(runnable, this.a, this.f2974b);
        }
    }

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    private static class b<T> implements Runnable {
        private Callable<T> a;

        /* renamed from: b  reason: collision with root package name */
        private androidx.core.util.a<T> f2975b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f2976c;

        /* compiled from: RequestExecutor.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ androidx.core.util.a a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f2977b;

            a(androidx.core.util.a aVar, Object obj) {
                this.a = aVar;
                this.f2977b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.a.accept(this.f2977b);
            }
        }

        b(Handler handler, Callable<T> callable, androidx.core.util.a<T> aVar) {
            this.a = callable;
            this.f2975b = aVar;
            this.f2976c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.a.call();
            } catch (Exception unused) {
                t = null;
            }
            this.f2976c.post(new a(this.f2975b, t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void b(Executor executor, Callable<T> callable, androidx.core.util.a<T> aVar) {
        executor.execute(new b(c.h.i.b.a(), callable, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            throw e2;
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
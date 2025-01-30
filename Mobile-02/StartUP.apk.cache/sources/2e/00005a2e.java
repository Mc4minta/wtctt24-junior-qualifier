package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CommonPool.kt */
/* loaded from: classes3.dex */
public final class l extends k0 {

    /* renamed from: c  reason: collision with root package name */
    private static final int f17518c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f17519d;

    /* renamed from: e  reason: collision with root package name */
    public static final l f17520e = new l();
    private static volatile Executor pool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonPool.kt */
    /* loaded from: classes3.dex */
    public static final class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger a;

        a(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "CommonPool-worker-" + this.a.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonPool.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public static final b a = new b();

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    static {
        String str;
        int i2;
        Integer q;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            q = kotlin.l0.w.q(str);
            if (q != null && q.intValue() >= 1) {
                i2 = q.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i2 = -1;
        }
        f17518c = i2;
    }

    private l() {
    }

    private final ExecutorService K() {
        return Executors.newFixedThreadPool(V(), new a(new AtomicInteger()));
    }

    private final ExecutorService N() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return K();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!f17519d && f17518c < 0) {
                try {
                    Method method = cls.getMethod("commonPool", new Class[0]);
                    Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                    if (!(invoke instanceof ExecutorService)) {
                        invoke = null;
                    }
                    executorService = (ExecutorService) invoke;
                } catch (Throwable unused2) {
                    executorService = null;
                }
                if (executorService != null) {
                    if (!f17520e.a0(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f17520e.V()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService2 = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
            }
            return executorService2 != null ? executorService2 : K();
        }
        return K();
    }

    private final synchronized Executor O() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = N();
            pool = executor;
        }
        return executor;
    }

    private final int V() {
        int b2;
        Integer valueOf = Integer.valueOf(f17518c);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        b2 = kotlin.i0.f.b(Runtime.getRuntime().availableProcessors() - 1, 1);
        return b2;
    }

    @Override // kotlinx.coroutines.t
    public void A(kotlin.c0.f fVar, Runnable runnable) {
        Runnable runnable2;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = O();
            }
            e1 a2 = f1.a();
            if (a2 == null || (runnable2 = a2.a(runnable)) == null) {
                runnable2 = runnable;
            }
            executor.execute(runnable2);
        } catch (RejectedExecutionException unused) {
            e1 a3 = f1.a();
            if (a3 != null) {
                a3.c();
            }
            z.f17548h.y0(runnable);
        }
    }

    public final boolean a0(Class<?> cls, ExecutorService executorService) {
        executorService.submit(b.a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.t
    public String toString() {
        return "CommonPool";
    }
}
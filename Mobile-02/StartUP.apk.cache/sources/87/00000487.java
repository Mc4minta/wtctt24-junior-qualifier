package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: BoltsExecutors.java */
/* loaded from: classes.dex */
final class b {
    private static final b a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f2397b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f2398c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2399d;

    /* compiled from: BoltsExecutors.java */
    /* renamed from: bolts.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class ExecutorC0052b implements Executor {
        private ThreadLocal<Integer> a;

        private ExecutorC0052b() {
            this.a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.a.remove();
            } else {
                this.a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private int b() {
            Integer num = this.a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.a.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    b.a().execute(runnable);
                }
            } finally {
                a();
            }
        }
    }

    private b() {
        this.f2397b = !c() ? Executors.newCachedThreadPool() : bolts.a.b();
        this.f2398c = Executors.newSingleThreadScheduledExecutor();
        this.f2399d = new ExecutorC0052b();
    }

    public static ExecutorService a() {
        return a.f2397b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return a.f2399d;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
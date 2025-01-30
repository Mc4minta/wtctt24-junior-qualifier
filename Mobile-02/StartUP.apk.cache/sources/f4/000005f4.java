package c.o.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ModernAsyncTask.java */
/* loaded from: classes.dex */
abstract class c<Params, Progress, Result> {
    private static final ThreadFactory a;

    /* renamed from: b  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3173b;

    /* renamed from: c  reason: collision with root package name */
    public static final Executor f3174c;

    /* renamed from: d  reason: collision with root package name */
    private static f f3175d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile Executor f3176e;

    /* renamed from: f  reason: collision with root package name */
    private final h<Params, Result> f3177f;

    /* renamed from: g  reason: collision with root package name */
    private final FutureTask<Result> f3178g;

    /* renamed from: h  reason: collision with root package name */
    private volatile g f3179h = g.PENDING;

    /* renamed from: j  reason: collision with root package name */
    final AtomicBoolean f3180j = new AtomicBoolean();

    /* renamed from: k  reason: collision with root package name */
    final AtomicBoolean f3181k = new AtomicBoolean();

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    class b extends h<Params, Result> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            c.this.f3181k.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) c.this.b(this.a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: c.o.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0081c extends FutureTask<Result> {
        C0081c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.m(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                c.this.m(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class e<Data> {
        final c a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f3183b;

        e(c cVar, Data... dataArr) {
            this.a = cVar;
            this.f3183b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                eVar.a.d(eVar.f3183b[0]);
            } else if (i2 != 2) {
            } else {
                eVar.a.k(eVar.f3183b);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    private static abstract class h<Params, Result> implements Callable<Result> {
        Params[] a;

        h() {
        }
    }

    static {
        a aVar = new a();
        a = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3173b = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f3174c = threadPoolExecutor;
        f3176e = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        b bVar = new b();
        this.f3177f = bVar;
        this.f3178g = new C0081c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (c.class) {
            if (f3175d == null) {
                f3175d = new f();
            }
            fVar = f3175d;
        }
        return fVar;
    }

    public final boolean a(boolean z) {
        this.f3180j.set(true);
        return this.f3178g.cancel(z);
    }

    protected abstract Result b(Params... paramsArr);

    public final c<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f3179h != g.PENDING) {
            int i2 = d.a[this.f3179h.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f3179h = g.RUNNING;
        j();
        this.f3177f.a = paramsArr;
        executor.execute(this.f3178g);
        return this;
    }

    void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f3179h = g.FINISHED;
    }

    public final boolean f() {
        return this.f3180j.get();
    }

    protected void g() {
    }

    protected void h(Result result) {
        g();
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }

    Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (this.f3181k.get()) {
            return;
        }
        l(result);
    }
}
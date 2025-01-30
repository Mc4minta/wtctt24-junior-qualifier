package h.c.j0.c;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import h.c.a0;
import h.c.k0.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandlerScheduler.java */
/* loaded from: classes2.dex */
public final class b extends a0 {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f14084b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14085c;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes2.dex */
    private static final class a extends a0.c {
        private final Handler a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14086b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f14087c;

        a(Handler handler, boolean z) {
            this.a = handler;
            this.f14086b = z;
        }

        @Override // h.c.a0.c
        @SuppressLint({"NewApi"})
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f14087c) {
                return c.a();
            }
            RunnableC0341b runnableC0341b = new RunnableC0341b(this.a, h.c.r0.a.w(runnable));
            Message obtain = Message.obtain(this.a, runnableC0341b);
            obtain.obj = this;
            if (this.f14086b) {
                obtain.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            if (this.f14087c) {
                this.a.removeCallbacks(runnableC0341b);
                return c.a();
            }
            return runnableC0341b;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14087c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14087c;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: h.c.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class RunnableC0341b implements Runnable, h.c.k0.b {
        private final Handler a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f14088b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f14089c;

        RunnableC0341b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.f14088b = runnable;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.a.removeCallbacks(this);
            this.f14089c = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14089c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f14088b.run();
            } catch (Throwable th) {
                h.c.r0.a.u(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, boolean z) {
        this.f14084b = handler;
        this.f14085c = z;
    }

    @Override // h.c.a0
    public a0.c a() {
        return new a(this.f14084b, this.f14085c);
    }

    @Override // h.c.a0
    @SuppressLint({"NewApi"})
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0341b runnableC0341b = new RunnableC0341b(this.f14084b, h.c.r0.a.w(runnable));
        Message obtain = Message.obtain(this.f14084b, runnableC0341b);
        if (this.f14085c) {
            obtain.setAsynchronous(true);
        }
        this.f14084b.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
        return runnableC0341b;
    }
}
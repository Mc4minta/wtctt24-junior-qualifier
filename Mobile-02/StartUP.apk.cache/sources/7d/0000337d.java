package com.google.android.gms.internal.p000firebaseperf;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h0  reason: invalid package */
/* loaded from: classes2.dex */
public final class h0 {
    @SuppressLint({"StaticFieldLeak"})
    private static final h0 a = new h0();

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f6725b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentLinkedQueue<f1> f6726c;

    /* renamed from: d  reason: collision with root package name */
    private final Runtime f6727d;

    /* renamed from: e  reason: collision with root package name */
    private ScheduledFuture f6728e;

    /* renamed from: f  reason: collision with root package name */
    private long f6729f;

    private h0() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    public static h0 d() {
        return a;
    }

    private final synchronized void e(long j2, y0 y0Var) {
        this.f6729f = j2;
        try {
            this.f6728e = this.f6725b.scheduleAtFixedRate(new Runnable(this, y0Var) { // from class: com.google.android.gms.internal.firebase-perf.g0
                private final h0 a;

                /* renamed from: b  reason: collision with root package name */
                private final y0 f6720b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f6720b = y0Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(this.f6720b);
                }
            }, 0L, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Memory Metrics: ".concat(valueOf) : new String("Unable to start collecting Memory Metrics: "));
        }
    }

    private final synchronized void f(y0 y0Var) {
        try {
            this.f6725b.schedule(new Runnable(this, y0Var) { // from class: com.google.android.gms.internal.firebase-perf.j0
                private final h0 a;

                /* renamed from: b  reason: collision with root package name */
                private final y0 f6766b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f6766b = y0Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(this.f6766b);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Memory Metric: ".concat(valueOf) : new String("Unable to collect Memory Metric: "));
        }
    }

    private final f1 g(y0 y0Var) {
        if (y0Var == null) {
            return null;
        }
        return (f1) ((m4) f1.w().p(y0Var.d()).o(s8.a(s0.f6902e.h(this.f6727d.totalMemory() - this.f6727d.freeMemory()))).O());
    }

    public static boolean j(long j2) {
        return j2 <= 0;
    }

    public final void a(long j2, y0 y0Var) {
        if (j(j2)) {
            return;
        }
        if (this.f6728e != null) {
            if (this.f6729f != j2) {
                c();
                e(j2, y0Var);
                return;
            }
            return;
        }
        e(j2, y0Var);
    }

    public final void b(y0 y0Var) {
        f(y0Var);
    }

    public final void c() {
        ScheduledFuture scheduledFuture = this.f6728e;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f6728e = null;
        this.f6729f = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(y0 y0Var) {
        f1 g2 = g(y0Var);
        if (g2 != null) {
            this.f6726c.add(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(y0 y0Var) {
        f1 g2 = g(y0Var);
        if (g2 != null) {
            this.f6726c.add(g2);
        }
    }

    private h0(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.f6728e = null;
        this.f6729f = -1L;
        this.f6725b = scheduledExecutorService;
        this.f6726c = new ConcurrentLinkedQueue<>();
        this.f6727d = runtime;
    }
}
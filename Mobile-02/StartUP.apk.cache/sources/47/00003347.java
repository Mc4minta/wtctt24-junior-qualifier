package com.google.android.gms.internal.p000firebaseperf;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c0  reason: invalid package */
/* loaded from: classes2.dex */
public final class c0 {
    private static final long a = TimeUnit.SECONDS.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private static c0 f6691b = null;

    /* renamed from: f  reason: collision with root package name */
    private final long f6695f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6696g;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture f6692c = null;

    /* renamed from: e  reason: collision with root package name */
    private long f6694e = -1;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentLinkedQueue<m1> f6697h = new ConcurrentLinkedQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f6693d = Executors.newSingleThreadScheduledExecutor();

    private c0() {
        String num = Integer.toString(Process.myPid());
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 11);
        sb.append("/proc/");
        sb.append(num);
        sb.append("/stat");
        this.f6696g = sb.toString();
        this.f6695f = Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : -1L;
    }

    private final synchronized void c(long j2, y0 y0Var) {
        this.f6694e = j2;
        try {
            this.f6692c = this.f6693d.scheduleAtFixedRate(new Runnable(this, y0Var) { // from class: com.google.android.gms.internal.firebase-perf.f0
                private final c0 a;

                /* renamed from: b  reason: collision with root package name */
                private final y0 f6716b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f6716b = y0Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(this.f6716b);
                }
            }, 0L, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Cpu Metrics: ".concat(valueOf) : new String("Unable to start collecting Cpu Metrics: "));
        }
    }

    private final synchronized void d(y0 y0Var) {
        try {
            this.f6693d.schedule(new Runnable(this, y0Var) { // from class: com.google.android.gms.internal.firebase-perf.e0
                private final c0 a;

                /* renamed from: b  reason: collision with root package name */
                private final y0 f6711b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f6711b = y0Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(this.f6711b);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Cpu Metric: ".concat(valueOf) : new String("Unable to collect Cpu Metric: "));
        }
    }

    public static c0 e() {
        if (f6691b == null) {
            f6691b = new c0();
        }
        return f6691b;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.p000firebaseperf.m1 g(com.google.android.gms.internal.p000firebaseperf.y0 r14) {
        /*
            r13 = this;
            java.lang.String r0 = "FirebasePerformance"
            r1 = 0
            if (r14 != 0) goto L6
            return r1
        L6:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            java.lang.String r4 = r13.f6696g     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            r3.<init>(r4)     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            r2.<init>(r3)     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            long r3 = r14.d()     // Catch: java.lang.Throwable -> L66
            java.lang.String r14 = r2.readLine()     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = " "
            java.lang.String[] r14 = r14.split(r5)     // Catch: java.lang.Throwable -> L66
            r5 = 13
            r5 = r14[r5]     // Catch: java.lang.Throwable -> L66
            long r5 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> L66
            r7 = 15
            r7 = r14[r7]     // Catch: java.lang.Throwable -> L66
            long r7 = java.lang.Long.parseLong(r7)     // Catch: java.lang.Throwable -> L66
            r9 = 14
            r9 = r14[r9]     // Catch: java.lang.Throwable -> L66
            long r9 = java.lang.Long.parseLong(r9)     // Catch: java.lang.Throwable -> L66
            r11 = 16
            r14 = r14[r11]     // Catch: java.lang.Throwable -> L66
            long r11 = java.lang.Long.parseLong(r14)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m1$a r14 = com.google.android.gms.internal.p000firebaseperf.m1.w()     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m1$a r14 = r14.p(r3)     // Catch: java.lang.Throwable -> L66
            long r9 = r9 + r11
            long r3 = r13.j(r9)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m1$a r14 = r14.o(r3)     // Catch: java.lang.Throwable -> L66
            long r5 = r5 + r7
            long r3 = r13.j(r5)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m1$a r14 = r14.q(r3)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.v5 r14 = r14.O()     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m4 r14 = (com.google.android.gms.internal.p000firebaseperf.m4) r14     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.firebase-perf.m1 r14 = (com.google.android.gms.internal.p000firebaseperf.m1) r14     // Catch: java.lang.Throwable -> L66
            r2.close()     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
            return r14
        L66:
            r14 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L6b
            goto L6f
        L6b:
            r2 = move-exception
            com.google.android.gms.internal.p000firebaseperf.u8.a(r14, r2)     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
        L6f:
            throw r14     // Catch: java.lang.NullPointerException -> L70 java.lang.NumberFormatException -> L72 java.lang.ArrayIndexOutOfBoundsException -> L74 java.io.IOException -> L93
        L70:
            r14 = move-exception
            goto L75
        L72:
            r14 = move-exception
            goto L75
        L74:
            r14 = move-exception
        L75:
            java.lang.String r2 = "Unexpected '/proc/[pid]/stat' file format encountered: "
            java.lang.String r14 = r14.getMessage()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r3 = r14.length()
            if (r3 == 0) goto L8a
            java.lang.String r14 = r2.concat(r14)
            goto L8f
        L8a:
            java.lang.String r14 = new java.lang.String
            r14.<init>(r2)
        L8f:
            android.util.Log.w(r0, r14)
            goto Lb1
        L93:
            r14 = move-exception
            java.lang.String r2 = "Unable to read 'proc/[pid]/stat' file: "
            java.lang.String r14 = r14.getMessage()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            int r3 = r14.length()
            if (r3 == 0) goto La9
            java.lang.String r14 = r2.concat(r14)
            goto Lae
        La9:
            java.lang.String r14 = new java.lang.String
            r14.<init>(r2)
        Lae:
            android.util.Log.w(r0, r14)
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.c0.g(com.google.android.gms.internal.firebase-perf.y0):com.google.android.gms.internal.firebase-perf.m1");
    }

    private final long j(long j2) {
        return Math.round((j2 / this.f6695f) * a);
    }

    public static boolean k(long j2) {
        return j2 <= 0;
    }

    public final void a(long j2, y0 y0Var) {
        long j3 = this.f6695f;
        if (j3 == -1 || j3 == 0 || k(j2)) {
            return;
        }
        if (this.f6692c != null) {
            if (this.f6694e != j2) {
                f();
                c(j2, y0Var);
                return;
            }
            return;
        }
        c(j2, y0Var);
    }

    public final void b(y0 y0Var) {
        d(y0Var);
    }

    public final void f() {
        ScheduledFuture scheduledFuture = this.f6692c;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f6692c = null;
        this.f6694e = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(y0 y0Var) {
        m1 g2 = g(y0Var);
        if (g2 != null) {
            this.f6697h.add(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(y0 y0Var) {
        m1 g2 = g(y0Var);
        if (g2 != null) {
            this.f6697h.add(g2);
        }
    }
}
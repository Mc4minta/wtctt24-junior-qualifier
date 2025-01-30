package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class h {
    private static volatile Handler a;

    /* renamed from: b  reason: collision with root package name */
    private final z5 f7617b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f7618c;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f7619d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(z5 z5Var) {
        com.google.android.gms.common.internal.t.k(z5Var);
        this.f7617b = z5Var;
        this.f7618c = new k(this, z5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(h hVar, long j2) {
        hVar.f7619d = 0L;
        return 0L;
    }

    private final Handler f() {
        Handler handler;
        if (a != null) {
            return a;
        }
        synchronized (h.class) {
            if (a == null) {
                a = new com.google.android.gms.internal.measurement.g8(this.f7617b.h().getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    public abstract void b();

    public final void c(long j2) {
        e();
        if (j2 >= 0) {
            this.f7619d = this.f7617b.i().a();
            if (f().postDelayed(this.f7618c, j2)) {
                return;
            }
            this.f7617b.f().H().b("Failed to schedule delayed post. time", Long.valueOf(j2));
        }
    }

    public final boolean d() {
        return this.f7619d != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.f7619d = 0L;
        f().removeCallbacks(this.f7618c);
    }
}
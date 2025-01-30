package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class c9 {
    final /* synthetic */ u8 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c9(u8 u8Var) {
        this.a = u8Var;
    }

    private final void c(long j2, boolean z) {
        this.a.d();
        if (this.a.a.q()) {
            this.a.n().w.b(j2);
            this.a.f().P().b("Session started, time", Long.valueOf(this.a.i().b()));
            Long valueOf = Long.valueOf(j2 / 1000);
            this.a.q().V("auto", "_sid", valueOf, j2);
            this.a.n().s.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.a.o().u(r.t0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.a.q().P("auto", "_s", j2, bundle);
            if (com.google.android.gms.internal.measurement.e9.b() && this.a.o().u(r.y0)) {
                String a = this.a.n().B.a();
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a);
                this.a.q().P("auto", "_ssr", j2, bundle2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.a.d();
        if (this.a.n().x(this.a.i().a())) {
            this.a.n().s.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.a.f().P().a("Detected application was in foreground");
                c(this.a.i().a(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j2, boolean z) {
        this.a.d();
        this.a.G();
        if (this.a.n().x(j2)) {
            this.a.n().s.a(true);
        }
        this.a.n().w.b(j2);
        if (this.a.n().s.b()) {
            c(j2, z);
        }
    }
}
package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class e9 extends k9 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f7569d;

    /* renamed from: e  reason: collision with root package name */
    private final h f7570e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f7571f;

    /* JADX INFO: Access modifiers changed from: protected */
    public e9(j9 j9Var) {
        super(j9Var);
        this.f7569d = (AlarmManager) h().getSystemService("alarm");
        this.f7570e = new h9(this, j9Var.f0(), j9Var);
    }

    private final int A() {
        if (this.f7571f == null) {
            String valueOf = String.valueOf(h().getPackageName());
            this.f7571f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f7571f.intValue();
    }

    private final PendingIntent B() {
        Context h2 = h();
        return PendingIntent.getBroadcast(h2, 0, new Intent().setClassName(h2, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @TargetApi(24)
    private final void z() {
        ((JobScheduler) h().getSystemService("jobscheduler")).cancel(A());
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ aa p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ r9 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ e r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.g9
    public final /* bridge */ /* synthetic */ w4 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        this.f7569d.cancel(B());
        if (Build.VERSION.SDK_INT >= 24) {
            z();
            return false;
        }
        return false;
    }

    public final void x(long j2) {
        u();
        g();
        Context h2 = h();
        if (!u4.b(h2)) {
            f().O().a("Receiver not registered/enabled");
        }
        if (!v9.X(h2, false)) {
            f().O().a("Service not registered/enabled");
        }
        y();
        f().P().b("Scheduling upload, millis", Long.valueOf(j2));
        long b2 = i().b() + j2;
        if (j2 < Math.max(0L, r.y.a(null).longValue()) && !this.f7570e.d()) {
            this.f7570e.c(j2);
        }
        g();
        if (Build.VERSION.SDK_INT >= 24) {
            Context h3 = h();
            ComponentName componentName = new ComponentName(h3, "com.google.android.gms.measurement.AppMeasurementJobService");
            int A = A();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            com.google.android.gms.internal.measurement.h6.b(h3, new JobInfo.Builder(A, componentName).setMinimumLatency(j2).setOverrideDeadline(j2 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        this.f7569d.setInexactRepeating(2, b2, Math.max(r.t.a(null).longValue(), j2), B());
    }

    public final void y() {
        u();
        f().P().a("Unscheduling upload");
        this.f7569d.cancel(B());
        this.f7570e.e();
        if (Build.VERSION.SDK_INT >= 24) {
            z();
        }
    }
}
package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.v8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class r8<T extends Context & v8> {
    private final T a;

    public r8(T t) {
        com.google.android.gms.common.internal.t.k(t);
        this.a = t;
    }

    private final void f(Runnable runnable) {
        j9 c2 = j9.c(this.a);
        c2.l().A(new s8(this, c2, runnable));
    }

    private final x3 j() {
        return b5.a(this.a, null, null).f();
    }

    public final int a(final Intent intent, int i2, final int i3) {
        b5 a = b5.a(this.a, null, null);
        final x3 f2 = a.f();
        if (intent == null) {
            f2.K().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a.g();
        f2.P().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            f(new Runnable(this, i3, f2, intent) { // from class: com.google.android.gms.measurement.internal.q8
                private final r8 a;

                /* renamed from: b  reason: collision with root package name */
                private final int f7820b;

                /* renamed from: c  reason: collision with root package name */
                private final x3 f7821c;

                /* renamed from: d  reason: collision with root package name */
                private final Intent f7822d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f7820b = i3;
                    this.f7821c = f2;
                    this.f7822d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(this.f7820b, this.f7821c, this.f7822d);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            j().H().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new h5(j9.c(this.a));
        }
        j().K().b("onBind received unknown action", action);
        return null;
    }

    public final void c() {
        b5 a = b5.a(this.a, null, null);
        x3 f2 = a.f();
        a.g();
        f2.P().a("Local AppMeasurementService is starting up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(int i2, x3 x3Var, Intent intent) {
        if (this.a.f(i2)) {
            x3Var.P().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            j().P().a("Completed wakeful intent.");
            this.a.a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(x3 x3Var, JobParameters jobParameters) {
        x3Var.P().a("AppMeasurementJobService processed last upload request.");
        this.a.b(jobParameters, false);
    }

    @TargetApi(24)
    public final boolean g(final JobParameters jobParameters) {
        b5 a = b5.a(this.a, null, null);
        final x3 f2 = a.f();
        String string = jobParameters.getExtras().getString("action");
        a.g();
        f2.P().b("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            f(new Runnable(this, f2, jobParameters) { // from class: com.google.android.gms.measurement.internal.t8
                private final r8 a;

                /* renamed from: b  reason: collision with root package name */
                private final x3 f7871b;

                /* renamed from: c  reason: collision with root package name */
                private final JobParameters f7872c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f7871b = f2;
                    this.f7872c = jobParameters;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(this.f7871b, this.f7872c);
                }
            });
            return true;
        }
        return true;
    }

    public final void h() {
        b5 a = b5.a(this.a, null, null);
        x3 f2 = a.f();
        a.g();
        f2.P().a("Local AppMeasurementService is shutting down");
    }

    public final boolean i(Intent intent) {
        if (intent == null) {
            j().H().a("onUnbind called with null intent");
            return true;
        }
        j().P().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void k(Intent intent) {
        if (intent == null) {
            j().H().a("onRebind called with null intent");
            return;
        }
        j().P().b("onRebind called. action", intent.getAction());
    }
}
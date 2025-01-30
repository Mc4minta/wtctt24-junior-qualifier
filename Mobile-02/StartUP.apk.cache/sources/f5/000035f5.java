package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.r8;
import com.google.android.gms.measurement.internal.v8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
@TargetApi(24)
/* loaded from: classes2.dex */
public final class AppMeasurementJobService extends JobService implements v8 {
    private r8<AppMeasurementJobService> a;

    private final r8<AppMeasurementJobService> c() {
        if (this.a == null) {
            this.a = new r8<>(this);
        }
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.v8
    public final void a(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.v8
    @TargetApi(24)
    public final void b(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.v8
    public final boolean f(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        c().c();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        c().h();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        c().k(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return c().g(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return c().i(intent);
    }
}
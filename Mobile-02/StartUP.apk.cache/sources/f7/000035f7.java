package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import c.n.a.a;
import com.google.android.gms.measurement.internal.r8;
import com.google.android.gms.measurement.internal.v8;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements v8 {
    private r8<AppMeasurementService> a;

    private final r8<AppMeasurementService> c() {
        if (this.a == null) {
            this.a = new r8<>(this);
        }
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.v8
    public final void a(Intent intent) {
        a.b(intent);
    }

    @Override // com.google.android.gms.measurement.internal.v8
    public final void b(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.v8
    public final boolean f(int i2) {
        return stopSelfResult(i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return c().b(intent);
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        return c().a(intent, i2, i3);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return c().i(intent);
    }
}
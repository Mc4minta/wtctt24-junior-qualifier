package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rc;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
/* loaded from: classes2.dex */
final class i9 implements Runnable {
    private final /* synthetic */ rc a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f7652b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i9(AppMeasurementDynamiteService appMeasurementDynamiteService, rc rcVar) {
        this.f7652b = appMeasurementDynamiteService;
        this.a = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7652b.a.H().T(this.a, this.f7652b.a.p());
    }
}
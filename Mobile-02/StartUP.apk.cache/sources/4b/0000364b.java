package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rc;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
/* loaded from: classes2.dex */
final class g6 implements Runnable {
    private final /* synthetic */ rc a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f7604b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g6(AppMeasurementDynamiteService appMeasurementDynamiteService, rc rcVar) {
        this.f7604b = appMeasurementDynamiteService;
        this.a = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7604b.a.Q().G(this.a);
    }
}
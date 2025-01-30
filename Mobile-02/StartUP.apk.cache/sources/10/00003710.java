package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rc;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
/* loaded from: classes2.dex */
final class x9 implements Runnable {
    private final /* synthetic */ rc a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7943b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7944c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f7945d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x9(AppMeasurementDynamiteService appMeasurementDynamiteService, rc rcVar, String str, String str2) {
        this.f7945d = appMeasurementDynamiteService;
        this.a = rcVar;
        this.f7943b = str;
        this.f7944c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7945d.a.Q().I(this.a, this.f7943b, this.f7944c);
    }
}
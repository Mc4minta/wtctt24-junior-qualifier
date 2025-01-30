package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rc;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
/* loaded from: classes2.dex */
final class g7 implements Runnable {
    private final /* synthetic */ rc a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7605b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7606c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f7607d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f7608e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7(AppMeasurementDynamiteService appMeasurementDynamiteService, rc rcVar, String str, String str2, boolean z) {
        this.f7608e = appMeasurementDynamiteService;
        this.a = rcVar;
        this.f7605b = str;
        this.f7606c = str2;
        this.f7607d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7608e.a.Q().J(this.a, this.f7605b, this.f7606c, this.f7607d);
    }
}
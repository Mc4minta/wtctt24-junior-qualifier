package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.rc;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
/* loaded from: classes2.dex */
final class h8 implements Runnable {
    private final /* synthetic */ rc a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ p f7623b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f7624c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f7625d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h8(AppMeasurementDynamiteService appMeasurementDynamiteService, rc rcVar, p pVar, String str) {
        this.f7625d = appMeasurementDynamiteService;
        this.a = rcVar;
        this.f7623b = pVar;
        this.f7624c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7625d.a.Q().H(this.a, this.f7623b, this.f7624c);
    }
}
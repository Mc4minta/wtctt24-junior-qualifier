package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class f {
    private a.b a;

    /* renamed from: b  reason: collision with root package name */
    private AppMeasurement f8592b;

    /* renamed from: c  reason: collision with root package name */
    private e f8593c;

    public f(AppMeasurement appMeasurement, a.b bVar) {
        this.a = bVar;
        this.f8592b = appMeasurement;
        e eVar = new e(this);
        this.f8593c = eVar;
        this.f8592b.b(eVar);
    }
}
package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class d {
    Set<String> a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f8589b;

    /* renamed from: c  reason: collision with root package name */
    private AppMeasurement f8590c;

    /* renamed from: d  reason: collision with root package name */
    private c f8591d;

    public d(AppMeasurement appMeasurement, a.b bVar) {
        this.f8589b = bVar;
        this.f8590c = appMeasurement;
        c cVar = new c(this);
        this.f8591d = cVar;
        this.f8590c.b(cVar);
        this.a = new HashSet();
    }
}
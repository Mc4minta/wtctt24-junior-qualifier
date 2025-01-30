package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class c implements AppMeasurement.a {
    private final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.gms.measurement.internal.f6
    public final void a(String str, String str2, Bundle bundle, long j2) {
        a.b bVar;
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", a.j(str2));
            bVar = this.a.f8589b;
            bVar.c(2, bundle2);
        }
    }
}
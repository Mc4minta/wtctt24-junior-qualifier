package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.coinbase.ApiConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class e implements AppMeasurement.a {
    private final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.gms.measurement.internal.f6
    public final void a(String str, String str2, Bundle bundle, long j2) {
        a.b bVar;
        if (str == null || str.equals("crash") || !a.i(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(ApiConstants.NAME, str2);
        bundle2.putLong("timestampInMillis", j2);
        bundle2.putBundle("params", bundle);
        bVar = this.a.a;
        bVar.c(3, bundle2);
    }
}
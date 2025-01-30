package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import c.n.a.a;
import com.google.android.gms.measurement.internal.u4;
import com.google.android.gms.measurement.internal.x4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends a implements x4 {

    /* renamed from: c  reason: collision with root package name */
    private u4 f7473c;

    @Override // com.google.android.gms.measurement.internal.x4
    public final void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f7473c == null) {
            this.f7473c = new u4(this);
        }
        this.f7473c.a(context, intent);
    }
}
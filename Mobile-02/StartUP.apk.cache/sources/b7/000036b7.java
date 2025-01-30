package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class p8 implements Runnable {
    private final /* synthetic */ l8 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p8(l8 l8Var) {
        this.a = l8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s7 s7Var = this.a.f7748c;
        Context h2 = this.a.f7748c.h();
        this.a.f7748c.g();
        s7Var.F(new ComponentName(h2, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
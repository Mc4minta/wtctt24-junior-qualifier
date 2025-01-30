package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u4 {
    private final x4 a;

    public u4(x4 x4Var) {
        com.google.android.gms.common.internal.t.k(x4Var);
        this.a = x4Var;
    }

    public static boolean b(Context context) {
        ActivityInfo receiverInfo;
        com.google.android.gms.common.internal.t.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        b5 a = b5.a(context, null, null);
        x3 f2 = a.f();
        if (intent == null) {
            f2.K().a("Receiver called with null intent");
            return;
        }
        a.g();
        String action = intent.getAction();
        f2.P().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            f2.P().a("Starting wakeful intent.");
            this.a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            f2.K().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
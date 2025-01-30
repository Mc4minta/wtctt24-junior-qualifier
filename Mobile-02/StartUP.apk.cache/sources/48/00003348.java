package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c1  reason: invalid package */
/* loaded from: classes2.dex */
public final class c1 {
    private static Boolean a;

    public static boolean a(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            a = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.d("isEnabled", valueOf2.length() != 0 ? "No perf logcat meta data found ".concat(valueOf2) : new String("No perf logcat meta data found "));
            return false;
        }
    }
}
package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.net.URI;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.a1  reason: invalid package */
/* loaded from: classes2.dex */
public final class a1 {
    private static String[] a;

    public static boolean a(URI uri, Context context) {
        String[] strArr;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier > 0) {
            Log.i("FirebasePerformance", "Detected domain whitelist, only whitelisted domains will be measured.");
            if (a == null) {
                a = resources.getStringArray(identifier);
            }
            for (String str : a) {
                String host = uri.getHost();
                if (host == null || host.contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
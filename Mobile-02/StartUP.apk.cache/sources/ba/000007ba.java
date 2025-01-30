package com.bugsnag.android;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
final class q0 {
    private static volatile boolean a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        if (a) {
            Log.i("Bugsnag", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(String str) {
        if (a) {
            Log.w("Bugsnag", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, Throwable th) {
        if (a) {
            Log.w("Bugsnag", str, th);
        }
    }
}
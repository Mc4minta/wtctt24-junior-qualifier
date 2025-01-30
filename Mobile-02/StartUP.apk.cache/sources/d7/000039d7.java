package com.google.firebase.crashlytics.c.g;

import android.content.Context;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class x {
    private String a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        if (this.a == null) {
            this.a = b(context);
        }
        return "".equals(this.a) ? null : this.a;
    }
}
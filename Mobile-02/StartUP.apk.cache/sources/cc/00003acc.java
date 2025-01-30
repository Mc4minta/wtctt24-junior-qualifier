package com.google.firebase.f;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
class d {
    private static d a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f9104b;

    private d(Context context) {
        this.f9104b = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean b(long j2) {
        return c("fire-global", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean c(String str, long j2) {
        if (this.f9104b.contains(str)) {
            if (j2 - this.f9104b.getLong(str, -1L) >= 86400000) {
                this.f9104b.edit().putLong(str, j2).apply();
                return true;
            }
            return false;
        }
        this.f9104b.edit().putLong(str, j2).apply();
        return true;
    }
}
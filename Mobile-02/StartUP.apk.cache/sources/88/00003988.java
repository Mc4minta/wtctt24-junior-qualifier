package com.google.firebase.crashlytics.c.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
class e {
    private final Float a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8673b;

    private e(Float f2, boolean z) {
        this.f8673b = z;
        this.a = f2;
    }

    public static e a(Context context) {
        boolean z;
        Float f2 = null;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            z = e(registerReceiver);
            f2 = d(registerReceiver);
        } else {
            z = false;
        }
        return new e(f2, z);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.a;
    }

    public int c() {
        Float f2;
        if (!this.f8673b || (f2 = this.a) == null) {
            return 1;
        }
        return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
    }
}
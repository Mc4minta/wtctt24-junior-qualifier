package com.amplitude.api;

import android.util.Log;

/* compiled from: AmplitudeLog.java */
/* loaded from: classes.dex */
public class d {
    protected static d a = new d();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f3543b = true;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f3544c = 4;

    private d() {
    }

    public static d d() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, String str2) {
        if (!this.f3543b || this.f3544c > 3) {
            return 0;
        }
        return Log.d(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str, String str2) {
        if (!this.f3543b || this.f3544c > 6) {
            return 0;
        }
        return Log.e(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(String str, String str2, Throwable th) {
        if (!this.f3543b || this.f3544c > 6) {
            return 0;
        }
        return Log.e(str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(String str, String str2) {
        if (!this.f3543b || this.f3544c > 4) {
            return 0;
        }
        return Log.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(String str, String str2) {
        if (!this.f3543b || this.f3544c > 5) {
            return 0;
        }
        return Log.w(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(String str, Throwable th) {
        if (!this.f3543b || this.f3544c > 5) {
            return 0;
        }
        return Log.w(str, th);
    }
}
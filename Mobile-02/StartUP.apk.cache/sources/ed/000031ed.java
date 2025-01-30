package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class j {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6247b;

    public j(String str, String str2) {
        t.l(str, "log tag cannot be null");
        t.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        if (str2 != null && str2.length() > 0) {
            this.f6247b = str2;
        } else {
            this.f6247b = null;
        }
    }

    private final String f(String str) {
        String str2 = this.f6247b;
        return str2 == null ? str : str2.concat(str);
    }

    public final boolean a(int i2) {
        return Log.isLoggable(this.a, i2);
    }

    public final void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, f(str2));
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, f(str2), th);
        }
    }

    public final void d(String str, String str2) {
        if (a(2)) {
            Log.v(str, f(str2));
        }
    }

    public final void e(String str, String str2) {
        if (a(5)) {
            Log.w(str, f(str2));
        }
    }

    public j(String str) {
        this(str, null);
    }
}
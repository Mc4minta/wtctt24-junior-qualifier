package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.c;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.d0  reason: invalid package */
/* loaded from: classes2.dex */
public final class d0 {
    private static d0 a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f6704b;

    /* renamed from: c  reason: collision with root package name */
    private k0 f6705c = k0.a();

    private d0() {
    }

    public static synchronized d0 f() {
        d0 d0Var;
        synchronized (d0.class) {
            if (a == null) {
                a = new d0();
            }
            d0Var = a;
        }
        return d0Var;
    }

    private static Context g() {
        try {
            c.h();
            return c.h().g();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final boolean a(String str, float f2) {
        if (str == null) {
            this.f6705c.c("Key is null when setting float value on device cache.");
            return false;
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return false;
            }
        }
        this.f6704b.edit().putFloat(str, f2).apply();
        return true;
    }

    public final boolean b(String str, long j2) {
        if (str == null) {
            this.f6705c.c("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return false;
            }
        }
        this.f6704b.edit().putLong(str, j2).apply();
        return true;
    }

    public final boolean c(String str, String str2) {
        if (str == null) {
            this.f6705c.c("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.f6704b.edit().remove(str).apply();
            return true;
        }
        this.f6704b.edit().putString(str, str2).apply();
        return true;
    }

    public final boolean d(String str, boolean z) {
        if (str == null) {
            this.f6705c.c("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return false;
            }
        }
        this.f6704b.edit().putBoolean(str, z).apply();
        return true;
    }

    public final p0<Boolean> e(String str) {
        if (str == null) {
            this.f6705c.c("Key is null when getting boolean value on device cache.");
            return p0.e();
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return p0.e();
            }
        }
        if (!this.f6704b.contains(str)) {
            return p0.e();
        }
        try {
            return p0.c(Boolean.valueOf(this.f6704b.getBoolean(str, false)));
        } catch (ClassCastException e2) {
            this.f6705c.c(String.format("Key %s from sharedPreferences has type other than long: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final p0<String> h(String str) {
        if (str == null) {
            this.f6705c.c("Key is null when getting String value on device cache.");
            return p0.e();
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return p0.e();
            }
        }
        if (!this.f6704b.contains(str)) {
            return p0.e();
        }
        try {
            return p0.c(this.f6704b.getString(str, ""));
        } catch (ClassCastException e2) {
            this.f6705c.c(String.format("Key %s from sharedPreferences has type other than String: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final p0<Float> i(String str) {
        if (str == null) {
            this.f6705c.c("Key is null when getting float value on device cache.");
            return p0.e();
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return p0.e();
            }
        }
        if (!this.f6704b.contains(str)) {
            return p0.e();
        }
        try {
            return p0.c(Float.valueOf(this.f6704b.getFloat(str, 0.0f)));
        } catch (ClassCastException e2) {
            this.f6705c.c(String.format("Key %s from sharedPreferences has type other than float: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final synchronized void j(Context context) {
        if (this.f6704b == null && context != null) {
            this.f6704b = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public final p0<Long> k(String str) {
        if (str == null) {
            this.f6705c.c("Key is null when getting long value on device cache.");
            return p0.e();
        }
        if (this.f6704b == null) {
            j(g());
            if (this.f6704b == null) {
                return p0.e();
            }
        }
        if (!this.f6704b.contains(str)) {
            return p0.e();
        }
        try {
            return p0.c(Long.valueOf(this.f6704b.getLong(str, 0L)));
        } catch (ClassCastException e2) {
            this.f6705c.c(String.format("Key %s from sharedPreferences has type other than long: %s", str, e2.getMessage()));
            return p0.e();
        }
    }
}
package e.j.f;

import android.content.SharedPreferences;

/* compiled from: SharedPrefsExtensions.kt */
/* loaded from: classes2.dex */
public final class s {
    public static final void a(SharedPreferences sharedPreferences, String key, boolean z) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        sharedPreferences.edit().putBoolean(key, z).apply();
    }

    public static final void b(SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        sharedPreferences.edit().clear().apply();
    }

    public static final void c(SharedPreferences sharedPreferences, String key, int i2) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        sharedPreferences.edit().putInt(key, i2).apply();
    }

    public static final void d(SharedPreferences sharedPreferences, String key, String str) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        sharedPreferences.edit().putString(key, str).apply();
    }

    public static final boolean e(SharedPreferences sharedPreferences, String key, int i2) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        return sharedPreferences.edit().putInt(key, i2).commit();
    }

    public static final boolean f(SharedPreferences sharedPreferences, String key, String str) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        return sharedPreferences.edit().putString(key, str).commit();
    }

    public static final String g(SharedPreferences sharedPreferences, String key) {
        kotlin.jvm.internal.m.g(sharedPreferences, "<this>");
        kotlin.jvm.internal.m.g(key, "key");
        return sharedPreferences.getString(key, null);
    }
}
package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class u {
    private static final Class<?> a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6569b;

    static {
        f6569b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return (a == null || f6569b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> c() {
        return a;
    }
}
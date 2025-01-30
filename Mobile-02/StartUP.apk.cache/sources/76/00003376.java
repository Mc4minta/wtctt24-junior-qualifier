package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.g3  reason: invalid package */
/* loaded from: classes2.dex */
final class g3 {
    private static final Class<?> a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6721b;

    static {
        f6721b = a("org.robolectric.Robolectric") != null;
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
        return (a == null || f6721b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> c() {
        return a;
    }
}
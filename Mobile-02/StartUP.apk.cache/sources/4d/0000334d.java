package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c6  reason: invalid package */
/* loaded from: classes2.dex */
final class c6 {
    private static final a6 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final a6 f6698b = new e6();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a6 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a6 b() {
        return f6698b;
    }

    private static a6 c() {
        try {
            return (a6) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
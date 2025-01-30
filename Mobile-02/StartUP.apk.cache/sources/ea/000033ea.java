package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.q5  reason: invalid package */
/* loaded from: classes2.dex */
final class q5 {
    private static final o5 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final o5 f6897b = new r5();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o5 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o5 b() {
        return f6897b;
    }

    private static o5 c() {
        try {
            return (o5) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
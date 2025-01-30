package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.f4  reason: invalid package */
/* loaded from: classes2.dex */
final class f4 {
    private static final c4<?> a = new b4();

    /* renamed from: b  reason: collision with root package name */
    private static final c4<?> f6718b = a();

    private static c4<?> a() {
        try {
            return (c4) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c4<?> b() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c4<?> c() {
        c4<?> c4Var = f6718b;
        if (c4Var != null) {
            return c4Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class f2 {
    private static final d2 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final d2 f6430b = new e2();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d2 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d2 b() {
        return f6430b;
    }

    private static d2 c() {
        try {
            return (d2) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
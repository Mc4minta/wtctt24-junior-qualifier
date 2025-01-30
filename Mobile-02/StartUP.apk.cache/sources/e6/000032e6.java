package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class r2 {
    private static final p2 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final p2 f6544b = new q2();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p2 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p2 b() {
        return f6544b;
    }

    private static p2 c() {
        try {
            return (p2) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
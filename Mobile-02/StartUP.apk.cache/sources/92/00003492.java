package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class d6 {
    private static final b6 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final b6 f7098b = new e6();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b6 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b6 b() {
        return f7098b;
    }

    private static b6 c() {
        try {
            return (b6) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class d4 {
    private static final b4<?> a = new a4();

    /* renamed from: b  reason: collision with root package name */
    private static final b4<?> f7096b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b4<?> a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b4<?> b() {
        b4<?> b4Var = f7096b;
        if (b4Var != null) {
            return b4Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static b4<?> c() {
        try {
            return (b4) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class t5 {
    private static final r5 a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final r5 f7349b = new q5();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r5 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r5 b() {
        return f7349b;
    }

    private static r5 c() {
        try {
            return (r5) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
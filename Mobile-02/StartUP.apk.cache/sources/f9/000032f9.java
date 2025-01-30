package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class u0 {
    private static final r0<?> a = new s0();

    /* renamed from: b  reason: collision with root package name */
    private static final r0<?> f6570b = a();

    private static r0<?> a() {
        try {
            return (r0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0<?> b() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r0<?> c() {
        r0<?> r0Var = f6570b;
        if (r0Var != null) {
            return r0Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
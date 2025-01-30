package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class p0 {
    private static final Class<?> a = a();

    private static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static q0 b() {
        Class<?> cls = a;
        if (cls != null) {
            try {
                return (q0) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return q0.f6537b;
    }
}
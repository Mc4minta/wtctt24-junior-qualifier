package com.google.protobuf;

/* compiled from: ExtensionRegistryFactory.java */
/* loaded from: classes2.dex */
final class g {
    static final Class<?> a = c();

    public static h a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return h.f9705b;
    }

    private static final h b(String str) throws Exception {
        return (h) a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
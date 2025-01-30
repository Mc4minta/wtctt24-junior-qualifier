package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u2 {
    private static final u2 a = new u2();

    /* renamed from: b  reason: collision with root package name */
    private final a3 f6572b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, z2<?>> f6573c = new ConcurrentHashMap();

    private u2() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        a3 a3Var = null;
        for (int i2 = 0; i2 <= 0; i2++) {
            a3Var = c(strArr[0]);
            if (a3Var != null) {
                break;
            }
        }
        this.f6572b = a3Var == null ? new x1() : a3Var;
    }

    public static u2 a() {
        return a;
    }

    private static a3 c(String str) {
        try {
            return (a3) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> z2<T> b(Class<T> cls) {
        g1.e(cls, "messageType");
        z2<T> z2Var = (z2<T>) this.f6573c.get(cls);
        if (z2Var == null) {
            z2<T> a2 = this.f6572b.a(cls);
            g1.e(cls, "messageType");
            g1.e(a2, "schema");
            z2<T> z2Var2 = (z2<T>) this.f6573c.putIfAbsent(cls, a2);
            return z2Var2 != null ? z2Var2 : a2;
        }
        return z2Var;
    }

    public final <T> z2<T> d(T t) {
        return b(t.getClass());
    }
}
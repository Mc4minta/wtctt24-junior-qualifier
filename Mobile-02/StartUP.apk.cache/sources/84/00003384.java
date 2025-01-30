package com.google.android.gms.internal.p000firebaseperf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h6  reason: invalid package */
/* loaded from: classes2.dex */
public final class h6 {
    private static final h6 a = new h6();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, m6<?>> f6733c = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final l6 f6732b = new i5();

    private h6() {
    }

    public static h6 b() {
        return a;
    }

    public final <T> m6<T> a(Class<T> cls) {
        n4.b(cls, "messageType");
        m6<T> m6Var = (m6<T>) this.f6733c.get(cls);
        if (m6Var == null) {
            m6<T> a2 = this.f6732b.a(cls);
            n4.b(cls, "messageType");
            n4.b(a2, "schema");
            m6<T> m6Var2 = (m6<T>) this.f6733c.putIfAbsent(cls, a2);
            return m6Var2 != null ? m6Var2 : a2;
        }
        return m6Var;
    }

    public final <T> m6<T> c(T t) {
        return a(t.getClass());
    }
}
package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class j6 {
    private static final j6 a = new j6();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, m6<?>> f7199c = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final l6 f7198b = new l5();

    private j6() {
    }

    public static j6 a() {
        return a;
    }

    public final <T> m6<T> b(Class<T> cls) {
        q4.f(cls, "messageType");
        m6<T> m6Var = (m6<T>) this.f7199c.get(cls);
        if (m6Var == null) {
            m6<T> a2 = this.f7198b.a(cls);
            q4.f(cls, "messageType");
            q4.f(a2, "schema");
            m6<T> m6Var2 = (m6<T>) this.f7199c.putIfAbsent(cls, a2);
            return m6Var2 != null ? m6Var2 : a2;
        }
        return m6Var;
    }

    public final <T> m6<T> c(T t) {
        return b(t.getClass());
    }
}
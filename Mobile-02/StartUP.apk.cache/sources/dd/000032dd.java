package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q0 {
    private static final Class<?> a = a();

    /* renamed from: b  reason: collision with root package name */
    static final q0 f6537b = new q0(true);

    /* renamed from: c  reason: collision with root package name */
    private final Map<Object, ?> f6538c;

    q0() {
        this.f6538c = new HashMap();
    }

    private q0(boolean z) {
        this.f6538c = Collections.emptyMap();
    }

    private static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static q0 b() {
        return p0.b();
    }
}
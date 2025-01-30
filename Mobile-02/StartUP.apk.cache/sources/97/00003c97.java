package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ExtensionRegistryLite.java */
/* loaded from: classes2.dex */
public class h {
    private static final Class<?> a = b();

    /* renamed from: b  reason: collision with root package name */
    static final h f9705b = new h(true);

    /* renamed from: c  reason: collision with root package name */
    private final Map<?, ?> f9706c;

    h() {
        this.f9706c = new HashMap();
    }

    public static h a() {
        return g.a();
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    h(boolean z) {
        this.f9706c = Collections.emptyMap();
    }
}
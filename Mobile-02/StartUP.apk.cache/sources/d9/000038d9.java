package com.google.common.collect;

import java.util.Map;

/* compiled from: ImmutableBiMap.java */
/* loaded from: classes2.dex */
public abstract class i<K, V> extends m<K, V> implements Map {
    public static <K, V> i<K, V> q() {
        return c0.f8460e;
    }

    public static <K, V> i<K, V> r(K k2, V v) {
        return new h0(k2, v);
    }

    public abstract i<V, K> p();

    @Override // com.google.common.collect.m, java.util.Map
    /* renamed from: s */
    public r<V> values() {
        return p().keySet();
    }
}
package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* loaded from: classes2.dex */
final class n1<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, l1> a;

    private n1(Map.Entry<K, l1> entry) {
        this.a = entry;
    }

    public final l1 a() {
        return this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.a.getValue() == null) {
            return null;
        }
        return l1.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof i2) {
            return this.a.getValue().c((i2) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
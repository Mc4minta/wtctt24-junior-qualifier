package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.x4  reason: invalid package */
/* loaded from: classes2.dex */
final class x4<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, v4> a;

    private x4(Map.Entry<K, v4> entry) {
        this.a = entry;
    }

    public final v4 a() {
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
        return v4.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof v5) {
            return this.a.getValue().d((v5) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
package com.google.common.collect;

import java.io.Serializable;

/* compiled from: ImmutableEntry.java */
/* loaded from: classes2.dex */
class k<K, V> extends b<K, V> implements Serializable {
    final K a;

    /* renamed from: b  reason: collision with root package name */
    final V f8484b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(K k2, V v) {
        this.a = k2;
        this.f8484b = v;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final K getKey() {
        return this.a;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final V getValue() {
        return this.f8484b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
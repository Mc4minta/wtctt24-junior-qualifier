package com.google.common.collect;

import com.google.common.collect.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapKeySet.java */
/* loaded from: classes2.dex */
public final class p<K, V> extends r.a<K> {

    /* renamed from: b  reason: collision with root package name */
    private final m<K, V> f8498b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m<K, V> mVar) {
        this.f8498b = mVar;
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f8498b.containsKey(obj);
    }

    @Override // com.google.common.collect.r.a
    K get(int i2) {
        return this.f8498b.entrySet().i().get(i2).getKey();
    }

    @Override // com.google.common.collect.r.a, com.google.common.collect.r, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: p */
    public l0<K> iterator() {
        return this.f8498b.j();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8498b.size();
    }
}
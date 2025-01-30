package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapValues.java */
/* loaded from: classes2.dex */
public final class q<K, V> extends j<V> {
    private final m<K, V> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmutableMapValues.java */
    /* loaded from: classes2.dex */
    public class a extends l0<V> {
        final l0<Map.Entry<K, V>> a;

        a() {
            this.a = q.this.a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.a.next().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m<K, V> mVar) {
        this.a = mVar;
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return obj != null && s.c(iterator(), obj);
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: k */
    public l0<V> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.a.size();
    }
}
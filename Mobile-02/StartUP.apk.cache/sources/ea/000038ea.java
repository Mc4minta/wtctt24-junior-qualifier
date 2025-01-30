package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapEntrySet.java */
/* loaded from: classes2.dex */
public abstract class o<K, V> extends r<Map.Entry<K, V>> {

    /* compiled from: ImmutableMapEntrySet.java */
    /* loaded from: classes2.dex */
    static final class a<K, V> extends o<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private final transient m<K, V> f8496b;

        /* renamed from: c  reason: collision with root package name */
        private final transient Map.Entry<K, V>[] f8497c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(m<K, V> mVar, Map.Entry<K, V>[] entryArr) {
            this.f8496b = mVar;
            this.f8497c = entryArr;
        }

        @Override // com.google.common.collect.r
        l<Map.Entry<K, V>> m() {
            return new b0(this, this.f8497c);
        }

        @Override // com.google.common.collect.r, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: p */
        public l0<Map.Entry<K, V>> iterator() {
            return s.f(this.f8497c);
        }

        @Override // com.google.common.collect.o
        m<K, V> t() {
            return this.f8496b;
        }
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            V v = t().get(entry.getKey());
            return v != null && v.equals(entry.getValue());
        }
        return false;
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public int hashCode() {
        return t().hashCode();
    }

    @Override // com.google.common.collect.r
    boolean o() {
        return t().i();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return t().size();
    }

    abstract m<K, V> t();
}
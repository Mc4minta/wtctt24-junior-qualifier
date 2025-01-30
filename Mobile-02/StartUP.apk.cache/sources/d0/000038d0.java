package com.google.common.collect;

import com.google.common.collect.n;
import com.google.common.collect.o;
import com.google.common.collect.r;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableMap.java */
/* loaded from: classes2.dex */
public final class e0<K, V> extends m<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private final transient Map.Entry<K, V>[] f8470e;

    /* renamed from: f  reason: collision with root package name */
    private final transient n<K, V>[] f8471f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f8472g;

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes2.dex */
    private static final class a<K, V> extends r.a<K> {

        /* renamed from: b  reason: collision with root package name */
        private final e0<K, V> f8473b;

        a(e0<K, V> e0Var) {
            this.f8473b = e0Var;
        }

        @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f8473b.containsKey(obj);
        }

        @Override // com.google.common.collect.r.a
        K get(int i2) {
            return (K) ((e0) this.f8473b).f8470e[i2].getKey();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f8473b.size();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes2.dex */
    private static final class b<K, V> extends l<V> {
        final e0<K, V> a;

        b(e0<K, V> e0Var) {
            this.a = e0Var;
        }

        @Override // java.util.List
        public V get(int i2) {
            return (V) ((e0) this.a).f8470e[i2].getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.a.size();
        }
    }

    private e0(Map.Entry<K, V>[] entryArr, n<K, V>[] nVarArr, int i2) {
        this.f8470e = entryArr;
        this.f8471f = nVarArr;
        this.f8472g = i2;
    }

    static void q(Object obj, Map.Entry<?, ?> entry, n<?, ?> nVar) {
        while (nVar != null) {
            m.b(!obj.equals(nVar.getKey()), "key", entry, nVar);
            nVar = nVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> e0<K, V> r(Map.Entry<K, V>... entryArr) {
        return s(entryArr.length, entryArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> e0<K, V> s(int i2, Map.Entry<K, V>[] entryArr) {
        n aVar;
        com.google.common.base.l.l(i2, entryArr.length);
        Map.Entry<K, V>[] a2 = i2 == entryArr.length ? entryArr : n.a(i2);
        int a3 = g.a(i2, 1.2d);
        n[] a4 = n.a(a3);
        int i3 = a3 - 1;
        for (int i4 = 0; i4 < i2; i4++) {
            Map.Entry<K, V> entry = entryArr[i4];
            K key = entry.getKey();
            V value = entry.getValue();
            d.a(key, value);
            int b2 = g.b(key.hashCode()) & i3;
            n nVar = a4[b2];
            if (nVar == null) {
                aVar = (entry instanceof n) && ((n) entry).d() ? (n) entry : new n(key, value);
            } else {
                aVar = new n.a(key, value, nVar);
            }
            a4[b2] = aVar;
            a2[i4] = aVar;
            q(key, aVar, nVar);
        }
        return new e0<>(a2, a4, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V t(Object obj, n<?, V>[] nVarArr, int i2) {
        if (obj == null) {
            return null;
        }
        for (n<?, V> nVar = nVarArr[i2 & g.b(obj.hashCode())]; nVar != null; nVar = nVar.b()) {
            if (obj.equals(nVar.getKey())) {
                return nVar.getValue();
            }
        }
        return null;
    }

    @Override // com.google.common.collect.m
    r<Map.Entry<K, V>> c() {
        return new o.a(this, this.f8470e);
    }

    @Override // com.google.common.collect.m
    r<K> d() {
        return new a(this);
    }

    @Override // com.google.common.collect.m
    j<V> e() {
        return new b(this);
    }

    @Override // com.google.common.collect.m, java.util.Map
    public V get(Object obj) {
        return (V) t(obj, this.f8471f, this.f8472g);
    }

    @Override // java.util.Map
    public int size() {
        return this.f8470e.length;
    }
}
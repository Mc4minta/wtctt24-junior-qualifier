package com.google.common.collect;

import com.google.common.collect.o;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableBiMap.java */
/* loaded from: classes2.dex */
public class c0<K, V> extends i<K, V> {

    /* renamed from: e  reason: collision with root package name */
    static final c0<Object, Object> f8460e = new c0<>(null, null, m.a, 0, 0);

    /* renamed from: f  reason: collision with root package name */
    private final transient n<K, V>[] f8461f;

    /* renamed from: g  reason: collision with root package name */
    private final transient n<K, V>[] f8462g;

    /* renamed from: h  reason: collision with root package name */
    private final transient Map.Entry<K, V>[] f8463h;

    /* renamed from: j  reason: collision with root package name */
    private final transient int f8464j;

    /* renamed from: k  reason: collision with root package name */
    private final transient int f8465k;
    @LazyInit

    /* renamed from: l  reason: collision with root package name */
    private transient i<V, K> f8466l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableBiMap.java */
    /* loaded from: classes2.dex */
    public final class b extends i<V, K> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RegularImmutableBiMap.java */
        /* loaded from: classes2.dex */
        public final class a extends o<V, K> {

            /* compiled from: RegularImmutableBiMap.java */
            /* renamed from: com.google.common.collect.c0$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class C0158a extends h<Map.Entry<V, K>> {
                C0158a() {
                }

                @Override // com.google.common.collect.h
                j<Map.Entry<V, K>> t() {
                    return a.this;
                }

                @Override // java.util.List
                /* renamed from: u */
                public Map.Entry<V, K> get(int i2) {
                    Map.Entry entry = c0.this.f8463h[i2];
                    return x.b(entry.getValue(), entry.getKey());
                }
            }

            a() {
            }

            @Override // com.google.common.collect.o, com.google.common.collect.r, java.util.Collection, java.util.Set
            public int hashCode() {
                return c0.this.f8465k;
            }

            @Override // com.google.common.collect.r
            l<Map.Entry<V, K>> m() {
                return new C0158a();
            }

            @Override // com.google.common.collect.o, com.google.common.collect.r
            boolean o() {
                return true;
            }

            @Override // com.google.common.collect.r, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: p */
            public l0<Map.Entry<V, K>> iterator() {
                return (l0<Map.Entry<K, V>>) i().iterator();
            }

            @Override // com.google.common.collect.o
            m<V, K> t() {
                return b.this;
            }
        }

        private b() {
        }

        @Override // com.google.common.collect.m
        r<Map.Entry<V, K>> c() {
            return new a();
        }

        @Override // com.google.common.collect.m, java.util.Map
        public K get(Object obj) {
            if (obj != null && c0.this.f8462g != null) {
                for (n nVar = c0.this.f8462g[g.b(obj.hashCode()) & c0.this.f8464j]; nVar != null; nVar = nVar.c()) {
                    if (obj.equals(nVar.getValue())) {
                        return nVar.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.google.common.collect.i
        public i<K, V> p() {
            return c0.this;
        }

        @Override // java.util.Map
        public int size() {
            return p().size();
        }
    }

    private c0(n<K, V>[] nVarArr, n<K, V>[] nVarArr2, Map.Entry<K, V>[] entryArr, int i2, int i3) {
        this.f8461f = nVarArr;
        this.f8462g = nVarArr2;
        this.f8463h = entryArr;
        this.f8464j = i2;
        this.f8465k = i3;
    }

    @Override // com.google.common.collect.m
    r<Map.Entry<K, V>> c() {
        return isEmpty() ? r.q() : new o.a(this, this.f8463h);
    }

    @Override // com.google.common.collect.m, java.util.Map
    public V get(Object obj) {
        n<K, V>[] nVarArr = this.f8461f;
        if (nVarArr == null) {
            return null;
        }
        return (V) e0.t(obj, nVarArr, this.f8464j);
    }

    @Override // com.google.common.collect.m, java.util.Map
    public int hashCode() {
        return this.f8465k;
    }

    @Override // com.google.common.collect.m
    boolean i() {
        return true;
    }

    @Override // com.google.common.collect.i
    public i<V, K> p() {
        if (isEmpty()) {
            return i.q();
        }
        i<V, K> iVar = this.f8466l;
        if (iVar == null) {
            b bVar = new b();
            this.f8466l = bVar;
            return bVar;
        }
        return iVar;
    }

    @Override // java.util.Map
    public int size() {
        return this.f8463h.length;
    }
}
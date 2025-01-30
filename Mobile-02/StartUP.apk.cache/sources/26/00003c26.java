package com.google.gson.u;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* loaded from: classes2.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> a = new a();

    /* renamed from: b  reason: collision with root package name */
    Comparator<? super K> f9601b;

    /* renamed from: c  reason: collision with root package name */
    e<K, V> f9602c;

    /* renamed from: d  reason: collision with root package name */
    int f9603d;

    /* renamed from: e  reason: collision with root package name */
    int f9604e;

    /* renamed from: f  reason: collision with root package name */
    final e<K, V> f9605f;

    /* renamed from: g  reason: collision with root package name */
    private h<K, V>.b f9606g;

    /* renamed from: h  reason: collision with root package name */
    private h<K, V>.c f9607h;

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes2.dex */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: c */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c2;
            if ((obj instanceof Map.Entry) && (c2 = h.this.c((Map.Entry) obj)) != null) {
                h.this.f(c2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9603d;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes2.dex */
        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f9617f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f9603d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    public abstract class d<T> implements Iterator<T> {
        e<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f9610b = null;

        /* renamed from: c  reason: collision with root package name */
        int f9611c;

        d() {
            this.a = h.this.f9605f.f9615d;
            this.f9611c = h.this.f9604e;
        }

        final e<K, V> b() {
            e<K, V> eVar = this.a;
            h hVar = h.this;
            if (eVar != hVar.f9605f) {
                if (hVar.f9604e == this.f9611c) {
                    this.a = eVar.f9615d;
                    this.f9610b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != h.this.f9605f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f9610b;
            if (eVar != null) {
                h.this.f(eVar, true);
                this.f9610b = null;
                this.f9611c = h.this.f9604e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(a);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f9613b;
            e<K, V> eVar3 = eVar.f9614c;
            int i2 = eVar2 != null ? eVar2.f9619h : 0;
            int i3 = eVar3 != null ? eVar3.f9619h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f9613b;
                e<K, V> eVar5 = eVar3.f9614c;
                int i5 = (eVar4 != null ? eVar4.f9619h : 0) - (eVar5 != null ? eVar5.f9619h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    k(eVar3);
                    j(eVar);
                } else {
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f9613b;
                e<K, V> eVar7 = eVar2.f9614c;
                int i6 = (eVar6 != null ? eVar6.f9619h : 0) - (eVar7 != null ? eVar7.f9619h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    j(eVar2);
                    k(eVar);
                } else {
                    k(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f9619h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f9619h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void i(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f9613b == eVar) {
                eVar3.f9613b = eVar2;
                return;
            } else {
                eVar3.f9614c = eVar2;
                return;
            }
        }
        this.f9602c = eVar2;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9613b;
        e<K, V> eVar3 = eVar.f9614c;
        e<K, V> eVar4 = eVar3.f9613b;
        e<K, V> eVar5 = eVar3.f9614c;
        eVar.f9614c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f9613b = eVar;
        eVar.a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.f9619h : 0, eVar4 != null ? eVar4.f9619h : 0) + 1;
        eVar.f9619h = max;
        eVar3.f9619h = Math.max(max, eVar5 != null ? eVar5.f9619h : 0) + 1;
    }

    private void k(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f9613b;
        e<K, V> eVar3 = eVar.f9614c;
        e<K, V> eVar4 = eVar2.f9613b;
        e<K, V> eVar5 = eVar2.f9614c;
        eVar.f9613b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f9614c = eVar;
        eVar.a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.f9619h : 0, eVar5 != null ? eVar5.f9619h : 0) + 1;
        eVar.f9619h = max;
        eVar2.f9619h = Math.max(max, eVar4 != null ? eVar4.f9619h : 0) + 1;
    }

    e<K, V> b(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f9601b;
        e<K, V> eVar2 = this.f9602c;
        if (eVar2 != null) {
            Comparable comparable = comparator == a ? (Comparable) k2 : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f9617f);
                } else {
                    i2 = comparator.compare(k2, (K) eVar2.f9617f);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f9613b : eVar2.f9614c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.f9605f;
            if (eVar2 == null) {
                if (comparator == a && !(k2 instanceof Comparable)) {
                    throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f9616e);
                this.f9602c = eVar;
            } else {
                eVar = new e<>(eVar2, k2, eVar4, eVar4.f9616e);
                if (i2 < 0) {
                    eVar2.f9613b = eVar;
                } else {
                    eVar2.f9614c = eVar;
                }
                e(eVar2, true);
            }
            this.f9603d++;
            this.f9604e++;
            return eVar;
        }
        return null;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> d2 = d(entry.getKey());
        if (d2 != null && a(d2.f9618g, entry.getValue())) {
            return d2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f9602c = null;
        this.f9603d = 0;
        this.f9604e++;
        e<K, V> eVar = this.f9605f;
        eVar.f9616e = eVar;
        eVar.f9615d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f9606g;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f9606g = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f9616e;
            eVar2.f9615d = eVar.f9615d;
            eVar.f9615d.f9616e = eVar2;
        }
        e<K, V> eVar3 = eVar.f9613b;
        e<K, V> eVar4 = eVar.f9614c;
        e<K, V> eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.f9619h > eVar4.f9619h ? eVar3.b() : eVar4.a();
            f(b2, false);
            e<K, V> eVar6 = eVar.f9613b;
            if (eVar6 != null) {
                i2 = eVar6.f9619h;
                b2.f9613b = eVar6;
                eVar6.a = b2;
                eVar.f9613b = null;
            } else {
                i2 = 0;
            }
            e<K, V> eVar7 = eVar.f9614c;
            if (eVar7 != null) {
                i3 = eVar7.f9619h;
                b2.f9614c = eVar7;
                eVar7.a = b2;
                eVar.f9614c = null;
            }
            b2.f9619h = Math.max(i2, i3) + 1;
            i(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            i(eVar, eVar3);
            eVar.f9613b = null;
        } else if (eVar4 != null) {
            i(eVar, eVar4);
            eVar.f9614c = null;
        } else {
            i(eVar, null);
        }
        e(eVar5, false);
        this.f9603d--;
        this.f9604e++;
    }

    e<K, V> g(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            f(d2, true);
        }
        return d2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            return d2.f9618g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f9607h;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f9607h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        Objects.requireNonNull(k2, "key == null");
        e<K, V> b2 = b(k2, true);
        V v2 = b2.f9618g;
        b2.f9618g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> g2 = g(obj);
        if (g2 != null) {
            return g2.f9618g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f9603d;
    }

    public h(Comparator<? super K> comparator) {
        this.f9603d = 0;
        this.f9604e = 0;
        this.f9605f = new e<>();
        this.f9601b = comparator == null ? a : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        e<K, V> f9613b;

        /* renamed from: c  reason: collision with root package name */
        e<K, V> f9614c;

        /* renamed from: d  reason: collision with root package name */
        e<K, V> f9615d;

        /* renamed from: e  reason: collision with root package name */
        e<K, V> f9616e;

        /* renamed from: f  reason: collision with root package name */
        final K f9617f;

        /* renamed from: g  reason: collision with root package name */
        V f9618g;

        /* renamed from: h  reason: collision with root package name */
        int f9619h;

        e() {
            this.f9617f = null;
            this.f9616e = this;
            this.f9615d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9613b; eVar2 != null; eVar2 = eVar2.f9613b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f9614c; eVar2 != null; eVar2 = eVar2.f9614c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k2 = this.f9617f;
                if (k2 == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k2.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f9618g;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9617f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9618g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f9617f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f9618g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f9618g;
            this.f9618g = v;
            return v2;
        }

        public String toString() {
            return this.f9617f + "=" + this.f9618g;
        }

        e(e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.f9617f = k2;
            this.f9619h = 1;
            this.f9615d = eVar2;
            this.f9616e = eVar3;
            eVar3.f9615d = this;
            eVar2.f9616e = this;
        }
    }
}
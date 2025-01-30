package com.google.android.gms.internal.clearcut;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c3<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private List<j3> f6390b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f6391c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6392d;

    /* renamed from: e  reason: collision with root package name */
    private volatile l3 f6393e;

    /* renamed from: f  reason: collision with root package name */
    private Map<K, V> f6394f;

    /* renamed from: g  reason: collision with root package name */
    private volatile f3 f6395g;

    private c3(int i2) {
        this.a = i2;
        this.f6390b = Collections.emptyList();
        this.f6391c = Collections.emptyMap();
        this.f6394f = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c3(int i2, d3 d3Var) {
        this(i2);
    }

    private final int b(K k2) {
        int size = this.f6390b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.f6390b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo((Comparable) this.f6390b.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends y0<FieldDescriptorType>> c3<FieldDescriptorType, Object> f(int i2) {
        return new d3(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V i(int i2) {
        p();
        V v = (V) this.f6390b.remove(i2).getValue();
        if (!this.f6391c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = q().entrySet().iterator();
            this.f6390b.add(new j3(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.f6392d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> q() {
        p();
        if (this.f6391c.isEmpty() && !(this.f6391c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6391c = treeMap;
            this.f6394f = treeMap.descendingMap();
        }
        return (SortedMap) this.f6391c;
    }

    public final boolean a() {
        return this.f6392d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        p();
        if (!this.f6390b.isEmpty()) {
            this.f6390b.clear();
        }
        if (this.f6391c.isEmpty()) {
            return;
        }
        this.f6391c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f6391c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d */
    public final V put(K k2, V v) {
        p();
        int b2 = b(k2);
        if (b2 >= 0) {
            return (V) this.f6390b.get(b2).setValue(v);
        }
        p();
        if (this.f6390b.isEmpty() && !(this.f6390b instanceof ArrayList)) {
            this.f6390b = new ArrayList(this.a);
        }
        int i2 = -(b2 + 1);
        if (i2 >= this.a) {
            return q().put(k2, v);
        }
        int size = this.f6390b.size();
        int i3 = this.a;
        if (size == i3) {
            j3 remove = this.f6390b.remove(i3 - 1);
            q().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.f6390b.add(i2, new j3(this, k2, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6393e == null) {
            this.f6393e = new l3(this, null);
        }
        return this.f6393e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c3) {
            c3 c3Var = (c3) obj;
            int size = size();
            if (size != c3Var.size()) {
                return false;
            }
            int m = m();
            if (m != c3Var.m()) {
                return entrySet().equals(c3Var.entrySet());
            }
            for (int i2 = 0; i2 < m; i2++) {
                if (!g(i2).equals(c3Var.g(i2))) {
                    return false;
                }
            }
            if (m != size) {
                return this.f6391c.equals(c3Var.f6391c);
            }
            return true;
        }
        return super.equals(obj);
    }

    public final Map.Entry<K, V> g(int i2) {
        return this.f6390b.get(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        return b2 >= 0 ? (V) this.f6390b.get(b2).getValue() : this.f6391c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m = m();
        int i2 = 0;
        for (int i3 = 0; i3 < m; i3++) {
            i2 += this.f6390b.get(i3).hashCode();
        }
        return this.f6391c.size() > 0 ? i2 + this.f6391c.hashCode() : i2;
    }

    public final int m() {
        return this.f6390b.size();
    }

    public final Iterable<Map.Entry<K, V>> n() {
        return this.f6391c.isEmpty() ? g3.a() : this.f6391c.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> o() {
        if (this.f6395g == null) {
            this.f6395g = new f3(this, null);
        }
        return this.f6395g;
    }

    public void r() {
        if (this.f6392d) {
            return;
        }
        this.f6391c = this.f6391c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f6391c);
        this.f6394f = this.f6394f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f6394f);
        this.f6392d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        p();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) i(b2);
        }
        if (this.f6391c.isEmpty()) {
            return null;
        }
        return this.f6391c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6390b.size() + this.f6391c.size();
    }
}
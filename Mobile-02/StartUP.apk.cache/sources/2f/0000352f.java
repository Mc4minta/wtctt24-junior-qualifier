package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class n6<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private List<w6> f7266b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f7267c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7268d;

    /* renamed from: e  reason: collision with root package name */
    private volatile y6 f7269e;

    /* renamed from: f  reason: collision with root package name */
    private Map<K, V> f7270f;

    /* renamed from: g  reason: collision with root package name */
    private volatile s6 f7271g;

    private n6(int i2) {
        this.a = i2;
        this.f7266b = Collections.emptyList();
        this.f7267c = Collections.emptyMap();
        this.f7270f = Collections.emptyMap();
    }

    private final int a(K k2) {
        int size = this.f7266b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.f7266b.get(size).getKey());
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
            int compareTo2 = k2.compareTo((Comparable) this.f7266b.get(i3).getKey());
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
    public static <FieldDescriptorType extends e4<FieldDescriptorType>> n6<FieldDescriptorType, Object> b(int i2) {
        return new q6(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V l(int i2) {
        q();
        V v = (V) this.f7266b.remove(i2).getValue();
        if (!this.f7267c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = r().entrySet().iterator();
            this.f7266b.add(new w6(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.f7268d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> r() {
        q();
        if (this.f7267c.isEmpty() && !(this.f7267c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f7267c = treeMap;
            this.f7270f = treeMap.descendingMap();
        }
        return (SortedMap) this.f7267c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        q();
        if (!this.f7266b.isEmpty()) {
            this.f7266b.clear();
        }
        if (this.f7267c.isEmpty()) {
            return;
        }
        this.f7267c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f7267c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d */
    public final V put(K k2, V v) {
        q();
        int a = a(k2);
        if (a >= 0) {
            return (V) this.f7266b.get(a).setValue(v);
        }
        q();
        if (this.f7266b.isEmpty() && !(this.f7266b instanceof ArrayList)) {
            this.f7266b = new ArrayList(this.a);
        }
        int i2 = -(a + 1);
        if (i2 >= this.a) {
            return r().put(k2, v);
        }
        int size = this.f7266b.size();
        int i3 = this.a;
        if (size == i3) {
            w6 remove = this.f7266b.remove(i3 - 1);
            r().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.f7266b.add(i2, new w6(this, k2, v));
        return null;
    }

    public void e() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f7268d) {
            return;
        }
        if (this.f7267c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f7267c);
        }
        this.f7267c = unmodifiableMap;
        if (this.f7270f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f7270f);
        }
        this.f7270f = unmodifiableMap2;
        this.f7268d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f7269e == null) {
            this.f7269e = new y6(this, null);
        }
        return this.f7269e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n6)) {
            return super.equals(obj);
        }
        n6 n6Var = (n6) obj;
        int size = size();
        if (size != n6Var.size()) {
            return false;
        }
        int k2 = k();
        if (k2 != n6Var.k()) {
            return entrySet().equals(n6Var.entrySet());
        }
        for (int i2 = 0; i2 < k2; i2++) {
            if (!i(i2).equals(n6Var.i(i2))) {
                return false;
            }
        }
        if (k2 != size) {
            return this.f7267c.equals(n6Var.f7267c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return (V) this.f7266b.get(a).getValue();
        }
        return this.f7267c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int k2 = k();
        int i2 = 0;
        for (int i3 = 0; i3 < k2; i3++) {
            i2 += this.f7266b.get(i3).hashCode();
        }
        return this.f7267c.size() > 0 ? i2 + this.f7267c.hashCode() : i2;
    }

    public final Map.Entry<K, V> i(int i2) {
        return this.f7266b.get(i2);
    }

    public final boolean j() {
        return this.f7268d;
    }

    public final int k() {
        return this.f7266b.size();
    }

    public final Iterable<Map.Entry<K, V>> n() {
        if (this.f7267c.isEmpty()) {
            return r6.a();
        }
        return this.f7267c.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> p() {
        if (this.f7271g == null) {
            this.f7271g = new s6(this, null);
        }
        return this.f7271g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        q();
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        if (a >= 0) {
            return (V) l(a);
        }
        if (this.f7267c.isEmpty()) {
            return null;
        }
        return this.f7267c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f7266b.size() + this.f7267c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n6(int i2, q6 q6Var) {
        this(i2);
    }
}
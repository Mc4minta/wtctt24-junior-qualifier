package com.google.android.gms.internal.p000firebaseperf;

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
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n6  reason: invalid package */
/* loaded from: classes2.dex */
public class n6<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private List<w6> f6857b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f6858c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6859d;

    /* renamed from: e  reason: collision with root package name */
    private volatile y6 f6860e;

    /* renamed from: f  reason: collision with root package name */
    private Map<K, V> f6861f;

    /* renamed from: g  reason: collision with root package name */
    private volatile s6 f6862g;

    private n6(int i2) {
        this.a = i2;
        this.f6857b = Collections.emptyList();
        this.f6858c = Collections.emptyMap();
        this.f6861f = Collections.emptyMap();
    }

    private final int b(K k2) {
        int size = this.f6857b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.f6857b.get(size).getKey());
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
            int compareTo2 = k2.compareTo((Comparable) this.f6857b.get(i3).getKey());
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
    public static <FieldDescriptorType extends g4<FieldDescriptorType>> n6<FieldDescriptorType, Object> f(int i2) {
        return new q6(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V i(int i2) {
        q();
        V v = (V) this.f6857b.remove(i2).getValue();
        if (!this.f6858c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = r().entrySet().iterator();
            this.f6857b.add(new w6(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.f6859d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> r() {
        q();
        if (this.f6858c.isEmpty() && !(this.f6858c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6858c = treeMap;
            this.f6861f = treeMap.descendingMap();
        }
        return (SortedMap) this.f6858c;
    }

    public final boolean a() {
        return this.f6859d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        q();
        if (!this.f6857b.isEmpty()) {
            this.f6857b.clear();
        }
        if (this.f6858c.isEmpty()) {
            return;
        }
        this.f6858c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f6858c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d */
    public final V put(K k2, V v) {
        q();
        int b2 = b(k2);
        if (b2 >= 0) {
            return (V) this.f6857b.get(b2).setValue(v);
        }
        q();
        if (this.f6857b.isEmpty() && !(this.f6857b instanceof ArrayList)) {
            this.f6857b = new ArrayList(this.a);
        }
        int i2 = -(b2 + 1);
        if (i2 >= this.a) {
            return r().put(k2, v);
        }
        int size = this.f6857b.size();
        int i3 = this.a;
        if (size == i3) {
            w6 remove = this.f6857b.remove(i3 - 1);
            r().put((K) remove.getKey(), (V) remove.getValue());
        }
        this.f6857b.add(i2, new w6(this, k2, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6860e == null) {
            this.f6860e = new y6(this, null);
        }
        return this.f6860e;
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
        int n = n();
        if (n != n6Var.n()) {
            return entrySet().equals(n6Var.entrySet());
        }
        for (int i2 = 0; i2 < n; i2++) {
            if (!g(i2).equals(n6Var.g(i2))) {
                return false;
            }
        }
        if (n != size) {
            return this.f6858c.equals(n6Var.f6858c);
        }
        return true;
    }

    public final Map.Entry<K, V> g(int i2) {
        return this.f6857b.get(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) this.f6857b.get(b2).getValue();
        }
        return this.f6858c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int n = n();
        int i2 = 0;
        for (int i3 = 0; i3 < n; i3++) {
            i2 += this.f6857b.get(i3).hashCode();
        }
        return this.f6858c.size() > 0 ? i2 + this.f6858c.hashCode() : i2;
    }

    public void m() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f6859d) {
            return;
        }
        if (this.f6858c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f6858c);
        }
        this.f6858c = unmodifiableMap;
        if (this.f6861f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f6861f);
        }
        this.f6861f = unmodifiableMap2;
        this.f6859d = true;
    }

    public final int n() {
        return this.f6857b.size();
    }

    public final Iterable<Map.Entry<K, V>> o() {
        if (this.f6858c.isEmpty()) {
            return r6.a();
        }
        return this.f6858c.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> p() {
        if (this.f6862g == null) {
            this.f6862g = new s6(this, null);
        }
        return this.f6862g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        q();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) i(b2);
        }
        if (this.f6858c.isEmpty()) {
            return null;
        }
        return this.f6858c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6857b.size() + this.f6858c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n6(int i2, q6 q6Var) {
        this(i2);
    }
}
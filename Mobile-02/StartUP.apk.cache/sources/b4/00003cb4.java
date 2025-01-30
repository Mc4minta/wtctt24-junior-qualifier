package com.google.protobuf;

import com.google.protobuf.i;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmallSortedMap.java */
/* loaded from: classes2.dex */
public class s<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private List<s<K, V>.c> f9739b;

    /* renamed from: c  reason: collision with root package name */
    private Map<K, V> f9740c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9741d;

    /* renamed from: e  reason: collision with root package name */
    private volatile s<K, V>.e f9742e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public static class a<FieldDescriptorType> extends s<FieldDescriptorType, Object> {
        a(int i2) {
            super(i2, null);
        }

        @Override // com.google.protobuf.s
        public void o() {
            if (!n()) {
                for (int i2 = 0; i2 < j(); i2++) {
                    Map.Entry<FieldDescriptorType, Object> i3 = i(i2);
                    if (((i.b) i3.getKey()).isRepeated()) {
                        i3.setValue(Collections.unmodifiableList((List) i3.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : l()) {
                    if (((i.b) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.o();
        }

        @Override // com.google.protobuf.s, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((i.b) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public static class b {
        private static final Iterator<Object> a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f9743b = new C0204b();

        /* compiled from: SmallSortedMap.java */
        /* loaded from: classes2.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap.java */
        /* renamed from: com.google.protobuf.s$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0204b implements Iterable<Object> {
            C0204b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f9743b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public class c implements Map.Entry<K, V>, Comparable<s<K, V>.c> {
        private final K a;

        /* renamed from: b  reason: collision with root package name */
        private V f9744b;

        c(s sVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean n(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return n(this.a, entry.getKey()) && n(this.f9744b, entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9744b;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(s<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.a;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f9744b;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        /* renamed from: q */
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            s.this.f();
            V v2 = this.f9744b;
            this.f9744b = v;
            return v2;
        }

        public String toString() {
            return this.a + "=" + this.f9744b;
        }

        c(K k2, V v) {
            this.a = k2;
            this.f9744b = v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = s.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: h */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            s.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(s.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                s.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s.this.size();
        }

        /* synthetic */ e(s sVar, a aVar) {
            this();
        }
    }

    /* synthetic */ s(int i2, a aVar) {
        this(i2);
    }

    private int e(K k2) {
        int size = this.f9739b.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.f9739b.get(size).getKey());
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
            int compareTo2 = k2.compareTo(this.f9739b.get(i3).getKey());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f9741d) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.f9739b.isEmpty() || (this.f9739b instanceof ArrayList)) {
            return;
        }
        this.f9739b = new ArrayList(this.a);
    }

    private SortedMap<K, V> m() {
        f();
        if (this.f9740c.isEmpty() && !(this.f9740c instanceof TreeMap)) {
            this.f9740c = new TreeMap();
        }
        return (SortedMap) this.f9740c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends i.b<FieldDescriptorType>> s<FieldDescriptorType, Object> p(int i2) {
        return new a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V r(int i2) {
        f();
        V value = this.f9739b.remove(i2).getValue();
        if (!this.f9740c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m().entrySet().iterator();
            this.f9739b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f9739b.isEmpty()) {
            this.f9739b.clear();
        }
        if (this.f9740c.isEmpty()) {
            return;
        }
        this.f9740c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f9740c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f9742e == null) {
            this.f9742e = new e(this, null);
        }
        return this.f9742e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return super.equals(obj);
        }
        s sVar = (s) obj;
        int size = size();
        if (size != sVar.size()) {
            return false;
        }
        int j2 = j();
        if (j2 != sVar.j()) {
            return entrySet().equals(sVar.entrySet());
        }
        for (int i2 = 0; i2 < j2; i2++) {
            if (!i(i2).equals(sVar.i(i2))) {
                return false;
            }
        }
        if (j2 != size) {
            return this.f9740c.equals(sVar.f9740c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return this.f9739b.get(e2).getValue();
        }
        return this.f9740c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int j2 = j();
        int i2 = 0;
        for (int i3 = 0; i3 < j2; i3++) {
            i2 += this.f9739b.get(i3).hashCode();
        }
        return k() > 0 ? i2 + this.f9740c.hashCode() : i2;
    }

    public Map.Entry<K, V> i(int i2) {
        return this.f9739b.get(i2);
    }

    public int j() {
        return this.f9739b.size();
    }

    public int k() {
        return this.f9740c.size();
    }

    public Iterable<Map.Entry<K, V>> l() {
        if (this.f9740c.isEmpty()) {
            return b.b();
        }
        return this.f9740c.entrySet();
    }

    public boolean n() {
        return this.f9741d;
    }

    public void o() {
        Map<K, V> unmodifiableMap;
        if (this.f9741d) {
            return;
        }
        if (this.f9740c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f9740c);
        }
        this.f9740c = unmodifiableMap;
        this.f9741d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: q */
    public V put(K k2, V v) {
        f();
        int e2 = e(k2);
        if (e2 >= 0) {
            return this.f9739b.get(e2).setValue(v);
        }
        g();
        int i2 = -(e2 + 1);
        if (i2 >= this.a) {
            return m().put(k2, v);
        }
        int size = this.f9739b.size();
        int i3 = this.a;
        if (size == i3) {
            s<K, V>.c remove = this.f9739b.remove(i3 - 1);
            m().put((K) remove.getKey(), remove.getValue());
        }
        this.f9739b.add(i2, new c(k2, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return (V) r(e2);
        }
        if (this.f9740c.isEmpty()) {
            return null;
        }
        return this.f9740c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f9739b.size() + this.f9740c.size();
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    private class d implements Iterator<Map.Entry<K, V>> {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9746b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f9747c;

        private d() {
            this.a = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f9747c == null) {
                this.f9747c = s.this.f9740c.entrySet().iterator();
            }
            return this.f9747c;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f9746b = true;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 < s.this.f9739b.size()) {
                return (Map.Entry) s.this.f9739b.get(this.a);
            }
            return b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < s.this.f9739b.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f9746b) {
                this.f9746b = false;
                s.this.f();
                if (this.a < s.this.f9739b.size()) {
                    s sVar = s.this;
                    int i2 = this.a;
                    this.a = i2 - 1;
                    sVar.r(i2);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(s sVar, a aVar) {
            this();
        }
    }

    private s(int i2) {
        this.a = i2;
        this.f9739b = Collections.emptyList();
        this.f9740c = Collections.emptyMap();
    }
}
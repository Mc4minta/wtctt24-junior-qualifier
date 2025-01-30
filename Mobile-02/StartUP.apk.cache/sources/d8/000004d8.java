package c.e;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    f<K, V> mCollections;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a extends f<K, V> {
        C0058a() {
        }

        @Override // c.e.f
        protected void a() {
            a.this.clear();
        }

        @Override // c.e.f
        protected Object b(int i2, int i3) {
            return a.this.mArray[(i2 << 1) + i3];
        }

        @Override // c.e.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // c.e.f
        protected int d() {
            return a.this.mSize;
        }

        @Override // c.e.f
        protected int e(Object obj) {
            return a.this.indexOfKey(obj);
        }

        @Override // c.e.f
        protected int f(Object obj) {
            return a.this.indexOfValue(obj);
        }

        @Override // c.e.f
        protected void g(K k2, V v) {
            a.this.put(k2, v);
        }

        @Override // c.e.f
        protected void h(int i2) {
            a.this.removeAt(i2);
        }

        @Override // c.e.f
        protected V i(int i2, V v) {
            return a.this.setValueAt(i2, v);
        }
    }

    public a() {
    }

    private f<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new C0058a();
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> collection) {
        return f.j(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().m();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return f.o(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().n();
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }
}
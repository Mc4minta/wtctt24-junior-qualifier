package c.b.a.b;

import c.b.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: e  reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f2594e = new HashMap<>();

    public boolean contains(K k2) {
        return this.f2594e.containsKey(k2);
    }

    @Override // c.b.a.b.b
    protected b.c<K, V> i(K k2) {
        return this.f2594e.get(k2);
    }

    @Override // c.b.a.b.b
    public V o(K k2, V v) {
        b.c<K, V> i2 = i(k2);
        if (i2 != null) {
            return i2.f2598b;
        }
        this.f2594e.put(k2, m(k2, v));
        return null;
    }

    @Override // c.b.a.b.b
    public V p(K k2) {
        V v = (V) super.p(k2);
        this.f2594e.remove(k2);
        return v;
    }

    public Map.Entry<K, V> q(K k2) {
        if (contains(k2)) {
            return this.f2594e.get(k2).f2600d;
        }
        return null;
    }
}
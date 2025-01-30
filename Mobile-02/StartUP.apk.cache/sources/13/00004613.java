package e.f.j.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: CountingLruMap.java */
/* loaded from: classes2.dex */
public class g<K, V> {
    private final v<V> a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedHashMap<K, V> f12441b = new LinkedHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private int f12442c = 0;

    public g(v<V> vVar) {
        this.a = vVar;
    }

    private int f(V v) {
        if (v == null) {
            return 0;
        }
        return this.a.a(v);
    }

    public synchronized V a(K k2) {
        return this.f12441b.get(k2);
    }

    public synchronized int b() {
        return this.f12441b.size();
    }

    public synchronized K c() {
        return this.f12441b.isEmpty() ? null : this.f12441b.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> d(e.f.d.c.j<K> jVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.f12441b.entrySet().size());
        for (Map.Entry<K, V> entry : this.f12441b.entrySet()) {
            if (jVar == null || jVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized int e() {
        return this.f12442c;
    }

    public synchronized V g(K k2, V v) {
        V remove;
        remove = this.f12441b.remove(k2);
        this.f12442c -= f(remove);
        this.f12441b.put(k2, v);
        this.f12442c += f(v);
        return remove;
    }

    public synchronized V h(K k2) {
        V remove;
        remove = this.f12441b.remove(k2);
        this.f12442c -= f(remove);
        return remove;
    }

    public synchronized ArrayList<V> i(e.f.d.c.j<K> jVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.f12441b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (jVar == null || jVar.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.f12442c -= f(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }
}
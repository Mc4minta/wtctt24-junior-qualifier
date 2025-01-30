package c.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    c<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f2595b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2596c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f2597d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2600d;
        }

        @Override // c.b.a.b.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2599c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: c.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0057b<K, V> extends e<K, V> {
        C0057b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2599c;
        }

        @Override // c.b.a.b.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2600d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        final K a;

        /* renamed from: b  reason: collision with root package name */
        final V f2598b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f2599c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f2600d;

        c(K k2, V v) {
            this.a = k2;
            this.f2598b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.a.equals(cVar.a) && this.f2598b.equals(cVar.f2598b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2598b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.f2598b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.f2598b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private c<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2601b = true;

        d() {
        }

        @Override // c.b.a.b.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2600d;
                this.a = cVar3;
                this.f2601b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            if (this.f2601b) {
                this.f2601b = false;
                this.a = b.this.a;
            } else {
                c<K, V> cVar = this.a;
                this.a = cVar != null ? cVar.f2599c : null;
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2601b) {
                return b.this.a != null;
            }
            c<K, V> cVar = this.a;
            return (cVar == null || cVar.f2599c == null) ? false : true;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        c<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f2603b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.f2603b = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f2603b;
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // c.b.a.b.b.f
        public void b(c<K, V> cVar) {
            if (this.a == cVar && cVar == this.f2603b) {
                this.f2603b = null;
                this.a = null;
            }
            c<K, V> cVar2 = this.a;
            if (cVar2 == cVar) {
                this.a = c(cVar2);
            }
            if (this.f2603b == cVar) {
                this.f2603b = f();
            }
        }

        abstract c<K, V> c(c<K, V> cVar);

        abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: e */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2603b;
            this.f2603b = f();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2603b != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0057b c0057b = new C0057b(this.f2595b, this.a);
        this.f2596c.put(c0057b, Boolean.FALSE);
        return c0057b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    public Map.Entry<K, V> h() {
        return this.a;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().hashCode();
        }
        return i2;
    }

    protected c<K, V> i(K k2) {
        c<K, V> cVar = this.a;
        while (cVar != null && !cVar.a.equals(k2)) {
            cVar = cVar.f2599c;
        }
        return cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.a, this.f2595b);
        this.f2596c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public b<K, V>.d k() {
        b<K, V>.d dVar = new d();
        this.f2596c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> l() {
        return this.f2595b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> m(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.f2597d++;
        c<K, V> cVar2 = this.f2595b;
        if (cVar2 == null) {
            this.a = cVar;
            this.f2595b = cVar;
            return cVar;
        }
        cVar2.f2599c = cVar;
        cVar.f2600d = cVar2;
        this.f2595b = cVar;
        return cVar;
    }

    public V o(K k2, V v) {
        c<K, V> i2 = i(k2);
        if (i2 != null) {
            return i2.f2598b;
        }
        m(k2, v);
        return null;
    }

    public V p(K k2) {
        c<K, V> i2 = i(k2);
        if (i2 == null) {
            return null;
        }
        this.f2597d--;
        if (!this.f2596c.isEmpty()) {
            for (f<K, V> fVar : this.f2596c.keySet()) {
                fVar.b(i2);
            }
        }
        c<K, V> cVar = i2.f2600d;
        if (cVar != null) {
            cVar.f2599c = i2.f2599c;
        } else {
            this.a = i2.f2599c;
        }
        c<K, V> cVar2 = i2.f2599c;
        if (cVar2 != null) {
            cVar2.f2600d = cVar;
        } else {
            this.f2595b = cVar;
        }
        i2.f2599c = null;
        i2.f2600d = null;
        return i2.f2598b;
    }

    public int size() {
        return this.f2597d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
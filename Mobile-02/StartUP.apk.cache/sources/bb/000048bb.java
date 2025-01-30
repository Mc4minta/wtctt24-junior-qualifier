package e.g.b.a.d;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes2.dex */
public class a<K, V> extends AbstractMap<K, V> implements Cloneable {
    int a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f13401b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: e.g.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0311a implements Map.Entry<K, V> {
        private int a;

        C0311a(int i2) {
            this.a = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return x.a(getKey(), entry.getKey()) && x.a(getValue(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) a.this.i(this.a);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) a.this.k(this.a);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            Object value = getValue();
            return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            return (V) a.this.o(this.a, v);
        }
    }

    /* compiled from: ArrayMap.java */
    /* loaded from: classes2.dex */
    final class b implements Iterator<Map.Entry<K, V>> {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private int f13403b;

        b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            int i2 = this.f13403b;
            a aVar = a.this;
            if (i2 != aVar.a) {
                this.f13403b = i2 + 1;
                this.a = false;
                return new C0311a(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13403b < a.this.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i2 = this.f13403b - 1;
            if (!this.a && i2 >= 0) {
                a.this.l(i2);
                this.f13403b--;
                this.a = true;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: ArrayMap.java */
    /* loaded from: classes2.dex */
    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.a;
        }
    }

    public static <K, V> a<K, V> c() {
        return new a<>();
    }

    private int e(Object obj) {
        int i2 = this.a << 1;
        Object[] objArr = this.f13401b;
        for (int i3 = 0; i3 < i2; i3 += 2) {
            Object obj2 = objArr[i3];
            if (obj == null) {
                if (obj2 == null) {
                    return i3;
                }
            } else if (obj.equals(obj2)) {
                return i3;
            }
        }
        return -2;
    }

    private V n(int i2) {
        int i3 = this.a << 1;
        if (i2 < 0 || i2 >= i3) {
            return null;
        }
        V s = s(i2 + 1);
        Object[] objArr = this.f13401b;
        int i4 = (i3 - i2) - 2;
        if (i4 != 0) {
            System.arraycopy(objArr, i2 + 2, objArr, i2, i4);
        }
        this.a--;
        q(i3 - 2, null, null);
        return s;
    }

    private void q(int i2, K k2, V v) {
        Object[] objArr = this.f13401b;
        objArr[i2] = k2;
        objArr[i2 + 1] = v;
    }

    private void r(int i2) {
        if (i2 == 0) {
            this.f13401b = null;
            return;
        }
        int i3 = this.a;
        Object[] objArr = this.f13401b;
        if (i3 == 0 || i2 != objArr.length) {
            Object[] objArr2 = new Object[i2];
            this.f13401b = objArr2;
            if (i3 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i3 << 1);
            }
        }
    }

    private V s(int i2) {
        if (i2 < 0) {
            return null;
        }
        return (V) this.f13401b[i2];
    }

    @Override // java.util.AbstractMap
    /* renamed from: b */
    public a<K, V> clone() {
        try {
            a<K, V> aVar = (a) super.clone();
            Object[] objArr = this.f13401b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                aVar.f13401b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.a = 0;
        this.f13401b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != e(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i2 = this.a << 1;
        Object[] objArr = this.f13401b;
        for (int i3 = 1; i3 < i2; i3 += 2) {
            Object obj2 = objArr[i3];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else if (obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    public final void d(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.f13401b;
            int i3 = i2 << 1;
            int length = objArr == null ? 0 : objArr.length;
            if (i3 > length) {
                int i4 = ((length / 2) * 3) + 1;
                if (i4 % 2 != 0) {
                    i4++;
                }
                if (i4 >= i3) {
                    i3 = i4;
                }
                r(i3);
                return;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new c();
    }

    public final int f(K k2) {
        return e(k2) >> 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return s(e(obj) + 1);
    }

    public final K i(int i2) {
        if (i2 < 0 || i2 >= this.a) {
            return null;
        }
        return (K) this.f13401b[i2 << 1];
    }

    public final V k(int i2) {
        if (i2 < 0 || i2 >= this.a) {
            return null;
        }
        return s((i2 << 1) + 1);
    }

    public final V l(int i2) {
        return n(i2 << 1);
    }

    public final V o(int i2, V v) {
        int i3 = this.a;
        if (i2 >= 0 && i2 < i3) {
            int i4 = (i2 << 1) + 1;
            V s = s(i4);
            this.f13401b[i4] = v;
            return s;
        }
        throw new IndexOutOfBoundsException();
    }

    public final V p(int i2, K k2, V v) {
        if (i2 >= 0) {
            int i3 = i2 + 1;
            d(i3);
            int i4 = i2 << 1;
            V s = s(i4 + 1);
            q(i4, k2, v);
            if (i3 > this.a) {
                this.a = i3;
            }
            return s;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        int f2 = f(k2);
        if (f2 == -1) {
            f2 = this.a;
        }
        return p(f2, k2, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return n(e(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a;
    }
}
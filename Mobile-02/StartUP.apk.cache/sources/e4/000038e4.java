package com.google.common.collect;

import com.google.common.collect.j;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* compiled from: ImmutableMap.java */
/* loaded from: classes2.dex */
public abstract class m<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] a = new Map.Entry[0];
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient r<Map.Entry<K, V>> f8488b;
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private transient r<K> f8489c;
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private transient j<V> f8490d;

    /* compiled from: ImmutableMap.java */
    /* loaded from: classes2.dex */
    class a extends l0<K> {
        final /* synthetic */ l0 a;

        a(l0 l0Var) {
            this.a = l0Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.a.next()).getKey();
        }
    }

    /* compiled from: ImmutableMap.java */
    /* loaded from: classes2.dex */
    public static class b<K, V> {
        Comparator<? super V> a;

        /* renamed from: b  reason: collision with root package name */
        n<K, V>[] f8492b;

        /* renamed from: c  reason: collision with root package name */
        int f8493c;

        /* renamed from: d  reason: collision with root package name */
        boolean f8494d;

        public b() {
            this(4);
        }

        private void b(int i2) {
            n<K, V>[] nVarArr = this.f8492b;
            if (i2 > nVarArr.length) {
                this.f8492b = (n[]) y.a(nVarArr, j.a.a(nVarArr.length, i2));
                this.f8494d = false;
            }
        }

        public m<K, V> a() {
            int i2 = this.f8493c;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (this.a != null) {
                        if (this.f8494d) {
                            this.f8492b = (n[]) y.a(this.f8492b, i2);
                        }
                        Arrays.sort(this.f8492b, 0, this.f8493c, z.a(this.a).b(x.d()));
                    }
                    int i3 = this.f8493c;
                    n<K, V>[] nVarArr = this.f8492b;
                    this.f8494d = i3 == nVarArr.length;
                    return e0.s(i3, nVarArr);
                }
                return m.m(this.f8492b[0].getKey(), this.f8492b[0].getValue());
            }
            return m.l();
        }

        @CanIgnoreReturnValue
        public b<K, V> c(K k2, V v) {
            b(this.f8493c + 1);
            n<K, V> f2 = m.f(k2, v);
            n<K, V>[] nVarArr = this.f8492b;
            int i2 = this.f8493c;
            this.f8493c = i2 + 1;
            nVarArr[i2] = f2;
            return this;
        }

        b(int i2) {
            this.f8492b = new n[i2];
            this.f8493c = 0;
            this.f8494d = false;
        }
    }

    public static <K, V> b<K, V> a() {
        return new b<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
    }

    static <K, V> n<K, V> f(K k2, V v) {
        return new n<>(k2, v);
    }

    public static <K, V> m<K, V> l() {
        return i.q();
    }

    public static <K, V> m<K, V> m(K k2, V v) {
        return i.r(k2, v);
    }

    public static <K, V> m<K, V> n(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        return e0.r(f(k2, v), f(k3, v2), f(k4, v3), f(k5, v4), f(k6, v5));
    }

    abstract r<Map.Entry<K, V>> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    r<K> d() {
        return isEmpty() ? r.q() : new p(this);
    }

    j<V> e() {
        return new q(this);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return x.a(this, obj);
    }

    @Override // java.util.Map
    /* renamed from: g */
    public r<Map.Entry<K, V>> entrySet() {
        r<Map.Entry<K, V>> rVar = this.f8488b;
        if (rVar == null) {
            r<Map.Entry<K, V>> c2 = c();
            this.f8488b = c2;
            return c2;
        }
        return rVar;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public int hashCode() {
        return g0.b(entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0<K> j() {
        return new a(entrySet().iterator());
    }

    @Override // java.util.Map
    /* renamed from: k */
    public r<K> keySet() {
        r<K> rVar = this.f8489c;
        if (rVar == null) {
            r<K> d2 = d();
            this.f8489c = d2;
            return d2;
        }
        return rVar;
    }

    @Override // java.util.Map
    /* renamed from: o */
    public j<V> values() {
        j<V> jVar = this.f8490d;
        if (jVar == null) {
            j<V> e2 = e();
            this.f8490d = e2;
            return e2;
        }
        return jVar;
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return x.c(this);
    }
}
package com.google.android.gms.internal.p000firebaseperf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.j8  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class j8<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] a = new Map.Entry[0];

    /* renamed from: b  reason: collision with root package name */
    private transient i8<Map.Entry<K, V>> f6783b;

    /* renamed from: c  reason: collision with root package name */
    private transient i8<K> f6784c;

    /* renamed from: d  reason: collision with root package name */
    private transient f8<V> f6785d;

    public static <K, V> j8<K, V> a(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        d7.a(k2, v);
        d7.a(k3, v2);
        d7.a(k4, v3);
        d7.a(k5, v4);
        return k8.e(4, new Object[]{k2, v, k3, v2, k4, v3, k5, v4});
    }

    abstract i8<Map.Entry<K, V>> b();

    abstract i8<K> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((f8) values()).contains(obj);
    }

    abstract f8<V> d();

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        i8<Map.Entry<K, V>> i8Var = this.f6783b;
        if (i8Var == null) {
            i8<Map.Entry<K, V>> b2 = b();
            this.f6783b = b2;
            return b2;
        }
        return i8Var;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return r8.a((i8) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        i8<K> i8Var = this.f6784c;
        if (i8Var == null) {
            i8<K> c2 = c();
            this.f6784c = c2;
            return c2;
        }
        return i8Var;
    }

    @Override // java.util.Map
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
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
            sb.append('{');
            boolean z = true;
            for (Map.Entry<K, V> entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("size".length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        f8<V> f8Var = this.f6785d;
        if (f8Var == null) {
            f8<V> d2 = d();
            this.f6785d = d2;
            return d2;
        }
        return f8Var;
    }
}
package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: MapBuilder.java */
/* loaded from: classes2.dex */
public class c {

    /* compiled from: MapBuilder.java */
    /* loaded from: classes2.dex */
    public static final class b<K, V> {
        private Map a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4787b;

        public Map<K, V> a() {
            if (this.f4787b) {
                this.f4787b = false;
                return this.a;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        public b<K, V> b(K k2, V v) {
            if (this.f4787b) {
                this.a.put(k2, v);
                return this;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        private b() {
            this.a = c.b();
            this.f4787b = true;
        }
    }

    public static <K, V> b<K, V> a() {
        return new b<>();
    }

    public static <K, V> HashMap<K, V> b() {
        return new HashMap<>();
    }

    public static <K, V> Map<K, V> c() {
        return b();
    }

    public static <K, V> Map<K, V> d(K k2, V v) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        return c2;
    }

    public static <K, V> Map<K, V> e(K k2, V v, K k3, V v2) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        c2.put(k3, v2);
        return c2;
    }

    public static <K, V> Map<K, V> f(K k2, V v, K k3, V v2, K k4, V v3) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        c2.put(k3, v2);
        c2.put(k4, v3);
        return c2;
    }

    public static <K, V> Map<K, V> g(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        c2.put(k3, v2);
        c2.put(k4, v3);
        c2.put(k5, v4);
        return c2;
    }

    public static <K, V> Map<K, V> h(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        c2.put(k3, v2);
        c2.put(k4, v3);
        c2.put(k5, v4);
        c2.put(k6, v5);
        return c2;
    }

    public static <K, V> Map<K, V> i(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        Map<K, V> c2 = c();
        c2.put(k2, v);
        c2.put(k3, v2);
        c2.put(k4, v3);
        c2.put(k5, v4);
        c2.put(k6, v5);
        c2.put(k7, v6);
        return c2;
    }
}
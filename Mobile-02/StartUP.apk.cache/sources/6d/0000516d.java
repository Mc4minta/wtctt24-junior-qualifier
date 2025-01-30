package kotlin.a0;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes3.dex */
public class m0 extends l0 {
    public static <K, V> Map<K, V> i() {
        c0 c0Var = c0.a;
        Objects.requireNonNull(c0Var, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return c0Var;
    }

    public static <K, V> V j(Map<K, ? extends V> getValue, K k2) {
        kotlin.jvm.internal.m.g(getValue, "$this$getValue");
        return (V) k0.a(getValue, k2);
    }

    public static <K, V> HashMap<K, V> k(kotlin.o<? extends K, ? extends V>... pairs) {
        int d2;
        kotlin.jvm.internal.m.g(pairs, "pairs");
        d2 = l0.d(pairs.length);
        HashMap<K, V> hashMap = new HashMap<>(d2);
        q(hashMap, pairs);
        return hashMap;
    }

    public static <K, V> Map<K, V> l(kotlin.o<? extends K, ? extends V>... pairs) {
        Map<K, V> i2;
        int d2;
        kotlin.jvm.internal.m.g(pairs, "pairs");
        if (pairs.length > 0) {
            d2 = l0.d(pairs.length);
            return u(pairs, new LinkedHashMap(d2));
        }
        i2 = i();
        return i2;
    }

    public static <K, V> Map<K, V> m(kotlin.o<? extends K, ? extends V>... pairs) {
        int d2;
        kotlin.jvm.internal.m.g(pairs, "pairs");
        d2 = l0.d(pairs.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        q(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> n(Map<K, ? extends V> optimizeReadOnlyMap) {
        Map<K, V> i2;
        kotlin.jvm.internal.m.g(optimizeReadOnlyMap, "$this$optimizeReadOnlyMap");
        int size = optimizeReadOnlyMap.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlyMap : l0.f(optimizeReadOnlyMap);
        }
        i2 = i();
        return i2;
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> plus, Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(plus);
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }

    public static final <K, V> void p(Map<? super K, ? super V> putAll, Iterable<? extends kotlin.o<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.m.g(putAll, "$this$putAll");
        kotlin.jvm.internal.m.g(pairs, "pairs");
        for (kotlin.o<? extends K, ? extends V> oVar : pairs) {
            putAll.put((K) oVar.a(), (V) oVar.b());
        }
    }

    public static final <K, V> void q(Map<? super K, ? super V> putAll, kotlin.o<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.m.g(putAll, "$this$putAll");
        kotlin.jvm.internal.m.g(pairs, "pairs");
        for (kotlin.o<? extends K, ? extends V> oVar : pairs) {
            putAll.put((K) oVar.a(), (V) oVar.b());
        }
    }

    public static <K, V> Map<K, V> r(Iterable<? extends kotlin.o<? extends K, ? extends V>> toMap) {
        Map<K, V> i2;
        Map<K, V> e2;
        int d2;
        kotlin.jvm.internal.m.g(toMap, "$this$toMap");
        if (toMap instanceof Collection) {
            Collection collection = (Collection) toMap;
            int size = collection.size();
            if (size == 0) {
                i2 = i();
                return i2;
            } else if (size != 1) {
                d2 = l0.d(collection.size());
                return s(toMap, new LinkedHashMap(d2));
            } else {
                e2 = l0.e(toMap instanceof List ? (kotlin.o<? extends K, ? extends V>) ((List) toMap).get(0) : toMap.iterator().next());
                return e2;
            }
        }
        return n(s(toMap, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M s(Iterable<? extends kotlin.o<? extends K, ? extends V>> toMap, M destination) {
        kotlin.jvm.internal.m.g(toMap, "$this$toMap");
        kotlin.jvm.internal.m.g(destination, "destination");
        p(destination, toMap);
        return destination;
    }

    public static <K, V> Map<K, V> t(Map<? extends K, ? extends V> toMap) {
        Map<K, V> i2;
        Map<K, V> v;
        kotlin.jvm.internal.m.g(toMap, "$this$toMap");
        int size = toMap.size();
        if (size == 0) {
            i2 = i();
            return i2;
        } else if (size != 1) {
            v = v(toMap);
            return v;
        } else {
            return l0.f(toMap);
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M u(kotlin.o<? extends K, ? extends V>[] toMap, M destination) {
        kotlin.jvm.internal.m.g(toMap, "$this$toMap");
        kotlin.jvm.internal.m.g(destination, "destination");
        q(destination, toMap);
        return destination;
    }

    public static <K, V> Map<K, V> v(Map<? extends K, ? extends V> toMutableMap) {
        kotlin.jvm.internal.m.g(toMutableMap, "$this$toMutableMap");
        return new LinkedHashMap(toMutableMap);
    }
}
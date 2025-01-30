package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: collections.kt */
/* loaded from: classes3.dex */
public final class CollectionsKt {
    public static final <T> void addIfNotNull(Collection<T> collection, T t) {
        m.g(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    private static final int capacity(int i2) {
        if (i2 < 3) {
            return 3;
        }
        return i2 + (i2 / 3) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        List<T> g2;
        List<T> b2;
        m.g(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            g2 = r.g();
            return g2;
        } else if (size != 1) {
            arrayList.trimToSize();
            return arrayList;
        } else {
            b2 = q.b(p.Y(arrayList));
            return b2;
        }
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> iterable) {
        m.g(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        for (K k2 : iterable) {
            linkedHashMap.put(k2, Integer.valueOf(i2));
            i2++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i2) {
        return new HashMap<>(capacity(i2));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i2) {
        return new HashSet<>(capacity(i2));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i2) {
        return new LinkedHashSet<>(capacity(i2));
    }
}
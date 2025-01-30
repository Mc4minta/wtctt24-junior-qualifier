package com.coinbase.wallet.common.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* compiled from: Map+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\t\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"T", "", "", "", "mapToSortedList", "(Ljava/util/Map;)Ljava/util/List;", "K", "V", "key", "require", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "toJSON", "(Ljava/util/Map;)Lorg/json/JSONObject;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Map_CommonKt {
    public static final <T> List<T> mapToSortedList(Map<Integer, ? extends T> map) {
        m.g(map, "<this>");
        TreeMap treeMap = new TreeMap(map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            arrayList.add(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        return arrayList;
    }

    public static final <K, V> V require(Map<K, ? extends V> map, K k2) {
        m.g(map, "<this>");
        if (map.containsKey(k2)) {
            V v = map.get(k2);
            if (v != null) {
                return v;
            }
            throw new NoSuchElementException(k2 + " in map is null.");
        }
        throw new NoSuchElementException(k2 + " does not exist in map");
    }

    public static final <K, V> JSONObject toJSON(Map<K, ? extends V> map) {
        m.g(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        return jSONObject;
    }
}
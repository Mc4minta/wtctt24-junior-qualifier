package e.f.d.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImmutableMap.java */
/* loaded from: classes2.dex */
public class f<K, V> extends HashMap<K, V> {
    private f(Map<? extends K, ? extends V> map) {
        super(map);
    }

    public static <K, V> f<K, V> b(Map<? extends K, ? extends V> map) {
        return new f<>(map);
    }

    public static <K, V> Map<K, V> of(K k2, V v) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(k2, v);
        return Collections.unmodifiableMap(hashMap);
    }

    public static <K, V> Map<K, V> of(K k2, V v, K k3, V v2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(k2, v);
        hashMap.put(k3, v2);
        return Collections.unmodifiableMap(hashMap);
    }
}
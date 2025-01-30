package kotlin.a0;

import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes3.dex */
class k0 {
    public static final <K, V> V a(Map<K, ? extends V> getOrImplicitDefault, K k2) {
        kotlin.jvm.internal.m.g(getOrImplicitDefault, "$this$getOrImplicitDefault");
        if (getOrImplicitDefault instanceof i0) {
            return (V) ((i0) getOrImplicitDefault).h(k2);
        }
        V v = getOrImplicitDefault.get(k2);
        if (v != null || getOrImplicitDefault.containsKey(k2)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }
}
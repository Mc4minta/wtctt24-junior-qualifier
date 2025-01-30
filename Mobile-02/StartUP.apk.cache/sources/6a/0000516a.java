package kotlin.a0;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes3.dex */
public class l0 extends k0 {
    public static <K, V> Map<K, V> b(Map<K, V> builder) {
        kotlin.jvm.internal.m.g(builder, "builder");
        return ((kotlin.a0.w0.c) builder).j();
    }

    public static <K, V> Map<K, V> c() {
        return new kotlin.a0.w0.c();
    }

    public static int d(int i2) {
        return i2 < 0 ? i2 : i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
    }

    public static <K, V> Map<K, V> e(kotlin.o<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.m.g(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.m.f(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> f(Map<? extends K, ? extends V> toSingletonMap) {
        kotlin.jvm.internal.m.g(toSingletonMap, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = toSingletonMap.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.m.f(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static <K extends Comparable<? super K>, V> SortedMap<K, V> g(Map<? extends K, ? extends V> toSortedMap) {
        kotlin.jvm.internal.m.g(toSortedMap, "$this$toSortedMap");
        return new TreeMap(toSortedMap);
    }

    public static <K, V> SortedMap<K, V> h(Map<? extends K, ? extends V> toSortedMap, Comparator<? super K> comparator) {
        kotlin.jvm.internal.m.g(toSortedMap, "$this$toSortedMap");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(toSortedMap);
        return treeMap;
    }
}
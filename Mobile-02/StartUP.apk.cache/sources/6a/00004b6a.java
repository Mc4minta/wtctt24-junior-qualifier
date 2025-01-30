package f.c;

import f.c.a;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: MapFactory.java */
/* loaded from: classes2.dex */
public final class f<K, V> extends f.c.a<K, V, V> {

    /* renamed from: b  reason: collision with root package name */
    private static final Provider<Map<Object, Object>> f14012b = e.a(Collections.emptyMap());

    /* compiled from: MapFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<K, V> extends a.AbstractC0335a<K, V, V> {
        public f<K, V> b() {
            return new f<>(this.a);
        }

        public b<K, V> c(K k2, Provider<V> provider) {
            super.a(k2, provider);
            return this;
        }

        private b(int i2) {
            super(i2);
        }
    }

    public static <K, V> b<K, V> b(int i2) {
        return new b<>(i2);
    }

    @Override // javax.inject.Provider
    /* renamed from: c */
    public Map<K, V> get() {
        LinkedHashMap c2 = f.c.b.c(a().size());
        for (Map.Entry<K, Provider<V>> entry : a().entrySet()) {
            c2.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(c2);
    }

    private f(Map<K, Provider<V>> map) {
        super(map);
    }
}
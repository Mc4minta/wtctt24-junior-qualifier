package f.c;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: AbstractMapFactory.java */
/* loaded from: classes2.dex */
abstract class a<K, V, V2> implements d<Map<K, V2>> {
    private final Map<K, Provider<V>> a;

    /* compiled from: AbstractMapFactory.java */
    /* renamed from: f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0335a<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0335a(int i2) {
            this.a = b.c(i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public AbstractC0335a<K, V, V2> a(K k2, Provider<V> provider) {
            this.a.put(h.c(k2, "key"), h.c(provider, "provider"));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Map<K, Provider<V>> map) {
        this.a = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Provider<V>> a() {
        return this.a;
    }
}
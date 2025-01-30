package f.c;

import f.c.a;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: MapProviderFactory.java */
/* loaded from: classes2.dex */
public final class g<K, V> extends f.c.a<K, V, Provider<V>> implements f.a<Map<K, Provider<V>>> {

    /* compiled from: MapProviderFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<K, V> extends a.AbstractC0335a<K, V, Provider<V>> {
        public g<K, V> b() {
            return new g<>(this.a);
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
    public Map<K, Provider<V>> get() {
        return a();
    }

    private g(Map<K, Provider<V>> map) {
        super(map);
    }
}
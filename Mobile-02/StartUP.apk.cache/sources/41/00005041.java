package h.c.n0.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: HashMapSupplier.java */
/* loaded from: classes3.dex */
public enum l implements Callable<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> Callable<Map<K, V>> h() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: n */
    public Map<Object, Object> call() throws Exception {
        return new HashMap();
    }
}
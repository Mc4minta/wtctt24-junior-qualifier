package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.e0.c.a;

/* compiled from: storage.kt */
/* loaded from: classes3.dex */
public interface CacheWithNotNullValues<K, V> {
    V computeIfAbsent(K k2, a<? extends V> aVar);
}
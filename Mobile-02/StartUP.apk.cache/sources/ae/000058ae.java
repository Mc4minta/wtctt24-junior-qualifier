package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.x;

/* compiled from: StorageManager.kt */
/* loaded from: classes3.dex */
public interface StorageManager {
    <T> T compute(a<? extends T> aVar);

    <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues();

    <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues();

    <T> NotNullLazyValue<T> createLazyValue(a<? extends T> aVar);

    <T> NotNullLazyValue<T> createLazyValueWithPostCompute(a<? extends T> aVar, l<? super Boolean, ? extends T> lVar, l<? super T, x> lVar2);

    <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(l<? super K, ? extends V> lVar);

    <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(l<? super K, ? extends V> lVar);

    <T> NullableLazyValue<T> createNullableLazyValue(a<? extends T> aVar);

    <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(a<? extends T> aVar, T t);
}
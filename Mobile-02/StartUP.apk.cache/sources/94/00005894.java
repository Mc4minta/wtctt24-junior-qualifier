package kotlin.reflect.jvm.internal.impl.storage;

import com.appsflyer.internal.referrer.Payload;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.x;

/* loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final StorageManager NO_LOCKS;
    private static final String PACKAGE_NAME;
    private final String debugText;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    protected final SimpleLock lock;

    /* loaded from: classes3.dex */
    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V> extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V> implements CacheWithNotNullValues<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "computation";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i2 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        public V computeIfAbsent(K k2, a<? extends V> aVar) {
            if (aVar == null) {
                $$$reportNull$$$0(2);
            }
            V v = (V) super.computeIfAbsent(k2, aVar);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNotNullValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(concurrentMap);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V> extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V> implements CacheWithNullableValues<K, V> {
        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i2 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V computeIfAbsent(K k2, a<? extends V> aVar) {
            if (aVar == null) {
                $$$reportNull$$$0(2);
            }
            return invoke(new KeyWithComputation(k2, aVar));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private CacheWithNullableValuesBasedOnMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<KeyWithComputation<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new l<KeyWithComputation<K, V>, V>() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNullableValuesBasedOnMemoizedFunction.1
                @Override // kotlin.e0.c.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((KeyWithComputation<K, Object>) obj);
                }

                public V invoke(KeyWithComputation<K, V> keyWithComputation) {
                    return (V) ((KeyWithComputation) keyWithComputation).computation.invoke();
                }
            });
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy() { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy.1
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    $$$reportNull$$$0(0);
                }
                throw ExceptionUtilsKt.rethrow(th);
            }
        };

        RuntimeException handleException(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class KeyWithComputation<K, V> {
        private final a<? extends V> computation;
        private final K key;

        public KeyWithComputation(K k2, a<? extends V> aVar) {
            this.key = k2;
            this.computation = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.key.equals(((KeyWithComputation) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LockBasedLazyValue<T> implements NullableLazyValue<T> {
        private final a<? extends T> computable;
        private final LockBasedStorageManager storageManager;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = (i2 == 2 || i2 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 2 || i2 == 3) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 == 2 || i2 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i2 != 2 && i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public LockBasedLazyValue(LockBasedStorageManager lockBasedStorageManager, a<? extends T> aVar) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (aVar == null) {
                $$$reportNull$$$0(1);
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = lockBasedStorageManager;
            this.computable = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue, kotlin.e0.c.a
        public T invoke() {
            T invoke;
            Object obj = this.value;
            if (obj instanceof NotValue) {
                this.storageManager.lock.lock();
                try {
                    Object obj2 = this.value;
                    if (obj2 instanceof NotValue) {
                        NotValue notValue = NotValue.COMPUTING;
                        if (obj2 == notValue) {
                            this.value = NotValue.RECURSION_WAS_DETECTED;
                            RecursionDetectedResult<T> recursionDetected = recursionDetected(true);
                            if (!recursionDetected.isFallThrough()) {
                                invoke = recursionDetected.getValue();
                            }
                        }
                        if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                            RecursionDetectedResult<T> recursionDetected2 = recursionDetected(false);
                            if (!recursionDetected2.isFallThrough()) {
                                invoke = recursionDetected2.getValue();
                            }
                        }
                        this.value = notValue;
                        invoke = this.computable.invoke();
                        postCompute(invoke);
                        this.value = invoke;
                    } else {
                        invoke = (T) WrappedValues.unescapeThrowable(obj2);
                    }
                    return invoke;
                } finally {
                    this.storageManager.lock.unlock();
                }
            }
            return (T) WrappedValues.unescapeThrowable(obj);
        }

        public boolean isComputed() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }

        protected void postCompute(T t) {
        }

        protected RecursionDetectedResult<T> recursionDetected(boolean z) {
            RecursionDetectedResult<T> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("in a lazy value", null);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(2);
            }
            return recursionDetectedDefault;
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class LockBasedLazyValueWithPostCompute<T> extends LockBasedLazyValue<T> {
        private volatile SingleThreadValue<T> valuePostCompute;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (aVar == null) {
                $$$reportNull$$$0(1);
            }
            this.valuePostCompute = null;
        }

        protected abstract void doPostCompute(T t);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue, kotlin.e0.c.a
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.valuePostCompute;
            if (singleThreadValue != null && singleThreadValue.hasValue()) {
                return singleThreadValue.getValue();
            }
            return (T) super.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
        protected final void postCompute(T t) {
            this.valuePostCompute = new SingleThreadValue<>(t);
            try {
                doPostCompute(t);
            } finally {
                this.valuePostCompute = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class LockBasedNotNullLazyValue<T> extends LockBasedLazyValue<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValue(LockBasedStorageManager lockBasedStorageManager, a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (aVar == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue, kotlin.e0.c.a
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    /* loaded from: classes3.dex */
    private static abstract class LockBasedNotNullLazyValueWithPostCompute<T> extends LockBasedLazyValueWithPostCompute<T> implements NotNullLazyValue<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockBasedNotNullLazyValueWithPostCompute(LockBasedStorageManager lockBasedStorageManager, a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (aVar == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue, kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue, kotlin.e0.c.a
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                $$$reportNull$$$0(2);
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final ConcurrentMap<K, Object> cache;
        private final l<? super K, ? extends V> compute;
        private final LockBasedStorageManager storageManager;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 == 3 || i2 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i2 != 3 && i2 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 3 && i2 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public MapBasedMemoizedFunction(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, l<? super K, ? extends V> lVar) {
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (lVar == null) {
                $$$reportNull$$$0(2);
            }
            this.storageManager = lockBasedStorageManager;
            this.cache = concurrentMap;
            this.compute = lVar;
        }

        private AssertionError raceCondition(K k2, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.sanitizeStackTrace(new AssertionError("Race condition detected on input " + k2 + ". Old value is " + obj + " under " + this.storageManager));
            if (assertionError == null) {
                $$$reportNull$$$0(4);
            }
            return assertionError;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable, kotlin.e0.c.l
        public V invoke(K k2) {
            V v;
            Object obj = this.cache.get(k2);
            if (obj == null || obj == NotValue.COMPUTING) {
                this.storageManager.lock.lock();
                try {
                    Object obj2 = this.cache.get(k2);
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        obj2 = NotValue.RECURSION_WAS_DETECTED;
                        RecursionDetectedResult<V> recursionDetected = recursionDetected(k2, true);
                        if (!recursionDetected.isFallThrough()) {
                            v = recursionDetected.getValue();
                            return v;
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        RecursionDetectedResult<V> recursionDetected2 = recursionDetected(k2, false);
                        if (!recursionDetected2.isFallThrough()) {
                            v = recursionDetected2.getValue();
                            return v;
                        }
                    }
                    if (obj2 != null) {
                        v = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                        return v;
                    }
                    this.cache.put(k2, notValue);
                    V invoke = this.compute.invoke(k2);
                    Object put = this.cache.put(k2, WrappedValues.escapeNull(invoke));
                    if (put == notValue) {
                        return invoke;
                    }
                    throw raceCondition(k2, put);
                } finally {
                    this.storageManager.lock.unlock();
                }
            }
            return (V) WrappedValues.unescapeExceptionOrNull(obj);
        }

        protected RecursionDetectedResult<V> recursionDetected(K k2, boolean z) {
            RecursionDetectedResult<V> recursionDetectedDefault = this.storageManager.recursionDetectedDefault("", k2);
            if (recursionDetectedDefault == null) {
                $$$reportNull$$$0(3);
            }
            return recursionDetectedDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MapBasedMemoizedFunctionToNotNull<K, V> extends MapBasedMemoizedFunction<K, V> implements MemoizedFunctionToNotNull<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MapBasedMemoizedFunctionToNotNull(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, l<? super K, ? extends V> lVar) {
            super(lockBasedStorageManager, concurrentMap, lVar);
            if (lockBasedStorageManager == null) {
                $$$reportNull$$$0(0);
            }
            if (concurrentMap == null) {
                $$$reportNull$$$0(1);
            }
            if (lVar == null) {
                $$$reportNull$$$0(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.MapBasedMemoizedFunction, kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable, kotlin.e0.c.l
        public V invoke(K k2) {
            V v = (V) super.invoke(k2);
            if (v == null) {
                $$$reportNull$$$0(3);
            }
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class RecursionDetectedResult<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean fallThrough;
        private final T value;

        private RecursionDetectedResult(T t, boolean z) {
            this.value = t;
            this.fallThrough = z;
        }

        public static <T> RecursionDetectedResult<T> fallThrough() {
            return new RecursionDetectedResult<>(null, true);
        }

        public static <T> RecursionDetectedResult<T> value(T t) {
            return new RecursionDetectedResult<>(t, false);
        }

        public T getValue() {
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.$$$reportNull$$$0(int):void");
    }

    static {
        String g1;
        g1 = y.g1(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        PACKAGE_NAME = g1;
        NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, EmptySimpleLock.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.1
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                Object[] objArr = new Object[i2 != 1 ? 3 : 2];
                if (i2 != 1) {
                    objArr[0] = Payload.SOURCE;
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                }
                if (i2 != 1) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
                } else {
                    objArr[1] = "recursionDetectedDefault";
                }
                if (i2 != 1) {
                    objArr[2] = "recursionDetectedDefault";
                }
                String format = String.format(str, objArr);
                if (i2 == 1) {
                    throw new IllegalStateException(format);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
            protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k2) {
                if (str == null) {
                    $$$reportNull$$$0(0);
                }
                RecursionDetectedResult<V> fallThrough = RecursionDetectedResult.fallThrough();
                if (fallThrough == null) {
                    $$$reportNull$$$0(1);
                }
                return fallThrough;
            }
        };
    }

    static /* synthetic */ ExceptionHandlingStrategy access$100(LockBasedStorageManager lockBasedStorageManager) {
        return lockBasedStorageManager.exceptionHandlingStrategy;
    }

    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T sanitizeStackTrace(T t) {
        if (t == null) {
            $$$reportNull$$$0(36);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            } else if (!stackTrace[i3].getClassName().startsWith(PACKAGE_NAME)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(a<? extends T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(34);
        }
        this.lock.lock();
        try {
            return aVar.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new CacheWithNotNullValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new CacheWithNullableValuesBasedOnMemoizedFunction(createConcurrentHashMap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValue(a<? extends T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(23);
        }
        return new LockBasedNotNullLazyValue(this, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(a<? extends T> aVar, final l<? super Boolean, ? extends T> lVar, final l<? super T, x> lVar2) {
        if (aVar == null) {
            $$$reportNull$$$0(28);
        }
        if (lVar2 == null) {
            $$$reportNull$$$0(29);
        }
        return new LockBasedNotNullLazyValueWithPostCompute<T>(this, aVar) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.5
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                String str = i2 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                Object[] objArr = new Object[i2 != 2 ? 2 : 3];
                if (i2 != 2) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                } else {
                    objArr[0] = "value";
                }
                if (i2 != 2) {
                    objArr[1] = "recursionDetected";
                } else {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
                }
                if (i2 == 2) {
                    objArr[2] = "doPostCompute";
                }
                String format = String.format(str, objArr);
                if (i2 == 2) {
                    throw new IllegalArgumentException(format);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValueWithPostCompute
            protected void doPostCompute(T t) {
                if (t == null) {
                    $$$reportNull$$$0(2);
                }
                lVar2.invoke(t);
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean z) {
                l lVar3 = lVar;
                if (lVar3 == null) {
                    RecursionDetectedResult<T> recursionDetected = super.recursionDetected(z);
                    if (recursionDetected == null) {
                        $$$reportNull$$$0(0);
                    }
                    return recursionDetected;
                }
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(lVar3.invoke(Boolean.valueOf(z)));
                if (value == null) {
                    $$$reportNull$$$0(1);
                }
                return value;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            $$$reportNull$$$0(9);
        }
        MemoizedFunctionToNotNull<K, V> createMemoizedFunction = createMemoizedFunction(lVar, createConcurrentHashMap());
        if (createMemoizedFunction == null) {
            $$$reportNull$$$0(10);
        }
        return createMemoizedFunction;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            $$$reportNull$$$0(19);
        }
        MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(lVar, createConcurrentHashMap());
        if (createMemoizedFunctionWithNullableValues == null) {
            $$$reportNull$$$0(20);
        }
        return createMemoizedFunctionWithNullableValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NullableLazyValue<T> createNullableLazyValue(a<? extends T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(30);
        }
        return new LockBasedLazyValue(this, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(a<? extends T> aVar, final T t) {
        if (aVar == null) {
            $$$reportNull$$$0(26);
        }
        if (t == null) {
            $$$reportNull$$$0(27);
        }
        return new LockBasedNotNullLazyValue<T>(this, aVar) { // from class: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.4
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.LockBasedLazyValue
            protected RecursionDetectedResult<T> recursionDetected(boolean z) {
                RecursionDetectedResult<T> value = RecursionDetectedResult.value(t);
                if (value == null) {
                    $$$reportNull$$$0(0);
                }
                return value;
            }
        };
    }

    protected <K, V> RecursionDetectedResult<V> recursionDetectedDefault(String str, K k2) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k2 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k2;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.debugText + ")";
    }

    private LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock simpleLock) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (exceptionHandlingStrategy == null) {
            $$$reportNull$$$0(5);
        }
        if (simpleLock == null) {
            $$$reportNull$$$0(6);
        }
        this.lock = simpleLock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = str;
    }

    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            $$$reportNull$$$0(14);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(15);
        }
        return new MapBasedMemoizedFunctionToNotNull(this, concurrentMap, lVar);
    }

    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(l<? super K, ? extends V> lVar, ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            $$$reportNull$$$0(21);
        }
        if (concurrentMap == null) {
            $$$reportNull$$$0(22);
        }
        return new MapBasedMemoizedFunction(this, concurrentMap, lVar);
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (l<InterruptedException, x>) null);
    }

    public LockBasedStorageManager(String str, Runnable runnable, l<InterruptedException, x> lVar) {
        this(str, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.simpleLock(runnable, lVar));
    }
}
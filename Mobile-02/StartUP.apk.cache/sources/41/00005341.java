package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.e0.c.a;

/* loaded from: classes3.dex */
public class ReflectProperties {

    /* loaded from: classes3.dex */
    public static class LazySoftVal<T> extends Val<T> implements a<T> {
        private final a<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        public LazySoftVal(T t, a<T> aVar) {
            if (aVar == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = aVar;
            if (t != null) {
                this.value = new SoftReference<>(escape(t));
            }
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.e0.c.a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.value;
            if (softReference != null && (obj = softReference.get()) != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = new SoftReference<>(escape(invoke));
            return invoke;
        }
    }

    /* loaded from: classes3.dex */
    public static class LazyVal<T> extends Val<T> {
        private final a<T> initializer;
        private volatile Object value;

        private static /* synthetic */ void $$$reportNull$$$0(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        public LazyVal(a<T> aVar) {
            if (aVar == null) {
                $$$reportNull$$$0(0);
            }
            this.value = null;
            this.initializer = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.e0.c.a
        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return unescape(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = escape(invoke);
            return invoke;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object() { // from class: kotlin.reflect.jvm.internal.ReflectProperties.Val.1
        };

        protected Object escape(T t) {
            return t == null ? NULL_VALUE : t;
        }

        public final T getValue(Object obj, Object obj2) {
            return invoke();
        }

        public abstract T invoke();

        /* JADX WARN: Multi-variable type inference failed */
        protected T unescape(Object obj) {
            if (obj == NULL_VALUE) {
                return null;
            }
            return obj;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i2) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i2 == 1 || i2 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> LazyVal<T> lazy(a<T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(0);
        }
        return new LazyVal<>(aVar);
    }

    public static <T> LazySoftVal<T> lazySoft(T t, a<T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(1);
        }
        return new LazySoftVal<>(t, aVar);
    }

    public static <T> LazySoftVal<T> lazySoft(a<T> aVar) {
        if (aVar == null) {
            $$$reportNull$$$0(2);
        }
        return lazySoft(null, aVar);
    }
}
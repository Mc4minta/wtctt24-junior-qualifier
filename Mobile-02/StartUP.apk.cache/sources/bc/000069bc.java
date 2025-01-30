package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: CallAdapter.java */
/* loaded from: classes3.dex */
public interface e<R, T> {

    /* compiled from: CallAdapter.java */
    /* loaded from: classes3.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type getParameterUpperBound(int i2, ParameterizedType parameterizedType) {
            return x.g(i2, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> getRawType(Type type) {
            return x.h(type);
        }

        public abstract e<?, ?> get(Type type, Annotation[] annotationArr, t tVar);
    }

    T adapt(d<R> dVar);

    Type responseType();
}
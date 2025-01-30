package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: Converter.java */
/* loaded from: classes3.dex */
public interface h<F, T> {

    /* compiled from: Converter.java */
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

        public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, t tVar) {
            return null;
        }

        public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, t tVar) {
            return null;
        }

        public h<?, String> stringConverter(Type type, Annotation[] annotationArr, t tVar) {
            return null;
        }
    }

    T convert(F f2) throws IOException;
}
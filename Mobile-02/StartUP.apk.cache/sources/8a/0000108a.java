package com.coinbase.network;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.d;
import retrofit2.e;
import retrofit2.t;

/* loaded from: classes.dex */
public class ApiCallAdapterFactory extends e.a {

    /* loaded from: classes.dex */
    private static class CoinbaseCallAdapter implements e<Object, ApiCall<?>> {
        private final Executor callbackExacutor;
        private final Type responseType;

        CoinbaseCallAdapter(Type type, Executor executor) {
            this.responseType = type;
            this.callbackExacutor = executor;
        }

        @Override // retrofit2.e
        public Type responseType() {
            return this.responseType;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // retrofit2.e
        public ApiCall<?> adapt(d<Object> dVar) {
            return new ApiCall<>(dVar, this.callbackExacutor);
        }
    }

    public static ApiCallAdapterFactory create() {
        return new ApiCallAdapterFactory();
    }

    @Override // retrofit2.e.a
    public e<?, ApiCall<?>> get(Type type, Annotation[] annotationArr, t tVar) {
        if (e.a.getRawType(type) != ApiCall.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException(ApiCall.class.getCanonicalName() + " must be parametrized with response type");
        }
        return new CoinbaseCallAdapter(e.a.getParameterUpperBound(0, (ParameterizedType) type), tVar.b());
    }
}
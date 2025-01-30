package com.coinbase.network.adapter;

import com.squareup.moshi.Types;
import h.c.b0;
import h.c.h;
import h.c.o;
import h.c.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import retrofit2.e;
import retrofit2.t;

/* compiled from: KotlinRxJava2CallAdapterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ8\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/network/adapter/KotlinRxJava2CallAdapterFactory;", "Lretrofit2/e$a;", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Lretrofit2/t;", "retrofit", "Lretrofit2/e;", "get", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/t;)Lretrofit2/e;", "<init>", "()V", "Companion", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class KotlinRxJava2CallAdapterFactory extends e.a {
    public static final Companion Companion = new Companion(null);

    /* compiled from: KotlinRxJava2CallAdapterFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/network/adapter/KotlinRxJava2CallAdapterFactory$Companion;", "", "Lcom/coinbase/network/adapter/KotlinRxJava2CallAdapterFactory;", "create", "()Lcom/coinbase/network/adapter/KotlinRxJava2CallAdapterFactory;", "<init>", "()V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KotlinRxJava2CallAdapterFactory create() {
            return new KotlinRxJava2CallAdapterFactory(null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private KotlinRxJava2CallAdapterFactory() {
    }

    public static final KotlinRxJava2CallAdapterFactory create() {
        return Companion.create();
    }

    @Override // retrofit2.e.a
    public e<?, ?> get(Type returnType, Annotation[] annotations, t retrofit) {
        m.h(returnType, "returnType");
        m.h(annotations, "annotations");
        m.h(retrofit, "retrofit");
        Class rawType = e.a.getRawType(returnType);
        boolean z = rawType == h.class;
        boolean z2 = rawType == b0.class;
        boolean z3 = rawType == o.class;
        if (rawType == s.class || z || z2 || z3) {
            if (returnType instanceof ParameterizedType) {
                Type parameterUpperBound = e.a.getParameterUpperBound(0, (ParameterizedType) returnType);
                if (!m.c(e.a.getRawType(parameterUpperBound), NetworkResponse.class)) {
                    return null;
                }
                if (parameterUpperBound instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) parameterUpperBound;
                    Type successBodyType = e.a.getParameterUpperBound(0, parameterizedType);
                    e<?, ?> f2 = retrofit.f(this, Types.newParameterizedType(s.class, successBodyType), annotations);
                    retrofit2.h errorBodyConverter = retrofit.h(null, e.a.getParameterUpperBound(1, parameterizedType), new Annotation[0]);
                    m.d(successBodyType, "successBodyType");
                    if (f2 != null) {
                        m.d(errorBodyConverter, "errorBodyConverter");
                        return new KotlinRxJava2CallAdapter(successBodyType, f2, errorBodyConverter, z, z2, z3);
                    }
                    throw new TypeCastException("null cannot be cast to non-null type retrofit2.CallAdapter<kotlin.Any, io.reactivex.Observable<kotlin.Any>>");
                }
                throw new IllegalStateException("NetworkResponse must be parameterized as NetworkResponse<SuccessBody, ErrorBody>");
            }
            StringBuilder sb = new StringBuilder();
            m.d(rawType, "rawType");
            sb.append(rawType.getSimpleName());
            sb.append(" return type must be parameterized as ");
            sb.append(rawType.getSimpleName());
            sb.append("<Foo> or ");
            sb.append(rawType.getSimpleName());
            sb.append("<? extends Foo>");
            throw new IllegalStateException(sb.toString());
        }
        return null;
    }

    public /* synthetic */ KotlinRxJava2CallAdapterFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
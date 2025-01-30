package retrofit2.adapter.rxjava2;

import h.c.a0;
import h.c.b0;
import h.c.h;
import h.c.o;
import h.c.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.e;
import retrofit2.t;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class g extends e.a {
    private final a0 a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17898b;

    private g(a0 a0Var, boolean z) {
        this.a = a0Var;
        this.f17898b = z;
    }

    public static g a() {
        return new g(null, false);
    }

    public static g b(a0 a0Var) {
        Objects.requireNonNull(a0Var, "scheduler == null");
        return new g(a0Var, false);
    }

    @Override // retrofit2.e.a
    public retrofit2.e<?, ?> get(Type type, Annotation[] annotationArr, t tVar) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> rawType = e.a.getRawType(type);
        if (rawType == h.c.c.class) {
            return new f(Void.class, this.a, this.f17898b, false, true, false, false, false, true);
        }
        boolean z3 = rawType == h.class;
        boolean z4 = rawType == b0.class;
        boolean z5 = rawType == o.class;
        if (rawType == s.class || z3 || z4 || z5) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type parameterUpperBound = e.a.getParameterUpperBound(0, (ParameterizedType) type);
            Class<?> rawType2 = e.a.getRawType(parameterUpperBound);
            if (rawType2 == retrofit2.s.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = e.a.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z2 = false;
                    z = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (rawType2 != d.class) {
                type2 = parameterUpperBound;
                z = true;
                z2 = false;
            } else if (parameterUpperBound instanceof ParameterizedType) {
                type2 = e.a.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z2 = true;
                z = false;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            return new f(type2, this.a, this.f17898b, z2, z, z3, z4, z5, false);
        }
        return null;
    }
}
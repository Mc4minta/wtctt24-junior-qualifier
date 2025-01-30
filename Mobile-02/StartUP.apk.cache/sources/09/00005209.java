package kotlin.j0.b0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.j0.g;
import kotlin.j0.h;
import kotlin.j0.q;
import kotlin.j0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;

/* compiled from: ReflectJvmMapping.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final <T> Constructor<T> a(g<? extends T> javaConstructor) {
        Caller<?> caller;
        m.g(javaConstructor, "$this$javaConstructor");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(javaConstructor);
        Object mo2204getMember = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.mo2204getMember();
        return mo2204getMember instanceof Constructor ? mo2204getMember : null;
    }

    public static final Field b(kotlin.j0.m<?> javaField) {
        m.g(javaField, "$this$javaField");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(javaField);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    public static final Method c(kotlin.j0.m<?> javaGetter) {
        m.g(javaGetter, "$this$javaGetter");
        return d(javaGetter.getGetter());
    }

    public static final Method d(g<?> javaMethod) {
        Caller<?> caller;
        m.g(javaMethod, "$this$javaMethod");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(javaMethod);
        Object mo2204getMember = (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) ? null : caller.mo2204getMember();
        return mo2204getMember instanceof Method ? mo2204getMember : null;
    }

    public static final Method e(h<?> javaSetter) {
        m.g(javaSetter, "$this$javaSetter");
        return d(javaSetter.getSetter());
    }

    public static final Type f(q javaType) {
        m.g(javaType, "$this$javaType");
        Type javaType2 = ((KTypeImpl) javaType).getJavaType();
        return javaType2 != null ? javaType2 : z.f(javaType);
    }
}
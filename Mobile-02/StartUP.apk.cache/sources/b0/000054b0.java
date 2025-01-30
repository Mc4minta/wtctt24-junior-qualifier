package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: classes3.dex */
final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    private SignatureSerializer() {
    }

    public final String constructorDesc(Constructor<?> constructor) {
        m.g(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        m.f(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i2 = 0;
        while (i2 < length) {
            Class<?> parameterType = parameterTypes[i2];
            i2++;
            m.f(parameterType, "parameterType");
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        m.f(sb2, "sb.toString()");
        return sb2;
    }

    public final String fieldDesc(Field field) {
        m.g(field, "field");
        Class<?> type = field.getType();
        m.f(type, "field.type");
        return ReflectClassUtilKt.getDesc(type);
    }

    public final String methodDesc(Method method) {
        m.g(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        m.f(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i2 = 0;
        while (i2 < length) {
            Class<?> parameterType = parameterTypes[i2];
            i2++;
            m.f(parameterType, "parameterType");
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        m.f(returnType, "method.returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        String sb2 = sb.toString();
        m.f(sb2, "sb.toString()");
        return sb2;
    }
}
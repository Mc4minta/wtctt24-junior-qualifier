package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.a0.n;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "signature", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class RuntimeTypeMapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getSignature(Method method) {
        String M;
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        m.f(parameterTypes, "parameterTypes");
        M = n.M(parameterTypes, "", "(", ")", 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24, null);
        sb.append(M);
        Class<?> returnType = method.getReturnType();
        m.f(returnType, "returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }
}
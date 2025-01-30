package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: ServiceMethod.java */
/* loaded from: classes3.dex */
abstract class u<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> u<T> b(t tVar, Method method) {
        r b2 = r.b(tVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!x.j(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return j.f(tVar, method, b2);
            }
            throw x.m(method, "Service methods cannot return void.", new Object[0]);
        }
        throw x.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(Object[] objArr);
}
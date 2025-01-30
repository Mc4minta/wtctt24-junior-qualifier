package kotlin.reflect.jvm.internal.calls;

import com.coinbase.ApiConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.j;
import kotlin.a0.n;
import kotlin.a0.s;
import kotlin.e0.a;
import kotlin.h;
import kotlin.j0.d;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.apache.http.message.TokenParser;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00000\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "Ljava/lang/Class;", "expectedType", "transformKotlinToJvm", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "", "index", "", ApiConstants.NAME, "expectedJvmType", "", "throwIllegalArgumentType", "(ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Void;", "T", "annotationClass", "", "values", "", "Ljava/lang/reflect/Method;", "methods", "createAnnotationInstance", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCallerKt {
    public static final <T> T createAnnotationInstance(final Class<T> annotationClass, final Map<String, ? extends Object> values, List<Method> methods) {
        final h b2;
        final h b3;
        m.g(annotationClass, "annotationClass");
        m.g(values, "values");
        m.g(methods, "methods");
        final AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2 = new AnnotationConstructorCallerKt$createAnnotationInstance$2(annotationClass, methods, values);
        b2 = k.b(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(values));
        b3 = k.b(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(annotationClass, values));
        T t = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new InvocationHandler() { // from class: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$result$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                List e0;
                m.f(method, "method");
                String name = method.getName();
                if (name != null) {
                    int hashCode = name.hashCode();
                    if (hashCode != -1776922004) {
                        if (hashCode != 147696667) {
                            if (hashCode == 1444986633 && name.equals("annotationType")) {
                                return annotationClass;
                            }
                        } else if (name.equals("hashCode")) {
                            return b2.getValue();
                        }
                    } else if (name.equals("toString")) {
                        return b3.getValue();
                    }
                }
                if (m.c(name, "equals") && objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(annotationConstructorCallerKt$createAnnotationInstance$2.invoke2(j.R(objArr)));
                }
                if (values.containsKey(name)) {
                    return values.get(name);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Method is not supported: ");
                sb.append(method);
                sb.append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                e0 = n.e0(objArr);
                sb.append(e0);
                sb.append(')');
                throw new KotlinReflectionInternalError(sb.toString());
            }
        });
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class cls, Map map, List list, int i2, Object obj) {
        int r;
        if ((i2 & 4) != 0) {
            Set<String> keySet = map.keySet();
            r = s.r(keySet, 10);
            ArrayList arrayList = new ArrayList(r);
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return createAnnotationInstance(cls, map, list);
    }

    public static final Void throwIllegalArgumentType(int i2, String str, Class<?> cls) {
        d e2;
        String qualifiedName;
        if (m.c(cls, Class.class)) {
            e2 = e0.b(d.class);
        } else if (cls.isArray() && m.c(cls.getComponentType(), Class.class)) {
            e2 = e0.b(d[].class);
        } else {
            e2 = a.e(cls);
        }
        if (m.c(e2.getQualifiedName(), e0.b(Object[].class).getQualifiedName())) {
            StringBuilder sb = new StringBuilder();
            sb.append(e2.getQualifiedName());
            sb.append('<');
            Class<?> componentType = a.b(e2).getComponentType();
            m.f(componentType, "kotlinClass.java.componentType");
            sb.append(a.e(componentType).getQualifiedName());
            sb.append('>');
            qualifiedName = sb.toString();
        } else {
            qualifiedName = e2.getQualifiedName();
        }
        throw new IllegalArgumentException("Argument #" + i2 + TokenParser.SP + str + " is not of the required type " + qualifiedName);
    }

    public static final Object transformKotlinToJvm(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof d) {
            obj = a.b((d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof d[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                d[] dVarArr = (d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                for (d dVar : dVarArr) {
                    arrayList.add(a.b(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
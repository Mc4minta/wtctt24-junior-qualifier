package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.d;
import kotlin.e0.a;
import kotlin.e0.c.b;
import kotlin.e0.c.c;
import kotlin.e0.c.e;
import kotlin.e0.c.f;
import kotlin.e0.c.g;
import kotlin.e0.c.h;
import kotlin.e0.c.i;
import kotlin.e0.c.j;
import kotlin.e0.c.k;
import kotlin.e0.c.l;
import kotlin.e0.c.m;
import kotlin.e0.c.n;
import kotlin.e0.c.o;
import kotlin.e0.c.p;
import kotlin.e0.c.q;
import kotlin.e0.c.t;
import kotlin.e0.c.v;
import kotlin.e0.c.w;
import kotlin.jvm.internal.e0;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.u;

/* compiled from: reflectClassUtil.kt */
/* loaded from: classes3.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends d<?>>, Integer> FUNCTION_CLASSES;
    private static final List<kotlin.j0.d<? extends Object>> PRIMITIVE_CLASSES;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    static {
        List<kotlin.j0.d<? extends Object>> j2;
        int r;
        Map<Class<? extends Object>, Class<? extends Object>> r2;
        int r3;
        Map<Class<? extends Object>, Class<? extends Object>> r4;
        List j3;
        int r5;
        Map<Class<? extends d<?>>, Integer> r6;
        int i2 = 0;
        j2 = r.j(e0.b(Boolean.TYPE), e0.b(Byte.TYPE), e0.b(Character.TYPE), e0.b(Double.TYPE), e0.b(Float.TYPE), e0.b(Integer.TYPE), e0.b(Long.TYPE), e0.b(Short.TYPE));
        PRIMITIVE_CLASSES = j2;
        r = s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<T> it = j2.iterator();
        while (it.hasNext()) {
            kotlin.j0.d dVar = (kotlin.j0.d) it.next();
            arrayList.add(u.a(a.c(dVar), a.d(dVar)));
        }
        r2 = m0.r(arrayList);
        WRAPPER_TO_PRIMITIVE = r2;
        List<kotlin.j0.d<? extends Object>> list = PRIMITIVE_CLASSES;
        r3 = s.r(list, 10);
        ArrayList arrayList2 = new ArrayList(r3);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            kotlin.j0.d dVar2 = (kotlin.j0.d) it2.next();
            arrayList2.add(u.a(a.d(dVar2), a.c(dVar2)));
        }
        r4 = m0.r(arrayList2);
        PRIMITIVE_TO_WRAPPER = r4;
        j3 = r.j(kotlin.e0.c.a.class, l.class, p.class, q.class, kotlin.e0.c.r.class, kotlin.e0.c.s.class, t.class, kotlin.e0.c.u.class, v.class, w.class, b.class, c.class, kotlin.e0.c.d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        r5 = s.r(j3, 10);
        ArrayList arrayList3 = new ArrayList(r5);
        for (Object obj : j3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            arrayList3.add(u.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        r6 = m0.r(arrayList3);
        FUNCTION_CLASSES = r6;
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final ClassId getClassId(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    String simpleName = cls.getSimpleName();
                    kotlin.jvm.internal.m.f(simpleName, "simpleName");
                    if (!(simpleName.length() == 0)) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        ClassId createNestedClassId = declaringClass == null ? null : getClassId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
                        if (createNestedClassId == null) {
                            createNestedClassId = ClassId.topLevel(new FqName(cls.getName()));
                        }
                        kotlin.jvm.internal.m.f(createNestedClassId, "declaringClass?.classId?.createNestedClassId(Name.identifier(simpleName)) ?: ClassId.topLevel(FqName(name))");
                        return createNestedClassId;
                    }
                }
                FqName fqName = new FqName(cls.getName());
                return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.m.o("Can't compute ClassId for array type: ", cls));
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.m.o("Can't compute ClassId for primitive type: ", cls));
    }

    public static final String getDesc(Class<?> cls) {
        String J;
        kotlin.jvm.internal.m.g(cls, "<this>");
        if (kotlin.jvm.internal.m.c(cls, Void.TYPE)) {
            return "V";
        }
        String name = createArrayType(cls).getName();
        kotlin.jvm.internal.m.f(name, "createArrayType().name");
        String substring = name.substring(1);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.String).substring(startIndex)");
        J = x.J(substring, '.', '/', false, 4, null);
        return J;
    }

    public static final Integer getFunctionClassArity(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        return FUNCTION_CLASSES.get(cls);
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        kotlin.k0.h g2;
        kotlin.k0.h q;
        List<Type> B;
        List<Type> e0;
        List<Type> g3;
        kotlin.jvm.internal.m.g(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            g3 = r.g();
            return g3;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            kotlin.jvm.internal.m.f(actualTypeArguments, "actualTypeArguments");
            e0 = kotlin.a0.n.e0(actualTypeArguments);
            return e0;
        }
        g2 = kotlin.k0.n.g(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE);
        q = kotlin.k0.p.q(g2, ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE);
        B = kotlin.k0.p.B(q);
        return B;
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            kotlin.jvm.internal.m.f(systemClassLoader, "getSystemClassLoader()");
            return systemClassLoader;
        }
        return classLoader;
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        kotlin.jvm.internal.m.g(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
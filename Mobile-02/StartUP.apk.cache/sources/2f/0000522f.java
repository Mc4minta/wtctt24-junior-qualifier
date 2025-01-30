package kotlin.j0;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.HttpUrl;

/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class a extends kotlin.jvm.internal.k implements kotlin.e0.c.l<Class<? extends Object>, Class<?>> {
        public static final a a = new a();

        a() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final Class<?> invoke(Class<?> p1) {
            kotlin.jvm.internal.m.g(p1, "p1");
            return p1.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(q qVar, boolean z) {
        int i2;
        e classifier = qVar.getClassifier();
        if (classifier instanceof r) {
            return new x((r) classifier);
        }
        if (classifier instanceof d) {
            d dVar = (d) classifier;
            Class c2 = z ? kotlin.e0.a.c(dVar) : kotlin.e0.a.b(dVar);
            List<s> arguments = qVar.getArguments();
            if (arguments.isEmpty()) {
                return c2;
            }
            if (c2.isArray()) {
                Class<?> componentType = c2.getComponentType();
                kotlin.jvm.internal.m.f(componentType, "jClass.componentType");
                if (componentType.isPrimitive()) {
                    return c2;
                }
                s sVar = (s) kotlin.a0.p.z0(arguments);
                if (sVar != null) {
                    u a2 = sVar.a();
                    q b2 = sVar.b();
                    if (a2 == null || (i2 = y.a[a2.ordinal()]) == 1) {
                        return c2;
                    }
                    if (i2 != 2 && i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    kotlin.jvm.internal.m.e(b2);
                    Type d2 = d(b2, false, 1, null);
                    return d2 instanceof Class ? c2 : new kotlin.j0.a(d2);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + qVar);
            }
            return e(c2, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + qVar);
    }

    static /* synthetic */ Type d(q qVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c(qVar, z);
    }

    private static final Type e(Class<?> cls, List<s> list) {
        int r;
        int r2;
        int r3;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                r3 = kotlin.a0.s.r(list, 10);
                ArrayList arrayList = new ArrayList(r3);
                for (s sVar : list) {
                    arrayList.add(g(sVar));
                }
                return new w(cls, declaringClass, arrayList);
            }
            int length = cls.getTypeParameters().length;
            Type e2 = e(declaringClass, list.subList(length, list.size()));
            List<s> subList = list.subList(0, length);
            r2 = kotlin.a0.s.r(subList, 10);
            ArrayList arrayList2 = new ArrayList(r2);
            for (s sVar2 : subList) {
                arrayList2.add(g(sVar2));
            }
            return new w(cls, e2, arrayList2);
        }
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList3 = new ArrayList(r);
        for (s sVar3 : list) {
            arrayList3.add(g(sVar3));
        }
        return new w(cls, null, arrayList3);
    }

    public static final Type f(q javaType) {
        Type javaType2;
        kotlin.jvm.internal.m.g(javaType, "$this$javaType");
        return (!(javaType instanceof kotlin.jvm.internal.n) || (javaType2 = ((kotlin.jvm.internal.n) javaType).getJavaType()) == null) ? d(javaType, false, 1, null) : javaType2;
    }

    private static final Type g(s sVar) {
        u d2 = sVar.d();
        if (d2 != null) {
            q c2 = sVar.c();
            kotlin.jvm.internal.m.e(c2);
            int i2 = y.f17306b[d2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return new a0(c(c2, true), null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new a0(null, c(c2, true));
            }
            return c(c2, true);
        }
        return a0.f17288b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        String name;
        kotlin.k0.h g2;
        int k2;
        String G;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                g2 = kotlin.k0.n.g(type, a.a);
                StringBuilder sb = new StringBuilder();
                sb.append(((Class) kotlin.k0.k.u(g2)).getName());
                k2 = kotlin.k0.p.k(g2);
                G = kotlin.l0.x.G(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, k2);
                sb.append(G);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            kotlin.jvm.internal.m.f(name, "if (type.isArray) {\n    …\n        } else type.name");
            return name;
        }
        return type.toString();
    }
}
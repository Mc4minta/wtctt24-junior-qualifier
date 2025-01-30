package kotlin.jvm.internal;

import java.util.Collections;

/* compiled from: Reflection.java */
/* loaded from: classes3.dex */
public class e0 {
    private static final f0 a;

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.j0.d[] f17314b;

    static {
        f0 f0Var = null;
        try {
            f0Var = (f0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (f0Var == null) {
            f0Var = new f0();
        }
        a = f0Var;
        f17314b = new kotlin.j0.d[0];
    }

    public static kotlin.j0.g a(j jVar) {
        return a.function(jVar);
    }

    public static kotlin.j0.d b(Class cls) {
        return a.getOrCreateKotlinClass(cls);
    }

    public static kotlin.j0.f c(Class cls) {
        return a.getOrCreateKotlinPackage(cls, "");
    }

    public static kotlin.j0.f d(Class cls, String str) {
        return a.getOrCreateKotlinPackage(cls, str);
    }

    public static kotlin.j0.i e(p pVar) {
        return a.mutableProperty0(pVar);
    }

    public static kotlin.j0.j f(q qVar) {
        return a.mutableProperty1(qVar);
    }

    public static kotlin.j0.q g(Class cls) {
        return a.typeOf(b(cls), Collections.emptyList(), true);
    }

    public static kotlin.j0.o h(w wVar) {
        return a.property1(wVar);
    }

    public static String i(i iVar) {
        return a.renderLambdaToString(iVar);
    }

    public static String j(o oVar) {
        return a.renderLambdaToString(oVar);
    }
}
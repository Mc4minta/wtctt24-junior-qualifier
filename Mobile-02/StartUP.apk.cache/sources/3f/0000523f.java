package kotlin.jvm.internal;

import java.util.List;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes3.dex */
public class f0 {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public kotlin.j0.d createKotlinClass(Class cls) {
        return new e(cls);
    }

    public kotlin.j0.g function(j jVar) {
        return jVar;
    }

    public kotlin.j0.d getOrCreateKotlinClass(Class cls) {
        return new e(cls);
    }

    public kotlin.j0.f getOrCreateKotlinPackage(Class cls, String str) {
        return new u(cls, str);
    }

    public kotlin.j0.i mutableProperty0(p pVar) {
        return pVar;
    }

    public kotlin.j0.j mutableProperty1(q qVar) {
        return qVar;
    }

    public kotlin.j0.k mutableProperty2(s sVar) {
        return sVar;
    }

    public kotlin.j0.n property0(v vVar) {
        return vVar;
    }

    public kotlin.j0.o property1(w wVar) {
        return wVar;
    }

    public kotlin.j0.p property2(y yVar) {
        return yVar;
    }

    public String renderLambdaToString(o oVar) {
        return renderLambdaToString((i) oVar);
    }

    public void setUpperBounds(kotlin.j0.r rVar, List<kotlin.j0.q> list) {
        ((k0) rVar).a(list);
    }

    public kotlin.j0.q typeOf(kotlin.j0.e eVar, List<kotlin.j0.s> list, boolean z) {
        return new m0(eVar, list, z);
    }

    public kotlin.j0.r typeParameter(Object obj, String str, kotlin.j0.u uVar, boolean z) {
        return new k0(obj, str, uVar, z);
    }

    public kotlin.j0.d createKotlinClass(Class cls, String str) {
        return new e(cls);
    }

    public kotlin.j0.d getOrCreateKotlinClass(Class cls, String str) {
        return new e(cls);
    }

    public String renderLambdaToString(i iVar) {
        String obj = iVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(KOTLIN_JVM_FUNCTIONS) ? obj.substring(21) : obj;
    }
}
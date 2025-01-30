package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.a0.j;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> member) {
        m.g(member, "member");
        this.member = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        m.f(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        List<JavaValueParameter> g2;
        Type[] realTypes = getMember().getGenericParameterTypes();
        m.f(realTypes, "types");
        if (realTypes.length == 0) {
            g2 = r.g();
            return g2;
        }
        Class<?> declaringClass = getMember().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            realTypes = (Type[]) j.i(realTypes, 1, realTypes.length);
        }
        Annotation[][] realAnnotations = getMember().getParameterAnnotations();
        if (realAnnotations.length >= realTypes.length) {
            if (realAnnotations.length > realTypes.length) {
                m.f(realAnnotations, "annotations");
                realAnnotations = (Annotation[][]) j.i(realAnnotations, realAnnotations.length - realTypes.length, realAnnotations.length);
            }
            m.f(realTypes, "realTypes");
            m.f(realAnnotations, "realAnnotations");
            return getValueParameters(realTypes, realAnnotations, getMember().isVarArgs());
        }
        throw new IllegalStateException(m.o("Illegal generic signature: ", getMember()));
    }
}
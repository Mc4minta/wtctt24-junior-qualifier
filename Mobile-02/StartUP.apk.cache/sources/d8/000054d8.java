package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaValueParameter.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements JavaValueParameter {
    private final boolean isVararg;
    private final Annotation[] reflectAnnotations;
    private final String reflectName;
    private final ReflectJavaType type;

    public ReflectJavaValueParameter(ReflectJavaType type, Annotation[] reflectAnnotations, String str, boolean z) {
        m.g(type, "type");
        m.g(reflectAnnotations, "reflectAnnotations");
        this.type = type;
        this.reflectAnnotations = reflectAnnotations;
        this.reflectName = str;
        this.isVararg = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public Name getName() {
        String str = this.reflectName;
        if (str == null) {
            return null;
        }
        return Name.guessByFirstCharacter(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public boolean isVararg() {
        return this.isVararg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReflectJavaValueParameter.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        m.g(fqName, "fqName");
        return ReflectJavaAnnotationOwnerKt.findAnnotation(this.reflectAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwnerKt.getAnnotations(this.reflectAnnotations);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter
    public ReflectJavaType getType() {
        return this.type;
    }
}
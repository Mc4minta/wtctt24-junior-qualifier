package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaPackage.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {
    private final FqName fqName;

    public ReflectJavaPackage(FqName fqName) {
        m.g(fqName, "fqName");
        this.fqName = fqName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && m.c(getFqName(), ((ReflectJavaPackage) obj).getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName fqName) {
        m.g(fqName, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public Collection<JavaClass> getClasses(l<? super Name, Boolean> nameFilter) {
        List g2;
        m.g(nameFilter, "nameFilter");
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage
    public Collection<JavaPackage> getSubPackages() {
        List g2;
        g2 = r.g();
        return g2;
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return ReflectJavaPackage.class.getName() + ": " + getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<JavaAnnotation> getAnnotations() {
        List<JavaAnnotation> g2;
        g2 = r.g();
        return g2;
    }
}
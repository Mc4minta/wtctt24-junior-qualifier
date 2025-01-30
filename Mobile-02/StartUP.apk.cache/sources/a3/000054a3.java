package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaClassFinder.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader classLoader;

    public ReflectJavaClassFinder(ClassLoader classLoader) {
        m.g(classLoader, "classLoader");
        this.classLoader = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(JavaClassFinder.Request request) {
        String J;
        m.g(request, "request");
        ClassId classId = request.getClassId();
        FqName packageFqName = classId.getPackageFqName();
        m.f(packageFqName, "classId.packageFqName");
        String asString = classId.getRelativeClassName().asString();
        m.f(asString, "classId.relativeClassName.asString()");
        J = x.J(asString, '.', '$', false, 4, null);
        if (!packageFqName.isRoot()) {
            J = packageFqName.asString() + '.' + J;
        }
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, J);
        if (tryLoadClass != null) {
            return new ReflectJavaClass(tryLoadClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(FqName fqName) {
        m.g(fqName, "fqName");
        return new ReflectJavaPackage(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName packageFqName) {
        m.g(packageFqName, "packageFqName");
        return null;
    }
}
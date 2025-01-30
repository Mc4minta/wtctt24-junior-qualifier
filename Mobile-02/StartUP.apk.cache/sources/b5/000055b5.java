package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.e0.c.l;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface JavaPackage extends JavaAnnotationOwner, JavaElement {
    Collection<JavaClass> getClasses(l<? super Name, Boolean> lVar);

    FqName getFqName();

    Collection<JavaPackage> getSubPackages();
}
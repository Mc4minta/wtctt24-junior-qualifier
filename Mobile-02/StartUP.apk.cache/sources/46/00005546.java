package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;

/* compiled from: LazyJavaAnnotations.kt */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotationsKt {
    public static final Annotations resolveAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner annotationsOwner) {
        m.g(lazyJavaResolverContext, "<this>");
        m.g(annotationsOwner, "annotationsOwner");
        return new LazyJavaAnnotations(lazyJavaResolverContext, annotationsOwner, false, 4, null);
    }
}
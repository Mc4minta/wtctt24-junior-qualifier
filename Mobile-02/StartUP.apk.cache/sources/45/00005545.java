package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaAnnotations.kt */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotations$annotationDescriptors$1 extends o implements l<JavaAnnotation, AnnotationDescriptor> {
    final /* synthetic */ LazyJavaAnnotations this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        super(1);
        this.this$0 = lazyJavaAnnotations;
    }

    @Override // kotlin.e0.c.l
    public final AnnotationDescriptor invoke(JavaAnnotation annotation) {
        LazyJavaResolverContext lazyJavaResolverContext;
        boolean z;
        m.g(annotation, "annotation");
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
        lazyJavaResolverContext = this.this$0.f17392c;
        z = this.this$0.areAnnotationsFreshlySupported;
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(annotation, lazyJavaResolverContext, z);
    }
}
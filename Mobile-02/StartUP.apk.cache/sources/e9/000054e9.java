package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.l;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnotationTypeQualifierResolver.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class AnnotationTypeQualifierResolver$resolvedNicknames$1 extends j implements l<ClassDescriptor, AnnotationDescriptor> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnotationTypeQualifierResolver$resolvedNicknames$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(1, annotationTypeQualifierResolver);
    }

    @Override // kotlin.jvm.internal.c, kotlin.j0.c
    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    @Override // kotlin.jvm.internal.c
    public final f getOwner() {
        return e0.b(AnnotationTypeQualifierResolver.class);
    }

    @Override // kotlin.jvm.internal.c
    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    @Override // kotlin.e0.c.l
    public final AnnotationDescriptor invoke(ClassDescriptor p0) {
        AnnotationDescriptor computeTypeQualifierNickname;
        m.g(p0, "p0");
        computeTypeQualifierNickname = ((AnnotationTypeQualifierResolver) this.receiver).computeTypeQualifierNickname(p0);
        return computeTypeQualifierNickname;
    }
}
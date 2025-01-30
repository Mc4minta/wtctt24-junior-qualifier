package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
final class CompositeAnnotations$findAnnotation$1 extends o implements l<Annotations, AnnotationDescriptor> {
    final /* synthetic */ FqName $fqName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations$findAnnotation$1(FqName fqName) {
        super(1);
        this.$fqName = fqName;
    }

    @Override // kotlin.e0.c.l
    public final AnnotationDescriptor invoke(Annotations it) {
        m.g(it, "it");
        return it.mo2207findAnnotation(this.$fqName);
    }
}
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k0.h;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
final class CompositeAnnotations$iterator$1 extends o implements l<Annotations, h<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 INSTANCE = new CompositeAnnotations$iterator$1();

    CompositeAnnotations$iterator$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final h<AnnotationDescriptor> invoke(Annotations it) {
        h<AnnotationDescriptor> M;
        m.g(it, "it");
        M = z.M(it);
        return M;
    }
}
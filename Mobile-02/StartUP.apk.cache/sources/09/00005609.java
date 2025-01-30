package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [A, C] */
/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* loaded from: classes3.dex */
public final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1<A, C> extends o implements l<KotlinJvmBinaryClass, AbstractBinaryClassAnnotationAndConstantLoader.Storage<? extends A, ? extends C>> {
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
        super(1);
        this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
    }

    @Override // kotlin.e0.c.l
    public final AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> invoke(KotlinJvmBinaryClass kotlinClass) {
        AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> loadAnnotationsAndInitializers;
        m.g(kotlinClass, "kotlinClass");
        loadAnnotationsAndInitializers = this.this$0.loadAnnotationsAndInitializers(kotlinClass);
        return loadAnnotationsAndInitializers;
    }
}
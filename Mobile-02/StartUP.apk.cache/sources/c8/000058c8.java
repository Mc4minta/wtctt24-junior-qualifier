package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    private final Annotations annotations;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotatedSimpleType(SimpleType delegate, Annotations annotations) {
        super(delegate);
        m.g(delegate, "delegate");
        m.g(annotations, "annotations");
        this.annotations = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public AnnotatedSimpleType replaceDelegate(SimpleType delegate) {
        m.g(delegate, "delegate");
        return new AnnotatedSimpleType(delegate, getAnnotations());
    }
}
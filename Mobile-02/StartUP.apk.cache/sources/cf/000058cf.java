package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: KotlinTypeFactory.kt */
/* loaded from: classes3.dex */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    private final SimpleType delegate;

    public DelegatingSimpleTypeImpl(SimpleType delegate) {
        m.g(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : getDelegate().makeNullableAsSpecified(z).replaceAnnotations(getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DelegatingSimpleTypeImpl replaceAnnotations(Annotations newAnnotations) {
        m.g(newAnnotations, "newAnnotations");
        return newAnnotations != getAnnotations() ? new AnnotatedSimpleType(this, newAnnotations) : this;
    }
}
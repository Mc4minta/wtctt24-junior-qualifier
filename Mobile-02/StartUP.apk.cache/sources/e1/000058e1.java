package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: classes3.dex */
public final class FlexibleTypeWithEnhancement extends FlexibleType implements TypeWithEnhancement {
    private final KotlinType enhancement;
    private final FlexibleType origin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleTypeWithEnhancement(FlexibleType origin, KotlinType enhancement) {
        super(origin.getLowerBound(), origin.getUpperBound());
        m.g(origin, "origin");
        m.g(enhancement, "enhancement");
        this.origin = origin;
        this.enhancement = enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer renderer, DescriptorRendererOptions options) {
        m.g(renderer, "renderer");
        m.g(options, "options");
        if (options.getEnhancedTypes()) {
            return renderer.renderType(getEnhancement());
        }
        return getOrigin().render(renderer, options);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType replaceAnnotations(Annotations newAnnotations) {
        m.g(newAnnotations, "newAnnotations");
        return TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAnnotations(newAnnotations), getEnhancement());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public FlexibleType getOrigin() {
        return this.origin;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new FlexibleTypeWithEnhancement((FlexibleType) kotlinTypeRefiner.refineType(getOrigin()), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class NotNullTypeParameter extends DelegatingSimpleType implements NotNullTypeVariable {
    private final SimpleType delegate;

    public NotNullTypeParameter(SimpleType delegate) {
        m.g(delegate, "delegate");
        this.delegate = delegate;
    }

    private final SimpleType prepareReplacement(SimpleType simpleType) {
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        return !TypeUtilsKt.isTypeParameter(simpleType) ? makeNullableAsSpecified : new NotNullTypeParameter(makeNullableAsSpecified);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public KotlinType substitutionResult(KotlinType replacement) {
        m.g(replacement, "replacement");
        UnwrappedType unwrap = replacement.unwrap();
        if (TypeUtilsKt.isTypeParameter(unwrap) || TypeUtils.isNullableType(unwrap)) {
            if (unwrap instanceof SimpleType) {
                return prepareReplacement((SimpleType) unwrap);
            }
            if (unwrap instanceof FlexibleType) {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                FlexibleType flexibleType = (FlexibleType) unwrap;
                return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.getLowerBound()), prepareReplacement(flexibleType.getUpperBound())), TypeWithEnhancementKt.getEnhancement(unwrap));
            }
            throw new IllegalStateException(m.o("Incorrect type: ", unwrap).toString());
        }
        return unwrap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(true) : this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullTypeParameter replaceDelegate(SimpleType delegate) {
        m.g(delegate, "delegate");
        return new NotNullTypeParameter(delegate);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NotNullTypeParameter replaceAnnotations(Annotations newAnnotations) {
        m.g(newAnnotations, "newAnnotations");
        return new NotNullTypeParameter(getDelegate().replaceAnnotations(newAnnotations));
    }
}
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ErasedOverridabilityCondition.kt */
/* loaded from: classes3.dex */
final class ErasedOverridabilityCondition$isOverridable$signatureTypes$1 extends o implements l<ValueParameterDescriptor, KotlinType> {
    public static final ErasedOverridabilityCondition$isOverridable$signatureTypes$1 INSTANCE = new ErasedOverridabilityCondition$isOverridable$signatureTypes$1();

    ErasedOverridabilityCondition$isOverridable$signatureTypes$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(ValueParameterDescriptor valueParameterDescriptor) {
        return valueParameterDescriptor.getType();
    }
}
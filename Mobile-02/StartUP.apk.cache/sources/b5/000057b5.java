package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationValue(AnnotationDescriptor value) {
        super(value);
        m.g(value, "value");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor module) {
        m.g(module, "module");
        return getValue().getType();
    }
}
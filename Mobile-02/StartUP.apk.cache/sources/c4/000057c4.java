package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class FloatValue extends ConstantValue<Float> {
    public FloatValue(float f2) {
        super(Float.valueOf(f2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().floatValue() + ".toFloat()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType floatType = module.getBuiltIns().getFloatType();
        m.f(floatType, "module.builtIns.floatType");
        return floatType;
    }
}
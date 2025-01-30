package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class IntValue extends IntegerValueConstant<Integer> {
    public IntValue(int i2) {
        super(Integer.valueOf(i2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType intType = module.getBuiltIns().getIntType();
        m.f(intType, "module.builtIns.intType");
        return intType;
    }
}
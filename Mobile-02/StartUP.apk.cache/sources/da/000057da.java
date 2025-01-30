package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class ULongValue extends UnsignedValueConstant<Long> {
    public ULongValue(long j2) {
        super(Long.valueOf(j2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor module) {
        m.g(module, "module");
        ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(module, StandardNames.FqNames.uLong);
        SimpleType defaultType = findClassAcrossModuleDependencies == null ? null : findClassAcrossModuleDependencies.getDefaultType();
        if (defaultType == null) {
            SimpleType createErrorType = ErrorUtils.createErrorType("Unsigned type ULong not found");
            m.f(createErrorType, "createErrorType(\"Unsigned type ULong not found\")");
            return createErrorType;
        }
        return defaultType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().longValue() + ".toULong()";
    }
}
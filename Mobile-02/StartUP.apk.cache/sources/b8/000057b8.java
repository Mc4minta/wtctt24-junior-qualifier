package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class ByteValue extends IntegerValueConstant<Byte> {
    public ByteValue(byte b2) {
        super(Byte.valueOf(b2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().intValue() + ".toByte()";
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType byteType = module.getBuiltIns().getByteType();
        m.f(byteType, "module.builtIns.byteType");
        return byteType;
    }
}
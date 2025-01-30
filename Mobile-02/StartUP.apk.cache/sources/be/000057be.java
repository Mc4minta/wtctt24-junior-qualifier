package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes3.dex */
public final class ConstantValueFactory$createArrayValue$3 extends o implements l<ModuleDescriptor, KotlinType> {
    final /* synthetic */ PrimitiveType $componentType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        super(1);
        this.$componentType = primitiveType;
    }

    @Override // kotlin.e0.c.l
    public final KotlinType invoke(ModuleDescriptor module) {
        m.g(module, "module");
        SimpleType primitiveArrayKotlinType = module.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
        m.f(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
        return primitiveArrayKotlinType;
    }
}
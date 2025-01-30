package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1 extends o implements a<KotlinType> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // kotlin.e0.c.a
    public final KotlinType invoke() {
        ModuleDescriptor moduleDescriptor;
        moduleDescriptor = this.this$0.moduleDescriptor;
        SimpleType anyType = moduleDescriptor.getBuiltIns().getAnyType();
        m.f(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: ReflectionTypes.kt */
/* loaded from: classes3.dex */
final class ReflectionTypes$kotlinReflectScope$2 extends o implements a<MemberScope> {
    final /* synthetic */ ModuleDescriptor $module;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor moduleDescriptor) {
        super(0);
        this.$module = moduleDescriptor;
    }

    @Override // kotlin.e0.c.a
    public final MemberScope invoke() {
        return this.$module.getPackage(StandardNames.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }
}
package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsCustomizer.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$isMutabilityViolation$2 extends o implements l<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$isMutabilityViolation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // kotlin.e0.c.l
    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        boolean z;
        JavaToKotlinClassMapper javaToKotlinClassMapper;
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
            javaToKotlinClassMapper = this.this$0.j2kClassMapper;
            if (javaToKotlinClassMapper.isMutable((ClassDescriptor) callableMemberDescriptor.getContainingDeclaration())) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
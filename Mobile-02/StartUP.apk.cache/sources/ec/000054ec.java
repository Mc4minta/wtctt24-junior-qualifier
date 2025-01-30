package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import java.util.Objects;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: specialBuiltinMembers.kt */
/* loaded from: classes3.dex */
final class BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1 extends o implements l<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ SimpleFunctionDescriptor $functionDescriptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        super(1);
        this.$functionDescriptor = simpleFunctionDescriptor;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(CallableMemberDescriptor it) {
        m.g(it, "it");
        Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(this.$functionDescriptor);
        Objects.requireNonNull(signature_to_jvm_representation_name, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return signature_to_jvm_representation_name.containsKey(computeJvmSignature);
    }
}
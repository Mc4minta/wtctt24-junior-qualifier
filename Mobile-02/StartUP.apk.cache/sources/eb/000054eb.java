package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: specialBuiltinMembers.kt */
/* loaded from: classes3.dex */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    public final List<Name> getBuiltinFunctionNamesByJvmName(Name name) {
        List<Name> g2;
        m.g(name, "name");
        List<Name> list = SpecialGenericSignatures.Companion.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        if (list == null) {
            g2 = r.g();
            return g2;
        }
        return list;
    }

    public final Name getJvmName(SimpleFunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(functionDescriptor);
        if (computeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(computeJvmSignature);
    }

    public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
        m.g(name, "<this>");
        return SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(name);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(SimpleFunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(functionDescriptor) && DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(functionDescriptor), 1, null) != null;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        m.g(simpleFunctionDescriptor, "<this>");
        return m.c(simpleFunctionDescriptor.getName().asString(), "removeAt") && m.c(MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
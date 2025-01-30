package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.a0.p;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
public final class MethodSignatureMappingKt {
    private static final void appendErasedType(StringBuilder sb, KotlinType kotlinType) {
        sb.append(mapToJvmType(kotlinType));
    }

    public static final String computeJvmDescriptor(FunctionDescriptor functionDescriptor, boolean z, boolean z2) {
        String asString;
        m.g(functionDescriptor, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (functionDescriptor instanceof ConstructorDescriptor) {
                asString = "<init>";
            } else {
                asString = functionDescriptor.getName().asString();
                m.f(asString, "name.asString()");
            }
            sb.append(asString);
        }
        sb.append("(");
        ReceiverParameterDescriptor extensionReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            KotlinType type = extensionReceiverParameter.getType();
            m.f(type, "it.type");
            appendErasedType(sb, type);
        }
        for (ValueParameterDescriptor valueParameterDescriptor : functionDescriptor.getValueParameters()) {
            KotlinType type2 = valueParameterDescriptor.getType();
            m.f(type2, "parameter.type");
            appendErasedType(sb, type2);
        }
        sb.append(")");
        if (z) {
            if (DescriptorBasedTypeSignatureMappingKt.hasVoidReturnType(functionDescriptor)) {
                sb.append("V");
            } else {
                KotlinType returnType = functionDescriptor.getReturnType();
                m.e(returnType);
                appendErasedType(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        m.f(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return computeJvmDescriptor(functionDescriptor, z, z2);
    }

    public static final String computeJvmSignature(CallableDescriptor callableDescriptor) {
        m.g(callableDescriptor, "<this>");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal(callableDescriptor)) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null || classDescriptor.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor original = callableDescriptor.getOriginal();
        SimpleFunctionDescriptor simpleFunctionDescriptor = original instanceof SimpleFunctionDescriptor ? (SimpleFunctionDescriptor) original : null;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        return MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, classDescriptor, computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null));
    }

    public static final boolean forceSingleValueParameterBoxing(CallableDescriptor f2) {
        m.g(f2, "f");
        if (f2 instanceof FunctionDescriptor) {
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) f2;
            if (m.c(functionDescriptor.getName().asString(), "remove") && functionDescriptor.getValueParameters().size() == 1 && !SpecialBuiltinMembers.isFromJavaOrBuiltins((CallableMemberDescriptor) f2)) {
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getOriginal().getValueParameters();
                m.f(valueParameters, "f.original.valueParameters");
                KotlinType type = ((ValueParameterDescriptor) p.x0(valueParameters)).getType();
                m.f(type, "f.original.valueParameters.single().type");
                JvmType mapToJvmType = mapToJvmType(type);
                JvmType.Primitive primitive = mapToJvmType instanceof JvmType.Primitive ? (JvmType.Primitive) mapToJvmType : null;
                if ((primitive != null ? primitive.getJvmPrimitiveType() : null) != JvmPrimitiveType.INT) {
                    return false;
                }
                BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
                FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(functionDescriptor);
                if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
                    return false;
                }
                List<ValueParameterDescriptor> valueParameters2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getOriginal().getValueParameters();
                m.f(valueParameters2, "overridden.original.valueParameters");
                KotlinType type2 = ((ValueParameterDescriptor) p.x0(valueParameters2)).getType();
                m.f(type2, "overridden.original.valueParameters.single().type");
                JvmType mapToJvmType2 = mapToJvmType(type2);
                DeclarationDescriptor containingDeclaration = overriddenBuiltinFunctionWithErasedValueParametersInJava.getContainingDeclaration();
                m.f(containingDeclaration, "overridden.containingDeclaration");
                return m.c(DescriptorUtilsKt.getFqNameUnsafe(containingDeclaration), StandardNames.FqNames.mutableCollection.toUnsafe()) && (mapToJvmType2 instanceof JvmType.Object) && m.c(((JvmType.Object) mapToJvmType2).getInternalName(), "java/lang/Object");
            }
            return false;
        }
        return false;
    }

    public static final String getInternalName(ClassDescriptor classDescriptor) {
        m.g(classDescriptor, "<this>");
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = DescriptorUtilsKt.getFqNameSafe(classDescriptor).toUnsafe();
        m.f(unsafe, "fqNameSafe.toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava == null) {
            return DescriptorBasedTypeSignatureMappingKt.computeInternalName$default(classDescriptor, null, 2, null);
        }
        String internalName = JvmClassName.byClassId(mapKotlinToJava).getInternalName();
        m.f(internalName, "byClassId(it).internalName");
        return internalName;
    }

    public static final JvmType mapToJvmType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return (JvmType) DescriptorBasedTypeSignatureMappingKt.mapType$default(kotlinType, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}
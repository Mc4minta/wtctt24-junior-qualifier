package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.List;
import kotlin.a0.p;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: inlineClassesUtils.kt */
/* loaded from: classes3.dex */
public final class InlineClassesUtilsKt {
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmInline");

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor callableDescriptor) {
        m.g(callableDescriptor, "<this>");
        if (callableDescriptor instanceof PropertyGetterDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyGetterDescriptor) callableDescriptor).getCorrespondingProperty();
            m.f(correspondingProperty, "correspondingProperty");
            if (isUnderlyingPropertyOfInlineClass(correspondingProperty)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClass(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        if (declarationDescriptor instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor.isInline() || classDescriptor.isValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (mo2214getDeclarationDescriptor == null) {
            return false;
        }
        return isInlineClass(mo2214getDeclarationDescriptor);
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor variableDescriptor) {
        m.g(variableDescriptor, "<this>");
        if (variableDescriptor.getExtensionReceiverParameter() != null) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = variableDescriptor.getContainingDeclaration();
        m.f(containingDeclaration, "this.containingDeclaration");
        if (isInlineClass(containingDeclaration)) {
            ValueParameterDescriptor underlyingRepresentation = underlyingRepresentation((ClassDescriptor) containingDeclaration);
            return m.c(underlyingRepresentation == null ? null : underlyingRepresentation.getName(), variableDescriptor.getName());
        }
        return false;
    }

    public static final KotlinType substitutedUnderlyingType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ValueParameterDescriptor unsubstitutedUnderlyingParameter = unsubstitutedUnderlyingParameter(kotlinType);
        if (unsubstitutedUnderlyingParameter == null) {
            return null;
        }
        return TypeSubstitutor.create(kotlinType).substitute(unsubstitutedUnderlyingParameter.getType(), Variance.INVARIANT);
    }

    public static final ValueParameterDescriptor underlyingRepresentation(ClassDescriptor classDescriptor) {
        ClassConstructorDescriptor mo2206getUnsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        m.g(classDescriptor, "<this>");
        if (!isInlineClass(classDescriptor) || (mo2206getUnsubstitutedPrimaryConstructor = classDescriptor.mo2206getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = mo2206getUnsubstitutedPrimaryConstructor.getValueParameters()) == null) {
            return null;
        }
        return (ValueParameterDescriptor) p.z0(valueParameters);
    }

    public static final ValueParameterDescriptor unsubstitutedUnderlyingParameter(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        if (!(mo2214getDeclarationDescriptor instanceof ClassDescriptor)) {
            mo2214getDeclarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) mo2214getDeclarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        return underlyingRepresentation(classDescriptor);
    }
}
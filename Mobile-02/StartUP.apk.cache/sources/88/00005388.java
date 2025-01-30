package kotlin.reflect.jvm.internal.impl.builtins;

import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.u;

/* compiled from: functionTypes.kt */
/* loaded from: classes3.dex */
public final class FunctionTypesKt {
    public static final SimpleType createFunctionType(KotlinBuiltIns builtIns, Annotations annotations, KotlinType kotlinType, List<? extends KotlinType> parameterTypes, List<Name> list, KotlinType returnType, boolean z) {
        m.g(builtIns, "builtIns");
        m.g(annotations, "annotations");
        m.g(parameterTypes, "parameterTypes");
        m.g(returnType, "returnType");
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, parameterTypes, list, returnType, builtIns);
        int size = parameterTypes.size();
        if (kotlinType != null) {
            size++;
        }
        ClassDescriptor functionDescriptor = getFunctionDescriptor(builtIns, size, z);
        if (kotlinType != null) {
            annotations = withExtensionFunctionAnnotation(annotations, builtIns);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleNotNullType(annotations, functionDescriptor, functionTypeArgumentProjections);
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, KotlinType kotlinType2, boolean z, int i2, Object obj) {
        if ((i2 & 64) != 0) {
            z = false;
        }
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, kotlinType2, z);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType kotlinType) {
        String value;
        m.g(kotlinType, "<this>");
        AnnotationDescriptor mo2207findAnnotation = kotlinType.getAnnotations().mo2207findAnnotation(StandardNames.FqNames.parameterName);
        if (mo2207findAnnotation == null) {
            return null;
        }
        Object y0 = p.y0(mo2207findAnnotation.getAllValueArguments().values());
        StringValue stringValue = y0 instanceof StringValue ? (StringValue) y0 : null;
        if (stringValue == null || (value = stringValue.getValue()) == null || !Name.isValidIdentifier(value)) {
            value = null;
        }
        if (value == null) {
            return null;
        }
        return Name.identifier(value);
    }

    public static final ClassDescriptor getFunctionDescriptor(KotlinBuiltIns builtIns, int i2, boolean z) {
        m.g(builtIns, "builtIns");
        ClassDescriptor suspendFunction = z ? builtIns.getSuspendFunction(i2) : builtIns.getFunction(i2);
        m.f(suspendFunction, "if (isSuspendFunction) builtIns.getSuspendFunction(parameterCount) else builtIns.getFunction(parameterCount)");
        return suspendFunction;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType kotlinType, List<? extends KotlinType> parameterTypes, List<Name> list, KotlinType returnType, KotlinBuiltIns builtIns) {
        Name name;
        Map e2;
        List<? extends AnnotationDescriptor> s0;
        m.g(parameterTypes, "parameterTypes");
        m.g(returnType, "returnType");
        m.g(builtIns, "builtIns");
        int i2 = 0;
        ArrayList arrayList = new ArrayList(parameterTypes.size() + (kotlinType != null ? 1 : 0) + 1);
        CollectionsKt.addIfNotNull(arrayList, kotlinType == null ? null : TypeUtilsKt.asTypeProjection(kotlinType));
        for (Object obj : parameterTypes) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            KotlinType kotlinType2 = (KotlinType) obj;
            if (list == null || (name = list.get(i2)) == null || name.isSpecial()) {
                name = null;
            }
            if (name != null) {
                FqName fqName = StandardNames.FqNames.parameterName;
                Name identifier = Name.identifier(ApiConstants.NAME);
                String asString = name.asString();
                m.f(asString, "name.asString()");
                e2 = l0.e(u.a(identifier, new StringValue(asString)));
                BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(builtIns, fqName, e2);
                Annotations.Companion companion = Annotations.Companion;
                s0 = z.s0(kotlinType2.getAnnotations(), builtInAnnotationDescriptor);
                kotlinType2 = TypeUtilsKt.replaceAnnotations(kotlinType2, companion.create(s0));
            }
            arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
            i2 = i3;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(returnType));
        return arrayList;
    }

    public static final FunctionClassKind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
        }
        return null;
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        if (isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return ((TypeProjection) p.Y(kotlinType.getArguments())).getType();
        }
        return null;
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        KotlinType type = ((TypeProjection) p.j0(kotlinType.getArguments())).getType();
        m.f(type, "arguments.last().type");
        return type;
    }

    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        isBuiltinFunctionalType(kotlinType);
        List<TypeProjection> arguments = kotlinType.getArguments();
        return arguments.subList(isBuiltinExtensionFunctionalType(kotlinType) ? 1 : 0, arguments.size() - 1);
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType);
    }

    public static final boolean isBuiltinFunctionalClassDescriptor(DeclarationDescriptor declarationDescriptor) {
        m.g(declarationDescriptor, "<this>");
        FunctionClassKind functionalClassKind = getFunctionalClassKind(declarationDescriptor);
        return functionalClassKind == FunctionClassKind.Function || functionalClassKind == FunctionClassKind.SuspendFunction;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return m.c(mo2214getDeclarationDescriptor == null ? null : Boolean.valueOf(isBuiltinFunctionalClassDescriptor(mo2214getDeclarationDescriptor)), Boolean.TRUE);
    }

    public static final boolean isFunctionType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return (mo2214getDeclarationDescriptor == null ? null : getFunctionalClassKind(mo2214getDeclarationDescriptor)) == FunctionClassKind.Function;
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
        return (mo2214getDeclarationDescriptor == null ? null : getFunctionalClassKind(mo2214getDeclarationDescriptor)) == FunctionClassKind.SuspendFunction;
    }

    private static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        return kotlinType.getAnnotations().mo2207findAnnotation(StandardNames.FqNames.extensionFunctionType) != null;
    }

    public static final Annotations withExtensionFunctionAnnotation(Annotations annotations, KotlinBuiltIns builtIns) {
        Map i2;
        List<? extends AnnotationDescriptor> s0;
        m.g(annotations, "<this>");
        m.g(builtIns, "builtIns");
        FqName fqName = StandardNames.FqNames.extensionFunctionType;
        if (annotations.hasAnnotation(fqName)) {
            return annotations;
        }
        Annotations.Companion companion = Annotations.Companion;
        i2 = m0.i();
        s0 = z.s0(annotations, new BuiltInAnnotationDescriptor(builtIns, fqName, i2));
        return companion.create(s0);
    }

    private static final FunctionClassKind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (!fqNameUnsafe.isSafe() || fqNameUnsafe.isRoot()) {
            return null;
        }
        FunctionClassKind.Companion companion = FunctionClassKind.Companion;
        String asString = fqNameUnsafe.shortName().asString();
        m.f(asString, "shortName().asString()");
        FqName parent = fqNameUnsafe.toSafe().parent();
        m.f(parent, "toSafe().parent()");
        return companion.getFunctionalClassKind(asString, parent);
    }
}
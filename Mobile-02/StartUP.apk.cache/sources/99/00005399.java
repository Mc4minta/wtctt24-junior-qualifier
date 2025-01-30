package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.q;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: suspendFunctionTypes.kt */
/* loaded from: classes3.dex */
public final class SuspendFunctionTypesKt {
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL;
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE;

    static {
        List<TypeParameterDescriptor> b2;
        List<TypeParameterDescriptor> b3;
        ModuleDescriptor errorModule = ErrorUtils.getErrorModule();
        m.f(errorModule, "getErrorModule()");
        EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(errorModule, StandardNames.COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL);
        ClassKind classKind = ClassKind.INTERFACE;
        Name shortName = StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL.shortName();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(emptyPackageFragmentDescriptor, classKind, false, false, shortName, sourceElement, storageManager);
        Modality modality = Modality.ABSTRACT;
        mutableClassDescriptor.setModality(modality);
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        mutableClassDescriptor.setVisibility(descriptorVisibility);
        Annotations.Companion companion = Annotations.Companion;
        Annotations empty = companion.getEMPTY();
        Variance variance = Variance.IN_VARIANCE;
        b2 = q.b(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, empty, false, variance, Name.identifier("T"), 0, storageManager));
        mutableClassDescriptor.setTypeParameterDescriptors(b2);
        mutableClassDescriptor.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL = mutableClassDescriptor;
        ModuleDescriptor errorModule2 = ErrorUtils.getErrorModule();
        m.f(errorModule2, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor2 = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(errorModule2, StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE), classKind, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE.shortName(), sourceElement, storageManager);
        mutableClassDescriptor2.setModality(modality);
        mutableClassDescriptor2.setVisibility(descriptorVisibility);
        b3 = q.b(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor2, companion.getEMPTY(), false, variance, Name.identifier("T"), 0, storageManager));
        mutableClassDescriptor2.setTypeParameterDescriptors(b3);
        mutableClassDescriptor2.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE = mutableClassDescriptor2;
    }

    public static final boolean isContinuation(FqName fqName, boolean z) {
        if (z) {
            return m.c(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE);
        }
        return m.c(fqName, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL);
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType suspendFunType, boolean z) {
        int r;
        TypeConstructor typeConstructor;
        List b2;
        List u0;
        m.g(suspendFunType, "suspendFunType");
        FunctionTypesKt.isSuspendFunctionType(suspendFunType);
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(suspendFunType);
        Annotations annotations = suspendFunType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(suspendFunType);
        List<TypeProjection> valueParameterTypesFromFunctionType = FunctionTypesKt.getValueParameterTypesFromFunctionType(suspendFunType);
        r = s.r(valueParameterTypesFromFunctionType, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeProjection typeProjection : valueParameterTypesFromFunctionType) {
            arrayList.add(typeProjection.getType());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        Annotations empty = Annotations.Companion.getEMPTY();
        if (z) {
            typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.getTypeConstructor();
        } else {
            typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.getTypeConstructor();
        }
        TypeConstructor typeConstructor2 = typeConstructor;
        m.f(typeConstructor2, "if (isReleaseCoroutines) FAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE.typeConstructor\n                    else FAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL.typeConstructor");
        b2 = q.b(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(suspendFunType)));
        u0 = z.u0(arrayList, KotlinTypeFactory.simpleType$default(empty, typeConstructor2, b2, false, null, 16, null));
        SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(suspendFunType).getNullableAnyType();
        m.f(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(builtIns, annotations, receiverTypeFromFunctionType, u0, null, nullableAnyType, false, 64, null).makeNullableAsSpecified(suspendFunType.isMarkedNullable());
    }
}
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.b0.a;
import kotlin.j0.f;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.w;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: MemberDeserializer.kt */
/* loaded from: classes3.dex */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f17404c;

    public MemberDeserializer(DeserializationContext c2) {
        m.g(c2, "c");
        this.f17404c = c2;
        this.annotationDeserializer = new AnnotationDeserializer(c2.getComponents().getModuleDescriptor(), c2.getComponents().getNotFoundClasses());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.f17404c.getNameResolver(), this.f17404c.getTypeTable(), this.f17404c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode checkExperimentalCoroutine(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (versionAndReleaseCoroutinesMismatch(deserializedMemberDescriptor)) {
            forceUpperBoundsComputation(typeDeserializer);
            if (typeDeserializer.getExperimentalSuspendFunctionTypeEncountered()) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions(DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, KotlinType kotlinType, boolean z) {
        int r;
        List k2;
        List<KotlinType> t0;
        boolean z2;
        boolean z3;
        int r2;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z4;
        if (versionAndReleaseCoroutinesMismatch(deserializedCallableMemberDescriptor) && !m.c(DescriptorUtilsKt.fqNameOrNull(deserializedCallableMemberDescriptor), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            r = s.r(collection, 10);
            ArrayList arrayList = new ArrayList(r);
            for (ValueParameterDescriptor valueParameterDescriptor : collection) {
                arrayList.add(valueParameterDescriptor.getType());
            }
            k2 = r.k(receiverParameterDescriptor == null ? null : receiverParameterDescriptor.getType());
            t0 = z.t0(arrayList, k2);
            if (m.c(kotlinType != null ? Boolean.valueOf(containsSuspendFunctionType(kotlinType)) : null, Boolean.TRUE)) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                for (TypeParameterDescriptor typeParameterDescriptor : collection2) {
                    List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                    m.f(upperBounds, "typeParameter.upperBounds");
                    if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                        for (KotlinType it : upperBounds) {
                            m.f(it, "it");
                            if (containsSuspendFunctionType(it)) {
                                z2 = true;
                                continue;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    continue;
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            r2 = s.r(t0, 10);
            ArrayList arrayList2 = new ArrayList(r2);
            for (KotlinType type : t0) {
                m.f(type, "type");
                if (FunctionTypesKt.isSuspendFunctionType(type) && type.getArguments().size() <= 3) {
                    List<TypeProjection> arguments = type.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        for (TypeProjection typeProjection : arguments) {
                            KotlinType type2 = typeProjection.getType();
                            m.f(type2, "it.type");
                            if (containsSuspendFunctionType(type2)) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                    z4 = false;
                    if (z4) {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                    } else {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                    }
                } else {
                    coroutinesCompatibilityMode2 = containsSuspendFunctionType(type) ? DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE : DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
                }
                arrayList2.add(coroutinesCompatibilityMode2);
            }
            DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) p.n0(arrayList2);
            if (coroutinesCompatibilityMode3 == null) {
                coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            if (z) {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
            } else {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) a.f(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final boolean containsSuspendFunctionType(KotlinType kotlinType) {
        return TypeUtilsKt.contains(kotlinType, new w() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$containsSuspendFunctionType$1
            @Override // kotlin.j0.o
            public Object get(Object obj) {
                return Boolean.valueOf(FunctionTypesKt.isSuspendFunctionType((KotlinType) obj));
            }

            @Override // kotlin.jvm.internal.c, kotlin.j0.c
            public String getName() {
                return "isSuspendFunctionType";
            }

            @Override // kotlin.jvm.internal.c
            public f getOwner() {
                return e0.d(FunctionTypesKt.class, "deserialization");
            }

            @Override // kotlin.jvm.internal.c
            public String getSignature() {
                return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
            }
        });
    }

    private final void forceUpperBoundsComputation(TypeDeserializer typeDeserializer) {
        for (TypeParameterDescriptor typeParameterDescriptor : typeDeserializer.getOwnTypeParameters()) {
            typeParameterDescriptor.getUpperBounds();
        }
    }

    private final Annotations getAnnotations(MessageLite messageLite, int i2, AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i2).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f17404c.getStorageManager(), new MemberDeserializer$getAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.f17404c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    private final Annotations getPropertyFieldAnnotations(ProtoBuf.Property property, boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.f17404c.getStorageManager(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, property));
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.f17404c.getStorageManager(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, messageLite, annotatedCallableKind));
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, boolean z) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility, map, computeExperimentalityModeForFunctions(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor, list2, list, kotlinType, z));
    }

    private final int loadOldFlags(int i2) {
        return (i2 & 63) + ((i2 >> 8) << 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r26, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.valueParameters(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List");
    }

    private final boolean versionAndReleaseCoroutinesMismatch(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (this.f17404c.getComponents().getConfiguration().getReleaseCoroutines()) {
            List<VersionRequirement> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
            if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
                for (VersionRequirement versionRequirement : versionRequirements) {
                    if (m.c(versionRequirement.getVersion(), new VersionRequirement.Version(1, 3, 0, 4, null)) && versionRequirement.getKind() == ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            return z2;
        }
        return false;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor proto, boolean z) {
        List g2;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions;
        TypeDeserializer typeDeserializer;
        m.g(proto, "proto");
        ClassDescriptor classDescriptor = (ClassDescriptor) this.f17404c.getContainingDeclaration();
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(proto, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f17404c.getNameResolver(), this.f17404c.getTypeTable(), this.f17404c.getVersionRequirementTable(), this.f17404c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.f17404c;
        g2 = r.g();
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(deserializationContext, deserializedClassConstructorDescriptor2, g2, null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        m.f(valueParameterList, "proto.valueParameterList");
        deserializedClassConstructorDescriptor2.initialize(memberDeserializer.valueParameters(valueParameterList, proto, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())));
        deserializedClassConstructorDescriptor2.setReturnType(classDescriptor.getDefaultType());
        boolean z2 = true;
        deserializedClassConstructorDescriptor2.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        DeclarationDescriptor containingDeclaration = this.f17404c.getContainingDeclaration();
        Boolean bool = null;
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        DeserializationContext c2 = deserializedClassDescriptor == null ? null : deserializedClassDescriptor.getC();
        if (c2 != null && (typeDeserializer = c2.getTypeDeserializer()) != null) {
            bool = Boolean.valueOf(typeDeserializer.getExperimentalSuspendFunctionTypeEncountered());
        }
        if ((m.c(bool, Boolean.TRUE) && versionAndReleaseCoroutinesMismatch(deserializedClassConstructorDescriptor2)) ? false : false) {
            computeExperimentalityModeForFunctions = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
        } else {
            Collection<? extends ValueParameterDescriptor> valueParameters = deserializedClassConstructorDescriptor2.getValueParameters();
            m.f(valueParameters, "descriptor.valueParameters");
            Collection<? extends TypeParameterDescriptor> typeParameters = deserializedClassConstructorDescriptor2.getTypeParameters();
            m.f(typeParameters, "descriptor.typeParameters");
            deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
            computeExperimentalityModeForFunctions = computeExperimentalityModeForFunctions(deserializedClassConstructorDescriptor2, null, valueParameters, typeParameters, deserializedClassConstructorDescriptor2.getReturnType(), false);
        }
        deserializedClassConstructorDescriptor.setCoroutinesExperimentalCompatibilityMode$deserialization(computeExperimentalityModeForFunctions);
        return deserializedClassConstructorDescriptor;
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function proto) {
        Annotations empty;
        VersionRequirementTable versionRequirementTable;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> i2;
        KotlinType type;
        m.g(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations annotations = getAnnotations(proto, flags, annotatedCallableKind);
        if (ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, annotatedCallableKind);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        if (m.c(DescriptorUtilsKt.getFqNameSafe(this.f17404c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.f17404c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.f17404c.getVersionRequirementTable();
        }
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        DeclarationDescriptor containingDeclaration = this.f17404c.getContainingDeclaration();
        Name name = NameResolverUtilKt.getName(this.f17404c.getNameResolver(), proto.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(containingDeclaration, null, annotations, name, ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(flags)), proto, this.f17404c.getNameResolver(), this.f17404c.getTypeTable(), versionRequirementTable2, this.f17404c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.f17404c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        m.f(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(proto, this.f17404c.getTypeTable());
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (receiverType != null && (type = childContext$default.getTypeDeserializer().type(receiverType)) != null) {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, empty);
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        m.f(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, proto, annotatedCallableKind);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.f17404c.getTypeTable()));
        Modality modality = protoEnumFlags.modality(Flags.MODALITY.get(flags));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, Flags.VISIBILITY.get(flags));
        i2 = m0.i();
        Flags.BooleanFlagField booleanFlagField = Flags.IS_SUSPEND;
        Boolean bool = booleanFlagField.get(flags);
        m.f(bool, "IS_SUSPEND.get(flags)");
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor, dispatchReceiverParameter, ownTypeParameters, valueParameters, type2, modality, descriptorVisibility, i2, bool.booleanValue());
        Boolean bool2 = Flags.IS_OPERATOR.get(flags);
        m.f(bool2, "IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.setOperator(bool2.booleanValue());
        Boolean bool3 = Flags.IS_INFIX.get(flags);
        m.f(bool3, "IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.setInfix(bool3.booleanValue());
        Boolean bool4 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        m.f(bool4, "IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExternal(bool4.booleanValue());
        Boolean bool5 = Flags.IS_INLINE.get(flags);
        m.f(bool5, "IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.setInline(bool5.booleanValue());
        Boolean bool6 = Flags.IS_TAILREC.get(flags);
        m.f(bool6, "IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool6.booleanValue());
        Boolean bool7 = booleanFlagField.get(flags);
        m.f(bool7, "IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool7.booleanValue());
        Boolean bool8 = Flags.IS_EXPECT_FUNCTION.get(flags);
        m.f(bool8, "IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExpect(bool8.booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags).booleanValue());
        o<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.f17404c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, deserializedSimpleFunctionDescriptor, this.f17404c.getTypeTable(), childContext$default.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.c(), deserializeContractFromFunction.d());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final PropertyDescriptor loadProperty(ProtoBuf.Property proto) {
        ProtoBuf.Property property;
        Annotations empty;
        KotlinType type;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor createExtensionReceiverParameterForCallable;
        Flags.FlagField<ProtoBuf.Modality> flagField;
        Flags.FlagField<ProtoBuf.Visibility> flagField2;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        ProtoBuf.Property property2;
        int i2;
        boolean z;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        List g2;
        List<ProtoBuf.ValueParameter> b2;
        PropertyGetterDescriptorImpl createDefaultGetter;
        m.g(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        DeclarationDescriptor containingDeclaration = this.f17404c.getContainingDeclaration();
        Annotations annotations = getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Flags.FlagField<ProtoBuf.Modality> flagField3 = Flags.MODALITY;
        Modality modality = protoEnumFlags.modality(flagField3.get(flags));
        Flags.FlagField<ProtoBuf.Visibility> flagField4 = Flags.VISIBILITY;
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, flagField4.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        m.f(bool, "IS_VAR.get(flags)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.f17404c.getNameResolver(), proto.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        m.f(bool2, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        m.f(bool3, "IS_CONST.get(flags)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        m.f(bool4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        m.f(bool5, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        m.f(bool6, "IS_EXPECT_PROPERTY.get(flags)");
        ProtoEnumFlags protoEnumFlags2 = protoEnumFlags;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, descriptorVisibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), proto, this.f17404c.getNameResolver(), this.f17404c.getTypeTable(), this.f17404c.getVersionRequirementTable(), this.f17404c.getContainerSource());
        DeserializationContext deserializationContext = this.f17404c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        m.f(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedPropertyDescriptor3, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(flags);
        m.f(bool7, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = bool7.booleanValue();
        if (booleanValue6 && ProtoTypeTableUtilKt.hasReceiver(proto)) {
            property = proto;
            empty = getReceiverParameterAnnotations(property, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            property = proto;
            empty = Annotations.Companion.getEMPTY();
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property, this.f17404c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property, this.f17404c.getTypeTable());
        if (receiverType == null || (type = childContext$default.getTypeDeserializer().type(receiverType)) == null) {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            createExtensionReceiverParameterForCallable = null;
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            createExtensionReceiverParameterForCallable = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, empty);
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, createExtensionReceiverParameterForCallable);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(flags);
        m.f(bool8, "HAS_ANNOTATIONS.get(flags)");
        int accessorFlags = Flags.getAccessorFlags(bool8.booleanValue(), flagField4.get(flags), flagField3.get(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : accessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            m.f(bool9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            m.f(bool10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            m.f(bool11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = bool11.booleanValue();
            Annotations annotations2 = getAnnotations(property, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                protoEnumFlags2 = protoEnumFlags2;
                flagField = flagField3;
                flagField2 = flagField4;
                createDefaultGetter = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, protoEnumFlags2.modality(flagField3.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, flagField4.get(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                flagField = flagField3;
                flagField2 = flagField4;
                createDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations2);
                m.f(createDefaultGetter, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            createDefaultGetter.initialize(deserializedPropertyDescriptor.getReturnType());
            propertyGetterDescriptorImpl = createDefaultGetter;
        } else {
            flagField = flagField3;
            flagField2 = flagField4;
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(flags);
        m.f(bool12, "HAS_SETTER.get(flags)");
        if (bool12.booleanValue()) {
            if (proto.hasSetterFlags()) {
                accessorFlags = proto.getSetterFlags();
            }
            int i3 = accessorFlags;
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(i3);
            m.f(bool13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(i3);
            m.f(bool14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(i3);
            m.f(bool15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = bool15.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations annotations3 = getAnnotations(property, i3, annotatedCallableKind);
            if (booleanValue10) {
                ProtoEnumFlags protoEnumFlags3 = protoEnumFlags2;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, protoEnumFlags3.modality(flagField.get(i3)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags3, flagField2.get(i3)), !booleanValue10, booleanValue11, booleanValue12, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
                g2 = r.g();
                z = true;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property2 = property;
                i2 = flags;
                MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(childContext$default, propertySetterDescriptorImpl2, g2, null, null, null, null, 60, null).getMemberDeserializer();
                b2 = q.b(proto.getSetterValueParameter());
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) p.x0(memberDeserializer.valueParameters(b2, property2, annotatedCallableKind)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property2 = property;
                i2 = flags;
                z = true;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor2, annotations3, Annotations.Companion.getEMPTY());
                m.f(propertySetterDescriptorImpl, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
            }
        } else {
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            property2 = property;
            i2 = flags;
            z = true;
            propertySetterDescriptorImpl = null;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(i2);
        m.f(bool16, "HAS_CONSTANT.get(flags)");
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor2.setCompileTimeInitializer(this.f17404c.getStorageManager().createNullableLazyValue(new MemberDeserializer$loadProperty$3(this, property2, deserializedPropertyDescriptor2)));
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property2, z), deserializedPropertyDescriptor2), checkExperimentalCoroutine(deserializedPropertyDescriptor2, childContext$default.getTypeDeserializer()));
        return deserializedPropertyDescriptor2;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias proto) {
        int r;
        m.g(proto, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        m.f(annotationList, "proto.annotationList");
        r = s.r(annotationList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (ProtoBuf.Annotation it : annotationList) {
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            m.f(it, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(it, this.f17404c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.f17404c.getStorageManager(), this.f17404c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.f17404c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(proto.getFlags())), proto, this.f17404c.getNameResolver(), this.f17404c.getTypeTable(), this.f17404c.getVersionRequirementTable(), this.f17404c.getContainerSource());
        DeserializationContext deserializationContext = this.f17404c;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        m.f(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.f17404c.getTypeTable()), false), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.f17404c.getTypeTable()), false), checkExperimentalCoroutine(deserializedTypeAliasDescriptor, childContext$default.getTypeDeserializer()));
        return deserializedTypeAliasDescriptor;
    }
}
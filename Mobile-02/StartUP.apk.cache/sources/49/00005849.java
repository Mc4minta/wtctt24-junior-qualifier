package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k0.h;
import kotlin.k0.n;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.http.message.TokenParser;

/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class TypeDeserializer {

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f17405c;
    private final l<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private boolean experimentalSuspendFunctionTypeEncountered;
    private final TypeDeserializer parent;
    private final l<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext c2, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> typeParameterProtos, String debugName, String containerPresentableName, boolean z) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        m.g(c2, "c");
        m.g(typeParameterProtos, "typeParameterProtos");
        m.g(debugName, "debugName");
        m.g(containerPresentableName, "containerPresentableName");
        this.f17405c = c2;
        this.parent = typeDeserializer;
        this.debugName = debugName;
        this.containerPresentableName = containerPresentableName;
        this.experimentalSuspendFunctionTypeEncountered = z;
        this.classifierDescriptors = c2.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = c2.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = m0.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            for (ProtoBuf.TypeParameter typeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.f17405c, typeParameter, i2));
                i2++;
            }
        }
        this.typeParameterDescriptors = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int i2) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f17405c.getNameResolver(), i2);
        if (classId.isLocal()) {
            return this.f17405c.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.f17405c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i2) {
        if (NameResolverUtilKt.getClassId(this.f17405c.getNameResolver(), i2).isLocal()) {
            return this.f17405c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i2) {
        ClassId classId = NameResolverUtilKt.getClassId(this.f17405c.getNameResolver(), i2);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.f17405c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        List<TypeProjection> R;
        int r;
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        R = z.R(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        r = s.r(R, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeProjection typeProjection : R) {
            arrayList.add(typeProjection.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final SimpleType createSuspendFunctionType(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        SimpleType simpleType = null;
        if (size2 == 0) {
            simpleType = createSuspendFunctionTypeForBasicCase(annotations, typeConstructor, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().getSuspendFunction(size).getTypeConstructor();
            m.f(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
            simpleType = KotlinTypeFactory.simpleType$default(annotations, typeConstructor2, list, z, null, 16, null);
        }
        if (simpleType == null) {
            SimpleType createErrorTypeWithArguments = ErrorUtils.createErrorTypeWithArguments(m.o("Bad suspend function in metadata with constructor: ", typeConstructor), list);
            m.f(createErrorTypeWithArguments, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
            return createErrorTypeWithArguments;
        }
        return simpleType;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(annotations, typeConstructor, list, z, null, 16, null);
        if (FunctionTypesKt.isFunctionType(simpleType$default)) {
            return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
        }
        return null;
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> t0;
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        m.f(argumentList, "argumentList");
        ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type, typeDeserializer.f17405c.getTypeTable());
        List<ProtoBuf.Type.Argument> simpleType$collectAllArguments = outerType == null ? null : simpleType$collectAllArguments(outerType, typeDeserializer);
        if (simpleType$collectAllArguments == null) {
            simpleType$collectAllArguments = r.g();
        }
        t0 = z.t0(argumentList, simpleType$collectAllArguments);
        return t0;
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        boolean releaseCoroutines = this.f17405c.getComponents().getConfiguration().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) p.l0(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        KotlinType type = typeProjection == null ? null : typeProjection.getType();
        if (type == null) {
            return null;
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = type.getConstructor().mo2214getDeclarationDescriptor();
        FqName fqNameSafe = mo2214getDeclarationDescriptor == null ? null : DescriptorUtilsKt.getFqNameSafe(mo2214getDeclarationDescriptor);
        boolean z = true;
        if (type.getArguments().size() == 1 && (SuspendFunctionTypesKt.isContinuation(fqNameSafe, true) || SuspendFunctionTypesKt.isContinuation(fqNameSafe, false))) {
            KotlinType type2 = ((TypeProjection) p.x0(type.getArguments())).getType();
            m.f(type2, "continuationArgumentType.arguments.single().type");
            DeclarationDescriptor containingDeclaration = this.f17405c.getContainingDeclaration();
            if (!(containingDeclaration instanceof CallableDescriptor)) {
                containingDeclaration = null;
            }
            CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
            if (m.c(callableDescriptor != null ? DescriptorUtilsKt.fqNameOrNull(callableDescriptor) : null, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
                return createSimpleSuspendFunctionType(kotlinType, type2);
            }
            if (!this.experimentalSuspendFunctionTypeEncountered && (!releaseCoroutines || !SuspendFunctionTypesKt.isContinuation(fqNameSafe, !releaseCoroutines))) {
                z = false;
            }
            this.experimentalSuspendFunctionTypeEncountered = z;
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return (SimpleType) kotlinType;
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                return new StarProjectionForAbsentTypeParameter(this.f17405c.getComponents().getModuleDescriptor().getBuiltIns());
            }
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        m.f(projection, "typeArgumentProto.projection");
        Variance variance = protoEnumFlags.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.f17405c.getTypeTable());
        return type == null ? new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded")) : new TypeProjectionImpl(variance, type(type));
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type type) {
        Object obj;
        TypeConstructor typeConstructor;
        if (type.hasClassName()) {
            ClassifierDescriptor invoke = this.classifierDescriptors.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = typeConstructor$notFoundClass(this, type, type.getClassName());
            }
            TypeConstructor typeConstructor2 = invoke.getTypeConstructor();
            m.f(typeConstructor2, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
            return typeConstructor2;
        } else if (type.hasTypeParameter()) {
            TypeConstructor typeParameterTypeConstructor = typeParameterTypeConstructor(type.getTypeParameter());
            if (typeParameterTypeConstructor == null) {
                TypeConstructor createErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.containerPresentableName + TokenParser.DQUOTE);
                m.f(createErrorTypeConstructor, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
                return createErrorTypeConstructor;
            }
            return typeParameterTypeConstructor;
        } else if (type.hasTypeParameterName()) {
            DeclarationDescriptor containingDeclaration = this.f17405c.getContainingDeclaration();
            String string = this.f17405c.getNameResolver().getString(type.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (m.c(((TypeParameterDescriptor) obj).getName().asString(), string)) {
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) obj;
            TypeConstructor typeConstructor3 = typeParameterDescriptor != null ? typeParameterDescriptor.getTypeConstructor() : null;
            if (typeConstructor3 == null) {
                typeConstructor = ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration);
            } else {
                typeConstructor = typeConstructor3;
            }
            m.f(typeConstructor, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
            return typeConstructor;
        } else if (!type.hasTypeAliasName()) {
            TypeConstructor createErrorTypeConstructor2 = ErrorUtils.createErrorTypeConstructor("Unknown type");
            m.f(createErrorTypeConstructor2, "createErrorTypeConstructor(\"Unknown type\")");
            return createErrorTypeConstructor2;
        } else {
            ClassifierDescriptor invoke2 = this.typeAliasDescriptors.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke2 == null) {
                invoke2 = typeConstructor$notFoundClass(this, type, type.getTypeAliasName());
            }
            TypeConstructor typeConstructor4 = invoke2.getTypeConstructor();
            m.f(typeConstructor4, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
            return typeConstructor4;
        }
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i2) {
        h g2;
        h v;
        List<Integer> C;
        h g3;
        int k2;
        ClassId classId = NameResolverUtilKt.getClassId(typeDeserializer.f17405c.getNameResolver(), i2);
        g2 = n.g(type, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(typeDeserializer));
        v = kotlin.k0.p.v(g2, TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE);
        C = kotlin.k0.p.C(v);
        g3 = n.g(classId, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE);
        k2 = kotlin.k0.p.k(g3);
        while (C.size() < k2) {
            C.add(0);
        }
        return typeDeserializer.f17405c.getComponents().getNotFoundClasses().getClass(classId, C);
    }

    private final TypeConstructor typeParameterTypeConstructor(int i2) {
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i2));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor == null) {
            TypeDeserializer typeDeserializer = this.parent;
            if (typeDeserializer == null) {
                return null;
            }
            return typeDeserializer.typeParameterTypeConstructor(i2);
        }
        return typeConstructor;
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.experimentalSuspendFunctionTypeEncountered;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        List<TypeParameterDescriptor> I0;
        I0 = z.I0(this.typeParameterDescriptors.values());
        return I0;
    }

    public final SimpleType simpleType(ProtoBuf.Type proto, boolean z) {
        SimpleType computeLocalClassifierReplacementType;
        int r;
        List<? extends TypeProjection> I0;
        SimpleType simpleType$default;
        SimpleType withAbbreviation;
        List<? extends AnnotationDescriptor> r0;
        m.g(proto, "proto");
        if (proto.hasClassName()) {
            computeLocalClassifierReplacementType = computeLocalClassifierReplacementType(proto.getClassName());
        } else {
            computeLocalClassifierReplacementType = proto.hasTypeAliasName() ? computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null;
        }
        if (computeLocalClassifierReplacementType != null) {
            return computeLocalClassifierReplacementType;
        }
        TypeConstructor typeConstructor = typeConstructor(proto);
        if (ErrorUtils.isError(typeConstructor.mo2214getDeclarationDescriptor())) {
            SimpleType createErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(typeConstructor.toString(), typeConstructor);
            m.f(createErrorTypeWithCustomConstructor, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return createErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.f17405c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, proto));
        List<ProtoBuf.Type.Argument> simpleType$collectAllArguments = simpleType$collectAllArguments(proto, this);
        r = s.r(simpleType$collectAllArguments, 10);
        ArrayList arrayList = new ArrayList(r);
        int i2 = 0;
        for (Object obj : simpleType$collectAllArguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            m.f(parameters, "constructor.parameters");
            arrayList.add(typeArgument((TypeParameterDescriptor) p.b0(parameters, i2), (ProtoBuf.Type.Argument) obj));
            i2 = i3;
        }
        I0 = z.I0(arrayList);
        ClassifierDescriptor mo2214getDeclarationDescriptor = typeConstructor.mo2214getDeclarationDescriptor();
        if (z && (mo2214getDeclarationDescriptor instanceof TypeAliasDescriptor)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) mo2214getDeclarationDescriptor, I0);
            SimpleType makeNullableAsSpecified = computeExpandedType.makeNullableAsSpecified(KotlinTypeKt.isNullable(computeExpandedType) || proto.getNullable());
            Annotations.Companion companion = Annotations.Companion;
            r0 = z.r0(deserializedAnnotations, computeExpandedType.getAnnotations());
            simpleType$default = makeNullableAsSpecified.replaceAnnotations(companion.create(r0));
        } else {
            Boolean bool = Flags.SUSPEND_TYPE.get(proto.getFlags());
            m.f(bool, "SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                simpleType$default = createSuspendFunctionType(deserializedAnnotations, typeConstructor, I0, proto.getNullable());
            } else {
                KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
                simpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructor, I0, proto.getNullable(), null, 16, null);
            }
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(proto, this.f17405c.getTypeTable());
        if (abbreviatedType != null && (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType$default, simpleType(abbreviatedType, false))) != null) {
            simpleType$default = withAbbreviation;
        }
        return proto.hasClassName() ? this.f17405c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.f17405c.getNameResolver(), proto.getClassName()), simpleType$default) : simpleType$default;
    }

    public String toString() {
        String str = this.debugName;
        TypeDeserializer typeDeserializer = this.parent;
        return m.o(str, typeDeserializer == null ? "" : m.o(". Child of ", typeDeserializer.debugName));
    }

    public final KotlinType type(ProtoBuf.Type proto) {
        m.g(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String string = this.f17405c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            SimpleType simpleType$default = simpleType$default(this, proto, false, 2, null);
            ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.f17405c.getTypeTable());
            m.e(flexibleUpperBound);
            return this.f17405c.getComponents().getFlexibleTypeDeserializer().create(proto, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, null));
        }
        return simpleType(proto, true);
    }

    public /* synthetic */ TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationContext, typeDeserializer, list, str, str2, (i2 & 32) != 0 ? false : z);
    }
}
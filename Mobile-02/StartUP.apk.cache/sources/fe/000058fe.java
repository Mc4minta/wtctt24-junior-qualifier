package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeAliasExpander.kt */
/* loaded from: classes3.dex */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion(null);
    private static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    /* compiled from: TypeAliasExpander.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void assertRecursionDepth(int i2, TypeAliasDescriptor typeAliasDescriptor) {
            if (i2 > 100) {
                throw new AssertionError(m.o("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }

        public final void checkBoundsInTypeAlias(TypeAliasExpansionReportStrategy reportStrategy, KotlinType unsubstitutedArgument, KotlinType typeArgument, TypeParameterDescriptor typeParameterDescriptor, TypeSubstitutor substitutor) {
            m.g(reportStrategy, "reportStrategy");
            m.g(unsubstitutedArgument, "unsubstitutedArgument");
            m.g(typeArgument, "typeArgument");
            m.g(typeParameterDescriptor, "typeParameterDescriptor");
            m.g(substitutor, "substitutor");
            for (KotlinType kotlinType : typeParameterDescriptor.getUpperBounds()) {
                KotlinType safeSubstitute = substitutor.safeSubstitute(kotlinType, Variance.INVARIANT);
                m.f(safeSubstitute, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(typeArgument, safeSubstitute)) {
                    reportStrategy.boundsViolationInSubstitution(safeSubstitute, unsubstitutedArgument, typeArgument, typeParameterDescriptor);
                }
            }
        }
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy reportStrategy, boolean z) {
        m.g(reportStrategy, "reportStrategy");
        this.reportStrategy = reportStrategy;
        this.shouldCheckBounds = z;
    }

    private final void checkRepeatedAnnotations(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (AnnotationDescriptor annotationDescriptor : annotations2) {
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final void checkTypeArgumentsSubstitution(KotlinType kotlinType, KotlinType kotlinType2) {
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType2);
        m.f(create, "create(substitutedType)");
        int i2 = 0;
        for (Object obj : kotlinType2.getArguments()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (!typeProjection.isStarProjection()) {
                KotlinType type = typeProjection.getType();
                m.f(type, "substitutedArgument.type");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection typeProjection2 = kotlinType.getArguments().get(i2);
                    TypeParameterDescriptor typeParameter = kotlinType.getConstructor().getParameters().get(i2);
                    if (this.shouldCheckBounds) {
                        Companion companion = Companion;
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        KotlinType type2 = typeProjection2.getType();
                        m.f(type2, "unsubstitutedArgument.type");
                        KotlinType type3 = typeProjection.getType();
                        m.f(type3, "substitutedArgument.type");
                        m.f(typeParameter, "typeParameter");
                        companion.checkBoundsInTypeAlias(typeAliasExpansionReportStrategy, type2, type3, typeParameter, create);
                    }
                }
            }
            i2 = i3;
        }
    }

    private final DynamicType combineAnnotations(DynamicType dynamicType, Annotations annotations) {
        return dynamicType.replaceAnnotations(createCombinedAnnotations(dynamicType, annotations));
    }

    private final SimpleType combineNullability(SimpleType simpleType, KotlinType kotlinType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        m.f(makeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType simpleType, KotlinType kotlinType) {
        return combineAnnotations(combineNullability(simpleType, kotlinType), kotlinType.getAnnotations());
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        m.f(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.getArguments(), z, MemberScope.Empty.INSTANCE);
    }

    private final Annotations createCombinedAnnotations(KotlinType kotlinType, Annotations annotations) {
        return KotlinTypeKt.isError(kotlinType) ? kotlinType.getAnnotations() : AnnotationsKt.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, int i2) {
        int r;
        UnwrappedType unwrap = typeProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(unwrap)) {
            return typeProjection;
        }
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
        if (KotlinTypeKt.isError(asSimpleType) || !TypeUtilsKt.requiresTypeAliasExpansion(asSimpleType)) {
            return typeProjection;
        }
        TypeConstructor constructor = asSimpleType.getConstructor();
        ClassifierDescriptor mo2214getDeclarationDescriptor = constructor.mo2214getDeclarationDescriptor();
        constructor.getParameters().size();
        asSimpleType.getArguments().size();
        if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        if (mo2214getDeclarationDescriptor instanceof TypeAliasDescriptor) {
            TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) mo2214getDeclarationDescriptor;
            if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor);
                return new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(m.o("Recursive type alias: ", typeAliasDescriptor.getName())));
            }
            List<TypeProjection> arguments = asSimpleType.getArguments();
            r = s.r(arguments, 10);
            ArrayList arrayList = new ArrayList(r);
            int i3 = 0;
            for (Object obj : arguments) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    r.q();
                }
                arrayList.add(expandTypeProjection((TypeProjection) obj, typeAliasExpansion, constructor.getParameters().get(i3), i2 + 1));
                i3 = i4;
            }
            SimpleType expandRecursively = expandRecursively(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i2 + 1, false);
            SimpleType substituteArguments = substituteArguments(asSimpleType, typeAliasExpansion, i2);
            if (!DynamicTypesKt.isDynamic(expandRecursively)) {
                expandRecursively = SpecialTypesKt.withAbbreviation(expandRecursively, substituteArguments);
            }
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), expandRecursively);
        }
        SimpleType substituteArguments2 = substituteArguments(asSimpleType, typeAliasExpansion, i2);
        checkTypeArgumentsSubstitution(asSimpleType, substituteArguments2);
        return new TypeProjectionImpl(typeProjection.getProjectionKind(), substituteArguments2);
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i2, boolean z2) {
        TypeProjection expandTypeProjection = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i2);
        KotlinType type = expandTypeProjection.getType();
        m.f(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        expandTypeProjection.getProjectionKind();
        checkRepeatedAnnotations(asSimpleType.getAnnotations(), annotations);
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(combineAnnotations(asSimpleType, annotations), z);
        m.f(makeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        return z2 ? SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, createAbbreviation(typeAliasExpansion, annotations, z)) : makeNullableIfNeeded;
    }

    private final TypeProjection expandTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i2) {
        KotlinType combineNullabilityAndAnnotations;
        Variance variance;
        Variance variance2;
        Companion.assertRecursionDepth(i2, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            m.e(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            m.f(makeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        m.f(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            return expandNonArgumentTypeProjection(typeProjection, typeAliasExpansion, i2);
        }
        if (replacement.isStarProjection()) {
            m.e(typeParameterDescriptor);
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            m.f(makeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection2;
        }
        UnwrappedType unwrap = replacement.getType().unwrap();
        Variance projectionKind = replacement.getProjectionKind();
        m.f(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        m.f(projectionKind2, "underlyingProjection.projectionKind");
        if (projectionKind2 != projectionKind && projectionKind2 != (variance2 = Variance.INVARIANT)) {
            if (projectionKind == variance2) {
                projectionKind = projectionKind2;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        Variance variance3 = typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance();
        if (variance3 == null) {
            variance3 = Variance.INVARIANT;
        }
        m.f(variance3, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
        if (variance3 != projectionKind && variance3 != (variance = Variance.INVARIANT)) {
            if (projectionKind == variance) {
                projectionKind = variance;
            } else {
                this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        checkRepeatedAnnotations(type.getAnnotations(), unwrap.getAnnotations());
        if (unwrap instanceof DynamicType) {
            combineNullabilityAndAnnotations = combineAnnotations((DynamicType) unwrap, type.getAnnotations());
        } else {
            combineNullabilityAndAnnotations = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(unwrap), type);
        }
        return new TypeProjectionImpl(projectionKind, combineNullabilityAndAnnotations);
    }

    private final SimpleType substituteArguments(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i2) {
        int r;
        TypeConstructor constructor = simpleType.getConstructor();
        List<TypeProjection> arguments = simpleType.getArguments();
        r = s.r(arguments, 10);
        ArrayList arrayList = new ArrayList(r);
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                r.q();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            TypeProjection expandTypeProjection = expandTypeProjection(typeProjection, typeAliasExpansion, constructor.getParameters().get(i3), i2 + 1);
            if (!expandTypeProjection.isStarProjection()) {
                expandTypeProjection = new TypeProjectionImpl(expandTypeProjection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(expandTypeProjection.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(expandTypeProjection);
            i3 = i4;
        }
        return TypeSubstitutionKt.replace$default(simpleType, arrayList, null, 2, null);
    }

    public final SimpleType expand(TypeAliasExpansion typeAliasExpansion, Annotations annotations) {
        m.g(typeAliasExpansion, "typeAliasExpansion");
        m.g(annotations, "annotations");
        return expandRecursively(typeAliasExpansion, annotations, false, 0, true);
    }

    private final SimpleType combineAnnotations(SimpleType simpleType, Annotations annotations) {
        return KotlinTypeKt.isError(simpleType) ? simpleType : TypeSubstitutionKt.replace$default(simpleType, null, createCombinedAnnotations(simpleType, annotations), 1, null);
    }
}
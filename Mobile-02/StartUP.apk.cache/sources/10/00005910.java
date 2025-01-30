package kotlin.reflect.jvm.internal.impl.types;

import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.e0.c.l;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;

/* loaded from: classes3.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = create(TypeSubstitution.EMPTY);
    private final TypeSubstitution substitution;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType;

        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = iArr;
            try {
                iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.$$$reportNull$$$0(int):void");
    }

    protected TypeSubstitutor(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(6);
        }
        this.substitution = typeSubstitution;
    }

    private static void assertRecursionDepth(int i2, TypeProjection typeProjection, TypeSubstitution typeSubstitution) {
        if (i2 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(typeProjection) + "; substitution: " + safeToString(typeSubstitution));
    }

    public static Variance combine(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            $$$reportNull$$$0(33);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(34);
        }
        if (typeProjection.isStarProjection()) {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 == null) {
                $$$reportNull$$$0(35);
            }
            return variance2;
        }
        return combine(variance, typeProjection.getProjectionKind());
    }

    private static VarianceConflictType conflictType(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor create(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(0);
        }
        return new TypeSubstitutor(typeSubstitution);
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(2);
        }
        if (typeSubstitution2 == null) {
            $$$reportNull$$$0(3);
        }
        return create(DisjointKeysUnionTypeSubstitution.create(typeSubstitution, typeSubstitution2));
    }

    private static Annotations filterOutUnsafeVariance(Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(31);
        }
        return !annotations.hasAnnotation(StandardNames.FqNames.unsafeVariance) ? annotations : new FilteredAnnotations(annotations, new l<FqName, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.1
            private static /* synthetic */ void $$$reportNull$$$0(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", ApiConstants.NAME, "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
            }

            @Override // kotlin.e0.c.l
            public Boolean invoke(FqName fqName) {
                if (fqName == null) {
                    $$$reportNull$$$0(0);
                }
                return Boolean.valueOf(!fqName.equals(StandardNames.FqNames.unsafeVariance));
            }
        });
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType kotlinType, TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor, TypeProjection typeProjection2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(24);
        }
        if (typeProjection == null) {
            $$$reportNull$$$0(25);
        }
        if (typeProjection2 == null) {
            $$$reportNull$$$0(26);
        }
        if (!kotlinType.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance)) {
            if (typeProjection == null) {
                $$$reportNull$$$0(27);
            }
            return typeProjection;
        }
        TypeConstructor constructor = typeProjection.getType().getConstructor();
        if (constructor instanceof NewCapturedTypeConstructor) {
            TypeProjection projection = ((NewCapturedTypeConstructor) constructor).getProjection();
            Variance projectionKind = projection.getProjectionKind();
            VarianceConflictType conflictType = conflictType(typeProjection2.getProjectionKind(), projectionKind);
            VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
            if (conflictType == varianceConflictType) {
                return new TypeProjectionImpl(projection.getType());
            }
            return (typeParameterDescriptor != null && conflictType(typeParameterDescriptor.getVariance(), projectionKind) == varianceConflictType) ? new TypeProjectionImpl(projection.getType()) : typeProjection;
        }
        return typeProjection;
    }

    private static String safeToString(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!ExceptionUtilsKt.isProcessCanceledException(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private TypeProjection substituteCompoundType(TypeProjection typeProjection, int i2) throws SubstitutionException {
        KotlinType type = typeProjection.getType();
        Variance projectionKind = typeProjection.getProjectionKind();
        if (type.getConstructor().mo2214getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return typeProjection;
        }
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type);
        KotlinType substitute = abbreviation != null ? replaceWithNonApproximatingSubstitution().substitute(abbreviation, Variance.INVARIANT) : null;
        KotlinType replace = TypeSubstitutionKt.replace(type, substituteTypeArguments(type.getConstructor().getParameters(), type.getArguments(), i2), this.substitution.filterAnnotations(type.getAnnotations()));
        if ((replace instanceof SimpleType) && (substitute instanceof SimpleType)) {
            replace = SpecialTypesKt.withAbbreviation((SimpleType) replace, (SimpleType) substitute);
        }
        return new TypeProjectionImpl(projectionKind, replace);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i2) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            TypeParameterDescriptor typeParameterDescriptor = list.get(i3);
            TypeProjection typeProjection = list2.get(i3);
            TypeProjection unsafeSubstitute = unsafeSubstitute(typeProjection, typeParameterDescriptor, i2 + 1);
            int i4 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(typeParameterDescriptor.getVariance(), unsafeSubstitute.getProjectionKind()).ordinal()];
            if (i4 == 1 || i4 == 2) {
                unsafeSubstitute = TypeUtils.makeStarProjection(typeParameterDescriptor);
            } else if (i4 == 3) {
                Variance variance = typeParameterDescriptor.getVariance();
                Variance variance2 = Variance.INVARIANT;
                if (variance != variance2 && !unsafeSubstitute.isStarProjection()) {
                    unsafeSubstitute = new TypeProjectionImpl(variance2, unsafeSubstitute.getType());
                }
            }
            if (unsafeSubstitute != typeProjection) {
                z = true;
            }
            arrayList.add(unsafeSubstitute);
        }
        return !z ? list2 : arrayList;
    }

    private TypeProjection unsafeSubstitute(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor, int i2) throws SubstitutionException {
        KotlinType makeNullableIfNeeded;
        if (typeProjection == null) {
            $$$reportNull$$$0(17);
        }
        assertRecursionDepth(i2, typeProjection, this.substitution);
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        if (type instanceof TypeWithEnhancement) {
            TypeWithEnhancement typeWithEnhancement = (TypeWithEnhancement) type;
            UnwrappedType origin = typeWithEnhancement.getOrigin();
            KotlinType enhancement = typeWithEnhancement.getEnhancement();
            TypeProjection unsafeSubstitute = unsafeSubstitute(new TypeProjectionImpl(typeProjection.getProjectionKind(), origin), typeParameterDescriptor, i2 + 1);
            return new TypeProjectionImpl(unsafeSubstitute.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(unsafeSubstitute.getType().unwrap(), substitute(enhancement, typeProjection.getProjectionKind())));
        }
        if (!DynamicTypesKt.isDynamic(type) && !(type.unwrap() instanceof RawType)) {
            TypeProjection mo2219get = this.substitution.mo2219get(type);
            TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance = mo2219get != null ? projectedTypeForConflictedTypeWithUnsafeVariance(type, mo2219get, typeParameterDescriptor, typeProjection) : null;
            Variance projectionKind = typeProjection.getProjectionKind();
            if (projectedTypeForConflictedTypeWithUnsafeVariance == null && FlexibleTypesKt.isFlexible(type) && !TypeCapabilitiesKt.isCustomTypeVariable(type)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(type);
                int i3 = i2 + 1;
                TypeProjection unsafeSubstitute2 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getLowerBound()), typeParameterDescriptor, i3);
                TypeProjection unsafeSubstitute3 = unsafeSubstitute(new TypeProjectionImpl(projectionKind, asFlexibleType.getUpperBound()), typeParameterDescriptor, i3);
                return (unsafeSubstitute2.getType() == asFlexibleType.getLowerBound() && unsafeSubstitute3.getType() == asFlexibleType.getUpperBound()) ? typeProjection : new TypeProjectionImpl(unsafeSubstitute2.getProjectionKind(), KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(unsafeSubstitute2.getType()), TypeSubstitutionKt.asSimpleType(unsafeSubstitute3.getType())));
            } else if (!KotlinBuiltIns.isNothing(type) && !KotlinTypeKt.isError(type)) {
                if (projectedTypeForConflictedTypeWithUnsafeVariance != null) {
                    VarianceConflictType conflictType = conflictType(projectionKind, projectedTypeForConflictedTypeWithUnsafeVariance.getProjectionKind());
                    if (!CapturedTypeConstructorKt.isCaptured(type)) {
                        int i4 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType.ordinal()];
                        if (i4 == 1) {
                            throw new SubstitutionException("Out-projection in in-position");
                        }
                        if (i4 == 2) {
                            return new TypeProjectionImpl(Variance.OUT_VARIANCE, type.getConstructor().getBuiltIns().getNullableAnyType());
                        }
                    }
                    CustomTypeVariable customTypeVariable = TypeCapabilitiesKt.getCustomTypeVariable(type);
                    if (projectedTypeForConflictedTypeWithUnsafeVariance.isStarProjection()) {
                        return projectedTypeForConflictedTypeWithUnsafeVariance;
                    }
                    if (customTypeVariable != null) {
                        makeNullableIfNeeded = customTypeVariable.substitutionResult(projectedTypeForConflictedTypeWithUnsafeVariance.getType());
                    } else {
                        makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(projectedTypeForConflictedTypeWithUnsafeVariance.getType(), type.isMarkedNullable());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        makeNullableIfNeeded = TypeUtilsKt.replaceAnnotations(makeNullableIfNeeded, new CompositeAnnotations(makeNullableIfNeeded.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(type.getAnnotations()))));
                    }
                    if (conflictType == VarianceConflictType.NO_CONFLICT) {
                        projectionKind = combine(projectionKind, projectedTypeForConflictedTypeWithUnsafeVariance.getProjectionKind());
                    }
                    return new TypeProjectionImpl(projectionKind, makeNullableIfNeeded);
                }
                typeProjection = substituteCompoundType(typeProjection, i2);
                if (typeProjection == null) {
                    $$$reportNull$$$0(23);
                }
            }
        }
        return typeProjection;
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            $$$reportNull$$$0(7);
        }
        return typeSubstitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        return ((typeSubstitution instanceof IndexedParametersSubstitution) && typeSubstitution.approximateContravariantCapturedTypes()) ? new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false)) : this;
    }

    public KotlinType safeSubstitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(8);
        }
        if (variance == null) {
            $$$reportNull$$$0(9);
        }
        if (isEmpty()) {
            if (kotlinType == null) {
                $$$reportNull$$$0(10);
            }
            return kotlinType;
        }
        try {
            KotlinType type = unsafeSubstitute(new TypeProjectionImpl(variance, kotlinType), null, 0).getType();
            if (type == null) {
                $$$reportNull$$$0(11);
            }
            return type;
        } catch (SubstitutionException e2) {
            SimpleType createErrorType = ErrorUtils.createErrorType(e2.getMessage());
            if (createErrorType == null) {
                $$$reportNull$$$0(12);
            }
            return createErrorType;
        }
    }

    public KotlinType substitute(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            $$$reportNull$$$0(13);
        }
        if (variance == null) {
            $$$reportNull$$$0(14);
        }
        TypeProjection substitute = substitute(new TypeProjectionImpl(variance, getSubstitution().prepareTopLevelType(kotlinType, variance)));
        if (substitute == null) {
            return null;
        }
        return substitute.getType();
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(16);
        }
        if (isEmpty()) {
            return typeProjection;
        }
        try {
            return unsafeSubstitute(typeProjection, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    public static TypeSubstitutor create(KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(5);
        }
        return create(TypeConstructorSubstitution.create(kotlinType.getConstructor(), kotlinType.getArguments()));
    }

    public static Variance combine(Variance variance, Variance variance2) {
        if (variance == null) {
            $$$reportNull$$$0(36);
        }
        if (variance2 == null) {
            $$$reportNull$$$0(37);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                $$$reportNull$$$0(38);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                $$$reportNull$$$0(39);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                $$$reportNull$$$0(40);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
    }

    public TypeProjection substitute(TypeProjection typeProjection) {
        if (typeProjection == null) {
            $$$reportNull$$$0(15);
        }
        TypeProjection substituteWithoutApproximation = substituteWithoutApproximation(typeProjection);
        return (this.substitution.approximateCapturedTypes() || this.substitution.approximateContravariantCapturedTypes()) ? CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substituteWithoutApproximation, this.substitution.approximateContravariantCapturedTypes()) : substituteWithoutApproximation;
    }
}
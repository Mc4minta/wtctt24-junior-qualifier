package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: classes3.dex */
public final class CapturedTypeApproximationKt {

    /* compiled from: CapturedTypeApproximation.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.valuesCustom().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(KotlinType type) {
        List<o> Q0;
        Object replaceTypeArguments;
        m.g(type, "type");
        if (FlexibleTypesKt.isFlexible(type)) {
            ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(type));
            ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(type));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getLower()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getLower())), type), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getUpper()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getUpper())), type));
        }
        TypeConstructor constructor = type.getConstructor();
        if (CapturedTypeConstructorKt.isCaptured(type)) {
            TypeProjection projection = ((CapturedTypeConstructor) constructor).getProjection();
            KotlinType type2 = projection.getType();
            m.f(type2, "typeProjection.type");
            KotlinType approximateCapturedTypes$makeNullableIfNeeded = approximateCapturedTypes$makeNullableIfNeeded(type2, type);
            int i2 = WhenMappings.$EnumSwitchMapping$0[projection.getProjectionKind().ordinal()];
            if (i2 == 2) {
                SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(type).getNullableAnyType();
                m.f(nullableAnyType, "type.builtIns.nullableAnyType");
                return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded, nullableAnyType);
            } else if (i2 == 3) {
                SimpleType nothingType = TypeUtilsKt.getBuiltIns(type).getNothingType();
                m.f(nothingType, "type.builtIns.nothingType");
                return new ApproximationBounds<>(approximateCapturedTypes$makeNullableIfNeeded(nothingType, type), approximateCapturedTypes$makeNullableIfNeeded);
            } else {
                throw new AssertionError(m.o("Only nontrivial projections should have been captured, not: ", projection));
            }
        } else if (!type.getArguments().isEmpty() && type.getArguments().size() == constructor.getParameters().size()) {
            ArrayList<TypeArgument> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> arguments = type.getArguments();
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            m.f(parameters, "typeConstructor.parameters");
            Q0 = z.Q0(arguments, parameters);
            for (o oVar : Q0) {
                TypeProjection typeProjection = (TypeProjection) oVar.a();
                TypeParameterDescriptor typeParameter = (TypeParameterDescriptor) oVar.b();
                m.f(typeParameter, "typeParameter");
                TypeArgument typeArgument = toTypeArgument(typeProjection, typeParameter);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(typeArgument);
                    arrayList2.add(typeArgument);
                } else {
                    ApproximationBounds<TypeArgument> approximateProjection = approximateProjection(typeArgument);
                    arrayList.add(approximateProjection.component1());
                    arrayList2.add(approximateProjection.component2());
                }
            }
            boolean z = true;
            if (!arrayList.isEmpty()) {
                for (TypeArgument typeArgument2 : arrayList) {
                    if (!typeArgument2.isConsistent()) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                replaceTypeArguments = TypeUtilsKt.getBuiltIns(type).getNothingType();
                m.f(replaceTypeArguments, "type.builtIns.nothingType");
            } else {
                replaceTypeArguments = replaceTypeArguments(type, arrayList);
            }
            return new ApproximationBounds<>(replaceTypeArguments, replaceTypeArguments(type, arrayList2));
        } else {
            return new ApproximationBounds<>(type, type);
        }
    }

    private static final KotlinType approximateCapturedTypes$makeNullableIfNeeded(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType, kotlinType2.isMarkedNullable());
        m.f(makeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        m.f(type, "typeProjection.type");
        if (TypeUtils.contains(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.INSTANCE)) {
            Variance projectionKind = typeProjection.getProjectionKind();
            m.f(projectionKind, "typeProjection.projectionKind");
            if (projectionKind == Variance.OUT_VARIANCE) {
                return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
            }
            if (z) {
                return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
            }
            return substituteCapturedTypesWithProjections(typeProjection);
        }
        return typeProjection;
    }

    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component2(), approximateCapturedTypes2.component1()), new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component1(), approximateCapturedTypes2.component2()));
    }

    private static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        int r;
        kotlinType.getArguments().size();
        list.size();
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (TypeArgument typeArgument : list) {
            arrayList.add(toTypeProjection(typeArgument));
        }
        return TypeSubstitutionKt.replace$default(kotlinType, arrayList, null, null, 6, null);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public TypeProjection get(TypeConstructor key) {
                m.g(key, "key");
                CapturedTypeConstructor capturedTypeConstructor = key instanceof CapturedTypeConstructor ? (CapturedTypeConstructor) key : null;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        m.f(create, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return create.substituteWithoutApproximation(typeProjection);
    }

    private static final TypeArgument toTypeArgument(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i2 == 1) {
            KotlinType type = typeProjection.getType();
            m.f(type, "type");
            KotlinType type2 = typeProjection.getType();
            m.f(type2, "type");
            return new TypeArgument(typeParameterDescriptor, type, type2);
        } else if (i2 == 2) {
            KotlinType type3 = typeProjection.getType();
            m.f(type3, "type");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            m.f(nullableAnyType, "typeParameter.builtIns.nullableAnyType");
            return new TypeArgument(typeParameterDescriptor, type3, nullableAnyType);
        } else if (i2 == 3) {
            SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
            m.f(nothingType, "typeParameter.builtIns.nothingType");
            KotlinType type4 = typeProjection.getType();
            m.f(type4, "type");
            return new TypeArgument(typeParameterDescriptor, nothingType, type4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final TypeProjection toTypeProjection(TypeArgument typeArgument) {
        typeArgument.isConsistent();
        if (!m.c(typeArgument.getInProjection(), typeArgument.getOutProjection())) {
            Variance variance = typeArgument.getTypeParameter().getVariance();
            Variance variance2 = Variance.IN_VARIANCE;
            if (variance != variance2) {
                if (!KotlinBuiltIns.isNothing(typeArgument.getInProjection()) || typeArgument.getTypeParameter().getVariance() == variance2) {
                    return KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection()) ? new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, variance2), typeArgument.getInProjection()) : new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
                }
                return new TypeProjectionImpl(toTypeProjection$removeProjectionIfRedundant(typeArgument, Variance.OUT_VARIANCE), typeArgument.getOutProjection());
            }
        }
        return new TypeProjectionImpl(typeArgument.getInProjection());
    }

    private static final Variance toTypeProjection$removeProjectionIfRedundant(TypeArgument typeArgument, Variance variance) {
        return variance == typeArgument.getTypeParameter().getVariance() ? Variance.INVARIANT : variance;
    }
}
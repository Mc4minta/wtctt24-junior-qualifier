package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: classes3.dex */
    public static class Result {
        private final int subtreeSize;
        private final KotlinType type;
        private final boolean wereChanges;

        public Result(KotlinType type, int i2, boolean z) {
            m.g(type, "type");
            this.type = type;
            this.subtreeSize = i2;
            this.wereChanges = z;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public KotlinType getType() {
            return this.type;
        }

        public final KotlinType getTypeIfChanged() {
            KotlinType type = getType();
            if (getWereChanges()) {
                return type;
            }
            return null;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class SimpleResult extends Result {
        private final SimpleType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleResult(SimpleType type, int i2, boolean z) {
            super(type, i2, z);
            m.g(type, "type");
            this.type = type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result
        public SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        m.g(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    private final KotlinType buildEnhancementByFlexibleTypeBounds(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType enhancement = TypeWithEnhancementKt.getEnhancement(kotlinType2);
        KotlinType enhancement2 = TypeWithEnhancementKt.getEnhancement(kotlinType);
        if (enhancement2 == null) {
            if (enhancement == null) {
                return null;
            }
            enhancement2 = enhancement;
        }
        if (enhancement == null) {
            return enhancement2;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(enhancement2), FlexibleTypesKt.upperIfFlexible(enhancement));
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, l<? super Integer, JavaTypeQualifiers> lVar, int i2, TypeComponentPosition typeComponentPosition, boolean z) {
        EnhancementResult enhanceMutability;
        int r;
        EnhancementResult enhancedNullability;
        List l2;
        Annotations compositeAnnotationsOrSingle;
        TypeProjection createProjection;
        if (TypeComponentPositionKt.shouldEnhance(typeComponentPosition) || !simpleType.getArguments().isEmpty()) {
            ClassifierDescriptor mo2214getDeclarationDescriptor = simpleType.getConstructor().mo2214getDeclarationDescriptor();
            if (mo2214getDeclarationDescriptor == null) {
                return new SimpleResult(simpleType, 1, false);
            }
            JavaTypeQualifiers invoke = lVar.invoke(Integer.valueOf(i2));
            enhanceMutability = TypeEnhancementKt.enhanceMutability(mo2214getDeclarationDescriptor, invoke, typeComponentPosition);
            ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) enhanceMutability.component1();
            Annotations component2 = enhanceMutability.component2();
            TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
            m.f(typeConstructor, "enhancedClassifier.typeConstructor");
            int i3 = i2 + 1;
            boolean z2 = component2 != null;
            List<TypeProjection> arguments = simpleType.getArguments();
            r = s.r(arguments, 10);
            ArrayList arrayList = new ArrayList(r);
            int i4 = 0;
            for (Object obj : arguments) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    r.q();
                }
                TypeProjection typeProjection = (TypeProjection) obj;
                if (typeProjection.isStarProjection()) {
                    int i6 = i3 + 1;
                    if (lVar.invoke(Integer.valueOf(i3)).getNullability() == NullabilityQualifier.NOT_NULL && !z) {
                        KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(typeProjection.getType().unwrap());
                        Variance projectionKind = typeProjection.getProjectionKind();
                        m.f(projectionKind, "arg.projectionKind");
                        createProjection = TypeUtilsKt.createProjection(makeNotNullable, projectionKind, typeConstructor.getParameters().get(i4));
                    } else {
                        createProjection = TypeUtils.makeStarProjection(classifierDescriptor.getTypeConstructor().getParameters().get(i4));
                        m.f(createProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                    }
                    i3 = i6;
                } else {
                    Result enhancePossiblyFlexible = enhancePossiblyFlexible(typeProjection.getType().unwrap(), lVar, i3);
                    z2 = z2 || enhancePossiblyFlexible.getWereChanges();
                    i3 += enhancePossiblyFlexible.getSubtreeSize();
                    KotlinType type = enhancePossiblyFlexible.getType();
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    m.f(projectionKind2, "arg.projectionKind");
                    createProjection = TypeUtilsKt.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i4));
                }
                arrayList.add(createProjection);
                i4 = i5;
            }
            enhancedNullability = TypeEnhancementKt.getEnhancedNullability(simpleType, invoke, typeComponentPosition);
            boolean booleanValue = ((Boolean) enhancedNullability.component1()).booleanValue();
            Annotations component22 = enhancedNullability.component2();
            int i7 = i3 - i2;
            if (!(z2 || component22 != null)) {
                return new SimpleResult(simpleType, i7, false);
            }
            boolean z3 = false;
            l2 = r.l(simpleType.getAnnotations(), component2, component22);
            compositeAnnotationsOrSingle = TypeEnhancementKt.compositeAnnotationsOrSingle(l2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(compositeAnnotationsOrSingle, typeConstructor, arrayList, booleanValue, null, 16, null);
            UnwrappedType unwrappedType = simpleType$default;
            if (invoke.isNotNullTypeParameter()) {
                unwrappedType = notNullTypeParameter(simpleType$default);
            }
            if (component22 != null && invoke.isNullabilityQualifierForWarning()) {
                z3 = true;
            }
            if (z3) {
                unwrappedType = TypeWithEnhancementKt.wrapEnhancement(simpleType, unwrappedType);
            }
            return new SimpleResult((SimpleType) unwrappedType, i7, true);
        }
        return new SimpleResult(simpleType, 1, false);
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, l lVar, int i2, TypeComponentPosition typeComponentPosition, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        return javaTypeEnhancement.enhanceInflexible(simpleType, lVar, i2, typeComponentPosition, z);
    }

    private final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, l<? super Integer, JavaTypeQualifiers> lVar, int i2) {
        UnwrappedType flexibleType;
        boolean z = false;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(unwrappedType, 1, false);
        }
        if (unwrappedType instanceof FlexibleType) {
            boolean z2 = unwrappedType instanceof RawType;
            FlexibleType flexibleType2 = (FlexibleType) unwrappedType;
            SimpleResult enhanceInflexible = enhanceInflexible(flexibleType2.getLowerBound(), lVar, i2, TypeComponentPosition.FLEXIBLE_LOWER, z2);
            SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType2.getUpperBound(), lVar, i2, TypeComponentPosition.FLEXIBLE_UPPER, z2);
            enhanceInflexible.getSubtreeSize();
            enhanceInflexible2.getSubtreeSize();
            if (enhanceInflexible.getWereChanges() || enhanceInflexible2.getWereChanges()) {
                z = true;
            }
            KotlinType buildEnhancementByFlexibleTypeBounds = buildEnhancementByFlexibleTypeBounds(enhanceInflexible.getType(), enhanceInflexible2.getType());
            if (z) {
                if (unwrappedType instanceof RawTypeImpl) {
                    flexibleType = new RawTypeImpl(enhanceInflexible.getType(), enhanceInflexible2.getType());
                } else {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                    flexibleType = KotlinTypeFactory.flexibleType(enhanceInflexible.getType(), enhanceInflexible2.getType());
                }
                unwrappedType = TypeWithEnhancementKt.wrapEnhancement(flexibleType, buildEnhancementByFlexibleTypeBounds);
            }
            return new Result(unwrappedType, enhanceInflexible.getSubtreeSize(), z);
        } else if (unwrappedType instanceof SimpleType) {
            return enhanceInflexible$default(this, (SimpleType) unwrappedType, lVar, i2, TypeComponentPosition.INFLEXIBLE, false, 8, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameter(simpleType);
    }

    public final KotlinType enhance(KotlinType kotlinType, l<? super Integer, JavaTypeQualifiers> qualifiers) {
        m.g(kotlinType, "<this>");
        m.g(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0).getTypeIfChanged();
    }
}
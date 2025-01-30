package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewKotlinTypeChecker.kt */
/* loaded from: classes3.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        m.f(createWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.overridingUtil = createWithTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType a, KotlinType b2) {
        m.g(a, "a");
        m.g(b2, "b");
        return equalTypes(new ClassicTypeCheckerContext(false, false, false, getKotlinTypeRefiner(), 6, null), a.unwrap(), b2.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType subtype, KotlinType supertype) {
        m.g(subtype, "subtype");
        m.g(supertype, "supertype");
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, false, getKotlinTypeRefiner(), 6, null), subtype.unwrap(), supertype.unwrap());
    }

    public final SimpleType transformToNewType(SimpleType type) {
        int r;
        int r2;
        List g2;
        KotlinType type2;
        int r3;
        m.g(type, "type");
        TypeConstructor constructor = type.getConstructor();
        boolean z = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r6 = null;
        UnwrappedType unwrap = null;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (!(projection.getProjectionKind() == Variance.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type2 = projection.getType()) != null) {
                unwrap = type2.unwrap();
            }
            UnwrappedType unwrappedType = unwrap;
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> mo2215getSupertypes = capturedTypeConstructorImpl.mo2215getSupertypes();
                r3 = s.r(mo2215getSupertypes, 10);
                ArrayList arrayList = new ArrayList(r3);
                for (KotlinType kotlinType : mo2215getSupertypes) {
                    arrayList.add(kotlinType.unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            m.e(newTypeConstructor);
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType, type.getAnnotations(), type.isMarkedNullable(), false, 32, null);
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> mo2215getSupertypes2 = ((IntegerValueTypeConstructor) constructor).mo2215getSupertypes();
            r2 = s.r(mo2215getSupertypes2, 10);
            ArrayList arrayList2 = new ArrayList(r2);
            for (KotlinType kotlinType2 : mo2215getSupertypes2) {
                KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(kotlinType2, type.isMarkedNullable());
                m.f(makeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(makeNullableAsSpecified);
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            Annotations annotations = type.getAnnotations();
            g2 = r.g();
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, intersectionTypeConstructor2, g2, false, type.getMemberScope());
        } else if ((constructor instanceof IntersectionTypeConstructor) && type.isMarkedNullable()) {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> mo2215getSupertypes3 = intersectionTypeConstructor3.mo2215getSupertypes();
            r = s.r(mo2215getSupertypes3, 10);
            ArrayList arrayList3 = new ArrayList(r);
            for (KotlinType kotlinType3 : mo2215getSupertypes3) {
                arrayList3.add(TypeUtilsKt.makeNullable(kotlinType3));
                z = true;
            }
            if (z) {
                KotlinType alternativeType = intersectionTypeConstructor3.getAlternativeType();
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).setAlternative(alternativeType != null ? TypeUtilsKt.makeNullable(alternativeType) : null);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.createType();
        } else {
            return type;
        }
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType a, UnwrappedType b2) {
        m.g(classicTypeCheckerContext, "<this>");
        m.g(a, "a");
        m.g(b2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, a, b2);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType subType, UnwrappedType superType) {
        m.g(classicTypeCheckerContext, "<this>");
        m.g(subType, "subType");
        m.g(superType, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, classicTypeCheckerContext, subType, superType, false, 8, null);
    }

    public UnwrappedType transformToNewType(UnwrappedType type) {
        UnwrappedType flexibleType;
        m.g(type, "type");
        if (type instanceof SimpleType) {
            flexibleType = transformToNewType((SimpleType) type);
        } else if (type instanceof FlexibleType) {
            FlexibleType flexibleType2 = (FlexibleType) type;
            SimpleType transformToNewType = transformToNewType(flexibleType2.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType2.getUpperBound());
            if (transformToNewType == flexibleType2.getLowerBound() && transformToNewType2 == flexibleType2.getUpperBound()) {
                flexibleType = type;
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                flexibleType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, type);
    }
}
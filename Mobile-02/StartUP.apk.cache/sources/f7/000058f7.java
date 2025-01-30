package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            return (AbbreviatedType) unwrap;
        }
        return null;
    }

    public static final SimpleType getAbbreviation(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType == null) {
            return null;
        }
        return abbreviatedType.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType, boolean z) {
        m.g(unwrappedType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(unwrappedType, z);
        if (makeDefinitelyNotNull$descriptors == null) {
            SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
            return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? unwrappedType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
        }
        return makeDefinitelyNotNull$descriptors;
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return makeDefinitelyNotNullOrNotNull.createType();
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType, boolean z) {
        m.g(simpleType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(simpleType, z);
        if (makeDefinitelyNotNull$descriptors == null) {
            SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
            return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? simpleType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
        }
        return makeDefinitelyNotNull$descriptors;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType simpleType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, z);
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType abbreviatedType) {
        m.g(simpleType, "<this>");
        m.g(abbreviatedType, "abbreviatedType");
        return KotlinTypeKt.isError(simpleType) ? simpleType : new AbbreviatedType(simpleType, abbreviatedType);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType newCapturedType) {
        m.g(newCapturedType, "<this>");
        return new NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAnnotations(), newCapturedType.isMarkedNullable(), true);
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor intersectionTypeConstructor) {
        int r;
        KotlinType kotlinType;
        Collection<KotlinType> mo2215getSupertypes = intersectionTypeConstructor.mo2215getSupertypes();
        r = s.r(mo2215getSupertypes, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<T> it = mo2215getSupertypes.iterator();
        boolean z = false;
        while (true) {
            kotlinType = null;
            if (!it.hasNext()) {
                break;
            }
            KotlinType kotlinType2 = (KotlinType) it.next();
            if (TypeUtils.isNullableType(kotlinType2)) {
                kotlinType2 = makeDefinitelyNotNullOrNotNull$default(kotlinType2.unwrap(), false, 1, null);
                z = true;
            }
            arrayList.add(kotlinType2);
        }
        if (z) {
            KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
            if (alternativeType != null) {
                if (TypeUtils.isNullableType(alternativeType)) {
                    alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
                }
                kotlinType = alternativeType;
            }
            return new IntersectionTypeConstructor(arrayList).setAlternative(kotlinType);
        }
        return null;
    }
}
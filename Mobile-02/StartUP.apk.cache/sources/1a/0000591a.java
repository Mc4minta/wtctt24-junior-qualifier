package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;

/* compiled from: TypeWithEnhancement.kt */
/* loaded from: classes3.dex */
public final class TypeWithEnhancementKt {
    public static final KotlinType getEnhancement(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType unwrappedType, KotlinType origin) {
        m.g(unwrappedType, "<this>");
        m.g(origin, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(origin));
    }

    public static final KotlinType unwrapEnhancement(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        KotlinType enhancement = getEnhancement(kotlinType);
        return enhancement == null ? kotlinType : enhancement;
    }

    public static final UnwrappedType wrapEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        m.g(unwrappedType, "<this>");
        if (kotlinType == null) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }
}
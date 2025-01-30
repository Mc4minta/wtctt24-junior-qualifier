package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;

/* compiled from: KotlinType.kt */
/* loaded from: classes3.dex */
public final class KotlinTypeKt {
    public static final boolean isError(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        return (unwrap instanceof ErrorType) || ((unwrap instanceof FlexibleType) && (((FlexibleType) unwrap).getDelegate() instanceof ErrorType));
    }

    public static final boolean isNullable(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return TypeUtils.isNullableType(kotlinType);
    }
}
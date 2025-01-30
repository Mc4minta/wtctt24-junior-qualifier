package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.m;

/* compiled from: dynamicTypes.kt */
/* loaded from: classes3.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof DynamicType;
    }
}
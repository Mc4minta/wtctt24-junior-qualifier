package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.a0.p;
import kotlin.a0.t0;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: typeEnchancementUtils.kt */
/* loaded from: classes3.dex */
public final class TypeEnchancementUtilsKt {
    public static final JavaTypeQualifiers createJavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (z2 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true, z);
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false, z);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker type) {
        m.g(typeSystemCommonBackendContext, "<this>");
        m.g(type, "type");
        FqName ENHANCED_NULLABILITY_ANNOTATION = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        m.f(ENHANCED_NULLABILITY_ANNOTATION, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(type, ENHANCED_NULLABILITY_ANNOTATION);
    }

    public static final <T> T select(Set<? extends T> set, T low, T high, T t, boolean z) {
        Set i2;
        Set<? extends T> M0;
        m.g(set, "<this>");
        m.g(low, "low");
        m.g(high, "high");
        if (z) {
            T t2 = set.contains(low) ? low : set.contains(high) ? high : null;
            if (m.c(t2, low) && m.c(t, high)) {
                return null;
            }
            return t == null ? t2 : t;
        }
        if (t != null) {
            i2 = t0.i(set, t);
            M0 = z.M0(i2);
            if (M0 != null) {
                set = M0;
            }
        }
        return (T) p.y0(set);
    }

    public static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        m.g(set, "<this>");
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
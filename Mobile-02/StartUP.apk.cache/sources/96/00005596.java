package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import java.util.Objects;
import kotlin.a0.p;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: classes3.dex */
public final class JavaTypeResolverKt {
    private static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName("java.lang.Class");

    public static final /* synthetic */ FqName access$getJAVA_LANG_CLASS_FQ_NAME$p$s1946801611() {
        return JAVA_LANG_CLASS_FQ_NAME;
    }

    public static final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, a<? extends KotlinType> defaultValue) {
        m.g(typeParameterDescriptor, "<this>");
        m.g(defaultValue, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return defaultValue.invoke();
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        m.f(upperBounds, "upperBounds");
        KotlinType firstUpperBound = (KotlinType) p.Y(upperBounds);
        if (firstUpperBound.getConstructor().mo2214getDeclarationDescriptor() instanceof ClassDescriptor) {
            m.f(firstUpperBound, "firstUpperBound");
            return TypeUtilsKt.replaceArgumentsWithStarProjections(firstUpperBound);
        }
        if (typeParameterDescriptor2 != null) {
            typeParameterDescriptor = typeParameterDescriptor2;
        }
        ClassifierDescriptor mo2214getDeclarationDescriptor = firstUpperBound.getConstructor().mo2214getDeclarationDescriptor();
        Objects.requireNonNull(mo2214getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) mo2214getDeclarationDescriptor;
            if (!m.c(typeParameterDescriptor3, typeParameterDescriptor)) {
                List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
                m.f(upperBounds2, "current.upperBounds");
                KotlinType nextUpperBound = (KotlinType) p.Y(upperBounds2);
                if (nextUpperBound.getConstructor().mo2214getDeclarationDescriptor() instanceof ClassDescriptor) {
                    m.f(nextUpperBound, "nextUpperBound");
                    return TypeUtilsKt.replaceArgumentsWithStarProjections(nextUpperBound);
                }
                mo2214getDeclarationDescriptor = nextUpperBound.getConstructor().mo2214getDeclarationDescriptor();
                Objects.requireNonNull(mo2214getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            } else {
                return defaultValue.invoke();
            }
        }
    }

    public static /* synthetic */ KotlinType getErasedUpperBound$default(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            typeParameterDescriptor2 = null;
        }
        if ((i2 & 2) != 0) {
            aVar = new JavaTypeResolverKt$getErasedUpperBound$1(typeParameterDescriptor);
        }
        return getErasedUpperBound(typeParameterDescriptor, typeParameterDescriptor2, aVar);
    }

    public static final TypeProjection makeStarProjection(TypeParameterDescriptor typeParameter, JavaTypeAttributes attr) {
        m.g(typeParameter, "typeParameter");
        m.g(attr, "attr");
        if (attr.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameter));
        }
        return new StarProjectionImpl(typeParameter);
    }

    public static final JavaTypeAttributes toAttributes(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        m.g(typeUsage, "<this>");
        return new JavaTypeAttributes(typeUsage, null, z, typeParameterDescriptor, 2, null);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z, typeParameterDescriptor);
    }
}
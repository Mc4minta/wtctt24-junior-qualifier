package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: TypeUtils.kt */
/* loaded from: classes3.dex */
public final class TypeUtilsKt {
    public static final TypeProjection asTypeProjection(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(KotlinType kotlinType, l<? super UnwrappedType, Boolean> predicate) {
        m.g(kotlinType, "<this>");
        m.g(predicate, "predicate");
        return TypeUtils.contains(kotlinType, predicate);
    }

    public static final boolean containsTypeAliasParameters(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE);
    }

    public static final TypeProjection createProjection(KotlinType type, Variance projectionKind, TypeParameterDescriptor typeParameterDescriptor) {
        m.g(type, "type");
        m.g(projectionKind, "projectionKind");
        if ((typeParameterDescriptor == null ? null : typeParameterDescriptor.getVariance()) == projectionKind) {
            projectionKind = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(projectionKind, type);
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        m.f(builtIns, "constructor.builtIns");
        return builtIns;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
        r3 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[EDGE_INSN: B:22:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.m.g(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            kotlin.jvm.internal.m.f(r0, r1)
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            kotlin.jvm.internal.m.f(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L51
            java.lang.Object r2 = r0.next()
            r4 = r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.mo2214getDeclarationDescriptor()
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L39
            r3 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
        L39:
            r4 = 0
            if (r3 != 0) goto L3d
            goto L4e
        L3d:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r5 == r6) goto L4e
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 == r5) goto L4e
            r4 = 1
        L4e:
            if (r4 == 0) goto L1c
            r3 = r2
        L51:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            if (r3 != 0) goto L68
            java.util.List r7 = r7.getUpperBounds()
            kotlin.jvm.internal.m.f(r7, r1)
            java.lang.Object r7 = kotlin.a0.p.Y(r7)
            java.lang.String r0 = "upperBounds.first()"
            kotlin.jvm.internal.m.f(r7, r0)
            r3 = r7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public static final boolean isSubtypeOf(KotlinType kotlinType, KotlinType superType) {
        m.g(kotlinType, "<this>");
        m.g(superType, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, superType);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor classifierDescriptor) {
        m.g(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean isTypeParameter(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final KotlinType makeNotNullable(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        m.f(makeNotNullable, "makeNotNullable(this)");
        return makeNotNullable;
    }

    public static final KotlinType makeNullable(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        KotlinType makeNullable = TypeUtils.makeNullable(kotlinType);
        m.f(makeNullable, "makeNullable(this)");
        return makeNullable;
    }

    public static final KotlinType replaceAnnotations(KotlinType kotlinType, Annotations newAnnotations) {
        m.g(kotlinType, "<this>");
        m.g(newAnnotations, "newAnnotations");
        return (kotlinType.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? kotlinType : kotlinType.unwrap().replaceAnnotations(newAnnotations);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType kotlinType) {
        int r;
        SimpleType simpleType;
        int r2;
        int r3;
        m.g(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo2214getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                m.f(parameters, "constructor.parameters");
                r3 = s.r(parameters, 10);
                ArrayList arrayList = new ArrayList(r3);
                for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                    arrayList.add(new StarProjectionImpl(typeParameterDescriptor));
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, arrayList, null, 2, null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo2214getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                m.f(parameters2, "constructor.parameters");
                r2 = s.r(parameters2, 10);
                ArrayList arrayList2 = new ArrayList(r2);
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    arrayList2.add(new StarProjectionImpl(typeParameterDescriptor2));
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, arrayList2, null, 2, null);
            }
            simpleType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType2 = (SimpleType) unwrap;
            boolean isEmpty = simpleType2.getConstructor().getParameters().isEmpty();
            simpleType = simpleType2;
            if (!isEmpty) {
                ClassifierDescriptor mo2214getDeclarationDescriptor = simpleType2.getConstructor().mo2214getDeclarationDescriptor();
                simpleType = simpleType2;
                if (mo2214getDeclarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType2.getConstructor().getParameters();
                    m.f(parameters3, "constructor.parameters");
                    r = s.r(parameters3, 10);
                    ArrayList arrayList3 = new ArrayList(r);
                    for (TypeParameterDescriptor typeParameterDescriptor3 : parameters3) {
                        arrayList3.add(new StarProjectionImpl(typeParameterDescriptor3));
                    }
                    simpleType = TypeSubstitutionKt.replace$default(simpleType2, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrap);
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE);
    }

    public static final boolean shouldBeSubstituted(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$shouldBeSubstituted$1.INSTANCE);
    }
}
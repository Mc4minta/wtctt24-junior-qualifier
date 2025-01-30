package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    /* compiled from: TypeSystemContext.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext typeSystemContext, SimpleTypeMarker receiver, TypeConstructorMarker constructor) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            m.g(constructor, "constructor");
            return null;
        }

        public static TypeArgumentMarker get(TypeSystemContext typeSystemContext, TypeArgumentListMarker receiver, int i2) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.getArgument((KotlinTypeMarker) receiver, i2);
            }
            if (receiver instanceof ArgumentList) {
                TypeArgumentMarker typeArgumentMarker = ((ArgumentList) receiver).get(i2);
                m.f(typeArgumentMarker, "get(index)");
                return typeArgumentMarker;
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + e0.b(receiver.getClass())).toString());
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemContext typeSystemContext, SimpleTypeMarker receiver, int i2) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            boolean z = false;
            if (i2 >= 0 && i2 < typeSystemContext.argumentsCount(receiver)) {
                z = true;
            }
            if (z) {
                return typeSystemContext.getArgument(receiver, i2);
            }
            return null;
        }

        public static boolean hasFlexibleNullability(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            return typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(receiver)) != typeSystemContext.isMarkedNullable(typeSystemContext.upperBoundIfFlexible(receiver));
        }

        public static boolean identicalArguments(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            return TypeSystemOptimizationContext.DefaultImpls.identicalArguments(typeSystemContext, simpleTypeMarker, simpleTypeMarker2);
        }

        public static boolean isClassType(TypeSystemContext typeSystemContext, SimpleTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            return typeSystemContext.isClassTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isDefinitelyNotNullType(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
            return (asSimpleType == null ? null : typeSystemContext.asDefinitelyNotNullType(asSimpleType)) != null;
        }

        public static boolean isDynamic(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            return (asFlexibleType == null ? null : typeSystemContext.asDynamicType(asFlexibleType)) != null;
        }

        public static boolean isIntegerLiteralType(TypeSystemContext typeSystemContext, SimpleTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            return typeSystemContext.isIntegerLiteralTypeConstructor(typeSystemContext.typeConstructor(receiver));
        }

        public static boolean isMarkedNullable(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            return (receiver instanceof SimpleTypeMarker) && typeSystemContext.isMarkedNullable((SimpleTypeMarker) receiver);
        }

        public static boolean isNothing(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            return typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(receiver)) && !typeSystemContext.isNullableType(receiver);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (asFlexibleType == null) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
                m.e(asSimpleType);
                return asSimpleType;
            }
            return typeSystemContext.lowerBound(asFlexibleType);
        }

        public static int size(TypeSystemContext typeSystemContext, TypeArgumentListMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return typeSystemContext.argumentsCount((KotlinTypeMarker) receiver);
            }
            if (receiver instanceof ArgumentList) {
                return ((ArgumentList) receiver).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + receiver + ", " + e0.b(receiver.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
            if (asSimpleType == null) {
                asSimpleType = typeSystemContext.lowerBoundIfFlexible(receiver);
            }
            return typeSystemContext.typeConstructor(asSimpleType);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemContext typeSystemContext, KotlinTypeMarker receiver) {
            m.g(typeSystemContext, "this");
            m.g(receiver, "receiver");
            FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(receiver);
            if (asFlexibleType == null) {
                SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(receiver);
                m.e(asSimpleType);
                return asSimpleType;
            }
            return typeSystemContext.upperBound(asFlexibleType);
        }
    }

    boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2);

    int argumentsCount(KotlinTypeMarker kotlinTypeMarker);

    TypeArgumentListMarker asArgumentList(SimpleTypeMarker simpleTypeMarker);

    CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker);

    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker simpleTypeMarker);

    DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker);

    FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker);

    SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker);

    TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker);

    SimpleTypeMarker captureFromArguments(SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus);

    TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i2);

    TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i2);

    TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i2);

    KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker);

    TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker);

    TypeVariance getVariance(TypeParameterMarker typeParameterMarker);

    KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> list);

    boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker);

    boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker);

    boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker);

    boolean isDenotable(TypeConstructorMarker typeConstructorMarker);

    boolean isError(KotlinTypeMarker kotlinTypeMarker);

    boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker);

    boolean isIntersection(TypeConstructorMarker typeConstructorMarker);

    boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker);

    boolean isMarkedNullable(SimpleTypeMarker simpleTypeMarker);

    boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker);

    boolean isNullableType(KotlinTypeMarker kotlinTypeMarker);

    boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker);

    boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker);

    boolean isSingleClassifierType(SimpleTypeMarker simpleTypeMarker);

    boolean isStarProjection(TypeArgumentMarker typeArgumentMarker);

    boolean isStubType(SimpleTypeMarker simpleTypeMarker);

    SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker);

    SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker);

    KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker);

    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker kotlinTypeMarker);

    SimpleTypeMarker original(DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker);

    int parametersCount(TypeConstructorMarker typeConstructorMarker);

    Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker simpleTypeMarker);

    int size(TypeArgumentListMarker typeArgumentListMarker);

    Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker);

    TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker);

    TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker);

    SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker);

    SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker);

    KotlinTypeMarker withNullability(KotlinTypeMarker kotlinTypeMarker, boolean z);

    SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z);
}
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.w;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: classes3.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* compiled from: AbstractTypeChecker.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.valuesCustom().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.valuesCustom().length];
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private AbstractTypeChecker() {
    }

    private final Boolean checkSubtypeForIntegerLiteralType(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) || abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
            if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) && abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
                return Boolean.TRUE;
            }
            if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker)) {
                if (checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(abstractTypeCheckerContext, this, simpleTypeMarker, simpleTypeMarker2, false)) {
                    return Boolean.TRUE;
                }
            } else if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2) && (checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(abstractTypeCheckerContext, simpleTypeMarker) || checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(abstractTypeCheckerContext, this, simpleTypeMarker2, simpleTypeMarker, true))) {
                return Boolean.TRUE;
            }
            return null;
        }
        return null;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isIntegerLiteralTypeInIntersectionComponents(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (typeConstructor instanceof IntersectionTypeConstructorMarker) {
            Collection<KotlinTypeMarker> supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
            if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                for (KotlinTypeMarker kotlinTypeMarker : supertypes) {
                    SimpleTypeMarker asSimpleType = abstractTypeCheckerContext.asSimpleType(kotlinTypeMarker);
                    if (m.c(asSimpleType == null ? null : Boolean.valueOf(abstractTypeCheckerContext.isIntegerLiteralType(asSimpleType)), Boolean.TRUE)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean checkSubtypeForIntegerLiteralType$isTypeInIntegerLiteralType(AbstractTypeCheckerContext abstractTypeCheckerContext, AbstractTypeChecker abstractTypeChecker, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Collection<KotlinTypeMarker> possibleIntegerTypes = abstractTypeCheckerContext.possibleIntegerTypes(simpleTypeMarker);
        if (!(possibleIntegerTypes instanceof Collection) || !possibleIntegerTypes.isEmpty()) {
            for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
                if (m.c(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker), abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2)) || (z && isSubtypeOf$default(abstractTypeChecker, abstractTypeCheckerContext, simpleTypeMarker2, kotlinTypeMarker, false, 8, null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Boolean checkSubtypeForSpecialCases(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z = false;
        if (abstractTypeCheckerContext.isError(simpleTypeMarker) || abstractTypeCheckerContext.isError(simpleTypeMarker2)) {
            return abstractTypeCheckerContext.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker) || abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) ? Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(abstractTypeCheckerContext, abstractTypeCheckerContext.withNullability(simpleTypeMarker, false), abstractTypeCheckerContext.withNullability(simpleTypeMarker2, false))) : Boolean.FALSE;
        } else if (!abstractTypeCheckerContext.isStubType(simpleTypeMarker) && !abstractTypeCheckerContext.isStubType(simpleTypeMarker2)) {
            DefinitelyNotNullTypeMarker asDefinitelyNotNullType = abstractTypeCheckerContext.asDefinitelyNotNullType(simpleTypeMarker2);
            CapturedTypeMarker asCapturedType = abstractTypeCheckerContext.asCapturedType(asDefinitelyNotNullType == null ? simpleTypeMarker2 : abstractTypeCheckerContext.original(asDefinitelyNotNullType));
            KotlinTypeMarker lowerType = asCapturedType == null ? null : abstractTypeCheckerContext.lowerType(asCapturedType);
            if (asCapturedType != null && lowerType != null) {
                if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) {
                    lowerType = abstractTypeCheckerContext.withNullability(lowerType, true);
                } else if (abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
                    lowerType = abstractTypeCheckerContext.makeDefinitelyNotNullOrNotNull(lowerType);
                }
                KotlinTypeMarker kotlinTypeMarker = lowerType;
                int i2 = WhenMappings.$EnumSwitchMapping$1[abstractTypeCheckerContext.getLowerCapturedTypePolicy(simpleTypeMarker, asCapturedType).ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && isSubtypeOf$default(this, abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker, false, 8, null)) {
                        return Boolean.TRUE;
                    }
                } else {
                    return Boolean.valueOf(isSubtypeOf$default(this, abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker, false, 8, null));
                }
            }
            TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
            if (abstractTypeCheckerContext.isIntersection(typeConstructor)) {
                abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2);
                Collection<KotlinTypeMarker> supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
                if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                    for (KotlinTypeMarker kotlinTypeMarker2 : supertypes) {
                        if (!isSubtypeOf$default(this, abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker2, false, 8, null)) {
                            break;
                        }
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            }
            return null;
        } else {
            return Boolean.valueOf(abstractTypeCheckerContext.isStubTypeEqualsToAnything());
        }
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        String h0;
        AbstractTypeCheckerContext.SupertypesPolicy substitutionSupertypePolicy;
        List<SimpleTypeMarker> g2;
        List<SimpleTypeMarker> b2;
        List<SimpleTypeMarker> g3;
        List<SimpleTypeMarker> fastCorrespondingSupertypes = abstractTypeCheckerContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes == null) {
            if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
                g3 = r.g();
                return g3;
            } else if (abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
                if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                    SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments != null) {
                        simpleTypeMarker = captureFromArguments;
                    }
                    b2 = q.b(simpleTypeMarker);
                    return b2;
                }
                g2 = r.g();
                return g2;
            } else {
                fastCorrespondingSupertypes = new SmartList<>();
                abstractTypeCheckerContext.initialize();
                ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
                m.e(supertypesDeque);
                Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
                m.e(supertypesSet);
                supertypesDeque.push(simpleTypeMarker);
                while (!supertypesDeque.isEmpty()) {
                    if (supertypesSet.size() <= 1000) {
                        SimpleTypeMarker current = supertypesDeque.pop();
                        m.f(current, "current");
                        if (supertypesSet.add(current)) {
                            SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(current, CaptureStatus.FOR_SUBTYPING);
                            if (captureFromArguments2 == null) {
                                captureFromArguments2 = current;
                            }
                            if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                                fastCorrespondingSupertypes.add(captureFromArguments2);
                                substitutionSupertypePolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                            } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments2) == 0) {
                                substitutionSupertypePolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                            } else {
                                substitutionSupertypePolicy = abstractTypeCheckerContext.substitutionSupertypePolicy(captureFromArguments2);
                            }
                            if (!(!m.c(substitutionSupertypePolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                                substitutionSupertypePolicy = null;
                            }
                            if (substitutionSupertypePolicy != null) {
                                for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                                    supertypesDeque.add(substitutionSupertypePolicy.mo2218transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                                }
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Too many supertypes for type: ");
                        sb.append(simpleTypeMarker);
                        sb.append(". Supertypes = ");
                        h0 = z.h0(supertypesSet, null, null, null, 0, null, null, 63, null);
                        sb.append(h0);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                }
                abstractTypeCheckerContext.clear();
            }
        }
        return fastCorrespondingSupertypes;
    }

    private final List<SimpleTypeMarker> collectAndFilter(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(abstractTypeCheckerContext, collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        Boolean checkSubtypeForSpecialCases = checkSubtypeForSpecialCases(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (checkSubtypeForSpecialCases == null) {
            Boolean addSubtypeConstraint = abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z);
            if (addSubtypeConstraint == null) {
                return isSubtypeOfForSingleClassifierType(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
            }
            return addSubtypeConstraint.booleanValue();
        }
        boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
        abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z);
        return booleanValue;
    }

    private final boolean hasNothingSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        String h0;
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (abstractTypeCheckerContext.isClassTypeConstructor(typeConstructor)) {
            return abstractTypeCheckerContext.isNothingConstructor(typeConstructor);
        }
        if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        m.e(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        m.e(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                m.f(current, "current");
                if (supertypesSet.add(current)) {
                    if (abstractTypeCheckerContext.isClassType(current)) {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!m.c(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            SimpleTypeMarker mo2218transformType = supertypesPolicy.mo2218transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(mo2218transformType))) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(mo2218transformType);
                        }
                        continue;
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(simpleTypeMarker);
                sb.append(". Supertypes = ");
                h0 = z.h0(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb.append(h0);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    private final boolean isCommonDenotableType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        return abstractTypeCheckerContext.isDenotable(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker)) && !abstractTypeCheckerContext.isDynamic(kotlinTypeMarker) && !abstractTypeCheckerContext.isDefinitelyNotNullType(kotlinTypeMarker) && m.c(abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker)), abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x00cf, code lost:
        if ((r19.getVariance(r5) == kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV) != false) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isSubtypeOfForSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r19, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r20, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r21) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOfForSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) next);
            int size = abstractTypeCheckerContext.size(asArgumentList);
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                if (!(abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(abstractTypeCheckerContext.get(asArgumentList, i2))) == null)) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final TypeVariance effectiveVariance(TypeVariance declared, TypeVariance useSite) {
        m.g(declared, "declared");
        m.g(useSite, "useSite");
        TypeVariance typeVariance = TypeVariance.INV;
        if (declared == typeVariance) {
            return useSite;
        }
        if (useSite == typeVariance || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean equalTypes(AbstractTypeCheckerContext context, KotlinTypeMarker a, KotlinTypeMarker b2) {
        m.g(context, "context");
        m.g(a, "a");
        m.g(b2, "b");
        if (a == b2) {
            return true;
        }
        if (isCommonDenotableType(context, a) && isCommonDenotableType(context, b2)) {
            KotlinTypeMarker refineType = context.refineType(a);
            KotlinTypeMarker refineType2 = context.refineType(b2);
            SimpleTypeMarker lowerBoundIfFlexible = context.lowerBoundIfFlexible(refineType);
            if (!context.areEqualTypeConstructors(context.typeConstructor(refineType), context.typeConstructor(refineType2))) {
                return false;
            }
            if (context.argumentsCount(lowerBoundIfFlexible) == 0) {
                return context.hasFlexibleNullability(refineType) || context.hasFlexibleNullability(refineType2) || context.isMarkedNullable(lowerBoundIfFlexible) == context.isMarkedNullable(context.lowerBoundIfFlexible(refineType2));
            }
        }
        return isSubtypeOf$default(this, context, a, b2, false, 8, null) && isSubtypeOf$default(this, context, b2, a, false, 8, null);
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker subType, TypeConstructorMarker superConstructor) {
        String h0;
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        m.g(abstractTypeCheckerContext, "<this>");
        m.g(subType, "subType");
        m.g(superConstructor, "superConstructor");
        if (abstractTypeCheckerContext.isClassType(subType)) {
            return collectAndFilter(abstractTypeCheckerContext, subType, superConstructor);
        }
        if (!abstractTypeCheckerContext.isClassTypeConstructor(superConstructor) && !abstractTypeCheckerContext.isIntegerLiteralTypeConstructor(superConstructor)) {
            return collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, subType, superConstructor);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList();
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        m.e(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        m.e(supertypesSet);
        supertypesDeque.push(subType);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                m.f(current, "current");
                if (supertypesSet.add(current)) {
                    if (abstractTypeCheckerContext.isClassType(current)) {
                        smartList.add(current);
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!m.c(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            supertypesDeque.add(supertypesPolicy.mo2218transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(subType);
                sb.append(". Supertypes = ");
                h0 = z.h0(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb.append(h0);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        abstractTypeCheckerContext.clear();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker it : smartList) {
            m.f(it, "it");
            w.y(arrayList, collectAndFilter(abstractTypeCheckerContext, it, superConstructor));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, TypeArgumentListMarker capturedSubArguments, SimpleTypeMarker superType) {
        int i2;
        int i3;
        boolean equalTypes;
        int i4;
        m.g(abstractTypeCheckerContext, "<this>");
        m.g(capturedSubArguments, "capturedSubArguments");
        m.g(superType, "superType");
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(superType);
        int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
        if (parametersCount > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                TypeArgumentMarker argument = abstractTypeCheckerContext.getArgument(superType, i5);
                if (!abstractTypeCheckerContext.isStarProjection(argument)) {
                    KotlinTypeMarker type = abstractTypeCheckerContext.getType(argument);
                    TypeArgumentMarker typeArgumentMarker = abstractTypeCheckerContext.get(capturedSubArguments, i5);
                    abstractTypeCheckerContext.getVariance(typeArgumentMarker);
                    TypeVariance typeVariance = TypeVariance.INV;
                    KotlinTypeMarker type2 = abstractTypeCheckerContext.getType(typeArgumentMarker);
                    TypeVariance effectiveVariance = effectiveVariance(abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i5)), abstractTypeCheckerContext.getVariance(argument));
                    if (effectiveVariance != null) {
                        i2 = abstractTypeCheckerContext.argumentsDepth;
                        if (i2 <= 100) {
                            i3 = abstractTypeCheckerContext.argumentsDepth;
                            abstractTypeCheckerContext.argumentsDepth = i3 + 1;
                            int i7 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                            if (i7 == 1) {
                                equalTypes = equalTypes(abstractTypeCheckerContext, type2, type);
                            } else if (i7 == 2) {
                                equalTypes = isSubtypeOf$default(this, abstractTypeCheckerContext, type2, type, false, 8, null);
                            } else if (i7 != 3) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                equalTypes = isSubtypeOf$default(this, abstractTypeCheckerContext, type, type2, false, 8, null);
                            }
                            i4 = abstractTypeCheckerContext.argumentsDepth;
                            abstractTypeCheckerContext.argumentsDepth = i4 - 1;
                            if (!equalTypes) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException(m.o("Arguments depth is too high. Some related argument: ", type2).toString());
                        }
                    } else {
                        return abstractTypeCheckerContext.isErrorTypeEqualsToAnything();
                    }
                }
                if (i6 >= parametersCount) {
                    break;
                }
                i5 = i6;
            }
        }
        return true;
    }

    public final boolean isSubtypeOf(AbstractTypeCheckerContext context, KotlinTypeMarker subType, KotlinTypeMarker superType, boolean z) {
        m.g(context, "context");
        m.g(subType, "subType");
        m.g(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (context.customIsSubtypeOf(subType, superType)) {
            return completeIsSubTypeOf(context, context.prepareType(context.refineType(subType)), context.prepareType(context.refineType(superType)), z);
        }
        return false;
    }
}
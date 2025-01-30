package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* compiled from: AbstractTypeChecker.kt */
/* loaded from: classes3.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    private final boolean isApplicableAsEndNode(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        if (abstractTypeCheckerContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (abstractTypeCheckerContext.isStubTypeEqualsToAnything() && abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return true;
        }
        return abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
    }

    private final boolean runIsPossibleSubtype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2)) {
                abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker)) {
            return true;
        }
        if (((simpleTypeMarker instanceof CapturedTypeMarker) && abstractTypeCheckerContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker2) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE) || abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(abstractTypeCheckerContext, simpleTypeMarker, abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2));
    }

    public final boolean hasNotNullSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker type, AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy) {
        String h0;
        m.g(abstractTypeCheckerContext, "<this>");
        m.g(type, "type");
        m.g(supertypesPolicy, "supertypesPolicy");
        if (!((abstractTypeCheckerContext.isClassType(type) && !abstractTypeCheckerContext.isMarkedNullable(type)) || abstractTypeCheckerContext.isDefinitelyNotNullType(type))) {
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
            m.e(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
            m.e(supertypesSet);
            supertypesDeque.push(type);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker current = supertypesDeque.pop();
                    m.f(current, "current");
                    if (supertypesSet.add(current)) {
                        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy2 = abstractTypeCheckerContext.isMarkedNullable(current) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                        if (!(!m.c(supertypesPolicy2, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy2 = null;
                        }
                        if (supertypesPolicy2 == null) {
                            continue;
                        } else {
                            for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                                SimpleTypeMarker mo2218transformType = supertypesPolicy2.mo2218transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((abstractTypeCheckerContext.isClassType(mo2218transformType) && !abstractTypeCheckerContext.isMarkedNullable(mo2218transformType)) || abstractTypeCheckerContext.isDefinitelyNotNullType(mo2218transformType)) {
                                    abstractTypeCheckerContext.clear();
                                } else {
                                    supertypesDeque.add(mo2218transformType);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many supertypes for type: ");
                    sb.append(type);
                    sb.append(". Supertypes = ");
                    h0 = z.h0(supertypesSet, null, null, null, 0, null, null, 63, null);
                    sb.append(h0);
                    throw new IllegalStateException(sb.toString().toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker start, TypeConstructorMarker end) {
        String h0;
        m.g(abstractTypeCheckerContext, "<this>");
        m.g(start, "start");
        m.g(end, "end");
        if (isApplicableAsEndNode(abstractTypeCheckerContext, start, end)) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        m.e(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        m.e(supertypesSet);
        supertypesDeque.push(start);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                m.f(current, "current");
                if (supertypesSet.add(current)) {
                    AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy = abstractTypeCheckerContext.isMarkedNullable(current) ? AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE : AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    if (!(!m.c(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            SimpleTypeMarker mo2218transformType = supertypesPolicy.mo2218transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (isApplicableAsEndNode(abstractTypeCheckerContext, mo2218transformType, end)) {
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
                sb.append(start);
                sb.append(". Supertypes = ");
                h0 = z.h0(supertypesSet, null, null, null, 0, null, null, 63, null);
                sb.append(h0);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    public final boolean isPossibleSubtype(AbstractTypeCheckerContext context, SimpleTypeMarker subType, SimpleTypeMarker superType) {
        m.g(context, "context");
        m.g(subType, "subType");
        m.g(superType, "superType");
        return runIsPossibleSubtype(context, subType, superType);
    }
}
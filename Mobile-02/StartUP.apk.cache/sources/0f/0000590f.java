package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public final class TypeSubstitutionKt {
    public static final SimpleType asSimpleType(KotlinType kotlinType) {
        m.g(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        SimpleType simpleType = unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(m.o("This is should be simple type: ", kotlinType).toString());
    }

    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> newArguments, Annotations newAnnotations) {
        m.g(kotlinType, "<this>");
        m.g(newArguments, "newArguments");
        m.g(newAnnotations, "newAnnotations");
        return replace$default(kotlinType, newArguments, newAnnotations, null, 4, null);
    }

    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> newArguments, Annotations newAnnotations, List<? extends TypeProjection> newArgumentsForUpperBound) {
        m.g(kotlinType, "<this>");
        m.g(newArguments, "newArguments");
        m.g(newAnnotations, "newAnnotations");
        m.g(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == kotlinType.getArguments()) && newAnnotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return KotlinTypeFactory.flexibleType(replace(flexibleType.getLowerBound(), newArguments, newAnnotations), replace(flexibleType.getUpperBound(), newArgumentsForUpperBound, newAnnotations));
        } else if (unwrap instanceof SimpleType) {
            return replace((SimpleType) unwrap, newArguments, newAnnotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations annotations, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i2 & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i2 & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List list, Annotations annotations, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i2 & 2) != 0) {
            annotations = simpleType.getAnnotations();
        }
        return replace(simpleType, (List<? extends TypeProjection>) list, annotations);
    }

    public static final SimpleType replace(SimpleType simpleType, List<? extends TypeProjection> newArguments, Annotations newAnnotations) {
        m.g(simpleType, "<this>");
        m.g(newArguments, "newArguments");
        m.g(newAnnotations, "newAnnotations");
        if (newArguments.isEmpty() && newAnnotations == simpleType.getAnnotations()) {
            return simpleType;
        }
        if (newArguments.isEmpty()) {
            return simpleType.replaceAnnotations(newAnnotations);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        return KotlinTypeFactory.simpleType$default(newAnnotations, simpleType.getConstructor(), newArguments, simpleType.isMarkedNullable(), null, 16, null);
    }
}
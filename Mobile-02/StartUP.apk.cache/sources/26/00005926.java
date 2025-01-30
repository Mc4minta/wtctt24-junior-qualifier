package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> types) {
        int r;
        int r2;
        SimpleType lowerBound;
        m.g(types, "types");
        int size = types.size();
        if (size != 0) {
            if (size != 1) {
                r = s.r(types, 10);
                ArrayList arrayList = new ArrayList(r);
                boolean z = false;
                boolean z2 = false;
                for (UnwrappedType unwrappedType : types) {
                    z = z || KotlinTypeKt.isError(unwrappedType);
                    if (unwrappedType instanceof SimpleType) {
                        lowerBound = (SimpleType) unwrappedType;
                    } else if (unwrappedType instanceof FlexibleType) {
                        if (DynamicTypesKt.isDynamic(unwrappedType)) {
                            return unwrappedType;
                        }
                        lowerBound = ((FlexibleType) unwrappedType).getLowerBound();
                        z2 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(lowerBound);
                }
                if (z) {
                    SimpleType createErrorType = ErrorUtils.createErrorType(m.o("Intersection of error types: ", types));
                    m.f(createErrorType, "createErrorType(\"Intersection of error types: $types\")");
                    return createErrorType;
                } else if (!z2) {
                    return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
                } else {
                    r2 = s.r(types, 10);
                    ArrayList arrayList2 = new ArrayList(r2);
                    for (UnwrappedType unwrappedType2 : types) {
                        arrayList2.add(FlexibleTypesKt.upperIfFlexible(unwrappedType2));
                    }
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                    TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                    return KotlinTypeFactory.flexibleType(typeIntersector.intersectTypes$descriptors(arrayList), typeIntersector.intersectTypes$descriptors(arrayList2));
                }
            }
            return (UnwrappedType) p.x0(types);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
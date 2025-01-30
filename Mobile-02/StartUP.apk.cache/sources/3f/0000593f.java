package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.p;
import kotlin.a0.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    /* loaded from: classes3.dex */
    private static final class ResultNullability {
        private static final /* synthetic */ ResultNullability[] $VALUES;
        public static final ResultNullability ACCEPT_NULL;
        public static final ResultNullability NOT_NULL;
        public static final ResultNullability START;
        public static final ResultNullability UNKNOWN;

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                m.g(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class NOT_NULL extends ResultNullability {
            NOT_NULL(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType nextType) {
                m.g(nextType, "nextType");
                return this;
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class START extends ResultNullability {
            START(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                m.g(nextType, "nextType");
                return getResultNullability(nextType);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType nextType) {
                m.g(nextType, "nextType");
                ResultNullability resultNullability = getResultNullability(nextType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        static {
            START start = new START("START", 0);
            START = start;
            ACCEPT_NULL accept_null = new ACCEPT_NULL("ACCEPT_NULL", 1);
            ACCEPT_NULL = accept_null;
            UNKNOWN unknown = new UNKNOWN("UNKNOWN", 2);
            UNKNOWN = unknown;
            NOT_NULL not_null = new NOT_NULL("NOT_NULL", 3);
            NOT_NULL = not_null;
            $VALUES = new ResultNullability[]{start, accept_null, unknown, not_null};
        }

        private ResultNullability(String str, int i2) {
        }

        public /* synthetic */ ResultNullability(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i2);
        }

        public static ResultNullability valueOf(String value) {
            m.g(value, "value");
            return (ResultNullability) Enum.valueOf(ResultNullability.class, value);
        }

        public static ResultNullability[] values() {
            ResultNullability[] resultNullabilityArr = $VALUES;
            ResultNullability[] resultNullabilityArr2 = new ResultNullability[resultNullabilityArr.length];
            System.arraycopy(resultNullabilityArr, 0, resultNullabilityArr2, 0, resultNullabilityArr.length);
            return resultNullabilityArr2;
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        protected final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            m.g(unwrappedType, "<this>");
            return unwrappedType.isMarkedNullable() ? ACCEPT_NULL : NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType) ? NOT_NULL : UNKNOWN;
        }
    }

    private TypeIntersector() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[EDGE_INSN: B:27:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.e0.c.p<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.m.f(r8, r1)
        Le:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L57
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r1
            boolean r2 = r0.isEmpty()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L24
        L22:
            r3 = r4
            goto L51
        L24:
            java.util.Iterator r2 = r0.iterator()
        L28:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L22
            java.lang.Object r5 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r5
            if (r5 == r1) goto L4e
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.m.f(r5, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.m.f(r1, r6)
            java.lang.Object r5 = r9.invoke(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4e
            r5 = r3
            goto L4f
        L4e:
            r5 = r4
        L4f:
            if (r5 == 0) goto L28
        L51:
            if (r3 == 0) goto Le
            r8.remove()
            goto Le
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.filterTypes(java.util.Collection, kotlin.e0.c.p):java.util.Collection");
    }

    private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) p.w0(set);
        }
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection<SimpleType> filterTypes = filterTypes(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        filterTypes.isEmpty();
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
        if (findIntersectionType == null) {
            Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
            filterTypes2.isEmpty();
            return filterTypes2.size() < 2 ? (SimpleType) p.w0(filterTypes2) : new IntersectionTypeConstructor(set).createType();
        }
        return findIntersectionType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> types) {
        int r;
        m.g(types, "types");
        types.size();
        ArrayList<UnwrappedType> arrayList = new ArrayList();
        for (SimpleType simpleType : types) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> mo2215getSupertypes = simpleType.getConstructor().mo2215getSupertypes();
                m.f(mo2215getSupertypes, "type.constructor.supertypes");
                r = s.r(mo2215getSupertypes, 10);
                ArrayList arrayList2 = new ArrayList(r);
                for (KotlinType it : mo2215getSupertypes) {
                    m.f(it, "it");
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(it);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (UnwrappedType unwrappedType : arrayList) {
            resultNullability = resultNullability.combine(unwrappedType);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SimpleType simpleType2 = (SimpleType) it2.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (simpleType2 instanceof NewCapturedType) {
                    simpleType2 = SpecialTypesKt.withNotNullProjection((NewCapturedType) simpleType2);
                }
                simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(simpleType2, false, 1, null);
            }
            linkedHashSet.add(simpleType2);
        }
        return intersectTypesWithoutIntersectionType(linkedHashSet);
    }
}
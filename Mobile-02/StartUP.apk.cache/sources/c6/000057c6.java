package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = new Companion(null);
    private final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final h supertypes$delegate;
    private final SimpleType type;
    private final long value;

    /* JADX WARN: Multi-variable type inference failed */
    private IntegerLiteralTypeConstructor(long j2, ModuleDescriptor moduleDescriptor, Set<? extends KotlinType> set) {
        h b2;
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        this.type = KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), this, false);
        b2 = k.b(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.supertypes$delegate = b2;
        this.value = j2;
        this.module = moduleDescriptor;
        this.possibleTypes = set;
    }

    public /* synthetic */ IntegerLiteralTypeConstructor(long j2, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, moduleDescriptor, set);
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isContainsOnlyUnsignedTypes() {
        Collection<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        for (KotlinType kotlinType : allSignedLiteralTypes) {
            if (!(!getPossibleTypes().contains(kotlinType))) {
                return false;
            }
        }
        return true;
    }

    private final String valueToString() {
        String h0;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        h0 = z.h0(this.possibleTypes, ",", null, null, 0, null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30, null);
        sb.append(h0);
        sb.append(']');
        return sb.toString();
    }

    public final boolean checkConstructor(TypeConstructor constructor) {
        m.g(constructor, "constructor");
        Set<KotlinType> set = this.possibleTypes;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (KotlinType kotlinType : set) {
            if (m.c(kotlinType.getConstructor(), constructor)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2214getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> g2;
        g2 = r.g();
        return g2;
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return m.o("IntegerLiteralType", valueToString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes  reason: collision with other method in class */
    public Collection<KotlinType> mo2215getSupertypes() {
        return getSupertypes();
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static Mode[] valuesCustom() {
                Mode[] valuesCustom = values();
                Mode[] modeArr = new Mode[valuesCustom.length];
                System.arraycopy(valuesCustom, 0, modeArr, 0, valuesCustom.length);
                return modeArr;
            }
        }

        /* compiled from: IntegerLiteralTypeConstructor.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.valuesCustom().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = fold((SimpleType) next, (SimpleType) it.next(), mode);
                }
                return (SimpleType) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType simpleType, SimpleType simpleType2, Mode mode) {
            if (simpleType == null || simpleType2 == null) {
                return null;
            }
            TypeConstructor constructor = simpleType.getConstructor();
            TypeConstructor constructor2 = simpleType2.getConstructor();
            boolean z = constructor instanceof IntegerLiteralTypeConstructor;
            if (z && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                return fold((IntegerLiteralTypeConstructor) constructor, (IntegerLiteralTypeConstructor) constructor2, mode);
            }
            if (z) {
                return fold((IntegerLiteralTypeConstructor) constructor, simpleType2);
            }
            if (constructor2 instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) constructor2, simpleType);
            }
            return null;
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> types) {
            m.g(types, "types");
            return findCommonSuperTypeOrIntersectionType(types, Mode.INTERSECTION_TYPE);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set d0;
            int i2 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i2 == 1) {
                d0 = z.d0(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                d0 = z.N0(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            }
            IntegerLiteralTypeConstructor integerLiteralTypeConstructor3 = new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.value, integerLiteralTypeConstructor.module, d0, null);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            return KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), integerLiteralTypeConstructor3, false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, SimpleType simpleType) {
            if (integerLiteralTypeConstructor.getPossibleTypes().contains(simpleType)) {
                return simpleType;
            }
            return null;
        }
    }
}
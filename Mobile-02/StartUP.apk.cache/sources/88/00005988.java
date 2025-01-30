package kotlin.reflect.jvm.internal.impl.util;

import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final l<KotlinBuiltIns, KotlinType> type;

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        static final class AnonymousClass1 extends o implements l<KotlinBuiltIns, KotlinType> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                m.g(kotlinBuiltIns, "<this>");
                SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                m.f(booleanType, "booleanType");
                return booleanType;
            }
        }

        private ReturnsBoolean() {
            super("Boolean", AnonymousClass1.INSTANCE, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        static final class AnonymousClass1 extends o implements l<KotlinBuiltIns, KotlinType> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                m.g(kotlinBuiltIns, "<this>");
                SimpleType intType = kotlinBuiltIns.getIntType();
                m.f(intType, "intType");
                return intType;
            }
        }

        private ReturnsInt() {
            super("Int", AnonymousClass1.INSTANCE, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        static final class AnonymousClass1 extends o implements l<KotlinBuiltIns, KotlinType> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                m.g(kotlinBuiltIns, "<this>");
                SimpleType unitType = kotlinBuiltIns.getUnitType();
                m.f(unitType, "unitType");
                return unitType;
            }
        }

        private ReturnsUnit() {
            super("Unit", AnonymousClass1.INSTANCE, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, l<? super KotlinBuiltIns, ? extends KotlinType> lVar) {
        this.name = str;
        this.type = lVar;
        this.description = m.o("must return ", str);
    }

    public /* synthetic */ ReturnsCheck(String str, l lVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        m.g(functionDescriptor, "functionDescriptor");
        return m.c(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
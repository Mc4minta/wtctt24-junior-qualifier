package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class KClassValue extends ConstantValue<Value> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: constantValues.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ConstantValue<?> create(KotlinType argumentType) {
            m.g(argumentType, "argumentType");
            if (KotlinTypeKt.isError(argumentType)) {
                return null;
            }
            KotlinType kotlinType = argumentType;
            int i2 = 0;
            while (KotlinBuiltIns.isArray(kotlinType)) {
                kotlinType = ((TypeProjection) p.x0(kotlinType.getArguments())).getType();
                m.f(kotlinType, "type.arguments.single().type");
                i2++;
            }
            ClassifierDescriptor mo2214getDeclarationDescriptor = kotlinType.getConstructor().mo2214getDeclarationDescriptor();
            if (mo2214getDeclarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtilsKt.getClassId(mo2214getDeclarationDescriptor);
                return classId == null ? new KClassValue(new Value.LocalClass(argumentType)) : new KClassValue(classId, i2);
            } else if (mo2214getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                ClassId classId2 = ClassId.topLevel(StandardNames.FqNames.any.toSafe());
                m.f(classId2, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new KClassValue(classId2, 0);
            } else {
                return null;
            }
        }
    }

    /* compiled from: constantValues.kt */
    /* loaded from: classes3.dex */
    public static abstract class Value {

        /* compiled from: constantValues.kt */
        /* loaded from: classes3.dex */
        public static final class LocalClass extends Value {
            private final KotlinType type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LocalClass(KotlinType type) {
                super(null);
                m.g(type, "type");
                this.type = type;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LocalClass) && m.c(this.type, ((LocalClass) obj).type);
            }

            public final KotlinType getType() {
                return this.type;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.type + ')';
            }
        }

        /* compiled from: constantValues.kt */
        /* loaded from: classes3.dex */
        public static final class NormalClass extends Value {
            private final ClassLiteralValue value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NormalClass(ClassLiteralValue value) {
                super(null);
                m.g(value, "value");
                this.value = value;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NormalClass) && m.c(this.value, ((NormalClass) obj).value);
            }

            public final int getArrayDimensions() {
                return this.value.getArrayNestedness();
            }

            public final ClassId getClassId() {
                return this.value.getClassId();
            }

            public final ClassLiteralValue getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.value + ')';
            }
        }

        private Value() {
        }

        public /* synthetic */ Value(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassValue(Value value) {
        super(value);
        m.g(value, "value");
    }

    public final KotlinType getArgumentType(ModuleDescriptor module) {
        m.g(module, "module");
        Value value = getValue();
        if (value instanceof Value.LocalClass) {
            return ((Value.LocalClass) getValue()).getType();
        }
        if (value instanceof Value.NormalClass) {
            ClassLiteralValue value2 = ((Value.NormalClass) getValue()).getValue();
            ClassId component1 = value2.component1();
            int component2 = value2.component2();
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(module, component1);
            if (findClassAcrossModuleDependencies == null) {
                SimpleType createErrorType = ErrorUtils.createErrorType("Unresolved type: " + component1 + " (arrayDimensions=" + component2 + ')');
                m.f(createErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
                return createErrorType;
            }
            SimpleType defaultType = findClassAcrossModuleDependencies.getDefaultType();
            m.f(defaultType, "descriptor.defaultType");
            KotlinType replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
            for (int i2 = 0; i2 < component2; i2++) {
                replaceArgumentsWithStarProjections = module.getBuiltIns().getArrayType(Variance.INVARIANT, replaceArgumentsWithStarProjections);
                m.f(replaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
            }
            return replaceArgumentsWithStarProjections;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor module) {
        List b2;
        m.g(module, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        Annotations empty = Annotations.Companion.getEMPTY();
        ClassDescriptor kClass = module.getBuiltIns().getKClass();
        m.f(kClass, "module.builtIns.kClass");
        b2 = q.b(new TypeProjectionImpl(getArgumentType(module)));
        return KotlinTypeFactory.simpleNotNullType(empty, kClass, b2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KClassValue(ClassLiteralValue value) {
        this(new Value.NormalClass(value));
        m.g(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KClassValue(ClassId classId, int i2) {
        this(new ClassLiteralValue(classId, i2));
        m.g(classId, "classId");
    }
}
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.h;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.k;
import kotlin.l0.x;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;

/* compiled from: ReflectionTypes.kt */
/* loaded from: classes3.dex */
public final class ReflectionTypes {
    static final /* synthetic */ m<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion(null);
    private final ClassLookup kClass$delegate;
    private final ClassLookup kMutableProperty0$delegate;
    private final ClassLookup kMutableProperty1$delegate;
    private final ClassLookup kMutableProperty2$delegate;
    private final ClassLookup kProperty$delegate;
    private final ClassLookup kProperty0$delegate;
    private final ClassLookup kProperty1$delegate;
    private final ClassLookup kProperty2$delegate;
    private final h kotlinReflectScope$delegate;
    private final NotFoundClasses notFoundClasses;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReflectionTypes.kt */
    /* loaded from: classes3.dex */
    public static final class ClassLookup {
        private final int numberOfTypeParameters;

        public ClassLookup(int i2) {
            this.numberOfTypeParameters = i2;
        }

        public final ClassDescriptor getValue(ReflectionTypes types, m<?> property) {
            String v;
            kotlin.jvm.internal.m.g(types, "types");
            kotlin.jvm.internal.m.g(property, "property");
            v = x.v(property.getName());
            return types.find(v, this.numberOfTypeParameters);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinType createKPropertyStarType(ModuleDescriptor module) {
            List b2;
            kotlin.jvm.internal.m.g(module, "module");
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(module, StandardNames.FqNames.kProperty);
            if (findClassAcrossModuleDependencies == null) {
                return null;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            Annotations empty = Annotations.Companion.getEMPTY();
            List<TypeParameterDescriptor> parameters = findClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            kotlin.jvm.internal.m.f(parameters, "kPropertyClass.typeConstructor.parameters");
            Object x0 = p.x0(parameters);
            kotlin.jvm.internal.m.f(x0, "kPropertyClass.typeConstructor.parameters.single()");
            b2 = q.b(new StarProjectionImpl((TypeParameterDescriptor) x0));
            return KotlinTypeFactory.simpleNotNullType(empty, findClassAcrossModuleDependencies, b2);
        }
    }

    static {
        m<Object>[] mVarArr = new m[9];
        mVarArr[1] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[2] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[3] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[4] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[5] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[6] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[7] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        mVarArr[8] = e0.h(new kotlin.jvm.internal.x(e0.b(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        $$delegatedProperties = mVarArr;
    }

    public ReflectionTypes(ModuleDescriptor module, NotFoundClasses notFoundClasses) {
        h a;
        kotlin.jvm.internal.m.g(module, "module");
        kotlin.jvm.internal.m.g(notFoundClasses, "notFoundClasses");
        this.notFoundClasses = notFoundClasses;
        a = k.a(kotlin.m.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(module));
        this.kotlinReflectScope$delegate = a;
        this.kClass$delegate = new ClassLookup(1);
        this.kProperty$delegate = new ClassLookup(1);
        this.kProperty0$delegate = new ClassLookup(1);
        this.kProperty1$delegate = new ClassLookup(2);
        this.kProperty2$delegate = new ClassLookup(3);
        this.kMutableProperty0$delegate = new ClassLookup(1);
        this.kMutableProperty1$delegate = new ClassLookup(2);
        this.kMutableProperty2$delegate = new ClassLookup(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor find(String str, int i2) {
        List<Integer> b2;
        Name identifier = Name.identifier(str);
        kotlin.jvm.internal.m.f(identifier, "identifier(className)");
        ClassifierDescriptor mo2216getContributedClassifier = getKotlinReflectScope().mo2216getContributedClassifier(identifier, NoLookupLocation.FROM_REFLECTION);
        ClassDescriptor classDescriptor = mo2216getContributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) mo2216getContributedClassifier : null;
        if (classDescriptor == null) {
            NotFoundClasses notFoundClasses = this.notFoundClasses;
            ClassId classId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, identifier);
            b2 = q.b(Integer.valueOf(i2));
            return notFoundClasses.getClass(classId, b2);
        }
        return classDescriptor;
    }

    private final MemberScope getKotlinReflectScope() {
        return (MemberScope) this.kotlinReflectScope$delegate.getValue();
    }

    public final ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
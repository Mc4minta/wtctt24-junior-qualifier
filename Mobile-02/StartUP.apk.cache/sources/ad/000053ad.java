package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.l0.w;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: JavaToKotlinClassMap.kt */
/* loaded from: classes3.dex */
public final class JavaToKotlinClassMap {
    private static final ClassId CLASS_CLASS_ID;
    private static final ClassId FUNCTION_N_CLASS_ID;
    private static final FqName FUNCTION_N_FQ_NAME;
    public static final JavaToKotlinClassMap INSTANCE;
    private static final ClassId K_CLASS_CLASS_ID;
    private static final ClassId K_FUNCTION_CLASS_ID;
    private static final String NUMBERED_FUNCTION_PREFIX;
    private static final String NUMBERED_K_FUNCTION_PREFIX;
    private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
    private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX;
    private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin;
    private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava;
    private static final List<PlatformMutabilityMapping> mutabilityMappings;
    private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly;
    private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable;

    /* compiled from: JavaToKotlinClassMap.kt */
    /* loaded from: classes3.dex */
    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public PlatformMutabilityMapping(ClassId javaClass, ClassId kotlinReadOnly, ClassId kotlinMutable) {
            m.g(javaClass, "javaClass");
            m.g(kotlinReadOnly, "kotlinReadOnly");
            m.g(kotlinMutable, "kotlinMutable");
            this.javaClass = javaClass;
            this.kotlinReadOnly = kotlinReadOnly;
            this.kotlinMutable = kotlinMutable;
        }

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlatformMutabilityMapping) {
                PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
                return m.c(this.javaClass, platformMutabilityMapping.javaClass) && m.c(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && m.c(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
            }
            return false;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + ')';
        }
    }

    static {
        List<PlatformMutabilityMapping> j2;
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        INSTANCE = javaToKotlinClassMap;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        NUMBERED_FUNCTION_PREFIX = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        NUMBERED_K_FUNCTION_PREFIX = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        NUMBERED_SUSPEND_FUNCTION_PREFIX = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = sb4.toString();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        m.f(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        FUNCTION_N_CLASS_ID = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        m.f(asSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        FUNCTION_N_FQ_NAME = asSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        m.f(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        K_FUNCTION_CLASS_ID = classId2;
        ClassId classId3 = ClassId.topLevel(new FqName("kotlin.reflect.KClass"));
        m.f(classId3, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        K_CLASS_CLASS_ID = classId3;
        CLASS_CLASS_ID = javaToKotlinClassMap.classId(Class.class);
        javaToKotlin = new HashMap<>();
        kotlinToJava = new HashMap<>();
        mutableToReadOnly = new HashMap<>();
        readOnlyToMutable = new HashMap<>();
        ClassId classId4 = ClassId.topLevel(StandardNames.FqNames.iterable);
        m.f(classId4, "topLevel(FqNames.iterable)");
        FqName fqName = StandardNames.FqNames.mutableIterable;
        FqName packageFqName = classId4.getPackageFqName();
        FqName packageFqName2 = classId4.getPackageFqName();
        m.f(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName tail = FqNamesUtilKt.tail(fqName, packageFqName2);
        int i2 = 0;
        ClassId classId5 = new ClassId(packageFqName, tail, false);
        ClassId classId6 = ClassId.topLevel(StandardNames.FqNames.iterator);
        m.f(classId6, "topLevel(FqNames.iterator)");
        FqName fqName2 = StandardNames.FqNames.mutableIterator;
        FqName packageFqName3 = classId6.getPackageFqName();
        FqName packageFqName4 = classId6.getPackageFqName();
        m.f(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId7 = new ClassId(packageFqName3, FqNamesUtilKt.tail(fqName2, packageFqName4), false);
        ClassId classId8 = ClassId.topLevel(StandardNames.FqNames.collection);
        m.f(classId8, "topLevel(FqNames.collection)");
        FqName fqName3 = StandardNames.FqNames.mutableCollection;
        FqName packageFqName5 = classId8.getPackageFqName();
        FqName packageFqName6 = classId8.getPackageFqName();
        m.f(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId9 = new ClassId(packageFqName5, FqNamesUtilKt.tail(fqName3, packageFqName6), false);
        ClassId classId10 = ClassId.topLevel(StandardNames.FqNames.list);
        m.f(classId10, "topLevel(FqNames.list)");
        FqName fqName4 = StandardNames.FqNames.mutableList;
        FqName packageFqName7 = classId10.getPackageFqName();
        FqName packageFqName8 = classId10.getPackageFqName();
        m.f(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId11 = new ClassId(packageFqName7, FqNamesUtilKt.tail(fqName4, packageFqName8), false);
        ClassId classId12 = ClassId.topLevel(StandardNames.FqNames.set);
        m.f(classId12, "topLevel(FqNames.set)");
        FqName fqName5 = StandardNames.FqNames.mutableSet;
        FqName packageFqName9 = classId12.getPackageFqName();
        FqName packageFqName10 = classId12.getPackageFqName();
        m.f(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId13 = new ClassId(packageFqName9, FqNamesUtilKt.tail(fqName5, packageFqName10), false);
        ClassId classId14 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        m.f(classId14, "topLevel(FqNames.listIterator)");
        FqName fqName6 = StandardNames.FqNames.mutableListIterator;
        FqName packageFqName11 = classId14.getPackageFqName();
        FqName packageFqName12 = classId14.getPackageFqName();
        m.f(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId15 = new ClassId(packageFqName11, FqNamesUtilKt.tail(fqName6, packageFqName12), false);
        FqName fqName7 = StandardNames.FqNames.map;
        ClassId classId16 = ClassId.topLevel(fqName7);
        m.f(classId16, "topLevel(FqNames.map)");
        FqName fqName8 = StandardNames.FqNames.mutableMap;
        FqName packageFqName13 = classId16.getPackageFqName();
        FqName packageFqName14 = classId16.getPackageFqName();
        m.f(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId17 = new ClassId(packageFqName13, FqNamesUtilKt.tail(fqName8, packageFqName14), false);
        ClassId createNestedClassId = ClassId.topLevel(fqName7).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        m.f(createNestedClassId, "topLevel(FqNames.map).createNestedClassId(FqNames.mapEntry.shortName())");
        FqName fqName9 = StandardNames.FqNames.mutableMapEntry;
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        m.f(packageFqName16, "kotlinReadOnly.packageFqName");
        j2 = r.j(new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterable.class), classId4, classId5), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterator.class), classId6, classId7), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Collection.class), classId8, classId9), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(List.class), classId10, classId11), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Set.class), classId12, classId13), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(ListIterator.class), classId14, classId15), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.class), classId16, classId17), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.Entry.class), createNestedClassId, new ClassId(packageFqName15, FqNamesUtilKt.tail(fqName9, packageFqName16), false)));
        mutabilityMappings = j2;
        javaToKotlinClassMap.addTopLevel(Object.class, StandardNames.FqNames.any);
        javaToKotlinClassMap.addTopLevel(String.class, StandardNames.FqNames.string);
        javaToKotlinClassMap.addTopLevel(CharSequence.class, StandardNames.FqNames.charSequence);
        javaToKotlinClassMap.addTopLevel(Throwable.class, StandardNames.FqNames.throwable);
        javaToKotlinClassMap.addTopLevel(Cloneable.class, StandardNames.FqNames.cloneable);
        javaToKotlinClassMap.addTopLevel(Number.class, StandardNames.FqNames.number);
        javaToKotlinClassMap.addTopLevel(Comparable.class, StandardNames.FqNames.comparable);
        javaToKotlinClassMap.addTopLevel(Enum.class, StandardNames.FqNames._enum);
        javaToKotlinClassMap.addTopLevel(Annotation.class, StandardNames.FqNames.annotation);
        for (PlatformMutabilityMapping platformMutabilityMapping : j2) {
            INSTANCE.addMapping(platformMutabilityMapping);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i3 = 0;
        while (i3 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i3];
            i3++;
            JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
            ClassId classId18 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            m.f(classId18, "topLevel(jvmType.wrapperFqName)");
            StandardNames standardNames = StandardNames.INSTANCE;
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            m.f(primitiveType, "jvmType.primitiveType");
            ClassId classId19 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            m.f(classId19, "topLevel(StandardNames.getPrimitiveFqName(jvmType.primitiveType))");
            javaToKotlinClassMap2.add(classId18, classId19);
        }
        for (ClassId classId20 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
            ClassId classId21 = ClassId.topLevel(new FqName("kotlin.jvm.internal." + classId20.getShortClassName().asString() + "CompanionObject"));
            m.f(classId21, "topLevel(FqName(\"kotlin.jvm.internal.\" + classId.shortClassName.asString() + \"CompanionObject\"))");
            ClassId createNestedClassId2 = classId20.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            m.f(createNestedClassId2, "classId.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap3.add(classId21, createNestedClassId2);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
            ClassId classId22 = ClassId.topLevel(new FqName(m.o("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            m.f(classId22, "topLevel(FqName(\"kotlin.jvm.functions.Function$i\"))");
            StandardNames standardNames2 = StandardNames.INSTANCE;
            javaToKotlinClassMap4.add(classId22, StandardNames.getFunctionClassId(i4));
            javaToKotlinClassMap4.addKotlinToJava(new FqName(m.o(NUMBERED_K_FUNCTION_PREFIX, Integer.valueOf(i4))), K_FUNCTION_CLASS_ID);
            if (i5 >= 23) {
                break;
            }
            i4 = i5;
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            JavaToKotlinClassMap javaToKotlinClassMap5 = INSTANCE;
            javaToKotlinClassMap5.addKotlinToJava(new FqName(m.o(functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i2))), K_FUNCTION_CLASS_ID);
            if (i6 >= 22) {
                FqName safe = StandardNames.FqNames.nothing.toSafe();
                m.f(safe, "nothing.toSafe()");
                javaToKotlinClassMap5.addKotlinToJava(safe, javaToKotlinClassMap5.classId(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    private JavaToKotlinClassMap() {
    }

    private final void add(ClassId classId, ClassId classId2) {
        addJavaToKotlin(classId, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        m.f(asSingleFqName, "kotlinClassId.asSingleFqName()");
        addKotlinToJava(asSingleFqName, classId);
    }

    private final void addJavaToKotlin(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> hashMap = javaToKotlin;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        m.f(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, classId2);
    }

    private final void addKotlinToJava(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> hashMap = kotlinToJava;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        m.f(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(unsafe, classId);
    }

    private final void addMapping(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId component1 = platformMutabilityMapping.component1();
        ClassId component2 = platformMutabilityMapping.component2();
        ClassId component3 = platformMutabilityMapping.component3();
        add(component1, component2);
        FqName asSingleFqName = component3.asSingleFqName();
        m.f(asSingleFqName, "mutableClassId.asSingleFqName()");
        addKotlinToJava(asSingleFqName, component1);
        FqName asSingleFqName2 = component2.asSingleFqName();
        m.f(asSingleFqName2, "readOnlyClassId.asSingleFqName()");
        FqName asSingleFqName3 = component3.asSingleFqName();
        m.f(asSingleFqName3, "mutableClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, FqName> hashMap = mutableToReadOnly;
        FqNameUnsafe unsafe = component3.asSingleFqName().toUnsafe();
        m.f(unsafe, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, asSingleFqName2);
        HashMap<FqNameUnsafe, FqName> hashMap2 = readOnlyToMutable;
        FqNameUnsafe unsafe2 = asSingleFqName2.toUnsafe();
        m.f(unsafe2, "readOnlyFqName.toUnsafe()");
        hashMap2.put(unsafe2, asSingleFqName3);
    }

    private final void addTopLevel(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        m.f(safe, "kotlinFqName.toSafe()");
        addTopLevel(cls, safe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId classId(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            m.f(classId, "topLevel(FqName(clazz.canonicalName))");
            return classId;
        }
        ClassId createNestedClassId = classId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        m.f(createNestedClassId, "classId(outer).createNestedClassId(Name.identifier(clazz.simpleName))");
        return createNestedClassId;
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe fqNameUnsafe, String str) {
        String U0;
        boolean P0;
        Integer q;
        String asString = fqNameUnsafe.asString();
        m.f(asString, "kotlinFqName.asString()");
        U0 = y.U0(asString, str, "");
        if (U0.length() > 0) {
            P0 = y.P0(U0, '0', false, 2, null);
            if (!P0) {
                q = w.q(U0);
                return q != null && q.intValue() >= 23;
            }
        }
        return false;
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = mutableToReadOnly;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fqNameUnsafe);
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = readOnlyToMutable;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(fqNameUnsafe);
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        m.g(fqName, "fqName");
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe kotlinFqName) {
        m.g(kotlinFqName, "kotlinFqName");
        if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            if (!isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_FUNCTION_PREFIX) && !isKotlinFunctionWithBigArity(kotlinFqName, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
                return kotlinToJava.get(kotlinFqName);
            }
            return K_FUNCTION_CLASS_ID;
        }
        return FUNCTION_N_CLASS_ID;
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return mutableToReadOnly.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return readOnlyToMutable.get(fqNameUnsafe);
    }

    private final void addTopLevel(Class<?> cls, FqName fqName) {
        ClassId classId = classId(cls);
        ClassId classId2 = ClassId.topLevel(fqName);
        m.f(classId2, "topLevel(kotlinFqName)");
        add(classId, classId2);
    }
}
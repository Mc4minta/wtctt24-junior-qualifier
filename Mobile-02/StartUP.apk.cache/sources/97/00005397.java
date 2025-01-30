package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.s0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.spongycastle.i18n.TextBundle;

/* compiled from: StandardNames.kt */
/* loaded from: classes3.dex */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final Name BUILT_INS_PACKAGE_NAME;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    public static final Name ENUM_VALUES;
    public static final Name ENUM_VALUE_OF;
    public static final StandardNames INSTANCE = new StandardNames();
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    public static final List<String> PREFIXES;
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    public static final FqName RESULT_FQ_NAME;
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    /* compiled from: StandardNames.kt */
    /* loaded from: classes3.dex */
    public static final class FqNames {
        public static final FqNames INSTANCE;
        public static final FqNameUnsafe _boolean;
        public static final FqNameUnsafe _byte;
        public static final FqNameUnsafe _char;
        public static final FqNameUnsafe _double;
        public static final FqNameUnsafe _enum;
        public static final FqNameUnsafe _float;
        public static final FqNameUnsafe _int;
        public static final FqNameUnsafe _long;
        public static final FqNameUnsafe _short;
        public static final FqName annotation;
        public static final FqName annotationRetention;
        public static final FqName annotationTarget;
        public static final FqNameUnsafe any;
        public static final FqNameUnsafe array;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        public static final FqNameUnsafe charSequence;
        public static final FqNameUnsafe cloneable;
        public static final FqName collection;
        public static final FqName comparable;
        public static final FqName deprecated;
        public static final FqName deprecatedSinceKotlin;
        public static final FqName deprecationLevel;
        public static final FqName extensionFunctionType;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        public static final FqNameUnsafe functionSupertype;
        public static final FqNameUnsafe intRange;
        public static final FqName iterable;
        public static final FqName iterator;
        public static final FqNameUnsafe kCallable;
        public static final FqNameUnsafe kClass;
        public static final FqNameUnsafe kDeclarationContainer;
        public static final FqNameUnsafe kMutableProperty0;
        public static final FqNameUnsafe kMutableProperty1;
        public static final FqNameUnsafe kMutableProperty2;
        public static final FqNameUnsafe kMutablePropertyFqName;
        public static final ClassId kProperty;
        public static final FqNameUnsafe kProperty0;
        public static final FqNameUnsafe kProperty1;
        public static final FqNameUnsafe kProperty2;
        public static final FqNameUnsafe kPropertyFqName;
        public static final FqName list;
        public static final FqName listIterator;
        public static final FqNameUnsafe longRange;
        public static final FqName map;
        public static final FqName mapEntry;
        public static final FqName mustBeDocumented;
        public static final FqName mutableCollection;
        public static final FqName mutableIterable;
        public static final FqName mutableIterator;
        public static final FqName mutableList;
        public static final FqName mutableListIterator;
        public static final FqName mutableMap;
        public static final FqName mutableMapEntry;
        public static final FqName mutableSet;
        public static final FqNameUnsafe nothing;
        public static final FqNameUnsafe number;
        public static final FqName parameterName;
        public static final Set<Name> primitiveArrayTypeShortNames;
        public static final Set<Name> primitiveTypeShortNames;
        public static final FqName publishedApi;
        public static final FqName repeatable;
        public static final FqName replaceWith;
        public static final FqName retention;
        public static final FqName set;
        public static final FqNameUnsafe string;
        public static final FqName suppress;
        public static final FqName target;
        public static final FqName throwable;
        public static final ClassId uByte;
        public static final FqName uByteArrayFqName;
        public static final FqName uByteFqName;
        public static final ClassId uInt;
        public static final FqName uIntArrayFqName;
        public static final FqName uIntFqName;
        public static final ClassId uLong;
        public static final FqName uLongArrayFqName;
        public static final FqName uLongFqName;
        public static final ClassId uShort;
        public static final FqName uShortArrayFqName;
        public static final FqName uShortFqName;
        public static final FqNameUnsafe unit;
        public static final FqName unsafeVariance;

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe("String");
            array = fqNames.fqNameUnsafe("Array");
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            parameterName = fqNames.fqName("ParameterName");
            annotation = fqNames.fqName("Annotation");
            target = fqNames.annotationName("Target");
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            retention = fqNames.annotationName("Retention");
            repeatable = fqNames.annotationName("Repeatable");
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            FqName collectionsFqName = fqNames.collectionsFqName("Map");
            map = collectionsFqName;
            FqName child = collectionsFqName.child(Name.identifier("Entry"));
            m.f(child, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = child;
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            FqNames fqNames2 = INSTANCE;
            mutableListIterator = fqNames2.collectionsFqName("MutableListIterator");
            mutableSet = fqNames2.collectionsFqName("MutableSet");
            FqName collectionsFqName2 = fqNames2.collectionsFqName("MutableMap");
            mutableMap = collectionsFqName2;
            FqName child2 = collectionsFqName2.child(Name.identifier("MutableEntry"));
            m.f(child2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = child2;
            kClass = reflect("KClass");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            kMutablePropertyFqName = reflect("KMutableProperty");
            ClassId classId = ClassId.topLevel(reflect.toSafe());
            m.f(classId, "topLevel(kPropertyFqName.toSafe())");
            kProperty = classId;
            kDeclarationContainer = reflect("KDeclarationContainer");
            FqName fqName = fqNames2.fqName("UByte");
            uByteFqName = fqName;
            FqName fqName2 = fqNames2.fqName("UShort");
            uShortFqName = fqName2;
            FqName fqName3 = fqNames2.fqName("UInt");
            uIntFqName = fqName3;
            FqName fqName4 = fqNames2.fqName("ULong");
            uLongFqName = fqName4;
            ClassId classId2 = ClassId.topLevel(fqName);
            m.f(classId2, "topLevel(uByteFqName)");
            uByte = classId2;
            ClassId classId3 = ClassId.topLevel(fqName2);
            m.f(classId3, "topLevel(uShortFqName)");
            uShort = classId3;
            ClassId classId4 = ClassId.topLevel(fqName3);
            m.f(classId4, "topLevel(uIntFqName)");
            uInt = classId4;
            ClassId classId5 = ClassId.topLevel(fqName4);
            m.f(classId5, "topLevel(uLongFqName)");
            uLong = classId5;
            uByteArrayFqName = fqNames2.fqName("UByteArray");
            uShortArrayFqName = fqNames2.fqName("UShortArray");
            uIntArrayFqName = fqNames2.fqName("UIntArray");
            uLongArrayFqName = fqNames2.fqName("ULongArray");
            HashSet newHashSetWithExpectedSize = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.valuesCustom().length);
            int i2 = 0;
            for (PrimitiveType primitiveType : PrimitiveType.valuesCustom()) {
                newHashSetWithExpectedSize.add(primitiveType.getTypeName());
            }
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            HashSet newHashSetWithExpectedSize2 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.valuesCustom().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.valuesCustom()) {
                newHashSetWithExpectedSize2.add(primitiveType2.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.valuesCustom().length);
            PrimitiveType[] valuesCustom = PrimitiveType.valuesCustom();
            int length = valuesCustom.length;
            int i3 = 0;
            while (i3 < length) {
                PrimitiveType primitiveType3 = valuesCustom[i3];
                i3++;
                FqNames fqNames3 = INSTANCE;
                String asString = primitiveType3.getTypeName().asString();
                m.f(asString, "primitiveType.typeName.asString()");
                newHashMapWithExpectedSize.put(fqNames3.fqNameUnsafe(asString), primitiveType3);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            HashMap newHashMapWithExpectedSize2 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.valuesCustom().length);
            PrimitiveType[] valuesCustom2 = PrimitiveType.valuesCustom();
            int length2 = valuesCustom2.length;
            while (i2 < length2) {
                PrimitiveType primitiveType4 = valuesCustom2[i2];
                i2++;
                FqNames fqNames4 = INSTANCE;
                String asString2 = primitiveType4.getArrayTypeName().asString();
                m.f(asString2, "primitiveType.arrayTypeName.asString()");
                newHashMapWithExpectedSize2.put(fqNames4.fqNameUnsafe(asString2), primitiveType4);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        private FqNames() {
        }

        private final FqName annotationName(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            m.f(child, "ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        private final FqName collectionsFqName(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            m.f(child, "COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        private final FqName fqName(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            m.f(child, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        private final FqNameUnsafe fqNameUnsafe(String str) {
            FqNameUnsafe unsafe = fqName(str).toUnsafe();
            m.f(unsafe, "fqName(simpleName).toUnsafe()");
            return unsafe;
        }

        private final FqNameUnsafe rangesFqName(String str) {
            FqNameUnsafe unsafe = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            m.f(unsafe, "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }

        public static final FqNameUnsafe reflect(String simpleName) {
            m.g(simpleName, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe();
            m.f(unsafe, "KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }
    }

    static {
        List<String> j2;
        Set<FqName> e2;
        Name identifier = Name.identifier("values");
        m.f(identifier, "identifier(\"values\")");
        ENUM_VALUES = identifier;
        Name identifier2 = Name.identifier("valueOf");
        m.f(identifier2, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = identifier2;
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME_RELEASE = fqName;
        FqName child = fqName.child(Name.identifier("experimental"));
        m.f(child, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = child;
        FqName child2 = child.child(Name.identifier("intrinsics"));
        m.f(child2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = child2;
        FqName child3 = child.child(Name.identifier("Continuation"));
        m.f(child3, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = child3;
        FqName child4 = fqName.child(Name.identifier("Continuation"));
        m.f(child4, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_RELEASE = child4;
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        j2 = r.j("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
        PREFIXES = j2;
        Name identifier3 = Name.identifier("kotlin");
        m.f(identifier3, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = identifier3;
        FqName fqName3 = FqName.topLevel(identifier3);
        m.f(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child5 = fqName3.child(Name.identifier("annotation"));
        m.f(child5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("collections"));
        m.f(child6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = child6;
        FqName child7 = fqName3.child(Name.identifier("ranges"));
        m.f(child7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = child7;
        FqName child8 = fqName3.child(Name.identifier(TextBundle.TEXT_ENTRY));
        m.f(child8, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = child8;
        FqName child9 = fqName3.child(Name.identifier("internal"));
        m.f(child9, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        e2 = s0.e(fqName3, child6, child7, child5, fqName2, child9, fqName);
        BUILT_INS_PACKAGE_FQ_NAMES = e2;
    }

    private StandardNames() {
    }

    public static final ClassId getFunctionClassId(int i2) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i2)));
    }

    public static final String getFunctionName(int i2) {
        return m.o("Function", Integer.valueOf(i2));
    }

    public static final FqName getPrimitiveFqName(PrimitiveType primitiveType) {
        m.g(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        m.f(child, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return child;
    }

    public static final String getSuspendFunctionName(int i2) {
        return m.o(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i2));
    }

    public static final boolean isPrimitiveArray(FqNameUnsafe arrayFqName) {
        m.g(arrayFqName, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(arrayFqName) != null;
    }
}
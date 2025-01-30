package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a0.r;
import kotlin.a0.t0;
import kotlin.a0.w;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: JvmBuiltInsSignatures.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltInsSignatures {
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES;
    public static final JvmBuiltInsSignatures INSTANCE;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES;

    static {
        Set<String> i2;
        Set h2;
        Set h3;
        Set h4;
        Set h5;
        Set h6;
        Set<String> h7;
        Set h8;
        Set h9;
        Set h10;
        Set h11;
        Set h12;
        Set<String> h13;
        Set h14;
        Set<String> h15;
        Set h16;
        Set<String> h17;
        JvmBuiltInsSignatures jvmBuiltInsSignatures = new JvmBuiltInsSignatures();
        INSTANCE = jvmBuiltInsSignatures;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        i2 = t0.i(signatureBuildingComponents.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        DROP_LIST_METHOD_SIGNATURES = i2;
        h2 = t0.h(jvmBuiltInsSignatures.buildPrimitiveValueMethodsSet(), signatureBuildingComponents.inJavaUtil("List", "sort(Ljava/util/Comparator;)V"));
        h3 = t0.h(h2, signatureBuildingComponents.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"));
        h4 = t0.h(h3, signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z"));
        h5 = t0.h(h4, signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z"));
        h6 = t0.h(h5, signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        h7 = t0.h(h6, signatureBuildingComponents.inJavaLang("CharSequence", "isEmpty()Z"));
        HIDDEN_METHOD_SIGNATURES = h7;
        h8 = t0.h(signatureBuildingComponents.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), signatureBuildingComponents.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V"));
        h9 = t0.h(h8, signatureBuildingComponents.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"));
        h10 = t0.h(h9, signatureBuildingComponents.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"));
        h11 = t0.h(h10, signatureBuildingComponents.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"));
        h12 = t0.h(h11, signatureBuildingComponents.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V"));
        h13 = t0.h(h12, signatureBuildingComponents.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        VISIBLE_METHOD_SIGNATURES = h13;
        h14 = t0.h(signatureBuildingComponents.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), signatureBuildingComponents.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"));
        h15 = t0.h(h14, signatureBuildingComponents.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        MUTABLE_METHOD_SIGNATURES = h15;
        Set<String> buildPrimitiveStringConstructorsSet = jvmBuiltInsSignatures.buildPrimitiveStringConstructorsSet();
        String[] constructors = signatureBuildingComponents.constructors("D");
        String[] strArr = new String[constructors.length];
        System.arraycopy(constructors, 0, strArr, 0, constructors.length);
        h16 = t0.h(buildPrimitiveStringConstructorsSet, signatureBuildingComponents.inJavaLang("Float", strArr));
        String[] constructors2 = signatureBuildingComponents.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr2 = new String[constructors2.length];
        System.arraycopy(constructors2, 0, strArr2, 0, constructors2.length);
        h17 = t0.h(h16, signatureBuildingComponents.inJavaLang("String", strArr2));
        HIDDEN_CONSTRUCTOR_SIGNATURES = h17;
        String[] constructors3 = signatureBuildingComponents.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr3 = new String[constructors3.length];
        System.arraycopy(constructors3, 0, strArr3, 0, constructors3.length);
        VISIBLE_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents.inJavaLang("Throwable", strArr3);
    }

    private JvmBuiltInsSignatures() {
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        List<JvmPrimitiveType> j2;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BYTE;
        j2 = r.j(JvmPrimitiveType.BOOLEAN, jvmPrimitiveType, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType2 : j2) {
            String asString = jvmPrimitiveType2.getWrapperFqName().shortName().asString();
            m.f(asString, "it.wrapperFqName.shortName().asString()");
            String[] constructors = signatureBuildingComponents.constructors("Ljava/lang/String;");
            String[] strArr = new String[constructors.length];
            System.arraycopy(constructors, 0, strArr, 0, constructors.length);
            w.y(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, strArr));
        }
        return linkedHashSet;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        List<JvmPrimitiveType> j2;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        j2 = r.j(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : j2) {
            String asString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
            m.f(asString, "it.wrapperFqName.shortName().asString()");
            w.y(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqName) {
        m.g(fqName, "fqName");
        if (!m.c(fqName, StandardNames.FqNames.array)) {
            StandardNames standardNames = StandardNames.INSTANCE;
            if (!StandardNames.isPrimitiveArray(fqName)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSerializableInJava(FqNameUnsafe fqName) {
        m.g(fqName, "fqName");
        if (isArrayOrPrimitiveArray(fqName)) {
            return true;
        }
        ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
        if (mapKotlinToJava == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(mapKotlinToJava.asSingleFqName().asString()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.p;
import kotlin.a0.z;
import kotlin.j0.c;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0007¢\u0006\u0004\bH\u0010IJG\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\r\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0004\u001a\u00020#H&¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0$2\u0006\u0010\u0004\u001a\u00020#H&¢\u0006\u0004\b)\u0010'J\u0019\u0010+\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020\u001cH&¢\u0006\u0004\b+\u0010,J)\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003010$2\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0004¢\u0006\u0004\b2\u00103J\u001d\u00105\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003¢\u0006\u0004\b5\u00106J\u001d\u00107\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b9\u0010:J'\u0010<\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\b¢\u0006\u0004\b<\u0010=J\u001b\u0010>\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b@\u0010?R\u001a\u0010C\u001a\u0006\u0012\u0002\b\u00030\u00028T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020D0$8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006M"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/d;", "Ljava/lang/Class;", "", ApiConstants.NAME, "", "parameterTypes", "returnType", "", "isStaticDefault", "Ljava/lang/reflect/Method;", "lookupMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "Ljava/lang/reflect/Constructor;", "tryGetConstructor", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "", "result", "desc", "isConstructor", "Lkotlin/x;", "addParametersAndMasks", "(Ljava/util/List;Ljava/lang/String;Z)V", "loadParameterTypes", "(Ljava/lang/String;)Ljava/util/List;", "", "begin", "end", "parseType", "(Ljava/lang/String;II)Ljava/lang/Class;", "loadReturnType", "(Ljava/lang/String;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "(Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;)Ljava/util/Collection;", "signature", "findPropertyDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findFunctionDescriptor", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "findMethodBySignature", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "isMember", "findDefaultMethod", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", "findConstructorBySignature", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "getMethodOwner", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "<init>", "()V", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements d {
    public static final Companion Companion = new Companion(null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    private static final k LOCAL_PROPERTY_SIGNATURE = new k("<v#(\\d+)>");

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "Lkotlin/l0/k;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/l0/k;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/l0/k;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final k getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public abstract class Data {
        static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        private final ReflectProperties.LazySoftVal moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(this));

        public Data() {
        }

        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", "accept", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Z", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(CallableMemberDescriptor member) {
            kotlin.jvm.internal.m.g(member, "member");
            CallableMemberDescriptor.Kind kind = member.getKind();
            kotlin.jvm.internal.m.f(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    private final void addParametersAndMasks(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> loadParameterTypes = loadParameterTypes(str);
        list.addAll(loadParameterTypes);
        int size = ((loadParameterTypes.size() + 32) - 1) / 32;
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls = Integer.TYPE;
            kotlin.jvm.internal.m.f(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        kotlin.jvm.internal.m.f(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> loadParameterTypes(String str) {
        boolean U;
        int h0;
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        while (str.charAt(i3) != ')') {
            int i4 = i3;
            while (str.charAt(i4) == '[') {
                i4++;
            }
            char charAt = str.charAt(i4);
            U = y.U("VZCBSIFJD", charAt, false, 2, null);
            if (U) {
                i2 = i4 + 1;
            } else if (charAt == 'L') {
                h0 = y.h0(str, ';', i3, false, 4, null);
                i2 = h0 + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(parseType(str, i3, i2));
            i3 = i2;
        }
        return arrayList;
    }

    private final Class<?> loadReturnType(String str) {
        int h0;
        h0 = y.h0(str, ')', 0, false, 6, null);
        return parseType(str, h0 + 1, str.length());
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Class<?>[] interfaces;
        Method lookupMethod;
        if (z) {
            clsArr[0] = cls;
        }
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (lookupMethod = lookupMethod(superclass, str, clsArr, cls2, z)) == null) {
            for (Class<?> superInterface : cls.getInterfaces()) {
                kotlin.jvm.internal.m.f(superInterface, "superInterface");
                Method lookupMethod2 = lookupMethod(superInterface, str, clsArr, cls2, z);
                if (lookupMethod2 != null) {
                    return lookupMethod2;
                }
                if (z) {
                    Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(superInterface), superInterface.getName() + "$DefaultImpls");
                    if (tryLoadClass != null) {
                        clsArr[0] = superInterface;
                        Method tryGetMethod2 = tryGetMethod(tryLoadClass, str, clsArr, cls2);
                        if (tryGetMethod2 != null) {
                            return tryGetMethod2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        return lookupMethod;
    }

    private final Class<?> parseType(String str, int i2, int i3) {
        String J;
        char charAt = str.charAt(i2);
        if (charAt != 'F') {
            if (charAt == 'L') {
                ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
                String substring = str.substring(i2 + 1, i3 - 1);
                kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                J = kotlin.l0.x.J(substring, '/', '.', false, 4, null);
                Class<?> loadClass = safeClassLoader.loadClass(J);
                kotlin.jvm.internal.m.f(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            } else if (charAt != 'S') {
                if (charAt == 'V') {
                    Class<?> cls = Void.TYPE;
                    kotlin.jvm.internal.m.f(cls, "Void.TYPE");
                    return cls;
                } else if (charAt != 'I') {
                    if (charAt != 'J') {
                        if (charAt != 'Z') {
                            if (charAt != '[') {
                                switch (charAt) {
                                    case 'B':
                                        return Byte.TYPE;
                                    case 'C':
                                        return Character.TYPE;
                                    case 'D':
                                        return Double.TYPE;
                                    default:
                                        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                                }
                            }
                            return ReflectClassUtilKt.createArrayType(parseType(str, i2 + 1, i3));
                        }
                        return Boolean.TYPE;
                    }
                    return Long.TYPE;
                } else {
                    return Integer.TYPE;
                }
            } else {
                return Short.TYPE;
            }
        }
        return Float.TYPE;
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[LOOP:0: B:7:0x0029->B:18:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.reflect.Method tryGetMethod(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r9, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r8, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r2 = "result"
            kotlin.jvm.internal.m.f(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class r2 = r1.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r2 = kotlin.jvm.internal.m.c(r2, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r2 == 0) goto L1d
            r0 = r1
            goto L5d
        L1d:
            java.lang.reflect.Method[] r7 = r7.getDeclaredMethods()     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r1 = "declaredMethods"
            kotlin.jvm.internal.m.f(r7, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            int r1 = r7.length     // Catch: java.lang.NoSuchMethodException -> L5d
            r2 = 0
            r3 = r2
        L29:
            if (r3 >= r1) goto L5d
            r4 = r7[r3]     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = "method"
            kotlin.jvm.internal.m.f(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = r4.getName()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = kotlin.jvm.internal.m.c(r5, r8)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class r5 = r4.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = kotlin.jvm.internal.m.c(r5, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class[] r5 = r4.getParameterTypes()     // Catch: java.lang.NoSuchMethodException -> L5d
            kotlin.jvm.internal.m.e(r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = java.util.Arrays.equals(r5, r9)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            r5 = 1
            goto L56
        L55:
            r5 = r2
        L56:
            if (r5 == 0) goto L5a
            r0 = r4
            goto L5d
        L5a:
            int r3 = r3 + 1
            goto L29
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.tryGetMethod(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    public final Constructor<?> findConstructorBySignature(String desc) {
        kotlin.jvm.internal.m.g(desc, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(desc));
    }

    public final Constructor<?> findDefaultConstructor(String desc) {
        kotlin.jvm.internal.m.g(desc, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, desc, true);
        kotlin.x xVar = kotlin.x.a;
        return tryGetConstructor(jClass, arrayList);
    }

    public final Method findDefaultMethod(String name, String desc, boolean z) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(desc, "desc");
        if (kotlin.jvm.internal.m.c(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, desc, false);
        Class<?> methodOwner = getMethodOwner();
        String str = name + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return lookupMethod(methodOwner, str, (Class[]) array, loadReturnType(desc), z);
    }

    public final FunctionDescriptor findFunctionDescriptor(String name, String signature) {
        Collection<FunctionDescriptor> functions;
        String h0;
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(signature, "signature");
        if (kotlin.jvm.internal.m.c(name, "<init>")) {
            functions = z.I0(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(name);
            kotlin.jvm.internal.m.f(identifier, "Name.identifier(name)");
            functions = getFunctions(identifier);
        }
        Collection<FunctionDescriptor> collection = functions;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.m.c(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) obj).asString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            h0 = z.h0(collection, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(name);
            sb.append("' (JVM signature: ");
            sb.append(signature);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            sb.append(h0.length() == 0 ? " no members found" : '\n' + h0);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (FunctionDescriptor) p.x0(arrayList);
    }

    public final Method findMethodBySignature(String name, String desc) {
        Method lookupMethod;
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(desc, "desc");
        if (kotlin.jvm.internal.m.c(name, "<init>")) {
            return null;
        }
        Object[] array = loadParameterTypes(desc).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> loadReturnType = loadReturnType(desc);
        Method lookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, loadReturnType, false);
        if (lookupMethod2 != null) {
            return lookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (lookupMethod = lookupMethod(Object.class, name, clsArr, loadReturnType, false)) == null) {
            return null;
        }
        return lookupMethod;
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String signature) {
        SortedMap h2;
        String h0;
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(signature, "signature");
        i c2 = LOCAL_PROPERTY_SIGNATURE.c(signature);
        if (c2 != null) {
            String str = c2.a().a().b().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(name);
        kotlin.jvm.internal.m.f(identifier, "Name.identifier(name)");
        Collection<PropertyDescriptor> properties = getProperties(identifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (kotlin.jvm.internal.m.c(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj).asString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    DescriptorVisibility visibility = ((PropertyDescriptor) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                h2 = l0.h(linkedHashMap, new Comparator<DescriptorVisibility>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2
                    @Override // java.util.Comparator
                    public final int compare(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
                        Integer compare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
                        if (compare != null) {
                            return compare.intValue();
                        }
                        return 0;
                    }
                });
                Collection values = h2.values();
                kotlin.jvm.internal.m.f(values, "properties\n             …                }).values");
                List mostVisibleProperties = (List) p.i0(values);
                if (mostVisibleProperties.size() == 1) {
                    kotlin.jvm.internal.m.f(mostVisibleProperties, "mostVisibleProperties");
                    return (PropertyDescriptor) p.Y(mostVisibleProperties);
                }
                Name identifier2 = Name.identifier(name);
                kotlin.jvm.internal.m.f(identifier2, "Name.identifier(name)");
                h0 = z.h0(getProperties(identifier2), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(name);
                sb.append("' (JVM signature: ");
                sb.append(signature);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                sb.append(h0.length() == 0 ? " no members found" : '\n' + h0);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            return (PropertyDescriptor) p.x0(arrayList);
        }
        throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name name);

    @Override // kotlin.jvm.internal.d
    public abstract /* synthetic */ Class<?> getJClass();

    public abstract PropertyDescriptor getLocalProperty(int i2);

    public abstract /* synthetic */ Collection<c<?>> getMembers();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x001e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.m.g(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L55
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L4e
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.m.c(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L4e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L4e
            kotlin.x r4 = kotlin.x.a
            java.lang.Object r3 = r3.accept(r0, r4)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L4f
        L4e:
            r3 = r1
        L4f:
            if (r3 == 0) goto L1e
            r2.add(r3)
            goto L1e
        L55:
            java.util.List r8 = kotlin.a0.p.I0(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    protected Class<?> getMethodOwner() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive != null ? wrapperByPrimitive : getJClass();
    }

    public abstract Collection<PropertyDescriptor> getProperties(Name name);
}
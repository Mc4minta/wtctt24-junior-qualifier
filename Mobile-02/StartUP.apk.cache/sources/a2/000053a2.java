package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum KFunction uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FunctionClassKind.kt */
/* loaded from: classes3.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    public static final Companion Companion;
    public static final FunctionClassKind Function;
    public static final FunctionClassKind KFunction;
    public static final FunctionClassKind KSuspendFunction;
    public static final FunctionClassKind SuspendFunction;
    private final String classNamePrefix;
    private final FqName packageFqName;

    /* compiled from: FunctionClassKind.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: FunctionClassKind.kt */
        /* loaded from: classes3.dex */
        public static final class KindWithArity {
            private final int arity;
            private final FunctionClassKind kind;

            public KindWithArity(FunctionClassKind kind, int i2) {
                m.g(kind, "kind");
                this.kind = kind;
                this.arity = i2;
            }

            public final FunctionClassKind component1() {
                return this.kind;
            }

            public final int component2() {
                return this.arity;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof KindWithArity) {
                    KindWithArity kindWithArity = (KindWithArity) obj;
                    return this.kind == kindWithArity.kind && this.arity == kindWithArity.arity;
                }
                return false;
            }

            public final FunctionClassKind getKind() {
                return this.kind;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Integer toInt(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                i2++;
                int i4 = charAt - '0';
                if (!(i4 >= 0 && i4 <= 9)) {
                    return null;
                }
                i3 = (i3 * 10) + i4;
            }
            return Integer.valueOf(i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[LOOP:0: B:3:0x0011->B:13:0x0032, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind byClassNamePrefix(kotlin.reflect.jvm.internal.impl.name.FqName r9, java.lang.String r10) {
            /*
                r8 = this;
                java.lang.String r0 = "packageFqName"
                kotlin.jvm.internal.m.g(r9, r0)
                java.lang.String r0 = "className"
                kotlin.jvm.internal.m.g(r10, r0)
                kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind[] r0 = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.values()
                int r1 = r0.length
                r2 = 0
                r3 = r2
            L11:
                r4 = 0
                if (r3 >= r1) goto L35
                r5 = r0[r3]
                kotlin.reflect.jvm.internal.impl.name.FqName r6 = r5.getPackageFqName()
                boolean r6 = kotlin.jvm.internal.m.c(r6, r9)
                if (r6 == 0) goto L2d
                java.lang.String r6 = r5.getClassNamePrefix()
                r7 = 2
                boolean r4 = kotlin.l0.o.Q(r10, r6, r2, r7, r4)
                if (r4 == 0) goto L2d
                r4 = 1
                goto L2e
            L2d:
                r4 = r2
            L2e:
                if (r4 == 0) goto L32
                r4 = r5
                goto L35
            L32:
                int r3 = r3 + 1
                goto L11
            L35:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion.byClassNamePrefix(kotlin.reflect.jvm.internal.impl.name.FqName, java.lang.String):kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind");
        }

        public final FunctionClassKind getFunctionalClassKind(String className, FqName packageFqName) {
            m.g(className, "className");
            m.g(packageFqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(className, packageFqName);
            if (parseClassName == null) {
                return null;
            }
            return parseClassName.getKind();
        }

        public final KindWithArity parseClassName(String className, FqName packageFqName) {
            m.g(className, "className");
            m.g(packageFqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(packageFqName, className);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = className.substring(byClassNamePrefix.getClassNamePrefix().length());
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
            Integer num = toInt(substring);
            if (num == null) {
                return null;
            }
            return new KindWithArity(byClassNamePrefix, num.intValue());
        }
    }

    static {
        FunctionClassKind functionClassKind = new FunctionClassKind("Function", 0, StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function");
        Function = functionClassKind;
        FunctionClassKind functionClassKind2 = new FunctionClassKind("SuspendFunction", 1, StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction");
        SuspendFunction = functionClassKind2;
        FqName fqName = StandardNames.KOTLIN_REFLECT_FQ_NAME;
        FunctionClassKind functionClassKind3 = new FunctionClassKind("KFunction", 2, fqName, "KFunction");
        KFunction = functionClassKind3;
        FunctionClassKind functionClassKind4 = new FunctionClassKind("KSuspendFunction", 3, fqName, "KSuspendFunction");
        KSuspendFunction = functionClassKind4;
        $VALUES = new FunctionClassKind[]{functionClassKind, functionClassKind2, functionClassKind3, functionClassKind4};
        Companion = new Companion(null);
    }

    private FunctionClassKind(String str, int i2, FqName fqName, String str2) {
        this.packageFqName = fqName;
        this.classNamePrefix = str2;
    }

    public static FunctionClassKind valueOf(String value) {
        m.g(value, "value");
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, value);
    }

    public static FunctionClassKind[] values() {
        FunctionClassKind[] functionClassKindArr = $VALUES;
        FunctionClassKind[] functionClassKindArr2 = new FunctionClassKind[functionClassKindArr.length];
        System.arraycopy(functionClassKindArr, 0, functionClassKindArr2, 0, functionClassKindArr.length);
        return functionClassKindArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int i2) {
        Name identifier = Name.identifier(m.o(this.classNamePrefix, Integer.valueOf(i2)));
        m.f(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }
}
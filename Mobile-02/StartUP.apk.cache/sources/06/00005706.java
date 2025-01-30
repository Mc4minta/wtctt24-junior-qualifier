package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: FqNamesUtil.kt */
/* loaded from: classes3.dex */
public final class FqNamesUtilKt {

    /* compiled from: FqNamesUtil.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.valuesCustom().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName packageName) {
        m.g(fqName, "<this>");
        m.g(packageName, "packageName");
        if (m.c(fqName, packageName) || packageName.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        m.f(asString, "this.asString()");
        String asString2 = packageName.asString();
        m.f(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            i2++;
            int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i3 == 1 || i3 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i3 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return state != State.AFTER_DOT;
    }

    public static final FqName tail(FqName fqName, FqName prefix) {
        m.g(fqName, "<this>");
        m.g(prefix, "prefix");
        if (!isSubpackageOf(fqName, prefix) || prefix.isRoot()) {
            return fqName;
        }
        if (m.c(fqName, prefix)) {
            FqName ROOT = FqName.ROOT;
            m.f(ROOT, "ROOT");
            return ROOT;
        }
        String asString = fqName.asString();
        m.f(asString, "asString()");
        String substring = asString.substring(prefix.asString().length() + 1);
        m.f(substring, "(this as java.lang.String).substring(startIndex)");
        return new FqName(substring);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        boolean Q;
        Q = x.Q(str, str2, false, 2, null);
        return Q && str.charAt(str2.length()) == '.';
    }
}
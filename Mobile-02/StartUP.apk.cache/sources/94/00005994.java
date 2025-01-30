package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Objects;
import kotlin.i0.c;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;

/* compiled from: capitalizeDecapitalize.kt */
/* loaded from: classes3.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String str) {
        m.g(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(upperCase) + substring;
        }
        return str;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        m.g(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt <= 'Z') {
            z = true;
        }
        if (z) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(lowerCase) + substring;
        }
        return str;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        String x;
        c b0;
        Integer num;
        m.g(str, "<this>");
        if ((str.length() == 0) || !isUpperCaseCharAt(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z)) {
            if (z) {
                return decapitalizeAsciiOnly(str);
            }
            x = x.x(str);
            return x;
        }
        b0 = y.b0(str);
        Iterator<Integer> it = b0.iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!isUpperCaseCharAt(str, num.intValue(), z)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return toLowerCase(str, z);
        }
        int intValue = num2.intValue() - 1;
        String substring = str.substring(0, intValue);
        m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String lowerCase = toLowerCase(substring, z);
        String substring2 = str.substring(intValue);
        m.f(substring2, "(this as java.lang.String).substring(startIndex)");
        return m.o(lowerCase, substring2);
    }

    private static final boolean isUpperCaseCharAt(String str, int i2, boolean z) {
        char charAt = str.charAt(i2);
        if (z) {
            return 'A' <= charAt && charAt <= 'Z';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        m.g(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            i2++;
            if ('A' <= charAt && charAt <= 'Z') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        m.f(sb2, "builder.toString()");
        return sb2;
    }
}
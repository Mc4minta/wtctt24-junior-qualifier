package kotlin.l0;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.h0;

/* compiled from: StringsJVM.kt */
/* loaded from: classes3.dex */
public class x extends w {
    public static boolean A(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean B(String str, String str2, boolean z, int i2, Object obj) {
        boolean A;
        if ((i2 & 2) != 0) {
            z = false;
        }
        A = A(str, str2, z);
        return A;
    }

    public static Comparator<String> C(h0 CASE_INSENSITIVE_ORDER) {
        kotlin.jvm.internal.m.g(CASE_INSENSITIVE_ORDER, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.m.f(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static boolean D(CharSequence isBlank) {
        kotlin.i0.c b0;
        boolean c2;
        boolean z;
        kotlin.jvm.internal.m.g(isBlank, "$this$isBlank");
        if (isBlank.length() != 0) {
            b0 = y.b0(isBlank);
            if (!(b0 instanceof Collection) || !((Collection) b0).isEmpty()) {
                Iterator<Integer> it = b0.iterator();
                while (it.hasNext()) {
                    c2 = b.c(isBlank.charAt(((kotlin.a0.h0) it).c()));
                    if (!c2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean E(String regionMatches, int i2, String other, int i3, int i4, boolean z) {
        kotlin.jvm.internal.m.g(regionMatches, "$this$regionMatches");
        kotlin.jvm.internal.m.g(other, "other");
        if (!z) {
            return regionMatches.regionMatches(i2, other, i3, i4);
        }
        return regionMatches.regionMatches(z, i2, other, i3, i4);
    }

    public static /* synthetic */ boolean F(String str, int i2, String str2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z = false;
        }
        return E(str, i2, str2, i3, i4, z);
    }

    public static String G(CharSequence repeat, int i2) {
        kotlin.jvm.internal.m.g(repeat, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        } else if (i2 != 0) {
            if (i2 != 1) {
                int length = repeat.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(repeat.length() * i2);
                        if (1 <= i2) {
                            while (true) {
                                sb.append(repeat);
                                if (i3 == i2) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        String sb2 = sb.toString();
                        kotlin.jvm.internal.m.f(sb2, "sb.toString()");
                        return sb2;
                    }
                    char charAt = repeat.charAt(0);
                    char[] cArr = new char[i2];
                    for (int i4 = 0; i4 < i2; i4++) {
                        cArr[i4] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return repeat.toString();
        } else {
            return "";
        }
    }

    public static final String H(String replace, char c2, char c3, boolean z) {
        boolean d2;
        kotlin.jvm.internal.m.g(replace, "$this$replace");
        if (!z) {
            String replace2 = replace.replace(c2, c3);
            kotlin.jvm.internal.m.f(replace2, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace2;
        }
        StringBuilder sb = new StringBuilder(replace.length());
        for (int i2 = 0; i2 < replace.length(); i2++) {
            char charAt = replace.charAt(i2);
            d2 = c.d(charAt, c2, z);
            if (d2) {
                charAt = c3;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.m.f(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String I(String replace, String oldValue, String newValue, boolean z) {
        int e0;
        int b2;
        kotlin.jvm.internal.m.g(replace, "$this$replace");
        kotlin.jvm.internal.m.g(oldValue, "oldValue");
        kotlin.jvm.internal.m.g(newValue, "newValue");
        int i2 = 0;
        e0 = y.e0(replace, oldValue, 0, z);
        if (e0 < 0) {
            return replace;
        }
        int length = oldValue.length();
        b2 = kotlin.i0.f.b(length, 1);
        int length2 = (replace.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) replace, i2, e0);
                sb.append(newValue);
                i2 = e0 + length;
                if (e0 >= replace.length()) {
                    break;
                }
                e0 = y.e0(replace, oldValue, e0 + b2, z);
            } while (e0 > 0);
            sb.append((CharSequence) replace, i2, replace.length());
            String sb2 = sb.toString();
            kotlin.jvm.internal.m.f(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String J(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return H(str, c2, c3, z);
    }

    public static /* synthetic */ String K(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return I(str, str2, str3, z);
    }

    public static final String L(String replaceFirst, String oldValue, String newValue, boolean z) {
        int i0;
        kotlin.jvm.internal.m.g(replaceFirst, "$this$replaceFirst");
        kotlin.jvm.internal.m.g(oldValue, "oldValue");
        kotlin.jvm.internal.m.g(newValue, "newValue");
        i0 = y.i0(replaceFirst, oldValue, 0, z, 2, null);
        return i0 < 0 ? replaceFirst : y.E0(replaceFirst, i0, oldValue.length() + i0, newValue).toString();
    }

    public static /* synthetic */ String M(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return L(str, str2, str3, z);
    }

    public static boolean N(String startsWith, String prefix, int i2, boolean z) {
        kotlin.jvm.internal.m.g(startsWith, "$this$startsWith");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix, i2);
        }
        return E(startsWith, i2, prefix, 0, prefix.length(), z);
    }

    public static boolean O(String startsWith, String prefix, boolean z) {
        kotlin.jvm.internal.m.g(startsWith, "$this$startsWith");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix);
        }
        return E(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean P(String str, String str2, int i2, boolean z, int i3, Object obj) {
        boolean N;
        if ((i3 & 4) != 0) {
            z = false;
        }
        N = N(str, str2, i2, z);
        return N;
    }

    public static /* synthetic */ boolean Q(String str, String str2, boolean z, int i2, Object obj) {
        boolean O;
        if ((i2 & 2) != 0) {
            z = false;
        }
        O = O(str, str2, z);
        return O;
    }

    public static String v(String capitalize) {
        kotlin.jvm.internal.m.g(capitalize, "$this$capitalize");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.m.f(locale, "Locale.getDefault()");
        return w(capitalize, locale);
    }

    public static final String w(String capitalize, Locale locale) {
        kotlin.jvm.internal.m.g(capitalize, "$this$capitalize");
        kotlin.jvm.internal.m.g(locale, "locale");
        if (capitalize.length() > 0) {
            char charAt = capitalize.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = capitalize.substring(0, 1);
                    kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = substring.toUpperCase(locale);
                    kotlin.jvm.internal.m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = capitalize.substring(1);
                kotlin.jvm.internal.m.f(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                kotlin.jvm.internal.m.f(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            return capitalize;
        }
        return capitalize;
    }

    public static String x(String decapitalize) {
        kotlin.jvm.internal.m.g(decapitalize, "$this$decapitalize");
        if (!(decapitalize.length() > 0) || Character.isLowerCase(decapitalize.charAt(0))) {
            return decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = decapitalize.substring(0, 1);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase();
        kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = decapitalize.substring(1);
        kotlin.jvm.internal.m.f(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    public static final boolean y(String endsWith, String suffix, boolean z) {
        kotlin.jvm.internal.m.g(endsWith, "$this$endsWith");
        kotlin.jvm.internal.m.g(suffix, "suffix");
        if (!z) {
            return endsWith.endsWith(suffix);
        }
        return E(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean z(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return y(str, str2, z);
    }
}
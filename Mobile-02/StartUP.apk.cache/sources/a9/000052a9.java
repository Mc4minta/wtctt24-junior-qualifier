package kotlin.l0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public class y extends x {

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.p<CharSequence, Integer, kotlin.o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] a;

        /* renamed from: b */
        final /* synthetic */ boolean f17379b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z) {
            super(2);
            this.a = cArr;
            this.f17379b = z;
        }

        public final kotlin.o<Integer, Integer> a(CharSequence receiver, int i2) {
            kotlin.jvm.internal.m.g(receiver, "$receiver");
            int j0 = y.j0(receiver, this.a, i2, this.f17379b);
            if (j0 < 0) {
                return null;
            }
            return kotlin.u.a(Integer.valueOf(j0), 1);
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ kotlin.o<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.p<CharSequence, Integer, kotlin.o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List a;

        /* renamed from: b */
        final /* synthetic */ boolean f17380b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, boolean z) {
            super(2);
            this.a = list;
            this.f17380b = z;
        }

        public final kotlin.o<Integer, Integer> a(CharSequence receiver, int i2) {
            kotlin.jvm.internal.m.g(receiver, "$receiver");
            kotlin.o a0 = y.a0(receiver, this.a, i2, this.f17380b, false);
            if (a0 != null) {
                return kotlin.u.a(a0.c(), Integer.valueOf(((String) a0.d()).length()));
            }
            return null;
        }

        @Override // kotlin.e0.c.p
        public /* bridge */ /* synthetic */ kotlin.o<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.i0.c, String> {
        final /* synthetic */ CharSequence a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final String invoke(kotlin.i0.c it) {
            kotlin.jvm.internal.m.g(it, "it");
            return y.R0(this.a, it);
        }
    }

    public static String A0(String removePrefix, CharSequence prefix) {
        kotlin.jvm.internal.m.g(removePrefix, "$this$removePrefix");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        if (Q0(removePrefix, prefix, false, 2, null)) {
            String substring = removePrefix.substring(prefix.length());
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return removePrefix;
    }

    public static String B0(String removeSuffix, CharSequence suffix) {
        kotlin.jvm.internal.m.g(removeSuffix, "$this$removeSuffix");
        kotlin.jvm.internal.m.g(suffix, "suffix");
        if (Z(removeSuffix, suffix, false, 2, null)) {
            String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSuffix;
    }

    public static String C0(String removeSurrounding, CharSequence delimiter) {
        kotlin.jvm.internal.m.g(removeSurrounding, "$this$removeSurrounding");
        kotlin.jvm.internal.m.g(delimiter, "delimiter");
        return D0(removeSurrounding, delimiter, delimiter);
    }

    public static final String D0(String removeSurrounding, CharSequence prefix, CharSequence suffix) {
        kotlin.jvm.internal.m.g(removeSurrounding, "$this$removeSurrounding");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(suffix, "suffix");
        if (removeSurrounding.length() >= prefix.length() + suffix.length() && Q0(removeSurrounding, prefix, false, 2, null) && Z(removeSurrounding, suffix, false, 2, null)) {
            String substring = removeSurrounding.substring(prefix.length(), removeSurrounding.length() - suffix.length());
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        return removeSurrounding;
    }

    public static final CharSequence E0(CharSequence replaceRange, int i2, int i3, CharSequence replacement) {
        kotlin.jvm.internal.m.g(replaceRange, "$this$replaceRange");
        kotlin.jvm.internal.m.g(replacement, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(replaceRange, 0, i2);
            kotlin.jvm.internal.m.f(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(replaceRange, i3, replaceRange.length());
            kotlin.jvm.internal.m.f(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    public static CharSequence F0(CharSequence replaceRange, kotlin.i0.c range, CharSequence replacement) {
        kotlin.jvm.internal.m.g(replaceRange, "$this$replaceRange");
        kotlin.jvm.internal.m.g(range, "range");
        kotlin.jvm.internal.m.g(replacement, "replacement");
        return E0(replaceRange, range.r().intValue(), range.q().intValue() + 1, replacement);
    }

    public static final List<String> G0(CharSequence split, char[] delimiters, boolean z, int i2) {
        Iterable<kotlin.i0.c> j2;
        int r;
        kotlin.jvm.internal.m.g(split, "$this$split");
        kotlin.jvm.internal.m.g(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return I0(split, String.valueOf(delimiters[0]), z, i2);
        }
        j2 = kotlin.k0.p.j(x0(split, delimiters, 0, z, i2, 2, null));
        r = kotlin.a0.s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (kotlin.i0.c cVar : j2) {
            arrayList.add(R0(split, cVar));
        }
        return arrayList;
    }

    public static final List<String> H0(CharSequence split, String[] delimiters, boolean z, int i2) {
        Iterable<kotlin.i0.c> j2;
        int r;
        kotlin.jvm.internal.m.g(split, "$this$split");
        kotlin.jvm.internal.m.g(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return I0(split, str, z, i2);
            }
        }
        j2 = kotlin.k0.p.j(y0(split, delimiters, 0, z, i2, 2, null));
        r = kotlin.a0.s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (kotlin.i0.c cVar : j2) {
            arrayList.add(R0(split, cVar));
        }
        return arrayList;
    }

    private static final List<String> I0(CharSequence charSequence, String str, boolean z, int i2) {
        int e0;
        List<String> b2;
        int i3 = 0;
        if (i2 >= 0) {
            e0 = e0(charSequence, str, 0, z);
            if (e0 != -1 && i2 != 1) {
                boolean z2 = i2 > 0;
                ArrayList arrayList = new ArrayList(z2 ? kotlin.i0.f.d(i2, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(i3, e0).toString());
                    i3 = str.length() + e0;
                    if (z2 && arrayList.size() == i2 - 1) {
                        break;
                    }
                    e0 = e0(charSequence, str, i3, z);
                } while (e0 != -1);
                arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                return arrayList;
            }
            b2 = kotlin.a0.q.b(charSequence.toString());
            return b2;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ List J0(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return G0(charSequence, cArr, z, i2);
    }

    public static /* synthetic */ List K0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return H0(charSequence, strArr, z, i2);
    }

    public static final kotlin.k0.h<String> L0(CharSequence splitToSequence, String[] delimiters, boolean z, int i2) {
        kotlin.k0.h<String> v;
        kotlin.jvm.internal.m.g(splitToSequence, "$this$splitToSequence");
        kotlin.jvm.internal.m.g(delimiters, "delimiters");
        v = kotlin.k0.p.v(y0(splitToSequence, delimiters, 0, z, i2, 2, null), new c(splitToSequence));
        return v;
    }

    public static /* synthetic */ kotlin.k0.h M0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return L0(charSequence, strArr, z, i2);
    }

    public static final boolean N0(CharSequence startsWith, char c2, boolean z) {
        boolean d2;
        kotlin.jvm.internal.m.g(startsWith, "$this$startsWith");
        if (startsWith.length() > 0) {
            d2 = kotlin.l0.c.d(startsWith.charAt(0), c2, z);
            return d2;
        }
        return false;
    }

    public static final boolean O0(CharSequence startsWith, CharSequence prefix, boolean z) {
        boolean Q;
        kotlin.jvm.internal.m.g(startsWith, "$this$startsWith");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        if (!z && (startsWith instanceof String) && (prefix instanceof String)) {
            Q = x.Q((String) startsWith, (String) prefix, false, 2, null);
            return Q;
        }
        return z0(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean P0(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return N0(charSequence, c2, z);
    }

    public static /* synthetic */ boolean Q0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return O0(charSequence, charSequence2, z);
    }

    public static final String R0(CharSequence substring, kotlin.i0.c range) {
        kotlin.jvm.internal.m.g(substring, "$this$substring");
        kotlin.jvm.internal.m.g(range, "range");
        return substring.subSequence(range.r().intValue(), range.q().intValue() + 1).toString();
    }

    public static final boolean S(CharSequence contains, char c2, boolean z) {
        int h0;
        kotlin.jvm.internal.m.g(contains, "$this$contains");
        h0 = h0(contains, c2, 0, z, 2, null);
        return h0 >= 0;
    }

    public static String S0(String substring, kotlin.i0.c range) {
        kotlin.jvm.internal.m.g(substring, "$this$substring");
        kotlin.jvm.internal.m.g(range, "range");
        String substring2 = substring.substring(range.r().intValue(), range.q().intValue() + 1);
        kotlin.jvm.internal.m.f(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    public static boolean T(CharSequence contains, CharSequence other, boolean z) {
        int i0;
        kotlin.jvm.internal.m.g(contains, "$this$contains");
        kotlin.jvm.internal.m.g(other, "other");
        if (other instanceof String) {
            i0 = i0(contains, (String) other, 0, z, 2, null);
            if (i0 >= 0) {
                return true;
            }
        } else if (g0(contains, other, 0, contains.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static final String T0(String substringAfter, char c2, String missingDelimiterValue) {
        int h0;
        kotlin.jvm.internal.m.g(substringAfter, "$this$substringAfter");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        h0 = h0(substringAfter, c2, 0, false, 6, null);
        if (h0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(h0 + 1, substringAfter.length());
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean U(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return S(charSequence, c2, z);
    }

    public static String U0(String substringAfter, String delimiter, String missingDelimiterValue) {
        int i0;
        kotlin.jvm.internal.m.g(substringAfter, "$this$substringAfter");
        kotlin.jvm.internal.m.g(delimiter, "delimiter");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        i0 = i0(substringAfter, delimiter, 0, false, 6, null);
        if (i0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(i0 + delimiter.length(), substringAfter.length());
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean V(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        boolean T;
        if ((i2 & 2) != 0) {
            z = false;
        }
        T = T(charSequence, charSequence2, z);
        return T;
    }

    public static /* synthetic */ String V0(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return T0(str, c2, str2);
    }

    public static final boolean W(CharSequence endsWith, char c2, boolean z) {
        int c0;
        boolean d2;
        kotlin.jvm.internal.m.g(endsWith, "$this$endsWith");
        if (endsWith.length() > 0) {
            c0 = c0(endsWith);
            d2 = kotlin.l0.c.d(endsWith.charAt(c0), c2, z);
            if (d2) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ String W0(String str, String str2, String str3, int i2, Object obj) {
        String U0;
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        U0 = U0(str, str2, str3);
        return U0;
    }

    public static final boolean X(CharSequence endsWith, CharSequence suffix, boolean z) {
        boolean z2;
        kotlin.jvm.internal.m.g(endsWith, "$this$endsWith");
        kotlin.jvm.internal.m.g(suffix, "suffix");
        if (!z && (endsWith instanceof String) && (suffix instanceof String)) {
            z2 = x.z((String) endsWith, (String) suffix, false, 2, null);
            return z2;
        }
        return z0(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static String X0(String substringAfterLast, char c2, String missingDelimiterValue) {
        int m0;
        kotlin.jvm.internal.m.g(substringAfterLast, "$this$substringAfterLast");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        m0 = m0(substringAfterLast, c2, 0, false, 6, null);
        if (m0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(m0 + 1, substringAfterLast.length());
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean Y(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return W(charSequence, c2, z);
    }

    public static final String Y0(String substringAfterLast, String delimiter, String missingDelimiterValue) {
        int n0;
        kotlin.jvm.internal.m.g(substringAfterLast, "$this$substringAfterLast");
        kotlin.jvm.internal.m.g(delimiter, "delimiter");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        n0 = n0(substringAfterLast, delimiter, 0, false, 6, null);
        if (n0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(n0 + delimiter.length(), substringAfterLast.length());
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean Z(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return X(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String Z0(String str, char c2, String str2, int i2, Object obj) {
        String X0;
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        X0 = X0(str, c2, str2);
        return X0;
    }

    public static final kotlin.o<Integer, String> a0(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int c0;
        int d2;
        kotlin.i0.a h2;
        Object obj;
        Object obj2;
        int b2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.a0.p.w0(collection);
            int i0 = !z2 ? i0(charSequence, str, i2, false, 4, null) : n0(charSequence, str, i2, false, 4, null);
            if (i0 < 0) {
                return null;
            }
            return kotlin.u.a(Integer.valueOf(i0), str);
        }
        if (z2) {
            c0 = c0(charSequence);
            d2 = kotlin.i0.f.d(i2, c0);
            h2 = kotlin.i0.f.h(d2, 0);
        } else {
            b2 = kotlin.i0.f.b(i2, 0);
            h2 = new kotlin.i0.c(b2, charSequence.length());
        }
        if (charSequence instanceof String) {
            int i3 = h2.i();
            int k2 = h2.k();
            int l2 = h2.l();
            if (l2 < 0 ? i3 >= k2 : i3 <= k2) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (x.E(str2, 0, (String) charSequence, i3, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (i3 == k2) {
                            break;
                        }
                        i3 += l2;
                    } else {
                        return kotlin.u.a(Integer.valueOf(i3), str3);
                    }
                }
            }
        } else {
            int i4 = h2.i();
            int k3 = h2.k();
            int l3 = h2.l();
            if (l3 < 0 ? i4 >= k3 : i4 <= k3) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (z0(str4, 0, charSequence, i4, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (i4 == k3) {
                            break;
                        }
                        i4 += l3;
                    } else {
                        return kotlin.u.a(Integer.valueOf(i4), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String a1(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return Y0(str, str2, str3);
    }

    public static kotlin.i0.c b0(CharSequence indices) {
        kotlin.jvm.internal.m.g(indices, "$this$indices");
        return new kotlin.i0.c(0, indices.length() - 1);
    }

    public static final String b1(String substringBefore, char c2, String missingDelimiterValue) {
        int h0;
        kotlin.jvm.internal.m.g(substringBefore, "$this$substringBefore");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        h0 = h0(substringBefore, c2, 0, false, 6, null);
        if (h0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, h0);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static int c0(CharSequence lastIndex) {
        kotlin.jvm.internal.m.g(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    public static final String c1(String substringBefore, String delimiter, String missingDelimiterValue) {
        int i0;
        kotlin.jvm.internal.m.g(substringBefore, "$this$substringBefore");
        kotlin.jvm.internal.m.g(delimiter, "delimiter");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        i0 = i0(substringBefore, delimiter, 0, false, 6, null);
        if (i0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, i0);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final int d0(CharSequence indexOf, char c2, int i2, boolean z) {
        kotlin.jvm.internal.m.g(indexOf, "$this$indexOf");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(c2, i2);
        }
        return j0(indexOf, new char[]{c2}, i2, z);
    }

    public static /* synthetic */ String d1(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return b1(str, c2, str2);
    }

    public static int e0(CharSequence indexOf, String string, int i2, boolean z) {
        kotlin.jvm.internal.m.g(indexOf, "$this$indexOf");
        kotlin.jvm.internal.m.g(string, "string");
        if (!z && (indexOf instanceof String)) {
            return ((String) indexOf).indexOf(string, i2);
        }
        return g0(indexOf, string, i2, indexOf.length(), z, false, 16, null);
    }

    public static /* synthetic */ String e1(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return c1(str, str2, str3);
    }

    private static final int f0(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        int c0;
        int d2;
        int b2;
        kotlin.i0.a h2;
        int b3;
        int d3;
        if (!z2) {
            b3 = kotlin.i0.f.b(i2, 0);
            d3 = kotlin.i0.f.d(i3, charSequence.length());
            h2 = new kotlin.i0.c(b3, d3);
        } else {
            c0 = c0(charSequence);
            d2 = kotlin.i0.f.d(i2, c0);
            b2 = kotlin.i0.f.b(i3, 0);
            h2 = kotlin.i0.f.h(d2, b2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int i4 = h2.i();
            int k2 = h2.k();
            int l2 = h2.l();
            if (l2 >= 0) {
                if (i4 > k2) {
                    return -1;
                }
            } else if (i4 < k2) {
                return -1;
            }
            while (!x.E((String) charSequence2, 0, (String) charSequence, i4, charSequence2.length(), z)) {
                if (i4 == k2) {
                    return -1;
                }
                i4 += l2;
            }
            return i4;
        }
        int i5 = h2.i();
        int k3 = h2.k();
        int l3 = h2.l();
        if (l3 >= 0) {
            if (i5 > k3) {
                return -1;
            }
        } else if (i5 < k3) {
            return -1;
        }
        while (!z0(charSequence2, 0, charSequence, i5, charSequence2.length(), z)) {
            if (i5 == k3) {
                return -1;
            }
            i5 += l3;
        }
        return i5;
    }

    public static String f1(String substringBeforeLast, char c2, String missingDelimiterValue) {
        int m0;
        kotlin.jvm.internal.m.g(substringBeforeLast, "$this$substringBeforeLast");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        m0 = m0(substringBeforeLast, c2, 0, false, 6, null);
        if (m0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, m0);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ int g0(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z2 = false;
        }
        return f0(charSequence, charSequence2, i2, i3, z, z2);
    }

    public static String g1(String substringBeforeLast, String delimiter, String missingDelimiterValue) {
        int n0;
        kotlin.jvm.internal.m.g(substringBeforeLast, "$this$substringBeforeLast");
        kotlin.jvm.internal.m.g(delimiter, "delimiter");
        kotlin.jvm.internal.m.g(missingDelimiterValue, "missingDelimiterValue");
        n0 = n0(substringBeforeLast, delimiter, 0, false, 6, null);
        if (n0 == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBeforeLast.substring(0, n0);
        kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int h0(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return d0(charSequence, c2, i2, z);
    }

    public static CharSequence h1(CharSequence trim) {
        boolean c2;
        kotlin.jvm.internal.m.g(trim, "$this$trim");
        int length = trim.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            c2 = kotlin.l0.b.c(trim.charAt(!z ? i2 : length));
            if (z) {
                if (!c2) {
                    break;
                }
                length--;
            } else if (c2) {
                i2++;
            } else {
                z = true;
            }
        }
        return trim.subSequence(i2, length + 1);
    }

    public static /* synthetic */ int i0(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        int e0;
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        e0 = e0(charSequence, str, i2, z);
        return e0;
    }

    public static final int j0(CharSequence indexOfAny, char[] chars, int i2, boolean z) {
        int b2;
        int c0;
        boolean z2;
        boolean d2;
        char Q;
        kotlin.jvm.internal.m.g(indexOfAny, "$this$indexOfAny");
        kotlin.jvm.internal.m.g(chars, "chars");
        if (!z && chars.length == 1 && (indexOfAny instanceof String)) {
            Q = kotlin.a0.n.Q(chars);
            return ((String) indexOfAny).indexOf(Q, i2);
        }
        b2 = kotlin.i0.f.b(i2, 0);
        c0 = c0(indexOfAny);
        if (b2 > c0) {
            return -1;
        }
        while (true) {
            char charAt = indexOfAny.charAt(b2);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                d2 = kotlin.l0.c.d(chars[i3], charAt, z);
                if (d2) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return b2;
            }
            if (b2 == c0) {
                return -1;
            }
            b2++;
        }
    }

    public static final int k0(CharSequence lastIndexOf, char c2, int i2, boolean z) {
        kotlin.jvm.internal.m.g(lastIndexOf, "$this$lastIndexOf");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(c2, i2);
        }
        return o0(lastIndexOf, new char[]{c2}, i2, z);
    }

    public static final int l0(CharSequence lastIndexOf, String string, int i2, boolean z) {
        kotlin.jvm.internal.m.g(lastIndexOf, "$this$lastIndexOf");
        kotlin.jvm.internal.m.g(string, "string");
        if (!z && (lastIndexOf instanceof String)) {
            return ((String) lastIndexOf).lastIndexOf(string, i2);
        }
        return f0(lastIndexOf, string, i2, 0, z, true);
    }

    public static /* synthetic */ int m0(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c0(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return k0(charSequence, c2, i2, z);
    }

    public static /* synthetic */ int n0(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c0(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return l0(charSequence, str, i2, z);
    }

    public static final int o0(CharSequence lastIndexOfAny, char[] chars, int i2, boolean z) {
        int c0;
        int d2;
        boolean d3;
        char Q;
        kotlin.jvm.internal.m.g(lastIndexOfAny, "$this$lastIndexOfAny");
        kotlin.jvm.internal.m.g(chars, "chars");
        if (!z && chars.length == 1 && (lastIndexOfAny instanceof String)) {
            Q = kotlin.a0.n.Q(chars);
            return ((String) lastIndexOfAny).lastIndexOf(Q, i2);
        }
        c0 = c0(lastIndexOfAny);
        for (d2 = kotlin.i0.f.d(i2, c0); d2 >= 0; d2--) {
            char charAt = lastIndexOfAny.charAt(d2);
            int length = chars.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                d3 = kotlin.l0.c.d(chars[i3], charAt, z);
                if (d3) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return d2;
            }
        }
        return -1;
    }

    public static final kotlin.k0.h<String> p0(CharSequence lineSequence) {
        kotlin.jvm.internal.m.g(lineSequence, "$this$lineSequence");
        return M0(lineSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> q0(CharSequence lines) {
        List<String> B;
        kotlin.jvm.internal.m.g(lines, "$this$lines");
        B = kotlin.k0.p.B(p0(lines));
        return B;
    }

    public static final CharSequence r0(CharSequence padEnd, int i2, char c2) {
        kotlin.jvm.internal.m.g(padEnd, "$this$padEnd");
        if (i2 >= 0) {
            if (i2 <= padEnd.length()) {
                return padEnd.subSequence(0, padEnd.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            sb.append(padEnd);
            int length = i2 - padEnd.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static String s0(String padEnd, int i2, char c2) {
        kotlin.jvm.internal.m.g(padEnd, "$this$padEnd");
        return r0(padEnd, i2, c2).toString();
    }

    public static final CharSequence t0(CharSequence padStart, int i2, char c2) {
        kotlin.jvm.internal.m.g(padStart, "$this$padStart");
        if (i2 >= 0) {
            if (i2 <= padStart.length()) {
                return padStart.subSequence(0, padStart.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - padStart.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb.append(padStart);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static String u0(String padStart, int i2, char c2) {
        kotlin.jvm.internal.m.g(padStart, "$this$padStart");
        return t0(padStart, i2, c2).toString();
    }

    private static final kotlin.k0.h<kotlin.i0.c> v0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new e(charSequence, i2, i3, new a(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    private static final kotlin.k0.h<kotlin.i0.c> w0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        List c2;
        if (i3 >= 0) {
            c2 = kotlin.a0.m.c(strArr);
            return new e(charSequence, i2, i3, new b(c2, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    static /* synthetic */ kotlin.k0.h x0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return v0(charSequence, cArr, i2, z, i3);
    }

    static /* synthetic */ kotlin.k0.h y0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return w0(charSequence, strArr, i2, z, i3);
    }

    public static final boolean z0(CharSequence regionMatchesImpl, int i2, CharSequence other, int i3, int i4, boolean z) {
        boolean d2;
        kotlin.jvm.internal.m.g(regionMatchesImpl, "$this$regionMatchesImpl");
        kotlin.jvm.internal.m.g(other, "other");
        if (i3 < 0 || i2 < 0 || i2 > regionMatchesImpl.length() - i4 || i3 > other.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            d2 = kotlin.l0.c.d(regionMatchesImpl.charAt(i2 + i5), other.charAt(i3 + i5), z);
            if (!d2) {
                return false;
            }
        }
        return true;
    }
}
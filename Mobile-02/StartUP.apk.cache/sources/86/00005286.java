package kotlin.l0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.a0.u0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
public class a0 extends z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: _Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<CharSequence, String> {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final String invoke(CharSequence it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toString();
        }
    }

    public static List<String> i1(CharSequence chunked, int i2) {
        kotlin.jvm.internal.m.g(chunked, "$this$chunked");
        return x1(chunked, i2, i2, true);
    }

    public static final String j1(String drop, int i2) {
        int d2;
        kotlin.jvm.internal.m.g(drop, "$this$drop");
        if (i2 >= 0) {
            d2 = kotlin.i0.f.d(i2, drop.length());
            String substring = drop.substring(d2);
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static String k1(String dropLast, int i2) {
        int b2;
        kotlin.jvm.internal.m.g(dropLast, "$this$dropLast");
        if (i2 >= 0) {
            b2 = kotlin.i0.f.b(dropLast.length() - i2, 0);
            return s1(dropLast, b2);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static char l1(CharSequence first) {
        kotlin.jvm.internal.m.g(first, "$this$first");
        if (!(first.length() == 0)) {
            return first.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character m1(CharSequence firstOrNull) {
        kotlin.jvm.internal.m.g(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length() == 0) {
            return null;
        }
        return Character.valueOf(firstOrNull.charAt(0));
    }

    public static Character n1(CharSequence getOrNull, int i2) {
        int c0;
        kotlin.jvm.internal.m.g(getOrNull, "$this$getOrNull");
        if (i2 >= 0) {
            c0 = y.c0(getOrNull);
            if (i2 <= c0) {
                return Character.valueOf(getOrNull.charAt(i2));
            }
        }
        return null;
    }

    public static char o1(CharSequence last) {
        int c0;
        kotlin.jvm.internal.m.g(last, "$this$last");
        if (!(last.length() == 0)) {
            c0 = y.c0(last);
            return last.charAt(c0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char p1(CharSequence single) {
        kotlin.jvm.internal.m.g(single, "$this$single");
        int length = single.length();
        if (length != 0) {
            if (length == 1) {
                return single.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character q1(CharSequence singleOrNull) {
        kotlin.jvm.internal.m.g(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length() == 1) {
            return Character.valueOf(singleOrNull.charAt(0));
        }
        return null;
    }

    public static String r1(String slice, kotlin.i0.c indices) {
        String S0;
        kotlin.jvm.internal.m.g(slice, "$this$slice");
        kotlin.jvm.internal.m.g(indices, "indices");
        if (indices.isEmpty()) {
            return "";
        }
        S0 = y.S0(slice, indices);
        return S0;
    }

    public static final String s1(String take, int i2) {
        int d2;
        kotlin.jvm.internal.m.g(take, "$this$take");
        if (i2 >= 0) {
            d2 = kotlin.i0.f.d(i2, take.length());
            String substring = take.substring(0, d2);
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static String t1(String takeLast, int i2) {
        int d2;
        kotlin.jvm.internal.m.g(takeLast, "$this$takeLast");
        if (i2 >= 0) {
            int length = takeLast.length();
            d2 = kotlin.i0.f.d(i2, length);
            String substring = takeLast.substring(length - d2);
            kotlin.jvm.internal.m.f(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final <C extends Collection<? super Character>> C u1(CharSequence toCollection, C destination) {
        kotlin.jvm.internal.m.g(toCollection, "$this$toCollection");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (int i2 = 0; i2 < toCollection.length(); i2++) {
            destination.add(Character.valueOf(toCollection.charAt(i2)));
        }
        return destination;
    }

    public static List<Character> v1(CharSequence toList) {
        List<Character> g2;
        List<Character> b2;
        List<Character> w1;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length();
        if (length == 0) {
            g2 = kotlin.a0.r.g();
            return g2;
        } else if (length != 1) {
            w1 = w1(toList);
            return w1;
        } else {
            b2 = kotlin.a0.q.b(Character.valueOf(toList.charAt(0)));
            return b2;
        }
    }

    public static List<Character> w1(CharSequence toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        return (List) u1(toMutableList, new ArrayList(toMutableList.length()));
    }

    public static final List<String> x1(CharSequence windowed, int i2, int i3, boolean z) {
        kotlin.jvm.internal.m.g(windowed, "$this$windowed");
        return y1(windowed, i2, i3, z, a.a);
    }

    public static final <R> List<R> y1(CharSequence windowed, int i2, int i3, boolean z, kotlin.e0.c.l<? super CharSequence, ? extends R> transform) {
        kotlin.jvm.internal.m.g(windowed, "$this$windowed");
        kotlin.jvm.internal.m.g(transform, "transform");
        u0.a(i2, i3);
        int length = windowed.length();
        int i4 = 0;
        ArrayList arrayList = new ArrayList((length / i3) + (length % i3 == 0 ? 0 : 1));
        while (i4 >= 0 && length > i4) {
            int i5 = i4 + i2;
            if (i5 < 0 || i5 > length) {
                if (!z) {
                    break;
                }
                i5 = length;
            }
            arrayList.add(transform.invoke(windowed.subSequence(i4, i5)));
            i4 += i3;
        }
        return arrayList;
    }
}
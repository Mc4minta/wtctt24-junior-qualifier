package kotlin.a0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
public class n extends m {

    /* compiled from: Iterables.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterable<T>, kotlin.jvm.internal.n0.a {
        final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.b.a(this.a);
        }
    }

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> implements kotlin.k0.h<T> {
        final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // kotlin.k0.h
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.b.a(this.a);
        }
    }

    /* compiled from: _Arrays.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Iterator<? extends T>> {
        final /* synthetic */ Object[] a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object[] objArr) {
            super(0);
            this.a = objArr;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Iterator<T> invoke() {
            return kotlin.jvm.internal.b.a(this.a);
        }
    }

    public static final int A(int[] lastIndex) {
        kotlin.jvm.internal.m.g(lastIndex, "$this$lastIndex");
        return lastIndex.length - 1;
    }

    public static <T> int B(T[] lastIndex) {
        kotlin.jvm.internal.m.g(lastIndex, "$this$lastIndex");
        return lastIndex.length - 1;
    }

    public static Integer C(int[] getOrNull, int i2) {
        kotlin.jvm.internal.m.g(getOrNull, "$this$getOrNull");
        if (i2 < 0 || i2 > A(getOrNull)) {
            return null;
        }
        return Integer.valueOf(getOrNull[i2]);
    }

    public static <T> T D(T[] getOrNull, int i2) {
        int B;
        kotlin.jvm.internal.m.g(getOrNull, "$this$getOrNull");
        if (i2 >= 0) {
            B = B(getOrNull);
            if (i2 <= B) {
                return getOrNull[i2];
            }
        }
        return null;
    }

    public static final int E(int[] indexOf, int i2) {
        kotlin.jvm.internal.m.g(indexOf, "$this$indexOf");
        int length = indexOf.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == indexOf[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static <T> int F(T[] indexOf, T t) {
        kotlin.jvm.internal.m.g(indexOf, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = indexOf.length;
            while (i2 < length) {
                if (indexOf[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = indexOf.length;
        while (i2 < length2) {
            if (kotlin.jvm.internal.m.c(t, indexOf[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <A extends Appendable> A G(byte[] joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinTo, "$this$joinTo");
        kotlin.jvm.internal.m.g(buffer, "buffer");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (byte b2 : joinTo) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.invoke(Byte.valueOf(b2)));
            } else {
                buffer.append(String.valueOf((int) b2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T, A extends Appendable> A H(T[] joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinTo, "$this$joinTo");
        kotlin.jvm.internal.m.g(buffer, "buffer");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : joinTo) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.l0.p.a(buffer, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String J(byte[] joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinToString, "$this$joinToString");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        String sb = ((StringBuilder) G(joinToString, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.m.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> String K(T[] joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinToString, "$this$joinToString");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        String sb = ((StringBuilder) H(joinToString, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.m.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String L(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.e0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i3 & 2) != 0 ? "" : charSequence2;
        String str2 = (i3 & 4) == 0 ? charSequence3 : "";
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return J(bArr, charSequence, str, str2, i4, charSequence5, lVar);
    }

    public static /* synthetic */ String M(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.e0.c.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i3 & 2) != 0 ? "" : charSequence2;
        String str2 = (i3 & 4) == 0 ? charSequence3 : "";
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return K(objArr, charSequence, str, str2, i4, charSequence5, lVar);
    }

    public static <T> T N(T[] last) {
        int B;
        kotlin.jvm.internal.m.g(last, "$this$last");
        if (!(last.length == 0)) {
            B = B(last);
            return last[B];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int O(int[] lastIndexOf, int i2) {
        kotlin.jvm.internal.m.g(lastIndexOf, "$this$lastIndexOf");
        for (int length = lastIndexOf.length - 1; length >= 0; length--) {
            if (i2 == lastIndexOf[length]) {
                return length;
            }
        }
        return -1;
    }

    public static <T, R> List<R> P(T[] map, kotlin.e0.c.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.g(map, "$this$map");
        kotlin.jvm.internal.m.g(transform, "transform");
        ArrayList arrayList = new ArrayList(map.length);
        for (T t : map) {
            arrayList.add(transform.invoke(t));
        }
        return arrayList;
    }

    public static char Q(char[] single) {
        kotlin.jvm.internal.m.g(single, "$this$single");
        int length = single.length;
        if (length != 0) {
            if (length == 1) {
                return single[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T R(T[] single) {
        kotlin.jvm.internal.m.g(single, "$this$single");
        int length = single.length;
        if (length != 0) {
            if (length == 1) {
                return single[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T S(T[] singleOrNull) {
        kotlin.jvm.internal.m.g(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.length == 1) {
            return singleOrNull[0];
        }
        return null;
    }

    public static byte[] T(byte[] sliceArray, kotlin.i0.c indices) {
        byte[] h2;
        kotlin.jvm.internal.m.g(sliceArray, "$this$sliceArray");
        kotlin.jvm.internal.m.g(indices, "indices");
        if (indices.isEmpty()) {
            return new byte[0];
        }
        h2 = m.h(sliceArray, indices.r().intValue(), indices.q().intValue() + 1);
        return h2;
    }

    public static <T> T[] U(T[] sliceArray, kotlin.i0.c indices) {
        kotlin.jvm.internal.m.g(sliceArray, "$this$sliceArray");
        kotlin.jvm.internal.m.g(indices, "indices");
        return indices.isEmpty() ? (T[]) j.i(sliceArray, 0, 0) : (T[]) j.i(sliceArray, indices.r().intValue(), indices.q().intValue() + 1);
    }

    public static final <T> T[] V(T[] sortedArrayWith, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.g(sortedArrayWith, "$this$sortedArrayWith");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        if (sortedArrayWith.length == 0) {
            return sortedArrayWith;
        }
        T[] tArr = (T[]) Arrays.copyOf(sortedArrayWith, sortedArrayWith.length);
        kotlin.jvm.internal.m.f(tArr, "java.util.Arrays.copyOf(this, size)");
        m.p(tArr, comparator);
        return tArr;
    }

    public static <T> List<T> W(T[] sortedWith, Comparator<? super T> comparator) {
        List<T> c2;
        kotlin.jvm.internal.m.g(sortedWith, "$this$sortedWith");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        c2 = m.c(V(sortedWith, comparator));
        return c2;
    }

    public static final <T, C extends Collection<? super T>> C X(T[] toCollection, C destination) {
        kotlin.jvm.internal.m.g(toCollection, "$this$toCollection");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (T t : toCollection) {
            destination.add(t);
        }
        return destination;
    }

    public static List<Byte> Y(byte[] toList) {
        List<Byte> g2;
        List<Byte> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return h0(toList);
        } else {
            b2 = q.b(Byte.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Character> Z(char[] toList) {
        List<Character> g2;
        List<Character> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return i0(toList);
        } else {
            b2 = q.b(Character.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Double> a0(double[] toList) {
        List<Double> g2;
        List<Double> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return j0(toList);
        } else {
            b2 = q.b(Double.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Float> b0(float[] toList) {
        List<Float> g2;
        List<Float> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return k0(toList);
        } else {
            b2 = q.b(Float.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Integer> c0(int[] toList) {
        List<Integer> g2;
        List<Integer> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return l0(toList);
        } else {
            b2 = q.b(Integer.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Long> d0(long[] toList) {
        List<Long> g2;
        List<Long> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return m0(toList);
        } else {
            b2 = q.b(Long.valueOf(toList[0]));
            return b2;
        }
    }

    public static <T> List<T> e0(T[] toList) {
        List<T> g2;
        List<T> b2;
        List<T> n0;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            n0 = n0(toList);
            return n0;
        } else {
            b2 = q.b(toList[0]);
            return b2;
        }
    }

    public static List<Short> f0(short[] toList) {
        List<Short> g2;
        List<Short> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return o0(toList);
        } else {
            b2 = q.b(Short.valueOf(toList[0]));
            return b2;
        }
    }

    public static List<Boolean> g0(boolean[] toList) {
        List<Boolean> g2;
        List<Boolean> b2;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        int length = toList.length;
        if (length == 0) {
            g2 = r.g();
            return g2;
        } else if (length != 1) {
            return p0(toList);
        } else {
            b2 = q.b(Boolean.valueOf(toList[0]));
            return b2;
        }
    }

    public static final List<Byte> h0(byte[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (byte b2 : toMutableList) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final List<Character> i0(char[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (char c2 : toMutableList) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final List<Double> j0(double[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (double d2 : toMutableList) {
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final List<Float> k0(float[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (float f2 : toMutableList) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final List<Integer> l0(int[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (int i2 : toMutableList) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final List<Long> m0(long[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (long j2 : toMutableList) {
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static <T> List<T> n0(T[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        return new ArrayList(r.d(toMutableList));
    }

    public static final List<Short> o0(short[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (short s : toMutableList) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    public static final List<Boolean> p0(boolean[] toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(toMutableList.length);
        for (boolean z : toMutableList) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static <T> Set<T> q0(T[] toSet) {
        Set<T> b2;
        Set<T> a2;
        int d2;
        kotlin.jvm.internal.m.g(toSet, "$this$toSet");
        int length = toSet.length;
        if (length == 0) {
            b2 = s0.b();
            return b2;
        } else if (length != 1) {
            d2 = l0.d(toSet.length);
            return (Set) X(toSet, new LinkedHashSet(d2));
        } else {
            a2 = r0.a(toSet[0]);
            return a2;
        }
    }

    public static <T> Iterable<T> r(T[] asIterable) {
        List g2;
        kotlin.jvm.internal.m.g(asIterable, "$this$asIterable");
        if (asIterable.length == 0) {
            g2 = r.g();
            return g2;
        }
        return new a(asIterable);
    }

    public static <T> Iterable<e0<T>> r0(T[] withIndex) {
        kotlin.jvm.internal.m.g(withIndex, "$this$withIndex");
        return new f0(new c(withIndex));
    }

    public static <T> kotlin.k0.h<T> s(T[] asSequence) {
        kotlin.k0.h<T> d2;
        kotlin.jvm.internal.m.g(asSequence, "$this$asSequence");
        if (asSequence.length == 0) {
            d2 = kotlin.k0.n.d();
            return d2;
        }
        return new b(asSequence);
    }

    public static <T, R> List<kotlin.o<T, R>> s0(T[] zip, R[] other) {
        kotlin.jvm.internal.m.g(zip, "$this$zip");
        kotlin.jvm.internal.m.g(other, "other");
        int min = Math.min(zip.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(kotlin.u.a(zip[i2], other[i2]));
        }
        return arrayList;
    }

    public static final boolean t(int[] contains, int i2) {
        kotlin.jvm.internal.m.g(contains, "$this$contains");
        return E(contains, i2) >= 0;
    }

    public static <T> boolean u(T[] contains, T t) {
        int F;
        kotlin.jvm.internal.m.g(contains, "$this$contains");
        F = F(contains, t);
        return F >= 0;
    }

    public static final <T> List<T> v(T[] filterNotNull) {
        kotlin.jvm.internal.m.g(filterNotNull, "$this$filterNotNull");
        return (List) w(filterNotNull, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C w(T[] filterNotNullTo, C destination) {
        kotlin.jvm.internal.m.g(filterNotNullTo, "$this$filterNotNullTo");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (T t : filterNotNullTo) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static int x(int[] first) {
        kotlin.jvm.internal.m.g(first, "$this$first");
        if (!(first.length == 0)) {
            return first[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T y(T[] first) {
        kotlin.jvm.internal.m.g(first, "$this$first");
        if (!(first.length == 0)) {
            return first[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T z(T[] firstOrNull) {
        kotlin.jvm.internal.m.g(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.length == 0) {
            return null;
        }
        return firstOrNull[0];
    }
}
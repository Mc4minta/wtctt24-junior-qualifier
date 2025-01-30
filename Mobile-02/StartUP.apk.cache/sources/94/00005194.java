package kotlin.a0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* compiled from: _Collections.kt */
/* loaded from: classes3.dex */
public class z extends y {

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements kotlin.k0.h<T> {
        final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.k0.h
        public Iterator<T> iterator() {
            return this.a.iterator();
        }
    }

    /* compiled from: _Collections.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Integer, T> {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i2) {
            super(1);
            this.a = i2;
        }

        public final T a(int i2) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.a + '.');
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* compiled from: _Collections.kt */
    /* loaded from: classes3.dex */
    public static final class c<T> extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Iterator<? extends T>> {
        final /* synthetic */ Iterable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Iterable iterable) {
            super(0);
            this.a = iterable;
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final Iterator<T> invoke() {
            return this.a.iterator();
        }
    }

    public static <T extends Comparable<? super T>> List<T> A0(Iterable<? extends T> sorted) {
        List<T> c2;
        List<T> I0;
        kotlin.jvm.internal.m.g(sorted, "$this$sorted");
        if (sorted instanceof Collection) {
            Collection collection = (Collection) sorted;
            if (collection.size() <= 1) {
                I0 = I0(sorted);
                return I0;
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Comparable[] comparableArr = (Comparable[]) array;
            m.o(comparableArr);
            c2 = m.c(comparableArr);
            return c2;
        }
        List<T> J0 = J0(sorted);
        v.w(J0);
        return J0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> B0(Iterable<? extends T> sortedWith, Comparator<? super T> comparator) {
        List<T> c2;
        List<T> I0;
        kotlin.jvm.internal.m.g(sortedWith, "$this$sortedWith");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        if (sortedWith instanceof Collection) {
            Collection collection = (Collection) sortedWith;
            if (collection.size() <= 1) {
                I0 = I0(sortedWith);
                return I0;
            }
            Object[] array = collection.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            m.p(array, comparator);
            c2 = m.c(array);
            return c2;
        }
        List<T> J0 = J0(sortedWith);
        v.x(J0, comparator);
        return J0;
    }

    public static <T> Set<T> C0(Iterable<? extends T> subtract, Iterable<? extends T> other) {
        Set<T> L0;
        kotlin.jvm.internal.m.g(subtract, "$this$subtract");
        kotlin.jvm.internal.m.g(other, "other");
        L0 = L0(subtract);
        w.C(L0, other);
        return L0;
    }

    public static final <T> List<T> D0(Iterable<? extends T> take, int i2) {
        List<T> n;
        List<T> b2;
        List<T> I0;
        List<T> g2;
        kotlin.jvm.internal.m.g(take, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            g2 = r.g();
            return g2;
        } else {
            if (take instanceof Collection) {
                if (i2 >= ((Collection) take).size()) {
                    I0 = I0(take);
                    return I0;
                } else if (i2 == 1) {
                    b2 = q.b(p.X(take));
                    return b2;
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            for (T t : take) {
                arrayList.add(t);
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            n = r.n(arrayList);
            return n;
        }
    }

    public static <T> List<T> E0(List<? extends T> takeLast, int i2) {
        List<T> b2;
        List<T> I0;
        List<T> g2;
        kotlin.jvm.internal.m.g(takeLast, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            g2 = r.g();
            return g2;
        } else {
            int size = takeLast.size();
            if (i2 >= size) {
                I0 = I0(takeLast);
                return I0;
            } else if (i2 == 1) {
                b2 = q.b(p.j0(takeLast));
                return b2;
            } else {
                ArrayList arrayList = new ArrayList(i2);
                if (takeLast instanceof RandomAccess) {
                    for (int i3 = size - i2; i3 < size; i3++) {
                        arrayList.add(takeLast.get(i3));
                    }
                } else {
                    ListIterator<? extends T> listIterator = takeLast.listIterator(size - i2);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        }
    }

    public static final <T, C extends Collection<? super T>> C F0(Iterable<? extends T> toCollection, C destination) {
        kotlin.jvm.internal.m.g(toCollection, "$this$toCollection");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (T t : toCollection) {
            destination.add(t);
        }
        return destination;
    }

    public static final <T> HashSet<T> G0(Iterable<? extends T> toHashSet) {
        int r;
        int d2;
        kotlin.jvm.internal.m.g(toHashSet, "$this$toHashSet");
        r = s.r(toHashSet, 12);
        d2 = l0.d(r);
        return (HashSet) F0(toHashSet, new HashSet(d2));
    }

    public static int[] H0(Collection<Integer> toIntArray) {
        kotlin.jvm.internal.m.g(toIntArray, "$this$toIntArray");
        int[] iArr = new int[toIntArray.size()];
        int i2 = 0;
        for (Integer num : toIntArray) {
            iArr[i2] = num.intValue();
            i2++;
        }
        return iArr;
    }

    public static <T> List<T> I0(Iterable<? extends T> toList) {
        List<T> n;
        List<T> g2;
        List<T> b2;
        List<T> K0;
        kotlin.jvm.internal.m.g(toList, "$this$toList");
        if (toList instanceof Collection) {
            Collection collection = (Collection) toList;
            int size = collection.size();
            if (size == 0) {
                g2 = r.g();
                return g2;
            } else if (size != 1) {
                K0 = K0(collection);
                return K0;
            } else {
                b2 = q.b(toList instanceof List ? ((List) toList).get(0) : toList.iterator().next());
                return b2;
            }
        }
        n = r.n(J0(toList));
        return n;
    }

    public static final <T> List<T> J0(Iterable<? extends T> toMutableList) {
        List<T> K0;
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        if (toMutableList instanceof Collection) {
            K0 = K0((Collection) toMutableList);
            return K0;
        }
        return (List) F0(toMutableList, new ArrayList());
    }

    public static <T> List<T> K0(Collection<? extends T> toMutableList) {
        kotlin.jvm.internal.m.g(toMutableList, "$this$toMutableList");
        return new ArrayList(toMutableList);
    }

    public static <T> boolean L(Iterable<? extends T> all, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(all, "$this$all");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        if ((all instanceof Collection) && ((Collection) all).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = all.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke((T) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> L0(Iterable<? extends T> toMutableSet) {
        kotlin.jvm.internal.m.g(toMutableSet, "$this$toMutableSet");
        return toMutableSet instanceof Collection ? new LinkedHashSet((Collection) toMutableSet) : (Set) F0(toMutableSet, new LinkedHashSet());
    }

    public static <T> kotlin.k0.h<T> M(Iterable<? extends T> asSequence) {
        kotlin.jvm.internal.m.g(asSequence, "$this$asSequence");
        return new a(asSequence);
    }

    public static <T> Set<T> M0(Iterable<? extends T> toSet) {
        Set<T> b2;
        Set<T> a2;
        int d2;
        kotlin.jvm.internal.m.g(toSet, "$this$toSet");
        if (toSet instanceof Collection) {
            Collection collection = (Collection) toSet;
            int size = collection.size();
            if (size == 0) {
                b2 = s0.b();
                return b2;
            } else if (size != 1) {
                d2 = l0.d(collection.size());
                return (Set) F0(toSet, new LinkedHashSet(d2));
            } else {
                a2 = r0.a(toSet instanceof List ? ((List) toSet).get(0) : toSet.iterator().next());
                return a2;
            }
        }
        return s0.d((Set) F0(toSet, new LinkedHashSet()));
    }

    public static <T> List<List<T>> N(Iterable<? extends T> chunked, int i2) {
        kotlin.jvm.internal.m.g(chunked, "$this$chunked");
        return O0(chunked, i2, i2, true);
    }

    public static <T> Set<T> N0(Iterable<? extends T> union, Iterable<? extends T> other) {
        Set<T> L0;
        kotlin.jvm.internal.m.g(union, "$this$union");
        kotlin.jvm.internal.m.g(other, "other");
        L0 = L0(union);
        w.y(L0, other);
        return L0;
    }

    public static <T> boolean O(Iterable<? extends T> contains, T t) {
        kotlin.jvm.internal.m.g(contains, "$this$contains");
        if (contains instanceof Collection) {
            return ((Collection) contains).contains(t);
        }
        return c0(contains, t) >= 0;
    }

    public static final <T> List<List<T>> O0(Iterable<? extends T> windowed, int i2, int i3, boolean z) {
        int d2;
        kotlin.jvm.internal.m.g(windowed, "$this$windowed");
        u0.a(i2, i3);
        if ((windowed instanceof RandomAccess) && (windowed instanceof List)) {
            List list = (List) windowed;
            int size = list.size();
            ArrayList arrayList = new ArrayList((size / i3) + (size % i3 == 0 ? 0 : 1));
            int i4 = 0;
            while (i4 >= 0 && size > i4) {
                d2 = kotlin.i0.f.d(i2, size - i4);
                if (d2 < i2 && !z) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(d2);
                for (int i5 = 0; i5 < d2; i5++) {
                    arrayList2.add(list.get(i5 + i4));
                }
                arrayList.add(arrayList2);
                i4 += i3;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator b2 = u0.b(windowed.iterator(), i2, i3, z, false);
        while (b2.hasNext()) {
            arrayList3.add((List) b2.next());
        }
        return arrayList3;
    }

    public static <T> List<T> P(Iterable<? extends T> distinct) {
        Set L0;
        List<T> I0;
        kotlin.jvm.internal.m.g(distinct, "$this$distinct");
        L0 = L0(distinct);
        I0 = I0(L0);
        return I0;
    }

    public static <T> Iterable<e0<T>> P0(Iterable<? extends T> withIndex) {
        kotlin.jvm.internal.m.g(withIndex, "$this$withIndex");
        return new f0(new c(withIndex));
    }

    public static <T> List<T> Q(Iterable<? extends T> drop, int i2) {
        ArrayList arrayList;
        List<T> n;
        List<T> b2;
        List<T> g2;
        List<T> I0;
        kotlin.jvm.internal.m.g(drop, "$this$drop");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            I0 = I0(drop);
            return I0;
        } else {
            if (drop instanceof Collection) {
                Collection collection = (Collection) drop;
                int size = collection.size() - i2;
                if (size <= 0) {
                    g2 = r.g();
                    return g2;
                } else if (size == 1) {
                    b2 = q.b(p.i0(drop));
                    return b2;
                } else {
                    arrayList = new ArrayList(size);
                    if (drop instanceof List) {
                        if (drop instanceof RandomAccess) {
                            int size2 = collection.size();
                            while (i2 < size2) {
                                arrayList.add(((List) drop).get(i2));
                                i2++;
                            }
                        } else {
                            ListIterator listIterator = ((List) drop).listIterator(i2);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        return arrayList;
                    }
                }
            } else {
                arrayList = new ArrayList();
            }
            for (T t : drop) {
                if (i3 >= i2) {
                    arrayList.add(t);
                } else {
                    i3++;
                }
            }
            n = r.n(arrayList);
            return n;
        }
    }

    public static <T, R> List<kotlin.o<T, R>> Q0(Iterable<? extends T> zip, Iterable<? extends R> other) {
        int r;
        int r2;
        kotlin.jvm.internal.m.g(zip, "$this$zip");
        kotlin.jvm.internal.m.g(other, "other");
        Iterator<? extends T> it = zip.iterator();
        Iterator<? extends R> it2 = other.iterator();
        r = s.r(zip, 10);
        r2 = s.r(other, 10);
        ArrayList arrayList = new ArrayList(Math.min(r, r2));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.u.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> List<T> R(List<? extends T> dropLast, int i2) {
        int b2;
        kotlin.jvm.internal.m.g(dropLast, "$this$dropLast");
        if (i2 >= 0) {
            b2 = kotlin.i0.f.b(dropLast.size() - i2, 0);
            return D0(dropLast, b2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static <T> T S(Iterable<? extends T> elementAt, int i2) {
        kotlin.jvm.internal.m.g(elementAt, "$this$elementAt");
        if (elementAt instanceof List) {
            return (T) ((List) elementAt).get(i2);
        }
        return (T) T(elementAt, i2, new b(i2));
    }

    public static final <T> T T(Iterable<? extends T> elementAtOrElse, int i2, kotlin.e0.c.l<? super Integer, ? extends T> defaultValue) {
        int i3;
        kotlin.jvm.internal.m.g(elementAtOrElse, "$this$elementAtOrElse");
        kotlin.jvm.internal.m.g(defaultValue, "defaultValue");
        if (elementAtOrElse instanceof List) {
            List list = (List) elementAtOrElse;
            if (i2 >= 0) {
                i3 = r.i(list);
                if (i2 <= i3) {
                    return (T) list.get(i2);
                }
            }
            return defaultValue.invoke(Integer.valueOf(i2));
        } else if (i2 < 0) {
            return defaultValue.invoke(Integer.valueOf(i2));
        } else {
            int i4 = 0;
            for (T t : elementAtOrElse) {
                int i5 = i4 + 1;
                if (i2 == i4) {
                    return t;
                }
                i4 = i5;
            }
            return defaultValue.invoke(Integer.valueOf(i2));
        }
    }

    public static <T> List<T> U(Iterable<? extends T> filter, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(filter, "$this$filter");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = filter.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> List<T> V(Iterable<? extends T> filterNotNull) {
        kotlin.jvm.internal.m.g(filterNotNull, "$this$filterNotNull");
        return (List) W(filterNotNull, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C W(Iterable<? extends T> filterNotNullTo, C destination) {
        kotlin.jvm.internal.m.g(filterNotNullTo, "$this$filterNotNullTo");
        kotlin.jvm.internal.m.g(destination, "destination");
        for (T t : filterNotNullTo) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static <T> T X(Iterable<? extends T> first) {
        kotlin.jvm.internal.m.g(first, "$this$first");
        if (first instanceof List) {
            return (T) p.Y((List) first);
        }
        Iterator<? extends T> it = first.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T Y(List<? extends T> first) {
        kotlin.jvm.internal.m.g(first, "$this$first");
        if (!first.isEmpty()) {
            return first.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T Z(Iterable<? extends T> firstOrNull) {
        kotlin.jvm.internal.m.g(firstOrNull, "$this$firstOrNull");
        if (firstOrNull instanceof List) {
            List list = (List) firstOrNull;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = firstOrNull.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T a0(List<? extends T> firstOrNull) {
        kotlin.jvm.internal.m.g(firstOrNull, "$this$firstOrNull");
        if (firstOrNull.isEmpty()) {
            return null;
        }
        return firstOrNull.get(0);
    }

    public static <T> T b0(List<? extends T> getOrNull, int i2) {
        int i3;
        kotlin.jvm.internal.m.g(getOrNull, "$this$getOrNull");
        if (i2 >= 0) {
            i3 = r.i(getOrNull);
            if (i2 <= i3) {
                return getOrNull.get(i2);
            }
        }
        return null;
    }

    public static final <T> int c0(Iterable<? extends T> indexOf, T t) {
        kotlin.jvm.internal.m.g(indexOf, "$this$indexOf");
        if (indexOf instanceof List) {
            return ((List) indexOf).indexOf(t);
        }
        int i2 = 0;
        for (T t2 : indexOf) {
            if (i2 < 0) {
                r.q();
            }
            if (kotlin.jvm.internal.m.c(t, t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> Set<T> d0(Iterable<? extends T> intersect, Iterable<? extends T> other) {
        Set<T> L0;
        kotlin.jvm.internal.m.g(intersect, "$this$intersect");
        kotlin.jvm.internal.m.g(other, "other");
        L0 = L0(intersect);
        w.E(L0, other);
        return L0;
    }

    public static final <T, A extends Appendable> A e0(Iterable<? extends T> joinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
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

    public static /* synthetic */ Appendable f0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.e0.c.l lVar, int i3, Object obj) {
        return e0(iterable, appendable, (i3 & 2) != 0 ? ", " : charSequence, (i3 & 4) != 0 ? "" : charSequence2, (i3 & 8) == 0 ? charSequence3 : "", (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : lVar);
    }

    public static <T> String g0(Iterable<? extends T> joinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.e0.c.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.g(joinToString, "$this$joinToString");
        kotlin.jvm.internal.m.g(separator, "separator");
        kotlin.jvm.internal.m.g(prefix, "prefix");
        kotlin.jvm.internal.m.g(postfix, "postfix");
        kotlin.jvm.internal.m.g(truncated, "truncated");
        String sb = ((StringBuilder) e0(joinToString, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.m.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String h0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.e0.c.l lVar, int i3, Object obj) {
        String g0;
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
        g0 = g0(iterable, charSequence, str, str2, i4, charSequence5, lVar);
        return g0;
    }

    public static <T> T i0(Iterable<? extends T> last) {
        kotlin.jvm.internal.m.g(last, "$this$last");
        if (last instanceof List) {
            return (T) p.j0((List) last);
        }
        Iterator<? extends T> it = last.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T j0(List<? extends T> last) {
        int i2;
        kotlin.jvm.internal.m.g(last, "$this$last");
        if (!last.isEmpty()) {
            i2 = r.i(last);
            return last.get(i2);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T k0(Iterable<? extends T> lastOrNull) {
        kotlin.jvm.internal.m.g(lastOrNull, "$this$lastOrNull");
        if (lastOrNull instanceof List) {
            List list = (List) lastOrNull;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = lastOrNull.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        return null;
    }

    public static <T> T l0(List<? extends T> lastOrNull) {
        kotlin.jvm.internal.m.g(lastOrNull, "$this$lastOrNull");
        if (lastOrNull.isEmpty()) {
            return null;
        }
        return lastOrNull.get(lastOrNull.size() - 1);
    }

    public static <T, R> List<R> m0(Iterable<? extends T> map, kotlin.e0.c.l<? super T, ? extends R> transform) {
        int r;
        kotlin.jvm.internal.m.g(map, "$this$map");
        kotlin.jvm.internal.m.g(transform, "transform");
        r = s.r(map, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator<? extends T> it = map.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke((T) it.next()));
        }
        return arrayList;
    }

    public static <T extends Comparable<? super T>> T n0(Iterable<? extends T> maxOrNull) {
        kotlin.jvm.internal.m.g(maxOrNull, "$this$maxOrNull");
        Iterator<? extends T> it = maxOrNull.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    public static <T extends Comparable<? super T>> T o0(Iterable<? extends T> minOrNull) {
        kotlin.jvm.internal.m.g(minOrNull, "$this$minOrNull");
        Iterator<? extends T> it = minOrNull.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    public static <T> List<T> p0(Iterable<? extends T> minus, Iterable<? extends T> elements) {
        List<T> I0;
        kotlin.jvm.internal.m.g(minus, "$this$minus");
        kotlin.jvm.internal.m.g(elements, "elements");
        Collection t = s.t(elements, minus);
        if (t.isEmpty()) {
            I0 = I0(minus);
            return I0;
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : minus) {
            if (!t.contains(t2)) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> q0(Iterable<? extends T> minus, T t) {
        int r;
        kotlin.jvm.internal.m.g(minus, "$this$minus");
        r = s.r(minus, 10);
        ArrayList arrayList = new ArrayList(r);
        boolean z = false;
        for (T t2 : minus) {
            boolean z2 = true;
            if (!z && kotlin.jvm.internal.m.c(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static <T> List<T> r0(Iterable<? extends T> plus, Iterable<? extends T> elements) {
        List<T> t0;
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(elements, "elements");
        if (plus instanceof Collection) {
            t0 = t0((Collection) plus, elements);
            return t0;
        }
        ArrayList arrayList = new ArrayList();
        w.y(arrayList, plus);
        w.y(arrayList, elements);
        return arrayList;
    }

    public static <T> List<T> s0(Iterable<? extends T> plus, T t) {
        List<T> u0;
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        if (plus instanceof Collection) {
            u0 = u0((Collection) plus, t);
            return u0;
        }
        ArrayList arrayList = new ArrayList();
        w.y(arrayList, plus);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> t0(Collection<? extends T> plus, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection = (Collection) elements;
            ArrayList arrayList = new ArrayList(plus.size() + collection.size());
            arrayList.addAll(plus);
            arrayList.addAll(collection);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(plus);
        w.y(arrayList2, elements);
        return arrayList2;
    }

    public static <T> List<T> u0(Collection<? extends T> plus, T t) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        ArrayList arrayList = new ArrayList(plus.size() + 1);
        arrayList.addAll(plus);
        arrayList.add(t);
        return arrayList;
    }

    public static <T> List<T> v0(Iterable<? extends T> reversed) {
        List<T> I0;
        kotlin.jvm.internal.m.g(reversed, "$this$reversed");
        if ((reversed instanceof Collection) && ((Collection) reversed).size() <= 1) {
            I0 = I0(reversed);
            return I0;
        }
        List<T> J0 = J0(reversed);
        y.K(J0);
        return J0;
    }

    public static <T> T w0(Iterable<? extends T> single) {
        kotlin.jvm.internal.m.g(single, "$this$single");
        if (single instanceof List) {
            return (T) p.x0((List) single);
        }
        Iterator<? extends T> it = single.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T x0(List<? extends T> single) {
        kotlin.jvm.internal.m.g(single, "$this$single");
        int size = single.size();
        if (size != 0) {
            if (size == 1) {
                return single.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T y0(Iterable<? extends T> singleOrNull) {
        kotlin.jvm.internal.m.g(singleOrNull, "$this$singleOrNull");
        if (singleOrNull instanceof List) {
            List list = (List) singleOrNull;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = singleOrNull.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                return null;
            }
            return next;
        }
        return null;
    }

    public static <T> T z0(List<? extends T> singleOrNull) {
        kotlin.jvm.internal.m.g(singleOrNull, "$this$singleOrNull");
        if (singleOrNull.size() == 1) {
            return singleOrNull.get(0);
        }
        return null;
    }
}
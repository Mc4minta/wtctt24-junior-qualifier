package kotlin.a0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public class r extends q {
    public static final <T> Collection<T> d(T[] asCollection) {
        kotlin.jvm.internal.m.g(asCollection, "$this$asCollection");
        return new i(asCollection, false);
    }

    public static final <T extends Comparable<? super T>> int e(List<? extends T> binarySearch, T t, int i2, int i3) {
        int c2;
        kotlin.jvm.internal.m.g(binarySearch, "$this$binarySearch");
        o(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            c2 = kotlin.b0.b.c(binarySearch.get(i5), t);
            if (c2 < 0) {
                i2 = i5 + 1;
            } else if (c2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int f(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return e(list, comparable, i2, i3);
    }

    public static <T> List<T> g() {
        return b0.a;
    }

    public static kotlin.i0.c h(Collection<?> indices) {
        kotlin.jvm.internal.m.g(indices, "$this$indices");
        return new kotlin.i0.c(0, indices.size() - 1);
    }

    public static <T> int i(List<? extends T> lastIndex) {
        kotlin.jvm.internal.m.g(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    public static <T> List<T> j(T... elements) {
        List<T> g2;
        List<T> c2;
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements.length > 0) {
            c2 = m.c(elements);
            return c2;
        }
        g2 = g();
        return g2;
    }

    public static <T> List<T> k(T t) {
        List<T> g2;
        List<T> b2;
        if (t != null) {
            b2 = q.b(t);
            return b2;
        }
        g2 = g();
        return g2;
    }

    public static <T> List<T> l(T... elements) {
        kotlin.jvm.internal.m.g(elements, "elements");
        return n.v(elements);
    }

    public static <T> List<T> m(T... elements) {
        kotlin.jvm.internal.m.g(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new i(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> n(List<? extends T> optimizeReadOnlyList) {
        List<T> g2;
        List<T> b2;
        kotlin.jvm.internal.m.g(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        if (size == 0) {
            g2 = g();
            return g2;
        } else if (size != 1) {
            return optimizeReadOnlyList;
        } else {
            b2 = q.b(optimizeReadOnlyList.get(0));
            return b2;
        }
    }

    private static final void o(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        } else if (i4 <= i2) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
        }
    }

    public static void p() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void q() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
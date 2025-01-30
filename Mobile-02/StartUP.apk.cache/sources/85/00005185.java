package kotlin.a0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes3.dex */
public class w extends v {
    private static final <T> boolean A(Iterable<? extends T> iterable, kotlin.e0.c.l<? super T, Boolean> lVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (lVar.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    private static final <T> boolean B(List<T> list, kotlin.e0.c.l<? super T, Boolean> lVar, boolean z) {
        int i2;
        int i3;
        int i4;
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return A(kotlin.jvm.internal.i0.b(list), lVar, z);
        }
        i2 = r.i(list);
        if (i2 >= 0) {
            int i5 = 0;
            i3 = 0;
            while (true) {
                T t = list.get(i5);
                if (lVar.invoke(t).booleanValue() != z) {
                    if (i3 != i5) {
                        list.set(i3, t);
                    }
                    i3++;
                }
                if (i5 == i2) {
                    break;
                }
                i5++;
            }
        } else {
            i3 = 0;
        }
        if (i3 >= list.size()) {
            return false;
        }
        i4 = r.i(list);
        if (i4 < i3) {
            return true;
        }
        while (true) {
            list.remove(i4);
            if (i4 == i3) {
                return true;
            }
            i4--;
        }
    }

    public static final <T> boolean C(Collection<? super T> removeAll, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.g(removeAll, "$this$removeAll");
        kotlin.jvm.internal.m.g(elements, "elements");
        return kotlin.jvm.internal.i0.a(removeAll).removeAll(s.t(elements, removeAll));
    }

    public static <T> boolean D(List<T> removeAll, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(removeAll, "$this$removeAll");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        return B(removeAll, predicate, true);
    }

    public static final <T> boolean E(Collection<? super T> retainAll, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.g(retainAll, "$this$retainAll");
        kotlin.jvm.internal.m.g(elements, "elements");
        return kotlin.jvm.internal.i0.a(retainAll).retainAll(s.t(elements, retainAll));
    }

    public static <T> boolean y(Collection<? super T> addAll, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.g(addAll, "$this$addAll");
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements instanceof Collection) {
            return addAll.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean z(Collection<? super T> addAll, T[] elements) {
        List c2;
        kotlin.jvm.internal.m.g(addAll, "$this$addAll");
        kotlin.jvm.internal.m.g(elements, "elements");
        c2 = m.c(elements);
        return addAll.addAll(c2);
    }
}
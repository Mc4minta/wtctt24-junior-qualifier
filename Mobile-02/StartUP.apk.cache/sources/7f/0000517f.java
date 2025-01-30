package kotlin.a0;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sets.kt */
/* loaded from: classes3.dex */
public class t0 extends s0 {
    public static <T> Set<T> f(Set<? extends T> minus, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.g(minus, "$this$minus");
        kotlin.jvm.internal.m.g(elements, "elements");
        Collection<?> t = s.t(elements, minus);
        if (t.isEmpty()) {
            return p.M0(minus);
        }
        if (t instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : minus) {
                if (!t.contains(t2)) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(minus);
        linkedHashSet2.removeAll(t);
        return linkedHashSet2;
    }

    public static <T> Set<T> g(Set<? extends T> minus, T t) {
        kotlin.jvm.internal.m.g(minus, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.d(minus.size()));
        boolean z = false;
        for (T t2 : minus) {
            boolean z2 = true;
            if (!z && kotlin.jvm.internal.m.c(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> h(Set<? extends T> plus, Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        kotlin.jvm.internal.m.g(elements, "elements");
        Integer s = s.s(elements);
        if (s != null) {
            size = plus.size() + s.intValue();
        } else {
            size = plus.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.d(size));
        linkedHashSet.addAll(plus);
        p.y(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static <T> Set<T> i(Set<? extends T> plus, T t) {
        kotlin.jvm.internal.m.g(plus, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.d(plus.size() + 1));
        linkedHashSet.addAll(plus);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
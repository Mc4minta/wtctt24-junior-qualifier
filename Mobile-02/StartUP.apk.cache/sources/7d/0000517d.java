package kotlin.a0;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes3.dex */
public class s0 extends r0 {
    public static <T> Set<T> b() {
        return d0.a;
    }

    public static <T> LinkedHashSet<T> c(T... elements) {
        int d2;
        kotlin.jvm.internal.m.g(elements, "elements");
        d2 = l0.d(elements.length);
        return (LinkedHashSet) n.X(elements, new LinkedHashSet(d2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> d(Set<? extends T> optimizeReadOnlySet) {
        Set<T> b2;
        Set<T> a;
        kotlin.jvm.internal.m.g(optimizeReadOnlySet, "$this$optimizeReadOnlySet");
        int size = optimizeReadOnlySet.size();
        if (size == 0) {
            b2 = b();
            return b2;
        } else if (size != 1) {
            return optimizeReadOnlySet;
        } else {
            a = r0.a(optimizeReadOnlySet.iterator().next());
            return a;
        }
    }

    public static <T> Set<T> e(T... elements) {
        Set<T> b2;
        Set<T> q0;
        kotlin.jvm.internal.m.g(elements, "elements");
        if (elements.length > 0) {
            q0 = n.q0(elements);
            return q0;
        }
        b2 = b();
        return b2;
    }
}
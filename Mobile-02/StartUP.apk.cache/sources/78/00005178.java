package kotlin.a0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes3.dex */
public class q {
    public static final <T> Object[] a(T[] copyToArrayOfAny, boolean z) {
        kotlin.jvm.internal.m.g(copyToArrayOfAny, "$this$copyToArrayOfAny");
        if (z && kotlin.jvm.internal.m.c(copyToArrayOfAny.getClass(), Object[].class)) {
            return copyToArrayOfAny;
        }
        Object[] copyOf = Arrays.copyOf(copyToArrayOfAny, copyToArrayOfAny.length, Object[].class);
        kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.m.f(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static <T> List<T> c(Iterable<? extends T> shuffled) {
        kotlin.jvm.internal.m.g(shuffled, "$this$shuffled");
        List<T> J0 = z.J0(shuffled);
        Collections.shuffle(J0);
        return J0;
    }
}
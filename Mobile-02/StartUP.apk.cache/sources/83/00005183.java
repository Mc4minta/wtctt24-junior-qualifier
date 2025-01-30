package kotlin.a0;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes3.dex */
public class v extends u {
    public static <T extends Comparable<? super T>> void w(List<T> sort) {
        kotlin.jvm.internal.m.g(sort, "$this$sort");
        if (sort.size() > 1) {
            Collections.sort(sort);
        }
    }

    public static <T> void x(List<T> sortWith, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.g(sortWith, "$this$sortWith");
        kotlin.jvm.internal.m.g(comparator, "comparator");
        if (sortWith.size() > 1) {
            Collections.sort(sortWith, comparator);
        }
    }
}
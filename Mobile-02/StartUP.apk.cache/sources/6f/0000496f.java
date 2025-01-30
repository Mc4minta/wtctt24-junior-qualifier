package e.j.f;

import java.util.Collection;
import java.util.List;

/* compiled from: ListExtensions.kt */
/* loaded from: classes2.dex */
public final class p {
    public static final <T> List<T> a(List<? extends T> list, Collection<? extends T> collection) {
        List<T> K0;
        kotlin.jvm.internal.m.g(list, "<this>");
        kotlin.jvm.internal.m.g(collection, "collection");
        K0 = kotlin.a0.z.K0(list);
        K0.addAll(collection);
        return K0;
    }
}
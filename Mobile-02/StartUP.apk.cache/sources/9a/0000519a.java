package kotlin.b0;

import java.util.Comparator;
import java.util.Objects;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public class b {

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    static final class a<T> implements Comparator<T> {
        final /* synthetic */ l[] a;

        a(l[] lVarArr) {
            this.a = lVarArr;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.d(t, t2, this.a);
        }
    }

    public static <T> Comparator<T> b(l<? super T, ? extends Comparable<?>>... selectors) {
        m.g(selectors, "selectors");
        if (selectors.length > 0) {
            return new a(selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static <T extends Comparable<?>> int c(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int d(T t, T t2, l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int c2 = kotlin.b0.a.c(lVar.invoke(t), lVar.invoke(t2));
            if (c2 != 0) {
                return c2;
            }
        }
        return 0;
    }

    public static <T extends Comparable<? super T>> Comparator<T> e() {
        e eVar = e.a;
        Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return eVar;
    }
}
package kotlin.b0;

import java.util.Comparator;
import kotlin.jvm.internal.m;

/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
final class f implements Comparator<Comparable<? super Object>> {
    public static final f a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Comparable<Object> a2, Comparable<Object> b2) {
        m.g(a2, "a");
        m.g(b2, "b");
        return b2.compareTo(a2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.a;
    }
}
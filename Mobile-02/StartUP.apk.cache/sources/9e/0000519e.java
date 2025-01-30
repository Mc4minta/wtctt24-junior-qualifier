package kotlin.b0;

import java.util.Comparator;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public final class e implements Comparator<Comparable<? super Object>> {
    public static final e a = new e();

    private e() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Comparable<Object> a2, Comparable<Object> b2) {
        m.g(a2, "a");
        m.g(b2, "b");
        return a2.compareTo(b2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return f.a;
    }
}
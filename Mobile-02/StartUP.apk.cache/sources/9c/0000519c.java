package kotlin.b0;

import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ComparisonsJvm.kt */
/* loaded from: classes3.dex */
public class c extends b {
    public static <T extends Comparable<? super T>> T f(T a, T b2) {
        m.g(a, "a");
        m.g(b2, "b");
        return a.compareTo(b2) >= 0 ? a : b2;
    }
}
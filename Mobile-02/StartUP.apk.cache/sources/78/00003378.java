package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.g5  reason: invalid package */
/* loaded from: classes2.dex */
final class g5 extends f5 {
    private g5() {
        super();
    }

    private static <E> t4<E> e(Object obj, long j2) {
        return (t4) k7.G(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f5
    public final void a(Object obj, long j2) {
        e(obj, j2).Q0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.p000firebaseperf.f5
    public final <E> void b(Object obj, Object obj2, long j2) {
        t4<E> e2 = e(obj, j2);
        t4<E> e3 = e(obj2, j2);
        int size = e2.size();
        int size2 = e3.size();
        t4<E> t4Var = e2;
        t4Var = e2;
        if (size > 0 && size2 > 0) {
            boolean K = e2.K();
            t4<E> t4Var2 = e2;
            if (!K) {
                t4Var2 = e2.J0(size2 + size);
            }
            t4Var2.addAll(e3);
            t4Var = t4Var2;
        }
        if (size > 0) {
            e3 = t4Var;
        }
        k7.g(obj, j2, e3);
    }
}
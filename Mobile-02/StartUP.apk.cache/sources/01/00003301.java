package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class v1 extends s1 {
    private v1() {
        super();
    }

    private static <E> j1<E> e(Object obj, long j2) {
        return (j1) x3.M(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.s1
    public final void a(Object obj, long j2) {
        e(obj, j2).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.clearcut.s1
    public final <E> void b(Object obj, Object obj2, long j2) {
        j1<E> e2 = e(obj, j2);
        j1<E> e3 = e(obj2, j2);
        int size = e2.size();
        int size2 = e3.size();
        j1<E> j1Var = e2;
        j1Var = e2;
        if (size > 0 && size2 > 0) {
            boolean g2 = e2.g();
            j1<E> j1Var2 = e2;
            if (!g2) {
                j1Var2 = e2.x0(size2 + size);
            }
            j1Var2.addAll(e3);
            j1Var = j1Var2;
        }
        if (size > 0) {
            e3 = j1Var;
        }
        x3.i(obj, j2, e3);
    }
}
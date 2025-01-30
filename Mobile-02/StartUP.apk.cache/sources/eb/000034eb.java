package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class j5 extends d5 {
    private j5() {
        super();
    }

    private static <E> v4<E> e(Object obj, long j2) {
        return (v4) j7.F(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.measurement.d5
    public final <E> void b(Object obj, Object obj2, long j2) {
        v4<E> e2 = e(obj, j2);
        v4<E> e3 = e(obj2, j2);
        int size = e2.size();
        int size2 = e3.size();
        v4<E> v4Var = e2;
        v4Var = e2;
        if (size > 0 && size2 > 0) {
            boolean a = e2.a();
            v4<E> v4Var2 = e2;
            if (!a) {
                v4Var2 = e2.f(size2 + size);
            }
            v4Var2.addAll(e3);
            v4Var = v4Var2;
        }
        if (size > 0) {
            e3 = v4Var;
        }
        j7.j(obj, j2, e3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d5
    public final void d(Object obj, long j2) {
        e(obj, j2).b();
    }
}
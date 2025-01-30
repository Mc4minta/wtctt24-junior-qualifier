package com.google.android.gms.internal.p000firebaseperf;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.r5  reason: invalid package */
/* loaded from: classes2.dex */
final class r5 implements o5 {
    @Override // com.google.android.gms.internal.p000firebaseperf.o5
    public final m5<?, ?> a(Object obj) {
        return ((n5) obj).d();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.o5
    public final Object b(Object obj) {
        ((p5) obj).d();
        return obj;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.o5
    public final Object c(Object obj, Object obj2) {
        p5 p5Var = (p5) obj;
        p5 p5Var2 = (p5) obj2;
        if (!p5Var2.isEmpty()) {
            if (!p5Var.b()) {
                p5Var = p5Var.f();
            }
            p5Var.c(p5Var2);
        }
        return p5Var;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.o5
    public final int d(int i2, Object obj, Object obj2) {
        p5 p5Var = (p5) obj;
        n5 n5Var = (n5) obj2;
        int i3 = 0;
        if (p5Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : p5Var.entrySet()) {
            i3 += n5Var.a(i2, entry.getKey(), entry.getValue());
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.o5
    public final Map<?, ?> e(Object obj) {
        return (p5) obj;
    }
}
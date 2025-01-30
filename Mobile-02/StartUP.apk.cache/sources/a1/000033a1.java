package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k5  reason: invalid package */
/* loaded from: classes2.dex */
final class k5 implements s5 {
    private s5[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(s5... s5VarArr) {
        this.a = s5VarArr;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s5
    public final boolean a(Class<?> cls) {
        for (s5 s5Var : this.a) {
            if (s5Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s5
    public final t5 b(Class<?> cls) {
        s5[] s5VarArr;
        for (s5 s5Var : this.a) {
            if (s5Var.a(cls)) {
                return s5Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
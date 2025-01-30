package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class n5 implements v5 {
    private v5[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n5(v5... v5VarArr) {
        this.a = v5VarArr;
    }

    @Override // com.google.android.gms.internal.measurement.v5
    public final boolean a(Class<?> cls) {
        for (v5 v5Var : this.a) {
            if (v5Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.v5
    public final s5 b(Class<?> cls) {
        v5[] v5VarArr;
        for (v5 v5Var : this.a) {
            if (v5Var.a(cls)) {
                return v5Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
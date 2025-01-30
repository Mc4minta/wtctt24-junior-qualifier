package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class z1 implements h2 {
    private h2[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1(h2... h2VarArr) {
        this.a = h2VarArr;
    }

    @Override // com.google.android.gms.internal.clearcut.h2
    public final boolean a(Class<?> cls) {
        for (h2 h2Var : this.a) {
            if (h2Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.h2
    public final g2 b(Class<?> cls) {
        h2[] h2VarArr;
        for (h2 h2Var : this.a) {
            if (h2Var.a(cls)) {
                return h2Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
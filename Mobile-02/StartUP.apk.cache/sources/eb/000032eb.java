package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class s0 extends r0<e1.d> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final int a(Map.Entry<?, ?> entry) {
        return ((e1.d) entry.getKey()).a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final v0<e1.d> b(Object obj) {
        return ((e1.c) obj).zzjv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final void c(l4 l4Var, Map.Entry<?, ?> entry) throws IOException {
        e1.d dVar = (e1.d) entry.getKey();
        switch (t0.a[dVar.f6401b.ordinal()]) {
            case 1:
                l4Var.q(dVar.a, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                l4Var.r(dVar.a, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                l4Var.F(dVar.a, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                l4Var.p(dVar.a, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                l4Var.E(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                l4Var.h(dVar.a, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                l4Var.t(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                l4Var.I(dVar.a, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                l4Var.G(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                l4Var.S(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                l4Var.D(dVar.a, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                l4Var.A(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                l4Var.d(dVar.a, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                l4Var.E(dVar.a, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                l4Var.M(dVar.a, (a0) entry.getValue());
                return;
            case 16:
                l4Var.m(dVar.a, (String) entry.getValue());
                return;
            case 17:
                l4Var.P(dVar.a, entry.getValue(), u2.a().b(entry.getValue().getClass()));
                return;
            case 18:
                l4Var.N(dVar.a, entry.getValue(), u2.a().b(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final void d(Object obj, v0<e1.d> v0Var) {
        ((e1.c) obj).zzjv = v0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final v0<e1.d> e(Object obj) {
        v0<e1.d> b2 = b(obj);
        if (b2.c()) {
            v0<e1.d> v0Var = (v0) b2.clone();
            d(obj, v0Var);
            return v0Var;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final void f(Object obj) {
        b(obj).t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.r0
    public final boolean g(i2 i2Var) {
        return i2Var instanceof e1.c;
    }
}
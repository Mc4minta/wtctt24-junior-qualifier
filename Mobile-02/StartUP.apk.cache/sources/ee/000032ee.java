package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
final class s3 extends q3<r3, r3> {
    private static void m(Object obj, r3 r3Var) {
        ((e1) obj).zzjp = r3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void a(r3 r3Var, int i2, long j2) {
        r3Var.e(i2 << 3, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void b(r3 r3Var, int i2, a0 a0Var) {
        r3Var.e((i2 << 3) | 2, a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void c(r3 r3Var, l4 l4Var) throws IOException {
        r3Var.g(l4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final void d(Object obj) {
        ((e1) obj).zzjp.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void e(r3 r3Var, l4 l4Var) throws IOException {
        r3Var.b(l4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ r3 f() {
        return r3.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void g(Object obj, r3 r3Var) {
        m(obj, r3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ void h(Object obj, r3 r3Var) {
        m(obj, r3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ r3 i(r3 r3Var, r3 r3Var2) {
        r3 r3Var3 = r3Var;
        r3 r3Var4 = r3Var2;
        return r3Var4.equals(r3.h()) ? r3Var3 : r3.a(r3Var3, r3Var4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ int j(r3 r3Var) {
        return r3Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ r3 k(Object obj) {
        return ((e1) obj).zzjp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.q3
    public final /* synthetic */ int l(r3 r3Var) {
        return r3Var.j();
    }
}
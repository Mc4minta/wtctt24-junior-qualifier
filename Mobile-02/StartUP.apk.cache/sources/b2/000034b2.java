package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class f7 extends d7<c7, c7> {
    private static void m(Object obj, c7 c7Var) {
        ((n4) obj).zzb = c7Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ c7 a() {
        return c7.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ void b(c7 c7Var, int i2, long j2) {
        c7Var.c(i2 << 3, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ void c(c7 c7Var, int i2, h3 h3Var) {
        c7Var.c((i2 << 3) | 2, h3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ void d(c7 c7Var, w7 w7Var) throws IOException {
        c7Var.h(w7Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* bridge */ /* synthetic */ void e(Object obj, c7 c7Var) {
        m(obj, c7Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ c7 f(Object obj) {
        return ((n4) obj).zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ void g(c7 c7Var, w7 w7Var) throws IOException {
        c7Var.e(w7Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ void h(Object obj, c7 c7Var) {
        m(obj, c7Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ c7 i(c7 c7Var, c7 c7Var2) {
        c7 c7Var3 = c7Var;
        c7 c7Var4 = c7Var2;
        return c7Var4.equals(c7.a()) ? c7Var3 : c7.b(c7Var3, c7Var4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final void j(Object obj) {
        ((n4) obj).zzb.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ int k(c7 c7Var) {
        return c7Var.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d7
    public final /* synthetic */ int l(c7 c7Var) {
        return c7Var.k();
    }
}
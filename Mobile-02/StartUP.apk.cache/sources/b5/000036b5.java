package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class p6 implements Runnable {
    private final /* synthetic */ long a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7799b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p6(i6 i6Var, long j2) {
        this.f7799b = i6Var;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i6 i6Var = this.f7799b;
        long j2 = this.a;
        i6Var.d();
        i6Var.b();
        i6Var.y();
        i6Var.f().O().a("Resetting analytics data (FE)");
        u8 v = i6Var.v();
        v.d();
        v.f7895e.a();
        boolean q = i6Var.a.q();
        k4 n = i6Var.n();
        n.f7710k.b(j2);
        if (!TextUtils.isEmpty(n.n().B.a())) {
            n.B.b(null);
        }
        if (com.google.android.gms.internal.measurement.x9.b() && n.o().u(r.z0)) {
            n.w.b(0L);
        }
        if (!n.o().I()) {
            n.B(!q);
        }
        n.C.b(null);
        n.D.b(0L);
        n.E.b(null);
        i6Var.s().Y();
        if (com.google.android.gms.internal.measurement.x9.b() && i6Var.o().u(r.z0)) {
            i6Var.v().f7894d.a();
        }
        i6Var.f7645i = !q;
        this.f7799b.s().S(new AtomicReference<>());
    }
}
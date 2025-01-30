package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
final class t0 implements Runnable {
    private final u0 a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s0 f6143b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(s0 s0Var, u0 u0Var) {
        this.f6143b = s0Var;
        this.a = u0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6143b.f6138b) {
            com.google.android.gms.common.b a = this.a.a();
            if (a.l1()) {
                s0 s0Var = this.f6143b;
                s0Var.a.startActivityForResult(GoogleApiActivity.b(s0Var.b(), a.k1(), this.a.b(), false), 1);
            } else if (this.f6143b.f6141e.j(a.i1())) {
                s0 s0Var2 = this.f6143b;
                s0Var2.f6141e.x(s0Var2.b(), this.f6143b.a, a.i1(), 2, this.f6143b);
            } else if (a.i1() == 18) {
                Dialog r = com.google.android.gms.common.e.r(this.f6143b.b(), this.f6143b);
                s0 s0Var3 = this.f6143b;
                s0Var3.f6141e.t(s0Var3.b().getApplicationContext(), new v0(this, r));
            } else {
                this.f6143b.m(a, this.a.b());
            }
        }
    }
}
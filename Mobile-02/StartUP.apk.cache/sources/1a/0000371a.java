package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y8 implements Runnable {
    long a;

    /* renamed from: b  reason: collision with root package name */
    long f7959b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z8 f7960c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y8(z8 z8Var, long j2, long j3) {
        this.f7960c = z8Var;
        this.a = j2;
        this.f7959b = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7960c.f7971b.l().A(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.b9
            private final y8 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y8 y8Var = this.a;
                z8 z8Var = y8Var.f7960c;
                long j2 = y8Var.a;
                long j3 = y8Var.f7959b;
                z8Var.f7971b.d();
                z8Var.f7971b.f().O().a("Application going to the background");
                if (z8Var.f7971b.o().u(r.G0)) {
                    z8Var.f7971b.n().y.a(true);
                }
                if (!z8Var.f7971b.o().M().booleanValue()) {
                    z8Var.f7971b.f7895e.f(j3);
                    z8Var.f7971b.F(false, false, j3);
                }
                z8Var.f7971b.q().P("auto", "_ab", j2, new Bundle());
            }
        });
    }
}
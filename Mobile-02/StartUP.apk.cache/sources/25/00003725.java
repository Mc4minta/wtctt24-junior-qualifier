package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z8 {
    private y8 a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u8 f7971b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z8(u8 u8Var) {
        this.f7971b = u8Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Handler handler;
        this.f7971b.d();
        if (this.f7971b.o().u(r.s0) && this.a != null) {
            handler = this.f7971b.f7893c;
            handler.removeCallbacks(this.a);
        }
        if (this.f7971b.o().u(r.G0)) {
            this.f7971b.n().y.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j2) {
        Handler handler;
        if (this.f7971b.o().u(r.s0)) {
            this.a = new y8(this, this.f7971b.i().a(), j2);
            handler = this.f7971b.f7893c;
            handler.postDelayed(this.a, 2000L);
        }
    }
}
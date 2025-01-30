package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a9 {
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private long f7490b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7491c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ u8 f7492d;

    public a9(u8 u8Var) {
        this.f7492d = u8Var;
        this.f7491c = new d9(this, u8Var.a);
        long b2 = u8Var.i().b();
        this.a = b2;
        this.f7490b = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.f7492d.d();
        d(false, false, this.f7492d.i().b());
        this.f7492d.p().w(this.f7492d.i().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f7491c.e();
        this.a = 0L;
        this.f7490b = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j2) {
        this.f7492d.d();
        this.f7491c.e();
        this.a = j2;
        this.f7490b = j2;
    }

    public final boolean d(boolean z, boolean z2, long j2) {
        this.f7492d.d();
        this.f7492d.y();
        if (!com.google.android.gms.internal.measurement.r9.b() || !this.f7492d.o().u(r.D0)) {
            j2 = this.f7492d.i().b();
        }
        if (!com.google.android.gms.internal.measurement.x9.b() || !this.f7492d.o().u(r.z0) || this.f7492d.a.q()) {
            this.f7492d.n().w.b(this.f7492d.i().a());
        }
        long j3 = j2 - this.a;
        if (!z && j3 < 1000) {
            this.f7492d.f().P().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j3));
            return false;
        }
        if (this.f7492d.o().u(r.V) && !z2) {
            j3 = (com.google.android.gms.internal.measurement.y9.b() && this.f7492d.o().u(r.X) && com.google.android.gms.internal.measurement.r9.b() && this.f7492d.o().u(r.D0)) ? g(j2) : e();
        }
        this.f7492d.f().P().b("Recording user engagement, ms", Long.valueOf(j3));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j3);
        n7.I(this.f7492d.t().L(), bundle, true);
        if (this.f7492d.o().u(r.V) && !this.f7492d.o().u(r.W) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f7492d.o().u(r.W) || !z2) {
            this.f7492d.q().S("auto", "_e", bundle);
        }
        this.a = j2;
        this.f7491c.e();
        this.f7491c.c(3600000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e() {
        long b2 = this.f7492d.i().b();
        long j2 = b2 - this.f7490b;
        this.f7490b = b2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(long j2) {
        this.f7491c.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long g(long j2) {
        long j3 = j2 - this.f7490b;
        this.f7490b = j2;
        return j3;
    }
}
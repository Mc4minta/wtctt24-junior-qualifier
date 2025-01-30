package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u8 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    private Handler f7893c;

    /* renamed from: d  reason: collision with root package name */
    protected final c9 f7894d;

    /* renamed from: e  reason: collision with root package name */
    protected final a9 f7895e;

    /* renamed from: f  reason: collision with root package name */
    private final z8 f7896f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u8(b5 b5Var) {
        super(b5Var);
        this.f7894d = new c9(this);
        this.f7895e = new a9(this);
        this.f7896f = new z8(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        d();
        G();
        f().P().b("Activity resumed, time", Long.valueOf(j2));
        this.f7896f.a();
        if (o().M().booleanValue()) {
            this.f7895e.b(j2);
        }
        c9 c9Var = this.f7894d;
        c9Var.a.d();
        if (c9Var.a.a.q()) {
            if (!c9Var.a.o().u(r.G0)) {
                c9Var.a.n().y.a(false);
            }
            c9Var.b(c9Var.a.i().a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        d();
        if (this.f7893c == null) {
            this.f7893c = new com.google.android.gms.internal.measurement.g8(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(long j2) {
        d();
        G();
        f().P().b("Activity paused, time", Long.valueOf(j2));
        this.f7896f.b(j2);
        if (o().M().booleanValue()) {
            this.f7895e.f(j2);
        }
        c9 c9Var = this.f7894d;
        if (c9Var.a.o().u(r.G0)) {
            return;
        }
        c9Var.a.n().y.a(true);
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return false;
    }

    public final boolean F(boolean z, boolean z2, long j2) {
        return this.f7895e.d(z, z2, j2);
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ s7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ n7 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ t3 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }
}
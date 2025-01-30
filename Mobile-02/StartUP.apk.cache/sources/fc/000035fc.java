package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a extends d2 {

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f7477b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f7478c;

    /* renamed from: d  reason: collision with root package name */
    private long f7479d;

    public a(b5 b5Var) {
        super(b5Var);
        this.f7478c = new c.e.a();
        this.f7477b = new c.e.a();
    }

    private final void B(String str, long j2, o7 o7Var) {
        if (o7Var == null) {
            f().P().a("Not logging ad unit exposure. No active activity");
        } else if (j2 < 1000) {
            f().P().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j2);
            n7.I(o7Var, bundle, true);
            q().S("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        for (String str : this.f7477b.keySet()) {
            this.f7477b.put(str, Long.valueOf(j2));
        }
        if (this.f7477b.isEmpty()) {
            return;
        }
        this.f7479d = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String str, long j2) {
        b();
        d();
        com.google.android.gms.common.internal.t.g(str);
        if (this.f7478c.isEmpty()) {
            this.f7479d = j2;
        }
        Integer num = this.f7478c.get(str);
        if (num != null) {
            this.f7478c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f7478c.size() >= 100) {
            f().K().a("Too many ads visible");
        } else {
            this.f7478c.put(str, 1);
            this.f7477b.put(str, Long.valueOf(j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String str, long j2) {
        b();
        d();
        com.google.android.gms.common.internal.t.g(str);
        Integer num = this.f7478c.get(str);
        if (num != null) {
            o7 L = t().L();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f7478c.remove(str);
                Long l2 = this.f7477b.get(str);
                if (l2 == null) {
                    f().H().a("First ad unit exposure time was never set");
                } else {
                    this.f7477b.remove(str);
                    B(str, j2 - l2.longValue(), L);
                }
                if (this.f7478c.isEmpty()) {
                    long j3 = this.f7479d;
                    if (j3 == 0) {
                        f().H().a("First ad exposure time was never set");
                        return;
                    }
                    x(j2 - j3, L);
                    this.f7479d = 0L;
                    return;
                }
                return;
            }
            this.f7478c.put(str, Integer.valueOf(intValue));
            return;
        }
        f().H().b("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void x(long j2, o7 o7Var) {
        if (o7Var == null) {
            f().P().a("Not logging ad exposure. No active activity");
        } else if (j2 < 1000) {
            f().P().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j2));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j2);
            n7.I(o7Var, bundle, true);
            q().S("am", "_xa", bundle);
        }
    }

    public final void A(String str, long j2) {
        if (str != null && str.length() != 0) {
            l().A(new c1(this, str, j2));
        } else {
            f().H().a("Ad unit id must be a non-empty string");
        }
    }

    public final void E(String str, long j2) {
        if (str != null && str.length() != 0) {
            l().A(new b0(this, str, j2));
        } else {
            f().H().a("Ad unit id must be a non-empty string");
        }
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

    public final void w(long j2) {
        o7 L = t().L();
        for (String str : this.f7477b.keySet()) {
            B(str, j2 - this.f7477b.get(str).longValue(), L);
        }
        if (!this.f7477b.isEmpty()) {
            x(j2 - this.f7479d, L);
        }
        C(j2);
    }
}
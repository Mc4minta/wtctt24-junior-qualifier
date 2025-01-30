package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class ga extends ha {

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.gms.internal.measurement.g0 f7615g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ aa f7616h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(aa aaVar, String str, int i2, com.google.android.gms.internal.measurement.g0 g0Var) {
        super(str, i2);
        this.f7616h = aaVar;
        this.f7615g = g0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ha
    public final int a() {
        return this.f7615g.E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ha
    public final boolean i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ha
    public final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(Long l2, Long l3, com.google.android.gms.internal.measurement.b1 b1Var, boolean z) {
        byte b2 = (com.google.android.gms.internal.measurement.f9.b() && this.f7616h.o().A(this.a, r.h0)) ? (byte) 1 : (byte) 0;
        boolean H = this.f7615g.H();
        boolean I = this.f7615g.I();
        boolean K = this.f7615g.K();
        byte b3 = (H || I || K) ? (byte) 1 : (byte) 0;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && b3 == 0) {
            this.f7616h.f().P().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f7628b), this.f7615g.D() ? Integer.valueOf(this.f7615g.E()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.e0 G = this.f7615g.G();
        boolean I2 = G.I();
        if (b1Var.T()) {
            if (!G.F()) {
                this.f7616h.f().K().b("No number filter for long property. property", this.f7616h.j().B(b1Var.P()));
            } else {
                bool = ha.d(ha.c(b1Var.U(), G.G()), I2);
            }
        } else if (b1Var.V()) {
            if (!G.F()) {
                this.f7616h.f().K().b("No number filter for double property. property", this.f7616h.j().B(b1Var.P()));
            } else {
                bool = ha.d(ha.b(b1Var.W(), G.G()), I2);
            }
        } else if (b1Var.R()) {
            if (!G.D()) {
                if (!G.F()) {
                    this.f7616h.f().K().b("No string or number filter defined. property", this.f7616h.j().B(b1Var.P()));
                } else if (r9.U(b1Var.S())) {
                    bool = ha.d(ha.e(b1Var.S(), G.G()), I2);
                } else {
                    this.f7616h.f().K().c("Invalid user property value for Numeric number filter. property, value", this.f7616h.j().B(b1Var.P()), b1Var.S());
                }
            } else {
                bool = ha.d(ha.g(b1Var.S(), G.E(), this.f7616h.f()), I2);
            }
        } else {
            this.f7616h.f().K().b("User property has no value, property", this.f7616h.j().B(b1Var.P()));
        }
        this.f7616h.f().P().b("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.f7629c = Boolean.TRUE;
        if (!K || bool.booleanValue()) {
            if (!z || this.f7615g.H()) {
                this.f7630d = bool;
            }
            if (bool.booleanValue() && b3 != 0 && b1Var.I()) {
                long J = b1Var.J();
                if (l2 != null) {
                    J = l2.longValue();
                }
                if (b2 != 0 && this.f7615g.H() && !this.f7615g.I() && l3 != null) {
                    J = l3.longValue();
                }
                if (this.f7615g.I()) {
                    this.f7632f = Long.valueOf(J);
                } else {
                    this.f7631e = Long.valueOf(J);
                }
            }
            return true;
        }
        return true;
    }
}
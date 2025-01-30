package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.z0;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class r0 extends n4<r0, a> implements w5 {
    private static final r0 zzh;
    private static volatile g6<r0> zzi;
    private int zzc;
    private int zzd;
    private z0 zze;
    private z0 zzf;
    private boolean zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<r0, a> implements w5 {
        private a() {
            super(r0.zzh);
        }

        public final a u(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((r0) this.f7252b).B(i2);
            return this;
        }

        public final a v(z0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((r0) this.f7252b).F((z0) ((n4) aVar.j()));
            return this;
        }

        public final a w(z0 z0Var) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((r0) this.f7252b).K(z0Var);
            return this;
        }

        public final a x(boolean z) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((r0) this.f7252b).G(z);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        r0 r0Var = new r0();
        zzh = r0Var;
        n4.u(r0.class, r0Var);
    }

    private r0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(z0 z0Var) {
        z0Var.getClass();
        this.zze = z0Var;
        this.zzc |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean z) {
        this.zzc |= 8;
        this.zzg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(z0 z0Var) {
        z0Var.getClass();
        this.zzf = z0Var;
        this.zzc |= 4;
    }

    public static a Q() {
        return zzh.w();
    }

    public final boolean H() {
        return (this.zzc & 1) != 0;
    }

    public final int I() {
        return this.zzd;
    }

    public final z0 L() {
        z0 z0Var = this.zze;
        return z0Var == null ? z0.b0() : z0Var;
    }

    public final boolean M() {
        return (this.zzc & 4) != 0;
    }

    public final z0 N() {
        z0 z0Var = this.zzf;
        return z0Var == null ? z0.b0() : z0Var;
    }

    public final boolean O() {
        return (this.zzc & 8) != 0;
    }

    public final boolean P() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new r0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g6<r0> g6Var = zzi;
                if (g6Var == null) {
                    synchronized (r0.class) {
                        g6Var = zzi;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzh);
                            zzi = g6Var;
                        }
                    }
                }
                return g6Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
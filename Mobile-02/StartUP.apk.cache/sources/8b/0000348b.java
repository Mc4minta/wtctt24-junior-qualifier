package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class d0 extends n4<d0, a> implements w5 {
    private static final d0 zzl;
    private static volatile g6<d0> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private v4<e0> zzf = n4.A();
    private boolean zzg;
    private f0 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<d0, a> implements w5 {
        private a() {
            super(d0.zzl);
        }

        public final a u(int i2, e0 e0Var) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((d0) this.f7252b).C(i2, e0Var);
            return this;
        }

        public final a v(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((d0) this.f7252b).F(str);
            return this;
        }

        public final e0 w(int i2) {
            return ((d0) this.f7252b).B(i2);
        }

        public final String x() {
            return ((d0) this.f7252b).I();
        }

        public final int y() {
            return ((d0) this.f7252b).K();
        }

        /* synthetic */ a(b0 b0Var) {
            this();
        }
    }

    static {
        d0 d0Var = new d0();
        zzl = d0Var;
        n4.u(d0.class, d0Var);
    }

    private d0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2, e0 e0Var) {
        e0Var.getClass();
        if (!this.zzf.a()) {
            this.zzf = n4.q(this.zzf);
        }
        this.zzf.set(i2, e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public static a R() {
        return zzl.w();
    }

    public final e0 B(int i2) {
        return this.zzf.get(i2);
    }

    public final boolean G() {
        return (this.zzc & 1) != 0;
    }

    public final int H() {
        return this.zzd;
    }

    public final String I() {
        return this.zze;
    }

    public final List<e0> J() {
        return this.zzf;
    }

    public final int K() {
        return this.zzf.size();
    }

    public final boolean L() {
        return (this.zzc & 8) != 0;
    }

    public final f0 M() {
        f0 f0Var = this.zzh;
        return f0Var == null ? f0.L() : f0Var;
    }

    public final boolean N() {
        return this.zzi;
    }

    public final boolean O() {
        return this.zzj;
    }

    public final boolean P() {
        return (this.zzc & 64) != 0;
    }

    public final boolean Q() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new d0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", e0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                g6<d0> g6Var = zzm;
                if (g6Var == null) {
                    synchronized (d0.class) {
                        g6Var = zzm;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzl);
                            zzm = g6Var;
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
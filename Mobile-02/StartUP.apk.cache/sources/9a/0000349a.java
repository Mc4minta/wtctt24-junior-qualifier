package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class e0 extends n4<e0, a> implements w5 {
    private static final e0 zzh;
    private static volatile g6<e0> zzi;
    private int zzc;
    private h0 zzd;
    private f0 zze;
    private boolean zzf;
    private String zzg = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<e0, a> implements w5 {
        private a() {
            super(e0.zzh);
        }

        public final a u(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((e0) this.f7252b).C(str);
            return this;
        }

        /* synthetic */ a(b0 b0Var) {
            this();
        }
    }

    static {
        e0 e0Var = new e0();
        zzh = e0Var;
        n4.u(e0.class, e0Var);
    }

    private e0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        str.getClass();
        this.zzc |= 8;
        this.zzg = str;
    }

    public static e0 L() {
        return zzh;
    }

    public final boolean D() {
        return (this.zzc & 1) != 0;
    }

    public final h0 E() {
        h0 h0Var = this.zzd;
        return h0Var == null ? h0.J() : h0Var;
    }

    public final boolean F() {
        return (this.zzc & 2) != 0;
    }

    public final f0 G() {
        f0 f0Var = this.zze;
        return f0Var == null ? f0.L() : f0Var;
    }

    public final boolean H() {
        return (this.zzc & 4) != 0;
    }

    public final boolean I() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzc & 8) != 0;
    }

    public final String K() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new e0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g6<e0> g6Var = zzi;
                if (g6Var == null) {
                    synchronized (e0.class) {
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
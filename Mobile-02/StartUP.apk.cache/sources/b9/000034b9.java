package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class g0 extends n4<g0, a> implements w5 {
    private static final g0 zzj;
    private static volatile g6<g0> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private e0 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<g0, a> implements w5 {
        private a() {
            super(g0.zzj);
        }

        public final a u(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((g0) this.f7252b).C(str);
            return this;
        }

        /* synthetic */ a(b0 b0Var) {
            this();
        }
    }

    static {
        g0 g0Var = new g0();
        zzj = g0Var;
        n4.u(g0.class, g0Var);
    }

    private g0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    public static a L() {
        return zzj.w();
    }

    public final boolean D() {
        return (this.zzc & 1) != 0;
    }

    public final int E() {
        return this.zzd;
    }

    public final String F() {
        return this.zze;
    }

    public final e0 G() {
        e0 e0Var = this.zzf;
        return e0Var == null ? e0.L() : e0Var;
    }

    public final boolean H() {
        return this.zzg;
    }

    public final boolean I() {
        return this.zzh;
    }

    public final boolean J() {
        return (this.zzc & 32) != 0;
    }

    public final boolean K() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new g0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                g6<g0> g6Var = zzk;
                if (g6Var == null) {
                    synchronized (g0.class) {
                        g6Var = zzk;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzj);
                            zzk = g6Var;
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
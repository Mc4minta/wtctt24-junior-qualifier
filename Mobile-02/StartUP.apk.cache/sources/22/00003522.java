package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class n0 extends n4<n0, a> implements w5 {
    private static final n0 zzh;
    private static volatile g6<n0> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<n0, a> implements w5 {
        private a() {
            super(n0.zzh);
        }

        public final int A() {
            return ((n0) this.f7252b).H();
        }

        public final a u(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((n0) this.f7252b).D(str);
            return this;
        }

        public final String v() {
            return ((n0) this.f7252b).B();
        }

        public final boolean w() {
            return ((n0) this.f7252b).E();
        }

        public final boolean x() {
            return ((n0) this.f7252b).F();
        }

        public final boolean y() {
            return ((n0) this.f7252b).G();
        }

        /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    static {
        n0 n0Var = new n0();
        zzh = n0Var;
        n4.u(n0.class, n0Var);
    }

    private n0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final String B() {
        return this.zzd;
    }

    public final boolean E() {
        return this.zze;
    }

    public final boolean F() {
        return this.zzf;
    }

    public final boolean G() {
        return (this.zzc & 8) != 0;
    }

    public final int H() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (m0.a[i2 - 1]) {
            case 1:
                return new n0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g6<n0> g6Var = zzi;
                if (g6Var == null) {
                    synchronized (n0.class) {
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
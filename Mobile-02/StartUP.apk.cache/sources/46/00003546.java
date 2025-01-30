package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class p0 extends n4<p0, a> implements w5 {
    private static final p0 zzf;
    private static volatile g6<p0> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<p0, a> implements w5 {
        private a() {
            super(p0.zzf);
        }

        /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    static {
        p0 p0Var = new p0();
        zzf = p0Var;
        n4.u(p0.class, p0Var);
    }

    private p0() {
    }

    public final String B() {
        return this.zzd;
    }

    public final String C() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (m0.a[i2 - 1]) {
            case 1:
                return new p0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g6<p0> g6Var = zzg;
                if (g6Var == null) {
                    synchronized (p0.class) {
                        g6Var = zzg;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzf);
                            zzg = g6Var;
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
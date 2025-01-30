package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class u0 extends n4<u0, a> implements w5 {
    private static final u0 zzf;
    private static volatile g6<u0> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<u0, a> implements w5 {
        private a() {
            super(u0.zzf);
        }

        public final a u(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((u0) this.f7252b).C(j2);
            return this;
        }

        public final a v(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((u0) this.f7252b).F(str);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        u0 u0Var = new u0();
        zzf = u0Var;
        n4.u(u0.class, u0Var);
    }

    private u0() {
    }

    public static a B() {
        return zzf.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        this.zzc |= 2;
        this.zze = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new u0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g6<u0> g6Var = zzg;
                if (g6Var == null) {
                    synchronized (u0.class) {
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
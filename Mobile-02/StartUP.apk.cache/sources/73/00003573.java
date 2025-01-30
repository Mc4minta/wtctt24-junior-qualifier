package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class s0 extends n4<s0, a> implements w5 {
    private static final s0 zzf;
    private static volatile g6<s0> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<s0, a> implements w5 {
        private a() {
            super(s0.zzf);
        }

        public final a u(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((s0) this.f7252b).B(i2);
            return this;
        }

        public final a v(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((s0) this.f7252b).C(j2);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        s0 s0Var = new s0();
        zzf = s0Var;
        n4.u(s0.class, s0Var);
    }

    private s0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        this.zzc |= 2;
        this.zze = j2;
    }

    public static a J() {
        return zzf.w();
    }

    public final boolean F() {
        return (this.zzc & 1) != 0;
    }

    public final int G() {
        return this.zzd;
    }

    public final boolean H() {
        return (this.zzc & 2) != 0;
    }

    public final long I() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new s0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g6<s0> g6Var = zzg;
                if (g6Var == null) {
                    synchronized (s0.class) {
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
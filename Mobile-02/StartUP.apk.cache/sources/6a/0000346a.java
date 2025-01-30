package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class b1 extends n4<b1, a> implements w5 {
    private static final b1 zzj;
    private static volatile g6<b1> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<b1, a> implements w5 {
        private a() {
            super(b1.zzj);
        }

        public final a A(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).K(j2);
            return this;
        }

        public final a B(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).O(str);
            return this;
        }

        public final a C() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).c0();
            return this;
        }

        public final a u() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).Z();
            return this;
        }

        public final a v(double d2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).B(d2);
            return this;
        }

        public final a w(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).C(j2);
            return this;
        }

        public final a x(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).H(str);
            return this;
        }

        public final a y() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((b1) this.f7252b).b0();
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        b1 b1Var = new b1();
        zzj = b1Var;
        n4.u(b1.class, b1Var);
    }

    private b1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(double d2) {
        this.zzc |= 32;
        this.zzi = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        this.zzc |= 1;
        this.zzd = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(long j2) {
        this.zzc |= 8;
        this.zzg = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String str) {
        str.getClass();
        this.zzc |= 4;
        this.zzf = str;
    }

    public static a X() {
        return zzj.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        this.zzc &= -5;
        this.zzf = zzj.zzf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        this.zzc &= -9;
        this.zzg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        this.zzc &= -33;
        this.zzi = 0.0d;
    }

    public final boolean I() {
        return (this.zzc & 1) != 0;
    }

    public final long J() {
        return this.zzd;
    }

    public final String P() {
        return this.zze;
    }

    public final boolean R() {
        return (this.zzc & 4) != 0;
    }

    public final String S() {
        return this.zzf;
    }

    public final boolean T() {
        return (this.zzc & 8) != 0;
    }

    public final long U() {
        return this.zzg;
    }

    public final boolean V() {
        return (this.zzc & 32) != 0;
    }

    public final double W() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new b1();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                g6<b1> g6Var = zzk;
                if (g6Var == null) {
                    synchronized (b1.class) {
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
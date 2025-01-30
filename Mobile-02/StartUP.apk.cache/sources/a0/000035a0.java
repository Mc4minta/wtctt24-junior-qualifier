package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class v0 extends n4<v0, a> implements w5 {
    private static final v0 zzj;
    private static volatile g6<v0> zzk;
    private int zzc;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private v4<v0> zzi = n4.A();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<v0, a> implements w5 {
        private a() {
            super(v0.zzj);
        }

        public final a A(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).K(str);
            return this;
        }

        public final a B() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).f0();
            return this;
        }

        public final a C(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).P(str);
            return this;
        }

        public final a D() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).g0();
            return this;
        }

        public final int E() {
            return ((v0) this.f7252b).b0();
        }

        public final a F() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).i0();
            return this;
        }

        public final a u() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).e0();
            return this;
        }

        public final a v(double d2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).B(d2);
            return this;
        }

        public final a w(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).C(j2);
            return this;
        }

        public final a x(a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).U((v0) ((n4) aVar.j()));
            return this;
        }

        public final a y(Iterable<? extends v0> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((v0) this.f7252b).J(iterable);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        v0 v0Var = new v0();
        zzj = v0Var;
        n4.u(v0.class, v0Var);
    }

    private v0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(double d2) {
        this.zzc |= 16;
        this.zzh = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j2) {
        this.zzc |= 4;
        this.zzf = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Iterable<? extends v0> iterable) {
        h0();
        x2.k(iterable, this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(v0 v0Var) {
        v0Var.getClass();
        h0();
        this.zzi.add(v0Var);
    }

    public static a c0() {
        return zzj.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        this.zzc &= -3;
        this.zze = zzj.zze;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        this.zzc &= -5;
        this.zzf = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        this.zzc &= -17;
        this.zzh = 0.0d;
    }

    private final void h0() {
        if (this.zzi.a()) {
            return;
        }
        this.zzi = n4.q(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        this.zzi = n4.A();
    }

    public final boolean L() {
        return (this.zzc & 1) != 0;
    }

    public final String M() {
        return this.zzd;
    }

    public final boolean R() {
        return (this.zzc & 2) != 0;
    }

    public final String S() {
        return this.zze;
    }

    public final boolean V() {
        return (this.zzc & 4) != 0;
    }

    public final long W() {
        return this.zzf;
    }

    public final boolean X() {
        return (this.zzc & 16) != 0;
    }

    public final double Y() {
        return this.zzh;
    }

    public final List<v0> Z() {
        return this.zzi;
    }

    public final int b0() {
        return this.zzi.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new v0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", v0.class});
            case 4:
                return zzj;
            case 5:
                g6<v0> g6Var = zzk;
                if (g6Var == null) {
                    synchronized (v0.class) {
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
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class z0 extends n4<z0, a> implements w5 {
    private static final z0 zzg;
    private static volatile g6<z0> zzh;
    private t4 zzc = n4.z();
    private t4 zzd = n4.z();
    private v4<s0> zze = n4.A();
    private v4<a1> zzf = n4.A();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<z0, a> implements w5 {
        private a() {
            super(z0.zzg);
        }

        public final a A(Iterable<? extends Long> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).M(iterable);
            return this;
        }

        public final a B(Iterable<? extends s0> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).P(iterable);
            return this;
        }

        public final a C(Iterable<? extends a1> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).T(iterable);
            return this;
        }

        public final a u() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).d0();
            return this;
        }

        public final a v(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).R(i2);
            return this;
        }

        public final a w(Iterable<? extends Long> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).G(iterable);
            return this;
        }

        public final a x() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).e0();
            return this;
        }

        public final a y(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((z0) this.f7252b).V(i2);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        z0 z0Var = new z0();
        zzg = z0Var;
        n4.u(z0.class, z0Var);
    }

    private z0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(Iterable<? extends Long> iterable) {
        if (!this.zzc.a()) {
            this.zzc = n4.p(this.zzc);
        }
        x2.k(iterable, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Iterable<? extends Long> iterable) {
        if (!this.zzd.a()) {
            this.zzd = n4.p(this.zzd);
        }
        x2.k(iterable, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(Iterable<? extends s0> iterable) {
        f0();
        x2.k(iterable, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(int i2) {
        f0();
        this.zze.remove(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Iterable<? extends a1> iterable) {
        g0();
        x2.k(iterable, this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(int i2) {
        g0();
        this.zzf.remove(i2);
    }

    public static a Z() {
        return zzg.w();
    }

    public static z0 b0() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        this.zzc = n4.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        this.zzd = n4.z();
    }

    private final void f0() {
        if (this.zze.a()) {
            return;
        }
        this.zze = n4.q(this.zze);
    }

    private final void g0() {
        if (this.zzf.a()) {
            return;
        }
        this.zzf = n4.q(this.zzf);
    }

    public final s0 B(int i2) {
        return this.zze.get(i2);
    }

    public final List<Long> C() {
        return this.zzc;
    }

    public final int H() {
        return this.zzc.size();
    }

    public final a1 I(int i2) {
        return this.zzf.get(i2);
    }

    public final List<Long> N() {
        return this.zzd;
    }

    public final int Q() {
        return this.zzd.size();
    }

    public final List<s0> U() {
        return this.zze;
    }

    public final int W() {
        return this.zze.size();
    }

    public final List<a1> X() {
        return this.zzf;
    }

    public final int Y() {
        return this.zzf.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new z0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", s0.class, "zzf", a1.class});
            case 4:
                return zzg;
            case 5:
                g6<z0> g6Var = zzh;
                if (g6Var == null) {
                    synchronized (z0.class) {
                        g6Var = zzh;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzg);
                            zzh = g6Var;
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
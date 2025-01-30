package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.v0;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class t0 extends n4<t0, a> implements w5 {
    private static final t0 zzi;
    private static volatile g6<t0> zzj;
    private int zzc;
    private v4<v0> zzd = n4.A();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<t0, a> implements w5 {
        private a() {
            super(t0.zzi);
        }

        public final a A(Iterable<? extends v0> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).N(iterable);
            return this;
        }

        public final a B(String str) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).O(str);
            return this;
        }

        public final v0 C(int i2) {
            return ((t0) this.f7252b).B(i2);
        }

        public final List<v0> D() {
            return Collections.unmodifiableList(((t0) this.f7252b).C());
        }

        public final int E() {
            return ((t0) this.f7252b).P();
        }

        public final a F(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).Q(i2);
            return this;
        }

        public final a G(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).R(j2);
            return this;
        }

        public final a H() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).e0();
            return this;
        }

        public final String I() {
            return ((t0) this.f7252b).T();
        }

        public final boolean J() {
            return ((t0) this.f7252b).U();
        }

        public final long K() {
            return ((t0) this.f7252b).V();
        }

        public final long L() {
            return ((t0) this.f7252b).X();
        }

        public final a u(int i2, v0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).D(i2, (v0) ((n4) aVar.j()));
            return this;
        }

        public final a v(int i2, v0 v0Var) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).D(i2, v0Var);
            return this;
        }

        public final a w(long j2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).E(j2);
            return this;
        }

        public final a x(v0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).M((v0) ((n4) aVar.j()));
            return this;
        }

        public final a y(v0 v0Var) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((t0) this.f7252b).M(v0Var);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        t0 t0Var = new t0();
        zzi = t0Var;
        n4.u(t0.class, t0Var);
    }

    private t0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i2, v0 v0Var) {
        v0Var.getClass();
        d0();
        this.zzd.set(i2, v0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(long j2) {
        this.zzc |= 2;
        this.zzf = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(v0 v0Var) {
        v0Var.getClass();
        d0();
        this.zzd.add(v0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(Iterable<? extends v0> iterable) {
        d0();
        x2.k(iterable, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int i2) {
        d0();
        this.zzd.remove(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(long j2) {
        this.zzc |= 4;
        this.zzg = j2;
    }

    public static a b0() {
        return zzi.w();
    }

    private final void d0() {
        if (this.zzd.a()) {
            return;
        }
        this.zzd = n4.q(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        this.zzd = n4.A();
    }

    public final v0 B(int i2) {
        return this.zzd.get(i2);
    }

    public final List<v0> C() {
        return this.zzd;
    }

    public final int P() {
        return this.zzd.size();
    }

    public final String T() {
        return this.zze;
    }

    public final boolean U() {
        return (this.zzc & 2) != 0;
    }

    public final long V() {
        return this.zzf;
    }

    public final boolean W() {
        return (this.zzc & 4) != 0;
    }

    public final long X() {
        return this.zzg;
    }

    public final boolean Y() {
        return (this.zzc & 8) != 0;
    }

    public final int Z() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new t0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", v0.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g6<t0> g6Var = zzj;
                if (g6Var == null) {
                    synchronized (t0.class) {
                        g6Var = zzj;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzi);
                            zzj = g6Var;
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
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n0;
import com.google.android.gms.internal.measurement.n4;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class o0 extends n4<o0, a> implements w5 {
    private static final o0 zzl;
    private static volatile g6<o0> zzm;
    private int zzc;
    private long zzd;
    private int zzf;
    private boolean zzk;
    private String zze = "";
    private v4<p0> zzg = n4.A();
    private v4<n0> zzh = n4.A();
    private v4<c0> zzi = n4.A();
    private String zzj = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<o0, a> implements w5 {
        private a() {
            super(o0.zzl);
        }

        public final int u() {
            return ((o0) this.f7252b).K();
        }

        public final n0 v(int i2) {
            return ((o0) this.f7252b).B(i2);
        }

        public final a w(int i2, n0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((o0) this.f7252b).C(i2, (n0) ((n4) aVar.j()));
            return this;
        }

        public final List<c0> x() {
            return Collections.unmodifiableList(((o0) this.f7252b).L());
        }

        public final a y() {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((o0) this.f7252b).Q();
            return this;
        }

        /* synthetic */ a(m0 m0Var) {
            this();
        }
    }

    static {
        o0 o0Var = new o0();
        zzl = o0Var;
        n4.u(o0.class, o0Var);
    }

    private o0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2, n0 n0Var) {
        n0Var.getClass();
        if (!this.zzh.a()) {
            this.zzh = n4.q(this.zzh);
        }
        this.zzh.set(i2, n0Var);
    }

    public static a N() {
        return zzl.w();
    }

    public static o0 O() {
        return zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        this.zzi = n4.A();
    }

    public final n0 B(int i2) {
        return this.zzh.get(i2);
    }

    public final boolean F() {
        return (this.zzc & 1) != 0;
    }

    public final long G() {
        return this.zzd;
    }

    public final boolean H() {
        return (this.zzc & 2) != 0;
    }

    public final String I() {
        return this.zze;
    }

    public final List<p0> J() {
        return this.zzg;
    }

    public final int K() {
        return this.zzh.size();
    }

    public final List<c0> L() {
        return this.zzi;
    }

    public final boolean M() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (m0.a[i2 - 1]) {
            case 1:
                return new o0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", p0.class, "zzh", n0.class, "zzi", c0.class, "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                g6<o0> g6Var = zzm;
                if (g6Var == null) {
                    synchronized (o0.class) {
                        g6Var = zzm;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzl);
                            zzm = g6Var;
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
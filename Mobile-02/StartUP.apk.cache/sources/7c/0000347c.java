package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.d0;
import com.google.android.gms.internal.measurement.g0;
import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class c0 extends n4<c0, a> implements w5 {
    private static final c0 zzi;
    private static volatile g6<c0> zzj;
    private int zzc;
    private int zzd;
    private v4<g0> zze = n4.A();
    private v4<d0> zzf = n4.A();
    private boolean zzg;
    private boolean zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<c0, a> implements w5 {
        private a() {
            super(c0.zzi);
        }

        public final d0 A(int i2) {
            return ((c0) this.f7252b).I(i2);
        }

        public final int u() {
            return ((c0) this.f7252b).K();
        }

        public final a v(int i2, d0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((c0) this.f7252b).C(i2, (d0) ((n4) aVar.j()));
            return this;
        }

        public final a w(int i2, g0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((c0) this.f7252b).D(i2, (g0) ((n4) aVar.j()));
            return this;
        }

        public final g0 x(int i2) {
            return ((c0) this.f7252b).B(i2);
        }

        public final int y() {
            return ((c0) this.f7252b).M();
        }

        /* synthetic */ a(b0 b0Var) {
            this();
        }
    }

    static {
        c0 c0Var = new c0();
        zzi = c0Var;
        n4.u(c0.class, c0Var);
    }

    private c0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2, d0 d0Var) {
        d0Var.getClass();
        if (!this.zzf.a()) {
            this.zzf = n4.q(this.zzf);
        }
        this.zzf.set(i2, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i2, g0 g0Var) {
        g0Var.getClass();
        if (!this.zze.a()) {
            this.zze = n4.q(this.zze);
        }
        this.zze.set(i2, g0Var);
    }

    public final g0 B(int i2) {
        return this.zze.get(i2);
    }

    public final boolean G() {
        return (this.zzc & 1) != 0;
    }

    public final int H() {
        return this.zzd;
    }

    public final d0 I(int i2) {
        return this.zzf.get(i2);
    }

    public final List<g0> J() {
        return this.zze;
    }

    public final int K() {
        return this.zze.size();
    }

    public final List<d0> L() {
        return this.zzf;
    }

    public final int M() {
        return this.zzf.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new c0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", g0.class, "zzf", d0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g6<c0> g6Var = zzj;
                if (g6Var == null) {
                    synchronized (c0.class) {
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
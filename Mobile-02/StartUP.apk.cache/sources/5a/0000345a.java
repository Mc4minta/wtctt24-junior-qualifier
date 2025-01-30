package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class a1 extends n4<a1, a> implements w5 {
    private static final a1 zzf;
    private static volatile g6<a1> zzg;
    private int zzc;
    private int zzd;
    private t4 zze = n4.z();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<a1, a> implements w5 {
        private a() {
            super(a1.zzf);
        }

        public final a u(int i2) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((a1) this.f7252b).H(i2);
            return this;
        }

        public final a v(Iterable<? extends Long> iterable) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((a1) this.f7252b).E(iterable);
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        a1 a1Var = new a1();
        zzf = a1Var;
        n4.u(a1.class, a1Var);
    }

    private a1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Iterable<? extends Long> iterable) {
        if (!this.zze.a()) {
            this.zze = n4.p(this.zze);
        }
        x2.k(iterable, this.zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(int i2) {
        this.zzc |= 1;
        this.zzd = i2;
    }

    public static a K() {
        return zzf.w();
    }

    public final long B(int i2) {
        return this.zze.c(i2);
    }

    public final boolean F() {
        return (this.zzc & 1) != 0;
    }

    public final int G() {
        return this.zzd;
    }

    public final List<Long> I() {
        return this.zze;
    }

    public final int J() {
        return this.zze.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new a1();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                g6<a1> g6Var = zzg;
                if (g6Var == null) {
                    synchronized (a1.class) {
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
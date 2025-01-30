package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class f0 extends n4<f0, a> implements w5 {
    private static final f0 zzi;
    private static volatile g6<f0> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<f0, a> implements w5 {
        private a() {
            super(f0.zzi);
        }

        /* synthetic */ a(b0 b0Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public enum b implements p4 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        

        /* renamed from: f  reason: collision with root package name */
        private static final s4<b> f7123f = new i0();

        /* renamed from: h  reason: collision with root package name */
        private final int f7125h;

        b(int i2) {
            this.f7125h = i2;
        }

        public static b h(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                return null;
                            }
                            return BETWEEN;
                        }
                        return EQUAL;
                    }
                    return GREATER_THAN;
                }
                return LESS_THAN;
            }
            return UNKNOWN_COMPARISON_TYPE;
        }

        public static r4 n() {
            return j0.a;
        }

        @Override // com.google.android.gms.internal.measurement.p4
        public final int a() {
            return this.f7125h;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f7125h + " name=" + name() + '>';
        }
    }

    static {
        f0 f0Var = new f0();
        zzi = f0Var;
        n4.u(f0.class, f0Var);
    }

    private f0() {
    }

    public static f0 L() {
        return zzi;
    }

    public final boolean B() {
        return (this.zzc & 1) != 0;
    }

    public final b C() {
        b h2 = b.h(this.zzd);
        return h2 == null ? b.UNKNOWN_COMPARISON_TYPE : h2;
    }

    public final boolean D() {
        return (this.zzc & 2) != 0;
    }

    public final boolean E() {
        return this.zze;
    }

    public final boolean F() {
        return (this.zzc & 4) != 0;
    }

    public final String G() {
        return this.zzf;
    }

    public final boolean H() {
        return (this.zzc & 8) != 0;
    }

    public final String I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzc & 16) != 0;
    }

    public final String K() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new f0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", b.n(), "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                g6<f0> g6Var = zzj;
                if (g6Var == null) {
                    synchronized (f0.class) {
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
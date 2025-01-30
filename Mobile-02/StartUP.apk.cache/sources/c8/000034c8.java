package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class h0 extends n4<h0, b> implements w5 {
    private static final h0 zzh;
    private static volatile g6<h0> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private v4<String> zzg = n4.A();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public enum a implements p4 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        

        /* renamed from: h  reason: collision with root package name */
        private static final s4<a> f7150h = new l0();

        /* renamed from: k  reason: collision with root package name */
        private final int f7152k;

        a(int i2) {
            this.f7152k = i2;
        }

        public static a h(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public static r4 n() {
            return k0.a;
        }

        @Override // com.google.android.gms.internal.measurement.p4
        public final int a() {
            return this.f7152k;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f7152k + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class b extends n4.a<h0, b> implements w5 {
        private b() {
            super(h0.zzh);
        }

        /* synthetic */ b(b0 b0Var) {
            this();
        }
    }

    static {
        h0 h0Var = new h0();
        zzh = h0Var;
        n4.u(h0.class, h0Var);
    }

    private h0() {
    }

    public static h0 J() {
        return zzh;
    }

    public final boolean B() {
        return (this.zzc & 1) != 0;
    }

    public final a C() {
        a h2 = a.h(this.zzd);
        return h2 == null ? a.UNKNOWN_MATCH_TYPE : h2;
    }

    public final boolean D() {
        return (this.zzc & 2) != 0;
    }

    public final String E() {
        return this.zze;
    }

    public final boolean F() {
        return (this.zzc & 4) != 0;
    }

    public final boolean G() {
        return this.zzf;
    }

    public final List<String> H() {
        return this.zzg;
    }

    public final int I() {
        return this.zzg.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (b0.a[i2 - 1]) {
            case 1:
                return new h0();
            case 2:
                return new b(null);
            case 3:
                return n4.s(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", a.n(), "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                g6<h0> g6Var = zzi;
                if (g6Var == null) {
                    synchronized (h0.class) {
                        g6Var = zzi;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzh);
                            zzi = g6Var;
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
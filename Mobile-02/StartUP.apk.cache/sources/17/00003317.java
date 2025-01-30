package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;

/* loaded from: classes2.dex */
public final class x4 extends e1<x4, a> implements k2 {
    private static final x4 zzbfc;
    private static volatile s2<x4> zzbg;
    private int zzbb;
    private int zzbfa = -1;
    private int zzbfb;

    /* loaded from: classes2.dex */
    public static final class a extends e1.a<x4, a> implements k2 {
        private a() {
            super(x4.zzbfc);
        }

        /* synthetic */ a(z4 z4Var) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public enum b implements h1 {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        private static final i1<b> z = new a5();
        private final int B;

        b(int i2) {
            this.B = i2;
        }

        public static b h(int i2) {
            if (i2 != 100) {
                switch (i2) {
                    case 0:
                        return UNKNOWN_MOBILE_SUBTYPE;
                    case 1:
                        return GPRS;
                    case 2:
                        return EDGE;
                    case 3:
                        return UMTS;
                    case 4:
                        return CDMA;
                    case 5:
                        return EVDO_0;
                    case 6:
                        return EVDO_A;
                    case 7:
                        return RTT;
                    case 8:
                        return HSDPA;
                    case 9:
                        return HSUPA;
                    case 10:
                        return HSPA;
                    case 11:
                        return IDEN;
                    case 12:
                        return EVDO_B;
                    case 13:
                        return LTE;
                    case 14:
                        return EHRPD;
                    case 15:
                        return HSPAP;
                    case 16:
                        return GSM;
                    case 17:
                        return TD_SCDMA;
                    case 18:
                        return IWLAN;
                    case 19:
                        return LTE_CA;
                    default:
                        return null;
                }
            }
            return COMBINED;
        }

        public static i1<b> n() {
            return z;
        }

        @Override // com.google.android.gms.internal.clearcut.h1
        public final int c() {
            return this.B;
        }
    }

    /* loaded from: classes2.dex */
    public enum c implements h1 {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        private static final i1<c> x = new b5();
        private final int z;

        c(int i2) {
            this.z = i2;
        }

        public static c h(int i2) {
            switch (i2) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static i1<c> n() {
            return x;
        }

        @Override // com.google.android.gms.internal.clearcut.h1
        public final int c() {
            return this.z;
        }
    }

    static {
        x4 x4Var = new x4();
        zzbfc = x4Var;
        e1.m(x4.class, x4Var);
    }

    private x4() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.s2<com.google.android.gms.internal.clearcut.x4>, com.google.android.gms.internal.clearcut.e1$b] */
    @Override // com.google.android.gms.internal.clearcut.e1
    public final Object e(int i2, Object obj, Object obj2) {
        s2<x4> s2Var;
        switch (z4.a[i2 - 1]) {
            case 1:
                return new x4();
            case 2:
                return new a(null);
            case 3:
                return e1.g(zzbfc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzbb", "zzbfa", c.n(), "zzbfb", b.n()});
            case 4:
                return zzbfc;
            case 5:
                s2<x4> s2Var2 = zzbg;
                s2<x4> s2Var3 = s2Var2;
                if (s2Var2 == null) {
                    synchronized (x4.class) {
                        s2<x4> s2Var4 = zzbg;
                        s2Var = s2Var4;
                        if (s2Var4 == null) {
                            ?? bVar = new e1.b(zzbfc);
                            zzbg = bVar;
                            s2Var = bVar;
                        }
                    }
                    s2Var3 = s2Var;
                }
                return s2Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
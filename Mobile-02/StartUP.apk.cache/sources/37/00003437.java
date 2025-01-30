package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.x7  reason: invalid package */
/* loaded from: classes2.dex */
public final class x7 extends m4<x7, b> implements x5 {
    private static volatile g6<x7> zzii;
    private static final x7 zzxg;
    private int zzid;
    private int zzxe = -1;
    private int zzxf;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.x7$a */
    /* loaded from: classes2.dex */
    public enum a implements q4 {
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
        
        private static final p4<a> z = new b8();
        private final int B;

        a(int i2) {
            this.B = i2;
        }

        public static s4 h() {
            return a8.a;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.q4
        public final int getNumber() {
            return this.B;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.x7$b */
    /* loaded from: classes2.dex */
    public static final class b extends m4.a<x7, b> implements x5 {
        private b() {
            super(x7.zzxg);
        }

        /* synthetic */ b(z7 z7Var) {
            this();
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.x7$c */
    /* loaded from: classes2.dex */
    public enum c implements q4 {
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
        
        private static final p4<c> x = new c8();
        private final int z;

        c(int i2) {
            this.z = i2;
        }

        public static s4 h() {
            return d8.a;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.q4
        public final int getNumber() {
            return this.z;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + c.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
        }
    }

    static {
        x7 x7Var = new x7();
        zzxg = x7Var;
        m4.n(x7.class, x7Var);
    }

    private x7() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (z7.a[dVar.ordinal()]) {
            case 1:
                return new x7();
            case 2:
                return new b(null);
            case 3:
                return m4.k(zzxg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzid", "zzxe", c.h(), "zzxf", a.h()});
            case 4:
                return zzxg;
            case 5:
                g6<x7> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (x7.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzxg);
                            zzii = g6Var;
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
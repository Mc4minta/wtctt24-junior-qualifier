package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.b1;
import com.google.android.gms.internal.p000firebaseperf.m4;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.g1  reason: invalid package */
/* loaded from: classes2.dex */
public final class g1 extends m4<g1, a> implements x5 {
    private static volatile g6<g1> zzii;
    private static final g1 zziu;
    private int zzid;
    private b1 zzip;
    private v1 zziq;
    private y2 zzir;
    private int zzis;
    private p5<String, String> zzit = p5.e();
    private String zzin = "";
    private String zzio = "";

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.g1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<g1, a> implements x5 {
        private a() {
            super(g1.zziu);
        }

        public final boolean o() {
            return ((g1) this.f6823b).t();
        }

        public final a p(b1.a aVar) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g1) this.f6823b).v((b1) ((m4) aVar.O()));
            return this;
        }

        public final a q(Map<String, String> map) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g1) this.f6823b).E().putAll(map);
            return this;
        }

        public final a r(i1 i1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g1) this.f6823b).I(i1Var);
            return this;
        }

        public final a s(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g1) this.f6823b).J(str);
            return this;
        }

        public final a t(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g1) this.f6823b).K(str);
            return this;
        }

        /* synthetic */ a(h1 h1Var) {
            this();
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.g1$b */
    /* loaded from: classes2.dex */
    static final class b {
        static final n5<String, String> a;

        static {
            s7 s7Var = s7.f6914j;
            a = n5.c(s7Var, "", s7Var, "");
        }
    }

    static {
        g1 g1Var = new g1();
        zziu = g1Var;
        m4.n(g1.class, g1Var);
    }

    private g1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> E() {
        if (!this.zzit.b()) {
            this.zzit = this.zzit.f();
        }
        return this.zzit;
    }

    public static a F() {
        return zziu.q();
    }

    public static g1 G() {
        return zziu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(i1 i1Var) {
        this.zzis = i1Var.getNumber();
        this.zzid |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzin = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String str) {
        str.getClass();
        this.zzid |= 2;
        this.zzio = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(b1 b1Var) {
        b1Var.getClass();
        this.zzip = b1Var;
        this.zzid |= 4;
    }

    public final boolean A() {
        return (this.zzid & 1) != 0;
    }

    public final boolean B() {
        return (this.zzid & 4) != 0;
    }

    public final b1 C() {
        b1 b1Var = this.zzip;
        return b1Var == null ? b1.z() : b1Var;
    }

    public final boolean D() {
        return (this.zzid & 32) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (h1.a[dVar.ordinal()]) {
            case 1:
                return new g1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zziu, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဌ\u0005\u00062\u0007ဉ\u0004", new Object[]{"zzid", "zzin", "zzio", "zzip", "zziq", "zzis", i1.h(), "zzit", b.a, "zzir"});
            case 4:
                return zziu;
            case 5:
                g6<g1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (g1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zziu);
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

    public final boolean t() {
        return (this.zzid & 2) != 0;
    }
}
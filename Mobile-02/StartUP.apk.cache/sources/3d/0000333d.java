package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.b1  reason: invalid package */
/* loaded from: classes2.dex */
public final class b1 extends m4<b1, a> implements x5 {
    private static final b1 zzih;
    private static volatile g6<b1> zzii;
    private int zzid;
    private String zzie = "";
    private String zzif = "";
    private String zzig = "";

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.b1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<b1, a> implements x5 {
        private a() {
            super(b1.zzih);
        }

        public final a o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((b1) this.f6823b).B(str);
            return this;
        }

        public final a p(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((b1) this.f6823b).C(str);
            return this;
        }

        public final a q(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((b1) this.f6823b).D(str);
            return this;
        }

        /* synthetic */ a(d1 d1Var) {
            this();
        }
    }

    static {
        b1 b1Var = new b1();
        zzih = b1Var;
        m4.n(b1.class, b1Var);
    }

    private b1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzie = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String str) {
        str.getClass();
        this.zzid |= 2;
        this.zzif = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String str) {
        str.getClass();
        this.zzid |= 4;
        this.zzig = str;
    }

    public static a y() {
        return zzih.q();
    }

    public static b1 z() {
        return zzih;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (d1.a[dVar.ordinal()]) {
            case 1:
                return new b1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzih, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzid", "zzie", "zzif", "zzig"});
            case 4:
                return zzih;
            case 5:
                g6<b1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (b1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzih);
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
        return (this.zzid & 1) != 0;
    }

    public final boolean u() {
        return (this.zzid & 2) != 0;
    }
}
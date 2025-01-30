package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s1  reason: invalid package */
/* loaded from: classes2.dex */
public final class s1 extends m4<s1, a> implements x5 {
    private static volatile g6<s1> zzii;
    private static final s1 zzjy;
    private int zzid;
    private r1 zzju;
    private String zzjt = "";
    private t4<m1> zzjv = m4.s();
    private t4<f1> zzjw = m4.s();
    private t4<w1> zzjx = m4.s();

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.s1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<s1, a> implements x5 {
        private a() {
            super(s1.zzjy);
        }

        public final a o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((s1) this.f6823b).A(str);
            return this;
        }

        public final a p(f1 f1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((s1) this.f6823b).t(f1Var);
            return this;
        }

        public final a q(m1 m1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((s1) this.f6823b).u(m1Var);
            return this;
        }

        public final a r(r1 r1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((s1) this.f6823b).v(r1Var);
            return this;
        }

        /* synthetic */ a(t1 t1Var) {
            this();
        }
    }

    static {
        s1 s1Var = new s1();
        zzjy = s1Var;
        m4.n(s1.class, s1Var);
    }

    private s1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjt = str;
    }

    public static a H() {
        return zzjy.q();
    }

    public static s1 I() {
        return zzjy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(f1 f1Var) {
        f1Var.getClass();
        t4<f1> t4Var = this.zzjw;
        if (!t4Var.K()) {
            this.zzjw = m4.j(t4Var);
        }
        this.zzjw.add(f1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(m1 m1Var) {
        m1Var.getClass();
        t4<m1> t4Var = this.zzjv;
        if (!t4Var.K()) {
            this.zzjv = m4.j(t4Var);
        }
        this.zzjv.add(m1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(r1 r1Var) {
        r1Var.getClass();
        this.zzju = r1Var;
        this.zzid |= 2;
    }

    public final boolean B() {
        return (this.zzid & 1) != 0;
    }

    public final String C() {
        return this.zzjt;
    }

    public final boolean D() {
        return (this.zzid & 2) != 0;
    }

    public final r1 E() {
        r1 r1Var = this.zzju;
        return r1Var == null ? r1.A() : r1Var;
    }

    public final int F() {
        return this.zzjv.size();
    }

    public final int G() {
        return this.zzjw.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (t1.a[dVar.ordinal()]) {
            case 1:
                return new s1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzjy, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b\u0005\u001b", new Object[]{"zzid", "zzjt", "zzjv", m1.class, "zzju", "zzjw", f1.class, "zzjx", w1.class});
            case 4:
                return zzjy;
            case 5:
                g6<s1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (s1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzjy);
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
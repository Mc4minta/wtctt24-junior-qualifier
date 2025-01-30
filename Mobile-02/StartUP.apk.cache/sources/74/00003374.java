package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.g1;
import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.g2  reason: invalid package */
/* loaded from: classes2.dex */
public final class g2 extends m4<g2, a> implements x5 {
    private static volatile g6<g2> zzii;
    private static final g2 zzlm;
    private int zzid;
    private g1 zzlh;
    private p2 zzli;
    private z1 zzlj;
    private s1 zzlk;
    private t2 zzll;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.g2$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<g2, a> implements x5 {
        private a() {
            super(g2.zzlm);
        }

        public final a o(g1.a aVar) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g2) this.f6823b).z((g1) ((m4) aVar.O()));
            return this;
        }

        public final a p(s1 s1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g2) this.f6823b).t(s1Var);
            return this;
        }

        public final a q(p2 p2Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g2) this.f6823b).y(p2Var);
            return this;
        }

        public final a r(z1 z1Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((g2) this.f6823b).A(z1Var);
            return this;
        }

        /* synthetic */ a(f2 f2Var) {
            this();
        }
    }

    static {
        g2 g2Var = new g2();
        zzlm = g2Var;
        m4.n(g2.class, g2Var);
    }

    private g2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(z1 z1Var) {
        z1Var.getClass();
        this.zzlj = z1Var;
        this.zzid |= 4;
    }

    public static a J() {
        return zzlm.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(s1 s1Var) {
        s1Var.getClass();
        this.zzlk = s1Var;
        this.zzid |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(p2 p2Var) {
        p2Var.getClass();
        this.zzli = p2Var;
        this.zzid |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(g1 g1Var) {
        g1Var.getClass();
        this.zzlh = g1Var;
        this.zzid |= 1;
    }

    public final boolean B() {
        return (this.zzid & 1) != 0;
    }

    public final g1 C() {
        g1 g1Var = this.zzlh;
        return g1Var == null ? g1.G() : g1Var;
    }

    public final boolean D() {
        return (this.zzid & 2) != 0;
    }

    public final p2 E() {
        p2 p2Var = this.zzli;
        return p2Var == null ? p2.Y() : p2Var;
    }

    public final boolean F() {
        return (this.zzid & 4) != 0;
    }

    public final z1 G() {
        z1 z1Var = this.zzlj;
        return z1Var == null ? z1.o0() : z1Var;
    }

    public final boolean H() {
        return (this.zzid & 8) != 0;
    }

    public final s1 I() {
        s1 s1Var = this.zzlk;
        return s1Var == null ? s1.I() : s1Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (f2.a[dVar.ordinal()]) {
            case 1:
                return new g2();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzlm, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzid", "zzlh", "zzli", "zzlj", "zzlk", "zzll"});
            case 4:
                return zzlm;
            case 5:
                g6<g2> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (g2.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzlm);
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
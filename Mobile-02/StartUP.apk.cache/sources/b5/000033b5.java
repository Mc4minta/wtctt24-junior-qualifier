package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.m1  reason: invalid package */
/* loaded from: classes2.dex */
public final class m1 extends m4<m1, a> implements x5 {
    private static volatile g6<m1> zzii;
    private static final m1 zzjf;
    private int zzid;
    private long zzik;
    private long zzjd;
    private long zzje;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.m1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<m1, a> implements x5 {
        private a() {
            super(m1.zzjf);
        }

        public final a o(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((m1) this.f6823b).A(j2);
            return this;
        }

        public final a p(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((m1) this.f6823b).y(j2);
            return this;
        }

        public final a q(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((m1) this.f6823b).z(j2);
            return this;
        }

        /* synthetic */ a(l1 l1Var) {
            this();
        }
    }

    static {
        m1 m1Var = new m1();
        zzjf = m1Var;
        m4.n(m1.class, m1Var);
    }

    private m1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(long j2) {
        this.zzid |= 4;
        this.zzje = j2;
    }

    public static a w() {
        return zzjf.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(long j2) {
        this.zzid |= 1;
        this.zzik = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(long j2) {
        this.zzid |= 2;
        this.zzjd = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (l1.a[dVar.ordinal()]) {
            case 1:
                return new m1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzjf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzid", "zzik", "zzjd", "zzje"});
            case 4:
                return zzjf;
            case 5:
                g6<m1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (m1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzjf);
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
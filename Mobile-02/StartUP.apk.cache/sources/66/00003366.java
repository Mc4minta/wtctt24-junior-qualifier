package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.f1  reason: invalid package */
/* loaded from: classes2.dex */
public final class f1 extends m4<f1, a> implements x5 {
    private static volatile g6<f1> zzii;
    private static final f1 zzim;
    private int zzid;
    private long zzik;
    private int zzil;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.f1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<f1, a> implements x5 {
        private a() {
            super(f1.zzim);
        }

        public final a o(int i2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((f1) this.f6823b).v(i2);
            return this;
        }

        public final a p(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((f1) this.f6823b).y(j2);
            return this;
        }

        /* synthetic */ a(e1 e1Var) {
            this();
        }
    }

    static {
        f1 f1Var = new f1();
        zzim = f1Var;
        m4.n(f1.class, f1Var);
    }

    private f1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i2) {
        this.zzid |= 2;
        this.zzil = i2;
    }

    public static a w() {
        return zzim.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(long j2) {
        this.zzid |= 1;
        this.zzik = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (e1.a[dVar.ordinal()]) {
            case 1:
                return new f1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzim, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001", new Object[]{"zzid", "zzik", "zzil"});
            case 4:
                return zzim;
            case 5:
                g6<f1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (f1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzim);
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
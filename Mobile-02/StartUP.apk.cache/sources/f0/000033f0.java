package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.r1  reason: invalid package */
/* loaded from: classes2.dex */
public final class r1 extends m4<r1, a> implements x5 {
    private static volatile g6<r1> zzii;
    private static final r1 zzjs;
    private int zzid;
    private String zzjm = "";
    private int zzjn;
    private int zzjo;
    private int zzjp;
    private int zzjq;
    private int zzjr;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.r1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<r1, a> implements x5 {
        private a() {
            super(r1.zzjs);
        }

        public final a o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((r1) this.f6823b).v(str);
            return this;
        }

        public final a p(int i2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((r1) this.f6823b).C(i2);
            return this;
        }

        public final a q(int i2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((r1) this.f6823b).D(i2);
            return this;
        }

        public final a r(int i2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((r1) this.f6823b).E(i2);
            return this;
        }

        /* synthetic */ a(q1 q1Var) {
            this();
        }
    }

    static {
        r1 r1Var = new r1();
        zzjs = r1Var;
        m4.n(r1.class, r1Var);
    }

    private r1() {
    }

    public static r1 A() {
        return zzjs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2) {
        this.zzid |= 8;
        this.zzjp = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i2) {
        this.zzid |= 16;
        this.zzjq = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int i2) {
        this.zzid |= 32;
        this.zzjr = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjm = str;
    }

    public static a z() {
        return zzjs.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (q1.a[dVar.ordinal()]) {
            case 1:
                return new r1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzjs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0005\u0006င\u0002", new Object[]{"zzid", "zzjm", "zzjn", "zzjp", "zzjq", "zzjr", "zzjo"});
            case 4:
                return zzjs;
            case 5:
                g6<r1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (r1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzjs);
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

    public final boolean y() {
        return (this.zzid & 16) != 0;
    }
}
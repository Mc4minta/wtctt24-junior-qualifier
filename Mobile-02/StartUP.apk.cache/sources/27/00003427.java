package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w1  reason: invalid package */
/* loaded from: classes2.dex */
public final class w1 extends m4<w1, a> implements x5 {
    private static volatile g6<w1> zzii;
    private static final w1 zzkf;
    private int zzid;
    private long zzik;
    private int zzkd;
    private int zzke;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.w1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<w1, a> implements x5 {
        private a() {
            super(w1.zzkf);
        }

        /* synthetic */ a(x1 x1Var) {
            this();
        }
    }

    static {
        w1 w1Var = new w1();
        zzkf = w1Var;
        m4.n(w1.class, w1Var);
    }

    private w1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (x1.a[dVar.ordinal()]) {
            case 1:
                return new w1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzkf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzid", "zzik", "zzkd", "zzke"});
            case 4:
                return zzkf;
            case 5:
                g6<w1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (w1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzkf);
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
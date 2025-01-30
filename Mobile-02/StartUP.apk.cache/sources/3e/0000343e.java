package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.y2  reason: invalid package */
/* loaded from: classes2.dex */
public final class y2 extends m4<y2, a> implements x5 {
    private static volatile g6<y2> zzii;
    private static final y2 zzmt;
    private int zzid;
    private String zzif = "";
    private String zzmp = "";
    private int zzmq;
    private int zzmr;
    private int zzms;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.y2$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<y2, a> implements x5 {
        private a() {
            super(y2.zzmt);
        }

        /* synthetic */ a(a3 a3Var) {
            this();
        }
    }

    static {
        y2 y2Var = new y2();
        zzmt = y2Var;
        m4.n(y2.class, y2Var);
    }

    private y2() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (a3.a[dVar.ordinal()]) {
            case 1:
                return new y2();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzmt, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004", new Object[]{"zzid", "zzif", "zzmp", "zzmq", k2.h(), "zzmr", x2.h(), "zzms", n1.h()});
            case 4:
                return zzmt;
            case 5:
                g6<y2> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (y2.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzmt);
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
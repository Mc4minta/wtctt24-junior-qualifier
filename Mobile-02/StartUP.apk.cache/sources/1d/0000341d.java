package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.v1  reason: invalid package */
/* loaded from: classes2.dex */
public final class v1 extends m4<v1, a> implements x5 {
    private static volatile g6<v1> zzii;
    private static final v1 zzkc;
    private int zzid;
    private String zzif = "";
    private String zzjz = "";
    private String zzka = "";
    private x7 zzkb;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.v1$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<v1, a> implements x5 {
        private a() {
            super(v1.zzkc);
        }

        /* synthetic */ a(u1 u1Var) {
            this();
        }
    }

    static {
        v1 v1Var = new v1();
        zzkc = v1Var;
        m4.n(v1.class, v1Var);
    }

    private v1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (u1.a[dVar.ordinal()]) {
            case 1:
                return new v1();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzkc, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဉ\u0003", new Object[]{"zzid", "zzif", "zzjz", "zzka", "zzkb"});
            case 4:
                return zzkc;
            case 5:
                g6<v1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (v1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzkc);
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
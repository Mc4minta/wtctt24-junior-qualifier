package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h2  reason: invalid package */
/* loaded from: classes2.dex */
public final class h2 extends m4<h2, a> implements x5 {
    private static volatile g6<h2> zzii;
    private static final u4<Integer, o2> zzlo = new j2();
    private static final h2 zzlp;
    private int zzid;
    private String zzjt = "";
    private r4 zzln = m4.r();

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.h2$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<h2, a> implements x5 {
        private a() {
            super(h2.zzlp);
        }

        public final a o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((h2) this.f6823b).w(str);
            return this;
        }

        public final a p(o2 o2Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((h2) this.f6823b).v(o2Var);
            return this;
        }

        /* synthetic */ a(j2 j2Var) {
            this();
        }
    }

    static {
        h2 h2Var = new h2();
        zzlp = h2Var;
        m4.n(h2.class, h2Var);
    }

    private h2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(o2 o2Var) {
        o2Var.getClass();
        if (!this.zzln.K()) {
            r4 r4Var = this.zzln;
            int size = r4Var.size();
            this.zzln = r4Var.n0(size == 0 ? 10 : size << 1);
        }
        this.zzln.A(o2Var.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjt = str;
    }

    public static a y() {
        return zzlp.q();
    }

    public final o2 A(int i2) {
        return zzlo.convert(Integer.valueOf(this.zzln.getInt(0)));
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    protected final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (i2.a[dVar.ordinal()]) {
            case 1:
                return new h2();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzlp, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"zzid", "zzjt", "zzln", o2.h()});
            case 4:
                return zzlp;
            case 5:
                g6<h2> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (h2.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzlp);
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

    public final int x() {
        return this.zzln.size();
    }
}
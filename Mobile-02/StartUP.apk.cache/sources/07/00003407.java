package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.t2  reason: invalid package */
/* loaded from: classes2.dex */
public final class t2 extends m4<t2, b> implements x5 {
    private static volatile g6<t2> zzii;
    private static final t2 zzmf;
    private int zzid;
    private int zzme;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.t2$a */
    /* loaded from: classes2.dex */
    public enum a implements q4 {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);
        

        /* renamed from: c  reason: collision with root package name */
        private static final p4<a> f6918c = new v2();

        /* renamed from: e  reason: collision with root package name */
        private final int f6920e;

        a(int i2) {
            this.f6920e = i2;
        }

        public static s4 h() {
            return u2.a;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.q4
        public final int getNumber() {
            return this.f6920e;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.t2$b */
    /* loaded from: classes2.dex */
    public static final class b extends m4.a<t2, b> implements x5 {
        private b() {
            super(t2.zzmf);
        }

        /* synthetic */ b(s2 s2Var) {
            this();
        }
    }

    static {
        t2 t2Var = new t2();
        zzmf = t2Var;
        m4.n(t2.class, t2Var);
    }

    private t2() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (s2.a[dVar.ordinal()]) {
            case 1:
                return new t2();
            case 2:
                return new b(null);
            case 3:
                return m4.k(zzmf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzid", "zzme", a.h()});
            case 4:
                return zzmf;
            case 5:
                g6<t2> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (t2.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzmf);
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
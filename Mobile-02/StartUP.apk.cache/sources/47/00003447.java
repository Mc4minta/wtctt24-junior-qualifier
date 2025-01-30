package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.z1  reason: invalid package */
/* loaded from: classes2.dex */
public final class z1 extends m4<z1, b> implements x5 {
    private static volatile g6<z1> zzii;
    private static final z1 zzks;
    private int zzid;
    private int zzkh;
    private long zzki;
    private long zzkj;
    private int zzkk;
    private int zzkl;
    private long zzkn;
    private long zzko;
    private long zzkp;
    private long zzkq;
    private p5<String, String> zzit = p5.e();
    private String zzkg = "";
    private String zzkm = "";
    private t4<h2> zzkr = m4.s();

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.z1$a */
    /* loaded from: classes2.dex */
    static final class a {
        static final n5<String, String> a;

        static {
            s7 s7Var = s7.f6914j;
            a = n5.c(s7Var, "", s7Var, "");
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.z1$b */
    /* loaded from: classes2.dex */
    public static final class b extends m4.a<z1, b> implements x5 {
        private b() {
            super(z1.zzks);
        }

        public final boolean A() {
            return ((z1) this.f6823b).Q();
        }

        public final boolean B() {
            return ((z1) this.f6823b).d0();
        }

        public final long C() {
            return ((z1) this.f6823b).i0();
        }

        public final boolean D() {
            return ((z1) this.f6823b).j0();
        }

        public final b E() {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).c0();
            return this;
        }

        public final b F(int i2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).u(i2);
            return this;
        }

        public final b o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).w(str);
            return this;
        }

        public final b p(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).v(str);
            return this;
        }

        public final b q(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).H(j2);
            return this;
        }

        public final b r(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).I(j2);
            return this;
        }

        public final b s(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).J(j2);
            return this;
        }

        public final b t(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).K(j2);
            return this;
        }

        public final b u(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).L(j2);
            return this;
        }

        public final b v(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).M(j2);
            return this;
        }

        public final b w(c cVar) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).x(cVar);
            return this;
        }

        public final b x(d dVar) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).y(dVar);
            return this;
        }

        public final b y(Iterable<? extends h2> iterable) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((z1) this.f6823b).G(iterable);
            return this;
        }

        /* synthetic */ b(y1 y1Var) {
            this();
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.z1$c */
    /* loaded from: classes2.dex */
    public enum c implements q4 {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        

        /* renamed from: l  reason: collision with root package name */
        private static final p4<c> f6996l = new a2();
        private final int n;

        c(int i2) {
            this.n = i2;
        }

        public static s4 h() {
            return b2.a;
        }

        public static c n(int i2) {
            switch (i2) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.q4
        public final int getNumber() {
            return this.n;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + c.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.z1$d */
    /* loaded from: classes2.dex */
    public enum d implements q4 {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        

        /* renamed from: c  reason: collision with root package name */
        private static final p4<d> f6998c = new e2();

        /* renamed from: e  reason: collision with root package name */
        private final int f7000e;

        d(int i2) {
            this.f7000e = i2;
        }

        public static s4 h() {
            return d2.a;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.q4
        public final int getNumber() {
            return this.f7000e;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
        }
    }

    static {
        z1 z1Var = new z1();
        zzks = z1Var;
        m4.n(z1.class, z1Var);
    }

    private z1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(Iterable<? extends h2> iterable) {
        t4<h2> t4Var = this.zzkr;
        if (!t4Var.K()) {
            this.zzkr = m4.j(t4Var);
        }
        c3.f(iterable, this.zzkr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(long j2) {
        this.zzid |= 4;
        this.zzki = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(long j2) {
        this.zzid |= 8;
        this.zzkj = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(long j2) {
        this.zzid |= 128;
        this.zzkn = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(long j2) {
        this.zzid |= 256;
        this.zzko = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(long j2) {
        this.zzid |= 512;
        this.zzkp = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(long j2) {
        this.zzid |= 1024;
        this.zzkq = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        this.zzid &= -65;
        this.zzkm = zzks.zzkm;
    }

    public static b m0() {
        return zzks.q();
    }

    public static z1 o0() {
        return zzks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i2) {
        this.zzid |= 32;
        this.zzkl = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String str) {
        str.getClass();
        this.zzid |= 64;
        this.zzkm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzkg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(c cVar) {
        this.zzkh = cVar.getNumber();
        this.zzid |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(d dVar) {
        this.zzkk = dVar.getNumber();
        this.zzid |= 16;
    }

    public final boolean Q() {
        return (this.zzid & 32) != 0;
    }

    public final boolean U() {
        return (this.zzid & 2) != 0;
    }

    public final c W() {
        c n = c.n(this.zzkh);
        return n == null ? c.HTTP_METHOD_UNKNOWN : n;
    }

    public final boolean X() {
        return (this.zzid & 4) != 0;
    }

    public final long Y() {
        return this.zzki;
    }

    public final boolean Z() {
        return (this.zzid & 8) != 0;
    }

    public final long a0() {
        return this.zzkj;
    }

    public final int b0() {
        return this.zzkl;
    }

    public final boolean d0() {
        return (this.zzid & 128) != 0;
    }

    public final long e0() {
        return this.zzkn;
    }

    public final boolean f0() {
        return (this.zzid & 256) != 0;
    }

    public final long g0() {
        return this.zzko;
    }

    public final boolean h0() {
        return (this.zzid & 512) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (y1.a[dVar.ordinal()]) {
            case 1:
                return new z1();
            case 2:
                return new b(null);
            case 3:
                return m4.k(zzks, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\bဂ\b\tဂ\t\nဂ\n\u000bဌ\u0004\f2\r\u001b", new Object[]{"zzid", "zzkg", "zzkh", c.h(), "zzki", "zzkj", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkk", d.h(), "zzit", a.a, "zzkr", h2.class});
            case 4:
                return zzks;
            case 5:
                g6<z1> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (z1.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzks);
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

    public final long i0() {
        return this.zzkp;
    }

    public final boolean j0() {
        return (this.zzid & 1024) != 0;
    }

    public final long k0() {
        return this.zzkq;
    }

    public final List<h2> l0() {
        return this.zzkr;
    }

    public final String t() {
        return this.zzkg;
    }
}
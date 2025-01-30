package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p2  reason: invalid package */
/* loaded from: classes2.dex */
public final class p2 extends m4<p2, a> implements x5 {
    private static volatile g6<p2> zzii;
    private static final p2 zzmd;
    private int zzid;
    private long zzkn;
    private boolean zzlz;
    private long zzma;
    private p5<String, Long> zzmb = p5.e();
    private p5<String, String> zzit = p5.e();
    private String zzly = "";
    private t4<p2> zzmc = m4.s();
    private t4<h2> zzkr = m4.s();

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.p2$a */
    /* loaded from: classes2.dex */
    public static final class a extends m4.a<p2, a> implements x5 {
        private a() {
            super(p2.zzmd);
        }

        public final a o(String str) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).v(str);
            return this;
        }

        public final a p(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).D(j2);
            return this;
        }

        public final a q(long j2) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).E(j2);
            return this;
        }

        public final a r(h2 h2Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).w(h2Var);
            return this;
        }

        public final a s(String str, long j2) {
            str.getClass();
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).R().put(str, Long.valueOf(j2));
            return this;
        }

        public final a t(Iterable<? extends p2> iterable) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).I(iterable);
            return this;
        }

        public final a u(Map<String, Long> map) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).R().putAll(map);
            return this;
        }

        public final a v(Iterable<? extends h2> iterable) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).C(iterable);
            return this;
        }

        public final a w(Map<String, String> map) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).K().putAll(map);
            return this;
        }

        public final a x(p2 p2Var) {
            if (this.f6824c) {
                k();
                this.f6824c = false;
            }
            ((p2) this.f6823b).H(p2Var);
            return this;
        }

        /* synthetic */ a(r2 r2Var) {
            this();
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.p2$b */
    /* loaded from: classes2.dex */
    static final class b {
        static final n5<String, String> a;

        static {
            s7 s7Var = s7.f6914j;
            a = n5.c(s7Var, "", s7Var, "");
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.p2$c */
    /* loaded from: classes2.dex */
    static final class c {
        static final n5<String, Long> a = n5.c(s7.f6914j, "", s7.f6908c, 0L);
    }

    static {
        p2 p2Var = new p2();
        zzmd = p2Var;
        m4.n(p2.class, p2Var);
    }

    private p2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Iterable<? extends h2> iterable) {
        W();
        c3.f(iterable, this.zzkr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(long j2) {
        this.zzid |= 4;
        this.zzkn = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(long j2) {
        this.zzid |= 8;
        this.zzma = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(p2 p2Var) {
        p2Var.getClass();
        T();
        this.zzmc.add(p2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(Iterable<? extends p2> iterable) {
        T();
        c3.f(iterable, this.zzmc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> K() {
        if (!this.zzit.b()) {
            this.zzit = this.zzit.f();
        }
        return this.zzit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Long> R() {
        if (!this.zzmb.b()) {
            this.zzmb = this.zzmb.f();
        }
        return this.zzmb;
    }

    private final void T() {
        t4<p2> t4Var = this.zzmc;
        if (t4Var.K()) {
            return;
        }
        this.zzmc = m4.j(t4Var);
    }

    private final void W() {
        t4<h2> t4Var = this.zzkr;
        if (t4Var.K()) {
            return;
        }
        this.zzkr = m4.j(t4Var);
    }

    public static a X() {
        return zzmd.q();
    }

    public static p2 Y() {
        return zzmd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzly = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(h2 h2Var) {
        h2Var.getClass();
        W();
        this.zzkr.add(h2Var);
    }

    public final boolean M() {
        return (this.zzid & 4) != 0;
    }

    public final List<h2> N() {
        return this.zzkr;
    }

    public final int P() {
        return this.zzmb.size();
    }

    public final Map<String, Long> Q() {
        return Collections.unmodifiableMap(this.zzmb);
    }

    public final List<p2> S() {
        return this.zzmc;
    }

    public final Map<String, String> U() {
        return Collections.unmodifiableMap(this.zzit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p000firebaseperf.m4
    public final Object i(m4.d dVar, Object obj, Object obj2) {
        switch (r2.a[dVar.ordinal()]) {
            case 1:
                return new p2();
            case 2:
                return new a(null);
            case 3:
                return m4.k(zzmd, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"zzid", "zzly", "zzlz", "zzkn", "zzma", "zzmb", c.a, "zzmc", p2.class, "zzit", b.a, "zzkr", h2.class});
            case 4:
                return zzmd;
            case 5:
                g6<p2> g6Var = zzii;
                if (g6Var == null) {
                    synchronized (p2.class) {
                        g6Var = zzii;
                        if (g6Var == null) {
                            g6Var = new m4.c<>(zzmd);
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

    public final long t() {
        return this.zzma;
    }

    public final String u() {
        return this.zzly;
    }
}
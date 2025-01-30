package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class d5 extends e1<d5, a> implements k2 {
    private static volatile s2<d5> zzbg;
    private static final d5 zzbir;
    private j1<b> zzbiq = e1.o();

    /* loaded from: classes2.dex */
    public static final class a extends e1.a<d5, a> implements k2 {
        private a() {
            super(d5.zzbir);
        }

        /* synthetic */ a(e5 e5Var) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends e1<b, a> implements k2 {
        private static volatile s2<b> zzbg;
        private static final b zzbiv;
        private int zzbb;
        private String zzbis = "";
        private long zzbit;
        private long zzbiu;
        private int zzya;

        /* loaded from: classes2.dex */
        public static final class a extends e1.a<b, a> implements k2 {
            private a() {
                super(b.zzbiv);
            }

            /* synthetic */ a(e5 e5Var) {
                this();
            }

            public final a q(String str) {
                n();
                ((b) this.f6398b).B(str);
                return this;
            }

            public final a r(long j2) {
                n();
                ((b) this.f6398b).C(j2);
                return this;
            }

            public final a s(long j2) {
                n();
                ((b) this.f6398b).D(j2);
                return this;
            }
        }

        static {
            b bVar = new b();
            zzbiv = bVar;
            e1.m(b.class, bVar);
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void B(String str) {
            Objects.requireNonNull(str);
            this.zzbb |= 2;
            this.zzbis = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(long j2) {
            this.zzbb |= 4;
            this.zzbit = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void D(long j2) {
            this.zzbb |= 8;
            this.zzbiu = j2;
        }

        public static a y() {
            return (a) ((e1.a) zzbiv.e(e1.e.f6405e, null, null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.e1$b, com.google.android.gms.internal.clearcut.s2<com.google.android.gms.internal.clearcut.d5$b>] */
        @Override // com.google.android.gms.internal.clearcut.e1
        public final Object e(int i2, Object obj, Object obj2) {
            s2<b> s2Var;
            switch (e5.a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(null);
                case 3:
                    return e1.g(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                case 4:
                    return zzbiv;
                case 5:
                    s2<b> s2Var2 = zzbg;
                    s2<b> s2Var3 = s2Var2;
                    if (s2Var2 == null) {
                        synchronized (b.class) {
                            s2<b> s2Var4 = zzbg;
                            s2Var = s2Var4;
                            if (s2Var4 == null) {
                                ?? bVar = new e1.b(zzbiv);
                                zzbg = bVar;
                                s2Var = bVar;
                            }
                        }
                        s2Var3 = s2Var;
                    }
                    return s2Var3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final int q() {
            return this.zzya;
        }

        public final boolean u() {
            return (this.zzbb & 1) == 1;
        }

        public final String v() {
            return this.zzbis;
        }

        public final long w() {
            return this.zzbit;
        }

        public final long x() {
            return this.zzbiu;
        }
    }

    static {
        d5 d5Var = new d5();
        zzbir = d5Var;
        e1.m(d5.class, d5Var);
    }

    private d5() {
    }

    public static d5 r() {
        return zzbir;
    }

    public static d5 t(byte[] bArr) throws zzco {
        return (d5) e1.n(zzbir, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.s2<com.google.android.gms.internal.clearcut.d5>, com.google.android.gms.internal.clearcut.e1$b] */
    @Override // com.google.android.gms.internal.clearcut.e1
    public final Object e(int i2, Object obj, Object obj2) {
        s2<d5> s2Var;
        switch (e5.a[i2 - 1]) {
            case 1:
                return new d5();
            case 2:
                return new a(null);
            case 3:
                return e1.g(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", b.class});
            case 4:
                return zzbir;
            case 5:
                s2<d5> s2Var2 = zzbg;
                s2<d5> s2Var3 = s2Var2;
                if (s2Var2 == null) {
                    synchronized (d5.class) {
                        s2<d5> s2Var4 = zzbg;
                        s2Var = s2Var4;
                        if (s2Var4 == null) {
                            ?? bVar = new e1.b(zzbir);
                            zzbg = bVar;
                            s2Var = bVar;
                        }
                    }
                    s2Var3 = s2Var;
                }
                return s2Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List<b> q() {
        return this.zzbiq;
    }
}
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;

/* loaded from: classes2.dex */
public final class w4 extends e1<w4, a> implements k2 {
    private static volatile s2<w4> zzbg;
    private static final w4 zztx;
    private int zzbb;
    private int zztu;
    private String zztv = "";
    private String zztw = "";

    /* loaded from: classes2.dex */
    public static final class a extends e1.a<w4, a> implements k2 {
        private a() {
            super(w4.zztx);
        }

        /* synthetic */ a(z4 z4Var) {
            this();
        }
    }

    static {
        w4 w4Var = new w4();
        zztx = w4Var;
        e1.m(w4.class, w4Var);
    }

    private w4() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.s2<com.google.android.gms.internal.clearcut.w4>, com.google.android.gms.internal.clearcut.e1$b] */
    @Override // com.google.android.gms.internal.clearcut.e1
    public final Object e(int i2, Object obj, Object obj2) {
        s2<w4> s2Var;
        switch (z4.a[i2 - 1]) {
            case 1:
                return new w4();
            case 2:
                return new a(null);
            case 3:
                return e1.g(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzbb", "zztu", "zztv", "zztw"});
            case 4:
                return zztx;
            case 5:
                s2<w4> s2Var2 = zzbg;
                s2<w4> s2Var3 = s2Var2;
                if (s2Var2 == null) {
                    synchronized (w4.class) {
                        s2<w4> s2Var4 = zzbg;
                        s2Var = s2Var4;
                        if (s2Var4 == null) {
                            ?? bVar = new e1.b(zztx);
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
}
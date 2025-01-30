package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.u0;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class y0 extends n4<y0, a> implements w5 {
    private static final y0 zzf;
    private static volatile g6<y0> zzg;
    private int zzc;
    private int zzd = 1;
    private v4<u0> zze = n4.A();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<y0, a> implements w5 {
        private a() {
            super(y0.zzf);
        }

        public final a u(u0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((y0) this.f7252b).C((u0) ((n4) aVar.j()));
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public enum b implements p4 {
        RADS(1),
        PROVISIONING(2);
        

        /* renamed from: c  reason: collision with root package name */
        private static final s4<b> f7423c = new c1();

        /* renamed from: e  reason: collision with root package name */
        private final int f7425e;

        b(int i2) {
            this.f7425e = i2;
        }

        public static b h(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return PROVISIONING;
            }
            return RADS;
        }

        public static r4 n() {
            return d1.a;
        }

        @Override // com.google.android.gms.internal.measurement.p4
        public final int a() {
            return this.f7425e;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f7425e + " name=" + name() + '>';
        }
    }

    static {
        y0 y0Var = new y0();
        zzf = y0Var;
        n4.u(y0.class, y0Var);
    }

    private y0() {
    }

    public static a B() {
        return zzf.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(u0 u0Var) {
        u0Var.getClass();
        if (!this.zze.a()) {
            this.zze = n4.q(this.zze);
        }
        this.zze.add(u0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new y0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", b.n(), "zze", u0.class});
            case 4:
                return zzf;
            case 5:
                g6<y0> g6Var = zzg;
                if (g6Var == null) {
                    synchronized (y0.class) {
                        g6Var = zzg;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzf);
                            zzg = g6Var;
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
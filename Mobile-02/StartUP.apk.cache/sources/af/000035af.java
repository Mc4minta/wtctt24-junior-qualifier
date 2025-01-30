package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.x0;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class w0 extends n4<w0, a> implements w5 {
    private static final w0 zzd;
    private static volatile g6<w0> zze;
    private v4<x0> zzc = n4.A();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
    /* loaded from: classes2.dex */
    public static final class a extends n4.a<w0, a> implements w5 {
        private a() {
            super(w0.zzd);
        }

        public final a u(x0.a aVar) {
            if (this.f7253c) {
                r();
                this.f7253c = false;
            }
            ((w0) this.f7252b).E((x0) ((n4) aVar.j()));
            return this;
        }

        public final x0 v(int i2) {
            return ((w0) this.f7252b).B(0);
        }

        /* synthetic */ a(q0 q0Var) {
            this();
        }
    }

    static {
        w0 w0Var = new w0();
        zzd = w0Var;
        n4.u(w0.class, w0Var);
    }

    private w0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(x0 x0Var) {
        x0Var.getClass();
        if (!this.zzc.a()) {
            this.zzc = n4.q(this.zzc);
        }
        this.zzc.add(x0Var);
    }

    public static a F() {
        return zzd.w();
    }

    public final x0 B(int i2) {
        return this.zzc.get(0);
    }

    public final List<x0> C() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n4
    public final Object r(int i2, Object obj, Object obj2) {
        switch (q0.a[i2 - 1]) {
            case 1:
                return new w0();
            case 2:
                return new a(null);
            case 3:
                return n4.s(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", x0.class});
            case 4:
                return zzd;
            case 5:
                g6<w0> g6Var = zze;
                if (g6Var == null) {
                    synchronized (w0.class) {
                        g6Var = zze;
                        if (g6Var == null) {
                            g6Var = new n4.c<>(zzd);
                            zze = g6Var;
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
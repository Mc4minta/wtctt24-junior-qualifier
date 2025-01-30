package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class zzel extends e3 {
    private static final Logger a = Logger.getLogger(zzel.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f7464b = j7.m();

    /* renamed from: c  reason: collision with root package name */
    w3 f7465c;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    static class a extends zzel {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f7466d;

        /* renamed from: e  reason: collision with root package name */
        private final int f7467e;

        /* renamed from: f  reason: collision with root package name */
        private final int f7468f;

        /* renamed from: g  reason: collision with root package name */
        private int f7469g;

        a(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i4)) >= 0) {
                this.f7466d = bArr;
                this.f7467e = 0;
                this.f7469g = 0;
                this.f7468f = i4;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
        }

        private final void F0(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f7466d, this.f7469g, i3);
                this.f7469g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void O(int i2) throws IOException {
            if (!zzel.f7464b || a3.b() || b() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f7466d;
                        int i3 = this.f7469g;
                        this.f7469g = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), 1), e2);
                    }
                }
                byte[] bArr2 = this.f7466d;
                int i4 = this.f7469g;
                this.f7469g = i4 + 1;
                bArr2[i4] = (byte) i2;
            } else if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.f7466d;
                int i5 = this.f7469g;
                this.f7469g = i5 + 1;
                j7.l(bArr3, i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f7466d;
                int i6 = this.f7469g;
                this.f7469g = i6 + 1;
                j7.l(bArr4, i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & (-128)) == 0) {
                    byte[] bArr5 = this.f7466d;
                    int i8 = this.f7469g;
                    this.f7469g = i8 + 1;
                    j7.l(bArr5, i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f7466d;
                int i9 = this.f7469g;
                this.f7469g = i9 + 1;
                j7.l(bArr6, i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & (-128)) == 0) {
                    byte[] bArr7 = this.f7466d;
                    int i11 = this.f7469g;
                    this.f7469g = i11 + 1;
                    j7.l(bArr7, i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f7466d;
                int i12 = this.f7469g;
                this.f7469g = i12 + 1;
                j7.l(bArr8, i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & (-128)) == 0) {
                    byte[] bArr9 = this.f7466d;
                    int i14 = this.f7469g;
                    this.f7469g = i14 + 1;
                    j7.l(bArr9, i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f7466d;
                int i15 = this.f7469g;
                this.f7469g = i15 + 1;
                j7.l(bArr10, i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f7466d;
                int i16 = this.f7469g;
                this.f7469g = i16 + 1;
                j7.l(bArr11, i16, (byte) (i13 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void P(int i2, int i3) throws IOException {
            m(i2, 0);
            j(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void R(int i2, h3 h3Var) throws IOException {
            m(1, 3);
            X(2, i2);
            o(3, h3Var);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void X(int i2, int i3) throws IOException {
            m(i2, 0);
            O(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void Y(int i2, long j2) throws IOException {
            m(i2, 1);
            Z(j2);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void Z(long j2) throws IOException {
            try {
                byte[] bArr = this.f7466d;
                int i2 = this.f7469g;
                int i3 = i2 + 1;
                this.f7469g = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.f7469g = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.f7469g = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.f7469g = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.f7469g = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.f7469g = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.f7469g = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.f7469g = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.e3
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            F0(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final int b() {
            return this.f7468f - this.f7469g;
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void e0(int i2) throws IOException {
            try {
                byte[] bArr = this.f7466d;
                int i3 = this.f7469g;
                int i4 = i3 + 1;
                this.f7469g = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.f7469g = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.f7469g = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.f7469g = i6 + 1;
                bArr[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void g(byte b2) throws IOException {
            try {
                byte[] bArr = this.f7466d;
                int i2 = this.f7469g;
                this.f7469g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void j(int i2) throws IOException {
            if (i2 >= 0) {
                O(i2);
            } else {
                t(i2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void j0(int i2, int i3) throws IOException {
            m(i2, 5);
            e0(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void m(int i2, int i3) throws IOException {
            O((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void n(int i2, long j2) throws IOException {
            m(i2, 0);
            t(j2);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void o(int i2, h3 h3Var) throws IOException {
            m(i2, 2);
            u(h3Var);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void p(int i2, u5 u5Var) throws IOException {
            m(1, 3);
            X(2, i2);
            m(3, 2);
            v(u5Var);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        final void q(int i2, u5 u5Var, m6 m6Var) throws IOException {
            m(i2, 2);
            x2 x2Var = (x2) u5Var;
            int m = x2Var.m();
            if (m == -1) {
                m = m6Var.e(x2Var);
                x2Var.n(m);
            }
            O(m);
            m6Var.i(u5Var, this.f7465c);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void r(int i2, String str) throws IOException {
            m(i2, 2);
            w(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void s(int i2, boolean z) throws IOException {
            m(i2, 0);
            g(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void t(long j2) throws IOException {
            if (zzel.f7464b && b() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f7466d;
                    int i2 = this.f7469g;
                    this.f7469g = i2 + 1;
                    j7.l(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f7466d;
                int i3 = this.f7469g;
                this.f7469g = i3 + 1;
                j7.l(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f7466d;
                    int i4 = this.f7469g;
                    this.f7469g = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7469g), Integer.valueOf(this.f7468f), 1), e2);
                }
            }
            byte[] bArr4 = this.f7466d;
            int i5 = this.f7469g;
            this.f7469g = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void u(h3 h3Var) throws IOException {
            O(h3Var.i());
            h3Var.r(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void v(u5 u5Var) throws IOException {
            O(u5Var.i());
            u5Var.f(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzel
        public final void w(String str) throws IOException {
            int i2 = this.f7469g;
            try {
                int o0 = zzel.o0(str.length() * 3);
                int o02 = zzel.o0(str.length());
                if (o02 == o0) {
                    int i3 = i2 + o02;
                    this.f7469g = i3;
                    int e2 = l7.e(str, this.f7466d, i3, b());
                    this.f7469g = i2;
                    O((e2 - i2) - o02);
                    this.f7469g = e2;
                    return;
                }
                O(l7.d(str));
                this.f7469g = l7.e(str, this.f7466d, this.f7469g, b());
            } catch (p7 e3) {
                this.f7469g = i2;
                x(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb(e4);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
    /* loaded from: classes2.dex */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L11
                java.lang.String r3 = r0.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzel.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzel() {
    }

    public static int A(float f2) {
        return 4;
    }

    public static int A0(int i2, int i3) {
        return g0(i2) + 4;
    }

    public static int B(int i2, double d2) {
        return g0(i2) + 8;
    }

    public static int B0(int i2) {
        return k0(i2);
    }

    public static int C(int i2, float f2) {
        return g0(i2) + 4;
    }

    public static int C0(int i2, int i3) {
        return g0(i2) + k0(i3);
    }

    public static int D(int i2, c5 c5Var) {
        return (g0(1) << 1) + p0(2, i2) + c(3, c5Var);
    }

    @Deprecated
    public static int D0(int i2) {
        return o0(i2);
    }

    public static int E(int i2, u5 u5Var) {
        return (g0(1) << 1) + p0(2, i2) + g0(3) + J(u5Var);
    }

    private static int E0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(int i2, u5 u5Var, m6 m6Var) {
        return g0(i2) + e(u5Var, m6Var);
    }

    public static int G(int i2, String str) {
        return g0(i2) + K(str);
    }

    public static int H(int i2, boolean z) {
        return g0(i2) + 1;
    }

    public static int I(h3 h3Var) {
        int i2 = h3Var.i();
        return o0(i2) + i2;
    }

    public static int J(u5 u5Var) {
        int i2 = u5Var.i();
        return o0(i2) + i2;
    }

    public static int K(String str) {
        int length;
        try {
            length = l7.d(str);
        } catch (p7 unused) {
            length = str.getBytes(q4.a).length;
        }
        return o0(length) + length;
    }

    public static int L(boolean z) {
        return 1;
    }

    public static int M(byte[] bArr) {
        int length = bArr.length;
        return o0(length) + length;
    }

    public static int T(int i2, h3 h3Var) {
        int g0 = g0(i2);
        int i3 = h3Var.i();
        return g0 + o0(i3) + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int U(int i2, u5 u5Var, m6 m6Var) {
        int g0 = g0(i2) << 1;
        x2 x2Var = (x2) u5Var;
        int m = x2Var.m();
        if (m == -1) {
            m = m6Var.e(x2Var);
            x2Var.n(m);
        }
        return g0 + m;
    }

    @Deprecated
    public static int V(u5 u5Var) {
        return u5Var.i();
    }

    public static int b0(int i2, long j2) {
        return g0(i2) + i0(j2);
    }

    public static int c(int i2, c5 c5Var) {
        int g0 = g0(i2);
        int b2 = c5Var.b();
        return g0 + o0(b2) + b2;
    }

    public static int c0(int i2, h3 h3Var) {
        return (g0(1) << 1) + p0(2, i2) + T(3, h3Var);
    }

    public static int d(c5 c5Var) {
        int b2 = c5Var.b();
        return o0(b2) + b2;
    }

    public static int d0(long j2) {
        return i0(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(u5 u5Var, m6 m6Var) {
        x2 x2Var = (x2) u5Var;
        int m = x2Var.m();
        if (m == -1) {
            m = m6Var.e(x2Var);
            x2Var.n(m);
        }
        return o0(m) + m;
    }

    public static zzel f(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int g0(int i2) {
        return o0(i2 << 3);
    }

    public static int h0(int i2, long j2) {
        return g0(i2) + i0(j2);
    }

    public static int i0(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int k0(int i2) {
        if (i2 >= 0) {
            return o0(i2);
        }
        return 10;
    }

    public static int l0(int i2, int i3) {
        return g0(i2) + k0(i3);
    }

    public static int m0(int i2, long j2) {
        return g0(i2) + i0(y0(j2));
    }

    public static int n0(long j2) {
        return i0(y0(j2));
    }

    public static int o0(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int p0(int i2, int i3) {
        return g0(i2) + o0(i3);
    }

    public static int q0(int i2, long j2) {
        return g0(i2) + 8;
    }

    public static int r0(long j2) {
        return 8;
    }

    public static int s0(int i2) {
        return o0(E0(i2));
    }

    public static int t0(int i2, int i3) {
        return g0(i2) + o0(E0(i3));
    }

    public static int u0(int i2, long j2) {
        return g0(i2) + 8;
    }

    public static int v0(long j2) {
        return 8;
    }

    public static int w0(int i2) {
        return 4;
    }

    public static int x0(int i2, int i3) {
        return g0(i2) + 4;
    }

    private static long y0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int z(double d2) {
        return 8;
    }

    public static int z0(int i2) {
        return 4;
    }

    public final void N() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void O(int i2) throws IOException;

    public abstract void P(int i2, int i3) throws IOException;

    public final void Q(int i2, long j2) throws IOException {
        n(i2, y0(j2));
    }

    public abstract void R(int i2, h3 h3Var) throws IOException;

    public final void S(long j2) throws IOException {
        t(y0(j2));
    }

    public final void W(int i2) throws IOException {
        O(E0(i2));
    }

    public abstract void X(int i2, int i3) throws IOException;

    public abstract void Y(int i2, long j2) throws IOException;

    public abstract void Z(long j2) throws IOException;

    public abstract int b();

    public abstract void e0(int i2) throws IOException;

    public final void f0(int i2, int i3) throws IOException {
        X(i2, E0(i3));
    }

    public abstract void g(byte b2) throws IOException;

    public final void h(double d2) throws IOException {
        Z(Double.doubleToRawLongBits(d2));
    }

    public final void i(float f2) throws IOException {
        e0(Float.floatToRawIntBits(f2));
    }

    public abstract void j(int i2) throws IOException;

    public abstract void j0(int i2, int i3) throws IOException;

    public final void k(int i2, double d2) throws IOException {
        Y(i2, Double.doubleToRawLongBits(d2));
    }

    public final void l(int i2, float f2) throws IOException {
        j0(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void m(int i2, int i3) throws IOException;

    public abstract void n(int i2, long j2) throws IOException;

    public abstract void o(int i2, h3 h3Var) throws IOException;

    public abstract void p(int i2, u5 u5Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void q(int i2, u5 u5Var, m6 m6Var) throws IOException;

    public abstract void r(int i2, String str) throws IOException;

    public abstract void s(int i2, boolean z) throws IOException;

    public abstract void t(long j2) throws IOException;

    public abstract void u(h3 h3Var) throws IOException;

    public abstract void v(u5 u5Var) throws IOException;

    public abstract void w(String str) throws IOException;

    final void x(String str, p7 p7Var) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) p7Var);
        byte[] bytes = str.getBytes(q4.a);
        try {
            O(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzb e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzb(e3);
        }
    }

    public final void y(boolean z) throws IOException {
        g(z ? (byte) 1 : (byte) 0);
    }
}
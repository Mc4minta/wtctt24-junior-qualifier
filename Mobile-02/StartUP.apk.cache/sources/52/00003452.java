package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.zzev  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class zzev extends j3 {
    private static final Logger a = Logger.getLogger(zzev.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f7017b = k7.w();

    /* renamed from: c  reason: collision with root package name */
    a4 f7018c;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.zzev$a */
    /* loaded from: classes2.dex */
    static class a extends zzev {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f7019d;

        /* renamed from: e  reason: collision with root package name */
        private final int f7020e;

        /* renamed from: f  reason: collision with root package name */
        private final int f7021f;

        /* renamed from: g  reason: collision with root package name */
        private int f7022g;

        a(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i4)) >= 0) {
                this.f7019d = bArr;
                this.f7020e = 0;
                this.f7022g = 0;
                this.f7021f = i4;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
        }

        private final void H0(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f7019d, this.f7022g, i3);
                this.f7022g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void B(long j2) throws IOException {
            if (zzev.f7017b && q0() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f7019d;
                    int i2 = this.f7022g;
                    this.f7022g = i2 + 1;
                    k7.i(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f7019d;
                int i3 = this.f7022g;
                this.f7022g = i3 + 1;
                k7.i(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f7019d;
                    int i4 = this.f7022g;
                    this.f7022g = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), 1), e2);
                }
            }
            byte[] bArr4 = this.f7019d;
            int i5 = this.f7022g;
            this.f7022g = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void B0(int i2) throws IOException {
            if (i2 >= 0) {
                C0(i2);
            } else {
                B(i2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void C0(int i2) throws IOException {
            if (!zzev.f7017b || g3.b() || q0() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f7019d;
                        int i3 = this.f7022g;
                        this.f7022g = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), 1), e2);
                    }
                }
                byte[] bArr2 = this.f7019d;
                int i4 = this.f7022g;
                this.f7022g = i4 + 1;
                bArr2[i4] = (byte) i2;
            } else if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.f7019d;
                int i5 = this.f7022g;
                this.f7022g = i5 + 1;
                k7.i(bArr3, i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f7019d;
                int i6 = this.f7022g;
                this.f7022g = i6 + 1;
                k7.i(bArr4, i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & (-128)) == 0) {
                    byte[] bArr5 = this.f7019d;
                    int i8 = this.f7022g;
                    this.f7022g = i8 + 1;
                    k7.i(bArr5, i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f7019d;
                int i9 = this.f7022g;
                this.f7022g = i9 + 1;
                k7.i(bArr6, i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & (-128)) == 0) {
                    byte[] bArr7 = this.f7019d;
                    int i11 = this.f7022g;
                    this.f7022g = i11 + 1;
                    k7.i(bArr7, i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f7019d;
                int i12 = this.f7022g;
                this.f7022g = i12 + 1;
                k7.i(bArr8, i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & (-128)) == 0) {
                    byte[] bArr9 = this.f7019d;
                    int i14 = this.f7022g;
                    this.f7022g = i14 + 1;
                    k7.i(bArr9, i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f7019d;
                int i15 = this.f7022g;
                this.f7022g = i15 + 1;
                k7.i(bArr10, i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f7019d;
                int i16 = this.f7022g;
                this.f7022g = i16 + 1;
                k7.i(bArr11, i16, (byte) (i13 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void D(long j2) throws IOException {
            try {
                byte[] bArr = this.f7019d;
                int i2 = this.f7022g;
                int i3 = i2 + 1;
                this.f7022g = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.f7022g = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.f7022g = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.f7022g = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.f7022g = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.f7022g = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.f7022g = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.f7022g = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void E0(int i2) throws IOException {
            try {
                byte[] bArr = this.f7019d;
                int i3 = this.f7022g;
                int i4 = i3 + 1;
                this.f7022g = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.f7022g = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.f7022g = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.f7022g = i6 + 1;
                bArr[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void W(int i2, i3 i3Var) throws IOException {
            b(1, 3);
            l0(2, i2);
            k(3, i3Var);
            b(1, 4);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void X(v5 v5Var) throws IOException {
            C0(v5Var.getSerializedSize());
            v5Var.e(this);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void Y(byte[] bArr, int i2, int i3) throws IOException {
            C0(i3);
            H0(bArr, 0, i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.j3
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            H0(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void b(int i2, int i3) throws IOException {
            C0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void d0(byte b2) throws IOException {
            try {
                byte[] bArr = this.f7019d;
                int i2 = this.f7022g;
                this.f7022g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f7022g), Integer.valueOf(this.f7021f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void e0(int i2, long j2) throws IOException {
            b(i2, 1);
            D(j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void j(int i2, long j2) throws IOException {
            b(i2, 0);
            B(j2);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void j0(int i2, int i3) throws IOException {
            b(i2, 0);
            B0(i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void k(int i2, i3 i3Var) throws IOException {
            b(i2, 2);
            p(i3Var);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void l(int i2, v5 v5Var) throws IOException {
            b(1, 3);
            l0(2, i2);
            b(3, 2);
            X(v5Var);
            b(1, 4);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void l0(int i2, int i3) throws IOException {
            b(i2, 0);
            C0(i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        final void m(int i2, v5 v5Var, m6 m6Var) throws IOException {
            b(i2, 2);
            c3 c3Var = (c3) v5Var;
            int g2 = c3Var.g();
            if (g2 == -1) {
                g2 = m6Var.c(c3Var);
                c3Var.h(g2);
            }
            C0(g2);
            m6Var.b(v5Var, this.f7018c);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void n(int i2, String str) throws IOException {
            b(i2, 2);
            z(str);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void o(int i2, boolean z) throws IOException {
            b(i2, 0);
            d0(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void p(i3 i3Var) throws IOException {
            C0(i3Var.size());
            i3Var.k(this);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final int q0() {
            return this.f7021f - this.f7022g;
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void u0(int i2, int i3) throws IOException {
            b(i2, 5);
            E0(i3);
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.zzev
        public final void z(String str) throws IOException {
            int i2 = this.f7022g;
            try {
                int r = zzev.r(str.length() * 3);
                int r2 = zzev.r(str.length());
                if (r2 == r) {
                    int i3 = i2 + r2;
                    this.f7022g = i3;
                    int d2 = m7.d(str, this.f7019d, i3, q0());
                    this.f7022g = i2;
                    C0((d2 - i2) - r2);
                    this.f7022g = d2;
                    return;
                }
                C0(m7.a(str));
                this.f7022g = m7.d(str, this.f7019d, this.f7022g, q0());
            } catch (n7 e2) {
                this.f7022g = i2;
                q(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.zzev$zza */
    /* loaded from: classes2.dex */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zza(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzev.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzev() {
    }

    public static int A(String str) {
        int length;
        try {
            length = m7.a(str);
        } catch (n7 unused) {
            length = str.getBytes(n4.a).length;
        }
        return r(length) + length;
    }

    public static int A0(int i2, int i3) {
        return F0(i2) + G0(i3);
    }

    public static int E(long j2) {
        return F(j2);
    }

    public static int F(long j2) {
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

    public static int F0(int i2) {
        return r(i2 << 3);
    }

    public static int G(long j2) {
        return F(J(j2));
    }

    public static int G0(int i2) {
        if (i2 >= 0) {
            return r(i2);
        }
        return 10;
    }

    public static int H(long j2) {
        return 8;
    }

    public static int I(long j2) {
        return 8;
    }

    private static long J(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int K(double d2) {
        return 8;
    }

    public static int L(int i2, double d2) {
        return F0(i2) + 8;
    }

    public static int M(int i2, float f2) {
        return F0(i2) + 4;
    }

    public static int N(int i2, z4 z4Var) {
        return (F0(1) << 1) + w0(2, i2) + c(3, z4Var);
    }

    public static int O(int i2, v5 v5Var) {
        return (F0(1) << 1) + w0(2, i2) + F0(3) + c0(v5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(int i2, v5 v5Var, m6 m6Var) {
        return F0(i2) + e(v5Var, m6Var);
    }

    public static int Q(int i2, String str) {
        return F0(i2) + A(str);
    }

    public static int R(int i2, boolean z) {
        return F0(i2) + 1;
    }

    public static int S(i3 i3Var) {
        int size = i3Var.size();
        return r(size) + size;
    }

    public static int T(byte[] bArr) {
        int length = bArr.length;
        return r(length) + length;
    }

    public static int Z(float f2) {
        return 4;
    }

    public static int a0(int i2, i3 i3Var) {
        int F0 = F0(i2);
        int size = i3Var.size();
        return F0 + r(size) + size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int b0(int i2, v5 v5Var, m6 m6Var) {
        int F0 = F0(i2) << 1;
        c3 c3Var = (c3) v5Var;
        int g2 = c3Var.g();
        if (g2 == -1) {
            g2 = m6Var.c(c3Var);
            c3Var.h(g2);
        }
        return F0 + g2;
    }

    public static int c(int i2, z4 z4Var) {
        int F0 = F0(i2);
        int a2 = z4Var.a();
        return F0 + r(a2) + a2;
    }

    public static int c0(v5 v5Var) {
        int serializedSize = v5Var.getSerializedSize();
        return r(serializedSize) + serializedSize;
    }

    public static int d(z4 z4Var) {
        int a2 = z4Var.a();
        return r(a2) + a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(v5 v5Var, m6 m6Var) {
        c3 c3Var = (c3) v5Var;
        int g2 = c3Var.g();
        if (g2 == -1) {
            g2 = m6Var.c(c3Var);
            c3Var.h(g2);
        }
        return r(g2) + g2;
    }

    public static zzev f(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int f0(int i2, long j2) {
        return F0(i2) + F(j2);
    }

    public static int g0(int i2, i3 i3Var) {
        return (F0(1) << 1) + w0(2, i2) + a0(3, i3Var);
    }

    @Deprecated
    public static int h0(v5 v5Var) {
        return v5Var.getSerializedSize();
    }

    public static int i0(int i2, long j2) {
        return F0(i2) + F(j2);
    }

    public static int k0(int i2, long j2) {
        return F0(i2) + F(J(j2));
    }

    public static int n0(int i2, long j2) {
        return F0(i2) + 8;
    }

    public static int o0(boolean z) {
        return 1;
    }

    public static int r(int i2) {
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

    public static int s(int i2) {
        return r(x(i2));
    }

    public static int t(int i2) {
        return 4;
    }

    public static int t0(int i2, long j2) {
        return F0(i2) + 8;
    }

    public static int u(int i2) {
        return 4;
    }

    public static int v(int i2) {
        return G0(i2);
    }

    public static int v0(int i2, int i3) {
        return F0(i2) + G0(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(int i2) {
        return r(i2) + i2;
    }

    public static int w0(int i2, int i3) {
        return F0(i2) + r(i3);
    }

    private static int x(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static int x0(int i2, int i3) {
        return F0(i2) + r(x(i3));
    }

    @Deprecated
    public static int y(int i2) {
        return r(i2);
    }

    public static int y0(int i2, int i3) {
        return F0(i2) + 4;
    }

    public static int z0(int i2, int i3) {
        return F0(i2) + 4;
    }

    public abstract void B(long j2) throws IOException;

    public abstract void B0(int i2) throws IOException;

    public final void C(long j2) throws IOException {
        B(J(j2));
    }

    public abstract void C0(int i2) throws IOException;

    public abstract void D(long j2) throws IOException;

    public final void D0(int i2) throws IOException {
        C0(x(i2));
    }

    public abstract void E0(int i2) throws IOException;

    public final void U(float f2) throws IOException {
        E0(Float.floatToRawIntBits(f2));
    }

    public final void V(int i2, long j2) throws IOException {
        j(i2, J(j2));
    }

    public abstract void W(int i2, i3 i3Var) throws IOException;

    public abstract void X(v5 v5Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void Y(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public abstract void d0(byte b2) throws IOException;

    public abstract void e0(int i2, long j2) throws IOException;

    public final void g(double d2) throws IOException {
        D(Double.doubleToRawLongBits(d2));
    }

    public final void h(int i2, double d2) throws IOException {
        e0(i2, Double.doubleToRawLongBits(d2));
    }

    public final void i(int i2, float f2) throws IOException {
        u0(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void j(int i2, long j2) throws IOException;

    public abstract void j0(int i2, int i3) throws IOException;

    public abstract void k(int i2, i3 i3Var) throws IOException;

    public abstract void l(int i2, v5 v5Var) throws IOException;

    public abstract void l0(int i2, int i3) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void m(int i2, v5 v5Var, m6 m6Var) throws IOException;

    public final void m0(boolean z) throws IOException {
        d0(z ? (byte) 1 : (byte) 0);
    }

    public abstract void n(int i2, String str) throws IOException;

    public abstract void o(int i2, boolean z) throws IOException;

    public abstract void p(i3 i3Var) throws IOException;

    public final void p0(int i2, int i3) throws IOException {
        l0(i2, x(i3));
    }

    final void q(String str, n7 n7Var) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) n7Var);
        byte[] bytes = str.getBytes(n4.a);
        try {
            C0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }

    public abstract int q0();

    public final void r0() {
        if (q0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void u0(int i2, int i3) throws IOException;

    public abstract void z(String str) throws IOException;
}
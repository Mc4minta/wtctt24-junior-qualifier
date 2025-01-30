package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzbn extends z {
    private static final Logger a = Logger.getLogger(zzbn.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6672b = x3.x();

    /* renamed from: c  reason: collision with root package name */
    n0 f6673c;

    /* loaded from: classes2.dex */
    static class a extends zzbn {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f6674d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6675e;

        /* renamed from: f  reason: collision with root package name */
        private final int f6676f;

        /* renamed from: g  reason: collision with root package name */
        private int f6677g;

        a(byte[] bArr, int i2, int i3) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i4 = i2 + i3;
            if ((i2 | i3 | (bArr.length - i4)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            this.f6674d = bArr;
            this.f6675e = i2;
            this.f6677g = i2;
            this.f6676f = i4;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i2) throws IOException {
            try {
                byte[] bArr = this.f6674d;
                int i3 = this.f6677g;
                int i4 = i3 + 1;
                this.f6677g = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.f6677g = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.f6677g = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.f6677g = i6 + 1;
                bArr[i6] = i2 >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i2, int i3) throws IOException {
            y0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i2, a0 a0Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            m(3, a0Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i2, i2 i2Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            n(3, i2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i2, boolean z) throws IOException {
            G(i2, 0);
            g(z ? (byte) 1 : (byte) 0);
        }

        public final int K0() {
            return this.f6677g - this.f6675e;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j2) throws IOException {
            if (zzbn.f6672b && u() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f6674d;
                    int i2 = this.f6677g;
                    this.f6677g = i2 + 1;
                    x3.k(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f6674d;
                int i3 = this.f6677g;
                this.f6677g = i3 + 1;
                x3.k(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f6674d;
                    int i4 = this.f6677g;
                    this.f6677g = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), 1), e2);
                }
            }
            byte[] bArr4 = this.f6674d;
            int i5 = this.f6677g;
            this.f6677g = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(i2 i2Var) throws IOException {
            y0(i2Var.l());
            i2Var.i(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i2, int i3) throws IOException {
            G(i2, 0);
            x0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i2, long j2) throws IOException {
            G(i2, 1);
            c0(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.z
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public void b() {
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i2, int i3) throws IOException {
            G(i2, 0);
            y0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f6674d, this.f6677g, i3);
                this.f6677g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j2) throws IOException {
            try {
                byte[] bArr = this.f6674d;
                int i2 = this.f6677g;
                int i3 = i2 + 1;
                this.f6677g = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.f6677g = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.f6677g = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.f6677g = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.f6677g = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.f6677g = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.f6677g = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.f6677g = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b2) throws IOException {
            try {
                byte[] bArr = this.f6674d;
                int i2 = this.f6677g;
                this.f6677g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i2, int i3) throws IOException {
            G(i2, 5);
            A0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i2, long j2) throws IOException {
            G(i2, 0);
            L(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i2, a0 a0Var) throws IOException {
            G(i2, 2);
            q(a0Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            int i2 = this.f6677g;
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    y0(z3.a(str));
                    this.f6677g = z3.b(str, this.f6674d, this.f6677g, u());
                    return;
                }
                int i3 = i2 + D02;
                this.f6677g = i3;
                int b2 = z3.b(str, this.f6674d, i3, u());
                this.f6677g = i2;
                y0((b2 - i2) - D02);
                this.f6677g = b2;
            } catch (c4 e2) {
                this.f6677g = i2;
                s(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i2, i2 i2Var) throws IOException {
            G(i2, 2);
            M(i2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void o(int i2, i2 i2Var, z2 z2Var) throws IOException {
            G(i2, 2);
            q qVar = (q) i2Var;
            int c2 = qVar.c();
            if (c2 == -1) {
                c2 = z2Var.d(qVar);
                qVar.a(c2);
            }
            y0(c2);
            z2Var.g(i2Var, this.f6673c);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i2, String str) throws IOException {
            G(i2, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(a0 a0Var) throws IOException {
            y0(a0Var.size());
            a0Var.l(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void r(i2 i2Var, z2 z2Var) throws IOException {
            q qVar = (q) i2Var;
            int c2 = qVar.c();
            if (c2 == -1) {
                c2 = z2Var.d(qVar);
                qVar.a(c2);
            }
            y0(c2);
            z2Var.g(i2Var, this.f6673c);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return this.f6676f - this.f6677g;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i2) throws IOException {
            if (i2 >= 0) {
                y0(i2);
            } else {
                L(i2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i2) throws IOException {
            if (zzbn.f6672b && u() >= 10) {
                while ((i2 & (-128)) != 0) {
                    byte[] bArr = this.f6674d;
                    int i3 = this.f6677g;
                    this.f6677g = i3 + 1;
                    x3.k(bArr, i3, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.f6674d;
                int i4 = this.f6677g;
                this.f6677g = i4 + 1;
                x3.k(bArr2, i4, (byte) i2);
                return;
            }
            while ((i2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f6674d;
                    int i5 = this.f6677g;
                    this.f6677g = i5 + 1;
                    bArr3[i5] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f6677g), Integer.valueOf(this.f6676f), 1), e2);
                }
            }
            byte[] bArr4 = this.f6674d;
            int i6 = this.f6677g;
            this.f6677g = i6 + 1;
            bArr4[i6] = (byte) i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b extends a {

        /* renamed from: h  reason: collision with root package name */
        private final ByteBuffer f6678h;

        /* renamed from: i  reason: collision with root package name */
        private int f6679i;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f6678h = byteBuffer;
            this.f6679i = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn.a, com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f6678h.position(this.f6679i + K0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends zzbn {

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f6680d;

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f6681e;

        /* renamed from: f  reason: collision with root package name */
        private final int f6682f;

        c(ByteBuffer byteBuffer) {
            super();
            this.f6680d = byteBuffer;
            this.f6681e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f6682f = byteBuffer.position();
        }

        private final void K0(String str) throws IOException {
            try {
                z3.c(str, this.f6681e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i2) throws IOException {
            try {
                this.f6681e.putInt(i2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i2, int i3) throws IOException {
            y0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i2, a0 a0Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            m(3, a0Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i2, i2 i2Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            n(3, i2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i2, boolean z) throws IOException {
            G(i2, 0);
            g(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j2) throws IOException {
            while (((-128) & j2) != 0) {
                try {
                    this.f6681e.put((byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f6681e.put((byte) j2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(i2 i2Var) throws IOException {
            y0(i2Var.l());
            i2Var.i(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i2, int i3) throws IOException {
            G(i2, 0);
            x0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i2, long j2) throws IOException {
            G(i2, 1);
            c0(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.z
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f6680d.position(this.f6681e.position());
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i2, int i3) throws IOException {
            G(i2, 0);
            y0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.f6681e.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            } catch (BufferOverflowException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j2) throws IOException {
            try {
                this.f6681e.putLong(j2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b2) throws IOException {
            try {
                this.f6681e.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i2, int i3) throws IOException {
            G(i2, 5);
            A0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i2, long j2) throws IOException {
            G(i2, 0);
            L(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i2, a0 a0Var) throws IOException {
            G(i2, 2);
            q(a0Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            int position = this.f6681e.position();
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    y0(z3.a(str));
                    K0(str);
                    return;
                }
                int position2 = this.f6681e.position() + D02;
                this.f6681e.position(position2);
                K0(str);
                int position3 = this.f6681e.position();
                this.f6681e.position(position);
                y0(position3 - position2);
                this.f6681e.position(position3);
            } catch (c4 e2) {
                this.f6681e.position(position);
                s(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i2, i2 i2Var) throws IOException {
            G(i2, 2);
            M(i2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void o(int i2, i2 i2Var, z2 z2Var) throws IOException {
            G(i2, 2);
            r(i2Var, z2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i2, String str) throws IOException {
            G(i2, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(a0 a0Var) throws IOException {
            y0(a0Var.size());
            a0Var.l(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void r(i2 i2Var, z2 z2Var) throws IOException {
            q qVar = (q) i2Var;
            int c2 = qVar.c();
            if (c2 == -1) {
                c2 = z2Var.d(qVar);
                qVar.a(c2);
            }
            y0(c2);
            z2Var.g(i2Var, this.f6673c);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return this.f6681e.remaining();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i2) throws IOException {
            if (i2 >= 0) {
                y0(i2);
            } else {
                L(i2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i2) throws IOException {
            while ((i2 & (-128)) != 0) {
                try {
                    this.f6681e.put((byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                } catch (BufferOverflowException e2) {
                    throw new zzc(e2);
                }
            }
            this.f6681e.put((byte) i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d extends zzbn {

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f6683d;

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f6684e;

        /* renamed from: f  reason: collision with root package name */
        private final long f6685f;

        /* renamed from: g  reason: collision with root package name */
        private final long f6686g;

        /* renamed from: h  reason: collision with root package name */
        private final long f6687h;

        /* renamed from: i  reason: collision with root package name */
        private final long f6688i;

        /* renamed from: j  reason: collision with root package name */
        private long f6689j;

        d(ByteBuffer byteBuffer) {
            super();
            this.f6683d = byteBuffer;
            this.f6684e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long o = x3.o(byteBuffer);
            this.f6685f = o;
            long position = byteBuffer.position() + o;
            this.f6686g = position;
            long limit = o + byteBuffer.limit();
            this.f6687h = limit;
            this.f6688i = limit - 10;
            this.f6689j = position;
        }

        private final void K0(long j2) {
            this.f6684e.position((int) (j2 - this.f6685f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void A0(int i2) throws IOException {
            this.f6684e.putInt((int) (this.f6689j - this.f6685f), i2);
            this.f6689j += 4;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void G(int i2, int i3) throws IOException {
            y0((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void I(int i2, a0 a0Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            m(3, a0Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void J(int i2, i2 i2Var) throws IOException {
            G(1, 3);
            b0(2, i2);
            n(3, i2Var);
            G(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void K(int i2, boolean z) throws IOException {
            G(i2, 0);
            g(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void L(long j2) throws IOException {
            if (this.f6689j <= this.f6688i) {
                while ((j2 & (-128)) != 0) {
                    long j3 = this.f6689j;
                    this.f6689j = j3 + 1;
                    x3.c(j3, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                long j4 = this.f6689j;
                this.f6689j = 1 + j4;
                x3.c(j4, (byte) j2);
                return;
            }
            while (true) {
                long j5 = this.f6689j;
                if (j5 >= this.f6687h) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6689j), Long.valueOf(this.f6687h), 1));
                }
                if ((j2 & (-128)) == 0) {
                    this.f6689j = 1 + j5;
                    x3.c(j5, (byte) j2);
                    return;
                }
                this.f6689j = j5 + 1;
                x3.c(j5, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void M(i2 i2Var) throws IOException {
            y0(i2Var.l());
            i2Var.i(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void T(int i2, int i3) throws IOException {
            G(i2, 0);
            x0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void U(int i2, long j2) throws IOException {
            G(i2, 1);
            c0(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.z
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            c(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b() {
            this.f6683d.position((int) (this.f6689j - this.f6685f));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void b0(int i2, int i3) throws IOException {
            G(i2, 0);
            y0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = i3;
                long j3 = this.f6689j;
                if (this.f6687h - j2 >= j3) {
                    x3.l(bArr, i2, j3, j2);
                    this.f6689j += j2;
                    return;
                }
            }
            Objects.requireNonNull(bArr, "value");
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6689j), Long.valueOf(this.f6687h), Integer.valueOf(i3)));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void c0(long j2) throws IOException {
            this.f6684e.putLong((int) (this.f6689j - this.f6685f), j2);
            this.f6689j += 8;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void g(byte b2) throws IOException {
            long j2 = this.f6689j;
            if (j2 >= this.f6687h) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6689j), Long.valueOf(this.f6687h), 1));
            }
            this.f6689j = 1 + j2;
            x3.c(j2, b2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void i0(int i2, int i3) throws IOException {
            G(i2, 5);
            A0(i3);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void l(int i2, long j2) throws IOException {
            G(i2, 0);
            L(j2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m(int i2, a0 a0Var) throws IOException {
            G(i2, 2);
            q(a0Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void m0(String str) throws IOException {
            long j2 = this.f6689j;
            try {
                int D0 = zzbn.D0(str.length() * 3);
                int D02 = zzbn.D0(str.length());
                if (D02 != D0) {
                    int a = z3.a(str);
                    y0(a);
                    K0(this.f6689j);
                    z3.c(str, this.f6684e);
                    this.f6689j += a;
                    return;
                }
                int i2 = ((int) (this.f6689j - this.f6685f)) + D02;
                this.f6684e.position(i2);
                z3.c(str, this.f6684e);
                int position = this.f6684e.position() - i2;
                y0(position);
                this.f6689j += position;
            } catch (c4 e2) {
                this.f6689j = j2;
                K0(j2);
                s(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzc(e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzc(e4);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void n(int i2, i2 i2Var) throws IOException {
            G(i2, 2);
            M(i2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void o(int i2, i2 i2Var, z2 z2Var) throws IOException {
            G(i2, 2);
            r(i2Var, z2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void p(int i2, String str) throws IOException {
            G(i2, 2);
            m0(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void q(a0 a0Var) throws IOException {
            y0(a0Var.size());
            a0Var.l(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        final void r(i2 i2Var, z2 z2Var) throws IOException {
            q qVar = (q) i2Var;
            int c2 = qVar.c();
            if (c2 == -1) {
                c2 = z2Var.d(qVar);
                qVar.a(c2);
            }
            y0(c2);
            z2Var.g(i2Var, this.f6673c);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int u() {
            return (int) (this.f6687h - this.f6689j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void x0(int i2) throws IOException {
            if (i2 >= 0) {
                y0(i2);
            } else {
                L(i2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void y0(int i2) throws IOException {
            long j2;
            if (this.f6689j <= this.f6688i) {
                while (true) {
                    int i3 = i2 & (-128);
                    j2 = this.f6689j;
                    if (i3 == 0) {
                        break;
                    }
                    this.f6689j = j2 + 1;
                    x3.c(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            } else {
                while (true) {
                    j2 = this.f6689j;
                    if (j2 >= this.f6687h) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f6689j), Long.valueOf(this.f6687h), 1));
                    }
                    if ((i2 & (-128)) == 0) {
                        break;
                    }
                    this.f6689j = j2 + 1;
                    x3.c(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
            this.f6689j = 1 + j2;
            x3.c(j2, (byte) i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzc(java.lang.String r3) {
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
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzc(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzbn.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzbn() {
    }

    public static int A(int i2, p1 p1Var) {
        return (B0(1) << 1) + n0(2, i2) + d(3, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i2, i2 i2Var, z2 z2Var) {
        return B0(i2) + E(i2Var, z2Var);
    }

    public static int B0(int i2) {
        return D0(i2 << 3);
    }

    public static int C(int i2, String str) {
        return B0(i2) + q0(str);
    }

    public static int C0(int i2) {
        if (i2 >= 0) {
            return D0(i2);
        }
        return 10;
    }

    public static int D(a0 a0Var) {
        int size = a0Var.size();
        return D0(size) + size;
    }

    public static int D0(int i2) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(i2 i2Var, z2 z2Var) {
        q qVar = (q) i2Var;
        int c2 = qVar.c();
        if (c2 == -1) {
            c2 = z2Var.d(qVar);
            qVar.a(c2);
        }
        return D0(c2) + c2;
    }

    public static int E0(int i2) {
        return D0(I0(i2));
    }

    public static int F(boolean z) {
        return 1;
    }

    public static int F0(int i2) {
        return 4;
    }

    public static int G0(int i2) {
        return 4;
    }

    public static int H0(int i2) {
        return C0(i2);
    }

    private static int I0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    @Deprecated
    public static int J0(int i2) {
        return D0(i2);
    }

    public static int N(int i2, a0 a0Var) {
        int B0 = B0(i2);
        int size = a0Var.size();
        return B0 + D0(size) + size;
    }

    public static int O(int i2, i2 i2Var) {
        return B0(i2) + R(i2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int P(int i2, i2 i2Var, z2 z2Var) {
        int B0 = B0(i2) << 1;
        q qVar = (q) i2Var;
        int c2 = qVar.c();
        if (c2 == -1) {
            c2 = z2Var.d(qVar);
            qVar.a(c2);
        }
        return B0 + c2;
    }

    public static int Q(int i2, boolean z) {
        return B0(i2) + 1;
    }

    public static int R(i2 i2Var) {
        int l2 = i2Var.l();
        return D0(l2) + l2;
    }

    public static zzbn S(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int W(int i2, long j2) {
        return B0(i2) + h0(j2);
    }

    public static int X(int i2, a0 a0Var) {
        return (B0(1) << 1) + n0(2, i2) + N(3, a0Var);
    }

    public static int Y(int i2, i2 i2Var) {
        return (B0(1) << 1) + n0(2, i2) + O(3, i2Var);
    }

    @Deprecated
    public static int Z(i2 i2Var) {
        return i2Var.l();
    }

    public static int a0(byte[] bArr) {
        int length = bArr.length;
        return D0(length) + length;
    }

    public static int d(int i2, p1 p1Var) {
        int B0 = B0(i2);
        int a2 = p1Var.a();
        return B0 + D0(a2) + a2;
    }

    public static int d0(int i2, long j2) {
        return B0(i2) + h0(j2);
    }

    public static int e(p1 p1Var) {
        int a2 = p1Var.a();
        return D0(a2) + a2;
    }

    public static int e0(long j2) {
        return h0(j2);
    }

    public static zzbn f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return x3.y() ? new d(byteBuffer) : new c(byteBuffer);
    }

    public static int g0(int i2, long j2) {
        return B0(i2) + h0(u0(j2));
    }

    public static int h0(long j2) {
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

    public static int j0(int i2, int i3) {
        return B0(i2) + C0(i3);
    }

    public static int k0(int i2, long j2) {
        return B0(i2) + 8;
    }

    public static int l0(long j2) {
        return h0(u0(j2));
    }

    public static int n0(int i2, int i3) {
        return B0(i2) + D0(i3);
    }

    public static int o0(int i2, long j2) {
        return B0(i2) + 8;
    }

    public static int p0(long j2) {
        return 8;
    }

    public static int q0(String str) {
        int length;
        try {
            length = z3.a(str);
        } catch (c4 unused) {
            length = str.getBytes(g1.a).length;
        }
        return D0(length) + length;
    }

    public static int r0(int i2, int i3) {
        return B0(i2) + D0(I0(i3));
    }

    public static int s0(long j2) {
        return 8;
    }

    public static int t0(int i2, int i3) {
        return B0(i2) + 4;
    }

    private static long u0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int v0(int i2, int i3) {
        return B0(i2) + 4;
    }

    public static int w(double d2) {
        return 8;
    }

    public static int w0(int i2, int i3) {
        return B0(i2) + C0(i3);
    }

    public static int x(float f2) {
        return 4;
    }

    public static int y(int i2, double d2) {
        return B0(i2) + 8;
    }

    public static int z(int i2, float f2) {
        return B0(i2) + 4;
    }

    public abstract void A0(int i2) throws IOException;

    public abstract void G(int i2, int i3) throws IOException;

    public final void H(int i2, long j2) throws IOException {
        l(i2, u0(j2));
    }

    public abstract void I(int i2, a0 a0Var) throws IOException;

    public abstract void J(int i2, i2 i2Var) throws IOException;

    public abstract void K(int i2, boolean z) throws IOException;

    public abstract void L(long j2) throws IOException;

    public abstract void M(i2 i2Var) throws IOException;

    public abstract void T(int i2, int i3) throws IOException;

    public abstract void U(int i2, long j2) throws IOException;

    public final void V(long j2) throws IOException {
        L(u0(j2));
    }

    public abstract void b() throws IOException;

    public abstract void b0(int i2, int i3) throws IOException;

    public abstract void c(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void c0(long j2) throws IOException;

    public final void f0(int i2, int i3) throws IOException {
        b0(i2, I0(i3));
    }

    public abstract void g(byte b2) throws IOException;

    public final void h(double d2) throws IOException {
        c0(Double.doubleToRawLongBits(d2));
    }

    public final void i(float f2) throws IOException {
        A0(Float.floatToRawIntBits(f2));
    }

    public abstract void i0(int i2, int i3) throws IOException;

    public final void j(int i2, double d2) throws IOException {
        U(i2, Double.doubleToRawLongBits(d2));
    }

    public final void k(int i2, float f2) throws IOException {
        i0(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void l(int i2, long j2) throws IOException;

    public abstract void m(int i2, a0 a0Var) throws IOException;

    public abstract void m0(String str) throws IOException;

    public abstract void n(int i2, i2 i2Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(int i2, i2 i2Var, z2 z2Var) throws IOException;

    public abstract void p(int i2, String str) throws IOException;

    public abstract void q(a0 a0Var) throws IOException;

    abstract void r(i2 i2Var, z2 z2Var) throws IOException;

    final void s(String str, c4 c4Var) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c4Var);
        byte[] bytes = str.getBytes(g1.a);
        try {
            y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzc e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzc(e3);
        }
    }

    public final void t(boolean z) throws IOException {
        g(z ? (byte) 1 : (byte) 0);
    }

    public abstract int u();

    public abstract void x0(int i2) throws IOException;

    public abstract void y0(int i2) throws IOException;

    public final void z0(int i2) throws IOException {
        y0(I0(i2));
    }
}
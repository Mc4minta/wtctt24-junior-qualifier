package com.google.firebase.crashlytics.c.m;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class c implements Flushable {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8996b;

    /* renamed from: c  reason: collision with root package name */
    private int f8997c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final OutputStream f8998d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f8998d = outputStream;
        this.a = bArr;
        this.f8996b = bArr.length;
    }

    public static int a(int i2, boolean z) {
        return o(i2) + b(z);
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(int i2, com.google.firebase.crashlytics.c.m.a aVar) {
        return o(i2) + d(aVar);
    }

    public static int d(com.google.firebase.crashlytics.c.m.a aVar) {
        return k(aVar.f()) + aVar.f();
    }

    public static int e(int i2, int i3) {
        return o(i2) + f(i3);
    }

    public static int f(int i2) {
        return j(i2);
    }

    public static int g(int i2, float f2) {
        return o(i2) + h(f2);
    }

    public static int h(float f2) {
        return 4;
    }

    public static int j(int i2) {
        if (i2 >= 0) {
            return k(i2);
        }
        return 10;
    }

    public static int k(int i2) {
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

    public static int l(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int m(int i2, int i3) {
        return o(i2) + n(i3);
    }

    public static int n(int i2) {
        return k(t(i2));
    }

    public static int o(int i2) {
        return k(e.a(i2, 0));
    }

    public static int p(int i2, int i3) {
        return o(i2) + q(i3);
    }

    public static int q(int i2) {
        return k(i2);
    }

    public static int r(int i2, long j2) {
        return o(i2) + s(j2);
    }

    public static int s(long j2) {
        return l(j2);
    }

    public static int t(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static c u(OutputStream outputStream) {
        return v(outputStream, 4096);
    }

    public static c v(OutputStream outputStream, int i2) {
        return new c(outputStream, new byte[i2]);
    }

    private void y() throws IOException {
        OutputStream outputStream = this.f8998d;
        if (outputStream != null) {
            outputStream.write(this.a, 0, this.f8997c);
            this.f8997c = 0;
            return;
        }
        throw new a();
    }

    public void A(boolean z) throws IOException {
        L(z ? 1 : 0);
    }

    public void B(int i2, com.google.firebase.crashlytics.c.m.a aVar) throws IOException {
        Y(i2, 2);
        C(aVar);
    }

    public void C(com.google.firebase.crashlytics.c.m.a aVar) throws IOException {
        T(aVar.f());
        M(aVar);
    }

    public void E(int i2, int i3) throws IOException {
        Y(i2, 0);
        G(i3);
    }

    public void G(int i2) throws IOException {
        J(i2);
    }

    public void H(int i2, float f2) throws IOException {
        Y(i2, 5);
        I(f2);
    }

    public void I(float f2) throws IOException {
        S(Float.floatToRawIntBits(f2));
    }

    public void J(int i2) throws IOException {
        if (i2 >= 0) {
            T(i2);
        } else {
            U(i2);
        }
    }

    public void K(byte b2) throws IOException {
        if (this.f8997c == this.f8996b) {
            y();
        }
        byte[] bArr = this.a;
        int i2 = this.f8997c;
        this.f8997c = i2 + 1;
        bArr[i2] = b2;
    }

    public void L(int i2) throws IOException {
        K((byte) i2);
    }

    public void M(com.google.firebase.crashlytics.c.m.a aVar) throws IOException {
        N(aVar, 0, aVar.f());
    }

    public void N(com.google.firebase.crashlytics.c.m.a aVar, int i2, int i3) throws IOException {
        int i4 = this.f8996b;
        int i5 = this.f8997c;
        if (i4 - i5 >= i3) {
            aVar.d(this.a, i2, i5, i3);
            this.f8997c += i3;
            return;
        }
        int i6 = i4 - i5;
        aVar.d(this.a, i2, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f8997c = this.f8996b;
        y();
        if (i8 <= this.f8996b) {
            aVar.d(this.a, i7, 0, i8);
            this.f8997c = i8;
            return;
        }
        InputStream e2 = aVar.e();
        long j2 = i7;
        if (j2 != e2.skip(j2)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i8 > 0) {
            int min = Math.min(i8, this.f8996b);
            int read = e2.read(this.a, 0, min);
            if (read == min) {
                this.f8998d.write(this.a, 0, read);
                i8 -= read;
            } else {
                throw new IllegalStateException("Read failed.");
            }
        }
    }

    public void O(byte[] bArr) throws IOException {
        Q(bArr, 0, bArr.length);
    }

    public void Q(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f8996b;
        int i5 = this.f8997c;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.a, i5, i3);
            this.f8997c += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f8997c = this.f8996b;
        y();
        if (i8 <= this.f8996b) {
            System.arraycopy(bArr, i7, this.a, 0, i8);
            this.f8997c = i8;
            return;
        }
        this.f8998d.write(bArr, i7, i8);
    }

    public void S(int i2) throws IOException {
        L(i2 & 255);
        L((i2 >> 8) & 255);
        L((i2 >> 16) & 255);
        L((i2 >> 24) & 255);
    }

    public void T(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            L((i2 & 127) | 128);
            i2 >>>= 7;
        }
        L(i2);
    }

    public void U(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            L((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        L((int) j2);
    }

    public void V(int i2, int i3) throws IOException {
        Y(i2, 0);
        W(i3);
    }

    public void W(int i2) throws IOException {
        T(t(i2));
    }

    public void Y(int i2, int i3) throws IOException {
        T(e.a(i2, i3));
    }

    public void Z(int i2, int i3) throws IOException {
        Y(i2, 0);
        a0(i3);
    }

    public void a0(int i2) throws IOException {
        T(i2);
    }

    public void b0(int i2, long j2) throws IOException {
        Y(i2, 0);
        c0(j2);
    }

    public void c0(long j2) throws IOException {
        U(j2);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f8998d != null) {
            y();
        }
    }

    public void z(int i2, boolean z) throws IOException {
        Y(i2, 0);
        A(z);
    }
}
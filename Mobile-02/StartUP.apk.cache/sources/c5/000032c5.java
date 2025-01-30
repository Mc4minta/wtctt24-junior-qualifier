package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class m4 {
    private final ByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    private zzbn f6516b;

    /* renamed from: c  reason: collision with root package name */
    private int f6517c;

    private m4(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private m4(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, i2, i3));
    }

    private static int A(int i2) {
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

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(i4 + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    private final void e(int i2) throws IOException {
        byte b2 = (byte) i2;
        if (!this.a.hasRemaining()) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(b2);
    }

    private final void f(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            e((i2 & 127) | 128);
            i2 >>>= 7;
        }
        e(i2);
    }

    public static int g(int i2, s4 s4Var) {
        int y = y(i2);
        int d2 = s4Var.d();
        return y + A(d2) + d2;
    }

    public static int h(int i2, String str) {
        return y(i2) + r(str);
    }

    public static int i(int i2, byte[] bArr) {
        return y(i2) + s(bArr);
    }

    public static int m(int i2, long j2) {
        return y(i2) + x(j2);
    }

    private static void n(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        char charAt;
        int i4;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i5 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                char c2 = charAt2;
                if (charAt2 >= 128) {
                    if (charAt2 < 2048) {
                        i4 = (charAt2 >>> 6) | 960;
                    } else if (charAt2 >= 55296 && 57343 >= charAt2) {
                        int i6 = i5 + 1;
                        if (i6 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i5 = i6;
                                i5++;
                            } else {
                                i5 = i6;
                            }
                        }
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i5 - 1);
                        throw new IllegalArgumentException(sb.toString());
                    } else {
                        byteBuffer.put((byte) ((charAt2 >>> '\f') | 480));
                        i4 = ((charAt2 >>> 6) & 63) | 128;
                    }
                    byteBuffer.put((byte) i4);
                    c2 = (charAt2 & '?') | 128;
                }
                byteBuffer.put((byte) c2);
                i5++;
            }
            return;
        }
        try {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i7 = remaining + arrayOffset;
            while (i5 < length2) {
                int i8 = i5 + arrayOffset;
                if (i8 >= i7 || (charAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                array[i8] = (byte) charAt;
                i5++;
            }
            if (i5 == length2) {
                i2 = arrayOffset + length2;
            } else {
                i2 = arrayOffset + i5;
                while (i5 < length2) {
                    char charAt4 = charSequence.charAt(i5);
                    if (charAt4 >= 128 || i2 >= i7) {
                        if (charAt4 < 2048 && i2 <= i7 - 2) {
                            int i9 = i2 + 1;
                            array[i2] = (byte) ((charAt4 >>> 6) | 960);
                            i2 = i9 + 1;
                            array[i9] = (byte) ((charAt4 & '?') | 128);
                        } else if ((charAt4 >= 55296 && 57343 >= charAt4) || i2 > i7 - 3) {
                            if (i2 > i7 - 4) {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt4);
                                sb2.append(" at index ");
                                sb2.append(i2);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            int i10 = i5 + 1;
                            if (i10 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i10);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    int i11 = i2 + 1;
                                    array[i2] = (byte) ((codePoint2 >>> 18) | 240);
                                    int i12 = i11 + 1;
                                    array[i11] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                    int i13 = i12 + 1;
                                    array[i12] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                    i2 = i13 + 1;
                                    array[i13] = (byte) ((codePoint2 & 63) | 128);
                                    i5 = i10;
                                } else {
                                    i5 = i10;
                                }
                            }
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i5 - 1);
                            throw new IllegalArgumentException(sb3.toString());
                        } else {
                            int i14 = i2 + 1;
                            array[i2] = (byte) ((charAt4 >>> '\f') | 480);
                            int i15 = i14 + 1;
                            array[i14] = (byte) (((charAt4 >>> 6) & 63) | 128);
                            i3 = i15 + 1;
                            array[i15] = (byte) ((charAt4 & '?') | 128);
                        }
                        i5++;
                    } else {
                        i3 = i2 + 1;
                        array[i2] = (byte) charAt4;
                    }
                    i2 = i3;
                    i5++;
                }
            }
            byteBuffer.position(i2 - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e2) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e2);
            throw bufferOverflowException;
        }
    }

    public static m4 q(byte[] bArr) {
        return t(bArr, 0, bArr.length);
    }

    public static int r(String str) {
        int a = a(str);
        return A(a) + a;
    }

    public static int s(byte[] bArr) {
        return A(bArr.length) + bArr.length;
    }

    public static m4 t(byte[] bArr, int i2, int i3) {
        return new m4(bArr, 0, i3);
    }

    public static long v(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int x(long j2) {
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

    public static int y(int i2) {
        return A(i2 << 3);
    }

    public static int z(int i2) {
        if (i2 >= 0) {
            return A(i2);
        }
        return 10;
    }

    public final void b(int i2, s4 s4Var) throws IOException {
        j(i2, 2);
        if (s4Var.a < 0) {
            s4Var.d();
        }
        f(s4Var.a);
        s4Var.b(this);
    }

    public final void c(int i2, String str) throws IOException {
        j(i2, 2);
        try {
            int A = A(str.length());
            if (A != A(str.length() * 3)) {
                f(a(str));
                n(str, this.a);
                return;
            }
            int position = this.a.position();
            if (this.a.remaining() < A) {
                throw new zzft(position + A, this.a.limit());
            }
            this.a.position(position + A);
            n(str, this.a);
            int position2 = this.a.position();
            this.a.position(position);
            f((position2 - position) - A);
            this.a.position(position2);
        } catch (BufferOverflowException e2) {
            zzft zzftVar = new zzft(this.a.position(), this.a.limit());
            zzftVar.initCause(e2);
            throw zzftVar;
        }
    }

    public final void d(int i2, byte[] bArr) throws IOException {
        j(i2, 2);
        f(bArr.length);
        int length = bArr.length;
        if (this.a.remaining() < length) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(bArr, 0, length);
    }

    public final void j(int i2, int i3) throws IOException {
        f((i2 << 3) | i3);
    }

    public final void k(int i2, boolean z) throws IOException {
        j(25, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        if (!this.a.hasRemaining()) {
            throw new zzft(this.a.position(), this.a.limit());
        }
        this.a.put(b2);
    }

    public final void l(int i2, int i3) throws IOException {
        j(i2, 0);
        if (i3 >= 0) {
            f(i3);
        } else {
            w(i3);
        }
    }

    public final void o(int i2, i2 i2Var) throws IOException {
        if (this.f6516b != null) {
            if (this.f6517c != this.a.position()) {
                this.f6516b.c(this.a.array(), this.f6517c, this.a.position() - this.f6517c);
            }
            zzbn zzbnVar = this.f6516b;
            zzbnVar.n(i2, i2Var);
            zzbnVar.b();
            this.f6517c = this.a.position();
        }
        this.f6516b = zzbn.f(this.a);
        this.f6517c = this.a.position();
        zzbn zzbnVar2 = this.f6516b;
        zzbnVar2.n(i2, i2Var);
        zzbnVar2.b();
        this.f6517c = this.a.position();
    }

    public final void p() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.a.remaining())));
        }
    }

    public final void u(int i2, long j2) throws IOException {
        j(i2, 0);
        w(j2);
    }

    public final void w(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            e((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        e((int) j2);
    }
}
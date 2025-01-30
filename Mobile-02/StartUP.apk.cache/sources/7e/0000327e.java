package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class d4 extends a4 {
    private static int f(byte[] bArr, int i2, long j2, int i3) {
        int d2;
        int l2;
        int f2;
        if (i3 == 0) {
            d2 = z3.d(i2);
            return d2;
        } else if (i3 == 1) {
            l2 = z3.l(i2, x3.a(bArr, j2));
            return l2;
        } else if (i3 == 2) {
            f2 = z3.f(i2, x3.a(bArr, j2), x3.a(bArr, j2 + 1));
            return f2;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ba, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.a4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.d4.a(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.a4
    public final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c2;
        long j2;
        long j3;
        long j4;
        char c3;
        int i4;
        char charAt;
        long j5 = i2;
        long j6 = i3 + j5;
        int length = charSequence.length();
        if (length > i3 || bArr.length - i3 < i2) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i2 + i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j2 = 1;
            if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            x3.k(bArr, j5, (byte) charAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 == length) {
            return (int) j5;
        }
        while (i5 < length) {
            char charAt3 = charSequence.charAt(i5);
            if (charAt3 < c2 && j5 < j6) {
                long j7 = j5 + j2;
                x3.k(bArr, j5, (byte) charAt3);
                j4 = j2;
                j3 = j7;
                c3 = c2;
            } else if (charAt3 < 2048 && j5 <= j6 - 2) {
                long j8 = j5 + j2;
                x3.k(bArr, j5, (byte) ((charAt3 >>> 6) | 960));
                long j9 = j8 + j2;
                x3.k(bArr, j8, (byte) ((charAt3 & '?') | 128));
                long j10 = j2;
                c3 = 128;
                j3 = j9;
                j4 = j10;
            } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j5 > j6 - 3) {
                if (j5 > j6 - 4) {
                    if (55296 > charAt3 || charAt3 > 57343 || ((i4 = i5 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j5);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    throw new c4(i5, length);
                }
                int i6 = i5 + 1;
                if (i6 != length) {
                    char charAt4 = charSequence.charAt(i6);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j11 = j5 + 1;
                        x3.k(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                        long j12 = j11 + 1;
                        c3 = 128;
                        x3.k(bArr, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j13 = j12 + 1;
                        x3.k(bArr, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                        j4 = 1;
                        j3 = j13 + 1;
                        x3.k(bArr, j13, (byte) ((codePoint & 63) | 128));
                        i5 = i6;
                    } else {
                        i5 = i6;
                    }
                }
                throw new c4(i5 - 1, length);
            } else {
                long j14 = j5 + j2;
                x3.k(bArr, j5, (byte) ((charAt3 >>> '\f') | 480));
                long j15 = j14 + j2;
                x3.k(bArr, j14, (byte) (((charAt3 >>> 6) & 63) | 128));
                x3.k(bArr, j15, (byte) ((charAt3 & '?') | 128));
                j3 = j15 + 1;
                j4 = 1;
                c3 = 128;
            }
            i5++;
            c2 = c3;
            long j16 = j4;
            j5 = j3;
            j2 = j16;
        }
        return (int) j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.a4
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c2;
        int i2;
        long j2;
        int i3;
        int i4;
        long j3;
        char c3;
        char charAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long o = x3.o(byteBuffer);
        long position = byteBuffer.position() + o;
        long limit = byteBuffer.limit() + o;
        int length = charSequence.length();
        if (length > limit - position) {
            char charAt2 = charSequence.charAt(length - 1);
            int limit2 = byteBuffer.limit();
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(limit2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            x3.c(position, (byte) charAt);
            i5++;
            position++;
        }
        if (i5 == length) {
            i2 = (int) (position - o);
        } else {
            while (i5 < length) {
                char charAt3 = charSequence.charAt(i5);
                if (charAt3 >= c2 || position >= limit) {
                    if (charAt3 >= 2048 || position > limit - 2) {
                        j2 = o;
                        if ((charAt3 >= 55296 && 57343 >= charAt3) || position > limit - 3) {
                            if (position > limit - 4) {
                                if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                                    throw new c4(i5, length);
                                }
                                StringBuilder sb2 = new StringBuilder(46);
                                sb2.append("Failed writing ");
                                sb2.append(charAt3);
                                sb2.append(" at index ");
                                sb2.append(position);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i4 = i5 + 1;
                            if (i4 != length) {
                                char charAt4 = charSequence.charAt(i4);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    j3 = limit;
                                    long j4 = position + 1;
                                    x3.c(position, (byte) ((codePoint >>> 18) | 240));
                                    long j5 = j4 + 1;
                                    c3 = 128;
                                    x3.c(j4, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j5 + 1;
                                    x3.c(j5, (byte) (((codePoint >>> 6) & 63) | 128));
                                    x3.c(j6, (byte) ((codePoint & 63) | 128));
                                    position = j6 + 1;
                                } else {
                                    i5 = i4;
                                }
                            }
                            throw new c4(i5 - 1, length);
                        }
                        long j7 = position + 1;
                        x3.c(position, (byte) ((charAt3 >>> '\f') | 480));
                        long j8 = j7 + 1;
                        x3.c(j7, (byte) (((charAt3 >>> 6) & 63) | 128));
                        x3.c(j8, (byte) ((charAt3 & '?') | 128));
                        position = j8 + 1;
                    } else {
                        j2 = o;
                        long j9 = position + 1;
                        x3.c(position, (byte) ((charAt3 >>> 6) | 960));
                        x3.c(j9, (byte) ((charAt3 & '?') | 128));
                        position = j9 + 1;
                    }
                    j3 = limit;
                    i4 = i5;
                    c3 = 128;
                } else {
                    x3.c(position, (byte) charAt3);
                    j3 = limit;
                    i4 = i5;
                    c3 = c2;
                    position++;
                    j2 = o;
                }
                c2 = c3;
                o = j2;
                limit = j3;
                i5 = i4 + 1;
            }
            i2 = (int) (position - o);
            byteBuffer2 = byteBuffer;
        }
        byteBuffer2.position(i2);
    }
}
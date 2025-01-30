package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class o7 extends n7 {
    private static int e(byte[] bArr, int i2, long j2, int i3) {
        int h2;
        int i4;
        int j3;
        if (i3 == 0) {
            h2 = l7.h(i2);
            return h2;
        } else if (i3 == 1) {
            i4 = l7.i(i2, j7.a(bArr, j2));
            return i4;
        } else if (i3 == 2) {
            j3 = l7.j(i2, j7.a(bArr, j2), j7.a(bArr, j2 + 1));
            return j3;
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
    @Override // com.google.android.gms.internal.measurement.n7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.o7.a(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.n7
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
            j7.l(bArr, j5, (byte) charAt);
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
                j7.l(bArr, j5, (byte) charAt3);
                j4 = j2;
                j3 = j7;
                c3 = c2;
            } else if (charAt3 < 2048 && j5 <= j6 - 2) {
                long j8 = j5 + j2;
                j7.l(bArr, j5, (byte) ((charAt3 >>> 6) | 960));
                long j9 = j8 + j2;
                j7.l(bArr, j8, (byte) ((charAt3 & '?') | 128));
                long j10 = j2;
                c3 = 128;
                j3 = j9;
                j4 = j10;
            } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j5 > j6 - 3) {
                if (j5 <= j6 - 4) {
                    int i6 = i5 + 1;
                    if (i6 != length) {
                        char charAt4 = charSequence.charAt(i6);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j11 = j5 + 1;
                            j7.l(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                            long j12 = j11 + 1;
                            c3 = 128;
                            j7.l(bArr, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j13 = j12 + 1;
                            j7.l(bArr, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                            j4 = 1;
                            j3 = j13 + 1;
                            j7.l(bArr, j13, (byte) ((codePoint & 63) | 128));
                            i5 = i6;
                        } else {
                            i5 = i6;
                        }
                    }
                    throw new p7(i5 - 1, length);
                } else if (55296 <= charAt3 && charAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                    throw new p7(i5, length);
                } else {
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(j5);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else {
                long j14 = j5 + j2;
                j7.l(bArr, j5, (byte) ((charAt3 >>> '\f') | 480));
                long j15 = j14 + j2;
                j7.l(bArr, j14, (byte) (((charAt3 >>> 6) & 63) | 128));
                j7.l(bArr, j15, (byte) ((charAt3 & '?') | 128));
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
    @Override // com.google.android.gms.internal.measurement.n7
    public final String c(byte[] bArr, int i2, int i3) throws zzfm {
        boolean l2;
        boolean l3;
        boolean m;
        boolean n;
        boolean l4;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte a = j7.a(bArr, i2);
                l4 = k7.l(a);
                if (!l4) {
                    break;
                }
                i2++;
                k7.i(a, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte a2 = j7.a(bArr, i2);
                l2 = k7.l(a2);
                if (l2) {
                    int i8 = i6 + 1;
                    k7.i(a2, cArr, i6);
                    while (i7 < i4) {
                        byte a3 = j7.a(bArr, i7);
                        l3 = k7.l(a3);
                        if (!l3) {
                            break;
                        }
                        i7++;
                        k7.i(a3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    m = k7.m(a2);
                    if (!m) {
                        n = k7.n(a2);
                        if (n) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                k7.g(a2, j7.a(bArr, i7), j7.a(bArr, i9), cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzfm.f();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            int i11 = i10 + 1;
                            k7.f(a2, j7.a(bArr, i7), j7.a(bArr, i10), j7.a(bArr, i11), cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzfm.f();
                        }
                    } else if (i7 < i4) {
                        k7.h(a2, j7.a(bArr, i7), cArr, i6);
                        i2 = i7 + 1;
                        i6++;
                    } else {
                        throw zzfm.f();
                    }
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }
}
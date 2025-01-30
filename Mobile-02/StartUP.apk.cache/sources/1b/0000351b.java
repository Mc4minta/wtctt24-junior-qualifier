package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class m7 extends n7 {
    @Override // com.google.android.gms.internal.measurement.n7
    final int a(int i2, byte[] bArr, int i3, int i4) {
        int m;
        int m2;
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return 0;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i4) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (b2 >= -16) {
                    if (i5 >= i4 - 2) {
                        m2 = l7.m(bArr, i5, i4);
                        return m2;
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i5 >= i4 - 1) {
                    m = l7.m(bArr, i5, i4);
                    return m;
                } else {
                    int i8 = i5 + 1;
                    byte b4 = bArr[i5];
                    if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                        i3 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i3 = i5;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.measurement.n7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.m7.b(java.lang.CharSequence, byte[], int, int):int");
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
                byte b2 = bArr[i2];
                l4 = k7.l(b2);
                if (!l4) {
                    break;
                }
                i2++;
                k7.i(b2, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte b3 = bArr[i2];
                l2 = k7.l(b3);
                if (l2) {
                    int i8 = i6 + 1;
                    k7.i(b3, cArr, i6);
                    while (i7 < i4) {
                        byte b4 = bArr[i7];
                        l3 = k7.l(b4);
                        if (!l3) {
                            break;
                        }
                        i7++;
                        k7.i(b4, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    m = k7.m(b3);
                    if (!m) {
                        n = k7.n(b3);
                        if (n) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                k7.g(b3, bArr[i7], bArr[i9], cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzfm.f();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            byte b5 = bArr[i7];
                            int i11 = i10 + 1;
                            k7.f(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzfm.f();
                        }
                    } else if (i7 < i4) {
                        k7.h(b3, bArr[i7], cArr, i6);
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
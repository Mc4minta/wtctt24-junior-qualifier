package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class d3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, byte[] bArr, int i3, int i4, c3 c3Var) throws zzfm {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                return i3 + 4;
                            }
                            throw zzfm.c();
                        }
                        int i6 = (i2 & (-8)) | 4;
                        int i7 = 0;
                        while (i3 < i4) {
                            i3 = i(bArr, i3, c3Var);
                            i7 = c3Var.a;
                            if (i7 == i6) {
                                break;
                            }
                            i3 = a(i7, bArr, i3, i4, c3Var);
                        }
                        if (i3 > i4 || i7 != i6) {
                            throw zzfm.e();
                        }
                        return i3;
                    }
                    return i(bArr, i3, c3Var) + c3Var.a;
                }
                return i3 + 8;
            }
            return k(bArr, i3, c3Var);
        }
        throw zzfm.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, byte[] bArr, int i3, int i4, v4<?> v4Var, c3 c3Var) {
        o4 o4Var = (o4) v4Var;
        int i5 = i(bArr, i3, c3Var);
        o4Var.l(c3Var.a);
        while (i5 < i4) {
            int i6 = i(bArr, i5, c3Var);
            if (i2 != c3Var.a) {
                break;
            }
            i5 = i(bArr, i6, c3Var);
            o4Var.l(c3Var.a);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4, c7 c7Var, c3 c3Var) throws zzfm {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int k2 = k(bArr, i3, c3Var);
                c7Var.c(i2, Long.valueOf(c3Var.f7067b));
                return k2;
            } else if (i5 == 1) {
                c7Var.c(i2, Long.valueOf(l(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int i6 = i(bArr, i3, c3Var);
                int i7 = c3Var.a;
                if (i7 >= 0) {
                    if (i7 <= bArr.length - i6) {
                        if (i7 == 0) {
                            c7Var.c(i2, h3.a);
                        } else {
                            c7Var.c(i2, h3.p(bArr, i6, i7));
                        }
                        return i6 + i7;
                    }
                    throw zzfm.a();
                }
                throw zzfm.b();
            } else if (i5 != 3) {
                if (i5 == 5) {
                    c7Var.c(i2, Integer.valueOf(h(bArr, i3)));
                    return i3 + 4;
                }
                throw zzfm.c();
            } else {
                c7 g2 = c7.g();
                int i8 = (i2 & (-8)) | 4;
                int i9 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int i10 = i(bArr, i3, c3Var);
                    int i11 = c3Var.a;
                    i9 = i11;
                    if (i11 == i8) {
                        i3 = i10;
                        break;
                    }
                    int c2 = c(i9, bArr, i10, i4, g2, c3Var);
                    i9 = i11;
                    i3 = c2;
                }
                if (i3 <= i4 && i9 == i8) {
                    c7Var.c(i2, g2);
                    return i3;
                }
                throw zzfm.e();
            }
        }
        throw zzfm.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, byte[] bArr, int i3, c3 c3Var) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c3Var.a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            c3Var.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            c3Var.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            c3Var.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                c3Var.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(m6<?> m6Var, int i2, byte[] bArr, int i3, int i4, v4<?> v4Var, c3 c3Var) throws IOException {
        int g2 = g(m6Var, bArr, i3, i4, c3Var);
        v4Var.add(c3Var.f7068c);
        while (g2 < i4) {
            int i5 = i(bArr, g2, c3Var);
            if (i2 != c3Var.a) {
                break;
            }
            g2 = g(m6Var, bArr, i5, i4, c3Var);
            v4Var.add(c3Var.f7068c);
        }
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(m6 m6Var, byte[] bArr, int i2, int i3, int i4, c3 c3Var) throws IOException {
        y5 y5Var = (y5) m6Var;
        Object a = y5Var.a();
        int o = y5Var.o(a, bArr, i2, i3, i4, c3Var);
        y5Var.b(a);
        c3Var.f7068c = a;
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(m6 m6Var, byte[] bArr, int i2, int i3, c3 c3Var) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = d(i5, bArr, i4, c3Var);
            i5 = c3Var.a;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object a = m6Var.a();
            int i7 = i5 + i6;
            m6Var.h(a, bArr, i6, i7, c3Var);
            m6Var.b(a);
            c3Var.f7068c = a;
            return i7;
        }
        throw zzfm.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(byte[] bArr, int i2, c3 c3Var) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            c3Var.a = b2;
            return i3;
        }
        return d(b2, bArr, i3, c3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(byte[] bArr, int i2, v4<?> v4Var, c3 c3Var) throws IOException {
        o4 o4Var = (o4) v4Var;
        int i3 = i(bArr, i2, c3Var);
        int i4 = c3Var.a + i3;
        while (i3 < i4) {
            i3 = i(bArr, i3, c3Var);
            o4Var.l(c3Var.a);
        }
        if (i3 == i4) {
            return i3;
        }
        throw zzfm.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(byte[] bArr, int i2, c3 c3Var) {
        byte b2;
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            c3Var.f7067b = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b3 = bArr[i3];
        long j3 = (j2 & 127) | ((b3 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b3 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (b2 & Byte.MAX_VALUE) << i5;
            b3 = bArr[i4];
            i4 = i6;
        }
        c3Var.f7067b = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long l(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double m(byte[] bArr, int i2) {
        return Double.longBitsToDouble(l(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(byte[] bArr, int i2, c3 c3Var) throws zzfm {
        int i3 = i(bArr, i2, c3Var);
        int i4 = c3Var.a;
        if (i4 >= 0) {
            if (i4 == 0) {
                c3Var.f7068c = "";
                return i3;
            }
            c3Var.f7068c = new String(bArr, i3, i4, q4.a);
            return i3 + i4;
        }
        throw zzfm.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float o(byte[] bArr, int i2) {
        return Float.intBitsToFloat(h(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(byte[] bArr, int i2, c3 c3Var) throws zzfm {
        int i3 = i(bArr, i2, c3Var);
        int i4 = c3Var.a;
        if (i4 >= 0) {
            if (i4 == 0) {
                c3Var.f7068c = "";
                return i3;
            }
            c3Var.f7068c = l7.k(bArr, i3, i4);
            return i3 + i4;
        }
        throw zzfm.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(byte[] bArr, int i2, c3 c3Var) throws zzfm {
        int i3 = i(bArr, i2, c3Var);
        int i4 = c3Var.a;
        if (i4 >= 0) {
            if (i4 <= bArr.length - i3) {
                if (i4 == 0) {
                    c3Var.f7068c = h3.a;
                    return i3;
                }
                c3Var.f7068c = h3.p(bArr, i3, i4);
                return i3 + i4;
            }
            throw zzfm.a();
        }
        throw zzfm.b();
    }
}
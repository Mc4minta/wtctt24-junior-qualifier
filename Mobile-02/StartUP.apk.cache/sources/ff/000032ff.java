package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, byte[] bArr, int i3, int i4, w wVar) throws zzco {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 5) {
                                return i3 + 4;
                            }
                            throw zzco.b();
                        }
                        int i6 = (i2 & (-8)) | 4;
                        int i7 = 0;
                        while (i3 < i4) {
                            i3 = e(bArr, i3, wVar);
                            i7 = wVar.a;
                            if (i7 == i6) {
                                break;
                            }
                            i3 = a(i7, bArr, i3, i4, wVar);
                        }
                        if (i3 > i4 || i7 != i6) {
                            throw zzco.d();
                        }
                        return i3;
                    }
                    return e(bArr, i3, wVar) + wVar.a;
                }
                return i3 + 8;
            }
            return g(bArr, i3, wVar);
        }
        throw zzco.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, byte[] bArr, int i3, int i4, j1<?> j1Var, w wVar) {
        f1 f1Var = (f1) j1Var;
        int e2 = e(bArr, i3, wVar);
        while (true) {
            f1Var.i(wVar.a);
            if (e2 >= i4) {
                break;
            }
            int e3 = e(bArr, e2, wVar);
            if (i2 != wVar.a) {
                break;
            }
            e2 = e(bArr, e3, wVar);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4, r3 r3Var, w wVar) throws IOException {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int g2 = g(bArr, i3, wVar);
                r3Var.e(i2, Long.valueOf(wVar.f6599b));
                return g2;
            } else if (i5 == 1) {
                r3Var.e(i2, Long.valueOf(k(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int e2 = e(bArr, i3, wVar);
                int i6 = wVar.a;
                r3Var.e(i2, i6 == 0 ? a0.a : a0.q(bArr, e2, i6));
                return e2 + i6;
            } else if (i5 != 3) {
                if (i5 == 5) {
                    r3Var.e(i2, Integer.valueOf(h(bArr, i3)));
                    return i3 + 4;
                }
                throw zzco.b();
            } else {
                r3 i7 = r3.i();
                int i8 = (i2 & (-8)) | 4;
                int i9 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int e3 = e(bArr, i3, wVar);
                    int i10 = wVar.a;
                    i9 = i10;
                    if (i10 == i8) {
                        i3 = e3;
                        break;
                    }
                    int c2 = c(i9, bArr, e3, i4, i7, wVar);
                    i9 = i10;
                    i3 = c2;
                }
                if (i3 > i4 || i9 != i8) {
                    throw zzco.d();
                }
                r3Var.e(i2, i7);
                return i3;
            }
        }
        throw zzco.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, byte[] bArr, int i3, w wVar) {
        int i4;
        int i5;
        int i6 = i2 & 127;
        int i7 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 < 0) {
            int i8 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i9 = i7 + 1;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i6 = i8 | ((b3 & Byte.MAX_VALUE) << 14);
                i7 = i9 + 1;
                byte b4 = bArr[i9];
                if (b4 >= 0) {
                    i5 = b4 << 21;
                } else {
                    i8 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i9 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i11 = i9 + 1;
                            if (bArr[i9] >= 0) {
                                wVar.a = i10;
                                return i11;
                            }
                            i9 = i11;
                        }
                    }
                }
            }
            wVar.a = i8 | i4;
            return i9;
        }
        i5 = b2 << 7;
        wVar.a = i6 | i5;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i2, w wVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            wVar.a = b2;
            return i3;
        }
        return d(b2, bArr, i3, wVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(byte[] bArr, int i2, j1<?> j1Var, w wVar) throws IOException {
        f1 f1Var = (f1) j1Var;
        int e2 = e(bArr, i2, wVar);
        int i3 = wVar.a + e2;
        while (e2 < i3) {
            e2 = e(bArr, e2, wVar);
            f1Var.i(wVar.a);
        }
        if (e2 == i3) {
            return e2;
        }
        throw zzco.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(byte[] bArr, int i2, w wVar) {
        byte b2;
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            wVar.f6599b = j2;
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
        wVar.f6599b = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(byte[] bArr, int i2, w wVar) {
        int e2 = e(bArr, i2, wVar);
        int i3 = wVar.a;
        if (i3 == 0) {
            wVar.f6600c = "";
            return e2;
        }
        wVar.f6600c = new String(bArr, e2, i3, g1.a);
        return e2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(byte[] bArr, int i2, w wVar) throws IOException {
        int e2 = e(bArr, i2, wVar);
        int i3 = wVar.a;
        if (i3 == 0) {
            wVar.f6600c = "";
            return e2;
        }
        int i4 = e2 + i3;
        if (z3.i(bArr, e2, i4)) {
            wVar.f6600c = new String(bArr, e2, i3, g1.a);
            return i4;
        }
        throw zzco.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double l(byte[] bArr, int i2) {
        return Double.longBitsToDouble(k(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(byte[] bArr, int i2, w wVar) {
        int e2 = e(bArr, i2, wVar);
        int i3 = wVar.a;
        if (i3 == 0) {
            wVar.f6600c = a0.a;
            return e2;
        }
        wVar.f6600c = a0.q(bArr, e2, i3);
        return e2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float n(byte[] bArr, int i2) {
        return Float.intBitsToFloat(h(bArr, i2));
    }
}
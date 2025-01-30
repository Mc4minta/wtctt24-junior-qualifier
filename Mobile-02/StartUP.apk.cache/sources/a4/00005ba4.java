package org.apache.commons.codec.b;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import org.apache.commons.codec.b.b;
import org.spongycastle.math.ec.Tnaf;

/* compiled from: Base64.java */
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f17557g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f17558h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f17559i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f17560j = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, Tnaf.POW_2_WIDTH, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f17561k;

    /* renamed from: l  reason: collision with root package name */
    private final byte[] f17562l;
    private final byte[] m;
    private final int n;
    private final int o;

    public a() {
        this(0);
    }

    public static byte[] n(String str) {
        return new a().d(str);
    }

    public static byte[] o(byte[] bArr) {
        return new a().e(bArr);
    }

    public static byte[] p(byte[] bArr) {
        return q(bArr, false);
    }

    public static byte[] q(byte[] bArr, boolean z) {
        return r(bArr, z, false);
    }

    public static byte[] r(byte[] bArr, boolean z, boolean z2) {
        return s(bArr, z, z2, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public static byte[] s(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, f17557g, z2);
        long j2 = aVar.j(bArr);
        if (j2 <= i2) {
            return aVar.g(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + i2);
    }

    public static String t(byte[] bArr) {
        return c.d(r(bArr, false, true));
    }

    @Override // org.apache.commons.codec.b.b
    void c(byte[] bArr, int i2, int i3, b.a aVar) {
        byte b2;
        if (aVar.f17572f) {
            return;
        }
        if (i3 < 0) {
            aVar.f17572f = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] h2 = h(this.n, aVar);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == this.f17563b) {
                aVar.f17572f = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = f17560j;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (aVar.f17574h + 1) % 4;
                    aVar.f17574h = i6;
                    int i7 = (aVar.a << 6) + b2;
                    aVar.a = i7;
                    if (i6 == 0) {
                        int i8 = aVar.f17570d;
                        int i9 = i8 + 1;
                        aVar.f17570d = i9;
                        h2[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        aVar.f17570d = i10;
                        h2[i9] = (byte) ((i7 >> 8) & 255);
                        aVar.f17570d = i10 + 1;
                        h2[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!aVar.f17572f || aVar.f17574h == 0) {
            return;
        }
        byte[] h3 = h(this.n, aVar);
        int i11 = aVar.f17574h;
        if (i11 != 1) {
            if (i11 == 2) {
                int i12 = aVar.a >> 4;
                aVar.a = i12;
                int i13 = aVar.f17570d;
                aVar.f17570d = i13 + 1;
                h3[i13] = (byte) (i12 & 255);
            } else if (i11 == 3) {
                int i14 = aVar.a >> 2;
                aVar.a = i14;
                int i15 = aVar.f17570d;
                int i16 = i15 + 1;
                aVar.f17570d = i16;
                h3[i15] = (byte) ((i14 >> 8) & 255);
                aVar.f17570d = i16 + 1;
                h3[i16] = (byte) (i14 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f17574h);
            }
        }
    }

    @Override // org.apache.commons.codec.b.b
    void f(byte[] bArr, int i2, int i3, b.a aVar) {
        if (aVar.f17572f) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] h2 = h(this.o, aVar);
                int i5 = (aVar.f17574h + 1) % 3;
                aVar.f17574h = i5;
                int i6 = i2 + 1;
                int i7 = bArr[i2];
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = (aVar.a << 8) + i7;
                aVar.a = i8;
                if (i5 == 0) {
                    int i9 = aVar.f17570d;
                    int i10 = i9 + 1;
                    aVar.f17570d = i10;
                    byte[] bArr2 = this.f17561k;
                    h2[i9] = bArr2[(i8 >> 18) & 63];
                    int i11 = i10 + 1;
                    aVar.f17570d = i11;
                    h2[i10] = bArr2[(i8 >> 12) & 63];
                    int i12 = i11 + 1;
                    aVar.f17570d = i12;
                    h2[i11] = bArr2[(i8 >> 6) & 63];
                    int i13 = i12 + 1;
                    aVar.f17570d = i13;
                    h2[i12] = bArr2[i8 & 63];
                    int i14 = aVar.f17573g + 4;
                    aVar.f17573g = i14;
                    int i15 = this.f17566e;
                    if (i15 > 0 && i15 <= i14) {
                        byte[] bArr3 = this.m;
                        System.arraycopy(bArr3, 0, h2, i13, bArr3.length);
                        aVar.f17570d += this.m.length;
                        aVar.f17573g = 0;
                    }
                }
                i4++;
                i2 = i6;
            }
            return;
        }
        aVar.f17572f = true;
        if (aVar.f17574h == 0 && this.f17566e == 0) {
            return;
        }
        byte[] h3 = h(this.o, aVar);
        int i16 = aVar.f17570d;
        int i17 = aVar.f17574h;
        if (i17 != 0) {
            if (i17 == 1) {
                int i18 = i16 + 1;
                aVar.f17570d = i18;
                byte[] bArr4 = this.f17561k;
                int i19 = aVar.a;
                h3[i16] = bArr4[(i19 >> 2) & 63];
                int i20 = i18 + 1;
                aVar.f17570d = i20;
                h3[i18] = bArr4[(i19 << 4) & 63];
                if (bArr4 == f17558h) {
                    int i21 = i20 + 1;
                    aVar.f17570d = i21;
                    byte b2 = this.f17563b;
                    h3[i20] = b2;
                    aVar.f17570d = i21 + 1;
                    h3[i21] = b2;
                }
            } else if (i17 == 2) {
                int i22 = i16 + 1;
                aVar.f17570d = i22;
                byte[] bArr5 = this.f17561k;
                int i23 = aVar.a;
                h3[i16] = bArr5[(i23 >> 10) & 63];
                int i24 = i22 + 1;
                aVar.f17570d = i24;
                h3[i22] = bArr5[(i23 >> 4) & 63];
                int i25 = i24 + 1;
                aVar.f17570d = i25;
                h3[i24] = bArr5[(i23 << 2) & 63];
                if (bArr5 == f17558h) {
                    aVar.f17570d = i25 + 1;
                    h3[i25] = this.f17563b;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f17574h);
            }
        }
        int i26 = aVar.f17573g;
        int i27 = aVar.f17570d;
        int i28 = i26 + (i27 - i16);
        aVar.f17573g = i28;
        if (this.f17566e <= 0 || i28 <= 0) {
            return;
        }
        byte[] bArr6 = this.m;
        System.arraycopy(bArr6, 0, h3, i27, bArr6.length);
        aVar.f17570d += this.m.length;
    }

    @Override // org.apache.commons.codec.b.b
    protected boolean k(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f17562l;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public a(boolean z) {
        this(76, f17557g, z);
    }

    public a(int i2) {
        this(i2, f17557g);
    }

    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public a(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.f17562l = f17560j;
        if (bArr != null) {
            if (b(bArr)) {
                String d2 = c.d(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d2 + "]");
            } else if (i2 > 0) {
                this.o = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.m = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.o = 4;
                this.m = null;
            }
        } else {
            this.o = 4;
            this.m = null;
        }
        this.n = this.o - 1;
        this.f17561k = z ? f17559i : f17558h;
    }
}
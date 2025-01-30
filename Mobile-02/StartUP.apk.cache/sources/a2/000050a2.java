package io.branch.referral;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64.java */
/* loaded from: classes2.dex */
class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* renamed from: io.branch.referral.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0406a {
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f16895b;

        AbstractC0406a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* loaded from: classes2.dex */
    public static class b extends AbstractC0406a {

        /* renamed from: c  reason: collision with root package name */
        private static final int[] f16896c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f16897d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e  reason: collision with root package name */
        private int f16898e;

        /* renamed from: f  reason: collision with root package name */
        private int f16899f;

        /* renamed from: g  reason: collision with root package name */
        private final int[] f16900g;

        public b(int i2, byte[] bArr) {
            this.a = bArr;
            this.f16900g = (i2 & 8) == 0 ? f16896c : f16897d;
            this.f16898e = 0;
            this.f16899f = 0;
        }

        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            int i4 = this.f16898e;
            if (i4 == 6) {
                return false;
            }
            int i5 = i3 + i2;
            int i6 = this.f16899f;
            byte[] bArr2 = this.a;
            int[] iArr = this.f16900g;
            int i7 = 0;
            int i8 = i6;
            int i9 = i4;
            int i10 = i2;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5 || (i8 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i8;
                        bArr2[i7 + 1] = (byte) (i8 >> 8);
                        bArr2[i7] = (byte) (i8 >> 16);
                        i7 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.f16898e = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 == 2) {
                        if (i13 < 0) {
                            if (i13 == -2) {
                                bArr2[i7] = (byte) (i8 >> 4);
                                i7++;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.f16898e = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5 && i13 != -1) {
                                this.f16898e = 6;
                                return false;
                            }
                        } else if (i13 == -2) {
                            i9++;
                        } else if (i13 != -1) {
                            this.f16898e = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        int i14 = i13 | (i8 << 6);
                        bArr2[i7 + 2] = (byte) i14;
                        bArr2[i7 + 1] = (byte) (i14 >> 8);
                        bArr2[i7] = (byte) (i14 >> 16);
                        i7 += 3;
                        i8 = i14;
                        i9 = 0;
                    } else if (i13 == -2) {
                        bArr2[i7 + 1] = (byte) (i8 >> 2);
                        bArr2[i7] = (byte) (i8 >> 10);
                        i7 += 2;
                        i9 = 5;
                    } else if (i13 != -1) {
                        this.f16898e = 6;
                        return false;
                    }
                    i9++;
                    i8 = i13;
                } else {
                    if (i13 < 0) {
                        if (i13 != -1) {
                            this.f16898e = 6;
                            return false;
                        }
                    }
                    i9++;
                    i8 = i13;
                }
                i10 = i12;
            }
            if (!z) {
                this.f16898e = i9;
                this.f16899f = i8;
                this.f16895b = i7;
                return true;
            } else if (i9 != 1) {
                if (i9 == 2) {
                    bArr2[i7] = (byte) (i8 >> 4);
                    i7++;
                } else if (i9 == 3) {
                    int i15 = i7 + 1;
                    bArr2[i7] = (byte) (i8 >> 10);
                    i7 = i15 + 1;
                    bArr2[i15] = (byte) (i8 >> 2);
                } else if (i9 == 4) {
                    this.f16898e = 6;
                    return false;
                }
                this.f16898e = i9;
                this.f16895b = i7;
                return true;
            } else {
                this.f16898e = 6;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* loaded from: classes2.dex */
    public static class c extends AbstractC0406a {

        /* renamed from: c  reason: collision with root package name */
        private static final byte[] f16901c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: d  reason: collision with root package name */
        private static final byte[] f16902d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f16903e;

        /* renamed from: f  reason: collision with root package name */
        int f16904f;

        /* renamed from: g  reason: collision with root package name */
        private int f16905g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f16906h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f16907i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f16908j;

        /* renamed from: k  reason: collision with root package name */
        private final byte[] f16909k;

        public c(int i2, byte[] bArr) {
            this.a = bArr;
            this.f16906h = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f16907i = z;
            this.f16908j = (i2 & 4) != 0;
            this.f16909k = (i2 & 8) == 0 ? f16901c : f16902d;
            this.f16903e = new byte[2];
            this.f16904f = 0;
            this.f16905g = z ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00dd -> B:22:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 477
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.a.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        b bVar = new b(i4, new byte[(i3 * 3) / 4]);
        if (bVar.a(bArr, i2, i3, true)) {
            int i5 = bVar.f16895b;
            byte[] bArr2 = bVar.a;
            if (i5 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, 0, bArr3, 0, i5);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] c(byte[] bArr, int i2) {
        return d(bArr, 0, bArr.length, i2);
    }

    public static byte[] d(byte[] bArr, int i2, int i3, int i4) {
        c cVar = new c(i4, null);
        int i5 = (i3 / 3) * 4;
        if (cVar.f16906h) {
            if (i3 % 3 > 0) {
                i5 += 4;
            }
        } else {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        }
        if (cVar.f16907i && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (cVar.f16908j ? 2 : 1);
        }
        cVar.a = new byte[i5];
        cVar.a(bArr, i2, i3, true);
        return cVar.a;
    }

    public static String e(byte[] bArr, int i2) {
        try {
            return new String(c(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
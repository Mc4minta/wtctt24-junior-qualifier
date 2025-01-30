package com.google.android.gms.internal.p000firebaseperf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.m7  reason: invalid package */
/* loaded from: classes2.dex */
public final class m7 {
    private static final l7 a;

    static {
        l7 o7Var;
        if ((k7.w() && k7.x()) && !g3.b()) {
            o7Var = new q7();
        } else {
            o7Var = new o7();
        }
        a = o7Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(CharSequence charSequence) {
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
                                throw new n7(i3, length2);
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
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i4 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return a.a(charSequence, bArr, i2, i3);
    }

    public static boolean e(byte[] bArr) {
        return a.c(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i2, int i3) {
        return a.c(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return g(b2, bArr[i2], bArr[i2 + 1]);
                }
                throw new AssertionError();
            }
            return k(b2, bArr[i2]);
        }
        return b(b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }
}
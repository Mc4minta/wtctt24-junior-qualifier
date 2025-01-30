package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.o7  reason: invalid package */
/* loaded from: classes2.dex */
final class o7 extends l7 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.p000firebaseperf.l7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.o7.a(java.lang.CharSequence, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.l7
    final int b(int i2, byte[] bArr, int i3, int i4) {
        int h2;
        int h3;
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
                        h3 = m7.h(bArr, i5, i4);
                        return h3;
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
                    h2 = m7.h(bArr, i5, i4);
                    return h2;
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
}
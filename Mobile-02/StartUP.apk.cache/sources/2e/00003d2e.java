package com.google.zxing.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader.java */
/* loaded from: classes2.dex */
public abstract class k implements com.google.zxing.j {
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c A[Catch: ReaderException -> 0x00cc, TRY_LEAVE, TryCatch #5 {ReaderException -> 0x00cc, blocks: (B:39:0x0076, B:41:0x007c), top: B:76:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.zxing.k d(com.google.zxing.c r22, java.util.Map<com.google.zxing.d, ?> r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.k.d(com.google.zxing.c, java.util.Map):com.google.zxing.k");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(com.google.zxing.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int o = aVar.o();
        if (i2 < o) {
            boolean z = !aVar.i(i2);
            while (i2 < o) {
                if (aVar.i(i2) == z) {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z = !z;
                } else {
                    iArr[i3] = iArr[i3] + 1;
                }
                i2++;
            }
            if (i3 != length) {
                if (i3 != length - 1 || i2 != o) {
                    throw NotFoundException.a();
                }
                return;
            }
            return;
        }
        throw NotFoundException.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(com.google.zxing.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean i3 = aVar.i(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.i(i2) != i3) {
                length--;
                i3 = !i3;
            }
        }
        if (length < 0) {
            f(aVar, i2 + 1, iArr);
            return;
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public com.google.zxing.k a(com.google.zxing.c cVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException {
        try {
            return d(cVar, map);
        } catch (NotFoundException e2) {
            if ((map != null && map.containsKey(com.google.zxing.d.TRY_HARDER)) && cVar.e()) {
                com.google.zxing.c f2 = cVar.f();
                com.google.zxing.k d2 = d(f2, map);
                Map<com.google.zxing.l, Object> d3 = d2.d();
                int i2 = 270;
                if (d3 != null) {
                    com.google.zxing.l lVar = com.google.zxing.l.ORIENTATION;
                    if (d3.containsKey(lVar)) {
                        i2 = (((Integer) d3.get(lVar)).intValue() + 270) % 360;
                    }
                }
                d2.h(com.google.zxing.l.ORIENTATION, Integer.valueOf(i2));
                com.google.zxing.m[] e3 = d2.e();
                if (e3 != null) {
                    int c2 = f2.c();
                    for (int i3 = 0; i3 < e3.length; i3++) {
                        e3[i3] = new com.google.zxing.m((c2 - e3[i3].d()) - 1.0f, e3[i3].c());
                    }
                }
                return d2;
            }
            throw e2;
        }
    }

    @Override // com.google.zxing.j
    public com.google.zxing.k b(com.google.zxing.c cVar) throws NotFoundException, FormatException {
        return a(cVar, null);
    }

    public abstract com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.j
    public void reset() {
    }
}
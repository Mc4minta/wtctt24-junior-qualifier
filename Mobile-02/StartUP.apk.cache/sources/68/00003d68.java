package com.google.zxing.v;

import com.google.zxing.WriterException;
import com.google.zxing.e;
import com.google.zxing.v.e.c;
import com.google.zxing.v.e.f;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: classes2.dex */
public final class b {
    private static com.google.zxing.q.b b(f fVar, int i2, int i3, int i4) {
        com.google.zxing.v.e.b a = fVar.a();
        if (a != null) {
            int e2 = a.e();
            int d2 = a.d();
            int i5 = i4 << 1;
            int i6 = e2 + i5;
            int i7 = i5 + d2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (e2 * min)) / 2;
            int i9 = (max2 - (d2 * min)) / 2;
            com.google.zxing.q.b bVar = new com.google.zxing.q.b(max, max2);
            int i10 = 0;
            while (i10 < d2) {
                int i11 = 0;
                int i12 = i8;
                while (i11 < e2) {
                    if (a.b(i11, i10) == 1) {
                        bVar.q(i12, i9, min, min);
                    }
                    i11++;
                    i12 += min;
                }
                i10++;
                i9 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    public com.google.zxing.q.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<e, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (aVar != com.google.zxing.a.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
            } else if (i2 >= 0 && i3 >= 0) {
                com.google.zxing.v.c.f fVar = com.google.zxing.v.c.f.L;
                int i4 = 4;
                if (map != null) {
                    e eVar = e.ERROR_CORRECTION;
                    if (map.containsKey(eVar)) {
                        fVar = com.google.zxing.v.c.f.valueOf(map.get(eVar).toString());
                    }
                    e eVar2 = e.MARGIN;
                    if (map.containsKey(eVar2)) {
                        i4 = Integer.parseInt(map.get(eVar2).toString());
                    }
                }
                return b(c.n(str, fVar, map), i2, i3, i4);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
package com.google.zxing.s;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.d;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.q.b;
import com.google.zxing.q.e;
import com.google.zxing.s.b.c;
import java.util.Map;

/* compiled from: MaxiCodeReader.java */
/* loaded from: classes2.dex */
public final class a implements j {
    private static final m[] a = new m[0];

    /* renamed from: b  reason: collision with root package name */
    private final c f9984b = new c();

    private static b c(b bVar) throws NotFoundException {
        int[] h2 = bVar.h();
        if (h2 != null) {
            int i2 = h2[0];
            int i3 = h2[1];
            int i4 = h2[2];
            int i5 = h2[3];
            b bVar2 = new b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (bVar.e(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        bVar2.p(i8, i6);
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map != null && map.containsKey(d.PURE_BARCODE)) {
            e b2 = this.f9984b.b(c(cVar.a()), map);
            k kVar = new k(b2.h(), b2.e(), a, com.google.zxing.a.MAXICODE);
            String b3 = b2.b();
            if (b3 != null) {
                kVar.h(l.ERROR_CORRECTION_LEVEL, b3);
            }
            return kVar;
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public k b(com.google.zxing.c cVar) throws NotFoundException, ChecksumException, FormatException {
        return a(cVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
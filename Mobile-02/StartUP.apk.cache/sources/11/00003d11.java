package com.google.zxing.r;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.c;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.q.b;
import com.google.zxing.q.e;
import com.google.zxing.q.g;
import com.google.zxing.r.b.d;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: classes2.dex */
public final class a implements j {
    private static final m[] a = new m[0];

    /* renamed from: b  reason: collision with root package name */
    private final d f9957b = new d();

    private static b c(b bVar) throws NotFoundException {
        int[] l2 = bVar.l();
        int[] f2 = bVar.f();
        if (l2 != null && f2 != null) {
            int d2 = d(l2, bVar);
            int i2 = l2[1];
            int i3 = f2[1];
            int i4 = l2[0];
            int i5 = ((f2[0] - i4) + 1) / d2;
            int i6 = ((i3 - i2) + 1) / d2;
            if (i5 > 0 && i6 > 0) {
                int i7 = d2 / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                b bVar2 = new b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * d2) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.e((i12 * d2) + i9, i11)) {
                            bVar2.p(i12, i10);
                        }
                    }
                }
                return bVar2;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    private static int d(int[] iArr, b bVar) throws NotFoundException {
        int n = bVar.n();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < n && bVar.e(i2, i3)) {
            i2++;
        }
        if (i2 != n) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public k a(c cVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        m[] b2;
        e eVar;
        if (map != null && map.containsKey(com.google.zxing.d.PURE_BARCODE)) {
            eVar = this.f9957b.b(c(cVar.a()));
            b2 = a;
        } else {
            g c2 = new com.google.zxing.r.c.a(cVar.a()).c();
            e b3 = this.f9957b.b(c2.a());
            b2 = c2.b();
            eVar = b3;
        }
        k kVar = new k(eVar.h(), eVar.e(), b2, com.google.zxing.a.DATA_MATRIX);
        List<byte[]> a2 = eVar.a();
        if (a2 != null) {
            kVar.h(l.BYTE_SEGMENTS, a2);
        }
        String b4 = eVar.b();
        if (b4 != null) {
            kVar.h(l.ERROR_CORRECTION_LEVEL, b4);
        }
        return kVar;
    }

    @Override // com.google.zxing.j
    public k b(c cVar) throws NotFoundException, ChecksumException, FormatException {
        return a(cVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}
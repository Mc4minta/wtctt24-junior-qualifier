package com.google.zxing.v;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.c;
import com.google.zxing.d;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.q.g;
import com.google.zxing.v.c.e;
import com.google.zxing.v.c.i;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* loaded from: classes2.dex */
public class a implements j {
    private static final m[] a = new m[0];

    /* renamed from: b  reason: collision with root package name */
    private final e f10114b = new e();

    private static com.google.zxing.q.b c(com.google.zxing.q.b bVar) throws NotFoundException {
        int[] l2 = bVar.l();
        int[] f2 = bVar.f();
        if (l2 != null && f2 != null) {
            float d2 = d(l2, bVar);
            int i2 = l2[1];
            int i3 = f2[1];
            int i4 = l2[0];
            int i5 = f2[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.n()) {
                    throw NotFoundException.a();
                }
                int round = Math.round(((i5 - i4) + 1) / d2);
                int round2 = Math.round((i6 + 1) / d2);
                if (round <= 0 || round2 <= 0) {
                    throw NotFoundException.a();
                }
                if (round2 == round) {
                    int i7 = (int) (d2 / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((round - 1) * d2)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw NotFoundException.a();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((round2 - 1) * d2)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw NotFoundException.a();
                        }
                        i8 -= i11;
                    }
                    com.google.zxing.q.b bVar2 = new com.google.zxing.q.b(round, round2);
                    for (int i12 = 0; i12 < round2; i12++) {
                        int i13 = ((int) (i12 * d2)) + i8;
                        for (int i14 = 0; i14 < round; i14++) {
                            if (bVar.e(((int) (i14 * d2)) + i9, i13)) {
                                bVar2.p(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    private static float d(int[] iArr, com.google.zxing.q.b bVar) throws NotFoundException {
        int i2 = bVar.i();
        int n = bVar.n();
        int i3 = iArr[0];
        boolean z = true;
        int i4 = iArr[1];
        int i5 = 0;
        while (i3 < n && i4 < i2) {
            if (z != bVar.e(i3, i4)) {
                i5++;
                if (i5 == 5) {
                    break;
                }
                z = !z;
            }
            i3++;
            i4++;
        }
        if (i3 != n && i4 != i2) {
            return (i3 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public final k a(c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        m[] b2;
        com.google.zxing.q.e eVar;
        if (map != null && map.containsKey(d.PURE_BARCODE)) {
            eVar = this.f10114b.b(c(cVar.a()), map);
            b2 = a;
        } else {
            g e2 = new com.google.zxing.v.d.c(cVar.a()).e(map);
            com.google.zxing.q.e b3 = this.f10114b.b(e2.a(), map);
            b2 = e2.b();
            eVar = b3;
        }
        if (eVar.d() instanceof i) {
            ((i) eVar.d()).a(b2);
        }
        k kVar = new k(eVar.h(), eVar.e(), b2, com.google.zxing.a.QR_CODE);
        List<byte[]> a2 = eVar.a();
        if (a2 != null) {
            kVar.h(l.BYTE_SEGMENTS, a2);
        }
        String b4 = eVar.b();
        if (b4 != null) {
            kVar.h(l.ERROR_CORRECTION_LEVEL, b4);
        }
        if (eVar.i()) {
            kVar.h(l.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.g()));
            kVar.h(l.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.f()));
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
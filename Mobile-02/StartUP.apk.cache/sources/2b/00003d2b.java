package com.google.zxing.t;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* compiled from: ITFReader.java */
/* loaded from: classes2.dex */
public final class h extends k {
    private static final int[] a = {6, 8, 10, 12, 14};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f10003b = {1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f10004c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f10005d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: e  reason: collision with root package name */
    private int f10006e = -1;

    private static int h(int[] iArr) throws NotFoundException {
        int length = f10005d.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float e2 = k.e(iArr, f10005d[i3], 0.5f);
            if (e2 < f2) {
                i2 = i3;
                f2 = e2;
            } else if (e2 == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw NotFoundException.a();
    }

    private int[] i(com.google.zxing.q.a aVar) throws NotFoundException {
        int i2;
        int[] l2;
        aVar.s();
        try {
            try {
                l2 = l(aVar, m(aVar), f10004c[0]);
            } catch (NotFoundException unused) {
                l2 = l(aVar, i2, f10004c[1]);
            }
            n(aVar, l2[0]);
            int i3 = l2[0];
            l2[0] = aVar.o() - l2[1];
            l2[1] = aVar.o() - i3;
            return l2;
        } finally {
            aVar.s();
        }
    }

    private static void j(com.google.zxing.q.a aVar, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            k.f(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] k(com.google.zxing.q.a aVar) throws NotFoundException {
        int[] l2 = l(aVar, m(aVar), f10003b);
        this.f10006e = (l2[1] - l2[0]) / 4;
        n(aVar, l2[0]);
        return l2;
    }

    private static int[] l(com.google.zxing.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int o = aVar.o();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < o) {
            if (aVar.i(i2) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i3, i2};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw NotFoundException.a();
    }

    private static int m(com.google.zxing.q.a aVar) throws NotFoundException {
        int o = aVar.o();
        int l2 = aVar.l(0);
        if (l2 != o) {
            return l2;
        }
        throw NotFoundException.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n(com.google.zxing.q.a r3, int r4) throws com.google.zxing.NotFoundException {
        /*
            r2 = this;
            int r0 = r2.f10006e
            int r0 = r0 * 10
            if (r0 >= r4) goto L7
            goto L8
        L7:
            r0 = r4
        L8:
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L19
            if (r4 < 0) goto L19
            boolean r1 = r3.i(r4)
            if (r1 != 0) goto L19
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L19:
            if (r0 != 0) goto L1c
            return
        L1c:
            com.google.zxing.NotFoundException r3 = com.google.zxing.NotFoundException.a()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.h.n(com.google.zxing.q.a, int):void");
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws FormatException, NotFoundException {
        boolean z;
        int[] k2 = k(aVar);
        int[] i3 = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, k2[1], i3[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(com.google.zxing.d.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = a;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length2) {
                z = false;
                break;
            }
            int i6 = iArr[i4];
            if (length == i6) {
                z = true;
                break;
            }
            if (i6 > i5) {
                i5 = i6;
            }
            i4++;
        }
        if (!z && length > i5) {
            z = true;
        }
        if (z) {
            float f2 = i2;
            return new com.google.zxing.k(sb2, null, new com.google.zxing.m[]{new com.google.zxing.m(k2[1], f2), new com.google.zxing.m(i3[0], f2)}, com.google.zxing.a.ITF);
        }
        throw FormatException.a();
    }
}
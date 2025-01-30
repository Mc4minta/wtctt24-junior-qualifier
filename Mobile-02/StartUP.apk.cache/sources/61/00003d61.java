package com.google.zxing.u.d;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.m;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: classes2.dex */
public final class j {
    private static final com.google.zxing.u.d.k.a a = new com.google.zxing.u.d.k.a();

    private static c a(h hVar) throws NotFoundException {
        int[] j2;
        if (hVar == null || (j2 = hVar.j()) == null) {
            return null;
        }
        int p = p(j2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : j2) {
            i3 += p - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] d2 = hVar.d();
        for (int i5 = 0; i3 > 0 && d2[i5] == null; i5++) {
            i3--;
        }
        for (int length = j2.length - 1; length >= 0; length--) {
            i2 += p - j2[length];
            if (j2[length] > 0) {
                break;
            }
        }
        for (int length2 = d2.length - 1; i2 > 0 && d2[length2] == null; length2--) {
            i2--;
        }
        return hVar.a().a(i3, i2, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) throws NotFoundException {
        b bVar = bVarArr[0][1];
        int[] a2 = bVar.a();
        int j2 = (fVar.j() * fVar.l()) - r(fVar.k());
        if (a2.length != 0) {
            if (a2[0] != j2) {
                bVar.b(j2);
            }
        } else if (j2 > 0 && j2 <= 928) {
            bVar.b(j2);
        } else {
            throw NotFoundException.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(com.google.zxing.q.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.e(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.d.j.c(com.google.zxing.q.b, int, int, boolean, int, int):int");
    }

    private static boolean d(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return a.a(iArr, i2, iArr2);
        }
        throw ChecksumException.a();
    }

    private static b[][] f(f fVar) {
        g[] o;
        d[] d2;
        int c2;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, fVar.l(), fVar.j() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (c2 = dVar.c()) >= 0 && c2 < bVarArr.length) {
                        bVarArr[c2][i4].b(dVar.e());
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static com.google.zxing.q.e g(f fVar) throws FormatException, ChecksumException, NotFoundException {
        b[][] f2 = f(fVar);
        b(fVar, f2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < fVar.l(); i2++) {
            int i3 = 0;
            while (i3 < fVar.j()) {
                int i4 = i3 + 1;
                int[] a2 = f2[i2][i4].a();
                int j2 = (fVar.j() * i2) + i3;
                if (a2.length == 0) {
                    arrayList.add(Integer.valueOf(j2));
                } else if (a2.length == 1) {
                    iArr[j2] = a2[0];
                } else {
                    arrayList3.add(Integer.valueOf(j2));
                    arrayList2.add(a2);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return h(fVar.k(), iArr, com.google.zxing.u.a.b(arrayList), com.google.zxing.u.a.b(arrayList3), iArr2);
    }

    private static com.google.zxing.q.e h(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return j(iArr, i2, iArr2);
                } catch (ChecksumException unused) {
                    if (length == 0) {
                        throw ChecksumException.a();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        } else {
                            iArr5[i6] = 0;
                            if (i6 == length - 1) {
                                throw ChecksumException.a();
                            }
                            i6++;
                        }
                    }
                    i3 = i4;
                }
            } else {
                throw ChecksumException.a();
            }
        }
    }

    public static com.google.zxing.q.e i(com.google.zxing.q.b bVar, m mVar, m mVar2, m mVar3, m mVar4, int i2, int i3) throws NotFoundException, FormatException, ChecksumException {
        g hVar;
        int i4;
        int i5;
        int i6;
        int i7;
        h hVar2 = null;
        h hVar3 = null;
        f fVar = null;
        c cVar = new c(bVar, mVar, mVar2, mVar3, mVar4);
        for (int i8 = 0; i8 < 2; i8++) {
            if (mVar != null) {
                hVar2 = s(bVar, cVar, mVar, true, i2, i3);
            }
            if (mVar3 != null) {
                hVar3 = s(bVar, cVar, mVar3, false, i2, i3);
            }
            fVar = v(hVar2, hVar3);
            if (fVar != null) {
                if (i8 == 0 && fVar.m() != null && (fVar.m().h() < cVar.h() || fVar.m().f() > cVar.f())) {
                    cVar = fVar.m();
                } else {
                    fVar.p(cVar);
                    break;
                }
            } else {
                throw NotFoundException.a();
            }
        }
        int j2 = fVar.j() + 1;
        fVar.q(0, hVar2);
        fVar.q(j2, hVar3);
        boolean z = hVar2 != null;
        int i9 = i2;
        int i10 = i3;
        for (int i11 = 1; i11 <= j2; i11++) {
            int i12 = z ? i11 : j2 - i11;
            if (fVar.n(i12) == null) {
                if (i12 != 0 && i12 != j2) {
                    hVar = new g(cVar);
                } else {
                    hVar = new h(cVar, i12 == 0);
                }
                fVar.q(i12, hVar);
                int i13 = -1;
                int h2 = cVar.h();
                int i14 = -1;
                while (h2 <= cVar.f()) {
                    int t = t(fVar, i12, h2, z);
                    if (t >= 0 && t <= cVar.e()) {
                        i7 = t;
                    } else if (i14 != i13) {
                        i7 = i14;
                    } else {
                        i4 = i14;
                        i5 = h2;
                        i6 = i13;
                        i14 = i4;
                        h2 = i5 + 1;
                        i13 = i6;
                    }
                    i4 = i14;
                    int i15 = h2;
                    i6 = i13;
                    d k2 = k(bVar, cVar.g(), cVar.e(), z, i7, i15, i9, i10);
                    i5 = i15;
                    if (k2 != null) {
                        hVar.f(i5, k2);
                        i9 = Math.min(i9, k2.f());
                        i10 = Math.max(i10, k2.f());
                        i14 = i7;
                        h2 = i5 + 1;
                        i13 = i6;
                    }
                    i14 = i4;
                    h2 = i5 + 1;
                    i13 = i6;
                }
            }
        }
        return g(fVar);
    }

    private static com.google.zxing.q.e j(int[] iArr, int i2, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int e2 = e(iArr, iArr2, i3);
            w(iArr, i3);
            com.google.zxing.q.e b2 = e.b(iArr, String.valueOf(i2));
            b2.k(Integer.valueOf(e2));
            b2.j(Integer.valueOf(iArr2.length));
            return b2;
        }
        throw FormatException.a();
    }

    private static d k(com.google.zxing.q.b bVar, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int d2;
        int a2;
        int c2 = c(bVar, i2, i3, z, i4, i5);
        int[] q = q(bVar, i2, i3, z, c2, i5);
        if (q == null) {
            return null;
        }
        int d3 = com.google.zxing.q.m.a.d(q);
        if (z) {
            i8 = c2 + d3;
        } else {
            for (int i9 = 0; i9 < q.length / 2; i9++) {
                int i10 = q[i9];
                q[i9] = q[(q.length - 1) - i9];
                q[(q.length - 1) - i9] = i10;
            }
            c2 -= d3;
            i8 = c2;
        }
        if (d(d3, i6, i7) && (a2 = com.google.zxing.u.a.a((d2 = i.d(q)))) != -1) {
            return new d(c2, i8, n(d2), a2);
        }
        return null;
    }

    private static a l(h hVar, h hVar2) {
        a i2;
        a i3;
        if (hVar == null || (i2 = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        } else if (hVar2 == null || (i3 = hVar2.i()) == null || i2.a() == i3.a() || i2.b() == i3.b() || i2.c() == i3.c()) {
            return i2;
        } else {
            return null;
        }
    }

    private static int[] m(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int n(int i2) {
        return o(m(i2));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0027 A[EDGE_INSN: B:27:0x0027->B:16:0x0027 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] q(com.google.zxing.q.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.e(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.d.j.q(com.google.zxing.q.b, int, int, boolean, int, int):int[]");
    }

    private static int r(int i2) {
        return 2 << i2;
    }

    private static h s(com.google.zxing.q.b bVar, c cVar, m mVar, boolean z, int i2, int i3) {
        int b2;
        h hVar = new h(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int c2 = (int) mVar.c();
            for (int d2 = (int) mVar.d(); d2 <= cVar.f() && d2 >= cVar.h(); d2 += i5) {
                d k2 = k(bVar, 0, bVar.n(), z, c2, d2, i2, i3);
                if (k2 != null) {
                    hVar.f(d2, k2);
                    if (z) {
                        b2 = k2.d();
                    } else {
                        b2 = k2.b();
                    }
                    c2 = b2;
                }
            }
            i4++;
        }
        return hVar;
    }

    private static int t(f fVar, int i2, int i3, boolean z) {
        d[] d2;
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        d b2 = u(fVar, i5) ? fVar.n(i5).b(i3) : null;
        if (b2 != null) {
            return z ? b2.b() : b2.d();
        }
        d c2 = fVar.n(i2).c(i3);
        if (c2 != null) {
            return z ? c2.d() : c2.b();
        }
        if (u(fVar, i5)) {
            c2 = fVar.n(i5).c(i3);
        }
        if (c2 != null) {
            return z ? c2.b() : c2.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (u(fVar, i2)) {
                for (d dVar : fVar.n(i2).d()) {
                    if (dVar != null) {
                        return (z ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                    }
                }
                i6++;
            } else {
                c m = fVar.m();
                return z ? m.g() : m.e();
            }
        }
    }

    private static boolean u(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.j() + 1;
    }

    private static f v(h hVar, h hVar2) throws NotFoundException {
        a l2;
        if ((hVar == null && hVar2 == null) || (l2 = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(l2, c.l(a(hVar), a(hVar2)));
    }

    private static void w(int[] iArr, int i2) throws FormatException {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw FormatException.a();
            }
            if (i3 == 0) {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw FormatException.a();
            }
            return;
        }
        throw FormatException.a();
    }
}
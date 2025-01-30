package com.google.zxing.t.r;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.m;
import com.google.zxing.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: RSS14Reader.java */
/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f10033g = {1, 10, 34, 70, 126};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f10034h = {4, 20, 48, 81};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f10035i = {0, CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 961, 2015, 2715};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f10036j = {0, 336, 1036, 1516};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f10037k = {8, 6, 4, 3, 1};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f10038l = {2, 4, 6, 8};
    private static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> n = new ArrayList();
    private final List<d> o = new ArrayList();

    private static void r(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r1 < 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r1 < 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        r5 = false;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        r2 = false;
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(boolean r10, int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.r.e.s(boolean, int):void");
    }

    private static boolean t(d dVar, d dVar2) {
        int a = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c2 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c2 > 72) {
            c2--;
        }
        if (c2 > 8) {
            c2--;
        }
        return a == c2;
    }

    private static k u(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        m[] a = dVar.d().a();
        m[] a2 = dVar2.d().a();
        return new k(sb.toString(), null, new m[]{a[0], a[1], a2[0], a2[1]}, com.google.zxing.a.RSS_14);
    }

    private b v(com.google.zxing.q.a aVar, c cVar, boolean z) throws NotFoundException {
        int[] i2 = i();
        for (int i3 = 0; i3 < i2.length; i3++) {
            i2[i3] = 0;
        }
        if (z) {
            com.google.zxing.t.k.g(aVar, cVar.b()[0], i2);
        } else {
            com.google.zxing.t.k.f(aVar, cVar.b()[1] + 1, i2);
            int i4 = 0;
            for (int length = i2.length - 1; i4 < length; length--) {
                int i5 = i2[i4];
                i2[i4] = i2[length];
                i2[length] = i5;
                i4++;
            }
        }
        int i6 = z ? 16 : 15;
        float d2 = com.google.zxing.q.m.a.d(i2) / i6;
        int[] m2 = m();
        int[] k2 = k();
        float[] n = n();
        float[] l2 = l();
        for (int i7 = 0; i7 < i2.length; i7++) {
            float f2 = i2[i7] / d2;
            int i8 = (int) (0.5f + f2);
            if (i8 <= 0) {
                i8 = 1;
            } else if (i8 > 8) {
                i8 = 8;
            }
            int i9 = i7 / 2;
            if ((i7 & 1) == 0) {
                m2[i9] = i8;
                n[i9] = f2 - i8;
            } else {
                k2[i9] = i8;
                l2[i9] = f2 - i8;
            }
        }
        s(z, i6);
        int i10 = 0;
        int i11 = 0;
        for (int length2 = m2.length - 1; length2 >= 0; length2--) {
            i10 = (i10 * 9) + m2[length2];
            i11 += m2[length2];
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = k2.length - 1; length3 >= 0; length3--) {
            i12 = (i12 * 9) + k2[length3];
            i13 += k2[length3];
        }
        int i14 = i10 + (i12 * 3);
        if (!z) {
            if ((i13 & 1) == 0 && i13 <= 10 && i13 >= 4) {
                int i15 = (10 - i13) / 2;
                int i16 = f10038l[i15];
                return new b((f.b(k2, 9 - i16, false) * f10034h[i15]) + f.b(m2, i16, true) + f10036j[i15], i14);
            }
            throw NotFoundException.a();
        } else if ((i11 & 1) == 0 && i11 <= 12 && i11 >= 4) {
            int i17 = (12 - i11) / 2;
            int i18 = f10037k[i17];
            return new b((f.b(m2, i18, false) * f10033g[i17]) + f.b(k2, 9 - i18, true) + f10035i[i17], i14);
        } else {
            throw NotFoundException.a();
        }
    }

    private d w(com.google.zxing.q.a aVar, boolean z, int i2, Map<com.google.zxing.d, ?> map) {
        try {
            int[] x = x(aVar, z);
            c y = y(aVar, i2, z, x);
            n nVar = map == null ? null : (n) map.get(com.google.zxing.d.NEED_RESULT_POINT_CALLBACK);
            if (nVar != null) {
                float f2 = (x[0] + x[1]) / 2.0f;
                if (z) {
                    f2 = (aVar.o() - 1) - f2;
                }
                nVar.a(new m(f2, i2));
            }
            b v = v(aVar, y, true);
            b v2 = v(aVar, y, false);
            return new d((v.b() * 1597) + v2.b(), v.a() + (v2.a() * 4), y);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] x(com.google.zxing.q.a aVar, boolean z) throws NotFoundException {
        int[] j2 = j();
        j2[0] = 0;
        j2[1] = 0;
        j2[2] = 0;
        j2[3] = 0;
        int o = aVar.o();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < o) {
            z2 = !aVar.i(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        int i4 = i2;
        while (i2 < o) {
            if (aVar.i(i2) != z2) {
                j2[i3] = j2[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else if (a.p(j2)) {
                    return new int[]{i4, i2};
                } else {
                    i4 += j2[0] + j2[1];
                    j2[0] = j2[2];
                    j2[1] = j2[3];
                    j2[2] = 0;
                    j2[3] = 0;
                    i3--;
                }
                j2[i3] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.a();
    }

    private c y(com.google.zxing.q.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        int i3;
        int i4;
        boolean i5 = aVar.i(iArr[0]);
        int i6 = iArr[0] - 1;
        while (i6 >= 0 && i5 != aVar.i(i6)) {
            i6--;
        }
        int i7 = i6 + 1;
        int[] j2 = j();
        System.arraycopy(j2, 0, j2, 1, j2.length - 1);
        j2[0] = iArr[0] - i7;
        int q = a.q(j2, m);
        int i8 = iArr[1];
        if (z) {
            i3 = (aVar.o() - 1) - i8;
            i4 = (aVar.o() - 1) - i7;
        } else {
            i3 = i8;
            i4 = i7;
        }
        return new c(q, new int[]{i7, iArr[1]}, i4, i3, i2);
    }

    @Override // com.google.zxing.t.k
    public k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException {
        r(this.n, w(aVar, false, i2, map));
        aVar.s();
        r(this.o, w(aVar, true, i2, map));
        aVar.s();
        for (d dVar : this.n) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.o) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public void reset() {
        this.n.clear();
        this.o.clear();
    }
}
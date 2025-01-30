package com.google.zxing.t.r.g;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.m;
import com.google.zxing.t.r.f;
import com.google.zxing.t.r.g.e.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.spongycastle.asn1.eac.EACTags;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

/* compiled from: RSSExpandedReader.java */
/* loaded from: classes2.dex */
public final class d extends com.google.zxing.t.r.a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f10044g = {7, 5, 4, 3, 1};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f10045h = {4, 20, 52, 104, HttpStatus.SC_NO_CONTENT};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f10046i = {0, 348, 1388, 2948, 3988};

    /* renamed from: j  reason: collision with root package name */
    private static final int[][] f10047j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: k  reason: collision with root package name */
    private static final int[][] f10048k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 118, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, 7, 21, 63}, new int[]{CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 13, 39, 117, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 209, HttpStatus.SC_RESET_CONTENT}, new int[]{CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 49, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 19, 57, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 91}, new int[]{62, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 85, 44, CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA}, new int[]{CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 188, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA, 4, 12, 36, 108}, new int[]{113, 128, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 97, 80, 29, 87, 50}, new int[]{CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 28, 84, 41, 123, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 52, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256}, new int[]{46, CipherSuite.TLS_PSK_WITH_RC4_128_SHA, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, HttpStatus.SC_PARTIAL_CONTENT, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256}, new int[]{76, 17, 51, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 37, 111, 122, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA}, new int[]{43, 129, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 106, 107, 110, 119, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA}, new int[]{16, 48, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 10, 30, 90, 59, CipherSuite.TLS_PSK_WITH_NULL_SHA384}, new int[]{109, 116, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 200, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 112, EACTags.SECURE_MESSAGING_TEMPLATE, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256}, new int[]{70, 210, 208, HttpStatus.SC_ACCEPTED, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA256, 130, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 115}, new int[]{CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 31, 93, 68, HttpStatus.SC_NO_CONTENT, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256}, new int[]{CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 22, 66, 198, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 94, 71, 2}, new int[]{6, 18, 54, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 64, 192, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 40}, new int[]{120, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 25, 75, 14, 42, 126, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384}, new int[]{79, 26, 78, 23, 69, HttpStatus.SC_MULTI_STATUS, 199, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384}, new int[]{103, 98, 83, 38, 114, 131, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 124}, new int[]{CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 61, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, 127, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 88, 53, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384}, new int[]{55, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 73, 8, 24, 72, 5, 15}, new int[]{45, CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 58, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 100, 89}};

    /* renamed from: l  reason: collision with root package name */
    private static final int[][] f10049l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> m = new ArrayList(11);
    private final List<c> n = new ArrayList();
    private final int[] o = new int[2];
    private boolean p;

    private static boolean A(com.google.zxing.t.r.c cVar, boolean z, boolean z2) {
        return (cVar.c() == 0 && z && z2) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean B(java.lang.Iterable<com.google.zxing.t.r.g.b> r7, java.lang.Iterable<com.google.zxing.t.r.g.c> r8) {
        /*
            java.util.Iterator r8 = r8.iterator()
        L4:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto L46
            java.lang.Object r0 = r8.next()
            com.google.zxing.t.r.g.c r0 = (com.google.zxing.t.r.g.c) r0
            java.util.Iterator r2 = r7.iterator()
        L15:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L42
            java.lang.Object r3 = r2.next()
            com.google.zxing.t.r.g.b r3 = (com.google.zxing.t.r.g.b) r3
            java.util.List r5 = r0.a()
            java.util.Iterator r5 = r5.iterator()
        L2a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L3e
            java.lang.Object r6 = r5.next()
            com.google.zxing.t.r.g.b r6 = (com.google.zxing.t.r.g.b) r6
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L2a
            r3 = r4
            goto L3f
        L3e:
            r3 = r1
        L3f:
            if (r3 != 0) goto L15
            goto L43
        L42:
            r1 = r4
        L43:
            if (r1 == 0) goto L4
            return r4
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.r.g.d.B(java.lang.Iterable, java.lang.Iterable):boolean");
    }

    private static boolean C(List<b> list) {
        int[][] iArr;
        boolean z;
        for (int[] iArr2 : f10049l) {
            if (list.size() <= iArr2.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i2).b().c() != iArr2[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private com.google.zxing.t.r.c D(com.google.zxing.q.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.o[0] - 1;
            while (i6 >= 0 && !aVar.i(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.o;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.o;
            int i8 = iArr2[0];
            int n = aVar.n(iArr2[1] + 1);
            i3 = n;
            i4 = i8;
            i5 = n - this.o[1];
        }
        int[] j2 = j();
        System.arraycopy(j2, 0, j2, 1, j2.length - 1);
        j2[0] = i5;
        try {
            return new com.google.zxing.t.r.c(com.google.zxing.t.r.a.q(j2, f10047j), new int[]{i4, i3}, i4, i3, i2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void E(java.util.List<com.google.zxing.t.r.g.b> r6, java.util.List<com.google.zxing.t.r.g.c> r7) {
        /*
            java.util.Iterator r7 = r7.iterator()
        L4:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L56
            java.lang.Object r0 = r7.next()
            com.google.zxing.t.r.g.c r0 = (com.google.zxing.t.r.g.c) r0
            java.util.List r1 = r0.a()
            int r1 = r1.size()
            int r2 = r6.size()
            if (r1 == r2) goto L4
            java.util.List r0 = r0.a()
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r0.next()
            com.google.zxing.t.r.g.b r1 = (com.google.zxing.t.r.g.b) r1
            java.util.Iterator r4 = r6.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4b
            java.lang.Object r5 = r4.next()
            com.google.zxing.t.r.g.b r5 = (com.google.zxing.t.r.g.b) r5
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L38
            goto L4c
        L4b:
            r3 = r2
        L4c:
            if (r3 != 0) goto L26
            goto L50
        L4f:
            r2 = r3
        L50:
            if (r2 == 0) goto L4
            r7.remove()
            goto L4
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.r.g.d.E(java.util.List, java.util.List):void");
    }

    private static void G(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void H(int i2, boolean z) {
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= this.n.size()) {
                break;
            }
            c cVar = this.n.get(i3);
            if (cVar.b() > i2) {
                z2 = cVar.c(this.m);
                break;
            } else {
                z3 = cVar.c(this.m);
                i3++;
            }
        }
        if (z2 || z3 || B(this.m, this.n)) {
            return;
        }
        this.n.add(i3, new c(this.m, i2, z));
        E(this.m, this.n);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.t.r.g.d.r(int):void");
    }

    private boolean s() {
        b bVar = this.m.get(0);
        com.google.zxing.t.r.b c2 = bVar.c();
        com.google.zxing.t.r.b d2 = bVar.d();
        if (d2 == null) {
            return false;
        }
        int a = d2.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.m.size(); i3++) {
            b bVar2 = this.m.get(i3);
            a += bVar2.c().a();
            i2++;
            com.google.zxing.t.r.b d3 = bVar2.d();
            if (d3 != null) {
                a += d3.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * Primes.SMALL_FACTOR_LIMIT) + (a % Primes.SMALL_FACTOR_LIMIT) == c2.b();
    }

    private List<b> t(List<c> list, int i2) throws NotFoundException {
        while (i2 < this.n.size()) {
            c cVar = this.n.get(i2);
            this.m.clear();
            for (c cVar2 : list) {
                this.m.addAll(cVar2.a());
            }
            this.m.addAll(cVar.a());
            if (C(this.m)) {
                if (s()) {
                    return this.m;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i2++;
        }
        throw NotFoundException.a();
    }

    private List<b> u(boolean z) {
        List<b> list = null;
        if (this.n.size() > 25) {
            this.n.clear();
            return null;
        }
        this.m.clear();
        if (z) {
            Collections.reverse(this.n);
        }
        try {
            list = t(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.n);
        }
        return list;
    }

    static k v(List<b> list) throws NotFoundException, FormatException {
        String d2 = j.a(a.a(list)).d();
        m[] a = list.get(0).b().a();
        m[] a2 = list.get(list.size() - 1).b().a();
        return new k(d2, null, new m[]{a[0], a[1], a2[0], a2[1]}, com.google.zxing.a.RSS_EXPANDED);
    }

    private void y(com.google.zxing.q.a aVar, List<b> list, int i2) throws NotFoundException {
        int[] j2 = j();
        j2[0] = 0;
        j2[1] = 0;
        j2[2] = 0;
        j2[3] = 0;
        int o = aVar.o();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.p) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < o) {
            z2 = !aVar.i(i2);
            if (!z2) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        boolean z3 = z2;
        int i4 = i2;
        while (i2 < o) {
            if (aVar.i(i2) != z3) {
                j2[i3] = j2[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        G(j2);
                    }
                    if (com.google.zxing.t.r.a.p(j2)) {
                        int[] iArr = this.o;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        G(j2);
                    }
                    i4 += j2[0] + j2[1];
                    j2[0] = j2[2];
                    j2[1] = j2[3];
                    j2[2] = 0;
                    j2[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                j2[i3] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.a();
    }

    private static int z(com.google.zxing.q.a aVar, int i2) {
        if (aVar.i(i2)) {
            return aVar.l(aVar.n(i2));
        }
        return aVar.n(aVar.l(i2));
    }

    b F(com.google.zxing.q.a aVar, List<b> list, int i2) throws NotFoundException {
        com.google.zxing.t.r.c D;
        com.google.zxing.t.r.b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.p) {
            z = !z;
        }
        int i3 = -1;
        boolean z2 = true;
        do {
            y(aVar, list, i3);
            D = D(aVar, i2, z);
            if (D == null) {
                i3 = z(aVar, this.o[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        com.google.zxing.t.r.b w = w(aVar, D, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).f()) {
            throw NotFoundException.a();
        }
        try {
            bVar = w(aVar, D, z, false);
        } catch (NotFoundException unused) {
            bVar = null;
        }
        return new b(w, bVar, D, true);
    }

    @Override // com.google.zxing.t.k
    public k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException, FormatException {
        this.m.clear();
        this.p = false;
        try {
            return v(x(i2, aVar));
        } catch (NotFoundException unused) {
            this.m.clear();
            this.p = true;
            return v(x(i2, aVar));
        }
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public void reset() {
        this.m.clear();
        this.n.clear();
    }

    com.google.zxing.t.r.b w(com.google.zxing.q.a aVar, com.google.zxing.t.r.c cVar, boolean z, boolean z2) throws NotFoundException {
        int[] i2 = i();
        for (int i3 = 0; i3 < i2.length; i3++) {
            i2[i3] = 0;
        }
        if (z2) {
            com.google.zxing.t.k.g(aVar, cVar.b()[0], i2);
        } else {
            com.google.zxing.t.k.f(aVar, cVar.b()[1], i2);
            int i4 = 0;
            for (int length = i2.length - 1; i4 < length; length--) {
                int i5 = i2[i4];
                i2[i4] = i2[length];
                i2[length] = i5;
                i4++;
            }
        }
        float d2 = com.google.zxing.q.m.a.d(i2) / 17.0f;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d2 - f2) / f2 <= 0.3f) {
            int[] m = m();
            int[] k2 = k();
            float[] n = n();
            float[] l2 = l();
            for (int i6 = 0; i6 < i2.length; i6++) {
                float f3 = (i2[i6] * 1.0f) / d2;
                int i7 = (int) (0.5f + f3);
                if (i7 <= 0) {
                    if (f3 < 0.3f) {
                        throw NotFoundException.a();
                    }
                    i7 = 1;
                } else if (i7 > 8) {
                    if (f3 > 8.7f) {
                        throw NotFoundException.a();
                    }
                    i7 = 8;
                }
                int i8 = i6 / 2;
                if ((i6 & 1) == 0) {
                    m[i8] = i7;
                    n[i8] = f3 - i7;
                } else {
                    k2[i8] = i7;
                    l2[i8] = f3 - i7;
                }
            }
            r(17);
            int c2 = (((cVar.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
            int i9 = 0;
            int i10 = 0;
            for (int length2 = m.length - 1; length2 >= 0; length2--) {
                if (A(cVar, z, z2)) {
                    i9 += m[length2] * f10048k[c2][length2 * 2];
                }
                i10 += m[length2];
            }
            int i11 = 0;
            for (int length3 = k2.length - 1; length3 >= 0; length3--) {
                if (A(cVar, z, z2)) {
                    i11 += k2[length3] * f10048k[c2][(length3 * 2) + 1];
                }
            }
            int i12 = i9 + i11;
            if ((i10 & 1) == 0 && i10 <= 13 && i10 >= 4) {
                int i13 = (13 - i10) / 2;
                int i14 = f10044g[i13];
                return new com.google.zxing.t.r.b((f.b(m, i14, true) * f10045h[i13]) + f.b(k2, 9 - i14, false) + f10046i[i13], i12);
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    List<b> x(int i2, com.google.zxing.q.a aVar) throws NotFoundException {
        while (true) {
            try {
                this.m.add(F(aVar, this.m, i2));
            } catch (NotFoundException e2) {
                if (!this.m.isEmpty()) {
                    if (s()) {
                        return this.m;
                    }
                    boolean z = !this.n.isEmpty();
                    H(i2, false);
                    if (z) {
                        List<b> u = u(false);
                        if (u != null) {
                            return u;
                        }
                        List<b> u2 = u(true);
                        if (u2 != null) {
                            return u2;
                        }
                    }
                    throw NotFoundException.a();
                }
                throw e2;
            }
        }
    }
}
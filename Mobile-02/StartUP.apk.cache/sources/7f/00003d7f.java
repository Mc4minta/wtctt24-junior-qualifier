package com.google.zxing.v.d;

import com.google.zxing.NotFoundException;
import com.google.zxing.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder.java */
/* loaded from: classes2.dex */
final class b {
    private final com.google.zxing.q.b a;

    /* renamed from: c  reason: collision with root package name */
    private final int f10154c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10155d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10156e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10157f;

    /* renamed from: g  reason: collision with root package name */
    private final float f10158g;

    /* renamed from: i  reason: collision with root package name */
    private final n f10160i;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f10153b = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    private final int[] f10159h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.google.zxing.q.b bVar, int i2, int i3, int i4, int i5, float f2, n nVar) {
        this.a = bVar;
        this.f10154c = i2;
        this.f10155d = i3;
        this.f10156e = i4;
        this.f10157f = i5;
        this.f10158g = f2;
        this.f10160i = nVar;
    }

    private static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r2[1] <= r12) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        if (r10 >= r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        if (r0.e(r11, r10) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
        if (r2[2] > r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
        if (r2[2] <= r12) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0090, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0095, code lost:
        if (d(r2) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009b, code lost:
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.google.zxing.q.b r0 = r9.a
            int r1 = r0.i()
            int[] r2 = r9.f10159h
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L26
            boolean r7 = r0.e(r11, r6)
            if (r7 == 0) goto L26
            r7 = r2[r4]
            if (r7 > r12) goto L26
            r7 = r2[r4]
            int r7 = r7 + r4
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L26:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto L9c
            r8 = r2[r4]
            if (r8 <= r12) goto L30
            goto L9c
        L30:
            if (r6 < 0) goto L44
            boolean r8 = r0.e(r11, r6)
            if (r8 != 0) goto L44
            r8 = r2[r3]
            if (r8 > r12) goto L44
            r8 = r2[r3]
            int r8 = r8 + r4
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L30
        L44:
            r6 = r2[r3]
            if (r6 <= r12) goto L49
            return r7
        L49:
            int r10 = r10 + r4
        L4a:
            if (r10 >= r1) goto L5e
            boolean r6 = r0.e(r11, r10)
            if (r6 == 0) goto L5e
            r6 = r2[r4]
            if (r6 > r12) goto L5e
            r6 = r2[r4]
            int r6 = r6 + r4
            r2[r4] = r6
            int r10 = r10 + 1
            goto L4a
        L5e:
            if (r10 == r1) goto L9c
            r6 = r2[r4]
            if (r6 <= r12) goto L65
            goto L9c
        L65:
            if (r10 >= r1) goto L79
            boolean r6 = r0.e(r11, r10)
            if (r6 != 0) goto L79
            r6 = r2[r5]
            if (r6 > r12) goto L79
            r6 = r2[r5]
            int r6 = r6 + r4
            r2[r5] = r6
            int r10 = r10 + 1
            goto L65
        L79:
            r11 = r2[r5]
            if (r11 <= r12) goto L7e
            return r7
        L7e:
            r11 = r2[r3]
            r12 = r2[r4]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * r5
            if (r11 < r13) goto L91
            return r7
        L91:
            boolean r11 = r9.d(r2)
            if (r11 == 0) goto L9c
            float r10 = a(r2, r10)
            return r10
        L9c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.v.d.b.b(int, int, int, int):float");
    }

    private boolean d(int[] iArr) {
        float f2 = this.f10158g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float a = a(iArr, i3);
        float b2 = b(i2, (int) a, iArr[1] * 2, i4);
        if (Float.isNaN(b2)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f10153b) {
            if (aVar.f(f2, b2, a)) {
                return aVar.g(b2, a, f2);
            }
        }
        a aVar2 = new a(a, b2, f2);
        this.f10153b.add(aVar2);
        n nVar = this.f10160i;
        if (nVar != null) {
            nVar.a(aVar2);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() throws NotFoundException {
        a e2;
        a e3;
        int i2 = this.f10154c;
        int i3 = this.f10157f;
        int i4 = this.f10156e + i2;
        int i5 = this.f10155d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.a.e(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.a.e(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 == 2) {
                    if (d(iArr) && (e3 = e(iArr, i7, i8)) != null) {
                        return e3;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                } else {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                }
                i8++;
            }
            if (d(iArr) && (e2 = e(iArr, i7, i4)) != null) {
                return e2;
            }
        }
        if (!this.f10153b.isEmpty()) {
            return this.f10153b.get(0);
        }
        throw NotFoundException.a();
    }
}
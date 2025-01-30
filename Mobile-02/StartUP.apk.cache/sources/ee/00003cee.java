package com.google.zxing.o.d;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.m;
import com.google.zxing.q.b;
import com.google.zxing.q.i;
import org.apache.http.message.TokenParser;

/* compiled from: Detector.java */
/* loaded from: classes2.dex */
public final class a {
    private static final int[] a = {3808, 476, 2107, 1799};

    /* renamed from: b  reason: collision with root package name */
    private final b f9871b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9872c;

    /* renamed from: d  reason: collision with root package name */
    private int f9873d;

    /* renamed from: e  reason: collision with root package name */
    private int f9874e;

    /* renamed from: f  reason: collision with root package name */
    private int f9875f;

    /* renamed from: g  reason: collision with root package name */
    private int f9876g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Detector.java */
    /* renamed from: com.google.zxing.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0207a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9877b;

        C0207a(int i2, int i3) {
            this.a = i2;
            this.f9877b = i3;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.f9877b;
        }

        m c() {
            return new m(a(), b());
        }

        public String toString() {
            return "<" + this.a + TokenParser.SP + this.f9877b + '>';
        }
    }

    public a(b bVar) {
        this.f9871b = bVar;
    }

    private static float b(m mVar, m mVar2) {
        return com.google.zxing.q.m.a.a(mVar.c(), mVar.d(), mVar2.c(), mVar2.d());
    }

    private static float c(C0207a c0207a, C0207a c0207a2) {
        return com.google.zxing.q.m.a.b(c0207a.a(), c0207a.b(), c0207a2.a(), c0207a2.b());
    }

    private static m[] d(m[] mVarArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float c2 = mVarArr[0].c() - mVarArr[2].c();
        float d2 = mVarArr[0].d() - mVarArr[2].d();
        float c3 = (mVarArr[0].c() + mVarArr[2].c()) / 2.0f;
        float d3 = (mVarArr[0].d() + mVarArr[2].d()) / 2.0f;
        float f5 = c2 * f4;
        float f6 = d2 * f4;
        m mVar = new m(c3 + f5, d3 + f6);
        m mVar2 = new m(c3 - f5, d3 - f6);
        float c4 = mVarArr[1].c() - mVarArr[3].c();
        float d4 = mVarArr[1].d() - mVarArr[3].d();
        float c5 = (mVarArr[1].c() + mVarArr[3].c()) / 2.0f;
        float d5 = (mVarArr[1].d() + mVarArr[3].d()) / 2.0f;
        float f7 = c4 * f4;
        float f8 = f4 * d4;
        return new m[]{mVar, new m(c5 + f7, d5 + f8), mVar2, new m(c5 - f7, d5 - f8)};
    }

    private void e(m[] mVarArr) throws NotFoundException {
        long j2;
        long j3;
        if (o(mVarArr[0]) && o(mVarArr[1]) && o(mVarArr[2]) && o(mVarArr[3])) {
            int i2 = this.f9875f * 2;
            int[] iArr = {r(mVarArr[0], mVarArr[1], i2), r(mVarArr[1], mVarArr[2], i2), r(mVarArr[2], mVarArr[3], i2), r(mVarArr[3], mVarArr[0], i2)};
            this.f9876g = m(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f9876g + i3) % 4];
                if (this.f9872c) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int h2 = h(j4, this.f9872c);
            if (this.f9872c) {
                this.f9873d = (h2 >> 6) + 1;
                this.f9874e = (h2 & 63) + 1;
                return;
            }
            this.f9873d = (h2 >> 11) + 1;
            this.f9874e = (h2 & 2047) + 1;
            return;
        }
        throw NotFoundException.a();
    }

    private m[] f(C0207a c0207a) throws NotFoundException {
        this.f9875f = 1;
        C0207a c0207a2 = c0207a;
        C0207a c0207a3 = c0207a2;
        C0207a c0207a4 = c0207a3;
        boolean z = true;
        while (this.f9875f < 9) {
            C0207a j2 = j(c0207a, z, 1, -1);
            C0207a j3 = j(c0207a2, z, 1, 1);
            C0207a j4 = j(c0207a3, z, -1, 1);
            C0207a j5 = j(c0207a4, z, -1, -1);
            if (this.f9875f > 2) {
                double c2 = (c(j5, j2) * this.f9875f) / (c(c0207a4, c0207a) * (this.f9875f + 2));
                if (c2 < 0.75d || c2 > 1.25d || !p(j2, j3, j4, j5)) {
                    break;
                }
            }
            z = !z;
            this.f9875f++;
            c0207a4 = j5;
            c0207a = j2;
            c0207a2 = j3;
            c0207a3 = j4;
        }
        int i2 = this.f9875f;
        if (i2 != 5 && i2 != 7) {
            throw NotFoundException.a();
        }
        this.f9872c = i2 == 5;
        m[] mVarArr = {new m(c0207a.a() + 0.5f, c0207a.b() - 0.5f), new m(c0207a2.a() + 0.5f, c0207a2.b() + 0.5f), new m(c0207a3.a() - 0.5f, c0207a3.b() + 0.5f), new m(c0207a4.a() - 0.5f, c0207a4.b() - 0.5f)};
        int i3 = this.f9875f;
        return d(mVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private int g(C0207a c0207a, C0207a c0207a2) {
        float c2 = c(c0207a, c0207a2);
        float a2 = (c0207a2.a() - c0207a.a()) / c2;
        float b2 = (c0207a2.b() - c0207a.b()) / c2;
        float a3 = c0207a.a();
        float b3 = c0207a.b();
        boolean e2 = this.f9871b.e(c0207a.a(), c0207a.b());
        int ceil = (int) Math.ceil(c2);
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            a3 += a2;
            b3 += b2;
            if (this.f9871b.e(com.google.zxing.q.m.a.c(a3), com.google.zxing.q.m.a.c(b3)) != e2) {
                i2++;
            }
        }
        float f2 = i2 / c2;
        if (f2 <= 0.1f || f2 >= 0.9f) {
            return (f2 <= 0.1f) == e2 ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j2, boolean z) throws NotFoundException {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(com.google.zxing.common.reedsolomon.a.f9801d).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.a();
        }
    }

    private int i() {
        if (this.f9872c) {
            return (this.f9873d * 4) + 11;
        }
        int i2 = this.f9873d;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private C0207a j(C0207a c0207a, boolean z, int i2, int i3) {
        int a2 = c0207a.a() + i2;
        int b2 = c0207a.b();
        while (true) {
            b2 += i3;
            if (!n(a2, b2) || this.f9871b.e(a2, b2) != z) {
                break;
            }
            a2 += i2;
        }
        int i4 = a2 - i2;
        int i5 = b2 - i3;
        while (n(i4, i5) && this.f9871b.e(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (n(i6, i5) && this.f9871b.e(i6, i5) == z) {
            i5 += i3;
        }
        return new C0207a(i6, i5 - i3);
    }

    private C0207a k() {
        m c2;
        m mVar;
        m mVar2;
        m mVar3;
        m c3;
        m c4;
        m c5;
        m c6;
        try {
            m[] c7 = new com.google.zxing.q.m.b(this.f9871b).c();
            mVar2 = c7[0];
            mVar3 = c7[1];
            mVar = c7[2];
            c2 = c7[3];
        } catch (NotFoundException unused) {
            int n = this.f9871b.n() / 2;
            int i2 = this.f9871b.i() / 2;
            int i3 = n + 7;
            int i4 = i2 - 7;
            m c8 = j(new C0207a(i3, i4), false, 1, -1).c();
            int i5 = i2 + 7;
            m c9 = j(new C0207a(i3, i5), false, 1, 1).c();
            int i6 = n - 7;
            m c10 = j(new C0207a(i6, i5), false, -1, 1).c();
            c2 = j(new C0207a(i6, i4), false, -1, -1).c();
            mVar = c10;
            mVar2 = c8;
            mVar3 = c9;
        }
        int c11 = com.google.zxing.q.m.a.c((((mVar2.c() + c2.c()) + mVar3.c()) + mVar.c()) / 4.0f);
        int c12 = com.google.zxing.q.m.a.c((((mVar2.d() + c2.d()) + mVar3.d()) + mVar.d()) / 4.0f);
        try {
            m[] c13 = new com.google.zxing.q.m.b(this.f9871b, 15, c11, c12).c();
            c3 = c13[0];
            c4 = c13[1];
            c5 = c13[2];
            c6 = c13[3];
        } catch (NotFoundException unused2) {
            int i7 = c11 + 7;
            int i8 = c12 - 7;
            c3 = j(new C0207a(i7, i8), false, 1, -1).c();
            int i9 = c12 + 7;
            c4 = j(new C0207a(i7, i9), false, 1, 1).c();
            int i10 = c11 - 7;
            c5 = j(new C0207a(i10, i9), false, -1, 1).c();
            c6 = j(new C0207a(i10, i8), false, -1, -1).c();
        }
        return new C0207a(com.google.zxing.q.m.a.c((((c3.c() + c6.c()) + c4.c()) + c5.c()) / 4.0f), com.google.zxing.q.m.a.c((((c3.d() + c6.d()) + c4.d()) + c5.d()) / 4.0f));
    }

    private m[] l(m[] mVarArr) {
        return d(mVarArr, this.f9875f * 2, i());
    }

    private static int m(int[] iArr, int i2) throws NotFoundException {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(a[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw NotFoundException.a();
    }

    private boolean n(int i2, int i3) {
        return i2 >= 0 && i2 < this.f9871b.n() && i3 > 0 && i3 < this.f9871b.i();
    }

    private boolean o(m mVar) {
        return n(com.google.zxing.q.m.a.c(mVar.c()), com.google.zxing.q.m.a.c(mVar.d()));
    }

    private boolean p(C0207a c0207a, C0207a c0207a2, C0207a c0207a3, C0207a c0207a4) {
        C0207a c0207a5 = new C0207a(c0207a.a() - 3, c0207a.b() + 3);
        C0207a c0207a6 = new C0207a(c0207a2.a() - 3, c0207a2.b() - 3);
        C0207a c0207a7 = new C0207a(c0207a3.a() + 3, c0207a3.b() - 3);
        C0207a c0207a8 = new C0207a(c0207a4.a() + 3, c0207a4.b() + 3);
        int g2 = g(c0207a8, c0207a5);
        return g2 != 0 && g(c0207a5, c0207a6) == g2 && g(c0207a6, c0207a7) == g2 && g(c0207a7, c0207a8) == g2;
    }

    private b q(b bVar, m mVar, m mVar2, m mVar3, m mVar4) throws NotFoundException {
        i b2 = i.b();
        int i2 = i();
        float f2 = i2 / 2.0f;
        int i3 = this.f9875f;
        float f3 = f2 - i3;
        float f4 = f2 + i3;
        return b2.c(bVar, i2, i2, f3, f3, f4, f3, f4, f4, f3, f4, mVar.c(), mVar.d(), mVar2.c(), mVar2.d(), mVar3.c(), mVar3.d(), mVar4.c(), mVar4.d());
    }

    private int r(m mVar, m mVar2, int i2) {
        float b2 = b(mVar, mVar2);
        float f2 = b2 / i2;
        float c2 = mVar.c();
        float d2 = mVar.d();
        float c3 = ((mVar2.c() - mVar.c()) * f2) / b2;
        float d3 = (f2 * (mVar2.d() - mVar.d())) / b2;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.f9871b.e(com.google.zxing.q.m.a.c((f3 * c3) + c2), com.google.zxing.q.m.a.c((f3 * d3) + d2))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public com.google.zxing.o.a a(boolean z) throws NotFoundException {
        m[] f2 = f(k());
        if (z) {
            m mVar = f2[0];
            f2[0] = f2[2];
            f2[2] = mVar;
        }
        e(f2);
        b bVar = this.f9871b;
        int i2 = this.f9876g;
        return new com.google.zxing.o.a(q(bVar, f2[i2 % 4], f2[(i2 + 1) % 4], f2[(i2 + 2) % 4], f2[(i2 + 3) % 4]), l(f2), this.f9872c, this.f9874e, this.f9873d);
    }
}
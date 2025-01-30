package com.google.zxing.v.c;

import com.google.zxing.FormatException;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes2.dex */
final class a {
    private final com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private j f10115b;

    /* renamed from: c  reason: collision with root package name */
    private g f10116c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10117d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.zxing.q.b bVar) throws FormatException {
        int i2 = bVar.i();
        if (i2 >= 21 && (i2 & 3) == 1) {
            this.a = bVar;
            return;
        }
        throw FormatException.a();
    }

    private int a(int i2, int i3, int i4) {
        return this.f10117d ? this.a.e(i3, i2) : this.a.e(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i2 = 0;
        while (i2 < this.a.n()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.a.i(); i4++) {
                if (this.a.e(i2, i4) != this.a.e(i4, i2)) {
                    this.a.d(i4, i2);
                    this.a.d(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() throws FormatException {
        g d2 = d();
        j e2 = e();
        c cVar = c.values()[d2.c()];
        int i2 = this.a.i();
        cVar.n(this.a, i2);
        com.google.zxing.q.b a = e2.a();
        byte[] bArr = new byte[e2.h()];
        int i3 = i2 - 1;
        boolean z = true;
        int i4 = i3;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 > 0) {
            if (i4 == 6) {
                i4--;
            }
            for (int i8 = 0; i8 < i2; i8++) {
                int i9 = z ? i3 - i8 : i8;
                for (int i10 = 0; i10 < 2; i10++) {
                    int i11 = i4 - i10;
                    if (!a.e(i11, i9)) {
                        i6++;
                        i7 <<= 1;
                        if (this.a.e(i11, i9)) {
                            i7 |= 1;
                        }
                        if (i6 == 8) {
                            bArr[i5] = (byte) i7;
                            i5++;
                            i6 = 0;
                            i7 = 0;
                        }
                    }
                }
            }
            z = !z;
            i4 -= 2;
        }
        if (i5 == e2.h()) {
            return bArr;
        }
        throw FormatException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() throws FormatException {
        g gVar = this.f10116c;
        if (gVar != null) {
            return gVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a = a(8, i5, a);
        }
        int i6 = this.a.i();
        int i7 = i6 - 7;
        for (int i8 = i6 - 1; i8 >= i7; i8--) {
            i2 = a(8, i8, i2);
        }
        for (int i9 = i6 - 8; i9 < i6; i9++) {
            i2 = a(i9, 8, i2);
        }
        g a2 = g.a(a, i2);
        this.f10116c = a2;
        if (a2 != null) {
            return a2;
        }
        throw FormatException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() throws FormatException {
        j jVar = this.f10115b;
        if (jVar != null) {
            return jVar;
        }
        int i2 = this.a.i();
        int i3 = (i2 - 17) / 4;
        if (i3 <= 6) {
            return j.i(i3);
        }
        int i4 = i2 - 11;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 5; i7 >= 0; i7--) {
            for (int i8 = i2 - 9; i8 >= i4; i8--) {
                i6 = a(i8, i7, i6);
            }
        }
        j c2 = j.c(i6);
        if (c2 != null && c2.e() == i2) {
            this.f10115b = c2;
            return c2;
        }
        for (int i9 = 5; i9 >= 0; i9--) {
            for (int i10 = i2 - 9; i10 >= i4; i10--) {
                i5 = a(i9, i10, i5);
            }
        }
        j c3 = j.c(i5);
        if (c3 != null && c3.e() == i2) {
            this.f10115b = c3;
            return c3;
        }
        throw FormatException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f10116c == null) {
            return;
        }
        c.values()[this.f10116c.c()].n(this.a, this.a.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z) {
        this.f10115b = null;
        this.f10116c = null;
        this.f10117d = z;
    }
}
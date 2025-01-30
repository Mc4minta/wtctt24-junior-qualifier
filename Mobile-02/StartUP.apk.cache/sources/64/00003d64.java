package com.google.zxing.u.d.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModulusPoly.java */
/* loaded from: classes2.dex */
public final class c {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10109b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.a = bVar;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i2 = 1;
                while (i2 < length && iArr[i2] == 0) {
                    i2++;
                }
                if (i2 == length) {
                    this.f10109b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i2];
                this.f10109b = iArr2;
                System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
                return;
            }
            this.f10109b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (e()) {
                return cVar;
            }
            if (cVar.e()) {
                return this;
            }
            int[] iArr = this.f10109b;
            int[] iArr2 = cVar.f10109b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr3[i2] = this.a.a(iArr2[i2 - length], iArr[i2]);
            }
            return new c(this.a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int i4 : this.f10109b) {
                i3 = this.a.a(i3, i4);
            }
            return i3;
        }
        int[] iArr = this.f10109b;
        int i5 = iArr[0];
        int length = iArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            b bVar = this.a;
            i5 = bVar.a(bVar.i(i2, i5), this.f10109b[i6]);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        int[] iArr = this.f10109b;
        return iArr[(iArr.length - 1) - i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f10109b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f10109b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(int i2) {
        if (i2 == 0) {
            return this.a.f();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f10109b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.i(this.f10109b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (!e() && !cVar.e()) {
                int[] iArr = this.f10109b;
                int length = iArr.length;
                int[] iArr2 = cVar.f10109b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        b bVar = this.a;
                        iArr3[i5] = bVar.a(iArr3[i5], bVar.i(i3, iArr2[i4]));
                    }
                }
                return new c(this.a, iArr3);
            }
            return this.a.f();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.a.f();
            }
            int length = this.f10109b.length;
            int[] iArr = new int[i2 + length];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.a.i(this.f10109b[i4], i3);
            }
            return new c(this.a, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i() {
        int length = this.f10109b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(0, this.f10109b[i2]);
        }
        return new c(this.a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d2 = d(); d2 >= 0; d2--) {
            int c2 = c(d2);
            if (c2 != 0) {
                if (c2 < 0) {
                    sb.append(" - ");
                    c2 = -c2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d2 == 0 || c2 != 1) {
                    sb.append(c2);
                }
                if (d2 != 0) {
                    if (d2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(d2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
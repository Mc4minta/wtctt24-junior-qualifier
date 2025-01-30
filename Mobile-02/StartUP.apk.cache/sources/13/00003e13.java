package com.journeyapps.barcodescanner;

/* compiled from: Size.java */
/* loaded from: classes2.dex */
public class n implements Comparable<n> {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10387b;

    public n(int i2, int i3) {
        this.a = i2;
        this.f10387b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.f10387b == nVar.f10387b;
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(n nVar) {
        int i2 = this.f10387b * this.a;
        int i3 = nVar.f10387b * nVar.a;
        if (i3 < i2) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    public int hashCode() {
        return (this.a * 31) + this.f10387b;
    }

    public n n() {
        return new n(this.f10387b, this.a);
    }

    public n q(n nVar) {
        int i2 = this.a;
        int i3 = nVar.f10387b;
        int i4 = i2 * i3;
        int i5 = nVar.a;
        int i6 = this.f10387b;
        if (i4 <= i5 * i6) {
            return new n(i5, (i6 * i5) / i2);
        }
        return new n((i2 * i3) / i6, i3);
    }

    public n s(n nVar) {
        int i2 = this.a;
        int i3 = nVar.f10387b;
        int i4 = i2 * i3;
        int i5 = nVar.a;
        int i6 = this.f10387b;
        if (i4 >= i5 * i6) {
            return new n(i5, (i6 * i5) / i2);
        }
        return new n((i2 * i3) / i6, i3);
    }

    public String toString() {
        return this.a + "x" + this.f10387b;
    }
}
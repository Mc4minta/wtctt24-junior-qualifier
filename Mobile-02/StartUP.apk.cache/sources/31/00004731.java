package e.g.a.b;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AspectRatio.java */
/* loaded from: classes2.dex */
public class a implements Comparable<a>, Parcelable {

    /* renamed from: b  reason: collision with root package name */
    private final int f12913b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12914c;
    private static final c.e.h<c.e.h<a>> a = new c.e.h<>(16);
    public static final Parcelable.Creator<a> CREATOR = new C0288a();

    /* compiled from: AspectRatio.java */
    /* renamed from: e.g.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0288a implements Parcelable.Creator<a> {
        C0288a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return a.B(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    private a(int i2, int i3) {
        this.f12913b = i2;
        this.f12914c = i3;
    }

    public static a B(int i2, int i3) {
        int n = n(i2, i3);
        int i4 = i2 / n;
        int i5 = i3 / n;
        c.e.h<c.e.h<a>> hVar = a;
        c.e.h<a> f2 = hVar.f(i4);
        if (f2 == null) {
            a aVar = new a(i4, i5);
            c.e.h<a> hVar2 = new c.e.h<>();
            hVar2.l(i5, aVar);
            hVar.l(i4, hVar2);
            return aVar;
        }
        a f3 = f2.f(i5);
        if (f3 == null) {
            a aVar2 = new a(i4, i5);
            f2.l(i5, aVar2);
            return aVar2;
        }
        return f3;
    }

    public static a C(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return B(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Malformed aspect ratio: " + str, e2);
            }
        }
        throw new IllegalArgumentException("Malformed aspect ratio: " + str);
    }

    private static int n(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    public boolean A(j jVar) {
        int n = n(jVar.getWidth(), jVar.getHeight());
        return this.f12913b == jVar.getWidth() / n && this.f12914c == jVar.getHeight() / n;
    }

    public float D() {
        return this.f12913b / this.f12914c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f12913b == aVar.f12913b && this.f12914c == aVar.f12914c;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(a aVar) {
        if (equals(aVar)) {
            return 0;
        }
        return D() - aVar.D() > 0.0f ? 1 : -1;
    }

    public int hashCode() {
        int i2 = this.f12914c;
        int i3 = this.f12913b;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public int q() {
        return this.f12913b;
    }

    public int s() {
        return this.f12914c;
    }

    public String toString() {
        return this.f12913b + ":" + this.f12914c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f12913b);
        parcel.writeInt(this.f12914c);
    }

    public a y() {
        return B(this.f12914c, this.f12913b);
    }
}
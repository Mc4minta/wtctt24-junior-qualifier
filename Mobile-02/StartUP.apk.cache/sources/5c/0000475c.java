package e.g.a.b;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Size.java */
/* loaded from: classes2.dex */
public class j implements Comparable<j>, Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12965b;

    /* compiled from: Size.java */
    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public j[] newArray(int i2) {
            return new j[i2];
        }
    }

    public j(int i2, int i3) {
        this.a = i2;
        this.f12965b = i3;
    }

    public static j n(String str) {
        int indexOf = str.indexOf(120);
        if (indexOf != -1) {
            try {
                return new j(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException("Malformed size: " + str, e2);
            }
        }
        throw new IllegalArgumentException("Malformed size: " + str);
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
        if (obj instanceof j) {
            j jVar = (j) obj;
            return this.a == jVar.a && this.f12965b == jVar.f12965b;
        }
        return false;
    }

    public int getHeight() {
        return this.f12965b;
    }

    public int getWidth() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(j jVar) {
        return (this.a * this.f12965b) - (jVar.a * jVar.f12965b);
    }

    public int hashCode() {
        int i2 = this.f12965b;
        int i3 = this.a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public String toString() {
        return this.a + "x" + this.f12965b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f12965b);
    }
}
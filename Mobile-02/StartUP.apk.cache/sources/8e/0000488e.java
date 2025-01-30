package e.g.a.f.u;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.e.g;

/* compiled from: ExtendableSavedState.java */
/* loaded from: classes2.dex */
public class a extends c.j.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0306a();

    /* renamed from: c  reason: collision with root package name */
    public final g<String, Bundle> f13337c;

    /* compiled from: ExtendableSavedState.java */
    /* renamed from: e.g.a.f.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0306a implements Parcelable.ClassLoaderCreator<a> {
        C0306a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0306a c0306a) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f13337c + "}";
    }

    @Override // c.j.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.f13337c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.f13337c.keyAt(i3);
            bundleArr[i3] = this.f13337c.valueAt(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f13337c = new g<>();
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f13337c = new g<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f13337c.put(strArr[i2], bundleArr[i2]);
        }
    }
}
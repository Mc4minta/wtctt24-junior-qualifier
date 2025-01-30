package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();
    ArrayList<r> a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f1650b;

    /* renamed from: c  reason: collision with root package name */
    b[] f1651c;

    /* renamed from: d  reason: collision with root package name */
    int f1652d;

    /* renamed from: e  reason: collision with root package name */
    String f1653e;

    /* compiled from: FragmentManagerState.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<o> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public o[] newArray(int i2) {
            return new o[i2];
        }
    }

    public o() {
        this.f1653e = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.f1650b);
        parcel.writeTypedArray(this.f1651c, i2);
        parcel.writeInt(this.f1652d);
        parcel.writeString(this.f1653e);
    }

    public o(Parcel parcel) {
        this.f1653e = null;
        this.a = parcel.createTypedArrayList(r.CREATOR);
        this.f1650b = parcel.createStringArrayList();
        this.f1651c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1652d = parcel.readInt();
        this.f1653e = parcel.readString();
    }
}
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f373b;

    /* renamed from: c  reason: collision with root package name */
    public int f374c;

    /* renamed from: d  reason: collision with root package name */
    public int f375d;

    /* renamed from: e  reason: collision with root package name */
    public int f376e;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.a = parcel.readInt();
        this.f374c = parcel.readInt();
        this.f375d = parcel.readInt();
        this.f376e = parcel.readInt();
        this.f373b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.f374c);
        parcel.writeInt(this.f375d);
        parcel.writeInt(this.f376e);
        parcel.writeInt(this.f373b);
    }
}
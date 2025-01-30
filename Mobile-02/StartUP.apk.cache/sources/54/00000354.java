package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavBackStackEntryState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    private final UUID a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1861b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f1862c;

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f1863d;

    /* compiled from: NavBackStackEntryState.java */
    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar.f1855f;
        this.f1861b = eVar.b().r();
        this.f1862c = eVar.a();
        Bundle bundle = new Bundle();
        this.f1863d = bundle;
        eVar.h(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        return this.f1862c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1861b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c() {
        return this.f1863d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UUID d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a.toString());
        parcel.writeInt(this.f1861b);
        parcel.writeBundle(this.f1862c);
        parcel.writeBundle(this.f1863d);
    }

    f(Parcel parcel) {
        this.a = UUID.fromString(parcel.readString());
        this.f1861b = parcel.readInt();
        this.f1862c = parcel.readBundle(f.class.getClassLoader());
        this.f1863d = parcel.readBundle(f.class.getClassLoader());
    }
}
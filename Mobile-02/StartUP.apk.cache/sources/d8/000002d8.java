package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentState.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new a();
    final String a;

    /* renamed from: b  reason: collision with root package name */
    final String f1664b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1665c;

    /* renamed from: d  reason: collision with root package name */
    final int f1666d;

    /* renamed from: e  reason: collision with root package name */
    final int f1667e;

    /* renamed from: f  reason: collision with root package name */
    final String f1668f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f1669g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f1670h;

    /* renamed from: j  reason: collision with root package name */
    final boolean f1671j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f1672k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f1673l;
    final int m;
    Bundle n;

    /* compiled from: FragmentState.java */
    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<r> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public r createFromParcel(Parcel parcel) {
            return new r(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public r[] newArray(int i2) {
            return new r[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.f1664b = fragment.mWho;
        this.f1665c = fragment.mFromLayout;
        this.f1666d = fragment.mFragmentId;
        this.f1667e = fragment.mContainerId;
        this.f1668f = fragment.mTag;
        this.f1669g = fragment.mRetainInstance;
        this.f1670h = fragment.mRemoving;
        this.f1671j = fragment.mDetached;
        this.f1672k = fragment.mArguments;
        this.f1673l = fragment.mHidden;
        this.m = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.f1664b);
        sb.append(")}:");
        if (this.f1665c) {
            sb.append(" fromLayout");
        }
        if (this.f1667e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1667e));
        }
        String str = this.f1668f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1668f);
        }
        if (this.f1669g) {
            sb.append(" retainInstance");
        }
        if (this.f1670h) {
            sb.append(" removing");
        }
        if (this.f1671j) {
            sb.append(" detached");
        }
        if (this.f1673l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.f1664b);
        parcel.writeInt(this.f1665c ? 1 : 0);
        parcel.writeInt(this.f1666d);
        parcel.writeInt(this.f1667e);
        parcel.writeString(this.f1668f);
        parcel.writeInt(this.f1669g ? 1 : 0);
        parcel.writeInt(this.f1670h ? 1 : 0);
        parcel.writeInt(this.f1671j ? 1 : 0);
        parcel.writeBundle(this.f1672k);
        parcel.writeInt(this.f1673l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }

    r(Parcel parcel) {
        this.a = parcel.readString();
        this.f1664b = parcel.readString();
        this.f1665c = parcel.readInt() != 0;
        this.f1666d = parcel.readInt();
        this.f1667e = parcel.readInt();
        this.f1668f = parcel.readString();
        this.f1669g = parcel.readInt() != 0;
        this.f1670h = parcel.readInt() != 0;
        this.f1671j = parcel.readInt() != 0;
        this.f1672k = parcel.readBundle();
        this.f1673l = parcel.readInt() != 0;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }
}
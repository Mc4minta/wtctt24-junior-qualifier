package io.branch.referral.j0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LinkProperties.java */
/* loaded from: classes2.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private final ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    private String f17044b;

    /* renamed from: c  reason: collision with root package name */
    private String f17045c;

    /* renamed from: d  reason: collision with root package name */
    private String f17046d;

    /* renamed from: e  reason: collision with root package name */
    private int f17047e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f17048f;

    /* renamed from: g  reason: collision with root package name */
    private String f17049g;

    /* renamed from: h  reason: collision with root package name */
    private String f17050h;

    /* compiled from: LinkProperties.java */
    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }

    public d a(String str, String str2) {
        this.f17048f.put(str, str2);
        return this;
    }

    public String b() {
        return this.f17045c;
    }

    public String c() {
        return this.f17050h;
    }

    public String d() {
        return this.f17049g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HashMap<String, String> e() {
        return this.f17048f;
    }

    public String f() {
        return this.f17044b;
    }

    public int g() {
        return this.f17047e;
    }

    public String h() {
        return this.f17046d;
    }

    public ArrayList<String> i() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f17044b);
        parcel.writeString(this.f17045c);
        parcel.writeString(this.f17046d);
        parcel.writeString(this.f17049g);
        parcel.writeString(this.f17050h);
        parcel.writeInt(this.f17047e);
        parcel.writeSerializable(this.a);
        parcel.writeInt(this.f17048f.size());
        for (Map.Entry<String, String> entry : this.f17048f.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public d() {
        this.a = new ArrayList<>();
        this.f17044b = "Share";
        this.f17048f = new HashMap<>();
        this.f17045c = "";
        this.f17046d = "";
        this.f17047e = 0;
        this.f17049g = "";
        this.f17050h = "";
    }

    private d(Parcel parcel) {
        this();
        this.f17044b = parcel.readString();
        this.f17045c = parcel.readString();
        this.f17046d = parcel.readString();
        this.f17049g = parcel.readString();
        this.f17050h = parcel.readString();
        this.f17047e = parcel.readInt();
        this.a.addAll((ArrayList) parcel.readSerializable());
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f17048f.put(parcel.readString(), parcel.readString());
        }
    }
}
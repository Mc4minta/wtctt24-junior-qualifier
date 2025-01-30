package io.branch.referral.j0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ContentMetadata.java */
/* loaded from: classes2.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private final HashMap<String, String> A;
    io.branch.referral.j0.a a;

    /* renamed from: b  reason: collision with root package name */
    public Double f17016b;

    /* renamed from: c  reason: collision with root package name */
    public Double f17017c;

    /* renamed from: d  reason: collision with root package name */
    public c f17018d;

    /* renamed from: e  reason: collision with root package name */
    public String f17019e;

    /* renamed from: f  reason: collision with root package name */
    public String f17020f;

    /* renamed from: g  reason: collision with root package name */
    public String f17021g;

    /* renamed from: h  reason: collision with root package name */
    public e f17022h;

    /* renamed from: j  reason: collision with root package name */
    public EnumC0408b f17023j;

    /* renamed from: k  reason: collision with root package name */
    public String f17024k;

    /* renamed from: l  reason: collision with root package name */
    public Double f17025l;
    public Double m;
    public Integer n;
    public Double p;
    public String q;
    public String t;
    public String u;
    public String v;
    public String w;
    public Double x;
    public Double y;
    private final ArrayList<String> z;

    /* compiled from: ContentMetadata.java */
    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    }

    /* compiled from: ContentMetadata.java */
    /* renamed from: io.branch.referral.j0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0408b {
        OTHER,
        NEW,
        GOOD,
        FAIR,
        POOR,
        USED,
        REFURBISHED,
        EXCELLENT;

        public static EnumC0408b h(String str) {
            EnumC0408b[] values;
            if (!TextUtils.isEmpty(str)) {
                for (EnumC0408b enumC0408b : values()) {
                    if (enumC0408b.name().equalsIgnoreCase(str)) {
                        return enumC0408b;
                    }
                }
            }
            return null;
        }
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a != null) {
                jSONObject.put(l.ContentSchema.h(), this.a.name());
            }
            if (this.f17016b != null) {
                jSONObject.put(l.Quantity.h(), this.f17016b);
            }
            if (this.f17017c != null) {
                jSONObject.put(l.Price.h(), this.f17017c);
            }
            if (this.f17018d != null) {
                jSONObject.put(l.PriceCurrency.h(), this.f17018d.toString());
            }
            if (!TextUtils.isEmpty(this.f17019e)) {
                jSONObject.put(l.SKU.h(), this.f17019e);
            }
            if (!TextUtils.isEmpty(this.f17020f)) {
                jSONObject.put(l.ProductName.h(), this.f17020f);
            }
            if (!TextUtils.isEmpty(this.f17021g)) {
                jSONObject.put(l.ProductBrand.h(), this.f17021g);
            }
            if (this.f17022h != null) {
                jSONObject.put(l.ProductCategory.h(), this.f17022h.h());
            }
            if (this.f17023j != null) {
                jSONObject.put(l.Condition.h(), this.f17023j.name());
            }
            if (!TextUtils.isEmpty(this.f17024k)) {
                jSONObject.put(l.ProductVariant.h(), this.f17024k);
            }
            if (this.f17025l != null) {
                jSONObject.put(l.Rating.h(), this.f17025l);
            }
            if (this.m != null) {
                jSONObject.put(l.RatingAverage.h(), this.m);
            }
            if (this.n != null) {
                jSONObject.put(l.RatingCount.h(), this.n);
            }
            if (this.p != null) {
                jSONObject.put(l.RatingMax.h(), this.p);
            }
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put(l.AddressStreet.h(), this.q);
            }
            if (!TextUtils.isEmpty(this.t)) {
                jSONObject.put(l.AddressCity.h(), this.t);
            }
            if (!TextUtils.isEmpty(this.u)) {
                jSONObject.put(l.AddressRegion.h(), this.u);
            }
            if (!TextUtils.isEmpty(this.v)) {
                jSONObject.put(l.AddressCountry.h(), this.v);
            }
            if (!TextUtils.isEmpty(this.w)) {
                jSONObject.put(l.AddressPostalCode.h(), this.w);
            }
            if (this.x != null) {
                jSONObject.put(l.Latitude.h(), this.x);
            }
            if (this.y != null) {
                jSONObject.put(l.Longitude.h(), this.y);
            }
            if (this.z.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(l.ImageCaptions.h(), jSONArray);
                Iterator<String> it = this.z.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            if (this.A.size() > 0) {
                for (String str : this.A.keySet()) {
                    jSONObject.put(str, this.A.get(str));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        io.branch.referral.j0.a aVar = this.a;
        parcel.writeString(aVar != null ? aVar.name() : "");
        parcel.writeSerializable(this.f17016b);
        parcel.writeSerializable(this.f17017c);
        c cVar = this.f17018d;
        parcel.writeString(cVar != null ? cVar.name() : "");
        parcel.writeString(this.f17019e);
        parcel.writeString(this.f17020f);
        parcel.writeString(this.f17021g);
        e eVar = this.f17022h;
        parcel.writeString(eVar != null ? eVar.h() : "");
        EnumC0408b enumC0408b = this.f17023j;
        parcel.writeString(enumC0408b != null ? enumC0408b.name() : "");
        parcel.writeString(this.f17024k);
        parcel.writeSerializable(this.f17025l);
        parcel.writeSerializable(this.m);
        parcel.writeSerializable(this.n);
        parcel.writeSerializable(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeSerializable(this.x);
        parcel.writeSerializable(this.y);
        parcel.writeSerializable(this.z);
        parcel.writeSerializable(this.A);
    }

    public b() {
        this.z = new ArrayList<>();
        this.A = new HashMap<>();
    }

    private b(Parcel parcel) {
        this();
        this.a = io.branch.referral.j0.a.h(parcel.readString());
        this.f17016b = (Double) parcel.readSerializable();
        this.f17017c = (Double) parcel.readSerializable();
        this.f17018d = c.h(parcel.readString());
        this.f17019e = parcel.readString();
        this.f17020f = parcel.readString();
        this.f17021g = parcel.readString();
        this.f17022h = e.n(parcel.readString());
        this.f17023j = EnumC0408b.h(parcel.readString());
        this.f17024k = parcel.readString();
        this.f17025l = (Double) parcel.readSerializable();
        this.m = (Double) parcel.readSerializable();
        this.n = (Integer) parcel.readSerializable();
        this.p = (Double) parcel.readSerializable();
        this.q = parcel.readString();
        this.t = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = (Double) parcel.readSerializable();
        this.y = (Double) parcel.readSerializable();
        this.z.addAll((ArrayList) parcel.readSerializable());
        this.A.putAll((HashMap) parcel.readSerializable());
    }
}
package h.b.a;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.f;
import io.branch.referral.j0.d;
import io.branch.referral.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BranchUniversalObject.java */
/* loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0337a();
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f14028b;

    /* renamed from: c  reason: collision with root package name */
    private String f14029c;

    /* renamed from: d  reason: collision with root package name */
    private String f14030d;

    /* renamed from: e  reason: collision with root package name */
    private String f14031e;

    /* renamed from: f  reason: collision with root package name */
    private io.branch.referral.j0.b f14032f;

    /* renamed from: g  reason: collision with root package name */
    private b f14033g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<String> f14034h;

    /* renamed from: j  reason: collision with root package name */
    private long f14035j;

    /* renamed from: k  reason: collision with root package name */
    private b f14036k;

    /* renamed from: l  reason: collision with root package name */
    private long f14037l;

    /* compiled from: BranchUniversalObject.java */
    /* renamed from: h.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0337a implements Parcelable.Creator {
        C0337a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    /* compiled from: BranchUniversalObject.java */
    /* loaded from: classes2.dex */
    public enum b {
        PUBLIC,
        PRIVATE
    }

    /* synthetic */ a(Parcel parcel, C0337a c0337a) {
        this(parcel);
    }

    private f b(Context context, d dVar) {
        return c(new f(context), dVar);
    }

    private f c(f fVar, d dVar) {
        if (dVar.i() != null) {
            fVar.b(dVar.i());
        }
        if (dVar.f() != null) {
            fVar.i(dVar.f());
        }
        if (dVar.b() != null) {
            fVar.e(dVar.b());
        }
        if (dVar.d() != null) {
            fVar.g(dVar.d());
        }
        if (dVar.h() != null) {
            fVar.j(dVar.h());
        }
        if (dVar.c() != null) {
            fVar.f(dVar.c());
        }
        if (dVar.g() > 0) {
            fVar.h(dVar.g());
        }
        if (!TextUtils.isEmpty(this.f14029c)) {
            fVar.a(l.ContentTitle.h(), this.f14029c);
        }
        if (!TextUtils.isEmpty(this.a)) {
            fVar.a(l.CanonicalIdentifier.h(), this.a);
        }
        if (!TextUtils.isEmpty(this.f14028b)) {
            fVar.a(l.CanonicalUrl.h(), this.f14028b);
        }
        JSONArray a = a();
        if (a.length() > 0) {
            fVar.a(l.ContentKeyWords.h(), a);
        }
        if (!TextUtils.isEmpty(this.f14030d)) {
            fVar.a(l.ContentDesc.h(), this.f14030d);
        }
        if (!TextUtils.isEmpty(this.f14031e)) {
            fVar.a(l.ContentImgUrl.h(), this.f14031e);
        }
        if (this.f14035j > 0) {
            String h2 = l.ContentExpiryTime.h();
            fVar.a(h2, "" + this.f14035j);
        }
        String h3 = l.PublicallyIndexable.h();
        fVar.a(h3, "" + e());
        JSONObject a2 = this.f14032f.a();
        try {
            Iterator<String> keys = a2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                fVar.a(next, a2.get(next));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HashMap<String, String> e3 = dVar.e();
        for (String str : e3.keySet()) {
            fVar.a(str, e3.get(str));
        }
        return fVar;
    }

    public JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f14034h.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public String d(Context context, d dVar) {
        return b(context, dVar).d();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f14033g == b.PUBLIC;
    }

    public a f(String str) {
        this.a = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f14037l);
        parcel.writeString(this.a);
        parcel.writeString(this.f14028b);
        parcel.writeString(this.f14029c);
        parcel.writeString(this.f14030d);
        parcel.writeString(this.f14031e);
        parcel.writeLong(this.f14035j);
        parcel.writeInt(this.f14033g.ordinal());
        parcel.writeSerializable(this.f14034h);
        parcel.writeParcelable(this.f14032f, i2);
        parcel.writeInt(this.f14036k.ordinal());
    }

    public a() {
        this.f14032f = new io.branch.referral.j0.b();
        this.f14034h = new ArrayList<>();
        this.a = "";
        this.f14028b = "";
        this.f14029c = "";
        this.f14030d = "";
        b bVar = b.PUBLIC;
        this.f14033g = bVar;
        this.f14036k = bVar;
        this.f14035j = 0L;
        this.f14037l = System.currentTimeMillis();
    }

    private a(Parcel parcel) {
        this();
        this.f14037l = parcel.readLong();
        this.a = parcel.readString();
        this.f14028b = parcel.readString();
        this.f14029c = parcel.readString();
        this.f14030d = parcel.readString();
        this.f14031e = parcel.readString();
        this.f14035j = parcel.readLong();
        this.f14033g = b.values()[parcel.readInt()];
        ArrayList arrayList = (ArrayList) parcel.readSerializable();
        if (arrayList != null) {
            this.f14034h.addAll(arrayList);
        }
        this.f14032f = (io.branch.referral.j0.b) parcel.readParcelable(io.branch.referral.j0.b.class.getClassLoader());
        this.f14036k = b.values()[parcel.readInt()];
    }
}
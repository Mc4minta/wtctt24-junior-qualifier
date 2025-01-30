package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class GoogleSignInAccount extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new f();
    private static com.google.android.gms.common.util.e a = com.google.android.gms.common.util.h.c();

    /* renamed from: b  reason: collision with root package name */
    private final int f5953b;

    /* renamed from: c  reason: collision with root package name */
    private String f5954c;

    /* renamed from: d  reason: collision with root package name */
    private String f5955d;

    /* renamed from: e  reason: collision with root package name */
    private String f5956e;

    /* renamed from: f  reason: collision with root package name */
    private String f5957f;

    /* renamed from: g  reason: collision with root package name */
    private Uri f5958g;

    /* renamed from: h  reason: collision with root package name */
    private String f5959h;

    /* renamed from: j  reason: collision with root package name */
    private long f5960j;

    /* renamed from: k  reason: collision with root package name */
    private String f5961k;

    /* renamed from: l  reason: collision with root package name */
    private List<Scope> f5962l;
    private String m;
    private String n;
    private Set<Scope> p = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f5953b = i2;
        this.f5954c = str;
        this.f5955d = str2;
        this.f5956e = str3;
        this.f5957f = str4;
        this.f5958g = uri;
        this.f5959h = str5;
        this.f5960j = j2;
        this.f5961k = str6;
        this.f5962l = list;
        this.m = str7;
        this.n = str8;
    }

    public static GoogleSignInAccount i1() {
        Account account = new Account("<<default account>>", "com.google");
        return t1(null, null, account.name, null, null, null, null, 0L, account.name, new HashSet());
    }

    public static GoogleSignInAccount s1(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount t1 = t1(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        t1.f5959h = jSONObject.optString("serverAuthCode", null);
        return t1;
    }

    private static GoogleSignInAccount t1(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l2, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l2 == null ? Long.valueOf(a.a() / 1000) : l2).longValue(), t.g(str7), new ArrayList((Collection) t.k(set)), str5, str6);
    }

    private final JSONObject w1() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (n1() != null) {
                jSONObject.put("tokenId", n1());
            }
            if (k1() != null) {
                jSONObject.put("email", k1());
            }
            if (j1() != null) {
                jSONObject.put("displayName", j1());
            }
            if (m1() != null) {
                jSONObject.put("givenName", m1());
            }
            if (l1() != null) {
                jSONObject.put("familyName", l1());
            }
            if (o1() != null) {
                jSONObject.put("photoUrl", o1().toString());
            }
            if (q1() != null) {
                jSONObject.put("serverAuthCode", q1());
            }
            jSONObject.put("expirationTime", this.f5960j);
            jSONObject.put("obfuscatedIdentifier", this.f5961k);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.f5962l;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, e.a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.i1());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.f5961k.equals(this.f5961k) && googleSignInAccount.p1().equals(p1());
        }
        return false;
    }

    public String getId() {
        return this.f5954c;
    }

    public int hashCode() {
        return ((this.f5961k.hashCode() + 527) * 31) + p1().hashCode();
    }

    public String j1() {
        return this.f5957f;
    }

    public String k1() {
        return this.f5956e;
    }

    public String l1() {
        return this.n;
    }

    public Account m() {
        if (this.f5956e == null) {
            return null;
        }
        return new Account(this.f5956e, "com.google");
    }

    public String m1() {
        return this.m;
    }

    public String n1() {
        return this.f5955d;
    }

    public Uri o1() {
        return this.f5958g;
    }

    public Set<Scope> p1() {
        HashSet hashSet = new HashSet(this.f5962l);
        hashSet.addAll(this.p);
        return hashSet;
    }

    public String q1() {
        return this.f5959h;
    }

    public final String u1() {
        return this.f5961k;
    }

    public final String v1() {
        JSONObject w1 = w1();
        w1.remove("serverAuthCode");
        return w1.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.f5953b);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 2, getId(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 3, n1(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 4, k1(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 5, j1(), false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 6, o1(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 7, q1(), false);
        com.google.android.gms.common.internal.safeparcel.b.n(parcel, 8, this.f5960j);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 9, this.f5961k, false);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, 10, this.f5962l, false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 11, m1(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 12, l1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
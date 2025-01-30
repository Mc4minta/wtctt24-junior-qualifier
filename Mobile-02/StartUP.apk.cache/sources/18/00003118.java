package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class GoogleSignInOptions extends com.google.android.gms.common.internal.safeparcel.a implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final Scope a = new Scope("profile");

    /* renamed from: b  reason: collision with root package name */
    public static final Scope f5963b = new Scope("email");

    /* renamed from: c  reason: collision with root package name */
    public static final Scope f5964c = new Scope("openid");

    /* renamed from: d  reason: collision with root package name */
    public static final Scope f5965d;

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f5966e;

    /* renamed from: f  reason: collision with root package name */
    public static final GoogleSignInOptions f5967f;

    /* renamed from: g  reason: collision with root package name */
    public static final GoogleSignInOptions f5968g;

    /* renamed from: h  reason: collision with root package name */
    private static Comparator<Scope> f5969h;

    /* renamed from: j  reason: collision with root package name */
    private final int f5970j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<Scope> f5971k;

    /* renamed from: l  reason: collision with root package name */
    private Account f5972l;
    private boolean m;
    private final boolean n;
    private final boolean p;
    private String q;
    private String t;
    private ArrayList<com.google.android.gms.auth.api.signin.internal.a> u;
    private String v;
    private Map<Integer, com.google.android.gms.auth.api.signin.internal.a> w;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f5965d = scope;
        f5966e = new Scope("https://www.googleapis.com/auth/games");
        f5967f = new a().c().d().a();
        f5968g = new a().e(scope, new Scope[0]).a();
        CREATOR = new h();
        f5969h = new g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<com.google.android.gms.auth.api.signin.internal.a> arrayList2, String str3) {
        this(i2, arrayList, account, z, z2, z3, str, str2, q1(arrayList2), str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, com.google.android.gms.auth.api.signin.internal.a> q1(List<com.google.android.gms.auth.api.signin.internal.a> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (com.google.android.gms.auth.api.signin.internal.a aVar : list) {
            hashMap.put(Integer.valueOf(aVar.i1()), aVar);
        }
        return hashMap;
    }

    public static GoogleSignInOptions r1(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap(), (String) null);
    }

    private final JSONObject v1() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f5971k, f5969h);
            ArrayList<Scope> arrayList = this.f5971k;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Scope scope = arrayList.get(i2);
                i2++;
                jSONArray.put(scope.i1());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f5972l;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.m);
            jSONObject.put("forceCodeForRefreshToken", this.p);
            jSONObject.put("serverAuthRequested", this.n);
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("serverClientId", this.q);
            }
            if (!TextUtils.isEmpty(this.t)) {
                jSONObject.put("hostedDomain", this.t);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r1.equals(r4.m()) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r3.q.equals(r4.l1()) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.a> r1 = r3.u     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 > 0) goto L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.a> r1 = r4.u     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 <= 0) goto L18
            goto L8f
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f5971k     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.k1()     // Catch: java.lang.ClassCastException -> L8f
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f5971k     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.k1()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L35
            goto L8f
        L35:
            android.accounts.Account r1 = r3.f5972l     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.m()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L8f
            goto L4a
        L40:
            android.accounts.Account r2 = r4.m()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L4a:
            java.lang.String r1 = r3.q     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.l1()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
            goto L69
        L5d:
            java.lang.String r1 = r3.q     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r2 = r4.l1()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L69:
            boolean r1 = r3.p     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.m1()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.m     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.n1()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.n     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.o1()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.lang.String r1 = r3.v     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r4 = r4.j1()     // Catch: java.lang.ClassCastException -> L8f
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L8f
            if (r4 == 0) goto L8f
            r4 = 1
            return r4
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f5971k;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.i1());
        }
        Collections.sort(arrayList);
        return new com.google.android.gms.auth.api.signin.internal.b().a(arrayList).a(this.f5972l).a(this.q).c(this.p).c(this.m).c(this.n).a(this.v).b();
    }

    public ArrayList<com.google.android.gms.auth.api.signin.internal.a> i1() {
        return this.u;
    }

    public String j1() {
        return this.v;
    }

    public ArrayList<Scope> k1() {
        return new ArrayList<>(this.f5971k);
    }

    public String l1() {
        return this.q;
    }

    public Account m() {
        return this.f5972l;
    }

    public boolean m1() {
        return this.p;
    }

    public boolean n1() {
        return this.m;
    }

    public boolean o1() {
        return this.n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.l(parcel, 1, this.f5970j);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, 2, k1(), false);
        com.google.android.gms.common.internal.safeparcel.b.p(parcel, 3, m(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, n1());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 5, o1());
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 6, m1());
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 7, l1(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 8, this.t, false);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, 9, i1(), false);
        com.google.android.gms.common.internal.safeparcel.b.q(parcel, 10, j1(), false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }

    public final String x1() {
        return v1().toString();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static final class a {
        private Set<Scope> a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5973b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5974c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5975d;

        /* renamed from: e  reason: collision with root package name */
        private String f5976e;

        /* renamed from: f  reason: collision with root package name */
        private Account f5977f;

        /* renamed from: g  reason: collision with root package name */
        private String f5978g;

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, com.google.android.gms.auth.api.signin.internal.a> f5979h;

        /* renamed from: i  reason: collision with root package name */
        private String f5980i;

        public a() {
            this.a = new HashSet();
            this.f5979h = new HashMap();
        }

        public final GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.f5966e)) {
                Set<Scope> set = this.a;
                Scope scope = GoogleSignInOptions.f5965d;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.f5975d && (this.f5977f == null || !this.a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f5977f, this.f5975d, this.f5973b, this.f5974c, this.f5976e, this.f5978g, this.f5979h, this.f5980i, null);
        }

        public final a b() {
            this.a.add(GoogleSignInOptions.f5963b);
            return this;
        }

        public final a c() {
            this.a.add(GoogleSignInOptions.f5964c);
            return this;
        }

        public final a d() {
            this.a.add(GoogleSignInOptions.a);
            return this;
        }

        public final a e(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final a f(String str) {
            this.f5980i = str;
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.f5979h = new HashMap();
            t.k(googleSignInOptions);
            this.a = new HashSet(googleSignInOptions.f5971k);
            this.f5973b = googleSignInOptions.n;
            this.f5974c = googleSignInOptions.p;
            this.f5975d = googleSignInOptions.m;
            this.f5976e = googleSignInOptions.q;
            this.f5977f = googleSignInOptions.f5972l;
            this.f5978g = googleSignInOptions.t;
            this.f5979h = GoogleSignInOptions.q1(googleSignInOptions.u);
            this.f5980i = googleSignInOptions.v;
        }
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, com.google.android.gms.auth.api.signin.internal.a> map, String str3) {
        this.f5970j = i2;
        this.f5971k = arrayList;
        this.f5972l = account;
        this.m = z;
        this.n = z2;
        this.p = z3;
        this.q = str;
        this.t = str2;
        this.u = new ArrayList<>(map.values());
        this.w = map;
        this.v = str3;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, g gVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map, str3);
    }
}
package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ServerRequest.java */
/* loaded from: classes2.dex */
public abstract class r {
    private JSONObject a;

    /* renamed from: b  reason: collision with root package name */
    private String f17103b;

    /* renamed from: c  reason: collision with root package name */
    protected final q f17104c;

    /* renamed from: d  reason: collision with root package name */
    private long f17105d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f17106e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<b> f17107f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17108g;

    /* renamed from: h  reason: collision with root package name */
    boolean f17109h;

    /* compiled from: ServerRequest.java */
    /* loaded from: classes2.dex */
    public enum a {
        V1,
        V2
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServerRequest.java */
    /* loaded from: classes2.dex */
    public enum b {
        FB_APP_LINK_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        STRONG_MATCH_PENDING_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK
    }

    public r(Context context, String str) {
        this.f17105d = 0L;
        this.f17108g = false;
        this.f17109h = false;
        this.f17106e = context;
        this.f17103b = str;
        this.f17104c = q.B(context);
        this.a = new JSONObject();
        this.f17107f = new HashSet();
    }

    private void D() {
        JSONObject optJSONObject;
        if (g() != a.V2 || (optJSONObject = this.a.optJSONObject(l.UserData.h())) == null) {
            return;
        }
        try {
            optJSONObject.put(l.DeveloperIdentity.h(), this.f17104c.x());
            optJSONObject.put(l.DeviceFingerprintID.h(), this.f17104c.s());
        } catch (JSONException unused) {
        }
    }

    private void F() {
        a g2 = g();
        int h2 = o.e().h().h();
        String e2 = o.e().h().e();
        if (!TextUtils.isEmpty(e2)) {
            try {
                if (g2 == a.V2) {
                    JSONObject optJSONObject = this.a.optJSONObject(l.UserData.h());
                    if (optJSONObject != null) {
                        optJSONObject.put(l.AAID.h(), e2);
                        optJSONObject.put(l.LimitedAdTracking.h(), h2);
                        optJSONObject.remove(l.UnidentifiedDevice.h());
                    }
                } else {
                    this.a.put(l.GoogleAdvertisingID.h(), e2);
                    this.a.put(l.LATVal.h(), h2);
                }
                return;
            } catch (JSONException e3) {
                e3.printStackTrace();
                return;
            }
        }
        a aVar = a.V2;
        if (g2 == aVar && g2 == aVar) {
            try {
                JSONObject optJSONObject2 = this.a.optJSONObject(l.UserData.h());
                if (optJSONObject2 == null || optJSONObject2.has(l.AndroidID.h())) {
                    return;
                }
                optJSONObject2.put(l.UnidentifiedDevice.h(), true);
            } catch (JSONException unused) {
            }
        }
    }

    private void G() {
        boolean T;
        JSONObject optJSONObject = g() == a.V1 ? this.a : this.a.optJSONObject(l.UserData.h());
        if (optJSONObject == null || !(T = this.f17104c.T())) {
            return;
        }
        try {
            optJSONObject.putOpt(l.limitFacebookTracking.h(), Boolean.valueOf(T));
        } catch (JSONException unused) {
        }
    }

    private void H() {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> keys = this.f17104c.L().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, this.f17104c.L().get(next));
            }
            JSONObject optJSONObject = this.a.optJSONObject(l.Metadata.h());
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject.put(next2, optJSONObject.get(next2));
                }
            }
            if ((this instanceof c0) && this.f17104c.z().length() > 0) {
                this.a.putOpt(l.InstallMetadata.h(), this.f17104c.z());
            }
            this.a.put(l.Metadata.h(), jSONObject);
        } catch (JSONException unused) {
            q.a("Could not merge metadata, ignoring user metadata.");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:2|3)|(5:5|7|8|(2:10|11)|(1:19)(2:16|17))|21|7|8|(0)|(1:14)|19) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0019 A[Catch: JSONException -> 0x001e, TRY_LEAVE, TryCatch #1 {JSONException -> 0x001e, blocks: (B:8:0x0013, B:10:0x0019), top: B:22:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static io.branch.referral.r f(org.json.JSONObject r5, android.content.Context r6) {
        /*
            java.lang.String r0 = "REQ_POST_PATH"
            java.lang.String r1 = "REQ_POST"
            java.lang.String r2 = ""
            r3 = 0
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L12
            if (r4 == 0) goto L12
            org.json.JSONObject r1 = r5.getJSONObject(r1)     // Catch: org.json.JSONException -> L12
            goto L13
        L12:
            r1 = r3
        L13:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L1e
            if (r4 == 0) goto L1e
            java.lang.String r5 = r5.getString(r0)     // Catch: org.json.JSONException -> L1e
            r2 = r5
        L1e:
            if (r2 == 0) goto L2b
            int r5 = r2.length()
            if (r5 <= 0) goto L2b
            io.branch.referral.r r5 = h(r2, r1, r6)
            return r5
        L2b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.r.f(org.json.JSONObject, android.content.Context):io.branch.referral.r");
    }

    private static r h(String str, JSONObject jSONObject, Context context) {
        if (str.equalsIgnoreCase(n.CompletedAction.h())) {
            return new s(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.GetURL.h())) {
            return new t(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.GetCreditHistory.h())) {
            return new u(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.GetCredits.h())) {
            return new v(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.IdentifyUser.h())) {
            return new w(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.Logout.h())) {
            return new y(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.RedeemRewards.h())) {
            return new a0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.RegisterClose.h())) {
            return new b0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.RegisterInstall.h())) {
            return new c0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(n.RegisterOpen.h())) {
            return new d0(str, jSONObject, context);
        }
        return null;
    }

    public boolean A() {
        return false;
    }

    protected boolean B() {
        return false;
    }

    public JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("REQ_POST", this.a);
            jSONObject.put("REQ_POST_PATH", this.f17103b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(Context context, JSONObject jSONObject) {
        try {
            String h2 = (o.e().l() ? l.NativeApp : l.InstantApp).h();
            if (g() == a.V2) {
                JSONObject optJSONObject = jSONObject.optJSONObject(l.UserData.h());
                if (optJSONObject != null) {
                    optJSONObject.put(l.Environment.h(), h2);
                    return;
                }
                return;
            }
            jSONObject.put(l.Environment.h(), h2);
        } catch (Exception unused) {
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f17107f.add(bVar);
        }
    }

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this instanceof x) {
            ((x) this).O();
        }
        D();
        if (!p() || i.e()) {
            return;
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        H();
        if (B()) {
            G();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(Context context) {
        int checkCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.INTERNET");
        if (!(checkCallingOrSelfPermission == 0)) {
            q.a("Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        }
        return checkCallingOrSelfPermission == 0;
    }

    public a g() {
        return a.V1;
    }

    public JSONObject i() {
        return this.a;
    }

    public JSONObject j() {
        return this.a;
    }

    public JSONObject k(ConcurrentHashMap<String, String> concurrentHashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a != null) {
                JSONObject jSONObject2 = new JSONObject(this.a.toString());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            if (concurrentHashMap.size() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                for (String str : concurrentHashMap.keySet()) {
                    jSONObject3.put(str, concurrentHashMap.get(str));
                    concurrentHashMap.remove(str);
                }
                jSONObject.put(l.Branch_Instrumentation.h(), jSONObject3);
                return jSONObject;
            }
            return jSONObject;
        } catch (ConcurrentModificationException unused) {
            return this.a;
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }

    public long l() {
        if (this.f17105d > 0) {
            return System.currentTimeMillis() - this.f17105d;
        }
        return 0L;
    }

    public final String m() {
        return this.f17103b;
    }

    public String n() {
        return this.f17104c.i() + this.f17103b;
    }

    public abstract void o(int i2, String str);

    public boolean p() {
        return true;
    }

    public abstract boolean q();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return true;
    }

    public boolean s() {
        return this.f17107f.size() > 0;
    }

    public void t() {
    }

    public void u() {
        this.f17105d = System.currentTimeMillis();
    }

    public abstract void v(e0 e0Var, io.branch.referral.b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        return false;
    }

    public void x(b bVar) {
        this.f17107f.remove(bVar);
    }

    public void y() {
        q.a("Requested operation cannot be completed since tracking is disabled [" + this.f17103b + "]");
        o(-117, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject;
        if (g() == a.V2) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                this.a.put(l.UserData.h(), jSONObject2);
                o.e().n(this.f17106e, this.f17104c, jSONObject2);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        o.e().m(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(String str, JSONObject jSONObject, Context context) {
        this.f17105d = 0L;
        this.f17108g = false;
        this.f17109h = false;
        this.f17106e = context;
        this.f17103b = str;
        this.a = jSONObject;
        this.f17104c = q.B(context);
        this.f17107f = new HashSet();
    }
}
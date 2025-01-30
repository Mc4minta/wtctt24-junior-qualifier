package io.branch.referral;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import io.branch.referral.InstallListener;
import io.branch.referral.g;
import io.branch.referral.g0;
import io.branch.referral.j;
import io.branch.referral.k;
import io.branch.referral.network.BranchRemoteInterface;
import io.branch.referral.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Branch.java */
/* loaded from: classes2.dex */
public class b implements j.d, g0.a, InstallListener.b {
    private static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f16912b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f16913c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f16914d = false;

    /* renamed from: e  reason: collision with root package name */
    static boolean f16915e = true;

    /* renamed from: f  reason: collision with root package name */
    private static long f16916f = 1500;

    /* renamed from: g  reason: collision with root package name */
    private static b f16917g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f16918h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f16919i;

    /* renamed from: j  reason: collision with root package name */
    private static i f16920j = i.USE_DEFAULT;

    /* renamed from: k  reason: collision with root package name */
    private static String f16921k = "app.link";

    /* renamed from: l  reason: collision with root package name */
    private static int f16922l = 2500;
    private static final String[] m = {"extra_launch_uri", "branch_intent"};
    private static boolean n = true;
    private WeakReference<g> A;
    private k B;
    private boolean C;
    private m D;
    private f0 E;
    WeakReference<Activity> F;
    boolean G;
    private final ConcurrentHashMap<String, String> H;
    private boolean I;
    private CountDownLatch J;
    private CountDownLatch K;
    private boolean L;
    boolean M;
    private boolean N;
    private final h0 O;
    private JSONObject o;
    private boolean p = false;
    private BranchRemoteInterface q;
    private q r;
    private final o s;
    private Context t;
    final Object u;
    private Semaphore v;
    private final z w;
    private int x;
    private boolean y;
    private Map<io.branch.referral.e, String> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public class a implements k.b {
        a() {
        }

        @Override // io.branch.referral.k.b
        public void a(String str) {
            b.this.r.r0(Boolean.TRUE);
            if (str != null) {
                String queryParameter = Uri.parse(str).getQueryParameter(io.branch.referral.l.LinkClickID.h());
                if (!TextUtils.isEmpty(queryParameter)) {
                    b.this.r.v0(queryParameter);
                }
            }
            b.this.w.t(r.b.FB_APP_LINK_WAIT_LOCK);
            b.this.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Branch.java */
    /* renamed from: io.branch.referral.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0407b implements g.e {
        C0407b() {
        }

        @Override // io.branch.referral.g.e
        public void a() {
            b.this.w.t(r.b.STRONG_MATCH_PENDING_WAIT_LOCK);
            b.this.u0();
        }
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(String str, io.branch.referral.d dVar);
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a(JSONArray jSONArray, io.branch.referral.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public class f extends io.branch.referral.c<Void, Void, e0> {
        r a;

        public f(r rVar) {
            this.a = rVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public e0 doInBackground(Void... voidArr) {
            b bVar = b.this;
            bVar.F(this.a.m() + "-" + io.branch.referral.l.Queue_Wait_Time.h(), String.valueOf(this.a.l()));
            this.a.c();
            if (!b.this.q0() || this.a.w()) {
                return this.a.q() ? b.this.q.f(this.a.n(), this.a.i(), this.a.m(), b.this.r.o()) : b.this.q.g(this.a.k(b.this.H), this.a.n(), this.a.m(), b.this.r.o());
            }
            return new e0(this.a.m(), -117);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(e0 e0Var) {
            boolean z;
            super.onPostExecute(e0Var);
            if (e0Var != null) {
                try {
                    int d2 = e0Var.d();
                    b.this.y = true;
                    if (e0Var.d() == -117) {
                        this.a.y();
                        b.this.w.p(this.a);
                    } else if (d2 == 200) {
                        b.this.y = true;
                        r rVar = this.a;
                        if (rVar instanceof t) {
                            if (e0Var.c() != null) {
                                b.this.z.put(((t) this.a).J(), e0Var.c().getString("url"));
                            }
                        } else if (rVar instanceof y) {
                            b.this.z.clear();
                            b.this.w.d();
                        }
                        b.this.w.g();
                        r rVar2 = this.a;
                        if (!(rVar2 instanceof x) && !(rVar2 instanceof w)) {
                            rVar2.v(e0Var, b.f16917g);
                        }
                        JSONObject c2 = e0Var.c();
                        if (c2 != null) {
                            if (b.this.q0()) {
                                z = false;
                            } else {
                                io.branch.referral.l lVar = io.branch.referral.l.SessionID;
                                if (c2.has(lVar.h())) {
                                    b.this.r.y0(c2.getString(lVar.h()));
                                    z = true;
                                } else {
                                    z = false;
                                }
                                io.branch.referral.l lVar2 = io.branch.referral.l.IdentityID;
                                if (c2.has(lVar2.h())) {
                                    if (!b.this.r.y().equals(c2.getString(lVar2.h()))) {
                                        b.this.z.clear();
                                        b.this.r.n0(c2.getString(lVar2.h()));
                                        z = true;
                                    }
                                }
                                io.branch.referral.l lVar3 = io.branch.referral.l.DeviceFingerprintID;
                                if (c2.has(lVar3.h())) {
                                    b.this.r.h0(c2.getString(lVar3.h()));
                                    z = true;
                                }
                            }
                            if (z) {
                                b.this.E0();
                            }
                            r rVar3 = this.a;
                            if (!(rVar3 instanceof x)) {
                                rVar3.v(e0Var, b.f16917g);
                            } else {
                                b.this.D = m.INITIALISED;
                                this.a.v(e0Var, b.f16917g);
                                if (!b.this.G && !((x) this.a).J(e0Var)) {
                                    b.this.H();
                                }
                                if (((x) this.a).K()) {
                                    b.this.G = true;
                                }
                                if (b.this.K != null) {
                                    b.this.K.countDown();
                                }
                                if (b.this.J != null) {
                                    b.this.J.countDown();
                                }
                            }
                        }
                    } else {
                        if (this.a instanceof x) {
                            b.this.D = m.UNINITIALISED;
                        }
                        if (d2 != 400 && d2 != 409) {
                            b.this.y = false;
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < b.this.w.j(); i2++) {
                                arrayList.add(b.this.w.n(i2));
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                r rVar4 = (r) it.next();
                                if (rVar4 == null || !rVar4.A()) {
                                    b.this.w.p(rVar4);
                                }
                            }
                            b.this.x = 0;
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                r rVar5 = (r) it2.next();
                                if (rVar5 != null) {
                                    rVar5.o(d2, e0Var.b());
                                    if (rVar5.A()) {
                                        rVar5.b();
                                    }
                                }
                            }
                        }
                        b.this.w.p(this.a);
                        r rVar6 = this.a;
                        if (rVar6 instanceof t) {
                            ((t) rVar6).L();
                        } else {
                            q.b("Branch API Error: Conflicting resource error code from API");
                            b.this.Y(0, d2);
                        }
                    }
                    b.this.x = 0;
                    if (!b.this.y || b.this.D == m.UNINITIALISED) {
                        return;
                    }
                    b.this.u0();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.a.t();
            this.a.d();
        }
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface g {
        void a(JSONObject jSONObject, io.branch.referral.d dVar);
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface h {
        void a(boolean z, io.branch.referral.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public enum i {
        USE_DEFAULT,
        REFERRABLE,
        NON_REFERRABLE
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface j {
        boolean a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public enum k {
        PENDING,
        READY
    }

    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public interface l {
        void a(boolean z, io.branch.referral.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public enum m {
        INITIALISED,
        INITIALISING,
        UNINITIALISED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    /* loaded from: classes2.dex */
    public class n extends AsyncTask<r, Void, e0> {
        private n() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public e0 doInBackground(r... rVarArr) {
            BranchRemoteInterface branchRemoteInterface = b.this.q;
            JSONObject j2 = rVarArr[0].j();
            return branchRemoteInterface.g(j2, b.this.r.i() + "v1/url", io.branch.referral.n.GetURL.h(), b.this.r.o());
        }

        /* synthetic */ n(b bVar, a aVar) {
            this();
        }
    }

    private b(Context context) {
        k kVar = k.PENDING;
        this.B = kVar;
        this.C = false;
        this.D = m.UNINITIALISED;
        this.G = false;
        this.I = false;
        this.J = null;
        this.K = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.r = q.B(context);
        h0 h0Var = new h0(context);
        this.O = h0Var;
        this.q = BranchRemoteInterface.e(context);
        o i2 = o.i(context);
        this.s = i2;
        this.w = z.i(context);
        this.v = new Semaphore(1);
        this.u = new Object();
        this.x = 0;
        this.y = true;
        this.z = new HashMap();
        this.H = new ConcurrentHashMap<>();
        if (!h0Var.a()) {
            this.I = i2.h().t(context, this);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            this.C = true;
            this.B = kVar;
            return;
        }
        this.C = false;
        this.B = k.READY;
    }

    private void A0() {
        C0(null);
    }

    @TargetApi(14)
    private void B0(Application application) {
        try {
            c cVar = new c(this, null);
            application.unregisterActivityLifecycleCallbacks(cVar);
            application.registerActivityLifecycleCallbacks(cVar);
            f16919i = true;
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            f16919i = false;
            f16918h = false;
            q.a(new io.branch.referral.d("", -108).a());
        }
    }

    private void C0(String str) {
        this.r.j0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Activity activity) {
        Uri data = activity.getIntent() != null ? activity.getIntent().getData() : null;
        WeakReference<g> weakReference = this.A;
        g gVar = weakReference != null ? weakReference.get() : null;
        this.G = false;
        g0(gVar, data, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        JSONObject j2;
        for (int i2 = 0; i2 < this.w.j(); i2++) {
            try {
                r n2 = this.w.n(i2);
                if (n2 != null && (j2 = n2.j()) != null) {
                    io.branch.referral.l lVar = io.branch.referral.l.SessionID;
                    if (j2.has(lVar.h())) {
                        n2.j().put(lVar.h(), this.r.O());
                    }
                    io.branch.referral.l lVar2 = io.branch.referral.l.IdentityID;
                    if (j2.has(lVar2.h())) {
                        n2.j().put(lVar2.h(), this.r.y());
                    }
                    io.branch.referral.l lVar3 = io.branch.referral.l.DeviceFingerprintID;
                    if (j2.has(lVar3.h())) {
                        n2.j().put(lVar3.h(), this.r.s());
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    private JSONObject G(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = this.o;
                if (jSONObject2 != null) {
                    if (jSONObject2.length() > 0) {
                        q.a("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    Iterator<String> keys = this.o.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, this.o.get(next));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        WeakReference<Activity> weakReference;
        Bundle bundle;
        JSONObject W = W();
        String str = null;
        try {
            io.branch.referral.l lVar = io.branch.referral.l.Clicked_Branch_Link;
            if (W.has(lVar.h()) && W.getBoolean(lVar.h()) && W.length() > 0) {
                Bundle bundle2 = this.t.getPackageManager().getApplicationInfo(this.t.getPackageName(), 128).metaData;
                if (bundle2 == null || !bundle2.getBoolean("io.branch.sdk.auto_link_disable", false)) {
                    ActivityInfo[] activityInfoArr = this.t.getPackageManager().getPackageInfo(this.t.getPackageName(), 129).activities;
                    int i2 = 1501;
                    if (activityInfoArr != null) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (activityInfo != null && (bundle = activityInfo.metaData) != null && ((bundle.getString("io.branch.sdk.auto_link_keys") != null || activityInfo.metaData.getString("io.branch.sdk.auto_link_path") != null) && (I(W, activityInfo) || J(W, activityInfo)))) {
                                str = activityInfo.name;
                                i2 = activityInfo.metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
                                break;
                            }
                        }
                    }
                    if (str == null || (weakReference = this.F) == null) {
                        return;
                    }
                    Activity activity = weakReference.get();
                    if (activity != null) {
                        Intent intent = new Intent(activity, Class.forName(str));
                        intent.putExtra("io.branch.sdk.auto_linked", "true");
                        intent.putExtra(io.branch.referral.l.ReferringData.h(), W.toString());
                        Iterator<String> keys = W.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            intent.putExtra(next, W.getString(next));
                        }
                        activity.startActivityForResult(intent, i2);
                        return;
                    }
                    q.a("No activity reference to launch deep linked activity");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            q.a("Warning: Please make sure Activity names set for auto deep link are correct!");
        } catch (ClassNotFoundException unused2) {
            q.a("Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity " + ((String) null));
        } catch (Exception unused3) {
        }
    }

    private boolean I(JSONObject jSONObject, ActivityInfo activityInfo) {
        if (activityInfo.metaData.getString("io.branch.sdk.auto_link_keys") != null) {
            for (String str : activityInfo.metaData.getString("io.branch.sdk.auto_link_keys").split(",")) {
                if (jSONObject.has(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean J(org.json.JSONObject r5, android.content.pm.ActivityInfo r6) {
        /*
            r4 = this;
            r0 = 0
            io.branch.referral.l r1 = io.branch.referral.l.AndroidDeepLinkPath     // Catch: org.json.JSONException -> L2c
            java.lang.String r2 = r1.h()     // Catch: org.json.JSONException -> L2c
            boolean r2 = r5.has(r2)     // Catch: org.json.JSONException -> L2c
            if (r2 == 0) goto L17
            java.lang.String r1 = r1.h()     // Catch: org.json.JSONException -> L2c
            java.lang.String r5 = r5.getString(r1)     // Catch: org.json.JSONException -> L2c
        L15:
            r0 = r5
            goto L2c
        L17:
            io.branch.referral.l r1 = io.branch.referral.l.DeepLinkPath     // Catch: org.json.JSONException -> L2c
            java.lang.String r2 = r1.h()     // Catch: org.json.JSONException -> L2c
            boolean r2 = r5.has(r2)     // Catch: org.json.JSONException -> L2c
            if (r2 == 0) goto L2c
            java.lang.String r1 = r1.h()     // Catch: org.json.JSONException -> L2c
            java.lang.String r5 = r5.getString(r1)     // Catch: org.json.JSONException -> L2c
            goto L15
        L2c:
            android.os.Bundle r5 = r6.metaData
            java.lang.String r1 = "io.branch.sdk.auto_link_path"
            java.lang.String r5 = r5.getString(r1)
            r2 = 0
            if (r5 == 0) goto L5a
            if (r0 == 0) goto L5a
            android.os.Bundle r5 = r6.metaData
            java.lang.String r5 = r5.getString(r1)
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            r1 = r2
        L47:
            if (r1 >= r6) goto L5a
            r3 = r5[r1]
            java.lang.String r3 = r3.trim()
            boolean r3 = r4.s0(r3, r0)
            if (r3 == 0) goto L57
            r5 = 1
            return r5
        L57:
            int r1 = r1 + 1
            goto L47
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.b.J(org.json.JSONObject, android.content.pm.ActivityInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(Intent intent) {
        if (intent != null) {
            try {
                io.branch.referral.l lVar = io.branch.referral.l.ForceNewBranchSession;
                if (intent.getBooleanExtra(lVar.h(), false)) {
                    try {
                        intent.putExtra(lVar.h(), false);
                    } catch (Throwable unused) {
                    }
                } else if (intent.getStringExtra(io.branch.referral.l.AndroidPushNotificationKey.h()) == null) {
                    return false;
                } else {
                    if (intent.getBooleanExtra(io.branch.referral.l.BranchLinkUsed.h(), false)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    private JSONObject M(String str) {
        if (str.equals("bnc_no_value")) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            try {
                return new JSONObject(new String(io.branch.referral.a.a(str.getBytes(), 2)));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new JSONObject();
            }
        }
    }

    private void N() {
        m mVar = this.D;
        m mVar2 = m.UNINITIALISED;
        if (mVar != mVar2) {
            if (!this.y) {
                r m2 = this.w.m();
                if ((m2 != null && (m2 instanceof c0)) || (m2 instanceof d0)) {
                    this.w.g();
                }
            } else if (!this.w.e()) {
                a0(new b0(this.t));
            }
            this.D = mVar2;
        }
    }

    private void O(r rVar) {
        a0(rVar);
    }

    private String Q(t tVar) {
        e0 e0Var;
        if (this.O.a()) {
            return tVar.K();
        }
        if (this.D == m.INITIALISED) {
            try {
                e0Var = new n(this, null).execute(tVar).get(this.r.R() + 2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                e0Var = null;
            }
            String K = tVar.O() ? tVar.K() : null;
            if (e0Var != null && e0Var.d() == 200) {
                try {
                    K = e0Var.c().getString("url");
                    if (tVar.J() != null) {
                        this.z.put(tVar.J(), K);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return K;
        }
        q.a("Warning: User session has not been initialized");
        return null;
    }

    @TargetApi(14)
    public static b R(Context context) {
        f16918h = true;
        f16920j = i.USE_DEFAULT;
        S(context, true ^ io.branch.referral.i.b(context), null);
        return f16917g;
    }

    private static b S(Context context, boolean z, String str) {
        boolean e0;
        if (f16917g == null) {
            f16917g = e0(context);
            boolean b2 = io.branch.referral.i.b(context);
            if (z) {
                b2 = false;
            }
            io.branch.referral.i.g(b2);
            if (TextUtils.isEmpty(str)) {
                str = io.branch.referral.i.f(context);
            }
            if (TextUtils.isEmpty(str)) {
                String str2 = null;
                try {
                    Resources resources = context.getResources();
                    str2 = resources.getString(resources.getIdentifier("io.branch.apiKey", "string", context.getPackageName()));
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    e0 = f16917g.r.e0(str2);
                } else {
                    q.a("Warning: Please enter your branch_key in your project's Manifest file!");
                    e0 = f16917g.r.e0("bnc_no_value");
                }
            } else {
                e0 = f16917g.r.e0(str);
            }
            if (e0) {
                f16917g.z.clear();
                f16917g.w.d();
            }
            f16917g.t = context.getApplicationContext();
            if (context instanceof Application) {
                f16918h = true;
                f16917g.B0((Application) context);
            }
        }
        return f16917g;
    }

    private r U(g gVar) {
        if (d0()) {
            return new d0(this.t, gVar);
        }
        return new c0(this.t, gVar, InstallListener.e());
    }

    @TargetApi(14)
    public static b V() {
        if (f16917g == null) {
            q.a("Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (f16918h && !f16919i) {
            q.a("Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return f16917g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i2, int i3) {
        r n2;
        if (i2 >= this.w.j()) {
            z zVar = this.w;
            n2 = zVar.n(zVar.j() - 1);
        } else {
            n2 = this.w.n(i2);
        }
        Z(n2, i3);
    }

    private void Z(r rVar, int i2) {
        if (rVar == null) {
            return;
        }
        rVar.o(i2, "");
    }

    private boolean b0() {
        return !this.r.s().equals("bnc_no_value");
    }

    private boolean c0() {
        return !this.r.O().equals("bnc_no_value");
    }

    private boolean d0() {
        return !this.r.y().equals("bnc_no_value");
    }

    private static b e0(Context context) {
        return new b(context.getApplicationContext());
    }

    private void h0(g gVar, Activity activity, boolean z) {
        if (activity != null) {
            this.F = new WeakReference<>(activity);
        }
        if (gVar != null) {
            this.A = new WeakReference<>(gVar);
        }
        if (d0() && c0() && this.D == m.INITIALISED) {
            y0(gVar);
            this.M = false;
            return;
        }
        if (this.M && y0(gVar)) {
            F(io.branch.referral.l.InstantDeepLinkSession.h(), "true");
            this.M = false;
            H();
        }
        if (z) {
            this.r.t0();
        } else {
            this.r.e();
        }
        m mVar = this.D;
        m mVar2 = m.INITIALISING;
        if (mVar != mVar2) {
            this.D = mVar2;
            i0(gVar);
        } else if (gVar != null) {
            this.w.r(gVar);
        }
    }

    private void i0(g gVar) {
        if (this.r.o() != null && !this.r.o().equalsIgnoreCase("bnc_no_value")) {
            if (this.r.o() != null && this.r.o().startsWith("key_test_")) {
                q.a("Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
            }
            if (X() == null && this.p) {
                if (io.branch.referral.k.a(this.t, new a()).booleanValue()) {
                    w0(gVar, r.b.FB_APP_LINK_WAIT_LOCK);
                    return;
                } else {
                    w0(gVar, null);
                    return;
                }
            }
            w0(gVar, null);
            return;
        }
        this.D = m.UNINITIALISED;
        if (gVar != null) {
            gVar.a(null, new io.branch.referral.d("Trouble initializing Branch.", -114));
        }
        q.a("Warning: Please enter your branch_key in your project's res/values/strings.xml!");
    }

    private void j0(r rVar) {
        if (this.x == 0) {
            this.w.k(rVar, 0);
        } else {
            this.w.k(rVar, 1);
        }
    }

    private boolean k0(Activity activity) {
        return (activity == null || activity.getIntent() == null || (activity.getIntent().getFlags() & PKIFailureInfo.badCertTemplate) == 0) ? false : true;
    }

    public static boolean l0() {
        return a;
    }

    public static boolean m0() {
        return f16913c;
    }

    private boolean n0(Activity activity) {
        return (activity == null || activity.getIntent() == null || !activity.getIntent().getBooleanExtra(io.branch.referral.l.BranchLinkUsed.h(), false)) ? false : true;
    }

    private boolean o0() {
        return c0() && b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p0() {
        return f16912b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Activity activity, boolean z) {
        this.w.t(r.b.INTENT_PENDING_WAIT_LOCK);
        if (z) {
            v0(activity.getIntent().getData(), activity);
            if (!q0() && f16921k != null && this.r.o() != null && !this.r.o().equalsIgnoreCase("bnc_no_value")) {
                if (this.I) {
                    this.L = true;
                    return;
                } else {
                    t0();
                    return;
                }
            }
            u0();
            return;
        }
        u0();
    }

    private boolean s0(String str, String str2) {
        String[] split = str.split("\\?")[0].split("/");
        String[] split2 = str2.split("\\?")[0].split("/");
        if (split.length != split2.length) {
            return false;
        }
        for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
            String str3 = split[i2];
            if (!str3.equals(split2[i2]) && !str3.contains("*")) {
                return false;
            }
        }
        return true;
    }

    private void t0() {
        if (this.O.a()) {
            return;
        }
        WeakReference<Activity> weakReference = this.F;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext != null) {
            this.w.s();
            io.branch.referral.g.j().i(applicationContext, f16921k, this.s, this.r, new C0407b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        try {
            this.v.acquire();
            if (this.x == 0 && this.w.j() > 0) {
                this.x = 1;
                r m2 = this.w.m();
                this.v.release();
                if (m2 != null) {
                    if (!m2.s()) {
                        if (!(m2 instanceof c0) && !d0()) {
                            q.a("Branch Error: User session has not been initialized!");
                            this.x = 0;
                            Y(this.w.j() - 1, -101);
                        } else if (z0(m2) && !o0()) {
                            this.x = 0;
                            Y(this.w.j() - 1, -101);
                        } else {
                            new f(m2).a(new Void[0]);
                        }
                    } else {
                        this.x = 0;
                    }
                } else {
                    this.w.p(null);
                }
            } else {
                this.v.release();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean v0(Uri uri, Activity activity) {
        String[] strArr;
        String uri2;
        String str;
        if (!n && ((this.B == k.READY || this.N) && activity != null && activity.getIntent() != null && this.D != m.INITIALISED && !K(activity.getIntent()))) {
            Intent intent = activity.getIntent();
            if (intent.getData() != null && (this.N || !n0(activity))) {
                io.branch.referral.l lVar = io.branch.referral.l.BranchData;
                if (!TextUtils.isEmpty(intent.getStringExtra(lVar.h()))) {
                    try {
                        JSONObject jSONObject = new JSONObject(intent.getStringExtra(lVar.h()));
                        jSONObject.put(io.branch.referral.l.Clicked_Branch_Link.h(), true);
                        this.r.z0(jSONObject.toString());
                        this.M = true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    intent.removeExtra(io.branch.referral.l.BranchData.h());
                    activity.setIntent(intent);
                } else if (uri.getQueryParameterNames() != null && Boolean.valueOf(uri.getQueryParameter(io.branch.referral.l.Instant.h())).booleanValue()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        for (String str2 : uri.getQueryParameterNames()) {
                            jSONObject2.put(str2, uri.getQueryParameter(str2));
                        }
                        jSONObject2.put(io.branch.referral.l.Clicked_Branch_Link.h(), true);
                        this.r.z0(jSONObject2.toString());
                        this.M = true;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (!this.r.A().equals("bnc_no_value")) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(io.branch.referral.l.Clicked_Branch_Link.h(), false);
                    jSONObject3.put(io.branch.referral.l.IsFirstSession.h(), false);
                    this.r.z0(jSONObject3.toString());
                    this.M = true;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        if (f16914d) {
            this.B = k.READY;
        }
        if (this.B == k.READY) {
            if (uri != null) {
                try {
                    if (!n0(activity)) {
                        String e5 = i0.d(this.t).e(uri.toString());
                        C0(e5);
                        if (e5 != null && e5.equals(uri.toString()) && activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null) {
                            Bundle extras = activity.getIntent().getExtras();
                            Set<String> keySet = extras.keySet();
                            if (keySet.size() > 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (String str3 : m) {
                                    if (keySet.contains(str3)) {
                                        jSONObject4.put(str3, extras.get(str3));
                                    }
                                }
                                if (jSONObject4.length() > 0) {
                                    this.r.i0(jSONObject4.toString());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (activity != null) {
                try {
                    if (activity.getIntent() != null && activity.getIntent().getExtras() != null && !n0(activity)) {
                        Object obj = activity.getIntent().getExtras().get(io.branch.referral.l.AndroidPushNotificationKey.h());
                        if (obj instanceof String) {
                            uri2 = (String) obj;
                        } else {
                            uri2 = obj instanceof Uri ? ((Uri) obj).toString() : null;
                        }
                        if (!TextUtils.isEmpty(uri2)) {
                            this.r.x0(uri2);
                            Intent intent2 = activity.getIntent();
                            intent2.putExtra(io.branch.referral.l.BranchLinkUsed.h(), true);
                            activity.setIntent(intent2);
                            return false;
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (uri != null && uri.isHierarchical() && activity != null && !k0(activity)) {
                try {
                    io.branch.referral.l lVar2 = io.branch.referral.l.LinkClickID;
                    if (uri.getQueryParameter(lVar2.h()) != null) {
                        this.r.v0(uri.getQueryParameter(lVar2.h()));
                        String str4 = "link_click_id=" + uri.getQueryParameter(lVar2.h());
                        String dataString = activity.getIntent() != null ? activity.getIntent().getDataString() : null;
                        if (uri.getQuery().length() == str4.length()) {
                            str = "\\?" + str4;
                        } else if (dataString != null && dataString.length() - str4.length() == dataString.indexOf(str4)) {
                            str = "&" + str4;
                        } else {
                            str = str4 + "&";
                        }
                        if (dataString != null) {
                            activity.getIntent().setData(Uri.parse(dataString.replaceFirst(str, "")));
                            activity.getIntent().putExtra(io.branch.referral.l.BranchLinkUsed.h(), true);
                        } else {
                            q.a("Warning: URI for the launcher activity is null. Please make sure that intent data is not set to null before calling Branch#InitSession ");
                        }
                        return true;
                    }
                    String scheme = uri.getScheme();
                    Intent intent3 = activity.getIntent();
                    if (scheme != null && intent3 != null && ((scheme.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || scheme.equalsIgnoreCase("https")) && uri.getHost() != null && uri.getHost().length() > 0 && !n0(activity))) {
                        if (uri.toString().equalsIgnoreCase(i0.d(this.t).e(uri.toString()))) {
                            this.r.b0(uri.toString());
                        }
                        intent3.putExtra(io.branch.referral.l.BranchLinkUsed.h(), true);
                        activity.setIntent(intent3);
                    }
                } catch (Exception unused3) {
                }
            }
        }
        return false;
    }

    private void w0(g gVar, r.b bVar) {
        r U = U(gVar);
        U.a(bVar);
        if (this.I) {
            U.a(r.b.GAID_FETCH_WAIT_LOCK);
        }
        if (this.B != k.READY && !m0()) {
            U.a(r.b.INTENT_PENDING_WAIT_LOCK);
        }
        if (f16915e && (U instanceof c0) && !InstallListener.f16893e) {
            U.a(r.b.INSTALL_REFERRER_FETCH_WAIT_LOCK);
            InstallListener.d(this.t, f16916f, this);
        }
        x0(U, gVar);
    }

    private void x0(r rVar, g gVar) {
        if (!this.w.f()) {
            j0(rVar);
        } else {
            if (gVar != null) {
                this.w.r(gVar);
            }
            this.w.l(rVar, this.x, gVar);
        }
        u0();
    }

    private boolean y0(g gVar) {
        if (gVar != null) {
            if (f16918h) {
                if (!this.G) {
                    gVar.a(W(), null);
                    this.G = true;
                } else {
                    gVar.a(new JSONObject(), null);
                }
            } else {
                gVar.a(new JSONObject(), null);
            }
        }
        return this.G;
    }

    private boolean z0(r rVar) {
        return ((rVar instanceof x) || (rVar instanceof t)) ? false : true;
    }

    public void F(String str, String str2) {
        this.H.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0() {
        i0.d(this.t).c(this.t);
    }

    void L() {
        N();
        A0();
        this.O.b(this.t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String P(t tVar) {
        if (tVar.f17108g || tVar.M(this.t)) {
            return null;
        }
        if (this.z.containsKey(tVar.J())) {
            String str = this.z.get(tVar.J());
            tVar.Q(str);
            return str;
        } else if (tVar.N()) {
            O(tVar);
            return null;
        } else {
            return Q(tVar);
        }
    }

    public JSONObject T() {
        return G(M(this.r.A()));
    }

    public JSONObject W() {
        return G(M(this.r.P()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String X() {
        String u = this.r.u();
        if (u.equals("bnc_no_value")) {
            return null;
        }
        return u;
    }

    @Override // io.branch.referral.InstallListener.b
    public void a() {
        this.w.t(r.b.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        u0();
    }

    public void a0(r rVar) {
        if (this.O.a() && !rVar.w()) {
            rVar.y();
            return;
        }
        if (this.D != m.INITIALISED && !(rVar instanceof x)) {
            if (rVar instanceof y) {
                rVar.o(-101, "");
                q.a("Branch is not initialized, cannot logout");
                return;
            } else if (rVar instanceof b0) {
                q.a("Branch is not initialized, cannot close session");
                return;
            } else {
                WeakReference<Activity> weakReference = this.F;
                Activity activity = weakReference != null ? weakReference.get() : null;
                if (f16920j == i.USE_DEFAULT) {
                    h0(null, activity, true);
                } else {
                    h0(null, activity, f16920j == i.REFERRABLE);
                }
            }
        }
        this.w.h(rVar);
        rVar.u();
        u0();
    }

    @Override // io.branch.referral.j.d
    public void b(String str, String str2) {
        if (x.L(str)) {
            H();
        }
    }

    @Override // io.branch.referral.g0.a
    public void c() {
        this.I = false;
        this.w.t(r.b.GAID_FETCH_WAIT_LOCK);
        if (this.L) {
            t0();
            this.L = false;
            return;
        }
        u0();
    }

    @Override // io.branch.referral.j.d
    public void d(int i2, String str, String str2) {
        if (x.L(str2)) {
            H();
        }
    }

    @Override // io.branch.referral.j.d
    public void e(String str, String str2) {
        if (x.L(str)) {
            H();
        }
    }

    @Override // io.branch.referral.j.d
    public void f(String str, String str2) {
    }

    public boolean f0(g gVar, Activity activity) {
        if (f16920j == i.USE_DEFAULT) {
            h0(gVar, activity, true);
        } else {
            h0(gVar, activity, f16920j == i.REFERRABLE);
        }
        return true;
    }

    public boolean g0(g gVar, Uri uri, Activity activity) {
        v0(uri, activity);
        return f0(gVar, activity);
    }

    public boolean q0() {
        return this.O.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Branch.java */
    @TargetApi(14)
    /* loaded from: classes2.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        private int a;

        private c() {
            this.a = 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b bVar = b.this;
            bVar.B = bVar.C ? k.PENDING : k.READY;
            b.this.N = true;
            if (io.branch.referral.j.k().m(activity.getApplicationContext())) {
                io.branch.referral.j.k().s(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference<Activity> weakReference = b.this.F;
            if (weakReference != null && weakReference.get() == activity) {
                b.this.F.clear();
            }
            io.branch.referral.j.k().o(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (b.this.E == null) {
                return;
            }
            f0 unused = b.this.E;
            throw null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (b.this.K(activity.getIntent())) {
                b.this.D = m.UNINITIALISED;
                b.this.D0(activity);
            }
            b.this.F = new WeakReference<>(activity);
            if (!b.this.C || b.f16914d) {
                return;
            }
            b.this.B = k.READY;
            b.this.r0(activity, (activity.getIntent() == null || b.this.D == m.INITIALISED) ? false : true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b bVar = b.this;
            bVar.B = bVar.C ? k.PENDING : k.READY;
            if (b.this.D == m.INITIALISED) {
                try {
                    h.b.a.b.w().q(activity, b.this.X());
                } catch (Exception unused) {
                }
            }
            if (this.a < 1) {
                if (b.this.D == m.INITIALISED) {
                    b.this.D = m.UNINITIALISED;
                }
                b.this.D0(activity);
            } else if (b.this.K(activity.getIntent())) {
                b.this.D = m.UNINITIALISED;
                b.this.D0(activity);
            }
            this.a++;
            b.this.N = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            h.b.a.b.w().z(activity);
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 < 1) {
                b bVar = b.this;
                bVar.M = false;
                bVar.L();
            }
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }
}
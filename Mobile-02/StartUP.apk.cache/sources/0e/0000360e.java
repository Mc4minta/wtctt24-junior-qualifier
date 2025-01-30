package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zc;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public class b5 implements z5 {
    private static volatile b5 a;
    private long A;
    private volatile Boolean B;
    private Boolean C;
    private Boolean D;
    private int E;
    final long G;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7503b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7504c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7505d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7506e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f7507f;

    /* renamed from: g  reason: collision with root package name */
    private final ja f7508g;

    /* renamed from: h  reason: collision with root package name */
    private final ka f7509h;

    /* renamed from: i  reason: collision with root package name */
    private final k4 f7510i;

    /* renamed from: j  reason: collision with root package name */
    private final x3 f7511j;

    /* renamed from: k  reason: collision with root package name */
    private final y4 f7512k;

    /* renamed from: l  reason: collision with root package name */
    private final u8 f7513l;
    private final v9 m;
    private final v3 n;
    private final com.google.android.gms.common.util.e o;
    private final n7 p;
    private final i6 q;
    private final a r;
    private final i7 s;
    private t3 t;
    private s7 u;
    private j v;
    private u3 w;
    private t4 x;
    private Boolean z;
    private boolean y = false;
    private AtomicInteger F = new AtomicInteger(0);

    private b5(e6 e6Var) {
        long a2;
        Bundle bundle;
        boolean z = false;
        com.google.android.gms.common.internal.t.k(e6Var);
        ja jaVar = new ja(e6Var.a);
        this.f7508g = jaVar;
        n3.a = jaVar;
        Context context = e6Var.a;
        this.f7503b = context;
        this.f7504c = e6Var.f7556b;
        this.f7505d = e6Var.f7557c;
        this.f7506e = e6Var.f7558d;
        this.f7507f = e6Var.f7562h;
        this.B = e6Var.f7559e;
        zc zcVar = e6Var.f7561g;
        if (zcVar != null && (bundle = zcVar.f7463g) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zcVar.f7463g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.x1.h(context);
        com.google.android.gms.common.util.e c2 = com.google.android.gms.common.util.h.c();
        this.o = c2;
        Long l2 = e6Var.f7563i;
        if (l2 != null) {
            a2 = l2.longValue();
        } else {
            a2 = c2.a();
        }
        this.G = a2;
        this.f7509h = new ka(this);
        k4 k4Var = new k4(this);
        k4Var.r();
        this.f7510i = k4Var;
        x3 x3Var = new x3(this);
        x3Var.r();
        this.f7511j = x3Var;
        v9 v9Var = new v9(this);
        v9Var.r();
        this.m = v9Var;
        v3 v3Var = new v3(this);
        v3Var.r();
        this.n = v3Var;
        this.r = new a(this);
        n7 n7Var = new n7(this);
        n7Var.z();
        this.p = n7Var;
        i6 i6Var = new i6(this);
        i6Var.z();
        this.q = i6Var;
        u8 u8Var = new u8(this);
        u8Var.z();
        this.f7513l = u8Var;
        i7 i7Var = new i7(this);
        i7Var.r();
        this.s = i7Var;
        y4 y4Var = new y4(this);
        y4Var.r();
        this.f7512k = y4Var;
        zc zcVar2 = e6Var.f7561g;
        if (zcVar2 != null && zcVar2.f7458b != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            i6 G = G();
            if (G.h().getApplicationContext() instanceof Application) {
                Application application = (Application) G.h().getApplicationContext();
                if (G.f7639c == null) {
                    G.f7639c = new c7(G, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(G.f7639c);
                    application.registerActivityLifecycleCallbacks(G.f7639c);
                    G.f().P().a("Registered activity lifecycle callback");
                }
            }
        } else {
            f().K().a("Application context is not an Application");
        }
        y4Var.A(new d5(this, e6Var));
    }

    private static void A(w5 w5Var) {
        if (w5Var != null) {
            if (w5Var.u()) {
                return;
            }
            String valueOf = String.valueOf(w5Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    public static b5 a(Context context, zc zcVar, Long l2) {
        Bundle bundle;
        if (zcVar != null && (zcVar.f7461e == null || zcVar.f7462f == null)) {
            zcVar = new zc(zcVar.a, zcVar.f7458b, zcVar.f7459c, zcVar.f7460d, null, null, zcVar.f7463g);
        }
        com.google.android.gms.common.internal.t.k(context);
        com.google.android.gms.common.internal.t.k(context.getApplicationContext());
        if (a == null) {
            synchronized (b5.class) {
                if (a == null) {
                    a = new b5(new e6(context, zcVar, l2));
                }
            }
        } else if (zcVar != null && (bundle = zcVar.f7463g) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            a.o(zcVar.f7463g.getBoolean("dataCollectionDefaultEnabled"));
        }
        return a;
    }

    public static b5 b(Context context, String str, String str2, Bundle bundle) {
        return a(context, new zc(0L, 0L, true, null, null, null, bundle), null);
    }

    private static void k(x5 x5Var) {
        if (x5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(e6 e6Var) {
        String concat;
        z3 z3Var;
        l().d();
        j jVar = new j(this);
        jVar.r();
        this.v = jVar;
        u3 u3Var = new u3(this, e6Var.f7560f);
        u3Var.z();
        this.w = u3Var;
        t3 t3Var = new t3(this);
        t3Var.z();
        this.t = t3Var;
        s7 s7Var = new s7(this);
        s7Var.z();
        this.u = s7Var;
        this.m.s();
        this.f7510i.s();
        this.x = new t4(this);
        this.w.A();
        f().N().b("App measurement initialized, version", Long.valueOf(this.f7509h.E()));
        f().N().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String D = u3Var.D();
        if (TextUtils.isEmpty(this.f7504c)) {
            if (H().C0(D)) {
                z3Var = f().N();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                z3 N = f().N();
                String valueOf = String.valueOf(D);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                z3Var = N;
            }
            z3Var.a(concat);
        }
        f().O().a("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            f().H().c("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.y = true;
    }

    private final i7 x() {
        A(this.s);
        return this.s;
    }

    private static void z(f5 f5Var) {
        if (f5Var != null) {
            if (f5Var.x()) {
                return;
            }
            String valueOf = String.valueOf(f5Var.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Component not created");
    }

    public final k4 B() {
        k(this.f7510i);
        return this.f7510i;
    }

    public final x3 C() {
        x3 x3Var = this.f7511j;
        if (x3Var == null || !x3Var.u()) {
            return null;
        }
        return this.f7511j;
    }

    public final u8 D() {
        z(this.f7513l);
        return this.f7513l;
    }

    public final t4 E() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y4 F() {
        return this.f7512k;
    }

    public final i6 G() {
        z(this.q);
        return this.q;
    }

    public final v9 H() {
        k(this.m);
        return this.m;
    }

    public final v3 I() {
        k(this.n);
        return this.n;
    }

    public final t3 J() {
        z(this.t);
        return this.t;
    }

    public final boolean K() {
        return TextUtils.isEmpty(this.f7504c);
    }

    public final String L() {
        return this.f7504c;
    }

    public final String M() {
        return this.f7505d;
    }

    public final String N() {
        return this.f7506e;
    }

    public final boolean O() {
        return this.f7507f;
    }

    public final n7 P() {
        z(this.p);
        return this.p;
    }

    public final s7 Q() {
        z(this.u);
        return this.u;
    }

    public final j R() {
        A(this.v);
        return this.v;
    }

    public final u3 S() {
        z(this.w);
        return this.w;
    }

    public final a T() {
        a aVar = this.r;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Component not created");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        l().d();
        if (B().f7705f.a() == 0) {
            B().f7705f.b(this.o.a());
        }
        if (Long.valueOf(B().f7710k.a()).longValue() == 0) {
            f().P().b("Persisting first open", Long.valueOf(this.G));
            B().f7710k.b(this.G);
        }
        if (this.f7509h.u(r.T0)) {
            G().f7644h.c();
        }
        if (!v()) {
            if (q()) {
                if (!H().A0("android.permission.INTERNET")) {
                    f().H().a("App is missing INTERNET permission");
                }
                if (!H().A0("android.permission.ACCESS_NETWORK_STATE")) {
                    f().H().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!com.google.android.gms.common.n.c.a(this.f7503b).g() && !this.f7509h.R()) {
                    if (!u4.b(this.f7503b)) {
                        f().H().a("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!v9.X(this.f7503b, false)) {
                        f().H().a("AppMeasurementService not registered/enabled");
                    }
                }
                f().H().a("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(S().E()) || !TextUtils.isEmpty(S().F())) {
                H();
                if (v9.i0(S().E(), B().E(), S().F(), B().F())) {
                    f().N().a("Rechecking which service to use due to a GMP App Id change");
                    B().H();
                    J().I();
                    this.u.c0();
                    this.u.a0();
                    B().f7710k.b(this.G);
                    B().m.b(null);
                }
                B().A(S().E());
                B().C(S().F());
            }
            G().O(B().m.a());
            if (com.google.android.gms.internal.measurement.e9.b() && this.f7509h.u(r.y0) && !H().N0() && !TextUtils.isEmpty(B().B.a())) {
                f().K().a("Remote config removed with active feature rollouts");
                B().B.b(null);
            }
            if (!TextUtils.isEmpty(S().E()) || !TextUtils.isEmpty(S().F())) {
                boolean q = q();
                if (!B().K() && !this.f7509h.I()) {
                    B().B(!q);
                }
                if (q) {
                    G().h0();
                }
                D().f7894d.a();
                Q().S(new AtomicReference<>());
            }
        }
        B().u.a(this.f7509h.u(r.b0));
        B().v.a(this.f7509h.u(r.c0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(f5 f5Var) {
        this.E++;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final x3 f() {
        A(this.f7511j);
        return this.f7511j;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final ja g() {
        return this.f7508g;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final Context h() {
        return this.f7503b;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final com.google.android.gms.common.util.e i() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(w5 w5Var) {
        this.E++;
    }

    @Override // com.google.android.gms.measurement.internal.z5
    public final y4 l() {
        A(this.f7512k);
        return this.f7512k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void n(String str, int i2, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && th == null)) {
            f().K().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            return;
        }
        B().z.a(true);
        if (bArr.length == 0) {
            f().O().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                f().O().a("Deferred Deep Link is empty.");
                return;
            }
            v9 H = H();
            H.b();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = H.h().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                f().K().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.q.S("auto", "_cmp", bundle);
            v9 H2 = H();
            if (TextUtils.isEmpty(optString) || !H2.d0(optString, optDouble)) {
                return;
            }
            H2.h().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e2) {
            f().H().b("Failed to parse the Deferred Deep Link response. exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(boolean z) {
        this.B = Boolean.valueOf(z);
    }

    public final boolean p() {
        return this.B != null && this.B.booleanValue();
    }

    public final boolean q() {
        return r() == 0;
    }

    public final int r() {
        l().d();
        if (this.f7509h.I()) {
            return 1;
        }
        Boolean bool = this.D;
        if (bool == null || !bool.booleanValue()) {
            Boolean I = B().I();
            if (I != null) {
                return I.booleanValue() ? 0 : 3;
            }
            ka kaVar = this.f7509h;
            kaVar.g();
            Boolean z = kaVar.z("firebase_analytics_collection_enabled");
            if (z != null) {
                return z.booleanValue() ? 0 : 4;
            }
            Boolean bool2 = this.C;
            if (bool2 != null) {
                return bool2.booleanValue() ? 0 : 5;
            } else if (com.google.android.gms.common.api.internal.g.d()) {
                return 6;
            } else {
                return (!this.f7509h.u(r.U) || this.B == null || this.B.booleanValue()) ? 0 : 7;
            }
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u() {
        this.F.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean v() {
        if (this.y) {
            l().d();
            Boolean bool = this.z;
            if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.o.b() - this.A) > 1000)) {
                this.A = this.o.b();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(H().A0("android.permission.INTERNET") && H().A0("android.permission.ACCESS_NETWORK_STATE") && (com.google.android.gms.common.n.c.a(this.f7503b).g() || this.f7509h.R() || (u4.b(this.f7503b) && v9.X(this.f7503b, false))));
                this.z = valueOf;
                if (valueOf.booleanValue()) {
                    if (!H().h0(S().E(), S().F(), S().G()) && TextUtils.isEmpty(S().F())) {
                        z = false;
                    }
                    this.z = Boolean.valueOf(z);
                }
            }
            return this.z.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final void w() {
        l().d();
        A(x());
        String D = S().D();
        Pair<String, Boolean> v = B().v(D);
        if (this.f7509h.K().booleanValue() && !((Boolean) v.second).booleanValue() && !TextUtils.isEmpty((CharSequence) v.first)) {
            if (!x().y()) {
                f().K().a("Network is not available for Deferred Deep Link request. Skipping");
                return;
            }
            URL J = H().J(S().o().E(), D, (String) v.first, B().A.a() - 1);
            i7 x = x();
            h7 h7Var = new h7(this) { // from class: com.google.android.gms.measurement.internal.e5
                private final b5 a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.android.gms.measurement.internal.h7
                public final void a(String str, int i2, Throwable th, byte[] bArr, Map map) {
                    this.a.n(str, i2, th, bArr, map);
                }
            };
            x.d();
            x.q();
            com.google.android.gms.common.internal.t.k(J);
            com.google.android.gms.common.internal.t.k(h7Var);
            x.l().D(new k7(x, D, J, null, null, h7Var));
            return;
        }
        f().O().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
    }

    public final ka y() {
        return this.f7509h;
    }
}
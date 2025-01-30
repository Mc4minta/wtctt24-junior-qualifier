package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.coinbase.ApiConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i6 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    protected c7 f7639c;

    /* renamed from: d  reason: collision with root package name */
    private c6 f7640d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<f6> f7641e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7642f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<String> f7643g;

    /* renamed from: h  reason: collision with root package name */
    final ba f7644h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f7645i;

    /* JADX INFO: Access modifiers changed from: protected */
    public i6(b5 b5Var) {
        super(b5Var);
        this.f7641e = new CopyOnWriteArraySet();
        this.f7645i = true;
        this.f7643g = new AtomicReference<>();
        this.f7644h = new ba(b5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(Bundle bundle) {
        d();
        y();
        com.google.android.gms.common.internal.t.k(bundle);
        com.google.android.gms.common.internal.t.g(bundle.getString(ApiConstants.NAME));
        if (!this.a.q()) {
            f().P().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            s().Q(new ia(bundle.getString("app_id"), bundle.getString("origin"), new q9(bundle.getString(ApiConstants.NAME), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean(AppStateModule.APP_STATE_ACTIVE), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), m().F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(boolean z) {
        d();
        b();
        y();
        f().O().b("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        n().z(z);
        l0();
    }

    private final void R(String str, String str2, long j2, Object obj) {
        l().A(new o6(this, str, str2, obj, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        d();
        String a = n().t.a();
        if (a != null) {
            if ("unset".equals(a)) {
                V("app", "_npa", null, i().a());
            } else {
                V("app", "_npa", Long.valueOf("true".equals(a) ? 1L : 0L), i().a());
            }
        }
        if (this.a.q() && this.f7645i) {
            f().O().a("Recording app launch after enabling measurement for the first time (FE)");
            h0();
            if (com.google.android.gms.internal.measurement.x9.b() && o().u(r.z0)) {
                v().f7894d.a();
            }
            if (com.google.android.gms.internal.measurement.m9.b() && o().u(r.E0)) {
                if (!(this.a.E().a.B().f7711l.a() > 0)) {
                    t4 E = this.a.E();
                    E.a.s();
                    E.b(E.a.h().getPackageName());
                }
            }
            if (o().u(r.T0)) {
                l().A(new a7(this));
                return;
            }
            return;
        }
        f().O().a("Updating Scion state (FE)");
        s().X();
    }

    private final ArrayList<Bundle> m0(String str, String str2, String str3) {
        if (l().I()) {
            f().H().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (ja.a()) {
            f().H().a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.a.l().w(atomicReference, 5000L, "get conditional user properties", new v6(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list == null) {
                f().H().b("Timed out waiting for get conditional user properties", str);
                return new ArrayList<>();
            }
            return v9.q0(list);
        }
    }

    private final Map<String, Object> n0(String str, String str2, String str3, boolean z) {
        if (l().I()) {
            f().H().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (ja.a()) {
            f().H().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.a.l().w(atomicReference, 5000L, "get user properties", new u6(this, atomicReference, str, str2, str3, z));
            List<q9> list = (List) atomicReference.get();
            if (list == null) {
                f().H().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            c.e.a aVar = new c.e.a(list.size());
            for (q9 q9Var : list) {
                aVar.put(q9Var.f7823b, q9Var.i1());
            }
            return aVar;
        }
    }

    private final void q0(Bundle bundle, long j2) {
        com.google.android.gms.common.internal.t.k(bundle);
        y5.a(bundle, "app_id", String.class, null);
        y5.a(bundle, "origin", String.class, null);
        y5.a(bundle, ApiConstants.NAME, String.class, null);
        y5.a(bundle, "value", Object.class, null);
        y5.a(bundle, "trigger_event_name", String.class, null);
        y5.a(bundle, "trigger_timeout", Long.class, 0L);
        y5.a(bundle, "timed_out_event_name", String.class, null);
        y5.a(bundle, "timed_out_event_params", Bundle.class, null);
        y5.a(bundle, "triggered_event_name", String.class, null);
        y5.a(bundle, "triggered_event_params", Bundle.class, null);
        y5.a(bundle, "time_to_live", Long.class, 0L);
        y5.a(bundle, "expired_event_name", String.class, null);
        y5.a(bundle, "expired_event_params", Bundle.class, null);
        com.google.android.gms.common.internal.t.g(bundle.getString(ApiConstants.NAME));
        com.google.android.gms.common.internal.t.g(bundle.getString("origin"));
        com.google.android.gms.common.internal.t.k(bundle.get("value"));
        bundle.putLong("creation_timestamp", j2);
        String string = bundle.getString(ApiConstants.NAME);
        Object obj = bundle.get("value");
        if (m().w0(string) != 0) {
            f().H().b("Invalid conditional user property name", j().B(string));
        } else if (m().o0(string, obj) != 0) {
            f().H().c("Invalid conditional user property value", j().B(string), obj);
        } else {
            Object x0 = m().x0(string, obj);
            if (x0 == null) {
                f().H().c("Unable to normalize conditional user property value", j().B(string), obj);
                return;
            }
            y5.b(bundle, x0);
            long j3 = bundle.getLong("trigger_timeout");
            if (!TextUtils.isEmpty(bundle.getString("trigger_event_name")) && (j3 > 15552000000L || j3 < 1)) {
                f().H().c("Invalid conditional user property timeout", j().B(string), Long.valueOf(j3));
                return;
            }
            long j4 = bundle.getLong("time_to_live");
            if (j4 <= 15552000000L && j4 >= 1) {
                l().A(new q6(this, bundle));
            } else {
                f().H().c("Invalid conditional user property time to live", j().B(string), Long.valueOf(j4));
            }
        }
    }

    private final void t0(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        l().A(new l6(this, str, str2, j2, v9.p0(bundle), z, z2, z3, str3));
    }

    private final void v0(String str, String str2, String str3, Bundle bundle) {
        long a = i().a();
        com.google.android.gms.common.internal.t.g(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(ApiConstants.NAME, str2);
        bundle2.putLong("creation_timestamp", a);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        l().A(new t6(this, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(Bundle bundle) {
        d();
        y();
        com.google.android.gms.common.internal.t.k(bundle);
        com.google.android.gms.common.internal.t.g(bundle.getString(ApiConstants.NAME));
        com.google.android.gms.common.internal.t.g(bundle.getString("origin"));
        com.google.android.gms.common.internal.t.k(bundle.get("value"));
        if (!this.a.q()) {
            f().P().a("Conditional property not set since app measurement is disabled");
            return;
        }
        q9 q9Var = new q9(bundle.getString(ApiConstants.NAME), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin"));
        try {
            p F = m().F(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, false);
            s().Q(new ia(bundle.getString("app_id"), bundle.getString("origin"), q9Var, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), m().F(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, false), bundle.getLong("trigger_timeout"), F, bundle.getLong("time_to_live"), m().F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void A0(long j2) {
        O(null);
        l().A(new p6(this, j2));
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return false;
    }

    public final ArrayList<Bundle> C(String str, String str2) {
        b();
        return m0(null, str, str2);
    }

    public final ArrayList<Bundle> D(String str, String str2, String str3) {
        com.google.android.gms.common.internal.t.g(str);
        a();
        return m0(str, str2, str3);
    }

    public final Map<String, Object> E(String str, String str2, String str3, boolean z) {
        com.google.android.gms.common.internal.t.g(str);
        a();
        return n0(str, str2, str3, z);
    }

    public final Map<String, Object> F(String str, String str2, boolean z) {
        b();
        return n0(null, str, str2, z);
    }

    public final void G(long j2) {
        b();
        l().A(new d7(this, j2));
    }

    public final void H(Bundle bundle) {
        I(bundle, i().a());
    }

    public final void I(Bundle bundle, long j2) {
        com.google.android.gms.common.internal.t.k(bundle);
        b();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            f().K().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        q0(bundle2, j2);
    }

    public final void J(c6 c6Var) {
        c6 c6Var2;
        d();
        b();
        y();
        if (c6Var != null && c6Var != (c6Var2 = this.f7640d)) {
            com.google.android.gms.common.internal.t.o(c6Var2 == null, "EventInterceptor already set.");
        }
        this.f7640d = c6Var;
    }

    public final void K(f6 f6Var) {
        b();
        y();
        com.google.android.gms.common.internal.t.k(f6Var);
        if (this.f7641e.add(f6Var)) {
            return;
        }
        f().K().a("OnEventListener already registered");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(String str) {
        this.f7643g.set(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(String str, String str2, long j2, Bundle bundle) {
        b();
        d();
        Q(str, str2, j2, bundle, true, this.f7640d == null || v9.B0(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        long j3;
        boolean z4;
        String str4;
        i6 i6Var;
        String str5;
        String str6;
        o7 o7Var;
        Bundle bundle2;
        long j4;
        int i2;
        boolean z5;
        Class<?> cls;
        List<String> J;
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(bundle);
        d();
        y();
        if (!this.a.q()) {
            f().O().a("Event not sent since app measurement is disabled");
        } else if (o().u(r.e0) && (J = r().J()) != null && !J.contains(str2)) {
            f().O().c("Dropping non-safelisted event. event name, origin", str2, str);
        } else {
            if (!this.f7642f) {
                this.f7642f = true;
                try {
                    if (!this.a.O()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, h().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, h());
                    } catch (Exception e2) {
                        f().K().b("Failed to invoke Tag Manager's initialize() method", e2);
                    }
                } catch (ClassNotFoundException unused) {
                    f().N().a("Tag Manager is not found and thus will not be used");
                }
            }
            if (o().u(r.l0) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
                V("auto", "_lgclid", bundle.getString("gclid"), i().a());
            }
            if (com.google.android.gms.internal.measurement.la.b() && o().u(r.R0)) {
                g();
                if (z && v9.E0(str2)) {
                    v9 m = m();
                    Bundle a = n().E.a();
                    if (a != null) {
                        for (String str7 : a.keySet()) {
                            if (!bundle.containsKey(str7)) {
                                m.m().N(bundle, str7, a.get(str7));
                            }
                        }
                    }
                }
            }
            if (z3) {
                g();
                if (!"_iap".equals(str2)) {
                    v9 H = this.a.H();
                    int i3 = 2;
                    if (H.f0("event", str2)) {
                        if (!H.k0("event", b6.a, str2)) {
                            i3 = 13;
                        } else if (H.e0("event", 40, str2)) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        f().J().b("Invalid public event name. Event will not be logged (FE)", j().x(str2));
                        this.a.H();
                        this.a.H().K(i3, "_ev", v9.I(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                }
            }
            g();
            o7 L = t().L();
            if (L != null && !bundle.containsKey("_sc")) {
                L.f7789d = true;
            }
            n7.I(L, bundle, z && z3);
            boolean equals = "am".equals(str);
            boolean B0 = v9.B0(str2);
            if (z && this.f7640d != null && !B0 && !equals) {
                f().O().c("Passing event to registered event handler (FE)", j().x(str2), j().v(bundle));
                this.f7640d.a(str, str2, bundle, j2);
            } else if (this.a.v()) {
                int n0 = m().n0(str2);
                if (n0 != 0) {
                    f().J().b("Invalid event name. Event will not be logged (FE)", j().x(str2));
                    m();
                    this.a.H().V(str3, n0, "_ev", v9.I(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
                List<String> c2 = com.google.android.gms.common.util.f.c("_o", "_sn", "_sc", "_si");
                Bundle D = m().D(str3, str2, bundle, c2, z3, true);
                o7 o7Var2 = (D != null && D.containsKey("_sc") && D.containsKey("_si")) ? new o7(D.getString("_sn"), D.getString("_sc"), Long.valueOf(D.getLong("_si")).longValue()) : null;
                o7 o7Var3 = o7Var2 == null ? L : o7Var2;
                String str8 = "_ae";
                if (o().u(r.V)) {
                    g();
                    if (t().L() != null && "_ae".equals(str2)) {
                        long e3 = v().f7895e.e();
                        if (e3 > 0) {
                            m().M(D, e3);
                        }
                    }
                }
                if (com.google.android.gms.internal.measurement.e9.b() && o().u(r.y0)) {
                    if (!"auto".equals(str) && "_ssr".equals(str2)) {
                        v9 m2 = m();
                        String string = D.getString("_ffr");
                        String trim = com.google.android.gms.common.util.n.a(string) ? null : string.trim();
                        if (v9.z0(trim, m2.n().B.a())) {
                            m2.f().O().a("Not logging duplicate session_start_with_rollout event");
                            z5 = false;
                        } else {
                            m2.n().B.b(trim);
                            z5 = true;
                        }
                        if (!z5) {
                            return;
                        }
                    } else if ("_ae".equals(str2)) {
                        String a2 = m().n().B.a();
                        if (!TextUtils.isEmpty(a2)) {
                            D.putString("_ffr", a2);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(D);
                long nextLong = m().G0().nextLong();
                if (n().w.a() > 0 && n().x(j2) && n().y.b()) {
                    f().P().a("Current session is expired, remove the session number, ID, and engagement time");
                    j3 = nextLong;
                    z4 = true;
                    V("auto", "_sid", null, i().a());
                    V("auto", "_sno", null, i().a());
                    V("auto", "_se", null, i().a());
                } else {
                    j3 = nextLong;
                    z4 = true;
                }
                if (D.getLong("extend_session", 0L) == 1) {
                    f().P().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    str4 = str2;
                    i6Var = this;
                    i6Var.a.D().f7894d.b(j2, z4);
                } else {
                    str4 = str2;
                    i6Var = this;
                }
                String[] strArr = (String[]) D.keySet().toArray(new String[D.size()]);
                Arrays.sort(strArr);
                if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.K0) && o().u(r.J0)) {
                    for (String str9 : strArr) {
                        m();
                        Bundle[] v0 = v9.v0(D.get(str9));
                        if (v0 != null) {
                            D.putParcelableArray(str9, v0);
                        }
                    }
                    str5 = "_ae";
                } else {
                    int length = strArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        String str10 = "_eid";
                        if (i4 >= length) {
                            break;
                        }
                        String str11 = strArr[i4];
                        Object obj = D.get(str11);
                        m();
                        String[] strArr2 = strArr;
                        Bundle[] v02 = v9.v0(obj);
                        int i6 = length;
                        if (v02 != null) {
                            D.putInt(str11, v02.length);
                            int i7 = 0;
                            while (i7 < v02.length) {
                                Bundle bundle3 = v02[i7];
                                n7.I(o7Var3, bundle3, true);
                                String str12 = str10;
                                String str13 = str11;
                                Bundle D2 = m().D(str3, "_ep", bundle3, c2, z3, false);
                                D2.putString("_en", str4);
                                D2.putLong(str12, j3);
                                D2.putString("_gn", str13);
                                D2.putInt("_ll", v02.length);
                                D2.putInt("_i", i7);
                                arrayList = arrayList;
                                arrayList.add(D2);
                                i7++;
                                D = D;
                                str10 = str12;
                                str11 = str13;
                                o7Var3 = o7Var3;
                                i5 = i5;
                                str8 = str8;
                            }
                            int i8 = i5;
                            str6 = str8;
                            o7Var = o7Var3;
                            bundle2 = D;
                            j4 = j3;
                            i2 = v02.length + i8;
                        } else {
                            int i9 = i5;
                            str6 = str8;
                            o7Var = o7Var3;
                            bundle2 = D;
                            j4 = j3;
                            i2 = i9;
                        }
                        i4++;
                        str8 = str6;
                        D = bundle2;
                        j3 = j4;
                        o7Var3 = o7Var;
                        length = i6;
                        i5 = i2;
                        strArr = strArr2;
                    }
                    int i10 = i5;
                    str5 = str8;
                    Bundle bundle4 = D;
                    long j5 = j3;
                    if (i10 != 0) {
                        bundle4.putLong("_eid", j5);
                        bundle4.putInt("_epc", i10);
                    }
                }
                int i11 = 0;
                while (i11 < arrayList.size()) {
                    Bundle bundle5 = (Bundle) arrayList.get(i11);
                    String str14 = i11 != 0 ? "_ep" : str4;
                    bundle5.putString("_o", str);
                    if (z2) {
                        bundle5 = m().C(bundle5);
                    }
                    Bundle bundle6 = bundle5;
                    String str15 = str5;
                    String str16 = str4;
                    s().K(new p(str14, new o(bundle6), str, j2), str3);
                    if (!equals) {
                        for (f6 f6Var : i6Var.f7641e) {
                            f6Var.a(str, str2, new Bundle(bundle6), j2);
                        }
                    }
                    i11++;
                    str5 = str15;
                    str4 = str16;
                }
                String str17 = str5;
                String str18 = str4;
                g();
                if (t().L() == null || !str17.equals(str18)) {
                    return;
                }
                v().F(true, true, i().b());
            }
        }
    }

    public final void S(String str, String str2, Bundle bundle) {
        U(str, str2, bundle, true, true, i().a());
    }

    public final void T(String str, String str2, Bundle bundle, boolean z) {
        U(str, str2, bundle, false, true, i().a());
    }

    public final void U(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        b();
        t0(str == null ? "app" : str, str2, j2, bundle == null ? new Bundle() : bundle, z2, !z2 || this.f7640d == null || v9.B0(str2), !z, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void V(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.t.g(r9)
            com.google.android.gms.common.internal.t.g(r10)
            r8.d()
            r8.b()
            r8.y()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L63
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L53
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L38
            r4 = r2
            goto L3a
        L38:
            r4 = 0
        L3a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.k4 r0 = r8.n()
            com.google.android.gms.measurement.internal.q4 r0 = r0.t
            long r4 = r10.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r11 = "true"
        L4e:
            r0.b(r11)
            r6 = r10
            goto L61
        L53:
            if (r11 != 0) goto L63
            com.google.android.gms.measurement.internal.k4 r10 = r8.n()
            com.google.android.gms.measurement.internal.q4 r10 = r10.t
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
        L61:
            r3 = r1
            goto L65
        L63:
            r3 = r10
            r6 = r11
        L65:
            com.google.android.gms.measurement.internal.b5 r10 = r8.a
            boolean r10 = r10.q()
            if (r10 != 0) goto L7b
            com.google.android.gms.measurement.internal.x3 r9 = r8.f()
            com.google.android.gms.measurement.internal.z3 r9 = r9.P()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7b:
            com.google.android.gms.measurement.internal.b5 r10 = r8.a
            boolean r10 = r10.v()
            if (r10 != 0) goto L84
            return
        L84:
            com.google.android.gms.measurement.internal.q9 r10 = new com.google.android.gms.measurement.internal.q9
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.s7 r9 = r8.s()
            r9.P(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i6.V(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void W(String str, String str2, Object obj, boolean z) {
        X(str, str2, obj, z, i().a());
    }

    public final void X(String str, String str2, Object obj, boolean z, long j2) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i2 = 6;
        if (z) {
            i2 = m().w0(str2);
        } else {
            v9 m = m();
            if (m.f0("user property", str2)) {
                if (!m.k0("user property", d6.a, str2)) {
                    i2 = 15;
                } else if (m.e0("user property", 24, str2)) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            m();
            this.a.H().K(i2, "_ev", v9.I(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int o0 = m().o0(str2, obj);
            if (o0 != 0) {
                m();
                String I = v9.I(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    r0 = String.valueOf(obj).length();
                }
                this.a.H().K(o0, "_ev", I, r0);
                return;
            }
            Object x0 = m().x0(str2, obj);
            if (x0 != null) {
                R(str3, str2, j2, x0);
            }
        } else {
            R(str3, str2, j2, null);
        }
    }

    public final void Y(String str, String str2, String str3, Bundle bundle) {
        com.google.android.gms.common.internal.t.g(str);
        a();
        v0(str, str2, str3, bundle);
    }

    public final void Z(boolean z) {
        y();
        b();
        l().A(new y6(this, z));
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public final void a0() {
        if (h().getApplicationContext() instanceof Application) {
            ((Application) h().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f7639c);
        }
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final Boolean b0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) l().w(atomicReference, 15000L, "boolean test flag value", new j6(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final String c0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) l().w(atomicReference, 15000L, "String test flag value", new s6(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    public final Long d0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) l().w(atomicReference, 15000L, "long test flag value", new x6(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    public final Integer e0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) l().w(atomicReference, 15000L, "int test flag value", new w6(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    public final Double f0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) l().w(atomicReference, 15000L, "double test flag value", new z6(this, atomicReference));
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    public final String g0() {
        b();
        return this.f7643g.get();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    public final void h0() {
        d();
        b();
        y();
        if (this.a.v()) {
            if (o().u(r.k0)) {
                ka o = o();
                o.g();
                Boolean z = o.z("google_analytics_deferred_deep_link_enabled");
                if (z != null && z.booleanValue()) {
                    f().O().a("Deferred Deep Link feature enabled.");
                    l().A(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.k6
                        private final i6 a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            i6 i6Var = this.a;
                            i6Var.d();
                            if (i6Var.n().z.b()) {
                                i6Var.f().O().a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long a = i6Var.n().A.a();
                            i6Var.n().A.b(1 + a);
                            if (a >= 5) {
                                i6Var.f().K().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                i6Var.n().z.a(true);
                                return;
                            }
                            i6Var.a.w();
                        }
                    });
                }
            }
            s().Z();
            this.f7645i = false;
            String J = n().J();
            if (TextUtils.isEmpty(J)) {
                return;
            }
            e().q();
            if (J.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", J);
            S("auto", "_ou", bundle);
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    public final String i0() {
        o7 M = this.a.P().M();
        if (M != null) {
            return M.a;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    public final String j0() {
        o7 M = this.a.P().M();
        if (M != null) {
            return M.f7787b;
        }
        return null;
    }

    public final String k0() {
        if (this.a.L() != null) {
            return this.a.L();
        }
        try {
            return new com.google.android.gms.common.internal.x(h()).a("google_app_id");
        } catch (IllegalStateException e2) {
            this.a.f().H().b("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    public final void o0(long j2) {
        b();
        l().A(new m6(this, j2));
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    public final void p0(Bundle bundle) {
        com.google.android.gms.common.internal.t.k(bundle);
        com.google.android.gms.common.internal.t.g(bundle.getString("app_id"));
        a();
        q0(new Bundle(bundle), i().a());
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
    }

    public final void r0(f6 f6Var) {
        b();
        y();
        com.google.android.gms.common.internal.t.k(f6Var);
        if (this.f7641e.remove(f6Var)) {
            return;
        }
        f().K().a("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ s7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ n7 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ t3 u() {
        return super.u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u0(String str, String str2, Bundle bundle) {
        b();
        d();
        P(str, str2, i().a(), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }

    public final void w0(boolean z) {
        y();
        b();
        l().A(new b7(this, z));
    }

    public final List<q9> x0(boolean z) {
        b();
        y();
        f().P().a("Getting user properties (FE)");
        if (l().I()) {
            f().H().a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (ja.a()) {
            f().H().a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.a.l().w(atomicReference, 5000L, "get user properties", new n6(this, atomicReference, z));
            List<q9> list = (List) atomicReference.get();
            if (list == null) {
                f().H().b("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
    }

    public final void z0(String str, String str2, Bundle bundle) {
        b();
        v0(null, str, str2, bundle);
    }
}
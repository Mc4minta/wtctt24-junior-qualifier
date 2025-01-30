package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.coinbase.ApiConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class n7 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    protected o7 f7769c;

    /* renamed from: d  reason: collision with root package name */
    private volatile o7 f7770d;

    /* renamed from: e  reason: collision with root package name */
    private o7 f7771e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Activity, o7> f7772f;

    /* renamed from: g  reason: collision with root package name */
    private o7 f7773g;

    /* renamed from: h  reason: collision with root package name */
    private String f7774h;

    public n7(b5 b5Var) {
        super(b5Var);
        this.f7772f = new ConcurrentHashMap();
    }

    private static String C(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final void F(Activity activity, o7 o7Var, boolean z) {
        o7 o7Var2;
        o7 o7Var3 = this.f7770d == null ? this.f7771e : this.f7770d;
        if (o7Var.f7787b == null) {
            o7Var2 = new o7(o7Var.a, activity != null ? C(activity.getClass().getCanonicalName()) : null, o7Var.f7788c);
        } else {
            o7Var2 = o7Var;
        }
        this.f7771e = this.f7770d;
        this.f7770d = o7Var2;
        l().A(new q7(this, z, i().b(), o7Var3, o7Var2));
    }

    public static void I(o7 o7Var, Bundle bundle, boolean z) {
        if (bundle == null || o7Var == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && o7Var == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = o7Var.a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = o7Var.f7787b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", o7Var.f7788c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(o7 o7Var, boolean z, long j2) {
        p().w(i().b());
        if (!v().F(o7Var != null && o7Var.f7789d, z, j2) || o7Var == null) {
            return;
        }
        o7Var.f7789d = false;
    }

    private final o7 Q(Activity activity) {
        com.google.android.gms.common.internal.t.k(activity);
        o7 o7Var = this.f7772f.get(activity);
        if (o7Var == null) {
            o7 o7Var2 = new o7(null, C(activity.getClass().getCanonicalName()), m().D0());
            this.f7772f.put(activity, o7Var2);
            return o7Var2;
        }
        return o7Var;
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return false;
    }

    public final void D(Activity activity) {
        if (o().M().booleanValue()) {
            F(activity, Q(activity), false);
            a p = p();
            p.l().A(new e3(p, p.i().b()));
        }
    }

    public final void E(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!o().M().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f7772f.put(activity, new o7(bundle2.getString(ApiConstants.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void G(Activity activity, String str, String str2) {
        if (!o().M().booleanValue()) {
            f().M().a("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.f7770d == null) {
            f().M().a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f7772f.get(activity) == null) {
            f().M().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = C(activity.getClass().getCanonicalName());
            }
            boolean z0 = v9.z0(this.f7770d.f7787b, str2);
            boolean z02 = v9.z0(this.f7770d.a, str);
            if (z0 && z02) {
                f().M().a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                f().M().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
                f().M().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            } else {
                f().P().c("Setting current screen to name, class", str == null ? "null" : str, str2);
                o7 o7Var = new o7(str, str2, m().D0());
                this.f7772f.put(activity, o7Var);
                F(activity, o7Var, true);
            }
        }
    }

    public final void K(String str, o7 o7Var) {
        d();
        synchronized (this) {
            String str2 = this.f7774h;
            if (str2 == null || str2.equals(str) || o7Var != null) {
                this.f7774h = str;
                this.f7773g = o7Var;
            }
        }
    }

    public final o7 L() {
        y();
        d();
        return this.f7769c;
    }

    public final o7 M() {
        b();
        return this.f7770d;
    }

    public final void N(Activity activity) {
        if (o().M().booleanValue()) {
            o7 Q = Q(activity);
            this.f7771e = this.f7770d;
            this.f7770d = null;
            l().A(new p7(this, Q, i().b()));
        }
    }

    public final void O(Activity activity, Bundle bundle) {
        o7 o7Var;
        if (!o().M().booleanValue() || bundle == null || (o7Var = this.f7772f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", o7Var.f7788c);
        bundle2.putString(ApiConstants.NAME, o7Var.a);
        bundle2.putString("referrer_name", o7Var.f7787b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void P(Activity activity) {
        if (o().M().booleanValue()) {
            this.f7772f.remove(activity);
        }
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
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

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
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

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }
}
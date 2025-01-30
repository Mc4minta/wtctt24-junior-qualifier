package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import e.g.a.e.a.a.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class k4 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    static final Pair<String, Long> f7702c = new Pair<>("", 0L);
    public o4 A;
    public final q4 B;
    public final q4 C;
    public final o4 D;
    public final p4 E;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences f7703d;

    /* renamed from: e  reason: collision with root package name */
    public r4 f7704e;

    /* renamed from: f  reason: collision with root package name */
    public final o4 f7705f;

    /* renamed from: g  reason: collision with root package name */
    public final o4 f7706g;

    /* renamed from: h  reason: collision with root package name */
    public final o4 f7707h;

    /* renamed from: i  reason: collision with root package name */
    public final o4 f7708i;

    /* renamed from: j  reason: collision with root package name */
    public final o4 f7709j;

    /* renamed from: k  reason: collision with root package name */
    public final o4 f7710k;

    /* renamed from: l  reason: collision with root package name */
    public final o4 f7711l;
    public final q4 m;
    private String n;
    private boolean o;
    private long p;
    public final o4 q;
    public final o4 r;
    public final m4 s;
    public final q4 t;
    public final m4 u;
    public final m4 v;
    public final o4 w;
    public boolean x;
    public m4 y;
    public m4 z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k4(b5 b5Var) {
        super(b5Var);
        this.f7705f = new o4(this, "last_upload", 0L);
        this.f7706g = new o4(this, "last_upload_attempt", 0L);
        this.f7707h = new o4(this, "backoff", 0L);
        this.f7708i = new o4(this, "last_delete_stale", 0L);
        this.q = new o4(this, "time_before_start", 10000L);
        this.r = new o4(this, "session_timeout", 1800000L);
        this.s = new m4(this, "start_new_session", true);
        this.w = new o4(this, "last_pause_time", 0L);
        this.t = new q4(this, "non_personalized_ads", null);
        this.u = new m4(this, "use_dynamite_api", false);
        this.v = new m4(this, "allow_remote_dynamite", false);
        this.f7709j = new o4(this, "midnight_offset", 0L);
        this.f7710k = new o4(this, "first_open_time", 0L);
        this.f7711l = new o4(this, "app_install_time", 0L);
        this.m = new q4(this, "app_instance_id", null);
        this.y = new m4(this, "app_backgrounded", false);
        this.z = new m4(this, "deep_link_retrieval_complete", false);
        this.A = new o4(this, "deep_link_retrieval_attempts", 0L);
        this.B = new q4(this, "firebase_feature_rollouts", null);
        this.C = new q4(this, "deferred_attribution_cache", null);
        this.D = new o4(this, "deferred_attribution_cache_timestamp", 0L);
        this.E = new p4(this, "default_event_parameters", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(String str) {
        d();
        SharedPreferences.Editor edit = D().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(boolean z) {
        d();
        f().P().b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = D().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(String str) {
        d();
        SharedPreferences.Editor edit = D().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences D() {
        d();
        q();
        return this.f7703d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E() {
        d();
        return D().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        d();
        return D().getString("admob_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean G() {
        d();
        if (D().contains("use_service")) {
            return Boolean.valueOf(D().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H() {
        d();
        Boolean I = I();
        SharedPreferences.Editor edit = D().edit();
        edit.clear();
        edit.apply();
        if (I != null) {
            z(I.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean I() {
        d();
        if (D().contains("measurement_enabled")) {
            return Boolean.valueOf(D().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String J() {
        d();
        String string = D().getString("previous_os_version", null);
        e().q();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = D().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K() {
        return this.f7703d.contains("deferred_analytics_collection");
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final void p() {
        SharedPreferences sharedPreferences = h().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f7703d = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.x = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f7703d.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f7704e = new r4(this, "health_monitor", Math.max(0L, r.f7832d.a(null).longValue()));
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> v(String str) {
        d();
        long b2 = i().b();
        if (this.n != null && b2 < this.p) {
            return new Pair<>(this.n, Boolean.valueOf(this.o));
        }
        this.p = b2 + o().r(str, r.f7831c);
        e.g.a.e.a.a.a.d(true);
        try {
            a.C0299a b3 = e.g.a.e.a.a.a.b(h());
            if (b3 != null) {
                this.n = b3.a();
                this.o = b3.b();
            }
            if (this.n == null) {
                this.n = "";
            }
        } catch (Exception e2) {
            f().O().b("Unable to get advertising id", e2);
            this.n = "";
        }
        e.g.a.e.a.a.a.d(false);
        return new Pair<>(this.n, Boolean.valueOf(this.o));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(boolean z) {
        d();
        SharedPreferences.Editor edit = D().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean x(long j2) {
        return j2 - this.r.a() > this.w.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String y(String str) {
        d();
        String str2 = (String) v(str).first;
        MessageDigest I0 = v9.I0();
        if (I0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, I0.digest(str2.getBytes())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(boolean z) {
        d();
        SharedPreferences.Editor edit = D().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }
}
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.xa;
import java.lang.reflect.InvocationTargetException;
import okhttp3.internal.cache.DiskLruCache;
import org.apache.http.HttpStatus;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ka extends x5 {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f7722b;

    /* renamed from: c  reason: collision with root package name */
    private b f7723c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f7724d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ka(b5 b5Var) {
        super(b5Var);
        this.f7723c = c.a;
    }

    public static long N() {
        return r.E.a(null).longValue();
    }

    public static long O() {
        return r.f7833e.a(null).longValue();
    }

    private final Bundle S() {
        try {
            if (h().getPackageManager() == null) {
                f().H().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c2 = com.google.android.gms.common.n.c.a(h()).c(h().getPackageName(), 128);
            if (c2 == null) {
                f().H().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return c2.metaData;
        } catch (PackageManager.NameNotFoundException e2) {
            f().H().b("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    private final String k(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e2) {
            f().H().b("Could not find SystemProperties class", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            f().H().b("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (NoSuchMethodException e4) {
            f().H().b("Could not find SystemProperties.get() method", e4);
            return str2;
        } catch (InvocationTargetException e5) {
            f().H().b("SystemProperties.get() threw an exception", e5);
            return str2;
        }
    }

    public final boolean A(String str, q3<Boolean> q3Var) {
        if (str == null) {
            return q3Var.a(null).booleanValue();
        }
        String k2 = this.f7723c.k(str, q3Var.b());
        if (TextUtils.isEmpty(k2)) {
            return q3Var.a(null).booleanValue();
        }
        return q3Var.a(Boolean.valueOf(Boolean.parseBoolean(k2))).booleanValue();
    }

    public final int B() {
        return (com.google.android.gms.internal.measurement.n8.b() && o().A(null, r.P0) && m().J0() >= 2147483) ? 100 : 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> C(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.t.g(r4)
            android.os.Bundle r0 = r3.S()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.x3 r4 = r3.f()
            com.google.android.gms.measurement.internal.z3 r4 = r4.H()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.h()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.x3 r0 = r3.f()
            com.google.android.gms.measurement.internal.z3 r0 = r0.H()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ka.C(java.lang.String):java.util.List");
    }

    public final boolean D(String str, q3<Boolean> q3Var) {
        return A(str, q3Var);
    }

    public final long E() {
        g();
        return 26001L;
    }

    public final boolean F(String str) {
        return DiskLruCache.VERSION_1.equals(this.f7723c.k(str, "gaia_collection_enabled"));
    }

    public final boolean G() {
        if (this.f7724d == null) {
            synchronized (this) {
                if (this.f7724d == null) {
                    ApplicationInfo applicationInfo = h().getApplicationInfo();
                    String a = com.google.android.gms.common.util.m.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f7724d = Boolean.valueOf(str != null && str.equals(a));
                    }
                    if (this.f7724d == null) {
                        this.f7724d = Boolean.TRUE;
                        f().H().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f7724d.booleanValue();
    }

    public final boolean H(String str) {
        return DiskLruCache.VERSION_1.equals(this.f7723c.k(str, "measurement.event_sampling_enabled"));
    }

    public final boolean I() {
        g();
        Boolean z = z("firebase_analytics_collection_deactivated");
        return z != null && z.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean J(String str) {
        return A(str, r.L);
    }

    public final Boolean K() {
        b();
        Boolean z = z("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(z == null || z.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String L(String str) {
        q3<String> q3Var = r.M;
        if (str == null) {
            return q3Var.a(null);
        }
        return q3Var.a(this.f7723c.k(str, q3Var.b()));
    }

    public final Boolean M() {
        b();
        if (xa.b() && u(r.F0)) {
            Boolean z = z("google_analytics_automatic_screen_reporting_enabled");
            return Boolean.valueOf(z == null || z.booleanValue());
        }
        return Boolean.TRUE;
    }

    public final String P() {
        return k("debug.firebase.analytics.app", "");
    }

    public final String Q() {
        return k("debug.deferred.deeplink", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean R() {
        if (this.f7722b == null) {
            Boolean z = z("app_measurement_lite");
            this.f7722b = z;
            if (z == null) {
                this.f7722b = Boolean.FALSE;
            }
        }
        return this.f7722b.booleanValue() || !this.a.O();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int p(String str) {
        return (com.google.android.gms.internal.measurement.n8.b() && A(null, r.O0)) ? q(str, r.I, HttpStatus.SC_INTERNAL_SERVER_ERROR, 2000) : HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }

    public final int q(String str, q3<Integer> q3Var, int i2, int i3) {
        return Math.max(Math.min(w(str, q3Var), i3), i2);
    }

    public final long r(String str, q3<Long> q3Var) {
        if (str == null) {
            return q3Var.a(null).longValue();
        }
        String k2 = this.f7723c.k(str, q3Var.b());
        if (TextUtils.isEmpty(k2)) {
            return q3Var.a(null).longValue();
        }
        try {
            return q3Var.a(Long.valueOf(Long.parseLong(k2))).longValue();
        } catch (NumberFormatException unused) {
            return q3Var.a(null).longValue();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String s(com.google.android.gms.measurement.internal.f4 r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.A()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.ka.b()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.ka r1 = r5.o()
            java.lang.String r2 = r6.t()
            com.google.android.gms.measurement.internal.q3<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.r.r0
            boolean r1 = r1.A(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.G()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.D()
        L33:
            com.google.android.gms.measurement.internal.q3<java.lang.String> r2 = com.google.android.gms.measurement.internal.r.f7834f
            r3 = 0
            java.lang.Object r2 = r2.a(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.q3<java.lang.String> r4 = com.google.android.gms.measurement.internal.r.f7835g
            java.lang.Object r3 = r4.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.x()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.E()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ka.s(com.google.android.gms.measurement.internal.f4):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(b bVar) {
        this.f7723c = bVar;
    }

    public final boolean u(q3<Boolean> q3Var) {
        return A(null, q3Var);
    }

    public final int v(String str) {
        return w(str, r.p);
    }

    public final int w(String str, q3<Integer> q3Var) {
        if (str == null) {
            return q3Var.a(null).intValue();
        }
        String k2 = this.f7723c.k(str, q3Var.b());
        if (TextUtils.isEmpty(k2)) {
            return q3Var.a(null).intValue();
        }
        try {
            return q3Var.a(Integer.valueOf(Integer.parseInt(k2))).intValue();
        } catch (NumberFormatException unused) {
            return q3Var.a(null).intValue();
        }
    }

    public final double x(String str, q3<Double> q3Var) {
        if (str == null) {
            return q3Var.a(null).doubleValue();
        }
        String k2 = this.f7723c.k(str, q3Var.b());
        if (TextUtils.isEmpty(k2)) {
            return q3Var.a(null).doubleValue();
        }
        try {
            return q3Var.a(Double.valueOf(Double.parseDouble(k2))).doubleValue();
        } catch (NumberFormatException unused) {
            return q3Var.a(null).doubleValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int y(String str) {
        if (com.google.android.gms.internal.measurement.n8.b() && A(null, r.O0)) {
            return q(str, r.H, 25, 100);
        }
        return 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean z(String str) {
        com.google.android.gms.common.internal.t.g(str);
        Bundle S = S();
        if (S == null) {
            f().H().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (S.containsKey(str)) {
            return Boolean.valueOf(S.getBoolean(str));
        } else {
            return null;
        }
    }
}
package com.google.android.gms.internal.p000firebaseperf;

import android.content.Context;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.internal.b;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i  reason: invalid package */
/* loaded from: classes2.dex */
public final class i {
    private static volatile i a;

    /* renamed from: c  reason: collision with root package name */
    private RemoteConfigManager f6737c = RemoteConfigManager.zzci();

    /* renamed from: b  reason: collision with root package name */
    private q0 f6736b = new q0();

    /* renamed from: d  reason: collision with root package name */
    private d0 f6738d = d0.f();

    /* renamed from: e  reason: collision with root package name */
    private k0 f6739e = k0.a();

    private i(RemoteConfigManager remoteConfigManager, q0 q0Var, d0 d0Var) {
    }

    public static synchronized i A() {
        i iVar;
        synchronized (i.class) {
            if (a == null) {
                a = new i(null, null, null);
            }
            iVar = a;
        }
        return iVar;
    }

    private final p0<Boolean> a(z<Boolean> zVar) {
        return this.f6736b.b(zVar.c());
    }

    private final <T> T b(z<T> zVar, T t) {
        this.f6739e.c(String.format("Config resolver result for flag: '%s' is: '%s'.", zVar.getClass().getName(), String.valueOf(t)));
        return t;
    }

    private static boolean d(float f2) {
        return 0.0f <= f2 && f2 <= 1.0f;
    }

    private final <T> boolean e(z<T> zVar, T t, boolean z) {
        this.f6739e.c(String.format("Config resolver result for flag: '%s' is: '%s'. Resolving value as '%s'", zVar.getClass().getName(), String.valueOf(t), String.valueOf(z)));
        return z;
    }

    private static boolean f(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(b.f9312b)) {
                return true;
            }
        }
        return false;
    }

    private final p0<Long> n(z<Long> zVar) {
        return this.f6736b.d(zVar.c());
    }

    private static boolean p(long j2) {
        return j2 >= 0;
    }

    private final p0<Float> q(z<Float> zVar) {
        return this.f6737c.zzd(zVar.a());
    }

    private static boolean s(long j2) {
        return j2 > 0;
    }

    private final p0<Long> t(z<Long> zVar) {
        return this.f6737c.zze(zVar.a());
    }

    private static boolean u(long j2) {
        return j2 >= 0;
    }

    private final p0<Float> v(z<Float> zVar) {
        return this.f6738d.i(zVar.b());
    }

    private static boolean w(long j2) {
        return j2 > 0;
    }

    private final p0<Long> x(z<Long> zVar) {
        return this.f6738d.k(zVar.b());
    }

    private final p0<Boolean> y(z<Boolean> zVar) {
        return this.f6738d.e(zVar.b());
    }

    private final p0<String> z(z<String> zVar) {
        return this.f6738d.h(zVar.b());
    }

    public final boolean B() {
        Boolean C = C();
        return (C == null || C.booleanValue()) && E();
    }

    public final Boolean C() {
        if (D().booleanValue()) {
            return Boolean.FALSE;
        }
        k d2 = k.d();
        p0<Boolean> y = y(d2);
        if (y.b()) {
            return (Boolean) b(d2, y.a());
        }
        p0<Boolean> a2 = a(d2);
        if (a2.b()) {
            return (Boolean) b(d2, a2.a());
        }
        this.f6739e.c("CollectionEnabled metadata key unknown or value not found in manifest.");
        return (Boolean) b(d2, null);
    }

    public final Boolean D() {
        h d2 = h.d();
        p0<Boolean> a2 = a(d2);
        if (a2.b()) {
            return (Boolean) b(d2, a2.a());
        }
        return (Boolean) b(d2, Boolean.FALSE);
    }

    public final boolean E() {
        boolean booleanValue;
        boolean e2;
        this.f6739e.c("Retrieving master flag for Firebase Performance SDK enabled configuration value.");
        p d2 = p.d();
        p0<Boolean> zzb = this.f6737c.zzb(d2.a());
        if (zzb.b()) {
            if (this.f6737c.zzcj()) {
                booleanValue = ((Boolean) b(d2, Boolean.FALSE)).booleanValue();
            } else {
                this.f6738d.d(d2.b(), zzb.a().booleanValue());
                booleanValue = ((Boolean) b(d2, zzb.a())).booleanValue();
            }
        } else {
            p0<Boolean> y = y(d2);
            if (y.b()) {
                booleanValue = ((Boolean) b(d2, y.a())).booleanValue();
            } else {
                booleanValue = ((Boolean) b(d2, Boolean.TRUE)).booleanValue();
            }
        }
        if (booleanValue) {
            this.f6739e.c("Retrieving Firebase Performance SDK disabled versions configuration value.");
            q d3 = q.d();
            p0<String> zzc = this.f6737c.zzc(d3.a());
            if (zzc.b()) {
                this.f6738d.c(d3.b(), zzc.a());
                e2 = e(d3, zzc.a(), f(zzc.a()));
            } else {
                p0<String> z = z(d3);
                if (z.b()) {
                    e2 = e(d3, z.a(), f(z.a()));
                } else {
                    e2 = e(d3, "", f(""));
                }
            }
            return !e2;
        }
        return false;
    }

    public final float F() {
        this.f6739e.c("Retrieving trace sampling rate configuration value.");
        a0 d2 = a0.d();
        p0<Float> q = q(d2);
        if (q.b() && d(q.a().floatValue())) {
            this.f6738d.a(d2.b(), q.a().floatValue());
            return ((Float) b(d2, q.a())).floatValue();
        }
        p0<Float> v = v(d2);
        if (v.b() && d(v.a().floatValue())) {
            return ((Float) b(d2, v.a())).floatValue();
        }
        return ((Float) b(d2, Float.valueOf(1.0f))).floatValue();
    }

    public final float G() {
        this.f6739e.c("Retrieving network request sampling rate configuration value.");
        o d2 = o.d();
        p0<Float> q = q(d2);
        if (q.b() && d(q.a().floatValue())) {
            this.f6738d.a(d2.b(), q.a().floatValue());
            return ((Float) b(d2, q.a())).floatValue();
        }
        p0<Float> v = v(d2);
        if (v.b() && d(v.a().floatValue())) {
            return ((Float) b(d2, v.a())).floatValue();
        }
        return ((Float) b(d2, Float.valueOf(1.0f))).floatValue();
    }

    public final float H() {
        this.f6739e.c("Retrieving session sampling rate configuration value.");
        v d2 = v.d();
        p0<Float> c2 = this.f6736b.c(d2.c());
        if (c2.b()) {
            float floatValue = c2.a().floatValue() / 100.0f;
            if (d(floatValue)) {
                return ((Float) b(d2, Float.valueOf(floatValue))).floatValue();
            }
        }
        p0<Float> q = q(d2);
        if (q.b() && d(q.a().floatValue())) {
            this.f6738d.a(d2.b(), q.a().floatValue());
            return ((Float) b(d2, q.a())).floatValue();
        }
        p0<Float> v = v(d2);
        if (v.b() && d(v.a().floatValue())) {
            return ((Float) b(d2, v.a())).floatValue();
        }
        return ((Float) b(d2, Float.valueOf(0.01f))).floatValue();
    }

    public final long I() {
        this.f6739e.c("Retrieving Session CPU Capture Frequency on foreground (milliseonds) configuration value.");
        r d2 = r.d();
        p0<Long> n = n(d2);
        if (n.b() && u(n.a().longValue())) {
            return ((Long) b(d2, n.a())).longValue();
        }
        p0<Long> t = t(d2);
        if (t.b() && u(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && u(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 100L)).longValue();
    }

    public final long J() {
        this.f6739e.c("Retrieving Session CPU Capture Frequency on background (milliseonds) configuration value.");
        s d2 = s.d();
        p0<Long> n = n(d2);
        if (n.b() && u(n.a().longValue())) {
            return ((Long) b(d2, n.a())).longValue();
        }
        p0<Long> t = t(d2);
        if (t.b() && u(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && u(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 0L)).longValue();
    }

    public final long K() {
        this.f6739e.c("Retrieving Session Memory Capture Frequency on foreground (milliseonds) configuration value.");
        w d2 = w.d();
        p0<Long> n = n(d2);
        if (n.b() && u(n.a().longValue())) {
            return ((Long) b(d2, n.a())).longValue();
        }
        p0<Long> t = t(d2);
        if (t.b() && u(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && u(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 100L)).longValue();
    }

    public final long L() {
        this.f6739e.c("Retrieving Session Memory Capture Frequency on background (milliseonds) configuration value.");
        t d2 = t.d();
        p0<Long> n = n(d2);
        if (n.b() && u(n.a().longValue())) {
            return ((Long) b(d2, n.a())).longValue();
        }
        p0<Long> t = t(d2);
        if (t.b() && u(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && u(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 0L)).longValue();
    }

    public final void c(q0 q0Var) {
        this.f6736b = q0Var;
    }

    public final long g() {
        this.f6739e.c("Retrieving Max Duration (in minutes) of single Session configuration value.");
        u d2 = u.d();
        p0<Long> n = n(d2);
        if (n.b() && w(n.a().longValue())) {
            return ((Long) b(d2, n.a())).longValue();
        }
        p0<Long> t = t(d2);
        if (t.b() && w(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && w(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 240L)).longValue();
    }

    public final long h() {
        this.f6739e.c("Retrieving trace event count foreground configuration value.");
        x d2 = x.d();
        p0<Long> t = t(d2);
        if (t.b() && p(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && p(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 300L)).longValue();
    }

    public final long i() {
        this.f6739e.c("Retrieving trace event count background configuration value.");
        y d2 = y.d();
        p0<Long> t = t(d2);
        if (t.b() && p(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && p(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 30L)).longValue();
    }

    public final long j() {
        this.f6739e.c("Retrieving network event count foreground configuration value.");
        l d2 = l.d();
        p0<Long> t = t(d2);
        if (t.b() && p(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && p(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 700L)).longValue();
    }

    public final long k() {
        this.f6739e.c("Retrieving network event count background configuration value.");
        m d2 = m.d();
        p0<Long> t = t(d2);
        if (t.b() && p(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && p(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 70L)).longValue();
    }

    public final long l() {
        this.f6739e.c("Retrieving rate limiting time range (in seconds) configuration value.");
        n d2 = n.d();
        p0<Long> t = t(d2);
        if (t.b() && s(t.a().longValue())) {
            this.f6738d.b(d2.b(), t.a().longValue());
            return ((Long) b(d2, t.a())).longValue();
        }
        p0<Long> x = x(d2);
        if (x.b() && s(x.a().longValue())) {
            return ((Long) b(d2, x.a())).longValue();
        }
        return ((Long) b(d2, 600L)).longValue();
    }

    public final String m() {
        String f2;
        j d2 = j.d();
        if (b.f9313c) {
            return (String) b(d2, j.e());
        }
        String a2 = d2.a();
        long longValue = a2 != null ? ((Long) this.f6737c.zza(a2, -1L)).longValue() : -1L;
        String b2 = d2.b();
        if (j.g(longValue) && (f2 = j.f(longValue)) != null) {
            this.f6738d.c(b2, f2);
            return (String) b(d2, f2);
        }
        p0<String> z = z(d2);
        if (z.b()) {
            return (String) b(d2, z.a());
        }
        return (String) b(d2, j.e());
    }

    public final void o(Context context) {
        r(context.getApplicationContext());
    }

    public final void r(Context context) {
        k0.a().b(c1.a(context));
        this.f6738d.j(context);
    }
}
package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.coinbase.ApiConstants;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* compiled from: AppData.java */
/* loaded from: classes.dex */
class c {
    private static final long a = SystemClock.elapsedRealtime();

    /* renamed from: b  reason: collision with root package name */
    private final Context f3609b;

    /* renamed from: c  reason: collision with root package name */
    private final s f3610c;

    /* renamed from: d  reason: collision with root package name */
    private final y0 f3611d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3612e;

    /* renamed from: f  reason: collision with root package name */
    private String f3613f = null;

    /* renamed from: g  reason: collision with root package name */
    final String f3614g;

    /* renamed from: h  reason: collision with root package name */
    private PackageInfo f3615h;

    /* renamed from: i  reason: collision with root package name */
    private ApplicationInfo f3616i;

    /* renamed from: j  reason: collision with root package name */
    private PackageManager f3617j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, PackageManager packageManager, s sVar, y0 y0Var) {
        this.f3609b = context;
        this.f3617j = packageManager;
        this.f3610c = sVar;
        this.f3611d = y0Var;
        String packageName = context.getPackageName();
        this.f3612e = packageName;
        try {
            this.f3617j = packageManager;
            this.f3615h = packageManager.getPackageInfo(packageName, 0);
            this.f3616i = this.f3617j.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            q0.d("Could not retrieve package/application information for " + this.f3612e);
        }
        this.f3614g = i();
    }

    private long a() {
        return this.f3611d.e(System.currentTimeMillis());
    }

    private String b() {
        String u = this.f3610c.u();
        return u != null ? u : "android";
    }

    private Integer c() {
        PackageInfo packageInfo = this.f3615h;
        if (packageInfo != null) {
            return Integer.valueOf(packageInfo.versionCode);
        }
        return null;
    }

    private String d() {
        String d2 = this.f3610c.d();
        if (d2 != null) {
            return d2;
        }
        PackageInfo packageInfo = this.f3615h;
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    private String i() {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = this.f3617j;
        if (packageManager == null || (applicationInfo = this.f3616i) == null) {
            return null;
        }
        return packageManager.getApplicationLabel(applicationInfo).toString();
    }

    static long j() {
        return SystemClock.elapsedRealtime() - a;
    }

    private long k() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private Boolean m() {
        try {
            ActivityManager activityManager = (ActivityManager) this.f3609b.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                return Boolean.valueOf(memoryInfo.lowMemory);
            }
            return null;
        } catch (Exception unused) {
            q0.d("Could not check lowMemory status");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f3611d.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> f() {
        Map<String, Object> h2 = h();
        h2.put("id", this.f3612e);
        h2.put("buildUUID", this.f3610c.i());
        h2.put("duration", Long.valueOf(j()));
        h2.put("durationInForeground", Long.valueOf(a()));
        h2.put("inForeground", Boolean.valueOf(this.f3611d.i()));
        h2.put("packageName", this.f3612e);
        h2.put("binaryArch", this.f3613f);
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put(ApiConstants.NAME, this.f3614g);
        hashMap.put("packageName", this.f3612e);
        hashMap.put("versionName", d());
        hashMap.put("activeScreen", e());
        hashMap.put("memoryUsage", Long.valueOf(k()));
        hashMap.put("lowMemory", m());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", b());
        hashMap.put("releaseStage", l());
        hashMap.put(ClientCookie.VERSION_ATTR, d());
        hashMap.put("versionCode", c());
        hashMap.put("codeBundleId", this.f3610c.j());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        String y = this.f3610c.y();
        if (y != null) {
            return y;
        }
        ApplicationInfo applicationInfo = this.f3616i;
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? "production" : "development";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str) {
        this.f3613f = str;
    }
}
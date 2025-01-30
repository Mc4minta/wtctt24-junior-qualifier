package com.bugsnag.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.util.DisplayMetrics;
import com.coinbase.ApiConstants;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: DeviceData.java */
/* loaded from: classes.dex */
class b0 {
    private static final String[] a = {"/system/xbin/su", "/system/bin/su", "/system/app/Superuser.apk", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/SuperSU", "/system/xbin/daemonsu", "/su/bin"};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3598b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f3599c;

    /* renamed from: d  reason: collision with root package name */
    private final t f3600d;

    /* renamed from: e  reason: collision with root package name */
    private final Resources f3601e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f3602f;

    /* renamed from: g  reason: collision with root package name */
    private final DisplayMetrics f3603g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3604h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3605i;

    /* renamed from: j  reason: collision with root package name */
    final Float f3606j;

    /* renamed from: k  reason: collision with root package name */
    final Integer f3607k;

    /* renamed from: l  reason: collision with root package name */
    final String f3608l;
    final String m;
    final String[] n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceData.java */
    /* loaded from: classes.dex */
    public static class a {
        static String[] a() {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceData.java */
    /* loaded from: classes.dex */
    public static class b {
        static String[] a() {
            return Build.SUPPORTED_ABIS;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(t tVar, Context context, Resources resources, SharedPreferences sharedPreferences) {
        this.f3600d = tVar;
        this.f3599c = context;
        this.f3601e = resources;
        this.f3602f = sharedPreferences;
        if (resources != null) {
            this.f3603g = resources.getDisplayMetrics();
        } else {
            this.f3603g = null;
        }
        this.f3606j = n();
        this.f3607k = o();
        this.f3608l = p();
        this.m = k();
        this.n = f();
        this.f3598b = s();
        this.f3604h = u();
        this.f3605i = t();
    }

    private Long a() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize() * statFs.getBlockCount();
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            return Long.valueOf(Math.min(statFs2.getBlockSize() * statFs2.getBlockCount(), blockSize));
        } catch (Exception unused) {
            q0.d("Could not get freeDisk");
            return null;
        }
    }

    private long b() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Long.MAX_VALUE) {
            return (runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory();
        }
        return runtime.freeMemory();
    }

    private String c() {
        Resources resources = this.f3601e;
        if (resources != null) {
            int i2 = resources.getConfiguration().orientation;
            if (i2 == 1) {
                return "portrait";
            }
            if (i2 == 2) {
                return "landscape";
            }
        }
        return null;
    }

    static long d() {
        Runtime runtime = Runtime.getRuntime();
        if (runtime.maxMemory() != Long.MAX_VALUE) {
            return runtime.maxMemory();
        }
        return runtime.totalMemory();
    }

    private Float e() {
        try {
            Intent registerReceiver = this.f3599c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return Float.valueOf(registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1));
        } catch (Exception unused) {
            q0.d("Could not get batteryLevel");
            return null;
        }
    }

    private String[] f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a();
        }
        return a.a();
    }

    private String k() {
        return Locale.getDefault().toString();
    }

    private String l() {
        try {
            String string = Settings.Secure.getString(this.f3599c.getContentResolver(), "location_providers_allowed");
            return string != null ? string.length() > 0 ? "allowed" : "disallowed" : "disallowed";
        } catch (Exception unused) {
            q0.d("Could not get locationStatus");
            return null;
        }
    }

    private String m() {
        return this.f3600d.c();
    }

    private Float n() {
        DisplayMetrics displayMetrics = this.f3603g;
        if (displayMetrics != null) {
            return Float.valueOf(displayMetrics.density);
        }
        return null;
    }

    private Integer o() {
        DisplayMetrics displayMetrics = this.f3603g;
        if (displayMetrics != null) {
            return Integer.valueOf(displayMetrics.densityDpi);
        }
        return null;
    }

    private String p() {
        DisplayMetrics displayMetrics = this.f3603g;
        if (displayMetrics != null) {
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            DisplayMetrics displayMetrics2 = this.f3603g;
            return String.format(Locale.US, "%dx%d", Integer.valueOf(max), Integer.valueOf(Math.min(displayMetrics2.widthPixels, displayMetrics2.heightPixels)));
        }
        return null;
    }

    private String q() {
        return x.b(new Date());
    }

    private Boolean r() {
        boolean z;
        try {
            int intExtra = this.f3599c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            if (intExtra != 2 && intExtra != 5) {
                z = false;
                return Boolean.valueOf(z);
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            q0.d("Could not get charging status");
            return null;
        }
    }

    private boolean s() {
        String str = Build.FINGERPRINT;
        return str.startsWith("unknown") || str.contains("generic") || str.contains("vbox");
    }

    private boolean t() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            try {
                for (String str2 : a) {
                    if (new File(str2).exists()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return true;
    }

    private String u() {
        String string = this.f3602f.getString("install.iud", null);
        if (string == null) {
            String uuid = UUID.randomUUID().toString();
            this.f3602f.edit().putString("install.iud", uuid).apply();
            return uuid;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> g() {
        Map<String, Object> h2 = h();
        h2.put("id", this.f3604h);
        h2.put("freeMemory", Long.valueOf(b()));
        h2.put("totalMemory", Long.valueOf(d()));
        h2.put("freeDisk", a());
        h2.put("orientation", c());
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("manufacturer", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("jailbroken", Boolean.valueOf(this.f3605i));
        hashMap.put("osName", "android");
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put("cpuAbi", this.n);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("androidApiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap2.put("osBuild", Build.DISPLAY);
        hashMap.put("runtimeVersions", hashMap2);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> i() {
        HashMap hashMap = new HashMap();
        hashMap.put("batteryLevel", e());
        hashMap.put("charging", r());
        hashMap.put("locationStatus", l());
        hashMap.put("networkAccess", m());
        hashMap.put(ApiConstants.TIME, q());
        hashMap.put("brand", Build.BRAND);
        hashMap.put(ApiConstants.LOCALE, this.m);
        hashMap.put("screenDensity", this.f3606j);
        hashMap.put("dpi", this.f3607k);
        hashMap.put("emulator", Boolean.valueOf(this.f3598b));
        hashMap.put("screenResolution", this.f3608l);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.f3604h;
    }
}
package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerParameters;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ai {

    /* renamed from: ɩ  reason: contains not printable characters */
    public static ai f183;

    /* renamed from: ı  reason: contains not printable characters */
    private JSONArray f184;

    /* renamed from: ǃ  reason: contains not printable characters */
    private JSONObject f185;

    /* renamed from: ɹ  reason: contains not printable characters */
    private int f186;

    /* renamed from: ι  reason: contains not printable characters */
    public boolean f188;

    /* renamed from: І  reason: contains not printable characters */
    private boolean f189;

    /* renamed from: і  reason: contains not printable characters */
    private boolean f190;

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean f187 = true;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private String f191 = "-1";

    public ai() {
        this.f186 = 0;
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.f189 = z;
        this.f188 = true ^ z;
        this.f184 = new JSONArray();
        this.f186 = 0;
        this.f190 = false;
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private boolean m137() {
        if (this.f188) {
            return this.f187 || this.f190;
        }
        return false;
    }

    /* renamed from: і  reason: contains not printable characters */
    private synchronized void m139() {
        this.f184 = null;
        this.f184 = new JSONArray();
        this.f186 = 0;
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final synchronized void m141(String str, String str2, String... strArr) {
        if (m137()) {
            if (this.f186 < 98304) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str3 = "";
                    if (strArr.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int length = strArr.length - 1; length > 0; length--) {
                            sb.append(strArr[length]);
                            sb.append(", ");
                        }
                        sb.append(strArr[0]);
                        str3 = sb.toString();
                    }
                    String format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
                    String format2 = str != null ? String.format("%18s %5s _/%s [%s] %s %s", format, Long.valueOf(Thread.currentThread().getId()), AppsFlyerLibCore.LOG_TAG, str, str2, str3) : String.format("%18s %5s %s/%s %s", format, Long.valueOf(Thread.currentThread().getId()), str2, AppsFlyerLibCore.LOG_TAG, str3);
                    this.f184.put(format2);
                    this.f186 += format2.getBytes().length;
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public final synchronized void m142() {
        this.f190 = true;
        m141("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final synchronized void m144(String str) {
        this.f191 = str;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public final synchronized String m145() {
        String str;
        try {
            this.f185.put("data", this.f184);
            str = this.f185.toString();
            try {
                m139();
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            str = null;
        }
        return str;
    }

    /* renamed from: ι  reason: contains not printable characters */
    public final synchronized void m147() {
        m141("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f190 = false;
        this.f187 = false;
    }

    /* renamed from: І  reason: contains not printable characters */
    public final boolean m148() {
        return this.f190;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final synchronized void m143() {
        this.f185 = null;
        this.f184 = null;
        f183 = null;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private synchronized void m135(String str, String str2, String str3, String str4) {
        try {
            this.f185.put("sdk_version", str);
            if (str2 != null && str2.length() > 0) {
                this.f185.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.f185.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.f185.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private synchronized void m138(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.f185.put("brand", str);
            this.f185.put("model", str2);
            this.f185.put("platform", "Android");
            this.f185.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.f185.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.f185.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.f185.put("android_id", str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public final synchronized void m146(String str, PackageManager packageManager) {
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.getInstance();
        String string = appsFlyerProperties.getString("remote_debug_static_data");
        if (string != null) {
            try {
                this.f185 = new JSONObject(string);
            } catch (Throwable unused) {
            }
        } else {
            this.f185 = new JSONObject();
            m138(Build.BRAND, Build.MODEL, Build.VERSION.RELEASE, appsFlyerProperties.getString(ServerParameters.ADVERTISING_ID_PARAM), appsFlyerLibCore.f85, appsFlyerLibCore.f86);
            StringBuilder sb = new StringBuilder("5.4.0.");
            sb.append(AppsFlyerLibCore.f61);
            m135(sb.toString(), appsFlyerProperties.getString(AppsFlyerProperties.AF_KEY), appsFlyerProperties.getString("KSAppsFlyerId"), appsFlyerProperties.getString("uid"));
            try {
                int i2 = packageManager.getPackageInfo(str, 0).versionCode;
                m136(str, String.valueOf(i2), appsFlyerProperties.getString(AppsFlyerProperties.CHANNEL), appsFlyerProperties.getString("preInstallName"));
            } catch (Throwable unused2) {
            }
            appsFlyerProperties.set("remote_debug_static_data", this.f185.toString());
        }
        try {
            this.f185.put("launch_counter", this.f191);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private synchronized void m136(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f185.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f185.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f185.put(AppsFlyerProperties.CHANNEL, str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f185.put("preInstall", str4);
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final synchronized void m140() {
        this.f187 = false;
        m139();
    }
}
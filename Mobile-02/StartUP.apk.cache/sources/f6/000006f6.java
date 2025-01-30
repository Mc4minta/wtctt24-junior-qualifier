package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.internal.referrer.Payload;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final String AF_KEY = "AppsFlyerKey";
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_FINGER_PRINT = "collectFingerPrint";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_MAC = "collectMAC";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";

    /* renamed from: ǃ  reason: contains not printable characters */
    private static AppsFlyerProperties f125 = new AppsFlyerProperties();

    /* renamed from: ı  reason: contains not printable characters */
    private boolean f126;

    /* renamed from: ɩ  reason: contains not printable characters */
    private String f128;

    /* renamed from: ι  reason: contains not printable characters */
    private boolean f130;

    /* renamed from: Ι  reason: contains not printable characters */
    private Map<String, Object> f129 = new HashMap();

    /* renamed from: Ɩ  reason: contains not printable characters */
    private boolean f127 = false;

    /* loaded from: classes.dex */
    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        

        /* renamed from: ɩ  reason: contains not printable characters */
        private final int f132;

        EmailsCryptType(int i2) {
            this.f132 = i2;
        }

        public final int getValue() {
            return this.f132;
        }
    }

    private AppsFlyerProperties() {
    }

    public static AppsFlyerProperties getInstance() {
        return f125;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m111() {
        return this.f127;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return string == null ? z : Boolean.valueOf(string).booleanValue();
    }

    public int getInt(String str, int i2) {
        String string = getString(str);
        return string == null ? i2 : Integer.valueOf(string).intValue();
    }

    public long getLong(String str, long j2) {
        String string = getString(str);
        return string == null ? j2 : Long.valueOf(string).longValue();
    }

    public synchronized Object getObject(String str) {
        return this.f129.get(str);
    }

    public String getReferrer(Context context) {
        String str = this.f128;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return AppsFlyerLibCore.getSharedPreferences(context).getString(Payload.REFERRER, null);
    }

    public synchronized String getString(String str) {
        return (String) this.f129.get(str);
    }

    public boolean isEnableLog() {
        return getBoolean("shouldLog", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFirstLaunchCalled() {
        return this.f130;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    protected boolean isOnReceiveCalled() {
        return this.f126;
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    public synchronized void loadProperties(Context context) {
        if (m111()) {
            return;
        }
        String string = AppsFlyerLibCore.getSharedPreferences(context).getString("savedProperties", null);
        if (string != null) {
            AFLogger.afDebugLog("Loading properties..");
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (this.f129.get(next) == null) {
                        this.f129.put(next, jSONObject.getString(next));
                    }
                }
                this.f127 = true;
            } catch (JSONException e2) {
                AFLogger.afErrorLog("Failed loading properties", e2);
            }
            StringBuilder sb = new StringBuilder("Done loading properties: ");
            sb.append(this.f127);
            AFLogger.afDebugLog(sb.toString());
        }
    }

    public synchronized void remove(String str) {
        this.f129.remove(str);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.f129).toString()).apply();
    }

    public synchronized void set(String str, String str2) {
        this.f129.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.f129.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    protected void setFirstLaunchCalled(boolean z) {
        this.f130 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnReceiveCalled() {
        this.f126 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setReferrer(String str) {
        set("AF_REFERRER", str);
        this.f128 = str;
    }

    public synchronized void setUserEmails(String str) {
        this.f129.put(USER_EMAILS, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFirstLaunchCalled() {
        this.f130 = true;
    }

    public synchronized void set(String str, String[] strArr) {
        this.f129.put(str, strArr);
    }

    public synchronized void set(String str, int i2) {
        this.f129.put(str, Integer.toString(i2));
    }

    public synchronized void set(String str, long j2) {
        this.f129.put(str, Long.toString(j2));
    }

    public synchronized void set(String str, boolean z) {
        this.f129.put(str, Boolean.toString(z));
    }
}
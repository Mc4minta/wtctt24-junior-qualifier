package com.appsflyer;

import com.appsflyer.internal.ai;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerConfigHandler {
    public static String getUrl(String str) {
        return String.format(str, AppsFlyerLib.getInstance().getHostPrefix(), AppsFlyerLibCore.getInstance().getHostName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ı  reason: contains not printable characters */
    public static JSONObject m114(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                if (jSONObject2.optBoolean("monitor", false) && !z) {
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai.f183.m142();
                } else {
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai.f183.m140();
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai.f183.m147();
                }
                if (jSONObject2.has("ol_id")) {
                    String optString = jSONObject2.optString("ol_scheme", null);
                    String optString2 = jSONObject2.optString("ol_domain", null);
                    String optString3 = jSONObject2.optString("ol_ver", null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                        return jSONObject2;
                    }
                    return jSONObject2;
                }
                return jSONObject2;
            } catch (JSONException unused) {
                jSONObject = jSONObject2;
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m140();
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m147();
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                jSONObject = jSONObject2;
                AFLogger.afErrorLog(th.getMessage(), th);
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m140();
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m147();
                return jSONObject;
            }
        } catch (JSONException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
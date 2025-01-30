package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;

/* loaded from: classes.dex */
public class LinkGenerator {

    /* renamed from: ı  reason: contains not printable characters */
    private String f327;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private String f328;

    /* renamed from: ǃ  reason: contains not printable characters */
    private String f329;

    /* renamed from: ȷ  reason: contains not printable characters */
    private String f330;

    /* renamed from: ɩ  reason: contains not printable characters */
    String f332;

    /* renamed from: ɹ  reason: contains not printable characters */
    private String f334;

    /* renamed from: ɾ  reason: contains not printable characters */
    private String f335;

    /* renamed from: Ι  reason: contains not printable characters */
    private String f336;

    /* renamed from: ι  reason: contains not printable characters */
    String f337;

    /* renamed from: І  reason: contains not printable characters */
    private String f338;

    /* renamed from: і  reason: contains not printable characters */
    private String f339;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private String f340;

    /* renamed from: ɨ  reason: contains not printable characters */
    private Map<String, String> f331 = new HashMap();

    /* renamed from: ɪ  reason: contains not printable characters */
    private Map<String, String> f333 = new HashMap();

    public LinkGenerator(String str) {
        this.f336 = str;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private StringBuilder m212() {
        StringBuilder sb = new StringBuilder();
        String str = this.f332;
        if (str != null && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            sb.append(this.f332);
        } else {
            sb.append(ServerConfigHandler.getUrl(Constants.f321));
        }
        if (this.f337 != null) {
            sb.append('/');
            sb.append(this.f337);
        }
        this.f333.put(Constants.URL_MEDIA_SOURCE, this.f336);
        sb.append('?');
        sb.append("pid=");
        sb.append(m213(this.f336, "media source"));
        String str2 = this.f334;
        if (str2 != null) {
            this.f333.put("af_referrer_uid", str2);
            sb.append('&');
            sb.append("af_referrer_uid=");
            sb.append(m213(this.f334, "referrerUID"));
        }
        String str3 = this.f329;
        if (str3 != null) {
            this.f333.put("af_channel", str3);
            sb.append('&');
            sb.append("af_channel=");
            sb.append(m213(this.f329, AppsFlyerProperties.CHANNEL));
        }
        String str4 = this.f338;
        if (str4 != null) {
            this.f333.put("af_referrer_customer_id", str4);
            sb.append('&');
            sb.append("af_referrer_customer_id=");
            sb.append(m213(this.f338, "referrerCustomerId"));
        }
        String str5 = this.f327;
        if (str5 != null) {
            this.f333.put(Constants.URL_CAMPAIGN, str5);
            sb.append('&');
            sb.append("c=");
            sb.append(m213(this.f327, "campaign"));
        }
        String str6 = this.f339;
        if (str6 != null) {
            this.f333.put("af_referrer_name", str6);
            sb.append('&');
            sb.append("af_referrer_name=");
            sb.append(m213(this.f339, "referrerName"));
        }
        String str7 = this.f328;
        if (str7 != null) {
            this.f333.put("af_referrer_image_url", str7);
            sb.append('&');
            sb.append("af_referrer_image_url=");
            sb.append(m213(this.f328, "referrerImageURL"));
        }
        if (this.f330 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f330);
            sb2.append(this.f330.endsWith("/") ? "" : "/");
            String str8 = this.f340;
            if (str8 != null) {
                sb2.append(str8);
            }
            this.f333.put("af_dp", sb2.toString());
            sb.append('&');
            sb.append("af_dp=");
            sb.append(m213(this.f330, "baseDeeplink"));
            if (this.f340 != null) {
                sb.append(this.f330.endsWith("/") ? "" : "%2F");
                sb.append(m213(this.f340, "deeplinkPath"));
            }
        }
        for (String str9 : this.f331.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str9);
            sb3.append("=");
            sb3.append(m213(this.f331.get(str9), str9));
            if (!obj.contains(sb3.toString())) {
                sb.append('&');
                sb.append(str9);
                sb.append('=');
                sb.append(m213(this.f331.get(str9), str9));
            }
        }
        return sb;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static String m213(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afInfoLog(sb.toString());
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.f331.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.f331.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        return m212().toString();
    }

    public String getBrandDomain() {
        return this.f335;
    }

    public String getCampaign() {
        return this.f327;
    }

    public String getChannel() {
        return this.f329;
    }

    public String getMediaSource() {
        return this.f336;
    }

    public Map<String, String> getParameters() {
        return this.f331;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.f330 = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.f332 = String.format("https://%s/%s", ServerConfigHandler.getUrl("%sapp.%s"), str3);
        } else {
            this.f332 = String.format("https://%s/%s", (str2 == null || str2.length() < 5) ? "go.onelink.me" : "go.onelink.me", str);
        }
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.f335 = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.f327 = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.f329 = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.f340 = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.f338 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.f328 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.f339 = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.f334 = str;
        return this;
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.f331.isEmpty()) {
            for (Map.Entry<String, String> entry : this.f331.entrySet()) {
                this.f333.put(entry.getKey(), entry.getValue());
            }
        }
        m212();
        String str = this.f335;
        Map<String, String> map = this.f333;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, AppsFlyerLibCore.getInstance(), context, AppsFlyerLib.getInstance().isTrackingStopped());
        createOneLinkHttpTask.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        createOneLinkHttpTask.setListener(responseListener);
        createOneLinkHttpTask.setBrandDomain(str);
        AFExecutor.getInstance().getThreadPoolExecutor().execute(createOneLinkHttpTask);
    }
}
package com.appsflyer.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.appsflyer.internal.am;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public class CrossPromotionHelper {

    /* renamed from: ɩ  reason: contains not printable characters */
    private static String f322 = "https://%simpression.%s";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private final WeakReference<Context> f323;

        /* renamed from: ǃ  reason: contains not printable characters */
        private final String f324;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final boolean f325;

        /* renamed from: Ι  reason: contains not printable characters */
        private final am f326;

        a(String str, am amVar, Context context, boolean z) {
            this.f324 = str;
            this.f326 = amVar;
            this.f323 = new WeakReference<>(context);
            this.f325 = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HttpURLConnection httpURLConnection;
            Throwable th;
            if (this.f325) {
                return;
            }
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f324).openConnection()));
            } catch (Throwable th2) {
                httpURLConnection = null;
                th = th2;
            }
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(false);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    StringBuilder sb = new StringBuilder("Cross promotion impressions success: ");
                    sb.append(this.f324);
                    AFLogger.afInfoLog(sb.toString(), false);
                } else if (responseCode != 301 && responseCode != 302) {
                    StringBuilder sb2 = new StringBuilder("call to ");
                    sb2.append(this.f324);
                    sb2.append(" failed: ");
                    sb2.append(responseCode);
                    AFLogger.afInfoLog(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder("Cross promotion redirection success: ");
                    sb3.append(this.f324);
                    AFLogger.afInfoLog(sb3.toString(), false);
                    if (this.f326 != null && this.f323.get() != null) {
                        this.f326.f209 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        am amVar = this.f326;
                        Context context = this.f323.get();
                        if (amVar.f209 != null) {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(amVar.f209)).setFlags(268435456));
                        }
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th3) {
                th = th3;
                try {
                    AFLogger.afErrorLog(th.getMessage(), th, true);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }
    }

    public static void trackAndOpenStore(Context context, String str, String str2) {
        trackAndOpenStore(context, str, str2, null);
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2) {
        trackCrossPromoteImpression(context, str, str2, null);
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static LinkGenerator m211(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.f332 = str3;
        linkGenerator.f337 = str;
        linkGenerator.addParameter(Constants.URL_SITE_ID, context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }

    public static void trackAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator m211 = m211(context, str, str2, map, ServerConfigHandler.getUrl(Constants.f321));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("af_campaign", str2);
        AppsFlyerLib.getInstance().trackEvent(context, "af_cross_promotion", map);
        new Thread(new a(m211.generateLink(), new am(), context, AppsFlyerLib.getInstance().isTrackingStopped())).start();
    }

    public static void trackCrossPromoteImpression(Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, Promote Impression is disabled", true);
        } else {
            new Thread(new a(m211(context, str, str2, map, ServerConfigHandler.getUrl(f322)).generateLink(), null, null, AppsFlyerLib.getInstance().isTrackingStopped())).start();
        }
    }
}
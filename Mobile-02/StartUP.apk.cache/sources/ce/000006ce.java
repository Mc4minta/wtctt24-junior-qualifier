package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public class AFDeepLinkManager {
    public static AFDeepLinkManager instance;
    public static Uri trampolineUri;

    /* renamed from: ı  reason: contains not printable characters */
    public static String[] f0;

    /* renamed from: ǃ  reason: contains not printable characters */
    static String[] f1;

    /* renamed from: ɩ  reason: contains not printable characters */
    static volatile boolean f2;

    /* renamed from: Ι  reason: contains not printable characters */
    static final int f3 = (int) TimeUnit.SECONDS.toMillis(2);

    private AFDeepLinkManager() {
    }

    public static AFDeepLinkManager getInstance() {
        if (instance == null) {
            instance = new AFDeepLinkManager();
        }
        return instance;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static boolean m1(String str) {
        String[] strArr;
        if (f1 == null || str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate ESP URLs :");
        sb.append(Arrays.asList(f1));
        AFLogger.afRDLog(sb.toString());
        for (String str2 : f1) {
            if (str.contains("://".concat(String.valueOf(str2)))) {
                AFLogger.afRDLog("Deeplink matches ESP domain: ".concat(String.valueOf(str2)));
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static void m2(Intent intent, Context context, Map<String, Object> map) {
        Uri data = (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) ? null : intent.getData();
        if (data != null) {
            if (!intent.hasExtra("af_consumed")) {
                intent.putExtra("af_consumed", System.currentTimeMillis());
                m3(context, map, data);
                return;
            }
            StringBuilder sb = new StringBuilder("skipping re-use of previously consumed deep link: ");
            sb.append(data.toString());
            sb.append(" w/af_consumed");
            AFLogger.afInfoLog(sb.toString());
        } else if (trampolineUri != null) {
            StringBuilder sb2 = new StringBuilder("using trampoline Intent fallback with URI: ");
            sb2.append(trampolineUri);
            AFLogger.afInfoLog(sb2.toString());
            m3(context, map, trampolineUri);
        } else if (AppsFlyerLibCore.getInstance().latestDeepLink != null) {
            StringBuilder sb3 = new StringBuilder("using Unity/plugin Intent fallback with URI: ");
            sb3.append(AppsFlyerLibCore.getInstance().latestDeepLink.toString());
            AFLogger.afInfoLog(sb3.toString());
            m3(context, map, AppsFlyerLibCore.getInstance().latestDeepLink);
        } else {
            AFLogger.afDebugLog("No deep link detected");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public static void m3(final Context context, final Map<String, Object> map, final Uri uri) {
        if (m1(uri.toString())) {
            f2 = true;
            AFExecutor aFExecutor = AFExecutor.getInstance();
            if (aFExecutor.f25 == null) {
                aFExecutor.f25 = Executors.newSingleThreadScheduledExecutor(aFExecutor.f24);
            }
            aFExecutor.f25.execute(new Runnable() { // from class: com.appsflyer.AFDeepLinkManager.5
                @Override // java.lang.Runnable
                public final void run() {
                    long currentTimeMillis;
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Uri uri2 = null;
                    try {
                        StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
                        sb.append(uri.toString());
                        AFLogger.afDebugLog(sb.toString());
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
                        httpURLConnection.setInstanceFollowRedirects(false);
                        int i2 = AFDeepLinkManager.f3;
                        httpURLConnection.setReadTimeout(i2);
                        httpURLConnection.setConnectTimeout(i2);
                        httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                        httpURLConnection.connect();
                        AFLogger.afDebugLog("ESP deeplink resolving is finished");
                        hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
                        if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() <= 305) {
                            uri2 = Uri.parse(httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
                        }
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        hashMap.put("error", th.getLocalizedMessage());
                        hashMap.put("status", "-1");
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                    hashMap.put("latency", Long.toString(currentTimeMillis));
                    if (uri2 != null) {
                        hashMap.put("res", uri2.toString());
                    } else {
                        hashMap.put("res", "");
                    }
                    synchronized (map) {
                        map.put("af_deeplink_r", hashMap);
                        map.put("af_deeplink", uri.toString());
                    }
                    AFDeepLinkManager.f2 = false;
                    if (uri2 == null) {
                        uri2 = uri;
                    }
                    AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri2);
                }
            });
        } else {
            AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri);
        }
        trampolineUri = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void collectIntentsFromActivities(Intent intent) {
        if (((intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) ? null : intent.getData()) == null || intent.getData() == trampolineUri) {
            return;
        }
        trampolineUri = intent.getData();
    }
}
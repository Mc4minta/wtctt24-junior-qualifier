package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFDeepLinkManager;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ab extends OneLinkHttpTask {

    /* renamed from: Ι  reason: contains not printable characters */
    private static List<String> f163 = Arrays.asList("onelink.me", "onelnk.com", "app.aflink.com");

    /* renamed from: ı  reason: contains not printable characters */
    private String f164;

    /* renamed from: ǃ  reason: contains not printable characters */
    private String f165;

    /* renamed from: ι  reason: contains not printable characters */
    public b f166;

    /* loaded from: classes.dex */
    public interface b {
        /* renamed from: ı */
        void mo108(String str);

        /* renamed from: ɩ */
        void mo109(Map<String, String> map);
    }

    public ab(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        super(appsFlyerLibCore);
        String[] strArr;
        if (TextUtils.isEmpty(uri.getHost()) || TextUtils.isEmpty(uri.getPath())) {
            return;
        }
        boolean z = false;
        for (String str : f163) {
            if (uri.getHost().contains(str)) {
                z = true;
            }
        }
        if (AFDeepLinkManager.f0 != null) {
            StringBuilder sb = new StringBuilder("Validate custom domain URLs: ");
            sb.append(Arrays.asList(AFDeepLinkManager.f0));
            AFLogger.afRDLog(sb.toString());
            for (String str2 : AFDeepLinkManager.f0) {
                if (uri.getHost().contains(str2) && str2 != "") {
                    StringBuilder sb2 = new StringBuilder("DeepLink matches customDomain: ");
                    sb2.append(uri.toString());
                    AFLogger.afDebugLog(sb2.toString());
                    z = true;
                }
            }
        }
        String[] split = uri.getPath().split("/");
        if (z && split.length == 3) {
            this.oneLinkId = split[1];
            this.f165 = split[2];
            this.f164 = uri.toString();
        }
    }

    @Override // com.appsflyer.OneLinkHttpTask
    public final String getOneLinkUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append("/");
        sb.append(this.oneLinkId);
        sb.append("?id=");
        sb.append(this.f165);
        return sb.toString();
    }

    @Override // com.appsflyer.OneLinkHttpTask
    public final void handleResponse(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.f166.mo109(hashMap);
        } catch (JSONException e2) {
            this.f166.mo108("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    @Override // com.appsflyer.OneLinkHttpTask
    public final void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
    }

    @Override // com.appsflyer.OneLinkHttpTask
    public final void onErrorResponse() {
        String str = this.f164;
        if (str == null) {
            str = "Can't get one link data";
        }
        this.f166.mo108(str);
    }

    /* renamed from: ι  reason: contains not printable characters */
    public final boolean m120() {
        return (TextUtils.isEmpty(this.oneLinkId) || TextUtils.isEmpty(this.f165) || this.oneLinkId.equals("app")) ? false : true;
    }
}
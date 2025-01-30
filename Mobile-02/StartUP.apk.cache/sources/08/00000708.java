package com.appsflyer;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract class OneLinkHttpTask implements Runnable {
    static final String BASE_URL = "https://%sonelink.%s/shortlink-sdk/v1";
    static final String NO_CONNECTION_ERROR_MSG = "Can't get one link data";
    private static final int WAIT_TIMEOUT = 3000;
    private AppsFlyerLibCore afLib;
    private HttpsUrlConnectionProvider connectionProvider;
    public String oneLinkId;

    /* loaded from: classes.dex */
    public static class HttpsUrlConnectionProvider {
        /* renamed from: ǃ  reason: contains not printable characters */
        final HttpsURLConnection m113(String str) throws IOException {
            return (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        }
    }

    public OneLinkHttpTask(AppsFlyerLibCore appsFlyerLibCore) {
        this.afLib = appsFlyerLibCore;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doRequest() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String r3 = r7.getOneLinkUrl()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "oneLinkUrl: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            com.appsflyer.OneLinkHttpTask$HttpsUrlConnectionProvider r4 = r7.connectionProvider     // Catch: java.lang.Throwable -> L7b
            javax.net.ssl.HttpsURLConnection r4 = r4.m113(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "content-type"
            java.lang.String r6 = "application/json"
            r4.addRequestProperty(r5, r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "authorization"
            java.lang.String r6 = com.appsflyer.internal.z.m210(r1)     // Catch: java.lang.Throwable -> L7b
            r4.addRequestProperty(r5, r6)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "af-timestamp"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L7b
            r4.addRequestProperty(r5, r1)     // Catch: java.lang.Throwable -> L7b
            r1 = 3000(0xbb8, float:4.204E-42)
            r4.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L7b
            r4.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L7b
            r7.initRequest(r4)     // Catch: java.lang.Throwable -> L7b
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L7b
            com.appsflyer.AppsFlyerLibCore r2 = r7.afLib     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = r2.m99(r4)     // Catch: java.lang.Throwable -> L7b
            r4 = 200(0xc8, float:2.8E-43)
            if (r1 != r4) goto L5f
            java.lang.String r1 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch: java.lang.Throwable -> L79
            goto Lad
        L5f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r0.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "Response code = "
            r0.append(r4)     // Catch: java.lang.Throwable -> L79
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = " content = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            r0.append(r2)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L79
            goto Lad
        L79:
            r0 = move-exception
            goto L7e
        L7b:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L7e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Error while calling "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afErrorLog(r1, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = " stacktrace: "
            r1.append(r3)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Lad:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lcb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Connection call succeeded: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            r7.handleResponse(r2)
            goto Le2
        Lcb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Connection error: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.appsflyer.AFLogger.afWarnLog(r0)
            r7.onErrorResponse()
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.OneLinkHttpTask.doRequest():void");
    }

    protected abstract String getOneLinkUrl();

    protected abstract void handleResponse(String str);

    protected abstract void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    protected abstract void onErrorResponse();

    @Override // java.lang.Runnable
    public void run() {
        doRequest();
    }

    public void setConnProvider(HttpsUrlConnectionProvider httpsUrlConnectionProvider) {
        this.connectionProvider = httpsUrlConnectionProvider;
    }
}
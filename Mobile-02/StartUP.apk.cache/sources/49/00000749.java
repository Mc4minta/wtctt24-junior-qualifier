package com.appsflyer.internal.referrer;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLibCore;
import e.c.a.a.a;
import e.c.a.a.c;
import e.c.a.a.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GoogleReferrer {
    public final Map<String, Object> oldMap = new HashMap();
    public final Map<String, Object> newMap = new HashMap();

    public static boolean allow(AppsFlyerLibCore appsFlyerLibCore, Context context) {
        if (appsFlyerLibCore.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(context), false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("e.c.a.a.a");
            if (AndroidUtils.isPermissionAvailable(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public void start(Context context, final Runnable runnable) {
        try {
            final a a = a.d(context).a();
            AFLogger.afDebugLog("Connecting to Install Referrer Library...");
            a.e(new c() { // from class: com.appsflyer.internal.referrer.GoogleReferrer.1
                @Override // e.c.a.a.c
                public final void onInstallReferrerServiceDisconnected() {
                    AFLogger.afDebugLog("Install Referrer service disconnected");
                }

                @Override // e.c.a.a.c
                public final void onInstallReferrerSetupFinished(int i2) {
                    GoogleReferrer.this.oldMap.put("code", String.valueOf(i2));
                    GoogleReferrer.this.newMap.put(Payload.SOURCE, Payload.SOURCE_GOOGLE);
                    GoogleReferrer.this.newMap.putAll(new MandatoryFields());
                    if (i2 == -1) {
                        AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_SERVICE_DISCONNECTED);
                    } else if (i2 == 0) {
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_OK);
                        try {
                            AFLogger.afDebugLog("InstallReferrer connected");
                            if (a.c()) {
                                d b2 = a.b();
                                String c2 = b2.c();
                                if (c2 != null) {
                                    GoogleReferrer.this.oldMap.put("val", c2);
                                    GoogleReferrer.this.newMap.put(Payload.REFERRER, c2);
                                }
                                long d2 = b2.d();
                                GoogleReferrer.this.oldMap.put("clk", Long.toString(d2));
                                GoogleReferrer.this.newMap.put(Payload.CLICK_TS, Long.valueOf(d2));
                                long b3 = b2.b();
                                GoogleReferrer.this.oldMap.put("install", Long.toString(b3));
                                GoogleReferrer.this.newMap.put(Payload.INSTALL_BEGIN_TS, Long.valueOf(b3));
                                try {
                                    GoogleReferrer.this.oldMap.put(Payload.INSTANT, Boolean.valueOf(b2.a()));
                                } catch (NoSuchMethodError unused) {
                                }
                            } else {
                                AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                                GoogleReferrer.this.oldMap.put("err", "ReferrerClient: InstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                            sb.append(th.getMessage());
                            AFLogger.afWarnLog(sb.toString());
                            GoogleReferrer.this.oldMap.put("err", th.getMessage());
                        }
                    } else if (i2 == 1) {
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_SERVICE_UNAVAILABLE);
                        AFLogger.afWarnLog("InstallReferrer not supported");
                    } else if (i2 == 2) {
                        AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_FEATURE_NOT_SUPPORTED);
                    } else if (i2 != 3) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_DEVELOPER_ERROR);
                    }
                    AFLogger.afDebugLog("Install Referrer collected locally");
                    runnable.run();
                    a.a();
                }
            });
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }
}
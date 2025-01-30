package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.c;

/* loaded from: classes.dex */
public final class af {
    af() {
    }

    /* renamed from: ı  reason: contains not printable characters */
    public static void m126(Context context, String str) {
        String str2;
        if (str != null) {
            AFLogger.afInfoLog("updateServerUninstallToken called with: ".concat(str));
            c.a.C0099c m172 = c.a.C0099c.m172(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            SharedPreferences sharedPreferences = AppsFlyerLibCore.getSharedPreferences(context);
            if (sharedPreferences.getBoolean("sentRegisterRequestToAF", false) && (str2 = m172.f235) != null && str2.equals(str)) {
                return;
            }
            AppsFlyerProperties.getInstance().set("afUninstallToken", str);
            if (AppsFlyerLibCore.m47(sharedPreferences)) {
                AppsFlyerLibCore.getInstance().m103(context, str);
            }
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static boolean m127(Context context) {
        if (AppsFlyerLib.getInstance().isTrackingStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
        if (AndroidUtils.m34(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class))) {
            return true;
        }
        AFLogger.afWarnLog("Cannot verify existence of our InstanceID Listener Service in the manifest. Please refer to documentation.");
        return false;
    }
}
package com.dieam.reactnativepushnotification.modules;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* compiled from: RNPushNotificationConfig.java */
/* loaded from: classes2.dex */
class c {
    private static Bundle a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4476b;

    public c(Context context) {
        this.f4476b = context;
        if (a == null) {
            try {
                a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                Log.e(RNPushNotification.LOG_TAG, "Error reading application meta, falling back to defaults");
                a = new Bundle();
            }
        }
    }

    private String c(String str, String str2) {
        try {
            String string = a.getString(str);
            if (string != null) {
                if (string.length() > 0) {
                    return string;
                }
            }
        } catch (Exception unused) {
            Log.w(RNPushNotification.LOG_TAG, "Unable to find " + str + " in manifest. Falling back to default");
        }
        return str2;
    }

    public int a() {
        try {
            return androidx.core.content.d.f.a(this.f4476b.getResources(), a.getInt("com.dieam.reactnativepushnotification.notification_color"), null);
        } catch (Exception unused) {
            Log.w(RNPushNotification.LOG_TAG, "Unable to find com.dieam.reactnativepushnotification.notification_color in manifest. Falling back to default");
            return -1;
        }
    }

    public String b() {
        try {
            return c("com.dieam.reactnativepushnotification.default_notification_channel_id", c("com.google.firebase.messaging.default_notification_channel_id", "fcm_fallback_notification_channel"));
        } catch (Exception unused) {
            Log.w(RNPushNotification.LOG_TAG, "Unable to find com.dieam.reactnativepushnotification.default_notification_channel_id in manifest. Falling back to default");
            return "fcm_fallback_notification_channel";
        }
    }
}
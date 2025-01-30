package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.a;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class r {
    private static final com.google.firebase.encoders.a a = new com.google.firebase.encoders.g.d().a(a.C0192a.class, new a.c()).a(a.class, new a.b()).f();

    public static void a(Intent intent) {
        if (intent != null) {
            if (DiskLruCache.VERSION_1.equals(intent.getStringExtra("google.c.a.tc"))) {
                com.google.firebase.analytics.a.a aVar = (com.google.firebase.analytics.a.a) com.google.firebase.c.h().f(com.google.firebase.analytics.a.a.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aVar.f("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(Payload.SOURCE, "Firebase");
                    bundle.putString(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, "notification");
                    bundle.putString("campaign", stringExtra);
                    aVar.c("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        c("_no", intent);
    }

    public static void b(Intent intent, e.g.a.c.f<String> fVar) {
        c("_nr", intent);
        if (fVar != null) {
            try {
                fVar.a(e.g.a.c.c.d(a.b(new a.C0192a(new a("MESSAGE_DELIVERED", intent)))));
            } catch (EncodingException unused) {
                Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
            }
        }
    }

    private static void c(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String r = r(intent);
        if (r != null) {
            bundle.putString("_nt", r);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e2);
            }
        }
        String stringExtra6 = intent.hasExtra("google.c.a.udt") ? intent.getStringExtra("google.c.a.udt") : null;
        if (stringExtra6 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(stringExtra6));
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e3);
            }
        }
        String str2 = (intent.getExtras() == null || !t.d(intent.getExtras())) ? "data" : "display";
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str2);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + valueOf.length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        com.google.firebase.analytics.a.a aVar = (com.google.firebase.analytics.a.a) com.google.firebase.c.h().f(com.google.firebase.analytics.a.a.class);
        if (aVar != null) {
            aVar.c("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    static boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            com.google.firebase.c.h();
            Context g2 = com.google.firebase.c.h().g();
            SharedPreferences sharedPreferences = g2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = g2.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(g2.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        return com.google.firebase.c.h().g().getPackageName();
    }

    public static void f(Intent intent) {
        c("_nd", intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return FirebaseInstanceId.getInstance(com.google.firebase.c.h()).b();
    }

    public static void h(Intent intent) {
        c("_nf", intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        com.google.firebase.c h2 = com.google.firebase.c.h();
        String d2 = h2.j().d();
        if (d2 != null) {
            return d2;
        }
        String c2 = h2.j().c();
        if (c2.startsWith("1:")) {
            String[] split = c2.split(":");
            if (split.length < 2) {
                return null;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return null;
            }
            return str;
        }
        return c2;
    }

    public static boolean j(Intent intent) {
        if (intent == null || t(intent)) {
            return false;
        }
        return DiskLruCache.VERSION_1.equals(intent.getStringExtra("google.c.a.e"));
    }

    public static boolean k(Intent intent) {
        if (intent == null || t(intent)) {
            return false;
        }
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 13);
                sb.append("Invalid TTL: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString());
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q(Intent intent) {
        return (intent.getExtras() == null || !t.d(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String r(Intent intent) {
        String stringExtra = intent.getStringExtra(ApiConstants.FROM);
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if (DiskLruCache.VERSION_1.equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        if (RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH.equals(stringExtra)) {
            return 1;
        }
        return "normal".equals(stringExtra) ? 2 : 0;
    }

    private static boolean t(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }
}
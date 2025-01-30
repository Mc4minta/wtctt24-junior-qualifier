package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.google.android.gms.common.internal.v0;
import com.google.android.gms.common.util.l;
import java.util.concurrent.atomic.AtomicBoolean;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class h {
    @Deprecated
    public static final int a = 12451000;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6182b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6183c;

    /* renamed from: d  reason: collision with root package name */
    static final AtomicBoolean f6184d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f6185e = new AtomicBoolean();

    @Deprecated
    public static void a(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int h2 = f.f().h(context, i2);
        if (h2 != 0) {
            Intent b2 = f.f().b(context, h2, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(h2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (b2 == null) {
                throw new GooglePlayServicesNotAvailableException(h2);
            }
            throw new GooglePlayServicesRepairableException(h2, "Google Play Services not available", b2);
        }
    }

    @Deprecated
    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static String c(int i2) {
        return b.n1(i2);
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!f6183c) {
                PackageInfo e2 = com.google.android.gms.common.n.c.a(context).e("com.google.android.gms", 64);
                i.a(context);
                if (e2 != null && !i.f(e2, false) && i.f(e2, true)) {
                    f6182b = true;
                } else {
                    f6182b = false;
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
        } finally {
            f6183c = true;
        }
        return f6182b || !com.google.android.gms.common.util.i.a();
    }

    @Deprecated
    public static int g(Context context, int i2) {
        try {
            context.getResources().getString(j.a);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f6185e.get()) {
            int b2 = v0.b(context);
            if (b2 != 0) {
                int i3 = a;
                if (b2 != i3) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i3);
                    sb.append(" but found ");
                    sb.append(b2);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return m(context, (com.google.android.gms.common.util.i.c(context) || com.google.android.gms.common.util.i.e(context)) ? false : true, i2);
    }

    @Deprecated
    public static boolean h(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return j(context, "com.google.android.gms");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean i(Context context) {
        Bundle applicationRestrictions;
        return l.e() && (applicationRestrictions = ((UserManager) context.getSystemService(ApiConstants.USER)).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public static boolean j(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (l.h()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, PKIFailureInfo.certRevoked);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        return applicationInfo.enabled && !i(context);
    }

    @Deprecated
    public static boolean k(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean l(Context context, int i2, String str) {
        return com.google.android.gms.common.util.o.b(context, i2, str);
    }

    private static int m(Context context, boolean z, int i2) {
        com.google.android.gms.common.internal.t.a(i2 >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            i.a(context);
            if (!i.f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            } else if (z && (!i.f(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
            } else if (com.google.android.gms.common.util.s.a(packageInfo2.versionCode) < com.google.android.gms.common.util.s.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }
}
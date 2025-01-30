package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public final class s {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: ı  reason: contains not printable characters */
        public final String f292;

        /* renamed from: ɩ  reason: contains not printable characters */
        public final String f293;

        /* renamed from: ι  reason: contains not printable characters */
        public final String f294;

        a(String str, String str2, String str3) {
            this.f292 = str;
            this.f293 = str2;
            this.f294 = str3;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: ι  reason: contains not printable characters */
        public static final s f295 = new s();
    }

    s() {
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static a m192(Context context) {
        String str;
        String str2;
        String str3 = "unknown";
        String str4 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                int i2 = 0;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i2]);
                        if (!m193(networkInfo)) {
                            i2++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else {
                    if (!m193(connectivityManager.getNetworkInfo(1))) {
                        if (!m193(connectivityManager.getNetworkInfo(0))) {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (m193(activeNetworkInfo)) {
                                if (1 != activeNetworkInfo.getType()) {
                                    if (activeNetworkInfo.getType() == 0) {
                                    }
                                }
                            }
                        }
                        str3 = "MOBILE";
                    }
                    str3 = "WIFI";
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str2 = telephonyManager.getSimOperatorName();
            try {
                str4 = telephonyManager.getNetworkOperatorName();
                if (str4 == null || str4.isEmpty()) {
                    if (2 == telephonyManager.getPhoneType()) {
                        str4 = "CDMA";
                    }
                }
            } catch (Throwable th) {
                th = th;
                str = str4;
                str4 = str2;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                String str5 = str;
                str2 = str4;
                str4 = str5;
                return new a(str3, str4, str2);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        return new a(str3, str4, str2);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m193(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
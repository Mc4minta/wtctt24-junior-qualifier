package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.w;

/* loaded from: classes.dex */
public final class v {

    /* loaded from: classes.dex */
    static class a extends IllegalStateException {
        a(String str) {
            super(str);
        }
    }

    v() {
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public static w m198(ContentResolver contentResolver) {
        String str;
        if (contentResolver != null && AppsFlyerProperties.getInstance().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            int i2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i2 == 0) {
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                w.e eVar = w.e.AMAZON;
                return new w(string, false);
            } else if (i2 == 2) {
                return null;
            } else {
                try {
                    str = Settings.Secure.getString(contentResolver, "advertising_id");
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                    str = "";
                }
                w.e eVar2 = w.e.AMAZON;
                return new w(str, true);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r8.length() == 0) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* renamed from: ι  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m199(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.v.m199(android.content.Context, java.util.Map):void");
    }
}
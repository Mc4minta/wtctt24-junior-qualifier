package com.bugsnag.android;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* compiled from: ConfigFactory.java */
/* loaded from: classes.dex */
class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static s a(Context context, String str, boolean z) {
        Context applicationContext = context.getApplicationContext();
        boolean isEmpty = TextUtils.isEmpty(str);
        if (isEmpty) {
            try {
                str = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.bugsnag.android.API_KEY");
            } catch (Exception unused) {
                q0.d("Bugsnag is unable to read api key from manifest.");
            }
        }
        Objects.requireNonNull(str, "You must provide a Bugsnag API key");
        s sVar = new s(str);
        sVar.M(z);
        if (isEmpty) {
            try {
                b(sVar, applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData);
            } catch (Exception unused2) {
                q0.d("Bugsnag is unable to read config from manifest.");
            }
        }
        return sVar;
    }

    static void b(s sVar, Bundle bundle) {
        sVar.H(bundle.getString("com.bugsnag.android.BUILD_UUID"));
        sVar.E(bundle.getString("com.bugsnag.android.APP_VERSION"));
        sVar.T(bundle.getString("com.bugsnag.android.RELEASE_STAGE"));
        if (bundle.containsKey("com.bugsnag.android.ENDPOINT")) {
            sVar.O(bundle.getString("com.bugsnag.android.ENDPOINT"), bundle.getString("com.bugsnag.android.SESSIONS_ENDPOINT"));
        }
        sVar.U(bundle.getBoolean("com.bugsnag.android.SEND_THREADS", true));
        sVar.R(bundle.getBoolean("com.bugsnag.android.PERSIST_USER_BETWEEN_SESSIONS", false));
        if (bundle.containsKey("com.bugsnag.android.DETECT_NDK_CRASHES")) {
            sVar.L(bundle.getBoolean("com.bugsnag.android.DETECT_NDK_CRASHES"));
        }
        if (bundle.containsKey("com.bugsnag.android.DETECT_ANRS")) {
            sVar.K(bundle.getBoolean("com.bugsnag.android.DETECT_ANRS"));
        }
        if (bundle.containsKey("com.bugsnag.android.AUTO_CAPTURE_SESSIONS")) {
            sVar.F(bundle.getBoolean("com.bugsnag.android.AUTO_CAPTURE_SESSIONS"));
        }
        sVar.M(bundle.getBoolean("com.bugsnag.android.ENABLE_EXCEPTION_HANDLER", true));
    }
}
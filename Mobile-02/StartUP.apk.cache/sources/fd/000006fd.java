package com.appsflyer;

import com.appsflyer.internal.af;
import com.appsflyer.internal.c;
import com.google.firebase.messaging.FirebaseMessagingService;

/* loaded from: classes.dex */
public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(str));
            c.a.C0099c m172 = c.a.C0099c.m172(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            c.a.C0099c c0099c = new c.a.C0099c(currentTimeMillis, str);
            if (m172.m175(c0099c)) {
                af.m126(getApplicationContext(), c0099c.f235);
            }
        }
    }
}
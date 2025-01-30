package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t4 {
    final b5 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t4(b5 b5Var) {
        this.a = b5Var;
    }

    private final boolean c() {
        try {
            com.google.android.gms.common.n.b a = com.google.android.gms.common.n.c.a(this.a.h());
            if (a != null) {
                return a.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.f().P().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            this.a.f().P().b("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle a(String str, com.google.android.gms.internal.measurement.k2 k2Var) {
        this.a.l().d();
        if (k2Var == null) {
            this.a.f().K().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle g2 = k2Var.g(bundle);
            if (g2 == null) {
                this.a.f().H().a("Install Referrer Service returned a null response");
                return null;
            }
            return g2;
        } catch (Exception e2) {
            this.a.f().H().b("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null && !str.isEmpty()) {
            this.a.l().d();
            if (!c()) {
                this.a.f().N().a("Install Referrer Reporter is not available");
                return;
            }
            s4 s4Var = new s4(this, str);
            this.a.l().d();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.a.h().getPackageManager();
            if (packageManager == null) {
                this.a.f().L().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                return;
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.packageName;
                    if (serviceInfo.name != null && "com.android.vending".equals(str2) && c()) {
                        try {
                            this.a.f().P().b("Install Referrer Service is", com.google.android.gms.common.stats.a.b().a(this.a.h(), new Intent(intent), s4Var, 1) ? "available" : "not available");
                            return;
                        } catch (Exception e2) {
                            this.a.f().H().b("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                            return;
                        }
                    }
                    this.a.f().K().a("Play Store version 8.3.73 or higher required for Install Referrer");
                    return;
                }
                return;
            }
            this.a.f().N().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        this.a.f().L().a("Install Referrer Reporter was called with invalid app package name");
    }
}
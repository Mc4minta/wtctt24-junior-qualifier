package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class i {
    private static i a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6186b;

    private i(Context context) {
        this.f6186b = context.getApplicationContext();
    }

    public static i a(Context context) {
        com.google.android.gms.common.internal.t.k(context);
        synchronized (i.class) {
            if (a == null) {
                q.c(context);
                a = new i(context);
            }
        }
        return a;
    }

    private static r d(PackageInfo packageInfo, r... rVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        u uVar = new u(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            if (rVarArr[i2].equals(uVar)) {
                return rVarArr[i2];
            }
        }
        return null;
    }

    private final z e(String str, int i2) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo h2 = com.google.android.gms.common.n.c.a(this.f6186b).h(str, 64, i2);
            boolean f2 = h.f(this.f6186b);
            if (h2 == null) {
                return z.d("null pkg");
            }
            Signature[] signatureArr = h2.signatures;
            if (signatureArr != null && signatureArr.length == 1) {
                u uVar = new u(h2.signatures[0].toByteArray());
                String str2 = h2.packageName;
                z a2 = q.a(str2, uVar, f2, false);
                return (!a2.f6346b || (applicationInfo = h2.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !q.a(str2, uVar, false, true).f6346b) ? a2 : z.d("debuggable release cert app rejected");
            }
            return z.d("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return z.d(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean f(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? d(packageInfo, w.a) : d(packageInfo, w.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (h.f(this.f6186b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i2) {
        z d2;
        String[] f2 = com.google.android.gms.common.n.c.a(this.f6186b).f(i2);
        if (f2 == null || f2.length == 0) {
            d2 = z.d("no pkgs");
        } else {
            d2 = null;
            for (String str : f2) {
                d2 = e(str, i2);
                if (d2.f6346b) {
                    break;
                }
            }
        }
        d2.g();
        return d2.f6346b;
    }
}
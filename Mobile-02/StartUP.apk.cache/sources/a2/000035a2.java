package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v1 {
    private static volatile g2<Boolean> a = g2.d();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7370b = new Object();

    private static boolean a(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
    }

    public static boolean b(Context context, Uri uri) {
        ProviderInfo resolveContentProvider;
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        } else if (a.b()) {
            return a.c().booleanValue();
        } else {
            synchronized (f7370b) {
                if (a.b()) {
                    return a.c().booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName()) && ((resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) == null || !"com.google.android.gms".equals(resolveContentProvider.packageName))) {
                    z = false;
                    if (z && a(context)) {
                        z2 = true;
                    }
                    a = g2.a(Boolean.valueOf(z2));
                    return a.c().booleanValue();
                }
                z = true;
                if (z) {
                    z2 = true;
                }
                a = g2.a(Boolean.valueOf(z2));
                return a.c().booleanValue();
            }
        }
    }
}
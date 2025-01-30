package com.google.firebase.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.e.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes2.dex */
public class a {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f9105b;

    /* renamed from: c  reason: collision with root package name */
    private final c f9106c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f9107d = new AtomicBoolean(c());

    public a(Context context, String str, c cVar) {
        this.a = a(context);
        this.f9105b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f9106c = cVar;
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || androidx.core.content.a.j(context)) ? context : androidx.core.content.a.b(context);
    }

    private boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (this.f9105b.contains("firebase_data_collection_default_enabled")) {
            return this.f9105b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    public boolean b() {
        return this.f9107d.get();
    }
}
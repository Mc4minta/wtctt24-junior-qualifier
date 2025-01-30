package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class q {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private String f9179b;

    /* renamed from: c  reason: collision with root package name */
    private String f9180c;

    /* renamed from: d  reason: collision with root package name */
    private int f9181d;

    /* renamed from: e  reason: collision with root package name */
    private int f9182e = 0;

    public q(Context context) {
        this.a = context;
    }

    private final PackageInfo a(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public static String b(com.google.firebase.c cVar) {
        String d2 = cVar.j().d();
        if (d2 != null) {
            return d2;
        }
        String c2 = cVar.j().c();
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

    private final synchronized void h() {
        PackageInfo a = a(this.a.getPackageName());
        if (a != null) {
            this.f9179b = Integer.toString(a.versionCode);
            this.f9180c = a.versionName;
        }
    }

    public final boolean c() {
        return d() != 0;
    }

    public final synchronized int d() {
        int i2 = this.f9182e;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!com.google.android.gms.common.util.l.j()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f9182e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f9182e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (com.google.android.gms.common.util.l.j()) {
            this.f9182e = 2;
        } else {
            this.f9182e = 1;
        }
        return this.f9182e;
    }

    public final synchronized String e() {
        if (this.f9179b == null) {
            h();
        }
        return this.f9179b;
    }

    public final synchronized String f() {
        if (this.f9180c == null) {
            h();
        }
        return this.f9180c;
    }

    public final synchronized int g() {
        PackageInfo a;
        if (this.f9181d == 0 && (a = a("com.google.android.gms")) != null) {
            this.f9181d = a.versionCode;
        }
        return this.f9181d;
    }
}
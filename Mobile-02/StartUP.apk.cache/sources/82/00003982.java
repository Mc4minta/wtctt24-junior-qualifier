package com.google.firebase.crashlytics.c.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8667b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8668c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8669d;

    /* renamed from: e  reason: collision with root package name */
    public final String f8670e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8671f;

    public b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.f8667b = str2;
        this.f8668c = str3;
        this.f8669d = str4;
        this.f8670e = str5;
        this.f8671f = str6;
    }

    public static b a(Context context, v vVar, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String e2 = vVar.e();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new b(str, str2, e2, packageName, num, str3);
    }
}
package com.google.android.gms.common;

import android.util.Log;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class z {
    private static final z a = new z(true, null, null);

    /* renamed from: b  reason: collision with root package name */
    final boolean f6346b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6347c;

    /* renamed from: d  reason: collision with root package name */
    private final Throwable f6348d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(boolean z, String str, Throwable th) {
        this.f6346b = z;
        this.f6347c = str;
        this.f6348d = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z b(String str, Throwable th) {
        return new z(false, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z c(Callable<String> callable) {
        return new b0(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z d(String str) {
        return new z(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, r rVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, com.google.android.gms.common.util.j.a(com.google.android.gms.common.util.a.b("SHA-1").digest(rVar.q())), Boolean.valueOf(z), "12451009.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z f() {
        return a;
    }

    String a() {
        return this.f6347c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (this.f6346b || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f6348d != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f6348d);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
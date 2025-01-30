package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Map;

/* compiled from: Bugsnag.java */
/* loaded from: classes.dex */
public final class j {
    private static final Object a = new Object();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    static q f3660b;

    public static void a() {
        b().e();
    }

    public static q b() {
        q qVar = f3660b;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("You must call Bugsnag.init before any other Bugsnag methods");
    }

    public static q c(Context context) {
        return f(context, null, true);
    }

    public static q d(Context context, s sVar) {
        synchronized (a) {
            if (f3660b == null) {
                f3660b = new q(context, sVar);
            } else {
                i();
            }
        }
        return f3660b;
    }

    public static q e(Context context, String str) {
        return f(context, str, true);
    }

    public static q f(Context context, String str, boolean z) {
        return d(context, r.a(context, str, z));
    }

    public static void g(Throwable th, Map<String, Object> map, boolean z, p pVar) {
        b().t(th, map, z, pVar);
    }

    public static void h(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        b().u(str, breadcrumbType, map);
    }

    private static void i() {
        q0.d("It appears that Bugsnag.init() was called more than once. Subsequent calls have no effect, but may indicate that Bugsnag is not integrated in an Application subclass, which can lead to undesired behaviour.");
    }

    public static boolean j() {
        return b().A();
    }

    public static void k(String str, String str2, String str3) {
        b().N(str, str2, str3);
    }

    public static void l() {
        b().R();
    }

    public static void m() {
        b().S();
    }
}
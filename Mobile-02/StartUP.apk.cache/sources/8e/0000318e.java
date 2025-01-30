package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@Deprecated
/* loaded from: classes2.dex */
public final class g {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static g f6112b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6113c;

    /* renamed from: d  reason: collision with root package name */
    private final Status f6114d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f6115e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6116f;

    g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(com.google.android.gms.common.j.a));
        boolean z = true;
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.f6116f = !z2;
            z = z2;
        } else {
            this.f6116f = false;
        }
        this.f6115e = z;
        String a2 = com.google.android.gms.common.internal.v0.a(context);
        a2 = a2 == null ? new com.google.android.gms.common.internal.x(context).a("google_app_id") : a2;
        if (TextUtils.isEmpty(a2)) {
            this.f6114d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f6113c = null;
            return;
        }
        this.f6113c = a2;
        this.f6114d = Status.a;
    }

    private static g a(String str) {
        g gVar;
        synchronized (a) {
            gVar = f6112b;
            if (gVar == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return gVar;
    }

    public static String b() {
        return a("getGoogleAppId").f6113c;
    }

    public static Status c(Context context) {
        Status status;
        com.google.android.gms.common.internal.t.l(context, "Context must not be null.");
        synchronized (a) {
            if (f6112b == null) {
                f6112b = new g(context);
            }
            status = f6112b.f6114d;
        }
        return status;
    }

    public static boolean d() {
        return a("isMeasurementExplicitlyDisabled").f6116f;
    }
}
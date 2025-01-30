package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m0;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class f {
    public static final int a = h.a;

    /* renamed from: b  reason: collision with root package name */
    private static final f f6180b = new f();

    public static f f() {
        return f6180b;
    }

    private static String l(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(com.google.android.gms.common.n.c.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public int a(Context context) {
        return h.b(context);
    }

    public Intent b(Context context, int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return m0.b("com.google.android.gms");
        } else if (context != null && com.google.android.gms.common.util.i.c(context)) {
            return m0.c();
        } else {
            return m0.a("com.google.android.gms", l(context, str));
        }
    }

    public PendingIntent c(Context context, int i2, int i3) {
        return d(context, i2, i3, null);
    }

    public PendingIntent d(Context context, int i2, int i3, String str) {
        Intent b2 = b(context, i2, str);
        if (b2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, b2, 134217728);
    }

    public String e(int i2) {
        return h.c(i2);
    }

    public int g(Context context) {
        return h(context, a);
    }

    public int h(Context context, int i2) {
        int g2 = h.g(context, i2);
        if (h.h(context, g2)) {
            return 18;
        }
        return g2;
    }

    public boolean i(Context context, String str) {
        return h.j(context, str);
    }

    public boolean j(int i2) {
        return h.k(i2);
    }

    public void k(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        h.a(context, i2);
    }
}
package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.coinbase.ApiConstants;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class i {
    private static Boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f6327b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f6328c;

    public static boolean a() {
        return ApiConstants.USER.equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean b(Context context) {
        if (a == null) {
            a = Boolean.valueOf(l.g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    @TargetApi(26)
    public static boolean c(Context context) {
        if (b(context)) {
            if (l.i()) {
                return d(context) && !l.j();
            }
            return true;
        }
        return false;
    }

    @TargetApi(21)
    private static boolean d(Context context) {
        if (f6327b == null) {
            f6327b = Boolean.valueOf(l.h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f6327b.booleanValue();
    }

    public static boolean e(Context context) {
        if (f6328c == null) {
            f6328c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f6328c.booleanValue();
    }
}
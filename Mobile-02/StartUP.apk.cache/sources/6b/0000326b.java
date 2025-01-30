package com.google.android.gms.internal.clearcut;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes2.dex */
public class b {
    private static volatile UserManager a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f6367b = !b();

    private b() {
    }

    public static boolean a(Context context) {
        return b() && !c(context);
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @TargetApi(24)
    private static boolean c(Context context) {
        boolean z = f6367b;
        if (!z) {
            UserManager userManager = a;
            if (userManager == null) {
                synchronized (b.class) {
                    userManager = a;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        a = userManager2;
                        if (userManager2 == null) {
                            f6367b = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                }
            }
            z = userManager.isUserUnlocked();
            f6367b = z;
            if (z) {
                a = null;
            }
        }
        return z;
    }
}
package com.google.android.gms.common.n;

import android.content.Context;
import com.google.android.gms.common.util.l;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a {
    private static Context a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f6288b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = a;
            if (context2 != null && (bool = f6288b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f6288b = null;
            if (l.j()) {
                f6288b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f6288b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f6288b = Boolean.FALSE;
                }
            }
            a = applicationContext;
            return f6288b.booleanValue();
        }
    }
}
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class v0 {
    private static Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6276b;

    /* renamed from: c  reason: collision with root package name */
    private static String f6277c;

    /* renamed from: d  reason: collision with root package name */
    private static int f6278d;

    public static String a(Context context) {
        c(context);
        return f6277c;
    }

    public static int b(Context context) {
        c(context);
        return f6278d;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (a) {
            if (f6276b) {
                return;
            }
            f6276b = true;
            try {
                bundle = com.google.android.gms.common.n.c.a(context).c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f6277c = bundle.getString("com.google.app.id");
            f6278d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
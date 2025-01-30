package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class g0 {
    private static final long a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f9163b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static e.g.a.e.i.a f9164c;

    public static ComponentName a(Context context, Intent intent) {
        synchronized (f9163b) {
            if (f9164c == null) {
                e.g.a.e.i.a aVar = new e.g.a.e.i.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                f9164c = aVar;
                aVar.c(true);
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            c(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                f9164c.a(a);
            }
            return startService;
        }
    }

    public static void b(Intent intent) {
        synchronized (f9163b) {
            if (f9164c != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                c(intent, false);
                f9164c.b();
            }
        }
    }

    private static void c(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }
}
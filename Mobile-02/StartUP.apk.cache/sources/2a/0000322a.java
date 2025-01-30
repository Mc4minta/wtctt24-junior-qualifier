package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.r;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f6317b;
    private static d a = new d();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6318c = false;

    public static d a() {
        return a;
    }

    private static void d(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(b.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e2) {
            Log.wtf("WakeLockTracker", e2);
        }
    }

    private static boolean e() {
        if (f6317b == null) {
            f6317b = Boolean.FALSE;
        }
        return f6317b.booleanValue();
    }

    public void b(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
        c(context, str, i2, str2, str3, str4, i3, list, 0L);
    }

    public void c(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j2) {
        if (e()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i2 || 8 == i2 || 10 == i2 || 11 == i2) {
                d(context, new WakeLockEvent(System.currentTimeMillis(), i2, str2, i3, c.b(list), str, SystemClock.elapsedRealtime(), r.a(context), str3, c.c(context.getPackageName()), r.b(context), j2, str4, false));
            }
        }
    }
}
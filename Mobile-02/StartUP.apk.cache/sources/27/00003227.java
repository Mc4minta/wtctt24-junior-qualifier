package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f6304b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f6305c;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f6306d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f6307e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f6308f;

    private a() {
        List<String> list = Collections.EMPTY_LIST;
        this.f6305c = list;
        this.f6306d = list;
        this.f6307e = list;
        this.f6308f = list;
    }

    public static a b() {
        if (f6304b == null) {
            synchronized (a) {
                if (f6304b == null) {
                    f6304b = new a();
                }
            }
        }
        return f6304b;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return d(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @SuppressLint({"UntrackedBindService"})
    public void c(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : com.google.android.gms.common.util.d.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }
}
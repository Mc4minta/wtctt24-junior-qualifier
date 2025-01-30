package com.bugsnag.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import kotlin.TypeCastException;

/* compiled from: ConnectivityCompat.kt */
/* loaded from: classes.dex */
public final class v implements t {
    private final ConnectivityManager a;

    /* renamed from: b  reason: collision with root package name */
    private final t f3715b;

    public v(Context context, kotlin.e0.c.l<? super Boolean, kotlin.x> lVar) {
        kotlin.jvm.internal.m.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            this.a = connectivityManager;
            this.f3715b = Build.VERSION.SDK_INT >= 24 ? new u(connectivityManager, lVar) : new w(context, connectivityManager, lVar);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @Override // com.bugsnag.android.t
    public void a() {
        this.f3715b.a();
    }

    @Override // com.bugsnag.android.t
    public boolean b() {
        return this.f3715b.b();
    }

    @Override // com.bugsnag.android.t
    public String c() {
        return this.f3715b.c();
    }
}
package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: ConnectivityCompat.kt */
/* loaded from: classes.dex */
public final class w implements t {
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3719b;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectivityManager f3720c;

    /* compiled from: ConnectivityCompat.kt */
    /* loaded from: classes.dex */
    private final class a extends BroadcastReceiver {
        private final kotlin.e0.c.l<Boolean, kotlin.x> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlin.e0.c.l<? super Boolean, kotlin.x> lVar) {
            this.a = lVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.m.h(context, "context");
            kotlin.jvm.internal.m.h(intent, "intent");
            kotlin.e0.c.l<Boolean, kotlin.x> lVar = this.a;
            if (lVar != null) {
                lVar.invoke(Boolean.valueOf(w.this.b()));
            }
        }
    }

    public w(Context context, ConnectivityManager cm, kotlin.e0.c.l<? super Boolean, kotlin.x> lVar) {
        kotlin.jvm.internal.m.h(context, "context");
        kotlin.jvm.internal.m.h(cm, "cm");
        this.f3719b = context;
        this.f3720c = cm;
        this.a = new a(lVar);
    }

    @Override // com.bugsnag.android.t
    public void a() {
        this.f3719b.registerReceiver(this.a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // com.bugsnag.android.t
    public boolean b() {
        NetworkInfo activeNetworkInfo = this.f3720c.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    @Override // com.bugsnag.android.t
    public String c() {
        NetworkInfo activeNetworkInfo = this.f3720c.getActiveNetworkInfo();
        Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        return valueOf == null ? "none" : valueOf.intValue() == 1 ? "wifi" : valueOf.intValue() == 9 ? "ethernet" : "cellular";
    }
}
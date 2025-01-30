package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: ConnectivityCompat.kt */
/* loaded from: classes.dex */
public final class u implements t {
    public volatile Network a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3712b;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectivityManager f3713c;

    /* compiled from: ConnectivityCompat.kt */
    /* loaded from: classes.dex */
    private final class a extends ConnectivityManager.NetworkCallback {
        private final kotlin.e0.c.l<Boolean, kotlin.x> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlin.e0.c.l<? super Boolean, kotlin.x> lVar) {
            this.a = lVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            u.this.a = network;
            kotlin.e0.c.l<Boolean, kotlin.x> lVar = this.a;
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            u.this.a = null;
            kotlin.e0.c.l<Boolean, kotlin.x> lVar = this.a;
            if (lVar != null) {
                lVar.invoke(Boolean.FALSE);
            }
        }
    }

    public u(ConnectivityManager cm, kotlin.e0.c.l<? super Boolean, kotlin.x> lVar) {
        kotlin.jvm.internal.m.h(cm, "cm");
        this.f3713c = cm;
        this.f3712b = new a(lVar);
    }

    @Override // com.bugsnag.android.t
    public void a() {
        this.f3713c.registerDefaultNetworkCallback(this.f3712b);
    }

    @Override // com.bugsnag.android.t
    public boolean b() {
        return this.a != null;
    }

    @Override // com.bugsnag.android.t
    public String c() {
        Network activeNetwork = this.f3713c.getActiveNetwork();
        NetworkCapabilities networkCapabilities = activeNetwork != null ? this.f3713c.getNetworkCapabilities(activeNetwork) : null;
        return networkCapabilities == null ? "none" : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(3) ? "ethernet" : networkCapabilities.hasTransport(0) ? "cellular" : "unknown";
    }
}
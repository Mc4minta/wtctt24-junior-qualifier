package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.facebook.react.bridge.ReactApplicationContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkCallbackConnectivityReceiver.java */
@TargetApi(24)
/* loaded from: classes2.dex */
public class f extends c {

    /* renamed from: i  reason: collision with root package name */
    private final b f10731i;

    /* renamed from: j  reason: collision with root package name */
    Network f10732j;

    /* renamed from: k  reason: collision with root package name */
    NetworkCapabilities f10733k;

    /* compiled from: NetworkCallbackConnectivityReceiver.java */
    /* loaded from: classes2.dex */
    private class b extends ConnectivityManager.NetworkCallback {
        private b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            f fVar = f.this;
            fVar.f10732j = network;
            fVar.f10733k = fVar.c().getNetworkCapabilities(network);
            f.this.k();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            f fVar = f.this;
            fVar.f10732j = network;
            fVar.f10733k = networkCapabilities;
            fVar.k();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            f fVar = f.this;
            if (fVar.f10732j != null) {
                fVar.f10732j = network;
                fVar.f10733k = fVar.c().getNetworkCapabilities(network);
            }
            f.this.k();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i2) {
            f fVar = f.this;
            fVar.f10732j = network;
            fVar.f10733k = fVar.c().getNetworkCapabilities(network);
            f.this.k();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            f fVar = f.this;
            fVar.f10732j = null;
            fVar.f10733k = null;
            fVar.k();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            f fVar = f.this;
            fVar.f10732j = null;
            fVar.f10733k = null;
            fVar.k();
        }
    }

    public f(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f10732j = null;
        this.f10733k = null;
        this.f10731i = new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.reactnativecommunity.netinfo.c
    @SuppressLint({"MissingPermission"})
    public void f() {
        try {
            c().registerDefaultNetworkCallback(this.f10731i);
        } catch (SecurityException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.reactnativecommunity.netinfo.c
    public void i() {
        try {
            c().unregisterNetworkCallback(this.f10731i);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    @SuppressLint({"MissingPermission"})
    void k() {
        boolean z;
        com.reactnativecommunity.netinfo.g.b bVar = com.reactnativecommunity.netinfo.g.b.UNKNOWN;
        NetworkCapabilities networkCapabilities = this.f10733k;
        com.reactnativecommunity.netinfo.g.a aVar = null;
        boolean z2 = false;
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(2)) {
                bVar = com.reactnativecommunity.netinfo.g.b.BLUETOOTH;
            } else if (this.f10733k.hasTransport(0)) {
                bVar = com.reactnativecommunity.netinfo.g.b.CELLULAR;
            } else if (this.f10733k.hasTransport(3)) {
                bVar = com.reactnativecommunity.netinfo.g.b.ETHERNET;
            } else if (this.f10733k.hasTransport(1)) {
                bVar = com.reactnativecommunity.netinfo.g.b.WIFI;
            } else if (this.f10733k.hasTransport(4)) {
                bVar = com.reactnativecommunity.netinfo.g.b.VPN;
            }
            NetworkInfo networkInfo = this.f10732j != null ? c().getNetworkInfo(this.f10732j) : null;
            if (Build.VERSION.SDK_INT >= 28) {
                z = !this.f10733k.hasCapability(21);
            } else {
                z = (this.f10732j == null || networkInfo == null || networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) ? false : true;
            }
            if (this.f10733k.hasCapability(12) && this.f10733k.hasCapability(16) && !z) {
                z2 = true;
            }
            if (this.f10732j != null && bVar == com.reactnativecommunity.netinfo.g.b.CELLULAR && z2) {
                aVar = com.reactnativecommunity.netinfo.g.a.h(networkInfo);
            }
        } else {
            bVar = com.reactnativecommunity.netinfo.g.b.NONE;
        }
        j(bVar, aVar, z2);
    }
}
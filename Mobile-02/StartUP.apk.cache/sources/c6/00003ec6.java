package com.reactnativecommunity.netinfo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;

/* compiled from: BroadcastReceiverConnectivityReceiver.java */
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: i  reason: collision with root package name */
    private final C0228b f10722i;

    /* compiled from: BroadcastReceiverConnectivityReceiver.java */
    /* renamed from: com.reactnativecommunity.netinfo.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0228b extends BroadcastReceiver {
        private boolean a;

        private C0228b() {
            this.a = false;
        }

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.a = z;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            b.this.l();
        }
    }

    public b(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f10722i = new C0228b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void l() {
        NetworkInfo activeNetworkInfo;
        com.reactnativecommunity.netinfo.g.b bVar = com.reactnativecommunity.netinfo.g.b.UNKNOWN;
        com.reactnativecommunity.netinfo.g.a aVar = null;
        boolean z = false;
        try {
            activeNetworkInfo = c().getActiveNetworkInfo();
        } catch (SecurityException unused) {
            bVar = com.reactnativecommunity.netinfo.g.b.UNKNOWN;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            z = activeNetworkInfo.isConnected();
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    bVar = com.reactnativecommunity.netinfo.g.b.WIFI;
                } else if (type != 4) {
                    if (type == 9) {
                        bVar = com.reactnativecommunity.netinfo.g.b.ETHERNET;
                    } else if (type == 17) {
                        bVar = com.reactnativecommunity.netinfo.g.b.VPN;
                    } else if (type == 6) {
                        bVar = com.reactnativecommunity.netinfo.g.b.WIMAX;
                    } else if (type == 7) {
                        bVar = com.reactnativecommunity.netinfo.g.b.BLUETOOTH;
                    }
                }
                j(bVar, aVar, z);
            }
            bVar = com.reactnativecommunity.netinfo.g.b.CELLULAR;
            aVar = com.reactnativecommunity.netinfo.g.a.h(activeNetworkInfo);
            j(bVar, aVar, z);
        }
        bVar = com.reactnativecommunity.netinfo.g.b.NONE;
        j(bVar, aVar, z);
    }

    @Override // com.reactnativecommunity.netinfo.c
    public /* bridge */ /* synthetic */ void d(String str, Promise promise) {
        super.d(str, promise);
    }

    @Override // com.reactnativecommunity.netinfo.c
    public void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        e().registerReceiver(this.f10722i, intentFilter);
        this.f10722i.b(true);
        l();
    }

    @Override // com.reactnativecommunity.netinfo.c
    public /* bridge */ /* synthetic */ void h(boolean z) {
        super.h(z);
    }

    @Override // com.reactnativecommunity.netinfo.c
    public void i() {
        if (this.f10722i.a()) {
            e().unregisterReceiver(this.f10722i);
            this.f10722i.b(false);
        }
    }
}
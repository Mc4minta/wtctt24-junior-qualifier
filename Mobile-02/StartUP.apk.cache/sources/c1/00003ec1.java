package com.reactnativecommunity.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;

/* compiled from: AmazonFireDeviceConnectivityPoller.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private final Context f10715b;

    /* renamed from: c  reason: collision with root package name */
    private final b f10716c;

    /* renamed from: e  reason: collision with root package name */
    private Handler f10718e;
    private final d a = new d();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f10717d = new c();

    /* renamed from: f  reason: collision with root package name */
    private boolean f10719f = false;

    /* compiled from: AmazonFireDeviceConnectivityPoller.java */
    /* loaded from: classes2.dex */
    public interface b {
        void onAmazonFireDeviceConnectivityChanged(boolean z);
    }

    /* compiled from: AmazonFireDeviceConnectivityPoller.java */
    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f10719f) {
                a.this.f10715b.sendBroadcast(new Intent("com.amazon.tv.networkmonitor.CONNECTIVITY_CHECK"));
                a.this.f10718e.postDelayed(a.this.f10717d, 10000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AmazonFireDeviceConnectivityPoller.java */
    /* loaded from: classes2.dex */
    public class d extends BroadcastReceiver {
        boolean a;

        /* renamed from: b  reason: collision with root package name */
        private Boolean f10720b;

        private d() {
            this.a = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            String action = intent == null ? null : intent.getAction();
            if ("com.amazon.tv.networkmonitor.INTERNET_DOWN".equals(action)) {
                z = false;
            } else if (!"com.amazon.tv.networkmonitor.INTERNET_UP".equals(action)) {
                return;
            } else {
                z = true;
            }
            Boolean bool = this.f10720b;
            if (bool == null || bool.booleanValue() != z) {
                this.f10720b = Boolean.valueOf(z);
                a.this.f10716c.onAmazonFireDeviceConnectivityChanged(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, b bVar) {
        this.f10715b = context;
        this.f10716c = bVar;
    }

    private boolean f() {
        if (Build.MANUFACTURER.equals("Amazon")) {
            String str = Build.MODEL;
            if (str.startsWith("AF") || str.startsWith("KF")) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        if (this.a.a) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_DOWN");
        intentFilter.addAction("com.amazon.tv.networkmonitor.INTERNET_UP");
        this.f10715b.registerReceiver(this.a, intentFilter);
        this.a.a = true;
    }

    private void i() {
        if (this.f10719f) {
            return;
        }
        Handler handler = new Handler();
        this.f10718e = handler;
        this.f10719f = true;
        handler.post(this.f10717d);
    }

    private void j() {
        if (this.f10719f) {
            this.f10719f = false;
            this.f10718e.removeCallbacksAndMessages(null);
            this.f10718e = null;
        }
    }

    private void l() {
        d dVar = this.a;
        if (dVar.a) {
            this.f10715b.unregisterReceiver(dVar);
            this.a.a = false;
        }
    }

    public void g() {
        if (f()) {
            h();
            i();
        }
    }

    public void k() {
        if (f()) {
            j();
            l();
        }
    }
}
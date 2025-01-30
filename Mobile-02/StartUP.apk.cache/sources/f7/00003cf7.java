package com.google.zxing.p.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: InactivityTimer.java */
/* loaded from: classes2.dex */
public final class e {
    private final Context a;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f9898e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9899f;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9896c = false;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver f9895b = new b();

    /* renamed from: d  reason: collision with root package name */
    private Handler f9897d = new Handler();

    /* compiled from: InactivityTimer.java */
    /* loaded from: classes2.dex */
    private final class b extends BroadcastReceiver {

        /* compiled from: InactivityTimer.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ boolean a;

            a(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f(this.a);
            }
        }

        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                e.this.f9897d.post(new a(intent.getIntExtra("plugged", -1) <= 0));
            }
        }
    }

    public e(Context context, Runnable runnable) {
        this.a = context;
        this.f9898e = runnable;
    }

    private void e() {
        this.f9897d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        this.f9899f = z;
        if (this.f9896c) {
            c();
        }
    }

    private void g() {
        if (this.f9896c) {
            return;
        }
        this.a.registerReceiver(this.f9895b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f9896c = true;
    }

    private void i() {
        if (this.f9896c) {
            this.a.unregisterReceiver(this.f9895b);
            this.f9896c = false;
        }
    }

    public void c() {
        e();
        if (this.f9899f) {
            this.f9897d.postDelayed(this.f9898e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public void h() {
        g();
        c();
    }
}
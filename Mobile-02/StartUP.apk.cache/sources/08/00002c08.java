package com.dieam.reactnativepushnotification.modules;

import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import e.f.m.k;

/* compiled from: RNPushNotificationActions.java */
/* loaded from: classes2.dex */
public class a extends BroadcastReceiver {

    /* compiled from: RNPushNotificationActions.java */
    /* renamed from: com.dieam.reactnativepushnotification.modules.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0105a implements Runnable {
        final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f4463b;

        RunnableC0105a(Context context, Bundle bundle) {
            this.a = context;
            this.f4463b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((k) this.a.getApplicationContext()).a();
            throw null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str = context.getPackageName() + ".ACTION_";
        Log.i(RNPushNotification.LOG_TAG, "RNPushNotificationBootEventReceiver loading scheduled notifications");
        if (intent.getAction() == null || !intent.getAction().startsWith(str)) {
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("notification");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int parseInt = Integer.parseInt(bundleExtra.getString("id"));
        if (bundleExtra.getBoolean("autoCancel", true)) {
            if (bundleExtra.containsKey("tag")) {
                notificationManager.cancel(bundleExtra.getString("tag"), parseInt);
            } else {
                notificationManager.cancel(parseInt);
            }
        }
        if (bundleExtra.getBoolean("invokeApp", true)) {
            new d((Application) context.getApplicationContext()).q(bundleExtra);
        } else {
            new Handler(Looper.getMainLooper()).post(new RunnableC0105a(context, bundleExtra));
        }
    }
}
package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EventReceiver.java */
/* loaded from: classes.dex */
public class f0 extends BroadcastReceiver {
    private static final Map<String, BreadcrumbType> a = a();

    /* renamed from: b  reason: collision with root package name */
    private final q f3650b;

    public f0(q qVar) {
        this.f3650b = qVar;
    }

    private static Map<String, BreadcrumbType> a() {
        HashMap hashMap = new HashMap();
        BreadcrumbType breadcrumbType = BreadcrumbType.USER;
        hashMap.put("android.appwidget.action.APPWIDGET_DELETED", breadcrumbType);
        hashMap.put("android.appwidget.action.APPWIDGET_DISABLED", breadcrumbType);
        hashMap.put("android.appwidget.action.APPWIDGET_ENABLED", breadcrumbType);
        BreadcrumbType breadcrumbType2 = BreadcrumbType.STATE;
        hashMap.put("android.appwidget.action.APPWIDGET_HOST_RESTORED", breadcrumbType2);
        hashMap.put("android.appwidget.action.APPWIDGET_RESTORED", breadcrumbType2);
        hashMap.put("android.appwidget.action.APPWIDGET_UPDATE", breadcrumbType2);
        hashMap.put("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", breadcrumbType2);
        hashMap.put("android.intent.action.ACTION_POWER_CONNECTED", breadcrumbType2);
        hashMap.put("android.intent.action.ACTION_POWER_DISCONNECTED", breadcrumbType2);
        hashMap.put("android.intent.action.ACTION_SHUTDOWN", breadcrumbType2);
        hashMap.put("android.intent.action.AIRPLANE_MODE", breadcrumbType2);
        hashMap.put("android.intent.action.BATTERY_LOW", breadcrumbType2);
        hashMap.put("android.intent.action.BATTERY_OKAY", breadcrumbType2);
        hashMap.put("android.intent.action.BOOT_COMPLETED", breadcrumbType2);
        hashMap.put("android.intent.action.CAMERA_BUTTON", breadcrumbType);
        hashMap.put("android.intent.action.CLOSE_SYSTEM_DIALOGS", breadcrumbType);
        hashMap.put("android.intent.action.CONFIGURATION_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.CONTENT_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.DATE_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.DEVICE_STORAGE_LOW", breadcrumbType2);
        hashMap.put("android.intent.action.DEVICE_STORAGE_OK", breadcrumbType2);
        hashMap.put("android.intent.action.DOCK_EVENT", breadcrumbType);
        BreadcrumbType breadcrumbType3 = BreadcrumbType.NAVIGATION;
        hashMap.put("android.intent.action.DREAMING_STARTED", breadcrumbType3);
        hashMap.put("android.intent.action.DREAMING_STOPPED", breadcrumbType3);
        hashMap.put("android.intent.action.INPUT_METHOD_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.LOCALE_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.REBOOT", breadcrumbType2);
        hashMap.put("android.intent.action.SCREEN_OFF", breadcrumbType2);
        hashMap.put("android.intent.action.SCREEN_ON", breadcrumbType2);
        hashMap.put("android.intent.action.TIMEZONE_CHANGED", breadcrumbType2);
        hashMap.put("android.intent.action.TIME_SET", breadcrumbType2);
        hashMap.put("android.os.action.DEVICE_IDLE_MODE_CHANGED", breadcrumbType2);
        hashMap.put("android.os.action.POWER_SAVE_MODE_CHANGED", breadcrumbType2);
        return hashMap;
    }

    public static IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : a.keySet()) {
            intentFilter.addAction(str);
        }
        return intentFilter;
    }

    static boolean c(String str) {
        return str.startsWith("android.");
    }

    static String d(String str) {
        return c(str) ? str.substring(str.lastIndexOf(".") + 1) : str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            HashMap hashMap = new HashMap();
            String action = intent.getAction();
            String d2 = d(intent.getAction());
            hashMap.put("Intent Action", action);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    String obj = extras.get(str).toString();
                    if (c(str)) {
                        hashMap.put("Extra", String.format("%s: %s", d2, obj));
                    } else {
                        hashMap.put(str, obj);
                    }
                }
            }
            Map<String, BreadcrumbType> map = a;
            BreadcrumbType breadcrumbType = map.containsKey(action) ? map.get(action) : BreadcrumbType.LOG;
            if (this.f3650b.l().D()) {
                this.f3650b.u(d2, breadcrumbType, hashMap);
            }
        } catch (Exception e2) {
            q0.d("Failed to leave breadcrumb in EventReceiver: " + e2.getMessage());
        }
    }
}
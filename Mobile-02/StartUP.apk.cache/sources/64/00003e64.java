package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.c.b.c;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* compiled from: RNInAppBrowser.java */
/* loaded from: classes2.dex */
public class c {
    private static final Pattern a = Pattern.compile("^.+:.+/");

    /* renamed from: b  reason: collision with root package name */
    private Promise f10548b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f10549c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f10550d;

    /* compiled from: RNInAppBrowser.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            a = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private String c(Context context) {
        List<ResolveInfo> d2 = d(context);
        String a2 = c.c.b.b.a(context, Arrays.asList("com.android.chrome", "com.chrome.beta", "com.chrome.dev", "com.google.android.apps.chrome"));
        return (a2 != null || d2 == null || d2.size() <= 0) ? a2 : d2.get(0).serviceInfo.packageName;
    }

    private List<ResolveInfo> d(Context context) {
        return context.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
    }

    private void g() {
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    private int h(Context context, String str) {
        if (a.matcher(str).find()) {
            return context.getResources().getIdentifier(str, null, null);
        }
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    private Boolean i(String str) {
        return Boolean.valueOf(c.h.e.a.b(Color.parseColor(str)) > 0.5d);
    }

    private void j() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    void a(Context context, c.a aVar, ReadableMap readableMap) {
        int h2 = readableMap.hasKey("startEnter") ? h(context, readableMap.getString("startEnter")) : -1;
        int h3 = readableMap.hasKey("startExit") ? h(context, readableMap.getString("startExit")) : -1;
        int h4 = readableMap.hasKey("endEnter") ? h(context, readableMap.getString("endEnter")) : -1;
        int h5 = readableMap.hasKey("endExit") ? h(context, readableMap.getString("endExit")) : -1;
        if (h2 != -1 && h3 != -1) {
            aVar.g(context, h2, h3);
        }
        if (h4 == -1 || h5 == -1) {
            return;
        }
        aVar.d(context, h4, h5);
    }

    public void b() {
        Promise promise = this.f10548b;
        if (promise == null) {
            return;
        }
        if (this.f10550d == null) {
            promise.reject("InAppBrowser", "No activity");
            this.f10548b = null;
            return;
        }
        j();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", "dismiss");
        this.f10548b.resolve(createMap);
        this.f10548b = null;
        Activity activity = this.f10550d;
        activity.startActivity(ChromeTabsManagerActivity.b(activity));
    }

    public void e(Context context, Promise promise) {
        List<ResolveInfo> d2 = d(context);
        promise.resolve(Boolean.valueOf((d2 == null || d2.isEmpty()) ? false : true));
    }

    public void f(Context context, ReadableMap readableMap, Promise promise, Activity activity) {
        ReadableMap map;
        String string = readableMap.getString("url");
        this.f10550d = activity;
        if (this.f10548b != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", "cancel");
            this.f10548b.resolve(createMap);
            this.f10548b = null;
            return;
        }
        this.f10548b = promise;
        if (activity == null) {
            promise.reject("InAppBrowser", "No activity");
            this.f10548b = null;
            return;
        }
        c.a aVar = new c.a();
        if (readableMap.hasKey("toolbarColor")) {
            String string2 = readableMap.getString("toolbarColor");
            try {
                aVar.h(Color.parseColor(string2));
                this.f10549c = i(string2);
            } catch (IllegalArgumentException e2) {
                throw new JSApplicationIllegalArgumentException("Invalid toolbar color '" + string2 + "': " + e2.getMessage());
            }
        }
        if (readableMap.hasKey("secondaryToolbarColor")) {
            String string3 = readableMap.getString("secondaryToolbarColor");
            try {
                aVar.e(Color.parseColor(string3));
            } catch (IllegalArgumentException e3) {
                throw new JSApplicationIllegalArgumentException("Invalid secondary toolbar color '" + string3 + "': " + e3.getMessage());
            }
        }
        if (readableMap.hasKey("enableDefaultShare") && readableMap.getBoolean("enableDefaultShare")) {
            aVar.a();
        }
        if (readableMap.hasKey("animations")) {
            a(context, aVar, readableMap.getMap("animations"));
        }
        if (readableMap.hasKey("hasBackButton") && readableMap.getBoolean("hasBackButton")) {
            aVar.c(BitmapFactory.decodeResource(context.getResources(), this.f10549c.booleanValue() ? b.a : b.f10547b));
        }
        c.c.b.c b2 = aVar.b();
        Intent intent = b2.a;
        boolean z = true;
        if (readableMap.hasKey("headers") && (map = readableMap.getMap("headers")) != null) {
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            if (keySetIterator.hasNextKey()) {
                Bundle bundle = new Bundle();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    if (a.a[map.getType(nextKey).ordinal()] == 1) {
                        bundle.putString(nextKey, map.getString(nextKey));
                    }
                }
                intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        if (readableMap.hasKey("forceCloseOnRedirection") && readableMap.getBoolean("forceCloseOnRedirection")) {
            intent.addFlags(268435456);
        }
        if (!readableMap.hasKey("showInRecents") || !readableMap.getBoolean("showInRecents")) {
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
        }
        if (!readableMap.hasKey("enableUrlBarHiding") || !readableMap.getBoolean("enableUrlBarHiding")) {
            z = false;
        }
        intent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", z);
        try {
            if (readableMap.hasKey("browserPackage")) {
                String string4 = readableMap.getString("browserPackage");
                if (!TextUtils.isEmpty(string4)) {
                    intent.setPackage(string4);
                }
            } else {
                intent.setPackage(c(this.f10550d));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        intent.setData(Uri.parse(string));
        if (readableMap.hasKey("showTitle")) {
            aVar.f(readableMap.getBoolean("showTitle"));
        } else {
            intent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 0);
        }
        g();
        Activity activity2 = this.f10550d;
        activity2.startActivity(ChromeTabsManagerActivity.c(activity2, intent), b2.f2605b);
    }
}
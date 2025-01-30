package com.dieam.reactnativepushnotification.modules;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.m;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RNPushNotification extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final String LOG_TAG = "RNPushNotification";
    private e mJsDelivery;
    private d mRNPushNotificationHelper;
    private final SecureRandom mRandomNumberGenerator;

    /* loaded from: classes2.dex */
    class a implements com.google.android.gms.tasks.c<com.google.firebase.iid.a> {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // com.google.android.gms.tasks.c
        public void a(com.google.android.gms.tasks.g<com.google.firebase.iid.a> gVar) {
            if (!gVar.q()) {
                Log.e(RNPushNotification.LOG_TAG, "exception", gVar.l());
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("deviceToken", gVar.m().a());
            this.a.d("remoteNotificationsRegistered", createMap);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FirebaseInstanceId.c().a();
                Log.i(RNPushNotification.LOG_TAG, "InstanceID deleted");
            } catch (IOException e2) {
                Log.e(RNPushNotification.LOG_TAG, "exception", e2);
            }
        }
    }

    public RNPushNotification(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRandomNumberGenerator = new SecureRandom();
        reactApplicationContext.addActivityEventListener(this);
        this.mRNPushNotificationHelper = new d((Application) reactApplicationContext.getApplicationContext());
        this.mJsDelivery = new e(reactApplicationContext);
    }

    private Bundle getBundleFromIntent(Intent intent) {
        Bundle bundle;
        if (intent.hasExtra("notification")) {
            bundle = intent.getBundleExtra("notification");
        } else if (intent.hasExtra("google.message_id")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("data", intent.getExtras());
            bundle = bundle2;
        } else {
            bundle = null;
        }
        if (bundle != null && !bundle.getBoolean("foreground", false) && !bundle.containsKey("userInteraction")) {
            bundle.putBoolean("userInteraction", true);
        }
        return bundle;
    }

    @ReactMethod
    public void abandonPermissions() {
        new Thread(new b()).start();
    }

    @ReactMethod
    public void cancelAllLocalNotifications() {
        this.mRNPushNotificationHelper.a();
        this.mRNPushNotificationHelper.i();
    }

    @ReactMethod
    public void cancelLocalNotifications(ReadableMap readableMap) {
        this.mRNPushNotificationHelper.b(readableMap);
    }

    @ReactMethod
    public void channelBlocked(String str, Callback callback) {
        boolean d2 = this.mRNPushNotificationHelper.d(str);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(d2));
        }
    }

    @ReactMethod
    public void channelExists(String str, Callback callback) {
        boolean e2 = this.mRNPushNotificationHelper.e(str);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(e2));
        }
    }

    @ReactMethod
    public void checkPermissions(Promise promise) {
        promise.resolve(Boolean.valueOf(m.b(getReactApplicationContext()).a()));
    }

    @ReactMethod
    public void clearLocalNotification(String str, int i2) {
        this.mRNPushNotificationHelper.h(str, i2);
    }

    @ReactMethod
    public void createChannel(ReadableMap readableMap, Callback callback) {
        boolean j2 = this.mRNPushNotificationHelper.j(readableMap);
        if (callback != null) {
            callback.invoke(Boolean.valueOf(j2));
        }
    }

    @ReactMethod
    public void deleteChannel(String str) {
        this.mRNPushNotificationHelper.k(str);
    }

    @ReactMethod
    public void getChannels(Callback callback) {
        WritableArray fromList = Arguments.fromList(this.mRNPushNotificationHelper.s());
        if (callback != null) {
            callback.invoke(fromList);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return new HashMap();
    }

    @ReactMethod
    public void getDeliveredNotifications(Callback callback) {
        callback.invoke(this.mRNPushNotificationHelper.m());
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        Bundle bundleFromIntent;
        WritableMap createMap = Arguments.createMap();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && (bundleFromIntent = getBundleFromIntent(currentActivity.getIntent())) != null) {
            bundleFromIntent.putBoolean("foreground", false);
            createMap.putString("dataJSON", this.mJsDelivery.a(bundleFromIntent));
        }
        promise.resolve(createMap);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return LOG_TAG;
    }

    @ReactMethod
    public void getScheduledLocalNotifications(Callback callback) {
        callback.invoke(this.mRNPushNotificationHelper.o());
    }

    @ReactMethod
    public void invokeApp(ReadableMap readableMap) {
        this.mRNPushNotificationHelper.q(readableMap != null ? Arguments.toBundle(readableMap) : null);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        onActivityResult(i2, i3, intent);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
        Bundle bundleFromIntent = getBundleFromIntent(intent);
        if (bundleFromIntent != null) {
            this.mJsDelivery.c(bundleFromIntent);
        }
    }

    @ReactMethod
    public void presentLocalNotification(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle.getString("id") == null) {
            bundle.putString("id", String.valueOf(this.mRandomNumberGenerator.nextInt()));
        }
        this.mRNPushNotificationHelper.x(bundle);
    }

    @ReactMethod
    public void removeAllDeliveredNotifications() {
        this.mRNPushNotificationHelper.i();
    }

    @ReactMethod
    public void removeDeliveredNotifications(ReadableArray readableArray) {
        this.mRNPushNotificationHelper.g(readableArray);
    }

    @ReactMethod
    public void requestPermissions() {
        FirebaseInstanceId.c().d().b(new a(this.mJsDelivery));
    }

    @ReactMethod
    public void scheduleLocalNotification(ReadableMap readableMap) {
        Bundle bundle = Arguments.toBundle(readableMap);
        if (bundle.getString("id") == null) {
            bundle.putString("id", String.valueOf(this.mRandomNumberGenerator.nextInt()));
        }
        this.mRNPushNotificationHelper.v(bundle);
    }

    @ReactMethod
    public void setApplicationIconBadgeNumber(int i2) {
        e.e.a.b.a.a.a(getReactApplicationContext(), i2);
    }

    @ReactMethod
    public void subscribeToTopic(String str) {
        FirebaseMessaging.a().c(str);
    }

    @ReactMethod
    public void unsubscribeFromTopic(String str) {
        FirebaseMessaging.a().d(str);
    }
}
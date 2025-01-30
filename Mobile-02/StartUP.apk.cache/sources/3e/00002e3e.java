package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;

@e.f.m.x.a.a(name = DeviceEventManagerModule.NAME)
/* loaded from: classes2.dex */
public class DeviceEventManagerModule extends NativeDeviceEventManagerSpec {
    public static final String NAME = "DeviceEventManager";
    private final Runnable mInvokeDefaultBackPressRunnable;

    @e.f.l.a.a
    /* loaded from: classes2.dex */
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(String str, Object obj);
    }

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            UiThreadUtil.assertOnUiThread();
            this.a.invokeDefaultOnBackPressed();
        }
    }

    public DeviceEventManagerModule(ReactApplicationContext reactApplicationContext, b bVar) {
        super(reactApplicationContext);
        this.mInvokeDefaultBackPressRunnable = new a(bVar);
    }

    public void emitHardwareBackPressed() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
        }
    }

    public void emitNewIntentReceived(Uri uri) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("url", uri.toString());
            ((RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(RCTDeviceEventEmitter.class)).emit("url", createMap);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceEventManagerSpec
    public void invokeDefaultBackPressHandler() {
        getReactApplicationContext().runOnUiQueueThread(this.mInvokeDefaultBackPressRunnable);
    }
}
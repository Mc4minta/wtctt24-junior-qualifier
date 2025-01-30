package com.proyecto26.inappbrowser;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

@e.f.m.x.a.a(name = RNInAppBrowserModule.NAME)
/* loaded from: classes2.dex */
public class RNInAppBrowserModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNInAppBrowser";
    private final c inAppBrowser;
    private final ReactApplicationContext reactContext;

    public RNInAppBrowserModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.inAppBrowser = new c();
    }

    @ReactMethod
    public void close() {
        this.inAppBrowser.b();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void isAvailable(Promise promise) {
        this.inAppBrowser.e(this.reactContext, promise);
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        this.inAppBrowser.f(this.reactContext, readableMap, promise, getCurrentActivity());
    }
}
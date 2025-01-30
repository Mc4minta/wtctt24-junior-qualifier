package com.coinbase.android.idfa;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes.dex */
public class RNIDFAModule extends ReactContextBaseJavaModule {
    public RNIDFAModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getAdvertisingId(Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnNativeModulesQueueThread(new RNIDFAThread(reactApplicationContext, promise));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNIDFA";
    }
}
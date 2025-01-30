package com.reactnativecommunity.netinfo;

import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativecommunity.netinfo.a;

@e.f.m.x.a.a(name = NetInfoModule.NAME)
/* loaded from: classes2.dex */
public class NetInfoModule extends ReactContextBaseJavaModule implements a.b {
    public static final String NAME = "RNCNetInfo";
    private final a mAmazonConnectivityChecker;
    private final c mConnectivityReceiver;

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mConnectivityReceiver = new f(reactApplicationContext);
        } else {
            this.mConnectivityReceiver = new b(reactApplicationContext);
        }
        this.mAmazonConnectivityChecker = new a(reactApplicationContext, this);
    }

    @ReactMethod
    public void getCurrentState(String str, Promise promise) {
        this.mConnectivityReceiver.d(str, promise);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.mConnectivityReceiver.f();
        this.mAmazonConnectivityChecker.g();
    }

    @Override // com.reactnativecommunity.netinfo.a.b
    public void onAmazonFireDeviceConnectivityChanged(boolean z) {
        this.mConnectivityReceiver.h(z);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mAmazonConnectivityChecker.k();
        this.mConnectivityReceiver.i();
    }
}
package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.a;

/* loaded from: classes2.dex */
public abstract class NativeTVNavigationEventEmitterSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, a {
    public NativeTVNavigationEventEmitterSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void removeListeners(double d2);
}
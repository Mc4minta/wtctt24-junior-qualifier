package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.c;
import e.f.m.x.a.a;
import java.util.HashMap;
import java.util.Map;

@a(name = DeviceInfoModule.NAME)
/* loaded from: classes2.dex */
public class DeviceInfoModule extends NativeDeviceInfoSpec implements LifecycleEventListener {
    public static final String NAME = "DeviceInfo";
    private float mFontScale;
    private ReadableMap mPreviousDisplayMetrics;
    private ReactApplicationContext mReactApplicationContext;

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        c.h(reactApplicationContext);
        this.mFontScale = reactApplicationContext.getResources().getConfiguration().fontScale;
        this.mReactApplicationContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext == null) {
            return;
        }
        if (reactApplicationContext.hasActiveCatalystInstance()) {
            WritableNativeMap b2 = c.b(this.mFontScale);
            ReadableMap readableMap = this.mPreviousDisplayMetrics;
            if (readableMap == null) {
                this.mPreviousDisplayMetrics = b2.copy();
                return;
            } else if (b2.equals(readableMap)) {
                return;
            } else {
                this.mPreviousDisplayMetrics = b2.copy();
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", b2);
                return;
            }
        }
        ReactSoftException.logSoftException(NAME, new ReactNoCrashSoftException("No active CatalystInstance, cannot emitUpdateDimensionsEvent"));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceInfoSpec
    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("Dimensions", c.a(this.mFontScale));
        return hashMap;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public void invalidate() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext == null) {
            return;
        }
        float f2 = reactApplicationContext.getResources().getConfiguration().fontScale;
        if (this.mFontScale != f2) {
            this.mFontScale = f2;
            emitUpdateDimensionsEvent();
        }
    }

    public DeviceInfoModule(Context context) {
        super(null);
        this.mReactApplicationContext = null;
        c.h(context);
        this.mFontScale = context.getResources().getConfiguration().fontScale;
    }
}
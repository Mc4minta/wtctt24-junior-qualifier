package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;

/* compiled from: ThemedReactContext.java */
/* loaded from: classes2.dex */
public class i0 extends ReactContext {
    private final ReactApplicationContext a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5133b;

    public i0(ReactApplicationContext reactApplicationContext, Context context, String str) {
        super(context);
        if (reactApplicationContext.hasCatalystInstance()) {
            initializeWithInstance(reactApplicationContext.getCatalystInstance());
        }
        this.a = reactApplicationContext;
        this.f5133b = str;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.a.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Activity getCurrentActivity() {
        return this.a.getCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public JSIModule getJSIModule(JSIModuleType jSIModuleType) {
        if (isBridgeless()) {
            return this.a.getJSIModule(jSIModuleType);
        }
        return super.getJSIModule(jSIModuleType);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCurrentActivity() {
        return this.a.hasCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean isBridgeless() {
        return this.a.isBridgeless();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.a.removeLifecycleEventListener(lifecycleEventListener);
    }
}
package com.facebook.react.uimanager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.UIManager;

/* compiled from: UIManagerHelper.java */
/* loaded from: classes2.dex */
public class o0 {
    public static com.facebook.react.uimanager.events.d a(ReactContext reactContext, int i2) {
        UIManager e2 = e(reactContext, i2, false);
        if (e2 == null) {
            return null;
        }
        return (com.facebook.react.uimanager.events.d) e2.getEventDispatcher();
    }

    public static com.facebook.react.uimanager.events.d b(ReactContext reactContext, int i2) {
        return a(reactContext, com.facebook.react.uimanager.d1.a.a(i2));
    }

    public static ReactContext c(View view) {
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static UIManager d(ReactContext reactContext, int i2) {
        return e(reactContext, i2, true);
    }

    private static UIManager e(ReactContext reactContext, int i2, boolean z) {
        if (reactContext.isBridgeless()) {
            return (UIManager) reactContext.getJSIModule(JSIModuleType.UIManager);
        }
        if (!reactContext.hasCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        }
        if (!reactContext.hasActiveCatalystInstance()) {
            ReactSoftException.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
            if (z) {
                return null;
            }
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        if (i2 == 2) {
            return (UIManager) catalystInstance.getJSIModule(JSIModuleType.UIManager);
        }
        return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
    }
}
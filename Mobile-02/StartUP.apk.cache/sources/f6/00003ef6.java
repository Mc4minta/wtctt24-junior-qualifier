package com.reactnativerestart;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import e.f.m.k;
import e.f.m.l;

/* loaded from: classes2.dex */
public class RestartModule extends ReactContextBaseJavaModule {
    private static final String REACT_APPLICATION_CLASS_NAME = "com.facebook.react.ReactApplication";
    private static final String REACT_NATIVE_HOST_CLASS_NAME = "com.facebook.react.ReactNativeHost";
    private static com.reactnativerestart.a mReactInstanceHolder;
    private LifecycleEventListener mLifecycleEventListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.recreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ l a;

        b(l lVar) {
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.N();
            } catch (Throwable unused) {
                RestartModule.this.loadBundleLegacy();
            }
        }
    }

    public RestartModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mLifecycleEventListener = null;
    }

    private void clearLifecycleEventListener() {
        if (this.mLifecycleEventListener != null) {
            getReactApplicationContext().removeLifecycleEventListener(this.mLifecycleEventListener);
            this.mLifecycleEventListener = null;
        }
    }

    static l getReactInstanceManager() {
        com.reactnativerestart.a aVar = mReactInstanceHolder;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    private void loadBundle() {
        clearLifecycleEventListener();
        try {
            l resolveInstanceManager = resolveInstanceManager();
            if (resolveInstanceManager == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new b(resolveInstanceManager));
        } catch (Throwable unused) {
            loadBundleLegacy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBundleLegacy() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new a(currentActivity));
    }

    private l resolveInstanceManager() throws NoSuchFieldException, IllegalAccessException {
        l reactInstanceManager = getReactInstanceManager();
        if (reactInstanceManager != null) {
            return reactInstanceManager;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        ((k) currentActivity.getApplication()).a();
        throw null;
    }

    @ReactMethod
    public void Restart() {
        loadBundle();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNRestart";
    }
}
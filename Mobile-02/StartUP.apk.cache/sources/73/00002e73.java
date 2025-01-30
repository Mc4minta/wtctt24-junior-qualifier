package com.facebook.react.modules.fresco;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.network.g;
import e.f.j.e.i;
import java.util.HashSet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@e.f.m.x.a.a(name = FrescoModule.NAME, needsEagerInit = true)
/* loaded from: classes2.dex */
public class FrescoModule extends ReactContextBaseJavaModule implements LifecycleEventListener, com.facebook.react.turbomodule.core.interfaces.a {
    public static final String NAME = "FrescoModule";
    private static boolean sHasBeenInitialized;
    private final boolean mClearOnDestroy;
    private i mConfig;

    public FrescoModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, true, null);
    }

    private static i getDefaultConfig(ReactContext reactContext) {
        return getDefaultConfigBuilder(reactContext).E();
    }

    public static i.b getDefaultConfigBuilder(ReactContext reactContext) {
        HashSet hashSet = new HashSet();
        hashSet.add(new c());
        OkHttpClient a = g.a();
        ((com.facebook.react.modules.network.a) a.cookieJar()).b(new JavaNetCookieJar(new com.facebook.react.modules.network.c(reactContext)));
        return e.f.j.b.a.a.a(reactContext.getApplicationContext(), a).G(new b(a)).F(false).H(hashSet);
    }

    public static boolean hasBeenInitialized() {
        return sHasBeenInitialized;
    }

    public void clearSensitiveData() {
        e.f.h.a.a.c.a().a();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
        if (!hasBeenInitialized()) {
            if (this.mConfig == null) {
                this.mConfig = getDefaultConfig(getReactApplicationContext());
            }
            e.f.h.a.a.c.e(getReactApplicationContext().getApplicationContext(), this.mConfig);
            sHasBeenInitialized = true;
        } else if (this.mConfig != null) {
            e.f.d.d.a.A("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
        }
        this.mConfig = null;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        if (hasBeenInitialized() && this.mClearOnDestroy) {
            e.f.h.a.a.c.a().c();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z) {
        this(reactApplicationContext, z, null);
    }

    public FrescoModule(ReactApplicationContext reactApplicationContext, boolean z, i iVar) {
        super(reactApplicationContext);
        this.mClearOnDestroy = z;
        this.mConfig = iVar;
    }
}
package com.facebook.react.modules.appearance;

import android.content.Context;
import com.facebook.fbreact.specs.NativeAppearanceSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@e.f.m.x.a.a(name = AppearanceModule.NAME)
/* loaded from: classes2.dex */
public class AppearanceModule extends NativeAppearanceSpec {
    private static final String APPEARANCE_CHANGED_EVENT_NAME = "appearanceChanged";
    public static final String NAME = "Appearance";
    private String mColorScheme;
    private final a mOverrideColorScheme;

    /* loaded from: classes2.dex */
    public interface a {
        String a();
    }

    public AppearanceModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null);
    }

    private String colorSchemeForCurrentConfiguration(Context context) {
        a aVar = this.mOverrideColorScheme;
        if (aVar != null) {
            return aVar.a();
        }
        return (context.getResources().getConfiguration().uiMode & 48) != 32 ? "light" : "dark";
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public void addListener(String str) {
    }

    public void emitAppearanceChanged(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("colorScheme", str);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(APPEARANCE_CHANGED_EVENT_NAME, createMap);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public String getColorScheme() {
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(getReactApplicationContext());
        this.mColorScheme = colorSchemeForCurrentConfiguration;
        return colorSchemeForCurrentConfiguration;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public void onConfigurationChanged(Context context) {
        String colorSchemeForCurrentConfiguration = colorSchemeForCurrentConfiguration(context);
        if (this.mColorScheme.equals(colorSchemeForCurrentConfiguration)) {
            return;
        }
        this.mColorScheme = colorSchemeForCurrentConfiguration;
        emitAppearanceChanged(colorSchemeForCurrentConfiguration);
    }

    @Override // com.facebook.fbreact.specs.NativeAppearanceSpec
    public void removeListeners(double d2) {
    }

    public AppearanceModule(ReactApplicationContext reactApplicationContext, a aVar) {
        super(reactApplicationContext);
        this.mColorScheme = "light";
        this.mOverrideColorScheme = aVar;
        this.mColorScheme = colorSchemeForCurrentConfiguration(reactApplicationContext);
    }
}
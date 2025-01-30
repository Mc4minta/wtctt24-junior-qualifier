package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@e.f.m.x.a.a(name = I18nManagerModule.NAME)
/* loaded from: classes2.dex */
public class I18nManagerModule extends ContextBaseJavaModule {
    public static final String NAME = "I18nManager";
    private final a sharedI18nUtilInstance;

    public I18nManagerModule(Context context) {
        super(context);
        this.sharedI18nUtilInstance = a.d();
    }

    @ReactMethod
    public void allowRTL(boolean z) {
        this.sharedI18nUtilInstance.a(getContext(), z);
    }

    @ReactMethod
    public void forceRTL(boolean z) {
        this.sharedI18nUtilInstance.c(getContext(), z);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        Context context = getContext();
        Locale locale = context.getResources().getConfiguration().locale;
        HashMap b2 = c.b();
        b2.put("isRTL", Boolean.valueOf(this.sharedI18nUtilInstance.g(context)));
        b2.put("doLeftAndRightSwapInRTL", Boolean.valueOf(this.sharedI18nUtilInstance.b(context)));
        b2.put("localeIdentifier", locale.toString());
        return b2;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void swapLeftAndRightInRTL(boolean z) {
        this.sharedI18nUtilInstance.k(getContext(), z);
    }
}
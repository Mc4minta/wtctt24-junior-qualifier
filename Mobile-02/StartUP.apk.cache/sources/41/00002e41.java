package com.facebook.react.modules.core;

import com.coinbase.ApiConstants;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;

@e.f.m.x.a.a(name = ExceptionsManagerModule.NAME)
/* loaded from: classes2.dex */
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {
    public static final String NAME = "ExceptionsManager";
    private final com.facebook.react.devsupport.g.c mDevSupportManager;

    public ExceptionsManagerModule(com.facebook.react.devsupport.g.c cVar) {
        super(null);
        this.mDevSupportManager = cVar;
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void dismissRedbox() {
        if (this.mDevSupportManager.b()) {
            this.mDevSupportManager.d();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportException(ReadableMap readableMap) {
        String string = readableMap.hasKey(ApiConstants.MESSAGE) ? readableMap.getString(ApiConstants.MESSAGE) : "";
        ReadableArray array = readableMap.hasKey("stack") ? readableMap.getArray("stack") : Arguments.createArray();
        int i2 = readableMap.hasKey("id") ? readableMap.getInt("id") : -1;
        boolean z = false;
        boolean z2 = readableMap.hasKey("isFatal") ? readableMap.getBoolean("isFatal") : false;
        if (this.mDevSupportManager.b()) {
            if (readableMap.getMap("extraData") != null && readableMap.getMap("extraData").hasKey("suppressRedBox")) {
                z = readableMap.getMap("extraData").getBoolean("suppressRedBox");
            }
            if (z) {
                return;
            }
            this.mDevSupportManager.g(string, array, i2);
            return;
        }
        String a = com.facebook.react.util.a.a(readableMap);
        if (!z2) {
            e.f.d.d.a.i("ReactNative", com.facebook.react.util.b.a(string, array));
            if (a != null) {
                e.f.d.d.a.c("ReactNative", "extraData: %s", a);
                return;
            }
            return;
        }
        throw new JavascriptException(com.facebook.react.util.b.a(string, array)).setExtraDataAsJson(a);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportFatalException(String str, ReadableArray readableArray, double d2) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(ApiConstants.MESSAGE, str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d2);
        javaOnlyMap.putBoolean("isFatal", true);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportSoftException(String str, ReadableArray readableArray, double d2) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(ApiConstants.MESSAGE, str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", (int) d2);
        javaOnlyMap.putBoolean("isFatal", false);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void updateExceptionMessage(String str, ReadableArray readableArray, double d2) {
        int i2 = (int) d2;
        if (this.mDevSupportManager.b()) {
            this.mDevSupportManager.q(str, readableArray, i2);
        }
    }
}
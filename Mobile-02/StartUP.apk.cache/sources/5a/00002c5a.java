package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.a;

/* loaded from: classes2.dex */
public abstract class NativeImageStoreSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, a {
    public NativeImageStoreSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void addImageFromBase64(String str, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void getBase64ForTag(String str, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void hasImageForTag(String str, Callback callback);

    @ReactMethod
    public abstract void removeImageForTag(String str);
}
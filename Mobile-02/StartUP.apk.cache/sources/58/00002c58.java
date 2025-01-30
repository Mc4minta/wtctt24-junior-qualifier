package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.a;

/* loaded from: classes2.dex */
public abstract class NativeImageLoaderSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, a {
    public NativeImageLoaderSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void getSize(String str, Promise promise);

    @ReactMethod
    public abstract void getSizeWithHeaders(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void prefetchImage(String str, Promise promise);

    @ReactMethod
    public abstract void queryCache(ReadableArray readableArray, Promise promise);
}
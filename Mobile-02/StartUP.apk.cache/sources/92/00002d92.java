package com.facebook.react.bridge;

import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
public interface NativeModule {

    /* loaded from: classes2.dex */
    public interface NativeMethod {
        String getType();

        void invoke(JSInstance jSInstance, ReadableArray readableArray);
    }

    boolean canOverrideExistingModule();

    String getName();

    void initialize();

    void onCatalystInstanceDestroy();
}
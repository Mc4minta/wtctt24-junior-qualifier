package com.facebook.react.bridge;

import android.view.View;

/* loaded from: classes2.dex */
public interface UIManager extends JSIModule, PerformanceCounter {
    <T extends View> int addRootView(T t, WritableMap writableMap, String str);

    void dispatchCommand(int i2, int i3, ReadableArray readableArray);

    void dispatchCommand(int i2, String str, ReadableArray readableArray);

    <T> T getEventDispatcher();

    void sendAccessibilityEvent(int i2, int i3);

    void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap);

    void updateRootLayoutSpecs(int i2, int i3, int i4);
}
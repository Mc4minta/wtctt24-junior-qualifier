package com.facebook.react.modules.core;

import com.facebook.react.bridge.WritableArray;

/* compiled from: JavaScriptTimerManager.java */
/* loaded from: classes2.dex */
public interface c {
    void callIdleCallbacks(double d2);

    void callTimers(WritableArray writableArray);

    void emitTimeDriftWarning(String str);
}
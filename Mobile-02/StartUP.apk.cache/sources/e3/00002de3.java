package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;

/* loaded from: classes2.dex */
public interface HMRClient extends JavaScriptModule {
    void disable();

    void enable();

    void setup(String str, String str2, String str3, int i2, boolean z);
}
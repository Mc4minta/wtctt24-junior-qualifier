package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ReactTextInputBlurEvent.java */
/* loaded from: classes2.dex */
class f extends com.facebook.react.uimanager.events.c<f> {
    public f(int i2) {
        super(i2);
    }

    private WritableMap m() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("target", i());
        return createMap;
    }

    @Override // com.facebook.react.uimanager.events.c
    public boolean a() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), m());
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topBlur";
    }
}
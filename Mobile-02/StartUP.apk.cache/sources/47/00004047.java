package com.swmansion.rnscreens;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: ScreenWillDisappearEvent.java */
/* loaded from: classes2.dex */
public class m extends com.facebook.react.uimanager.events.c<c> {
    public m(int i2) {
        super(i2);
    }

    @Override // com.facebook.react.uimanager.events.c
    public void c(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(i(), f(), Arguments.createMap());
    }

    @Override // com.facebook.react.uimanager.events.c
    public short e() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.c
    public String f() {
        return "topWillDisappear";
    }
}
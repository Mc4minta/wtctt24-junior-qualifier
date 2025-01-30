package com.swmansion.rnscreens;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: StackFinishTransitioningEvent.java */
/* loaded from: classes2.dex */
public class n extends com.facebook.react.uimanager.events.c<c> {
    public n(int i2) {
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
        return "topFinishTransitioning";
    }
}